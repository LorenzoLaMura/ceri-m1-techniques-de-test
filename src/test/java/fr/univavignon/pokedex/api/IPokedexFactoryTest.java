package fr.univavignon.pokedex.api;

import org.mockito.Mockito;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class IPokedexFactoryTest  {

	@Test
	public void testCreatePokedex() {
		IPokedexFactory iPokedexFactory = Mockito.mock(IPokedexFactory.class);
		IPokemonMetadataProvider metadataProvider = Mockito.mock(IPokemonMetadataProvider.class);
		IPokemonFactory pokemonFactory = Mockito.mock(IPokemonFactory.class);
		IPokedex ipokedex = Mockito.mock(IPokedex.class);
		when(iPokedexFactory.createPokedex(metadataProvider, pokemonFactory)).thenReturn(ipokedex);
		assertEquals(iPokedexFactory.createPokedex(metadataProvider, pokemonFactory), ipokedex);
	}

}
