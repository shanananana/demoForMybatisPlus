一些小工具
Springboot+swagger集成一些小工具，项目中可能用得到
目前集成
springBoot
swagger2
mybatisPlus

项目可直接启动 
swagger地址 http://localhost:8080/swagger-ui.html

功能
封装通用响应
md5工具

后续会增加异常，缓存工具类等通用小功能，并考虑拆分工具单独出来使用

看的时候可以直接看commit历史，对应注释看diff 基本上就是集成该功能的全部代码了


2020/3/31

新增自定义异常 异常处理相关

新增日志功能 打印接口入参以及出参（aop）

2020/4/3

新增MybatisPlus AR模式 进一步简化开发代码

2020/4/4

新增redis工具类 可直接存储对象，并且对象无需序列化
