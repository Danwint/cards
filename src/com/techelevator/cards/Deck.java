package com.techelevator.cards;

import static com.techelevator.cards.Card.*;

public class Deck {
	private int numberOfCards;
	private Card[] cardsInDeck;
	private static final String[] SUITS = new String[] { HEARTS, CLUBS, SPADES, DIAMONDS };

	public Deck() {
		cardsInDeck = new Card[52];

		int offset = 0;

		for (String suit : SUITS) {
			for (int rank = 1; rank <= 13; rank++) {
				Card newCard = new Card(rank, suit);
				cardsInDeck[rank + offset - 1] = newCard;
			}
			offset += 13;
		}

	}
}
