package pk_chat;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Rece implements Runnable {

	private DatagramSocket ds;
	public Rece(DatagramSocket ds)
	{
		this.ds=ds;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			while(true)
			{
			// 2、创建数据包
			byte[] buf=new byte[1024];
			
			DatagramPacket dp=new DatagramPacket(buf,buf.length);
			//3.使用Socket服务的receive方法将接收的数据存到数据包中
			ds.receive(dp);
			//4.通过数据包的方法解析数据包中的数据，比如地址，端口，数据内容
			String ip=dp.getAddress().getHostAddress();
			int port=dp.getPort();
			String text=new String(dp.getData(),0,dp.getLength());
			
			System.out.println(ip+":"+port+""+text);
			if(text.equals("再见"))
			{
				System.out.println(ip+":...退出了聊天室");
			}
			}
		}
		catch(Exception e){
			
		}
	}

}
