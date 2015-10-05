# 项目说明
这个是一个为了大家能够快速搭建Springboot＋SpringMVC开发环境所准备的框架项目。大家在完成相应的项目课程的时候都可以使用此框架进行训练环境的搭建。

## [前置条件](#pre-requirement)
## [初次使用项目向导](#init-setup)

## <a name="pre-requirement"></a>前置条件
在你正式开始进行本向导的内容之前，请先在你的本地准备以下的工具
* Java的IDE（例如Eclipse，NetBean，IntelliJ等）
* Java IDE的Maven插件（例如M2Eclipse）
* Maven命令行（[Maven官网下载地址](https://maven.apache.org/download.cgi)）

## <a name="init-setup"></a>初次使用项目向导
由于初次使用项目的时候你需要用maven去下载一些本地资源，否则你的Maven IDE插件可能无法正确加载项目（例如Eclipse的M2Eclipse就会有这种问题）。这里列出初始化步骤
1. 首先你可请通过这个地址下载本项目[]()
2. 把zip包解压，并且把它通过IDE的导入功能导入为Maven项目
3. 如果你的Maven插件解释pom文件出错，请使用命令行进行pom的初始化依赖加载。方式如下：
  * 打开命令行
  * 定位到你的pom.xml文件所在目录
  * 执行mvn dependency:resolve 命令下载相关资源
  * 回到IDE关闭项目然后重新打开项目（或者重启IDE），应该就可以开始使用这个项目框架
