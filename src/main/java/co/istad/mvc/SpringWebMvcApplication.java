package co.istad.mvc;

import co.istad.mvc.dto.BookResponse;
import co.istad.mvc.dto.CreateBookRequest;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringWebMvcApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringWebMvcApplication.class, args);

		CreateBookRequest bookResponse = new CreateBookRequest(
				"My title", "My description", "My author"
		);

	}

}
