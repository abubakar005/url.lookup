package stylight.url.lookup;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import stylight.url.lookup.util.LoadData;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {

		System.out.println("Loading URLs mapping ...");
		LoadData.loadParameterizedURLsMap();
		LoadData.loadPrettyURLsMap();
		System.out.println("Data loaded successfully ...");
		SpringApplication.run(Application.class, args);
	}

}
