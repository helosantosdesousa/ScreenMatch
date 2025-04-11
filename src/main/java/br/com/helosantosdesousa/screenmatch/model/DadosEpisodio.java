package br.com.helosantosdesousa.screenmatch.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)

public record DadosEpisodio(@JsonAlias ("Title")String titulo, @JsonAlias ("Episode") int numEpisodio, @JsonAlias("imdbRating")String rating, @JsonAlias("Released")String dataLancamento) {
}
