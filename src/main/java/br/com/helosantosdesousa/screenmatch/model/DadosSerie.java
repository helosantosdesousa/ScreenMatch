package br.com.helosantosdesousa.screenmatch.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true) //ignorar todos os dados que eu nao pedi, pra nao dar erro
public record DadosSerie(String Title, @JsonAlias("imdbRating") double ratings, int totalSeasons) {
}
