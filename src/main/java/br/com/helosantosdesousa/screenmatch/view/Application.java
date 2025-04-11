package br.com.helosantosdesousa.screenmatch.view;

import br.com.helosantosdesousa.screenmatch.model.DadosEpisodio;
import br.com.helosantosdesousa.screenmatch.model.DadosSerie;
import br.com.helosantosdesousa.screenmatch.model.DadosTemporada;
import br.com.helosantosdesousa.screenmatch.service.ConverteDados;
import br.com.helosantosdesousa.screenmatch.util.ConsumoAPI;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Application {
    Scanner sc = new Scanner(System.in);

    private final String ENDERECO = "https://www.omdbapi.com/?t=";
    private final String API_KEY = "&apikey=6585022c";


    private ConsumoAPI api = new ConsumoAPI();
    private ConverteDados conversor = new ConverteDados();


    public void exibeMenu() throws JsonProcessingException {
        String nomeSerie = null;


        do {
            System.out.println("Digite o nome da série ou 0 para SAIR");
            nomeSerie = sc.nextLine();

            if (!nomeSerie.equals("0")) {
                procuraSerie(api, conversor, nomeSerie);
            }

        } while (!nomeSerie.equals("0"));
    }

    public void procuraSerie(ConsumoAPI api, ConverteDados conversor, String nomeSerie) throws JsonProcessingException {
        var json = api.obterDados(ENDERECO + nomeSerie.replace(" ", "+") + API_KEY);

        DadosSerie serie = conversor.obterDados(json, DadosSerie.class);

        System.out.println(serie);

        List<DadosTemporada> temporadasList = new ArrayList<>();

        for (int i = 1; i <= serie.totalSeasons(); i++) {
            json = api.obterDados(ENDERECO + nomeSerie.replace(" ", "+") + "&season=" + i + API_KEY);
            DadosTemporada temporada = conversor.obterDados(json, DadosTemporada.class);

            temporadasList.add(temporada);

        }

        System.out.println("---------------- TEMPORADAS ---------------------");
        //temporadasList.forEach(System.out::println);

        /*for (int i = 0; i < serie.totalSeasons(); i++) {
            System.out.println("---------------------------------------------------------");
            System.out.println("Season " + (i + 1));
            List<DadosEpisodio> episodioList = temporadasList.get(i).episodesList();
            System.out.println("Episodes -------------------------------------");
            for (int j = 0; j < serie.totalSeasons(); j++) {
                System.out.println(episodioList.get(j).titulo());
            }
        }*/

        temporadasList.forEach(t -> {
            System.out.println("---------------------------------------------------------");
            System.out.println("Season " + (temporadasList.indexOf(t)+1));
            System.out.println(" -- Episodes -- ");

            t.episodesList().forEach(e ->{
                System.out.println(e.titulo());
            });

        });
    }
}
