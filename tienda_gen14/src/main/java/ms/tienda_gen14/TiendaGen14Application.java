package ms.tienda_gen14;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class TiendaGen14Application {

	public static void main(String[] args) {
		SpringApplication.run(TiendaGen14Application.class, args);
	}

}
