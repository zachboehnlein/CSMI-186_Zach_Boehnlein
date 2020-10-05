import java.util.Arrays;

public class DieAndDiceSetTestHarness {

  /**
   * private instance data
   */
   private int count;
   private static int countStatic;        // Just for demonstration purposes
   private int sides;
   private Die[] ds = null;               // size unknown at this point, just declare

  /**
   * A little test main to check things out
   */
   public static void main( String[] args ) {

      System.out.println( "TESTING THE DIE CLASS: TEST CONSTRUCTOR FOR INVALID NUMBERS OF SIDES:" );
      Die d = null;
      try { d = new Die( -1 ); }
      catch( IllegalArgumentException iae ) { System.out.println( "   Too few sides requested to constructor...." ); }
      try { d = new Die( 1 ); }
      catch( IllegalArgumentException iae ) { System.out.println( "   Too few sides requested to constructor...." ); }
      try { d = new Die( 2 ); }
      catch( IllegalArgumentException iae ) { System.out.println( "   Too few sides requested to constructor...." ); }
      try { d = new Die( 3 ); }
      catch( IllegalArgumentException iae ) { System.out.println( "   Too few sides requested to constructor...." ); }

      System.out.println( "TESTING THE DIE CLASS: TESTS ON 4-SIDED DIE:" );
      try { d = new Die( 4 ); }
      catch( IllegalArgumentException iae ) { System.out.println( "   Too few sides requested to constructor...." ); }
      System.out.println( "   roll() test for 4 sided die: " );
      System.out.println( "   You rolled a " + d.roll() );
      System.out.println( "   You rolled a " + d.roll() );
      System.out.println( "   You rolled a " + d.roll() );
      System.out.println( "   You rolled a " + d.roll() );
      System.out.println( "   You rolled a " + d.roll() );
      System.out.println( "   Current value is: " + d.toString() );

      System.out.println( "TESTING THE DIE CLASS: TESTS ON 5-SIDED DIE:" );
      try { d = new Die( 5 ); }
      catch( IllegalArgumentException iae ) { System.out.println( "Too few sides requested to constructor...." ); }
      System.out.println( "   roll() test for 5 sided die: " );
      System.out.println( "   You rolled a " + d.roll() );
      System.out.println( "   You rolled a " + d.roll() );
      System.out.println( "   You rolled a " + d.roll() );
      System.out.println( "   You rolled a " + d.roll() );
      System.out.println( "   You rolled a " + d.roll() );
      System.out.println( "   Current value is: " + d.toString() );

      System.out.println( "TESTING THE DIE CLASS: TESTS ON 6-SIDED DIE:" );
      try { d = new Die( 6 ); }
      catch( IllegalArgumentException iae ) { System.out.println( "Too few sides requested to constructor...." ); }
      System.out.println( "   roll() test for 6 sided die: " );
      System.out.println( "   You rolled a " + d.roll() );
      System.out.println( "   You rolled a " + d.roll() );
      System.out.println( "   You rolled a " + d.roll() );
      System.out.println( "   You rolled a " + d.roll() );
      System.out.println( "   You rolled a " + d.roll() );
      System.out.println( "   Current value is: " + d.toString() );

      System.out.println( "TESTING THE DIE CLASS: TESTS ON 7-SIDED DIE:" );
      try { d = new Die( 7 ); }
      catch( IllegalArgumentException iae ) { System.out.println( "Too few sides requested to constructor...." ); }
      System.out.println( "   roll() test for 7 sided die: " );
      System.out.println( "   You rolled a " + d.roll() );
      System.out.println( "   You rolled a " + d.roll() );
      System.out.println( "   You rolled a " + d.roll() );
      System.out.println( "   You rolled a " + d.roll() );
      System.out.println( "   You rolled a " + d.roll() );
      System.out.println( "   Current value is: " + d.toString() );

      System.out.println( "TESTING THE DIE CLASS: TESTS ON 8-SIDED DIE:" );
      try { d = new Die( 8 ); }
      catch( IllegalArgumentException iae ) { System.out.println( "Too few sides requested to constructor...." ); }
      System.out.println( "   roll() test for 8 sided die: " );
      System.out.println( "   You rolled a " + d.roll() );
      System.out.println( "   You rolled a " + d.roll() );
      System.out.println( "   You rolled a " + d.roll() );
      System.out.println( "   You rolled a " + d.roll() );
      System.out.println( "   You rolled a " + d.roll() );
      System.out.println( "   Current value is: " + d.toString() );
      // System.out.println( "   Current die side count is: " + d.getSides() );

      System.out.println( "TESTING THE DIE CLASS: TESTS ON 11-SIDED DIE USING NEW SIDE COUNT:" );
      d = new Die( 11 );
      // System.out.println( "   Resetting - current die side count is now: " + d.getSides() );
      System.out.println( "   Rolling with new side count -- " );
      System.out.println( "      You rolled a " + d.roll() );
      System.out.println( "      You rolled a " + d.roll() );
      System.out.println( "      You rolled a " + d.roll() );
      System.out.println( "      You rolled a " + d.roll() );
      System.out.println( "      You rolled a " + d.roll() );

      System.out.println( "TESTING THE DIE CLASS: TESTS ON 17-SIDED DIE USING NEW SIDE COUNT:" );
      d = new Die( 17 );
      // System.out.println( "   Resetting - current die side count is now: " + d.getSides() );
      System.out.println( "   Rolling with new side count -- " );
      System.out.println( "      You rolled a " + d.roll() );
      System.out.println( "      current value is: " + d.getValue() );

      System.out.println( "TESTING THE DIE CLASS: TESTS ON 111-SIDED DIE USING NEW SIDE COUNT:" );
      d = new Die( 111 );
      // System.out.println( "   Resetting - current die side count is now: " + d.getSides() );
      System.out.println( "   Rolling with new side count -- " );
      System.out.println( "      You rolled a " + d.roll() );
      System.out.println( "      current value is: " + d.getValue() );
      System.out.println( "......End of Die Class Testing.....\n\n" );

      System.out.println( "TESTING THE DICESET CLASS: TEST CONSTRUCTOR FOR 3 SIX-SIDED DICE:" );
      System.out.println( "  DiceSet: 3 dice, six sided - ds36:" );
      DiceSet ds36 = new DiceSet( 3, 6 );
      System.out.println( "      initialized ds36 contents             : " + ds36.toString() );
      ds36.roll();
      System.out.println( "      after collective roll ds36 contents   : " + ds36.toString() );
      ds36.rollIndividual( 2 );
      System.out.println( "      after individual roll(2) ds36 contents: " + ds36.toString() );
      System.out.println( "      sum of dice values is: " + ds36.sum() );
      System.out.println( "   Re-rolling all dice" );
      ds36.roll();
      System.out.println( "      after collective roll ds36 contents   : " + ds36.toString() );
      ds36.rollIndividual( 2 );
      System.out.println( "      after individual roll(2) ds36 contents: " + ds36.toString() );
      System.out.println( "      sum of dice values is                 : " + ds36.sum() );
      System.out.println( "   Test of getIndividual(): ");
      System.out.println( "      value of die at index 0: " + ds36.getIndividual( 0 ) );
      System.out.println( "      value of die at index 1: " + ds36.getIndividual( 1 ) );
      System.out.println( "      value of die at index 2: " + ds36.getIndividual( 2 ) );

      System.out.println( "TESTING THE DICESET CLASS: TEST CONSTRUCTOR FOR 6 NINE-SIDED DICE:" );
      System.out.println( "   DiceSet: 6 dice, nine sided - ds69:" );
      DiceSet ds69 = new DiceSet( 6, 9 );
      System.out.println( "      initialized ds36 contents             : " + ds69.toString() );
      ds69.roll();
      System.out.println( "      after collective roll ds69 contents   : " + ds69.toString() );
      ds69.rollIndividual( 2 );
      System.out.println( "      after individual roll(2) ds69 contents: " + ds69.toString() );
      System.out.println( "      sum of dice values is                 : " + ds69.sum() );
      System.out.println( "   Re-rolling all dice" );
      ds69.roll();
      System.out.println( "      after collective roll ds69 contents   : " + ds69.toString() );
      ds69.rollIndividual( 3 );
      System.out.println( "      after individual roll(3) ds69 contents: " + ds69.toString() );
      System.out.println( "      sum of dice values is                 : " + ds69.sum() );
      System.out.println( "   Test of getIndividual(): ");
      System.out.println( "      value of die at index 0: " + ds69.getIndividual( 0 ) );
      System.out.println( "      value of die at index 1: " + ds69.getIndividual( 1 ) );
      System.out.println( "      value of die at index 2: " + ds69.getIndividual( 2 ) );
      System.out.println( "      value of die at index 3: " + ds69.getIndividual( 3 ) );
      System.out.println( "      value of die at index 4: " + ds69.getIndividual( 4 ) );
      System.out.println( "      value of die at index 5: " + ds69.getIndividual( 5 ) );

      System.out.println( "TESTING THE DICESET CLASS: TEST CONSTRUCTOR FOR 9 SEVENTEEN-SIDED DICE:" );
      System.out.println( "   DiceSet: 9 dice, 17 sided - ds917:" );
      DiceSet ds917 = new DiceSet( 9, 17 );
      System.out.println( "      initialized ds36 contents              : " + ds917.toString() );
      ds917.roll();
      System.out.println( "      after collective roll ds917 contents   : " + ds917.toString() );
      ds917.rollIndividual( 6 );
      System.out.println( "      after individual roll(6) ds917 contents: " + ds917.toString() );
      System.out.println( "      sum of dice values is                  : " + ds917.sum() );
      System.out.println( "   Re-rolling all dice" );
      ds917.roll();
      System.out.println( "      after collective roll ds917 contents   : " + ds917.toString() );
      ds917.rollIndividual( 8 );
      System.out.println( "      after individual roll(8) ds69 contents : " + ds917.toString() );
      System.out.println( "      sum of dice values is                  : " + ds917.sum() );
      System.out.println( "   Test of getIndividual(): ");
      System.out.println( "      value of die at index 0: " + ds917.getIndividual( 0 ) );
      System.out.println( "      value of die at index 1: " + ds917.getIndividual( 1 ) );
      System.out.println( "      value of die at index 2: " + ds917.getIndividual( 2 ) );
      System.out.println( "      value of die at index 3: " + ds917.getIndividual( 3 ) );
      System.out.println( "      value of die at index 4: " + ds917.getIndividual( 4 ) );
      System.out.println( "      value of die at index 5: " + ds917.getIndividual( 5 ) );
      System.out.println( "      value of die at index 6: " + ds917.getIndividual( 6 ) );
      System.out.println( "      value of die at index 7: " + ds917.getIndividual( 7 ) );
      System.out.println( "      value of die at index 8: " + ds917.getIndividual( 8 ) );

      System.out.println( "TESTING THE DICESET CLASS: TEST 'isIdentical()' FOR 9 SEVENTEEN-SIDED DICE:" );
      System.out.println( "   Test of isIndentical(): " );
//      System.out.println( "      Test of ds917 against ds69   : " + ds917.isIdentical( ds69 ) );
      System.out.println( "      Test of ds917 against itself : " + ds917.isIdentical( ds917 ) );

      System.out.println( "TESTING THE DICESET CLASS: TEST 'isIdentical()' FOR NEW SET OF 9 SEVENTEEN-SIDED DICE:" );
      ds917 = new DiceSet( 9, 17 );
      DiceSet ds2_917 = new DiceSet( 9, 17 );
      ds917.roll();
      ds2_917.roll();
      System.out.println( "   DiceSet ds917 contents       : " + ds917.toString() );
      System.out.println( "      New DiceSet ds2_917 contents : " + ds2_917.toString() );
      System.out.println( "      Test of ds917 against ds2_917: " + ds917.isIdentical( ds2_917 ) );

      System.out.println( "......End of DiceSet Class Testing.....\n\n" );

   }

}

