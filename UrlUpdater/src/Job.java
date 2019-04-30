import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Base64.Encoder;

public class Job extends Thread {
	
	private String url;
	private HttpURLConnection connection;
	private int updatesPerDay;
	
	public Job (String url, int updatesPerDay) throws IOException {
		
		this.url = url;
		this.updatesPerDay = updatesPerDay;
		
		connection = (HttpURLConnection) new URL(url).openConnection();
		connection.setRequestMethod("GET");
		connection.setRequestProperty("User-Agent", "Mozilla/5.0");
		
		if(url.indexOf("@") >= 0) {
			String authorization = url.substring(url.indexOf("//") + 2, url.indexOf("@"));
			Encoder encoder = java.util.Base64.getEncoder();
			authorization = new String(encoder.encode(authorization.getBytes()));			
			connection.setRequestProperty("Authorization", "Basic " + authorization);
		}
	}
	
	@Override
	public void run() {
		
		while(true) {

			try {
				System.out.println("Accessed " + url + " with response code " + connection.getResponseCode());
			} catch(IOException e) {
				e.printStackTrace();
			}
			
			try {
				Thread.sleep(1000 * 60 * 60 * 24 / updatesPerDay);
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
			
		}
		
	}
	
}
