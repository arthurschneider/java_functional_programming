package de.aschneider.cardschuffler;

public class Card {

   Suit suit;
   Rank rank;
   
   Card(Suit suit, Rank rank){
       this.suit = suit;
       this.rank = rank;
   }
   
   @Override
   public String toString() {
       return suit +" "+rank;
   }
}
