package github.chenlei.springbootscalademo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class SpringBootScalaDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootScalaDemoApplication.class, args);
	}
}
