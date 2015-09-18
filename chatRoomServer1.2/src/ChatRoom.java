import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
/*
 * 
 * **/

public class ChatRoom  {
	private ArrayList<User> userlist;
	public ChatRoom(){
		userlist=new  ArrayList<User>();
//		this.user1=user1;
//		this.user2=user2;	
//		try {
//			new MsgReceiver(user1.getInputStream(),user2.getOutputStream()).start();
//			new MsgReceiver(user2.getInputStream(),user1.getOutputStream()).start();
//		} catch (IOException e) {
//			e.printStackTrace();
//		} 
	}
	
	public void  join(Socket socket) throws IOException{
		User user=new User();
		user.setSocket(socket);
		user.setOutput(socket.getOutputStream());
		userlist.add(user);
		new MsgReceiver(user, userlist).start();
		for (User everyone : userlist) {
			PrintWriter writer = new PrintWriter(
					new OutputStreamWriter(everyone.getOutput()));
			writer.write("一位使用者加入聊天!\n");
			writer.flush();
			System.out.println("一位使用者加入聊天!\n");
		}
	}
	public ArrayList<User> getUserlist() {
		return userlist;
	}
	public void setUserlist(ArrayList<User> userlist) {
		this.userlist = userlist;
	}
	

}
