package br.com.Pokedex.Pokedex.Model;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
    public class PokemonData {
        private List<AbilityWrapper> abilities;


        public List<AbilityWrapper> getAbilities() { return abilities; }
        public void setAbilities(List<AbilityWrapper> abilities) { this.abilities = abilities; }
    }

