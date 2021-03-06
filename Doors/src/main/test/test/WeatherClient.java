package test;
import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
/**
 * Created by liyang on 2017/12/4.
 */
public class WeatherClient {
    public static void main(String[] args) throws UnknownHostException, IOException{

        //1.创建Socket对象，和服务端建立连接
        Socket socket = new Socket("127.0.0.1",8080);

        //2.发送城市名称
        DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
        dos.writeUTF("南京");
        System.out.println("请求查询天气: 南京");

        //3.接受返回结果使用输入流
        DataInputStream dis = new DataInputStream(socket.getInputStream());
        String result = dis.readUTF();
        System.out.println("南京的天气: " + result);

        //4.关闭流
        dis.close();
        dos.close();
    }
}
