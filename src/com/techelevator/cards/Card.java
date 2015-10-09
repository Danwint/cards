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
	
	public Card(int rank, String suit) {
		this.rank = rank;
		this.suit = suit;
	}
	
	public int getRank() {
		return this.rank;
	}
	
	public String getSuit() {
		return this.suit;
	}
}
