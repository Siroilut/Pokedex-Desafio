package br.com.Pokedex.Pokedex;

import br.com.Pokedex.Pokedex.Principal.Principal;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PokedexApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(PokedexApplication.class, args);
}
	@Override
	public void run(String... args) throws Exception {
		Principal principal = new Principal();
		principal.exibeMenu();
	}
}