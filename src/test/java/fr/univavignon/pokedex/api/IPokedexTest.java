package fr.univavignon.pokedex.api;

import org.mockito.Mockito;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

public class IPokedexTest{
	
	IPokedex iPokedexMock = Mockito.mock(IPokedex.class);
	
	@Test
	public void testSize() {
		when(iPokedexMock.size()).thenReturn(0);
		assertEquals(0,iPokedexMock.size());
	}
	
	@Test
	public void testAddPokemon() {
		Pokemon pokemon = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 56);
		when(iPokedexMock.addPokemon(pokemon)).thenReturn(0);
		assertEquals(0,iPokedexMock.addPokemon(pokemon));
	}
	
	@Test
	public void testGetPokemon() throws PokedexException {
		Pokemon pokemon = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 56);
		when(iPokedexMock.getPokemon(anyInt())).thenAnswer(input -> {
			if((int)input.getArgument(0) > 150 || (int)input.getArgument(0) < 0) throw new PokedexException("Index must be between 0 and 150!");
			else return pokemon; 
		});
		assertThrows(PokedexException.class,()->iPokedexMock.getPokemon(-1));
		assertThrows(PokedexException.class,()->iPokedexMock.getPokemon(151));
		assertEquals(pokemon, iPokedexMock.getPokemon(0));
	}
	
	@Test
	public void testGetPokemons() {
		ArrayList<Pokemon> pokemons = new ArrayList<>();
		pokemons.add(new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 56));
		pokemons.add(new Pokemon(1, "Aquali", 186, 168, 260, 2729, 202, 5000, 4, 100));
		when(iPokedexMock.getPokemons()).thenReturn(pokemons);
		assertEquals(pokemons,iPokedexMock.getPokemons());
	}
}
