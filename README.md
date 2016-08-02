# 简介
----
Java Image Similarity Application

这是一个Java写的网络图片Hash、汉明距离计算程序，可用于相似图判断，基于Spring MVC  

输入：两个图片地址URL  
输出：图片Hash和距离  

容器化部署
----
如果你讨厌搭建各种环境依赖，那么你可以使用docker来部署该应用，仅需执行两个命令即可：
> docker build -t docker-imgsim-java .

运行：
> docker run -d -p 8080:8080 docker-imgsim-java

我在Google Cloud上测试通过：
```bash
  ... 此处省略N行
  Step 30 : CMD catalina.sh run
  ---> Running in 8f0b3adf18fb
  ---> 0944eb2b4d3b
  Removing intermediate container 8f0b3adf18fb
  Successfully built 0944eb2b4d3b
  frank@code-labs:~$ docker images
  REPOSITORY           TAG                 IMAGE ID            CREATED             VIRTUAL SIZE
  docker-imgsim-java   latest              0944eb2b4d3b        13 seconds ago      813.2 MB
  frank@code-labs:~$ docker run -d -p 8080:8080 docker-imgsim-java
  bbafa030781c17218d6b6d3c5ca4cd22fb18e2ae50a1251b8a202eb9083e687d
```

预览
----
![img](img.png)
