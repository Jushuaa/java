package Single;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class SingleThreadClient {
    public static void main(String[] args) throws Exception {
        //建立连接
        Socket socket=new Socket("127.0.0.1",6666);
        Scanner scanner=new Scanner(socket.getInputStream());
        if(scanner.hasNext()){
            System.out.println("服务器端发来的信息为"+scanner.nextLine());
        }
        PrintStream printStream=new PrintStream(socket.getOutputStream(),true,"UTF-8");
        printStream.println("hello i am client");
        //关闭流
        scanner.close();
        printStream.close();
        socket.close();
    }
}
