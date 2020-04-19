package nia.chapter1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by kerr.
 *
 * Listing 1.1 Blocking I/O example
 */
public class BlockingIoExample {

    /**
     * Listing 1.1 Blocking I/O example
     *
     * */
    public void serve(int portNumber) throws IOException {
        // 创建一个新的ServerSocket，用于监听指定端口上的请求连接
        ServerSocket serverSocket = new ServerSocket(portNumber);
        // accept()将被阻塞，直到一个连接建立，将返回一个新的Socket用于客户端与服务器之间的通信。
        // 同时ServerSocket继续监听传入的连接。
        Socket clientSocket = serverSocket.accept();
        BufferedReader in = new BufferedReader(
                new InputStreamReader(clientSocket.getInputStream()));
        PrintWriter out =
                new PrintWriter(clientSocket.getOutputStream(), true);
        String request, response;
        // 开始循环处理
        while ((request = in.readLine()) != null) {
            if ("Done".equals(request)) {
                // 直至客户端发送Done停止循环
                break;
            }
            response = processRequest(request);
            out.println(response);
        }
    }

    private String processRequest(String request){
        return "Processed";
    }
}
