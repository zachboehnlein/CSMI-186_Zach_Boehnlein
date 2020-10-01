/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  File name     :  Die.java
 *  Purpose       :  Provides a class describing a single die that can be rolled
 *  author       :  Zach Boehnlein
 *  Date          :  2020-09-30
 *  Description   :  This class provides the data fields and methods to describe a single game die.  A
 *                   die can have "N" sides.  Sides are randomly assigned sequential pip values, from 1
 *                   to N, with no repeating numbers.  A "normal" die would thus has six sides, with the
 *                   pip values [spots] ranging in value from one to six.  Includes the following:
 *                   public Die( int nSides );                  // Constructor for a single die with "N" sides
 *                   public int roll();                         // Roll the die and return the result
 *                   public int getValue()                      // get the value of this die
 *                   public void setSides()                     // change the configuration and return the new number of sides
 *                   public String toString()                   // Instance method that returns a String representation
 *                   public static String toString()            // Class-wide method that returns a String representation
 *                   public static void main( String args[] );  // main for testing porpoises
 *
 *  Notes         :  Restrictions: no such thing as a "two-sided die" which would be a coin, actually.
 *                   Also, no such thing as a "three-sided die" which is a physical impossibility without
 *                   having it be a hollow triangular prism shape, presenting an argument as to whether
 *                   the inner faces are faces which then should be numbered.  Just start at four for
 *                   minimum number of faces.  However, be aware that a four-sided die dosn't have a top
 *                   face to provide a value, since it's a tetrahedron [pyramid] so you'll have to figure
 *                   out a way to get the value, since it won't end up on its point.
 *
 *  Warnings      :  None
 *  Exceptions    :  IllegalArgumentException when the number of sides or pips is out of range
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
import java.util.Random;

public class Die {

  /**
   * private instance data
   */
   private int sides;
   private int pips;
   private static final int MINIMUM_SIDES = 4;

   // public constructor:
  /**
   * constructor
   * @param nSides int value containing the number of sides to build on THIS Die
   * @throws      IllegalArgumentException
   * Note: parameter must be checked for validity; invalid value must throw "IllegalArgumentException"
   */
   public Die( int nSides ) {
      if (nSides < MINIMUM_SIDES) {
      throw new IllegalArgumentException("Value too small, please put in int greater than 4");
    }
      else{
        sides = nSides;
      }

   }

  /**
   * Roll THIS die and return the result
   * @return  integer value of the result of the roll, randomly selected
   */
   public int roll() {
     Random random = new Random();
     int randDieRoll = random.nextInt(sides) + 1;
     pips = randDieRoll;
     return randDieRoll;


   }

  /**
   * Get the value of THIS die to return to the caller; note that the way
   *  the count is determined is left as a design decision to the programmer
   *  For example, what about a four-sided die - which face is considered its
   *  "value"?
   * @return the pip count of THIS die instance
   */
   public int getValue() {
      return pips;
   }

  /**
   * Public Instance method that returns a String representation of THIS die instance
   * @return String representation of this Die
   */
   public String toString() {
      return "[" + pips + "]";
   }

  /**
   * Class-wide method that returns a String representation of THIS die instance
   * @return String representation of this Die
   */
   public static String toString( Die d ) {
      return d.toString();
   }

  /**
   * A little test main to check things
   */
   public static void main( String[] args ) {
      Die bigD = new Die(6);
      bigD.roll();
      System.out.println(bigD.getValue());
      System.out.println(bigD.toString());
      System.out.println(toString(bigD));


      /**
       * test's that wont work
       */
     System.out.println( "TESTING THE DIE CLASS: TEST CONSTRUCTOR FOR INVALID NUMBERS OF SIDES:" );
     Die d = null;
     try { d = new Die( -1 ); }
     catch( IllegalArgumentException iae ) { System.out.println( "invalid sides are less than 4, please enter int sides greater than 4" ); }
     try { d = new Die( 1 ); }
     catch( IllegalArgumentException iae ) { System.out.println( "invalid sides are less than 4, please enter int sides greater than 4." ); }
     try { d = new Die( 2 ); }
     catch( IllegalArgumentException iae ) { System.out.println( "invalid sides are less than 4, please enter int sides greater than 4" ); }
     try { d = new Die( 3 ); }
     catch( IllegalArgumentException iae ) { System.out.println( "invalid sides are less than 4, please enter int sides greater than 4" ); }



      /**
       * other tests
       */
      Die d2 = new Die(5);
      d2.roll();
      System.out.println(d2.getValue());
      System.out.println(d2.toString());
      System.out.println(toString(d2));


      Die d4 = new Die(10);
      d4.roll();
      System.out.println(d4.getValue());
      System.out.println(d4.toString());
      System.out.println(toString(d4));


      Die d5 = new Die(12);
      d5.roll();
      System.out.println(d5.getValue());
      System.out.println(d5.toString());
      System.out.println(toString(d5));


      Die d8 = new Die(100);
      d8.roll();
      System.out.println(d8.getValue());
      System.out.println(d8.toString());
      System.out.println(toString(d8));


      Die d9 = new Die(75);
      d9.roll();
      System.out.println(d9.getValue());
      System.out.println(d9.toString());
      System.out.println(toString(d9));


      Die d10 = new Die(50);
      d10.roll();
      System.out.println(d10.getValue());
      System.out.println(d10.toString());
      System.out.println(toString(d10));



   }




}
