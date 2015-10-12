package com.techelevator.cards;

import static com.techelevator.cards.Blackjack.*;

import java.io.IOException;

public class CardsDemo {
	public static void main(String[] args) throws IOException {
		
		Deck newDeck = new Deck();
		newDeck.shuffle();
		
		System.out.println("\n\n******BlackJack******");

		playBlackjack(3, newDeck);
		
		System.out.println("\n******End of Game******\n\n");
	}

}
