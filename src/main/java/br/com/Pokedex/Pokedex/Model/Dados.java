package br.com.Pokedex.Pokedex.Model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@JsonIgnoreProperties(ignoreUnknown = true)
public record Dados( @JsonAlias("name")String name, @JsonAlias("abilities") String abilities ) {

}
