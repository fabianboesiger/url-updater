import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		File urls = new File("urls.txt");
		
        Scanner scanner = new Scanner(urls);
     
        while(scanner.hasNext()) {
            String url = scanner.next();
            int updatesPerDay = scanner.nextInt();
            new Job(url, updatesPerDay).start();
            System.out.println("Started job for " + url + " with " + updatesPerDay + " updates per day");
        } 
        
        scanner.close();

	}

}
