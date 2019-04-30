import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

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
