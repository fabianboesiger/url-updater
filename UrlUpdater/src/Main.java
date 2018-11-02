import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Main {
	
	public static void main(String[] args) {
		
		final String URL = args[0];
		final int UPDATES_PER_DAY = Integer.parseInt(args[1]);
		
		while(true){

			try{
				URL url = new URL(URL);
				HttpURLConnection connection = (HttpURLConnection) url.openConnection();
				connection.setRequestMethod("GET");
				connection.setRequestProperty("User-Agent", "Mozilla/5.0");
				System.out.println("Accessed "+URL+" with response code "+connection.getResponseCode());
			}catch(MalformedURLException e){
				e.printStackTrace();
			}catch(IOException e){
				e.printStackTrace();
			}
			
			try{
				Thread.sleep(1000*60*60*24/UPDATES_PER_DAY);
			}catch(InterruptedException e){
				e.printStackTrace();
			}
			
		}

	}

}