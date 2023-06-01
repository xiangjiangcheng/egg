# egg
copy/base on pig... spring cloud + java 17


## 
JDK 17

## 配置本地host



## nacos


http://pig-register:8848/


## 搭建步骤
1.. 搭建基本Maven框架
```lua
-- egg
    -- egg-common 系统公共模块
        -- egg-common-bom  通用依赖管理，无其他作用
        -- egg-common-core 核心库
    -- egg-register 服务注册/配置中心
    -- egg-gateway  网关服务
    -- egg-auth  认证服务
    -- ...

```
2..引入Nacos

服务注册中心

3.. 引入网关gateway

4.. 引入spring security oauth2

统一授权


## 查阅资料
https://www.jianshu.com/p/c4952ef14660

```lua
1.Spring Authorization Server
官方主页：https://spring.io/projects/spring-authorization-server
https://blog.csdn.net/qq_31772441/article/details/126092213

```