package main.com.example.consumingwebservice;

import com.example.consumingwebservice.wsdl.ServiceResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class ConsumingWebServiceApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ConsumingWebServiceApplication.class, args);
	}


	@Autowired
	HelloClient helloClient;


	@Override
	public void run(String... args) throws Exception {
		ServiceResponse serviceResponse = helloClient.getHello("genna");

		System.out.println(serviceResponse.getHello());
		System.out.println(serviceResponse.getCurrentTime());
	}


/*	@Bean
	CommandLineRunner lookup(CountryClient quoteClient) {
		return args -> {
			String country = "Spain";

			if (args.length > 0) {
				country = args[0];
			}
			GetCountryResponse response = quoteClient.getCountry(country);
			System.err.println(response.getCountry().getCurrency());
		};
	}*/

}
