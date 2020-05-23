import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.io.IOException;
import java.io.OutputStream;

public class SocketServer implements Runnable{

    protected int          serverPort;
    protected ServerSocket serverSocket = null;
    protected boolean      isStopped    = false;
    protected Thread       runningThread= null;
    protected int clients_count = 0;
    public String user1, user2;
    private Scanner scanner;
    
    
    public SocketServer(int port){
        this.serverPort = port;
        
    }

    public void run(){
        synchronized(this){
            this.runningThread = Thread.currentThread();
        }
        scanner = new Scanner(System.in);
        openServerSocket();
        
        Socket clientSocket1 = null;
        Socket clientSocket2 = null;
        
        try {
        	OutputStream output1 = clientSocket1.getOutputStream();
            OutputStream output2 = clientSocket2.getOutputStream();
            
        	clientSocket1 = this.serverSocket.accept();
        	//System.out.println("Enter your name:");
        	output1.write(("Enter Your Name :").getBytes());
        	user1 = scanner.next();
        	new Thread(
                    new WorkerThread1(
                        clientSocket1,user1)
                ).start();
        	clientSocket2 = this.serverSocket.accept();
        	System.out.println("Enter your name:");
        	user2 = scanner.next();
        	new Thread(
                    new WorkerThread2(
                        clientSocket2, user2)
                ).start();
            
        }catch(Exception e) {
        	
        }
        
        
        /*while(! isStopped()){
            Socket clientSocket1 = null;
            Socket clientSocket2 = null;
            try {
            	clientSocket1 = this.serverSocket.accept();
            	clientSocket2 = this.serverSocket.accept();
            } catch (IOException e) {
                if(isStopped()) {
                    System.out.println("Server Stopped.") ;
                    return;
                }
                throw new RuntimeException(
                    "Error accepting client connection", e);
            }
            new Thread(
                new WorkerThread(
                    clientSocket, "Multithreaded Server")
            ).start();
        }*/
        System.out.println("Server Stopped.") ;
    }


    private synchronized boolean isStopped() {
        return this.isStopped;
    }

    public synchronized void stop(){
        this.isStopped = true;
        try {
            this.serverSocket.close();
        } catch (IOException e) {
            throw new RuntimeException("Error closing server", e);
        }
    }

    private void openServerSocket() {
        try {
            this.serverSocket = new ServerSocket(this.serverPort);
        } catch (IOException e) {
            throw new RuntimeException("Cannot open port 8080", e);
        }
    }
    
    public static void main(String[] args) {
		SocketServer server = new SocketServer(4444);
		
		new Thread(server).start();
		
		try {
			Thread.sleep(50000);
		}catch(Exception e) {
			
		}
		
		server.stop();

	}

}