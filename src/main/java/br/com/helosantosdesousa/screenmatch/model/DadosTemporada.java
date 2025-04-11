package br.com.helosantosdesousa.screenmatch.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;
@JsonIgnoreProperties(ignoreUnknown = true)

public record DadosTemporada(@JsonAlias("Season") int season, @JsonAlias("Episodes") List<DadosEpisodio> episodesList) {
}
