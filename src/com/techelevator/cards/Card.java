package com.techelevator.cards;

public class Card {
	private String suit;
	private int rank;
	
	public static final String HEARTS = "hearts";
	public static final String CLUBS = "clubs";
	public static final String SPADES = "spades";
	public static final String DIAMONDS = "diamonds";
	public static final int ACE = 1;
	public static final int KING = 13;
	public static final int QUEEN = 12;
	public static final int JACK = 11;
	public static final int[] cardValues = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10};
	public static final String[] cardNames = new String[] {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};
	
	public Card(int rank, String suit) {
		this.rank = rank;
		this.suit = suit;
	}
	
	public int getRank() {
		return this.rank;
	}
	
	public int getValue() {
		return cardValues[rank-1];
	}
	
	public String getSuit() {
		return this.suit;
	}
	
	public String toString() {
		return cardNames[rank-1] + " of " + suit;
	}
}
