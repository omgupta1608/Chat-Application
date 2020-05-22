import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class WorkerThread1 implements Runnable{
	public Socket clientsocket = null;
	public String sockettext = null;
	
	public WorkerThread1(Socket socket, String txt) {
		this.clientsocket = socket;
		this.sockettext = txt;
	}
	@Override
	public void run() {
		try {
            //InputStream input  = clientsocket.getInputStream();
            OutputStream output = clientsocket.getOutputStream();
            long time = System.currentTimeMillis();
            output.write(("HTTP/1.1 200 OK\n\n**Connected** " +
            			this.sockettext + " - " +
            			time +
            			"").getBytes());
            output.close();
            //input.close();
            System.out.println("Request processed: " + time);
        } catch (IOException e) {
            //report exception somewhere.
            e.printStackTrace();
        }
		
	}

}
