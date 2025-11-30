/* *****************************************************************************
 *  Name:              Ikhsan Sigma Putra
 *  Coursera User ID:  ikhsanputra@gmail.com
 *  Last modified:     November 29, 2025
 **************************************************************************** */

import java.util.Arrays;

public class PokerAnalysis {
    private static final String[] SUITS = {
            "Clubs", "Diamonds", "Hearts", "Spades"
    };
    private static final String[] RANKS = {
            "2", "3", "4", "5", "6", "7", "8", "9", "10",
            "Jack", "Queen", "King", "Ace"
    };
    private static final String DIVIDER = " of ";

    public static String[] getDeck(String[] suits, String[] ranks) {
        String[] deck = new String[suits.length * ranks.length];
        for (int i = 0; i < suits.length; i++)
            for (int j = 0; j < ranks.length; j++)
                deck[ranks.length * i + j] = ranks[j] + DIVIDER + suits[i];
        return deck;
    }

    public static String[] getRandomNCards(int nbCards, String[] decks) {
        String[] cards = new String[nbCards];
        int[] randomIndex = new int[nbCards];
        for (int i = 0; i < nbCards; i++) {
            do {
                randomIndex[i] = StdRandom.uniformInt(decks.length);
            }
            while (!distinct(randomIndex, i));
            cards[i] = decks[randomIndex[i]];
        }
        return cards;
    }

    public static boolean distinct(int[] random, int n) {
        if (n == 0) return true;
        for (int i = 0; i < n; i++) {
            if (random[i] == random[n])
                return false;
        }
        return true;
    }

    public static boolean isRoyalFlush(String[] cards) {
        return isFlush(cards) && isHighCards(cards);
    }

    public static boolean isStraightFlush(String[] cards) {
        return isFlush(cards) && isStraight(cards);
    }

    public static boolean isFourOfAKind(String[] cards) {
        return compareCards(cards, 4, 1);
    }

    public static boolean isFullHouse(String[] cards) {
        return isThreeOfAKind(cards) && isOnePair(cards);
    }

    public static boolean isThreeOfAKind(String[] cards) {
        return compareCards(cards, 3, 1);
    }

    public static boolean isTwoPair(String[] cards) {
        return compareCards(cards, 2, 2);
    }

    public static boolean isOnePair(String[] cards) {
        return compareCards(cards, 2, 1);
    }

    public static boolean compareCards(String[] cards, int nbSameRank, int nbSameRankOccurence) {
        int[] ranks = new int[RANKS.length];
        for (int i = 0; i < cards.length; i++) {
            ranks[getRankValue(getCardRank(cards[i]))]++;
        }
        int occurence = 0;
        for (int i = 0; i < ranks.length; i++) {
            if (ranks[i] == nbSameRank)
                occurence++;
        }
        return occurence == nbSameRankOccurence;
    }

    public static boolean isStraight(String[] cards) {
        String[] sortedCards = sortByRank(cards);
        for (int i = 0; i < sortedCards.length - 1; i++) {
            int rankFirst = getRankValue(getCardRank(sortedCards[i]));
            int rankSecond = getRankValue(getCardRank(sortedCards[i + 1]));
            if (rankFirst != rankSecond - 1) {
                return false;
            }
        }
        return true;
    }

    public static boolean isFlush(String[] cards) {
        for (int i = 1; i < cards.length; i++)
            if (!getCardSuit(cards[0]).equals(getCardSuit(cards[i])))
                return false;
        return true;
    }

    public static boolean isHighCards(String[] cards) {
        for (int i = 0; i < cards.length; i++)
            if (!isHighCard(cards[i]))
                return false;
        return true;
    }

    public static boolean isHighCard(String card) {
        if (getRankValue(getCardRank(card)) > 7) {
            return true;
        }
        return false;
    }

    public static String getCardRank(String card) {
        return getCardRankAndSuit(card)[0];
    }

    public static String getCardSuit(String card) {
        return getCardRankAndSuit(card)[1];
    }

    public static String[] getCardRankAndSuit(String card) {
        return card.split(DIVIDER);
    }

    public static String[] sortByRank(String[] cards) {
        String[] cardsCopy = new String[cards.length];
        for (int i = 0; i < cards.length; i++) {
            cardsCopy[i] = cards[i];
        }
        for (int i = 0; i < cardsCopy.length - 1; i++) {
            for (int j = i + 1; j < cardsCopy.length; j++) {
                if (getRankValue(getCardRank(cardsCopy[i])) > getRankValue(
                        getCardRank(cardsCopy[j]))) {
                    String temp = cardsCopy[i];
                    cardsCopy[i] = cardsCopy[j];
                    cardsCopy[j] = temp;
                }
            }
        }
        return cardsCopy;
    }

