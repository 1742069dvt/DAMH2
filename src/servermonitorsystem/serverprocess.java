package servermonitorsystem;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class serverprocess {
	public serverprocess()
	{
		
	}
	public String XuatIP() throws UnknownHostException
	{
		String kq="";
		InetAddress addr = InetAddress.getLocalHost();
		
		kq = addr.getHostAddress();
		String hostname = addr.getHostName();
		//System.out.println("IP address of localhost from Java : "+ ipaddr);
		//System.out.println("Name of hostname from Java : "+ hostname);
		return kq;
	}
}
