package com.techelevator.cards;

import static com.techelevator.cards.Card.*;
import java.util.Random;

public class Deck {
	private int numberOfCards;
	private Card[] cardsInDeck;
	private static final String[] SUITS = new String[] { HEARTS, CLUBS, SPADES, DIAMONDS };
	int topOfDeck = 0;

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

	public Card[] deal(int handDealt) {
		Card[] hand = new Card[handDealt];
		
		for (int i = 0; i < handDealt; i++) {
			hand[i] = cardsInDeck[topOfDeck];
			topOfDeck++;
			if (topOfDeck >= 52) {
				this.shuffle();
				topOfDeck = 0;
			}
		}
		return hand;
	}

	public void shuffle() {
		Random numGenerator = new Random();
		for (int i = 0; i < 1000; i++) {
			int rando = numGenerator.nextInt(52);
			int rando2 = numGenerator.nextInt(52);
			Card holdCard = cardsInDeck[rando];
			cardsInDeck[rando] = cardsInDeck[rando2];
			cardsInDeck[rando2] = holdCard;

		}

	}
}
