package br.edu.fatecpg.Maven.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ConverteDado implements  IConverteDado {

    ObjectMapper mapper = new ObjectMapper();

    @Override
    public <T> T consome(String json, Class<T> classe) throws JsonProcessingException {
        return mapper.readValue(json, classe);
    }
}
