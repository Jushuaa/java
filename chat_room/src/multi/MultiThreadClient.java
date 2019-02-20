package multi;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;
class ReadFromServer implements  Runnable{
    private Socket client;
    public ReadFromServer(Socket client) {
        this.client = client;
    }
    @Override
    public void run() {
        //获取输入流来取得服务器发来的信息
        try{
            Scanner in=new Scanner(client.getInputStream());
            while (true) {
                if(client.isClosed()){
                    System.out.println("客户端已关闭");
                    in.close();
                }
                if(in.hasNext()){
                    String msgFromServer=in.nextLine();
                    System.out.println("服务端发来的信息为"+msgFromServer);
                }
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}

/**
 * 向服务器端发送信息线程
 */
class SendMsgToServer implements Runnable{
    private Socket client;
    public SendMsgToServer(Socket client) {
        this.client = client;
    }
    @Override
    public void run(){

        try{
            //获取输出向服务器发送的信息
            PrintStream printStream=new PrintStream(client.getOutputStream(),true,"UTF-8");
            //获取用户输入
            Scanner in=new Scanner(System.in);
            while(true){
                System.out.println("请输入要向服务器发送的信息：");
                String strFromUser="";
                if(in.hasNext()){
                    strFromUser=in.nextLine();
                }
                //向服务器发送信息
                System.out.println(strFromUser);
                //判断退出，字符串含有“byebye”
                if(strFromUser.contains("byebye")){
                    System.out.println("客户退出聊天室");
                    printStream.close();
                    in.close();
                    client.close();
                    break;
                }
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
public class MultiThreadClient {
    public static void main(String[] args) throws Exception{
        //根据指定的ip和端口号建立连接
        Socket client=new Socket("127.0.0.1",6666);
        //启动读线程与写线程
        Thread ReadThread=new Thread(new ReadFromServer(client));
        Thread WriteThread=new Thread(new SendMsgToServer(client));
        ReadThread.start();
        WriteThread.start();
    }
}
