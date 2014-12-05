package com.artis.dojo;


public class TennisGame {

	int scorePlayer1 = 0;
	int scorePlayer2 = 0;

	public String getScore() {

		if (hasWinner()) {
			return "Jeu " + winner();
		}

		String convertedScorePlayer1 = translateScore(scorePlayer1);
		String convertedScorePlayer2 = translateScore(scorePlayer2);

		String score = convertedScorePlayer1 + "-" + convertedScorePlayer2;
		if (scorePlayer1 == scorePlayer2) {
			score = "Egalité : " + score;
		}
		return score;
	}

	private String winner() {
		if (scorePlayer1 > scorePlayer2)
			return "joueur 1";
		else if (scorePlayer2 > scorePlayer1)
			return "joueur 2";
		else
			return null;
	}

	private boolean hasWinner() {
		if (scorePlayer1 > 3 && scorePlayer1 > (scorePlayer2 + 1))
			return true;
		if (scorePlayer2 > 3 && scorePlayer2 > (scorePlayer1 + 1))
			return true;
		return false;
	}

	private String translateScore(int score) {
		switch (score) {
		case 0:
			return "0";
		case 1:
			return "15";
		case 2:
			return "30";
		case 3:
			return "40";
		case 4:
			return "AV";
		}
		return null;
	}

	public void player1Scores() {
		if (scorePlayer2 == 4)
			scorePlayer2--;
		else
			scorePlayer1++;
	}

	public void player2Scores() {
		if (scorePlayer1 == 4)
			scorePlayer1--;
		else
			scorePlayer2++;
	}

}
