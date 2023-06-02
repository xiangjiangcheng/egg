# egg
copy/base on pig... spring cloud + java 17


### 核心依赖

| 依赖                   | 版本             |
| ---------------------- |----------------|
| Spring Boot            | 3.1.0          |
| Spring Cloud           | 2022.0.3       |
| Spring Cloud Alibaba   | 2022.0.0.0-RC2 |
| Spring Authorization Server | 1.1.0          |
| Mybatis Plus           | 3.5.3.1        |
| hutool                 | 5.8.18         |

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

```
服务注册中心
```

3.. 引入网关gateway

4.. 引入spring security oauth2

```
统一授权
```


## 查阅资料
https://www.jianshu.com/p/c4952ef14660

```lua
1.Spring Authorization Server
官方主页：https://spring.io/projects/spring-authorization-server
demo: https://blog.csdn.net/qq_31772441/article/details/126092213

```

## issue
point:
```lua
1. 自定义starter,自动配置 -
2. @EnableFeignClients 指定最大的扫描路径, 否则会找不到实现类
```

## API
```shell
1. obtain token: pig-gateway:9999/auth/oauth2/token?grant_type=password&scope=server&username=admin&password=YehdBPev

```