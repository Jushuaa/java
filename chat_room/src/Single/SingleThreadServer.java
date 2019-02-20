package Single;

import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class SingleThreadServer {
    public static void main(String[] args) throws Exception{
        //建立基站
        ServerSocket server=new ServerSocket(6666);
        //等待客户端链接
        System.out.println("等待客户端连接");
        Socket socket=server.accept();
        //建立连接后进行数据的传输
        PrintStream printStream=new PrintStream(socket.getOutputStream(),true,"UTF-8");
        printStream.println("hello,i am server");
        Scanner scanner=new Scanner(socket.getInputStream());
        if(scanner.hasNext()){
            System.out.println("客户发来的信息为"+scanner.nextLine());
            //关闭流
            scanner.close();
            printStream.close();
            server.close();
        }
    }
}
