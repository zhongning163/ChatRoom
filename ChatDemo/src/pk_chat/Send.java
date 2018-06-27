package pk_chat;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Send implements Runnable {
	private DatagramSocket ds;
	public Send(DatagramSocket ds)
	{
		this.ds=ds;
	}
	@Override

	public void run() {
		// TODO Auto-generated method stub
		try {
			BufferedReader bufr=new BufferedReader(new InputStreamReader(System.in));
			String line=null;
			
			while((line=bufr.readLine())!=null)
			{
				
				byte[] buf=line.getBytes();
				DatagramPacket dp=new DatagramPacket(buf,buf.length,InetAddress.getByName("192.168.199.206"),50021);
				//3.通过UDP的socket服务将数据包发送出去，使用send方法
				ds.send(dp);
				if("再见".equals(line))
					break;
			}
			ds.close();
		}
		catch(Exception e)
		{}
	}

}
