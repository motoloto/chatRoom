import java.net.*;
import java.io.*;
/*----1.1版------
 * 建立標準的一對一對話
 * 無法自動重新連線
 * 未有斷線的處理
 * */
public class TcpServer {
	public static int port = 20; // 連接埠

	public static void main(String args[]) throws Exception {
		ServerSocket ss = new ServerSocket(port); // 建立 TCP 伺服器。
		System.out.println("Server Start up !");
		System.out.println("connect port :" + port);

		while (true) { // 不斷的接收處理輸入訊息。
			Socket con1 = ss.accept();
			System.out.println("User1 connected !");
			Socket con2 = ss.accept();
			System.out.println("User2 connected !");
			new ChatRoom(con1, con2);
			System.out.println("open chat !");
		}
	}
}