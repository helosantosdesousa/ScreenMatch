package br.com.helosantosdesousa.screenmatch.service;

import com.fasterxml.jackson.core.JsonProcessingException;

public interface IConverteDados {
    <T> T obterDados(String json, Class <T> classe) throws JsonProcessingException;
    //isso é um java generics -> vc quer que devolva uma ENTIDADE mas nao necessariamente vc sabe se é tipo serie, dretor, ator...
}
