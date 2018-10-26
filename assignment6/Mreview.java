package assignment6;

import java.util.*;


public class Mreview implements Comparable<Mreview>{

	  // instance variables
	  private String title;   // title of the movie
	  private ArrayList<Integer> ratings; // list of ratings stored in a Store object

	  public Mreview() {
		  title = "";
		  ratings = new ArrayList<>();
	  }
	  public Mreview(String ttl) {
		  this.title = ttl;
		  ratings = new ArrayList<>();
	  }
	  public Mreview(String ttl, int firstRating) {
		  this.title = ttl;
		  ratings = new ArrayList<>();
		  ratings.add(firstRating);
		  
	  }
	  // methods
	  public String getTitle(){
		  return title;
	  }

      public void addRating(int r) {
    	  ratings.add(r);
      }
      public double aveRating() {
    	  int sum = 0;
    	  for(Integer i : ratings) {
    		  sum += i;
    	  }
    	  double ave = (double)sum / (double)ratings.size();
    	  return ave;
      }
      public int numRatings() {
    	  return ratings.size();
      }

      @Override
      public int compareTo(Mreview obj) {
    	  String a = this.title;
    	  String b = obj.getTitle();
    	  int length = Math.min(a.length(), b.length());
    	  for(int i = 0; i < length; i++) {
    		  if((a.charAt(i) - 'a') - (b.charAt(i) - 'a') != 0)
    			  return (a.charAt(i) - 'a') - (b.charAt(i) - 'a');
    	  }
    	  if(a.length() == b.length())
    		  return 0;
    	  else {
    		  return a.length() - b.length();
    	  }
//    	  return a.compareTo(b);
      }
      @Override
      public boolean equals(Object obj) {
    	  String a = this.title;
    	  Mreview res = (Mreview)obj;
    	  String b = res.getTitle();
    	  if(a.length() != b.length())
    		  return false;
    	  for(int i = 0; i < a.length(); i++) {
    		  if(a.charAt(i) != b.charAt(i))
    			  return false;
    	  }
    	  return true;
    	 
      }
      public String toString(){
    	  return getTitle() +", average" + aveRating()+" out of "+numRatings()+" ratings";
      }
      
      public static void main(String[] args) {
    	  Mreview mreview = new Mreview("Kill Bill");
    	  mreview.addRating(3);
    	  mreview.addRating(4);
    	  mreview.addRating(3);
    	  System.out.println(mreview.toString());
    	  System.out.println(mreview.aveRating());
      }

}
