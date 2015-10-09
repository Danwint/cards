package com.techelevator.cards;

import static com.techelevator.cards.Card.*;

public class CardsDemo {
	public static void main(String[] args) {
		Card newCard = new Card(ACE, SPADES);
		System.out.println(newCard);
		System.out.println("Your card is the "+newCard.getRank()+" of "+newCard.getSuit());
		
		Deck newDeck = new Deck();
		Card[] christosCards = newDeck.deal(5);
		Card[] brucesCards = newDeck.deal(5);
		Card[] dannysCards = newDeck.deal(5);
		
		showCards("Christo", christosCards);
		showCards("Bruce", brucesCards);
		showCards("Danny", dannysCards);
		
	}
	
	public static void showCards(String name, Card[] cards) {
		System.out.println(name+"'s cards: ");
		for(Card c : cards) {
			System.out.println(c.getRank()+" of "+c.getSuit());
		}
	}
	
	
}
