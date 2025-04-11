package br.com.helosantosdesousa.screenmatch.service;

import br.com.helosantosdesousa.screenmatch.model.DadosSerie;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ConverteDados implements IConverteDados{
    private ObjectMapper mapper = new ObjectMapper();
    //mapper é o objeto do json que faz a oonversao

    @Override
    public <T> T obterDados(String json, Class<T> classe) throws JsonProcessingException {
        return mapper.readValue(json, classe);
    }
}
