package test;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.Socket;
import java.net.UnknownHostException;

import org.apache.log4j.Logger;
public class SocketClient
{
  private static final Logger logger = Logger.getLogger(SocketClient.class);
  
  public void client(){
    Socket client =null;
    BufferedReader is =null;
    Writer writer =null;
    try
    {
      client  = new Socket("192.168.2.230",4070);
      writer =new OutputStreamWriter(client.getOutputStream());
      writer.write("Hello Server----------------.");
      writer.write("eof\n");
      writer.flush();
      is = new BufferedReader(new InputStreamReader(client.getInputStream()));
      StringBuffer sb = new StringBuffer();
      String temp;
      int index;
      while ((temp = is.readLine()) != null) {
          if ((index = temp.indexOf("eof")) != -1) {
              sb.append(temp.substring(0, index));
              break;
    }
          sb.append(temp);
      }
      System.out.println(sb.toString());
    } catch (UnknownHostException e) {
      e.printStackTrace();
  } catch (IOException e) {
      e.printStackTrace();
  } finally {
      try {
          if (is != null) {
              is.close();
          }
          if (writer != null) {
              writer.close();
          }
          if (client != null) {
              client.close();
          }
      } catch (IOException e) {
          logger.error("Close the IO session error: ", e);
      }
  }

}

public static void main(String[] args) {
  SocketClient sc = new SocketClient();
  sc.client();
}

}
