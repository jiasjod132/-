package com.example.orderservice.entity;
import jakarta.persistence.*;

@Entity
@Table(name = "orders")
public class OrderEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private Long userId;
  private String product;
  private Double amount;

  // getters/setters
  public Long getId(){return id;}
  public void setId(Long id){this.id=id;}
  public Long getUserId(){return userId;}
  public void setUserId(Long userId){this.userId=userId;}
  public String getProduct(){return product;}
  public void setProduct(String product){this.product=product;}
  public Double getAmount(){return amount;}
  public void setAmount(Double amount){this.amount=amount;}
}
