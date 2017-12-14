package com.springmvc.listener;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;




/**
 * 用于做初始化工作的监听器
 * @author liyang
 * 2016年12月13日上午10:06:23
 */
public class InitListener implements ServletContextListener {
  @Autowired

  public  static List<String> ConnectedCameraIp =new ArrayList<String>();
  private  static List<String> listIp=new ArrayList<String>(); 
  @Override
  public void contextInitialized(ServletContextEvent sce){
   // SocketClient sc = new SocketClient();
 //   sc.client();
  }
  
  
  @Override
  public void contextDestroyed(ServletContextEvent arg0) {}
  
  
 
 
 

}
