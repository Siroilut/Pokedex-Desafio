package br.com.Pokedex.Pokedex.Principal;

import br.com.Pokedex.Pokedex.Model.AbilityWrapper;
import br.com.Pokedex.Pokedex.Model.Dados;
import br.com.Pokedex.Pokedex.Model.PokemonData;
import br.com.Pokedex.Pokedex.Service.ConsumoApi;
import com.fasterxml.jackson.databind.JsonNode;

import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class Principal {

    private ConsumoApi consumo = new ConsumoApi();
    private final String URL_BASE = "https://pokeapi.co/api/v2/pokemon/";
    private Scanner leitura = new Scanner(System.in);




    public void exibeMenu() {
        String menu = """
                digite o nome do pokemon
                
                """;

        System.out.println(menu);
        String opcao = leitura.nextLine();

        String endereco = URL_BASE + opcao;
        PokemonData pokemonData = consumo.obterDados(endereco);

        if (pokemonData != null) {
            System.out.println("Detalhes do Pokémon:");
            pokemonData.getAbilities().forEach(abilityWrapper -> {
                System.out.println("Habilidade: " + abilityWrapper.getAbility().getName());
            });
        } else {
            System.out.println("Pokémon não encontrado.");
        }


        System.out.println("Gostaria de saber a localização? ");
        String localizacao = leitura.nextLine();



        if (localizacao.equalsIgnoreCase("sim")) {
            String enderecoLocalizacao = endereco + "/encounters";
            JsonNode localizacoes = consumo.obterDadosLocalizacoes(enderecoLocalizacao);


            //pesquisa e impressão do filtro por chance de captura
            if (localizacoes != null && localizacoes.isArray()) {
                List<JsonNode> localizacaoFiltrada = StreamSupport.stream(localizacoes.spliterator(), false)
                        .flatMap(n -> StreamSupport.stream(n.get("version_details").spliterator(), false))
                        .flatMap(versionDetails -> StreamSupport.stream(versionDetails.get("encounter_details").spliterator(), false))
                        .filter(c -> c.get("chance") !=null && c.get("chance").asInt() > 1)
                        .limit(1)
                        .collect(Collectors.toList());
                if (!localizacaoFiltrada.isEmpty()){
                    localizacaoFiltrada.forEach(System.out::println);;
                }else {
                    System.out.println("nada encontrado!");
                }

            } else {
                System.out.println("Nenhuma localização encontrada.");
            }
        } else {
            System.out.println("Pesquisa encerrada.");
        }
    }
}
