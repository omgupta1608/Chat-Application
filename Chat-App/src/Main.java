
public class Main {

	public static void main(String[] args) {
		SocketServer server = new SocketServer(8500);
		
		new Thread(server).start();
		
		try {
			Thread.sleep(5000);
		}catch(Exception e) {
			
		}
		
		server.stop();

	}

}
