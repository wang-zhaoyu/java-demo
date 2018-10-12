## 1.安装zookepper ,安装mysql
    2.配置文件默认读取test环境的配置（DefaultProfileListener设置的）
    3.如果线上不是可以通过设置启动profile为product加载正式环境的配置
    4.appcontext-arch.xml文件定义了test和product的profile,可以控制加载的配置文件
    5.MyPropertyPlaceholder可以吧配置文件内容加载到内存中，可以通过静态方法读取配置文件内容
    6.可以通过分布式的配置平台代替当前的环境区分方案，比如disconf