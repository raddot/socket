import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class MyServer1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			ServerSocket ss = new ServerSocket(6666);
			Socket s = ss.accept();
			DataInputStream din = new DataInputStream(s.getInputStream());
			DataOutputStream dout = new DataOutputStream(s.getOutputStream());
			BufferedReader br = new BufferedReader(new InputStreamReader(
					System.in));

			String str = "", str2 = "";
			while (!str.equals("stop")) {
				str = din.readUTF();
				System.out.println("client says -> " + str);
				str2 = br.readLine();
				dout.writeUTF(str2);
				dout.flush();
			}
			din.close();
			s.close();
			ss.close();

		} catch (Exception e) {
			System.out.println(e);
		}
	}

}