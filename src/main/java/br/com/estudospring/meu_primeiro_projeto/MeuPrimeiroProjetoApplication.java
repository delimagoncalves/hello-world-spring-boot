package br.com.estudospring.meu_primeiro_projeto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@SpringBootApplication
public class MeuPrimeiroProjetoApplication {

	public static void main(String[] args) {
		SpringApplication.run(MeuPrimeiroProjetoApplication.class, args);
	}

	@GetMapping("/hello")	
	public String helloWord(@RequestParam(value = "name", defaultValue = "World") String name){
		return String.format("Hello, %s !",name);
	}

}
