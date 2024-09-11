package br.edu.fatecpg.Maven.Model;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Carro (

        @JsonAlias("Marca") String marca,

        @JsonAlias("Valor") String valor,

        @JsonAlias("Modelo") String modelo,

        @JsonAlias("AnoModelo") String ano,

        @JsonAlias("CodigoFipe") String cod)
{
    @Override
    public String toString() {
        return "\n---Carro---" +
                "\nMarca: "  + marca +
                "\nValor: " + valor +
                "\nModelo: " + modelo +
                "\nAno: " + ano +
                "\nCódigo: " + cod;
    }
}
