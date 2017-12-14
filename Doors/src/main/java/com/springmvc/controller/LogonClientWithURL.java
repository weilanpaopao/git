package com.springmvc.controller;
import org.apache.axis.client.Call;
import org.apache.axis.client.Service;
/**
 * Created by liyang on 2017/12/4.
 */
public class LogonClientWithURL {
    public static void main(String args[]) throws Exception {
        try {
            String urlname = "http://192.168.194.23:9080/Logon/services/Logon?wsdl";
            urlname = "http://192.168.194.23:9080/Logon/services/Logon";

            Service s = new Service();
            Call call = (Call) s.createCall();
            call.setTimeout(new Integer(5000));
            call.setOperation("getSecurityToken");
            call.setTargetEndpointAddress(urlname);

            Object[] fn01 = {"john", "john", null, null};
            String val = (String) call.invoke(fn01);
            System.out.println("getSecurityToken(correct):" + val);

            Object[] fn02 = {"john", "john2", null, null};
            String va2 = (String) call.invoke(fn02);
            System.out.println("getSecurityToken(wrong):" + va2);

        } catch (Exception e) {
            //java.io.InterruptedIOException: Read timed out
            System.out.println(e.getMessage());
        }
    }
}