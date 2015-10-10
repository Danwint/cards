package com.techelevator.cards;

import static com.techelevator.cards.Blackjack.*;

import java.io.IOException;

public class CardsDemo {
	public static void main(String[] args) throws IOException {
		
		Deck newDeck = new Deck();
		newDeck.shuffle();
		Card[] christosCards = newDeck.deal(7);
		Card[] brucesCards = newDeck.deal(7);
		Card[] dannysCards = newDeck.deal(7);
		
		showCards("Christo", christosCards);
		showCards("Bruce", brucesCards);
		showCards("Danny", dannysCards);
		
		System.out.println("\n\n******BlackJack******");

		playBlackjack(1, newDeck);
		
		System.out.println("\n******End of Game******\n\n");
	}

}
