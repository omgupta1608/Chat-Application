import java.net.*;
import java.util.*;
import java.io.*;

public class Client {
	
	private Socket socket = null;
	private Scanner input = null;
	private DataOutputStream output = null;
	
	@SuppressWarnings("deprecation")
	public Client(String address, int port) {
		
		try {
			socket = new Socket(address,port);
			//System.out.println("Connected!");
			
			//input = new Scanner(System.in);
			
			//output = new DataOutputStream(socket.getOutputStream());
			
		}catch(UnknownHostException u) {
			System.out.println(u);
		}
		catch(IOException e) {
			System.out.println(e);
		}
		
		/*
		String line = "";
		System.out.println("Write your messages to the server!");
		
		while(!line.contentEquals("Over")) {
			
			try {
				line = input.next();
				output.writeUTF(line);
			}catch(IOException e) {
				System.out.println(e);
			}
		}
		
		try {
			input.close();
			output.close();
			socket.close();
		}catch(IOException e) {
			System.out.println(e);
		}
		*/
	}
	
public static void main(String[] args) {
	Scanner ssss = new Scanner(System.in);	
	System.out.println("Enter Address and Port");
	
	String a;
	int p;
	a = ssss.next();
	p = ssss.nextInt();
	
	Client cc = new Client(a,p);
	
	}

}
