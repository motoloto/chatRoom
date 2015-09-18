import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
/*----Client 1.2版------
 * 建立標準的多人對話
 * 無法自動重新連線
 * 未有斷線的處理
 * */
public class TcpClient {
	private static Integer port = 20;
	private static String address = "127.0.0.1";

	public static void main(String[] args) throws Exception {
		Socket clientSocket = new Socket();
		try {
			port=Integer.valueOf(args[1]);
			address=args[0];
			System.out.println("server IP :" + address);
			System.out.println("port      :" + port);
			System.out.println("Server connected !");
			System.out.println("========================================");
			clientSocket.connect(new InetSocketAddress(address,port));
//			new MsgReceiver(System.in,clientSocket.getOutputStream()).start();
			new MsgReceiver( clientSocket.getInputStream(),System.out).start();
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			PrintWriter writer = new PrintWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
			String userName=args[2];
			try {
				while (true) { // 不斷讀取。
					String msg = reader.readLine(); // 讀取一個 byte。(read 傳回 -1 代表串流結束)
					writer.write(userName+"說:"+msg+"\n");
					writer.flush();
//					System.out.println(userName+"說:"+msg); // 印出接收到的訊息。
//					System.out.println(">>"+msg); // 印出接收到的訊息。
				}
			} catch (Exception e) {
				System.out.println("IOException :" + e.toString());
//				in.close(); // 關閉輸入串流。
			}
		} catch (java.io.IOException e) {
			System.out.println("Socket連線有問題 !");
			System.out.println("IOException :" + e.toString());
			clientSocket.close(); // 關閉 TcpSocket.
		}catch (Exception e) {
			System.out.println("不明問題 !");
			System.out.println("Exception :" + e.toString());
			clientSocket.close(); // 關閉 TcpSocket.
		}
	}
}
