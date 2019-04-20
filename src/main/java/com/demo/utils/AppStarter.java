package com.demo.utils; 

import org.apache.catalina.Host;
import org.apache.catalina.Server;
import org.apache.catalina.connector.Connector;
import org.apache.catalina.core.AprLifecycleListener;
import org.apache.catalina.startup.Tomcat;

import java.io.File;
import java.io.IOException;

public class AppStarter {
	

    //设置主机或ip
    private String hostname="localhost";
    //设置端口,默认的端口，主要看配置属性
    private int port=8080;
    //
    private String webappDir="webapp";
    //设置 连接时的一些参数
    private int maxPostSize=-1;
    private int maxThreads=200;
    private int acceptCount=100;
    private String encodeing="UTF-8";
    private String contextPath="";

    //tomcat引用
    private Tomcat tomcat;


    //获取属性信息
    protected  void loadProperties()throws IOException {
        //根据配置文件修改初始值
        //第二个参数是默认值，当第一个为空时，使用默认值
//        this.hostname= Global.getConfig("server.hostname","localhost");
//        this.port=Integer.parseInt(Global.getConfig("server.port","8080"));
//        this.webappDir= Global.getConfig("server.webappDir","webapp");
//        this.maxPostSize=Integer.parseInt( Global.getConfig("server.maxPostSize","-1"));
//        this.maxThreads= Integer.parseInt(Global.getConfig("server.maxThreads","200"));
//        this.acceptCount= Integer.parseInt(Global.getConfig("server.acceptCount","100"));
//        this.encodeing=Global.getConfig("server.tomcat.uri-encoding","UTF-8");
//        this.contextPath=Global.getConfig("server.servlet.context-path","");
    }

    //启动
    public void start(){
        try{
            //加载配置
            this.loadProperties();
            //tomcat实例
            this.tomcat=new Tomcat();
            this.tomcat.setPort(this.port);
            this.tomcat.setHostname(this.hostname);
            //tomcat存储自身信息，保存在项目目录下
            this.tomcat.setBaseDir(".");

            this.configServer(tomcat.getServer());
            this.tomcat.getEngine();
            this.configHost(this.tomcat.getHost());
            this.configConnector(this.tomcat.getConnector());
            //第一个参数上下文路径contextPath,第二个参数docBase
            String webappPath=System.getProperty("user.dir")+ File.separator+this.webappDir;
            File webapp=new File(webappPath);
            if(!webapp.exists()){
                webapp.mkdirs();
            }
            System.out.println("contextPath:"+contextPath);
            System.out.println("webappPath:"+webappPath);
//            this.tomcat.addWebapp(contextPath, webappPath);

            //这种方式也行
              this.tomcat.getHost().setAppBase(System.getProperty("user.dir")+ File.separator+".");
              this.tomcat.addWebapp("",this.webappDir);
            
            this.tomcat.start();
            this.tomcat.getServer().await();
        }catch(Exception e){
        	System.out.println("异常："+e.getMessage());
        	 e.printStackTrace();
        }
    }

    private void configHost(Host host) {
        //user.dir  用户的当前工作目录
        host.setAppBase(System.getProperty("user.dir"));
    }

    private void configServer(Server server) {
        AprLifecycleListener listener = new AprLifecycleListener();
        server.addLifecycleListener(listener);
    }

    //设置连接属性
    private void configConnector(Connector connector) {
        connector.setURIEncoding(encodeing);
        connector.setMaxPostSize(this.maxPostSize);
        connector.setAttribute("maxThreads", Integer.valueOf(this.maxThreads));
        connector.setAttribute("acceptCount", Integer.valueOf(this.acceptCount));
        connector.setAttribute("disableUploadTimeout", Boolean.valueOf(true));
        connector.setAttribute("enableLookups", Boolean.valueOf(false));
    }

    public static void main(String[] args){
        AppStarter appStarter=new AppStarter();
        appStarter.start();
    }

}
