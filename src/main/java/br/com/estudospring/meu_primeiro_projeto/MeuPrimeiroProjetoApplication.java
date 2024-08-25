package br.com.estudospring.meu_primeiro_projeto;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;


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

	@GetMapping("/greet")	
	public Map<String, String> greet(@RequestParam(value =  "name", defaultValue = "Guest") String name) {
		Map<String, String> response = new HashMap<>();
		response.put("message","Greetings " + name + "!");
		response.put("timestamp", new Date().toString());
		return response;
	} 

	@GetMapping("/divide")
	//Indica que os parâmetros são obrigatórios
	public double divide(@RequestParam int a, @RequestParam int b){
		if( b == 0){
			throw new IllegalArgumentException("Cannot divide by zero");
		}
		return (double) a / b;
	}

	//Essa anotação indica que este método deve ser chamado se ouver uma IllegalArgumentException
	@ExceptionHandler(IllegalArgumentException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)//Define o status da resposta Http
	public Map<String, String > handleIllegalArgumentException(IllegalArgumentException ex){
		Map<String,String> error = new HashMap<>();
		error.put("error",ex.getMessage());
		return error;
	}
}
