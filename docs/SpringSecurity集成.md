# 后台权限管理
> 首先在开发中需要使用权限时，先别着急找权限框架，先好好分析下自己需要什么，简单一点的需求完全可以不用框架 自己实现就好了

## 登录
首先：我们需要控制登录后才能访问系统，这是前提；
当然你可能会说我不要他登录来控制是否有页面访问的权限，http协议是无状态的，你不知道他身份信息如何判断。
这里推荐使用页面加密的形式实现就好了，就是他要访问这个页面需要输入密码的方式

登录是前提，登录的方式就有好几种：
- 传统的session登录方式 浏览器维护一个sessionid 后台维护一个sessionid -> 用户信息 的一个map 这种一般适合单体部署不适合集群，
集群需要考虑分布式session的问题。分布式session参考后面
- 分布式session(即token解决方案) 通过第三方来保存这里可以是缓存中间件、mysql等其他。一般用redis缓存配合token解决session不一致的问题
即登录时生成一个token 把token -> 用户信息 存储在redis里面 然后返回前端一个token 前端每次访问都传一个token来判断是否登录
- jwt的生成方案 通过jwt（json web tokens）来加密用户信息生成一个token返回前端，前端拿到这个token 我进行解密token获取用户信息判断是否登录，支持单机和集群，
缺点是token的维护还是有问题的，退出登录后需要删除token 这个token当然可以通过前端来实现删除 但是如果我通过postman等接口工具访问还是能访问到相关信息的，这样的话还是达不到完全删除的效果。
如果要打到完全删除的效果，需要借助第三方 redis或mysql来维护这样和第二点就没什么区别了
- sso单点登录
- oAuth2 登录

本后台管理系统只实现了第三种jwt的登录方式，具体实现类`TokenBasicService` 当然你也可以自定义实现登录方式，可以继承方法`TokenAbstractService`

## 过滤
完成登录后，我们需要实现第二个需求，首先从权限颗粒度出发，有页面、菜单访问操作权限控制，这里不考虑角色这种，这些其实跟权限没有多大点关系，角色管理更注重业务，
如我不需要角色，我只要维护一个白名单就能满足需求了，为什么要专门建一个角色管理的模块来控制

简单来说其实就是过滤，true 和 false。权限就两种你可以访问或者不可以，其他的都是业务相关联了，那么一般基本的过滤有几种：
- 某些接口或静态资源或页面是不需要登录就能访问的，简称匿名访问
- 登录过滤 对你的账号和密码进行验证或鉴权
- 不登录强行访问需要权限的接口


### Spring Security 框架基本使用
## 依赖
```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-security</artifactId>
</dependency>
```

## 配置
参考`SecurityConfig`
这里要注意Spring Security可以配置多个过滤器，本文已实现过滤接口
 - 登录鉴权`LogoutSuccessHandlerImpl` 
 - 退出`LogoutSuccessHandlerImpl`
 - 用户鉴权`UserDetailsServiceImpl` 
 - 鉴权失败`AuthenticationEntryPointImpl`
这里需要注意一点的是，在登录那块需要将用户凭证信息传入Spring Security里面，这里的`TokenUser`是继承了Security UserDetails 并重写了其中某些方法和继承某些属性

## Spring Security工作流程
![image.png](http://upload.i20forever.cn/blog/image_1606025244600.png)

相关过滤器及原理参考：https://blog.csdn.net/u012702547/article/details/89629415


# Spring Security 和 Shiro
## Shiro

Apache Shiro是一个强大且易用的Java安全框架，能够非常清晰的处理身份验证、授权、管理会话以及密码加密。

利用其易于理解的API，可以快速、轻松地获得任何应用程序，从最小的移动应用程序到最大的网络和企业应用程序。

Shiro 主要分为两个部分就是认证和授权，在个人感觉来看就是查询数据库做相应的判断而已，Shiro只是一个框架而已，其中的内容需要自己的去构建，前后是自己的，中间是Shiro帮我们去搭建和配置好的。

## Spring Security

Spring Security是一个能够为基于Spring的企业应用系统提供声明式的安全访问控制解决方案的安全框架。

它提供了一组可以在Spring应用上下文中配置的Bean，充分利用了Spring IoC（控制反转），DI（ 依赖注入）和AOP（面向切面编程）功能，为应用系统提供声明式的安全访问控制功能，减少了为企业系统安全控制编写大量重复代码的工作。

众所周知，想要对对Web资源进行保护，最好的办法莫过于Filter，要想对方法调用进行保护，最好的办法莫过于AOP。所以Spring Security在我们进行用户认证以及授予权限的时候，通过各种各样的拦截器来控制权限的访问，从而实现安全。

它所有的架构也是基于认证和授权这两个核心功能去实现的。


## 选择
一般小型项目或者技术栈不是使用Spring的用shiro就可以了，比较大的公司一般用Spring Security