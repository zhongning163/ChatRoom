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
			// 2���������ݰ�
			byte[] buf=new byte[1024];
			
			DatagramPacket dp=new DatagramPacket(buf,buf.length);
			//3.ʹ��Socket�����receive���������յ����ݴ浽���ݰ���
			ds.receive(dp);
			//4.ͨ�����ݰ��ķ����������ݰ��е����ݣ������ַ���˿ڣ���������
			String ip=dp.getAddress().getHostAddress();
			int port=dp.getPort();
			String text=new String(dp.getData(),0,dp.getLength());
			
			System.out.println(ip+":"+port+""+text);
			if(text.equals("�ټ�"))
			{
				System.out.println(ip+":...�˳���������");
			}
			}
		}
		catch(Exception e){
			
		}
	}

}
