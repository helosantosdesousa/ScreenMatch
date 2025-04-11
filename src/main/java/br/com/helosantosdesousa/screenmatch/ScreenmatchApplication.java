package br.com.helosantosdesousa.screenmatch;

import br.com.helosantosdesousa.screenmatch.util.ConsumoAPI;
import br.com.helosantosdesousa.screenmatch.view.Application;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ScreenmatchApplication implements CommandLineRunner {

	public static void main(String[] args) throws JsonProcessingException {
		SpringApplication.run(ScreenmatchApplication.class, args);
		Application app = new Application();
		app.exibeMenu();
	}

	//como se fosse o metodo main
	@Override
	public void run(String... args) throws Exception {
		ConsumoAPI consumoAPI = new ConsumoAPI();

		String json = consumoAPI.obterDados("https://www.omdbapi.com/?t=gilmore+girls&apikey=6585022c");

	}
}
