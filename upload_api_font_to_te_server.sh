
#0.
echo '此脚本是作用在已经和服务器之间做了免密认证的基础上，如未设置，参考：https://www.jianshu.com/p/02625a8ef07c设置后再操作'

#2.
echo 'uplpad font - site - api tomcat 8888'
scp ./com-yt-design-font-site-api/target/com-yt-design-font-site-api-0.0.1-SNAPSHOT.war   root@106.15.90.77:/usr/local/YiTaoDesign/materServer/tomcat-8888-font-api/webapps/YtFontSiteApi.war
