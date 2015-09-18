import java.io.OutputStream;
import java.net.Socket;


public class User {
	private String username;
	private Socket socket;
	private OutputStream output;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Socket getSocket() {
		return socket;
	}
	public void setSocket(Socket socket) {
		this.socket = socket;
	}
	public OutputStream getOutput() {
		return output;
	}
	public void setOutput(OutputStream output) {
		this.output = output;
	}
	
}
