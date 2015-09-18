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
		clientSocket.setSoTimeout(30);// 30��O��
		try {
			clientSocket.connect(new InetSocketAddress(address, port));
			InputStream in = clientSocket.getInputStream();
			StringBuffer msgBuf = new StringBuffer();
			try {
				while (true) { // ���_Ū���C
					int x = in.read(); // Ū���@�� byte�C(read �Ǧ^ -1 �N���y����)
					if (x == -1)
						break; // x = -1 �N���y�����AŪ�������A�� break ���}�C
					byte b = (byte) x; // �N x �ର byte�A��J�ܼ� b.
					msgBuf.append((char) b);// ���]�ǰeASCII�r�����O ASCII�C
				}
				System.out.println(msgBuf); // �L�X�����쪺�T���C
			} catch (Exception e) {
				in.close(); // ������J��y�C
			}
		} catch (java.io.IOException e) {
			System.out.println("Socket�s�u�����D !");
			System.out.println("IOException :" + e.toString());
			clientSocket.close(); // ���� TcpSocket.
		}
	}
}
