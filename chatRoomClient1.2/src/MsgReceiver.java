import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class MsgReceiver extends Thread {
	private InputStream in;
	private OutputStream out;

	public MsgReceiver(InputStream in, OutputStream out) {
		this.in = in;
		this.out = out;
	}

	@Override
	public void run() {
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));
		PrintWriter writer = new PrintWriter(new OutputStreamWriter(out));
		while (true) {
			String ss;
			try {
				ss = reader.readLine();
//				System.out.println("say :" + ss);
				writer.write(ss + "\n");
				writer.flush();
			} catch (IOException e) {
				try {
					in.close();
					out.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				e.printStackTrace();
				break;
			}catch (Exception e) {
				try {
					in.close();
					out.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				e.printStackTrace();
				break;
			}

		}

	}

}
