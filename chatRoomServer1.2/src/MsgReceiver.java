import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
/*
 * 更改為多人對話
 * 訊息傳遞改為群播
 **/
import java.util.ArrayList;

public class MsgReceiver extends Thread {
	private InputStream in;
	private ArrayList<User> userlist;
	private User user;

	public MsgReceiver(User user, ArrayList<User> userlist) throws IOException {
		this.user = user;
		this.userlist = userlist;
		in = user.getSocket().getInputStream();
	}

	@Override
	public void run() {
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));
		// PrintWriter writer = new PrintWriter(new OutputStreamWriter(out));
		while (true) {
			String ss;
			try {
				ss = reader.readLine();
				System.out.println("get:" + ss);
				System.out.println("send:" + ss);
				// 對聊天室所有人發送訊息
				for (User user : userlist) {
					PrintWriter writer = new PrintWriter(
							new OutputStreamWriter(user.getOutput()));
					writer.write(ss + "\n");
					writer.flush();
				}
			} catch (IOException e) {
				try {
					in.close();
					user.getSocket().close();

				} catch (IOException e1) {
					e1.printStackTrace();

				}
				e.printStackTrace();
				break;
			} catch (Exception e) {
				try {
					in.close();
					user.getSocket().close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				e.printStackTrace();
				break;
			}

		}

	}

}
