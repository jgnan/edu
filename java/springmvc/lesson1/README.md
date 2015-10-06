* [SQL脚本](#sql-scripts)

##<a name="sql-scripts"></a>SQL脚本
在完成本课程前，请大家先安装mysql服务器和客户端工具，并且使用有权限的账号登录本地服务器执行以下脚本
```
create database `springmvc`;
use `springmvc`;
create table `users`(
  `id` int(10) not null primary key default 0,
  `name` varchar(50) not null,
  `birthday` date default '0000-00-00',
  `mobile` varchar(20),
  `address` varchar(50),
  `email` varchar(50),
  `password` varchar(255)
) AUTO_INCREMENT=1000 ENGINE=INNODB CHARACTER SET UTF8 COLLATE utf8_unicode_ci;

```
