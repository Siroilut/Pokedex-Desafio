package br.com.Pokedex.Pokedex.Service;

import br.com.Pokedex.Pokedex.Model.PokemonData;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsumoApi {

    private final HttpClient client = HttpClient.newHttpClient();
    private final ObjectMapper objectMapper = new ObjectMapper();

    // Metodo para obter dados do Pokémon
    public PokemonData obterDados(String endereco) {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(endereco))
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            String responseBody = response.body();

            // Desserializa o JSON da resposta diretamente em um objeto PokemonData
            return objectMapper.readValue(responseBody, PokemonData.class);

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            return null;
        }
    }

    // metodo para obter localizações (encounters) de um Pokémon
    public JsonNode obterDadosLocalizacoes(String enderecoLocalizacao) {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(enderecoLocalizacao))
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            String responseBody = response.body();

            // Retorna o JSON como um JsonNode para lidar com listas ou objetos complexos
            return objectMapper.readTree(responseBody);

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            return null;
        }
    }
}
