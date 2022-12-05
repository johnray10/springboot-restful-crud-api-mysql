package softengineerjay.springbootrestfulcrudapimysql;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.TimeZone;

@SpringBootApplication
public class SpringbootRestfulCrudApiMysqlApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootRestfulCrudApiMysqlApplication.class, args);
	}

	@PostConstruct
	public void init(){
		// Setting Spring Boot SetTimeZone
		TimeZone.setDefault(TimeZone.getTimeZone("GMT+8:00"));
	}
}
