简单学生微服务模板（Java + Spring Boot）

前提
- Docker & Docker Compose 已安装（推荐 Docker Desktop）
- 或者 Java 17 + Maven 可用（仅用于本地构建镜像/调试）

快速一键启动（推荐）
1. 在项目根目录运行：
   docker-compose up --build

2. 等待服务启动完成（第一次构建会拉依赖/构建镜像）
   - Eureka UI: http://localhost:8761
   - API Gateway: http://localhost:8080
   - 用户服务示例路径：http://localhost:8080/users
   - 订单服务示例路径：http://localhost:8080/orders

测试示例（curl）
- 列出用户：
  curl http://localhost:8080/users

- 创建用户：
  curl -X POST -H "Content-Type: application/json" \
    -d '{"name":"Alice","email":"alice@example.com"}' \
    http://localhost:8080/users

- 创建订单（userId 必须存在）：
  curl -X POST -H "Content-Type: application/json" \
    -d '{"userId":1,"product":"Book","amount":39.9}' \
    http://localhost:8080/orders

作业说明见 assignment.md

常见问题
- 如果容器找不到 DB，请确认 postgres 容器状态并重试（docker-compose logs postgres）。
- 若端口冲突，修改 docker-compose.yml 中对应端口。

如何打包为 ZIP（在本地）
1. 将项目文件保存在一个目录，例如 student-microservices/
2. 运行：
   zip -r student-microservices.zip student-microservices/
