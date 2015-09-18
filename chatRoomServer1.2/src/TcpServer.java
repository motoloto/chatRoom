import java.net.*;
import java.io.*;
/*----Server 1.2版------
 * 建立一個標準的多人聊天室
 * 無法自動重新連線
 * 未有斷線的處理
 * */
public class TcpServer {
	public static int port = 20; // 連接埠
	public static ChatRoom chatroom;
	public static void main(String args[]) throws Exception {
		ServerSocket ss = new ServerSocket(port); // 建立 TCP 伺服器。
		System.out.println("Server Start up !");
		System.out.println("connect port :" + port);
		chatroom=new ChatRoom();
		while (true) { // 不斷的接收處理輸入訊息。
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