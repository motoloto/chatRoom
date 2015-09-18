import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.net.Socket;

public class TcpClient {
	private static Integer port = 20;
	private static String address = "127.0.0.1";

	public static void main(String[] args) throws Exception {
//		clientSocket.setSoTimeout(3000);// 30��O��
		Socket clientSocket = new Socket();
		try {
			port=Integer.valueOf(args[1]);
			address=args[0];
			System.out.println("server IP :" + address);
			System.out.println("port      :" + port);
			System.out.println("Server connected !");
			System.out.println("========================================");
			clientSocket.connect(new InetSocketAddress(address,port));
			new MsgReceiver(System.in,clientSocket.getOutputStream()).start();
			InputStream in = clientSocket.getInputStream();
			BufferedReader reader = new BufferedReader(new InputStreamReader(in));
			try {
				while (true) { // ���_Ū���C
					String msg = reader.readLine(); // Ū���@�� byte�C(read �Ǧ^ -1 �N���y����)
					if( msg==null){
						System.out.println("�t�ΡG���w���u"); // �L�X�����쪺�T���C
						break;
					}
					System.out.println(">>"+msg); // �L�X�����쪺�T���C
				}
			} catch (Exception e) {
				System.out.println("IOException :" + e.toString());
				in.close(); // ������J��y�C
			}
		} catch (java.io.IOException e) {
			System.out.println("Socket�s�u�����D !");
			System.out.println("IOException :" + e.toString());
			clientSocket.close(); // ���� TcpSocket.
		}catch (Exception e) {
			System.out.println("�������D !");
			System.out.println("Exception :" + e.toString());
			clientSocket.close(); // ���� TcpSocket.
		}
	}
}
