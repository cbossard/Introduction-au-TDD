package com.artis.dojo;


import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class TennisGameTest  {

	private TennisGame game;
	
	@Before
	public void init(){
		game = new TennisGame();
	}
	
	@Test
	public void nouveau_jeu_score_nul(){
		assertEquals("Egalité : 0-0",  game.getScore());
	}
	
	@Test
	public void joueur1_gagne_premier_point(){
		game.player1Scores();
		assertEquals("15-0",  game.getScore());
	}
	
	// joueur1 gagne 2 premiers points
	@Test
	public void joueur1_gagne_2_premiere_point(){
		game.player1Scores();
		game.player1Scores();
		assertEquals("30-0",  game.getScore());
	}
	
	// joueur1 gagne 3 premiers points
	@Test
	public void joueur1_gagne_3_premiere_point(){
		game.player1Scores();
		game.player1Scores();
		game.player1Scores();
		assertEquals("40-0",  game.getScore());
	}
	
	// joueur1 gagne 4 jeu
	@Test
	public void joueur1_gagne_jeu(){
		game.player1Scores();
		game.player1Scores();
		game.player1Scores();
		game.player1Scores();
		assertEquals("Jeu joueur 1",  game.getScore());
	}
	
	// joueur 1 gagne 1er point, joueur 2 gagne 2ème point
	@Test
	public void egalite_15_partout(){
		game.player1Scores();
		game.player2Scores();

		assertEquals("Egalité : 15-15",  game.getScore());
	}

	
	// joueur 1 a l'avantage
	@Test
	public void avantage_joueur1(){
		game.player1Scores();
		game.player1Scores();
		game.player1Scores();
		game.player2Scores();
		game.player2Scores();
		game.player2Scores();
		game.player1Scores();
		
		assertEquals("AV-40",  game.getScore());
	}
	
	// joueur 1 perd l'avantage
	@Test
	public void egalite_apres_avantage(){
		game.player1Scores(); // 15-0
		game.player1Scores(); // 30-0
		game.player1Scores(); // 40-0
		game.player2Scores(); // 40-15
		game.player2Scores(); // 40-30
		game.player2Scores(); // 40-40
		game.player1Scores(); // AV-40
		game.player2Scores(); // 40-40
		
		assertEquals("Egalité : 40-40",  game.getScore());
	}
	
	// joueur 1 gagne le jeu après un avantage
	@Test
	public void joueur1_gagne_après_avantage(){
		game.player1Scores(); // 15-0
		game.player1Scores(); // 30-0
		game.player1Scores(); // 40-0
		game.player2Scores(); // 40-15
		game.player2Scores(); // 40-30
		game.player2Scores(); // 40-40
		game.player1Scores(); // AV-40
		game.player1Scores(); // Joueur 1 gagne
		
		assertEquals("Jeu joueur 1",  game.getScore());
	}
}
