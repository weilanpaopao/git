package test;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by liyang on 2017/12/4.
 */
public class Test2 {
    //获取其他页面的数据
    /**
     * POST请求获取数据
     */
    public static void  main(String  args[]){
        String param = "key=b9dfb09a9cdb4399812d60642c21d74e&location=南京";
        String    urls  = "https://free-api.heweather.com/s6/weather/forecast?parameters";

        try {
          //  url = new URL(path);
            URL url        = new URL(urls);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("POST");// 提交模式
            // conn.setConnectTimeout(10000);//连接超时 单位毫秒
            // conn.setReadTimeout(2000);//读取超时 单位毫秒
            // 发送POST请求必须设置如下两行
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setDoInput(true);
            // 获取URLConnection对象对应的输出流
            PrintWriter printWriter = new PrintWriter(httpURLConnection.getOutputStream());
            // 发送请求参数
          //  printWriter.write(post);//post的参数 xx=xx&yy=yy
            printWriter.print(param);
            // flush输出流的缓冲
            printWriter.flush();
            //开始获取数据
            BufferedInputStream bis = new BufferedInputStream(httpURLConnection.getInputStream());
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            int len;
            byte[] arr = new byte[1024];
            while((len=bis.read(arr))!= -1){
                bos.write(arr,0,len);
                bos.flush();
            }
            bos.close();
            System.out.printf(bos.toString("utf-8"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
