package br.com.Pokedex.Pokedex.Principal;

import br.com.Pokedex.Pokedex.Service.ConsumoApi;

import java.util.Scanner;

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

        String endereco = "";

        if (opcao.toLowerCase().contains(opcao)){
            endereco = URL_BASE + opcao;

        }else {
            System.out.println("pokemon nao encontrado");

        }

        String json = consumo.obterDados(endereco);
        System.out.println(json);


//        System.out.println("""
//                OPÇÕES:
//                *Yellow
//                *Blue
//                *Gold
//                *Silver
//                *Crystal
//
//                Digite o nome da versão:
//                """);


        System.out.println("Gostaria de saber a localização? ");
        String localizacao = leitura.nextLine();
        System.out.println(localizacao.toLowerCase().contains("sim"));
        if (localizacao.toLowerCase().contains("sim"))
            endereco =  endereco+ "/" + "encounters";
        else if (localizacao.toLowerCase().contains("não")){
            System.out.println("Pesquisa encerrada!");
        }

        json = consumo.obterDados(endereco);
        System.out.println(json);





    }



}
