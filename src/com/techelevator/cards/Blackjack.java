package com.techelevator.cards;


public class Blackjack {

	public static void showCards(String name, Card[] cards) {
		System.out.println("\n" + name + "'s cards: \n");
		for (Card c : cards) {
			System.out.println(c);
		}
	}

	public static int handValue(Card[] hand) {
		int numberOfAces = 0;
		int handValue = 0;
		for (int i = 0; i < hand.length; i++) {
			if (hand[i].getRank() == 1) {
				numberOfAces += 1;
			} else {
				handValue += hand[i].getValue();
			}
		}

		if (numberOfAces > 0) {
			for (int i = 1; i <= numberOfAces; i++) {
				if ((handValue + 11 + (numberOfAces - i)) <= 21) {
					handValue += 11;
				} else {
					handValue += 1;
				}
			}
		}
		return handValue;
	}

	public static void evaluateHand(String playerName, Card[] hand) {
		int playerHandTotal = handValue(hand);
		if (playerHandTotal < 21) {
			System.out.println(playerName + " has : " + playerHandTotal);
		} else if (playerHandTotal == 21) {
			System.out.println(playerName + " has Blackjack!");
		} else {
			System.out.println(playerName + " Busts!");
		}
	}
	
	private static int determineWinner(int[] allHandValues) {
		int winningHand = 0;
		int winningIndex = 0;
		for(int i = 0; i < allHandValues.length; i++) {
			if (allHandValues[i] > winningHand && allHandValues[i] < 22) {
				winningHand = allHandValues[i];
				winningIndex = i;
			}
		}
		return winningIndex;
	}

	public static void playBlackjack(int numberOfAIPlayers, Deck deck) throws java.io.IOException {
		char choice, ignore;
		Card[] playerHand = deck.deal(2);
		int[] allHandValues = new int[numberOfAIPlayers + 1];
		showCards("Player", playerHand);
		for (; handValue(playerHand) < 21;) {
			do {
				System.out.println("h to hit, s to Stand");
				choice = (char) System.in.read();
				
				do {
					ignore = (char) System.in.read();
				} while (ignore != '\n');
			} while ( choice != 'h' && choice != 's');
			
			//System.out.println("\n");
			
			switch(choice) {
				case 'h':
					Card[] hitMe = deck.deal(1);
					Card[] temporaryHand = new Card[playerHand.length + 1];
					for (int i = 0; i < playerHand.length; i++) {
						temporaryHand[i] = playerHand[i];
					}
					temporaryHand[temporaryHand.length - 1] = hitMe[0];
					playerHand = temporaryHand;
					showCards("Player", playerHand);
					break;
				case 's':
					showCards("Player", playerHand);
					break;
			}
			if (choice == 's') {
				break;
			}
		}
		allHandValues[0] = handValue(playerHand);
		evaluateHand("Player", playerHand);
		
		for (int i = 1; i <= numberOfAIPlayers; i++) {
			String playerAIName = "AI "+i;
			allHandValues[i] = autoPlayBlackjack(playerAIName, deck);
		}
		
		int winnerIndex = determineWinner(allHandValues);
		if (winnerIndex == 0) {
			System.out.println("Player Wins!!!");
		} else {
			System.out.println("AI "+winnerIndex+" Wins...");
		}
		
		
	}
	
	public static int autoPlayBlackjack(String playerName, Deck deck) {
		Card[] hand = deck.deal(2);
		int playerHandTotal = handValue(hand);
		while (playerHandTotal < 17) {
			Card[] hitMe = deck.deal(1);
			Card[] temporaryHand = new Card[hand.length + 1];
			for (int i = 0; i < hand.length; i++) {
				temporaryHand[i] = hand[i];
			}
			temporaryHand[temporaryHand.length - 1] = hitMe[0];
			hand = temporaryHand;
			playerHandTotal = handValue(hand);
			
		}

		showCards(playerName, hand);
		evaluateHand(playerName, hand);
		return playerHandTotal;
	}

}
