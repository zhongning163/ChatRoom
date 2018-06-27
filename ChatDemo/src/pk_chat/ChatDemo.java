package pk_chat;

import java.net.DatagramSocket;
import java.net.SocketException;

public class ChatDemo {
	public static void main(String[] args) throws SocketException
	{
		DatagramSocket send=new DatagramSocket();
		
		DatagramSocket rece=new DatagramSocket(50021);
		
		Send s=new Send(send);
		Rece r=new Rece(rece);
		
		new Thread(s).start();
		new Thread(r).start();
	}
}