    public static int getRankValue(String rank) {
        for (int i = 0; i < RANKS.length; i++) {
            if (rank.equals(RANKS[i]))
                return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        String[] deck = getDeck(SUITS, RANKS);
        // test(deck);

        int trials = Integer.parseInt(args[0]);
        int countRoyalFlush = 0;
        int countStraightFlush = 0;
        int countFourOfAKind = 0;
        int countFullHouse = 0;
        int countFlush = 0;
        int countStraight = 0;
        int countThreeOfAKind = 0;
        int countTwoPair = 0;
        int countOnePair = 0;

        for (int t = 0; t < trials; t++) {
            String[] cards = getRandomNCards(5, deck);
            if (isRoyalFlush(cards)) countRoyalFlush++;
            else if (isStraightFlush(cards)) countStraightFlush++;
            else if (isFourOfAKind(cards)) countFourOfAKind++;
            else if (isFullHouse(cards)) countFullHouse++;
            else if (isFlush(cards)) countFlush++;
            else if (isStraight(cards)) countStraight++;
            else if (isThreeOfAKind(cards)) countThreeOfAKind++;
            else if (isTwoPair(cards)) countTwoPair++;
            else if (isOnePair(cards)) countOnePair++;
        }
        System.out.println("Possibility of Royal Flush: " + (double) countRoyalFlush / trials);
        System.out.println(
                "Possibility of Straight Flush: " + (double) countStraightFlush / trials);
        System.out.println("Possibility of Four Of A Kind: " + (double) countFourOfAKind / trials);
        System.out.println("Possibility of Full House: " + (double) countFullHouse / trials);
        System.out.println("Possibility of Flush: " + (double) countFlush / trials);
        System.out.println("Possibility of Straight: " + (double) countStraight / trials);
        System.out.println(
                "Possibility of Three Of A Kind: " + (double) countThreeOfAKind / trials);
        System.out.println("Possibility of Two Pair: " + (double) countTwoPair / trials);
        System.out.println("Possibility of One Pair: " + (double) countOnePair / trials);
        System.out.printf("Total: %d\n",
                          countOnePair + countTwoPair + countThreeOfAKind + countStraight
                                  + countFlush + countFullHouse + countFourOfAKind
                                  + countStraightFlush + countRoyalFlush);
        double[] stats = new double[9];
        stats[0] = (double) countRoyalFlush / trials;
        stats[1] = (double) countStraightFlush / trials;
        stats[2] = (double) countFourOfAKind / trials;
        stats[3] = (double) countFullHouse / trials;
        stats[4] = (double) countFlush / trials;
        stats[5] = (double) countStraight / trials;
        stats[6] = (double) countThreeOfAKind / trials;
        stats[7] = (double) countTwoPair / trials;
        stats[8] = (double) countOnePair / trials;
        StdStats.plotBars(stats);
    }

    public static void test(String[] deck) {
        System.out.println(Arrays.toString(deck));
        System.out.println(Arrays.toString(getRandomNCards(5, deck)));
        System.out.println("isFlush");
        System.out.println(isFlush(new String[] {
                "Queen of Diamonds", "3 of Diamonds", "4 of Diamonds",
                "7 of Diamonds", "6 of Diamonds"
        }) + " should be true");
        System.out.println(isFlush(new String[] {
                "Queen of Diamonds", "3 of Diamonds", "4 of Diamonds",
                "7 of Diamonds", "6 of Clubs"
        }) + " should be false");
        System.out.println("isHighCards");
        System.out.println(isHighCards(new String[] {
                "Queen of Clubs", "Jack of Diamonds", "King of Diamonds",
                "10 of Hearts", "Ace of Clubs"
        }) + " should be true");
        System.out.println(isHighCards(new String[] {
                "Queen of Clubs", "2 of Diamonds", "King of Diamonds",
                "10 of Hearts", "9 of Clubs"
        }) + " should be false");
        System.out.println("isRoyalFlush");
        System.out.println(isRoyalFlush(new String[] {
                "Queen of Clubs", "Jack of Clubs", "King of Clubs",
                "10 of Clubs", "Ace of Clubs"
        }) + " should be true");
        System.out.println(isRoyalFlush(new String[] {
                "Queen of Clubs", "2 of Diamonds", "King of Diamonds",
                "10 of Hearts", "9 of Clubs"
        }) + " should be false");
        System.out.println("sortByRank");
        System.out.println(Arrays.toString(sortByRank(new String[] {
                "6 of Clubs", "2 of Diamonds", "King of Diamonds",
                "10 of Hearts", "9 of Clubs"
        })));
        System.out.println("isStraight");
        System.out.println(isStraight(new String[] {
                "7 of Clubs", "5 of Diamonds", "6 of Spades",
                "8 of Hearts", "4 of Clubs"
        }) + " should be true");
        System.out.println(isStraight(new String[] {
                "6 of Clubs", "2 of Diamonds", "King of Diamonds",
                "10 of Hearts", "9 of Clubs"
        }) + " should be false");
        System.out.println("isStraightFlush");
        System.out.println(isStraightFlush(new String[] {
                "4 of Clubs", "5 of Clubs", "6 of Clubs",
                "3 of Clubs", "2 of Clubs"
        }) + " should be true");
        System.out.println(isStraightFlush(new String[] {
                "4 of Clubs", "5 of Diamonds", "6 of Spade",
                "3 of Hearts", "2 of Clubs"
        }) + " should be false");
        System.out.println("isFourOfAKind");
        System.out.println(isFourOfAKind(new String[] {
                "Queen of Clubs", "Queen of Diamonds", "Queen of Spades",
                "Queen of Hearts", "9 of Clubs"
        }) + " should be true");
        System.out.println(isFourOfAKind(new String[] {
                "Queen of Clubs", "Queen of Diamonds", "Queen of Spades",
                "King of Hearts", "9 of Clubs"
        }) + " should be false");
        System.out.println("isFullHouse");
        System.out.println(isFullHouse(new String[] {
                "Queen of Clubs", "Queen of Diamonds", "Queen of Spades",
                "9 of Hearts", "9 of Clubs"
        }) + " should be true");
        System.out.println(isFullHouse(new String[] {
                "Queen of Clubs", "Queen of Diamonds", "Queen of Spades",
                "Queen of Hearts", "9 of Clubs"
        }) + " should be false");
        System.out.println(isFullHouse(new String[] {
                "Queen of Clubs", "Queen of Diamonds", "King of Spades",
                "King of Hearts", "9 of Clubs"
        }) + " should be false");
        System.out.println("isThreeOfAKind");
        System.out.println(isThreeOfAKind(new String[] {
                "Queen of Clubs", "Queen of Diamonds", "Queen of Spades",
                "King of Hearts", "9 of Clubs"
        }) + " should be true");
        System.out.println(isThreeOfAKind(new String[] {
                "Queen of Clubs", "Queen of Diamonds", "Queen of Spades",
                "Queen of Hearts", "9 of Clubs"
        }) + " should be false");
        System.out.println(isThreeOfAKind(new String[] {
                "Queen of Clubs", "8 of Diamonds", "Queen of Spades",
                "Ace of Hearts", "9 of Clubs"
        }) + " should be false");
        System.out.println("isTwoPair");
        System.out.println(isTwoPair(new String[] {
                "Queen of Clubs", "Queen of Diamonds", "King of Spades",
                "King of Hearts", "9 of Clubs"
        }) + " should be true");
        System.out.println(isTwoPair(new String[] {
                "Queen of Clubs", "Queen of Diamonds", "Queen of Spades",
                "Queen of Hearts", "9 of Clubs"
        }) + " should be false");
        System.out.println(isTwoPair(new String[] {
                "Queen of Clubs", "8 of Diamonds", "Queen of Spades",
                "Ace of Hearts", "9 of Clubs"
        }) + " should be false");
        System.out.println(isTwoPair(new String[] {
                "Queen of Clubs", "8 of Diamonds", "10 of Spades",
                "Ace of Hearts", "9 of Clubs"
        }) + " should be false");
        System.out.println("isOnePair");
        System.out.println(isOnePair(new String[] {
                "Queen of Clubs", "8 of Diamonds", "Queen of Spades",
                "Ace of Hearts", "9 of Clubs"
        }) + " should be true");
        System.out.println(isOnePair(new String[] {
                "Queen of Clubs", "Queen of Diamonds", "King of Spades",
                "King of Hearts", "9 of Clubs"
        }) + " should be false");
        System.out.println(isOnePair(new String[] {
                "Queen of Clubs", "Queen of Diamonds", "Queen of Spades",
                "Queen of Hearts", "9 of Clubs"
        }) + " should be false");
        System.out.println(isOnePair(new String[] {
                "Ace of Clubs", "Ace of Diamonds", "8 of Spades",
                "Ace of Hearts", "9 of Clubs"
        }) + " should be false");
    }


}
