#!/bin/bash
# 在项目根目录运行：sh create-zip.sh
ZIPNAME=student-microservices.zip
DIRNAME=student-microservices
mkdir -p $DIRNAME
# 将需要复制的文件/目录到 $DIRNAME（示例：只演示，实际请把所有文件放好）
cp -r README.md assignment.md docker-compose.yml eureka-server gateway user-service order-service $DIRNAME
zip -r $ZIPNAME $DIRNAME
echo "Created $ZIPNAME"
