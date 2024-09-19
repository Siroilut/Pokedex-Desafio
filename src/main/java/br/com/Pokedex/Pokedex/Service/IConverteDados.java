package br.com.Pokedex.Pokedex.Service;


import java.util.List;

public interface IConverteDados {
        List<String>   obterDados(String json, Class<String> classe);
    }


