import java.net.*;
import java.io.*;
 
// 1. ���{�������P TcpClient.java �{���f�t����A�����楻�{���A���� UdpClient�C
// 2. �����k : java TcpServer
 
public class TcpServer {
    public static int port = 20; // �s����
 
    public static void main(String args[]) throws Exception {
        ServerSocket ss = new ServerSocket(port);     // �إ� TCP ���A���C
        System.out.println("Server Start up !");
        System.out.println("connect port :"+port);
        while (true) {                                // ���_�������B�z��J�T���C
            Socket sc = ss.accept();                // ������J�T���C
            OutputStream os = sc.getOutputStream();    // ���o��X��y�C
            os.write("From Server : Hi !".getBytes("UTF-8"));// �e�T���� Client �ݡC
            os.close();                                // ������X��y�C
            sc.close();                                // ���� TCP ���A���C
        }
    }
}