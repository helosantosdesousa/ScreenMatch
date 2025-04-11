package br.com.helosantosdesousa.screenmatch;

import br.com.helosantosdesousa.screenmatch.model.DadosSerie;
import br.com.helosantosdesousa.screenmatch.service.ConverteDados;
import br.com.helosantosdesousa.screenmatch.util.ConsumoAPI;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ScreenmatchApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ScreenmatchApplication.class, args);
	}

	//como se fosse o metodo main
	@Override
	public void run(String... args) throws Exception {
		ConsumoAPI consumoAPI = new ConsumoAPI();

		String json = consumoAPI.obterDados("https://www.omdbapi.com/?t=gilmore+girls&apikey=6585022c");
		//System.out.println(json);

		//exemplo api pega imagens cafetreria randomicas
		/*json = consumoAPI.obterDados("https://coffee.alexflipnote.dev/random.json");
		System.out.println(json);*/

		ConverteDados conversor = new ConverteDados();
		DadosSerie serie = conversor.obterDados(json, DadosSerie.class);
		System.out.println(serie);
	}
}
