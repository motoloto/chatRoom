import java.io.InputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

public class TcpClient {
	private static Integer port = 20;
	private static String address = "127.0.0.1";

	public static void main(String[] args) throws Exception {
		System.out.println("server IP :" + address);
		System.out.println("port      :" + port);
		System.out.println("start connecting...");
		Socket clientSocket = new Socket();
		clientSocket.setSoTimeout(30);// 30秒逾時
		try {
			clientSocket.connect(new InetSocketAddress(address, port));
			InputStream in = clientSocket.getInputStream();
			StringBuffer msgBuf = new StringBuffer();
			try {
				while (true) { // 不斷讀取。
					int x = in.read(); // 讀取一個 byte。(read 傳回 -1 代表串流結束)
					if (x == -1)
						break; // x = -1 代表串流結束，讀取完畢，用 break 跳開。
					byte b = (byte) x; // 將 x 轉為 byte，放入變數 b.
					msgBuf.append((char) b);// 假設傳送ASCII字元都是 ASCII。
				}
				System.out.println(msgBuf); // 印出接收到的訊息。
			} catch (Exception e) {
				in.close(); // 關閉輸入串流。
			}
		} catch (java.io.IOException e) {
			System.out.println("Socket連線有問題 !");
			System.out.println("IOException :" + e.toString());
			clientSocket.close(); // 關閉 TcpSocket.
		}
	}
}
