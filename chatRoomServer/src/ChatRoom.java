import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;


public class ChatRoom  {
	private Socket user1;
	private Socket user2;
	
	public ChatRoom(Socket user1,Socket user2){
		this.user1=user1;
		this.user2=user2;	
		try {
			new MsgReceiver(user1.getInputStream(),user2.getOutputStream()).start();
			new MsgReceiver(user2.getInputStream(),user1.getOutputStream()).start();
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}


}
