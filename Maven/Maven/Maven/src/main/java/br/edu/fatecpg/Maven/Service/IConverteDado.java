package br.edu.fatecpg.Maven.Service;

import com.fasterxml.jackson.core.JsonProcessingException;

public interface IConverteDado {
    <T> T consome(String json, Class<T> classe) throws JsonProcessingException;
}
