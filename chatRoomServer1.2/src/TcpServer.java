import java.net.*;
import java.io.*;
/*----Server 1.2��------
 * �إߤ@�ӼзǪ��h�H��ѫ�
 * �L�k�۰ʭ��s�s�u
 * �����_�u���B�z
 * */
public class TcpServer {
	public static int port = 20; // �s����
	public static ChatRoom chatroom;
	public static void main(String args[]) throws Exception {
		ServerSocket ss = new ServerSocket(port); // �إ� TCP ���A���C
		System.out.println("Server Start up !");
		System.out.println("connect port :" + port);
		chatroom=new ChatRoom();
		while (true) { // ���_�������B�z��J�T���C
			Socket con1 = ss.accept();
			chatroom.join(con1);
			System.out.println("User1 connected !");
//			Socket con2 = ss.accept();
//			System.out.println("User2 connected !");
//			new ChatRoom(con1, con2);
//			System.out.println("open chat !");
		}
	}
}