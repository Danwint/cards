package com.techelevator.cards;

import static com.techelevator.cards.Card.*;

public class CardsDemo {
	public static void main(String[] args) {
		Card newCard = new Card(ACE, SPADES);
		System.out.println("Your card is the "+newCard.getRank()+" of "+newCard.getSuit());
	}
}
