/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  File name     :  HighRoll.java
 *  Purpose       :  Demonstrates the use of input from a command line for use with Yahtzee
 *  Author        : Zach Boehnlein
 *  Date          :  2020-09-30
 *  Description   :
 *  Notes         :  None
 *  Warnings      :  None
 *  Exceptions    :  None
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.*;



public class HighRoll{



   public static void main( String args[] ) {
      int yourscore = 0;
      DiceSet ds = new DiceSet(4, 10);
      System.out.println( "\n   Welcome to the HighRoll Demo!!\n" );
      int count = Integer.parseInt(args[0]);
      int sides = Integer.parseInt(args[1]);
      ds = new DiceSet(count, sides);


     // This line uses the two classes to assemble an "input stream" for the user to type
     // text into the program
      BufferedReader input = new BufferedReader( new InputStreamReader( System.in ) );
      while( true ) {
         System.out.println( "Welcome to the DiceGame" );
         System.out.println( "input 1 to ROLL ALL THE DICE" );
         System.out.println( "input 2 ROLL A SINGLE DIE" );
         System.out.println( "input 3 CALCULATE THE SCORE FOR THIS SET" );
         System.out.println( "input 4 SAVE THIS SCORE AS HIGH SCORE" );
         System.out.println( "input 5 DISPLAY THE HIGH SCORE" );
         System.out.println( "ENTER 'Q' TO QUIT THE PROGRAM" );


         System.out.print( "prompt >>" );
         String inputLine = null;
         try {
            inputLine = input.readLine();
            if( 0 == inputLine.length() ) {
               System.out.println("enter some text!:");
            }
            System.out.println( "   You typed: " + inputLine );

            if( '1' == inputLine.charAt(0) ) {
               ds.roll();
               System.out.println("you rolled " + ds.toString());
            }

            if('2' == inputLine.charAt(0)){
              String[] splitthisarrayplz = inputLine.split(" ");
              System.out.println("first split " + splitthisarrayplz[0]);
              System.out.println("second split " + splitthisarrayplz[1]);
              int abc = Integer.parseInt(splitthisarrayplz[1]);
              ds.rollIndividual(abc);
              System.out.println("individual roll is " + ds.getIndividual(abc));
              System.out.println("the dice set shows " + ds.toString());
            }

            if( '3' == inputLine.charAt(0) ) {
             System.out.println("the dice set shows " + ds.toString());
             System.out.println("the sum is " + ds.sum());

           }

           if( '4' == inputLine.charAt(0) ) {
            System.out.println("the dice set shows " + ds.toString());
            yourscore = ds.sum();
            }
           if( '5' == inputLine.charAt(0) ) {

            System.out.println("the high score is " + yourscore);

            }

           if( 'q' == inputLine.charAt(0) ) {
             break;
           }

      }
      catch( IOException ioe ) {
         System.out.println( "Caught IOException" );
      }
   }
 }
}
