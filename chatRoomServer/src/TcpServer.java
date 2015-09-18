import java.net.*;
import java.io.*;
/*----1.1��------
 * �إ߼зǪ��@��@���
 * �L�k�۰ʭ��s�s�u
 * �����_�u���B�z
 * */
public class TcpServer {
	public static int port = 20; // �s����

	public static void main(String args[]) throws Exception {
		ServerSocket ss = new ServerSocket(port); // �إ� TCP ���A���C
		System.out.println("Server Start up !");
		System.out.println("connect port :" + port);

		while (true) { // ���_�������B�z��J�T���C
			Socket con1 = ss.accept();
			System.out.println("User1 connected !");
			Socket con2 = ss.accept();
			System.out.println("User2 connected !");
			new ChatRoom(con1, con2);
			System.out.println("open chat !");
		}
	}
}