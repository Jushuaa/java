package multi;

import java.io.IOException;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MultiThreadServer {
    private static Map<String,Socket> clientLists=new ConcurrentHashMap<>();
    //专门用来处理每个客户端的输入输出请求
    private static  class ExecuteClientRequest implements Runnable {
        private Socket client;
        public ExecuteClientRequest(Socket client) {
            this.client = client;
        }
        @Override
        public void run() {
            //获取用户的输入流，读取用户发来的信息
            try {
                Scanner in=new Scanner(client.getInputStream());
                String strFromClient="";
                while(true){
                    if(in.hasNext()){
                        strFromClient=in.nextLine();
                        //windows下消除用户输入在带的\r
                        //\r->""
                        Pattern pattern=Pattern.compile("\r");
                        Matcher matcher=pattern.matcher(strFromClient);
                        strFromClient=matcher.replaceAll("");
                    }
                    //注册流程
                    //userName：Jushua
                    if(strFromClient.startsWith("userName:")){
                        String userName=strFromClient.split("\\:")[1];
                        UserRegister(userName,client);

                    }
                    //群聊流程
                    // // userName:Jushua
                    if(strFromClient.startsWith("G:")){
                        String groupMsg=strFromClient.split("\\:")[1];
                        GroupChat(groupMsg);
                    }
                    //私聊流程
                    // P:1-hello world
                    if(strFromClient.startsWith("P:")){
                        String userName=strFromClient.split("\\:")[1].split("\\-")[0];
                        String privateMsg=strFromClient.split("\\:")[1].split("\\-")[1];
                        privateChat(userName,privateMsg);
                    }
                    //用户退出
                    // 1:byebye
                    if(strFromClient.contains("byebye")){
                        String userName=strFromClient.split("\\:")[0];
                        userOffline(userName);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        private void userOffline(String userName) {
         //删除Map中的用户实体
          clientLists.remove(userName);
            System.out.println("用户"+userName+"已下线!");
            System.out.println("当前聊天室人数为:"+clientLists.size());
        }

        private void privateChat(String userName, String privateMsg) {
            //取出userName对应的Socket
            Socket client=clientLists.get(userName);
            //获取输出流
            try{
                PrintStream out=new PrintStream(client.getOutputStream(),true,"UTF-8");
                out.println("私聊信息为:"+privateMsg);
            }catch(IOException e){
                e.printStackTrace();
            }
        }

        /**
         * 遍历Map向每个客户端输出一遍
         * @param groupMsg
         */
        private void GroupChat(String groupMsg){
            Set<Map.Entry<String,Socket>> clientEntry=clientLists.entrySet();
            Iterator<Map.Entry<String,Socket>> iterator=clientEntry.iterator();
            while(iterator.hasNext()){
                //取出每一个客户端实体
                Map.Entry<String,Socket> client=iterator.next();
                //拿到客户端输出流输出群聊信息
                PrintStream out=null;
                try{
                    out=new PrintStream(client.getValue().getOutputStream(),true,"UTF-8");
                    out.println("群聊信息为"+groupMsg);
                }catch(IOException e){
                    e.printStackTrace();
                }
            }
        }
        private static  void UserRegister(String userName,Socket socket){
            clientLists.put(userName,socket);
            System.out.println("用户"+userName+"上线了");
            System.out.println("当前聊天室人数为："+clientLists.size());
            try{
                PrintStream out=new PrintStream(socket.getOutputStream(),true,"UTF-8");
                out.println("注册成功");
                out.println("当前聊天室人数为"+clientLists.size());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws Exception{
        ServerSocket serverSocket=new ServerSocket(6666);
         ExecutorService executorService=Executors.newFixedThreadPool(20);
        System.out.println("等待客户端连接");
        for(int i=0;i<20;i++){
            Socket client=serverSocket.accept();
            System.out.println("有新客户上线，客户端为"+client.getPort());
            executorService.submit(new ExecuteClientRequest(client));
        }
        //关闭线程池与服务器
        executorService.shutdown();
        serverSocket.close();
    }
}
