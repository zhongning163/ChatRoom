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
				//3.ͨ��UDP��socket�������ݰ����ͳ�ȥ��ʹ��send����
				ds.send(dp);
				if("�ټ�".equals(line))
					break;
			}
			ds.close();
		}
		catch(Exception e)
		{}
	}

}
