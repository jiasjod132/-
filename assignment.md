实训作业：微服务示例项目（提交 ZIP 或 Git 仓库）

目标
- 理解微服务基本组件：注册中心、API Gateway、服务间调用、持久化、容器化部署
- 完成基础功能并做少量扩展

交付物（ZIP 或 Git 仓库）
- 完整项目源代码（所有服务）
- README.md（运行步骤）
- assignment-report.md（包含运行截图或 curl 输出，及你做的扩展）

基础任务（必做）
1) 启动项目并提交运行截图（Eureka UI、Gateway、两个服务的 curl 返回）
2) user-service：实现用户 CRUD（已实现基础版）
3) order-service：实现订单 CRUD，创建订单时检查 userId 是否存在（已实现基础版）
4) 使用 Docker Compose 一键启动（已提供）

加分任务（选做，最多 +40%）
- 为 order-service 增加分页查询接口（/orders?page=..&size=..）
- 使用 Spring Security 实现基础认证（JWT 可加分）
- 为服务添加单元/集成测试（JUnit + Testcontainers）
- 添加 Prometheus / Zipkin / Sleuth 基本监控/链路追踪集成

评分参考（总分 100）
- 基础功能（启动、用户 CRUD、订单 CRUD、验证）：60
- 文档与可重复运行（README、脚本）：10
- 扩展（每项最高 10）：最多 +30
- 代码质量与测试：最多 +10

提交说明
- 把 ZIP 上传到提交系统或把仓库链接贴到作业提交处
- 若使用扩展，请在 assignment-report.md 里说明改动及如何验证
