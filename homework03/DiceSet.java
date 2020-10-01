/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  File name     :  DiceSet.java
 *  Purpose       :  Provides a class describing a set of dice
 *  Author        :  Zach Boehnlein
 *  Date          :  2020-09-30
 *  Description   :  This class provides everything needed (pretty much) to describe a set of dice.  The
 *                   idea here is to have an implementing class that uses the Die.java class.  Includes
 *                   the following:
 *                   public DiceSet( int k, int n );                  // Constructor for a set of k dice each with n-sides
 *                   public int sum();                                // Returns the present sum of this set of dice
 *                   public void roll();                              // Randomly rolls all of the dice in this set
 *                   public void rollIndividual( int i );             // Randomly rolls only the ith die in this set
 *                   public int getIndividual( int i );               // Gets the value of the ith die in this set
 *                   public String toString();                        // Returns a stringy representation of this set of dice
 *                   public static String toString( DiceSet ds );     // Classwide version of the preceding instance method
 *                   public boolean isIdentical( DiceSet ds );        // Returns true iff this set is identical to the set ds
 *                   public static void main( String[] args );        // The built-in test program for this class
 *
 *  Notes         :  Stolen from Dr. Dorin pretty much verbatim, then modified to show some interesting
 *                   things about Java, and to add this header block and some JavaDoc comments.
 *  Warnings      :  None
 *  Exceptions    :  IllegalArgumentException when the number of sides or pips is out of range
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
import java.util.Random;
import java.util.Arrays;
import java.util.Scanner;

 public class DiceSet {

   /**
    * private instance data
    */
    private int count;
    private int sides;
    private Die[] ds = null;
    private int sum;
    private int[] comparison1 = null;
    private int[] comparison2 = null;

    // public constructor:
   /**
    * constructor
    * @param  count int value containing total dice count
    * @param  sides int value containing the number of pips on each die
    * @throws IllegalArgumentException if one or both arguments don't make sense
    * @note   parameters are checked for validity; invalid values throw "IllegalArgumentException"
    */
    public DiceSet( int count, int sides ) {
      if(count < 1 || sides < 4){
        throw new IllegalArgumentException("either count below 1 or sides below 1");

      }
      else{
        this.count = count;
        ds = new Die[ count ];
        for (int i = 0; i < count; i++) {
          ds[i] = new Die( sides );
        }
      }

    }

   /**
    * @return the sum of all the dice values in the set
    */
    public int sum() {
      for (int i = 0; i < count; i++){
        sum = sum + ds[i].getValue();
      }
       return sum;
    }

   /**
    * Randomly rolls all of the dice in this set
    *  NOTE: you will need to use one of the "toString()" methods to obtain
    *  the values of the dice in the set
    */
    public void roll() {
      for (int i = 0; i < count; i++){
        ds[i].roll();
        }
    }

   /**
    * Randomly rolls a single die of the dice in this set indexed by 'dieIndex'
    * @param  dieIndex int of which die to roll
    * @return the integer value of the newly rolled die
    * @trhows IllegalArgumentException if the index is out of range
    */
    public int rollIndividual( int dieIndex ) {
      if (count < dieIndex) {
      throw new IllegalArgumentException("position outside of diceset count");

    }
      else{
       ds[dieIndex].roll();
       return ds[dieIndex].getValue();

    }
  }

   /**
    * Gets the value of the die in this set indexed by 'dieIndex'
    * @param  dieIndex int of which die to roll
    * @trhows IllegalArgumentException if the index is out of range
    */
    public int getIndividual( int dieIndex ) {
      if (count < dieIndex ) {
      throw new IllegalArgumentException("position outside of diceset count");

      }
      else{

       return ds[dieIndex].getValue();
      }
    }

   /**
    * @return Public Instance method that returns a String representation of the DiceSet instance
    */
    public String toString() {
      String result = "";
      for (int i = 0; i < count; i++){
         result = result + ds[i].toString();
      }
      return result;
    }

   /**
    * @return Class-wide version of the preceding instance method
    */
    public static String toString( DiceSet ds ) {

       return ds.toString();
    }

   /**
    * @return  tru if this set is identical to the set passed as an argument
    */
    public boolean isIdentical( DiceSet dscheck ) {
      comparison1 = new int[count];
      comparison2 = new int[count];
      for (int i = 0; i < count; i++){
        comparison1[i] = ds[i].getValue();
        comparison2[i] = dscheck.ds[i].getValue();
      }
      Arrays.sort(comparison1);
      Arrays.sort(comparison2);
      if(Arrays.equals(comparison1, comparison2)){
        return true;
      }
      else{

       return false;
      }
    }
   /**
    * A little test main to check things out
    */
    public static void main( String[] args ) {
      DiceSet ds = new DiceSet(6, 6);
      ds.roll();
      DiceSet ds2 = new DiceSet(6, 6);
      ds2.roll();
      System.out.println("roll indivdual =" + ds.rollIndividual(1));
      System.out.println("get indivdual =" + ds.getIndividual(3));
      System.out.println("to string instance =" + ds.toString());
      System.out.println("to string class =" + toString(ds));
      System.out.println("is Identical =" + ds.isIdentical(ds2));
       // You do this part!
    }



 }
