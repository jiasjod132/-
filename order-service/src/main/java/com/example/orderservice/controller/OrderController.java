package com.example.orderservice.controller;
import com.example.orderservice.entity.OrderEntity;
import com.example.orderservice.repository.OrderRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/orders")
public class OrderController {
  private final OrderRepository repo;
  private final RestTemplate rest;

  public OrderController(OrderRepository repo){
    this.repo = repo;
    this.rest = new RestTemplate();
  }

  @GetMapping
  public List<OrderEntity> list(){ return repo.findAll(); }

  @GetMapping("/{id}")
  public ResponseEntity<OrderEntity> get(@PathVariable Long id){
    return repo.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
  }

  @PostMapping
  public ResponseEntity<?> create(@RequestBody OrderEntity order){
    // 简单校验 user 是否存在：通过 user-service 容器名访问
    String url = "http://user-service:8081/users/" + order.getUserId();
    try {
      ResponseEntity<Map> r = rest.getForEntity(url, Map.class);
      if (!r.getStatusCode().is2xxSuccessful()) {
        return ResponseEntity.badRequest().body("user not found");
      }
    } catch (Exception ex){
      return ResponseEntity.badRequest().body("user not found");
    }
    OrderEntity saved = repo.save(order);
    return ResponseEntity.ok(saved);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> delete(@PathVariable Long id){
    return repo.findById(id).map(existing -> {
      repo.deleteById(id);
      return ResponseEntity.noContent().<Void>build();
    }).orElse(ResponseEntity.notFound().build());
  }
}
