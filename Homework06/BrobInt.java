/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * File name  :  BrobInt.java
 * Purpose    :  Learning exercise to implement arbitrarily large numbers and their operations
 * @author    :  Zach Boehnlein
 * Date       :  2017-04-04
 * Description:  @see <a href='http://bjohnson.lmu.build/cmsi186web/homework06.html'>Assignment Page</a>
 * Notes      :  None
 * Warnings   :  None
 *
 *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Revision History
 * ================
 *   Ver      Date     Modified by:  Reason for change or modification
 *  -----  ----------  ------------  ---------------------------------------------------------------------
 *  1.0.0  2017-04-04  B.J. Johnson  Initial writing and begin coding
 *  1.1.0  2017-04-13  B.J. Johnson  Completed addByt, addInt, compareTo, equals, toString, Constructor,
 *                                     validateDigits, two reversers, and valueOf methods; revamped equals
 *                                     and compareTo methods to use the Java String methods; ready to
 *                                     start work on subtractByte and subtractInt methods
 *  1.2.0  2019-04-18  B.J. Johnson  Fixed bug in add() method that was causing errors in Collatz
 *                                     sequence.  Added some tests into the main() method at the bottom
 *                                     of the file to test construction.  Also added two tests there to
 *                                     test multiplication by three and times-3-plus-1 operations
 *
 *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
import java.util.Arrays;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class BrobInt {

 public static final int chunkSize = 1;
 public int numRep[] = null;

   public static final BrobInt ZERO     = new BrobInt(  "0" );      /// Constant for "zero"
   public static final BrobInt ONE      = new BrobInt(  "1" );      /// Constant for "one"
   public static final BrobInt TWO      = new BrobInt(  "2" );      /// Constant for "two"
   public static final BrobInt THREE    = new BrobInt(  "3" );      /// Constant for "three"
   public static final BrobInt FOUR     = new BrobInt(  "4" );      /// Constant for "four"
   public static final BrobInt FIVE     = new BrobInt(  "5" );      /// Constant for "five"
   public static final BrobInt SIX      = new BrobInt(  "6" );      /// Constant for "six"
   public static final BrobInt SEVEN    = new BrobInt(  "7" );      /// Constant for "seven"
   public static final BrobInt EIGHT    = new BrobInt(  "8" );      /// Constant for "eight"
   public static final BrobInt NINE     = new BrobInt(  "9" );      /// Constant for "nine"
   public static final BrobInt TEN      = new BrobInt( "10" );      /// Constant for "ten"

  // Some constants for other intrinsic data types
  //  these can help speed up the math if they fit into the proper memory space
   public static final BrobInt MAX_INT  = new BrobInt( Integer.valueOf( Integer.MAX_VALUE ).toString() );
   public static final BrobInt MIN_INT  = new BrobInt( Integer.valueOf( Integer.MIN_VALUE ).toString() );
   public static final BrobInt MAX_LONG = new BrobInt( Long.valueOf( Long.MAX_VALUE ).toString() );
   public static final BrobInt MIN_LONG = new BrobInt( Long.valueOf( Long.MIN_VALUE ).toString() );

  /// These are the internal fields
   public  String internalValue = "";        // internal String representation of this BrobInt
   public  byte   sign          = 0;         // "0" is positive, "1" is negative
  /// You can use this or not, as you see fit.  The explanation was provided in class
   private String reversed      = "";        // the backwards version of the internal String representation

   private static BufferedReader input = new BufferedReader( new InputStreamReader( System.in ) );
   private static final boolean DEBUG_ON = false;
   private static final boolean INFO_ON  = false;

  /**
   *  Constructor takes a string and assigns it to the internal storage, checks for a sign character
   *   and handles that accordingly;  it then checks to see if it's all valid digits, and reverses it
   *   for later use
   *  @param  value  String value to make into a BrobInt
   */
   public BrobInt( String value ) {
     //System.out.println( "string value is: " + value);
     if(value.charAt(0) == '-') {
      sign = 1;
      value = value.replace("-", "");
     }
    // System.out.println( "string value after trying negative is: " + value);
     int   chunkCount = (value.length() / chunkSize) + 1;
     numRep = new int[chunkCount];
     int   index = 0;

     int   end   = value.length();
     int   start = (value.length()) - chunkSize;



     for( int i = value.length(); i >= 0; i -= chunkSize ) {
       try {

           numRep[index] = Integer.parseInt( value.substring( start, end ) );

  }

       catch( IllegalArgumentException iae ) {

           System.out.println( "dog what are you doing, I am looking for only digits in my string or a negative sign and you just gave me something that was not just digits, please get it together and write me a number so I can show you this dope code!");


           System.exit( 8 );
          }
       numRep[index] = Integer.parseInt( value.substring( start, end ) );
       //System.out.println("index: " + index + "value is: " + numRep[index]);
       start -= chunkSize;
       end -= chunkSize;
       index++;
       if( 0 == end ) {
         break;            // handles even boundary
       } else if( 0 > start ) {
         start = 0;
       }
     }
    // toArray( numRep );  System.out.println("");
    }

  /** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
   *  Method to validate that all the characters in the value are valid decimal digits
   *  @return  boolean  true if all digits are good
   *  @throws  IllegalArgumentException if something is hinky
   *  note that there is no return false, because of throwing the exception
   *  note also that this must check for the '+' and '-' sign digits
   *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
   public boolean validateDigits() throws IllegalArgumentException {
      throw new UnsupportedOperationException( "\n         Sorry, that operation is not yet implemented." );
   }


  /** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
   *  Method to add the value of a BrobIntk passed as argument to this BrobInt
   *  @param  bint         BrobInt to add to this
   *  @return BrobInt that is the sum of the value of this BrobInt and the one passed in
   *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
   public BrobInt add( BrobInt bint ) {
     int carry = 0;
     int Sumoroni = 0;
     int lilBoyArray[] = null;
     int bigBoyArray[] = null;
     int i = 0;
    String stringAnswer = "";

    if(this.numRep.length >= bint.numRep.length){
      lilBoyArray = bint.numRep;
      bigBoyArray = this.numRep;
    }
    else{
      lilBoyArray = this.numRep;
      bigBoyArray = bint.numRep;

    }

    if(this.sign != 1 && bint.sign == 1) {
      return this.subtract(bint);
    }

    if(this.sign == 1 && bint.sign != 1) {
      return bint.subtract(this);
    }

    int answer[] = new int[bigBoyArray.length];


     while(i < lilBoyArray.length) {
        Sumoroni = lilBoyArray[i] + bigBoyArray[i] + carry;

       if(Sumoroni >= 10){
        Sumoroni  = Sumoroni - 10;
        carry = 1;
       }
       else{
       carry = 0;
     }
     answer[i] = Sumoroni;

     i++;

     }

     for(int z = lilBoyArray.length; z < bigBoyArray.length; z++){
       answer[z] = bigBoyArray[z] + carry;

      carry = 0;
     }


     for(int j = answer.length -1; j >= 0; j--){
       stringAnswer += Integer.toString(answer[j]);


     }

     while(stringAnswer.charAt(0) == '0'){
       stringAnswer = stringAnswer.substring(1);

     }

     if(this.sign == 1 && bint.sign == 1) {
       stringAnswer = "-" + stringAnswer;
     }


    return new BrobInt(stringAnswer);


   }

  /** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
   *  Method to subtract the value of a BrobIntk passed as argument to this BrobInt
   *  @param  bint         BrobInt to subtract from this
   *  @return BrobInt that is the difference of the value of this BrobInt and the one passed in
   *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
   public BrobInt subtract( BrobInt bint ) {
     int borrow = 0;
     int Suboroni = 0;
     int lilBoyArray[] = null;
     int bigBoyArray[] = null;
     int i = 0;
     String stringAnswer = "";


     if(this.numRep.length >= bint.numRep.length){
       lilBoyArray = bint.numRep;
       bigBoyArray = this.numRep;
     }
     else{
       lilBoyArray = this.numRep;
       bigBoyArray = bint.numRep;

     }

     int answer[] = new int[bigBoyArray.length];


     if(this.sign == 1 && bint.sign != 1) {
       String thiss = this.toString().substring(1);
       BrobInt this1 = new BrobInt(thiss);
       BrobInt semiAnswer = this1.add(bint);
       String semiAnswer1 = "-" + semiAnswer.toString();
       return new BrobInt(semiAnswer1);


     }

     if(this.sign != 1 && bint.sign == 1) {
       String bint415 = bint.toString().substring(1);
       BrobInt bint4156 = new BrobInt(bint415);
       return bint4156.add(this);


     }





     while(i < lilBoyArray.length) {

        Suboroni = bigBoyArray[i] - lilBoyArray[i] - borrow;

       if(Suboroni < 0 && borrow == 0 ){
        Suboroni  = Suboroni + 10;

        borrow = 1;

       }
       else if(Suboroni<0 && borrow > 0){
       Suboroni = Suboroni + 10;

       borrow = 1;


     }
       else{

       borrow = 0;

     }
     answer[i] = Suboroni;


     i++;


     }

     for(int z = lilBoyArray.length; z < bigBoyArray.length; z++){

       Suboroni = bigBoyArray[z] - borrow;

       if(Suboroni < 0 && borrow == 0){
        Suboroni  = bigBoyArray[z] + 10;
        borrow = 1;

       }
       else if(Suboroni<0 && borrow > 0){
       Suboroni = bigBoyArray[z] + 10 - borrow;
       borrow = 1;

     }
       else{
       borrow = 0;

     }

     answer[z] = Suboroni;


         }


     for(int j = answer.length -1; j >= 0; j--){
       stringAnswer += Integer.toString(answer[j]);


     }

     while(stringAnswer.charAt(0) == '0'){
      stringAnswer = stringAnswer.substring(1);

     }

     if(this.sign == 1 && bint.sign == 1 && this.compareTo(bint) == -1) {
       stringAnswer = "-" + stringAnswer;

     }

     else if(this.sign == 1 && bint.sign == 1 && this.compareTo(bint) == 1) {
       String bint1s = bint.toString().substring(1);
       BrobInt bint1 = new BrobInt(bint1s);
       return bint1.subtract(this);

     }



    return new BrobInt(stringAnswer);

   }

  /** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
   *  Method to multiply the value of a BrobIntk passed as argument to this BrobInt
   *  @param  bint         BrobInt to multiply this by
   *  @return BrobInt that is the product of the value of this BrobInt and the one passed in
   *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
   public BrobInt multiply( BrobInt bint ) {
     BrobInt answer = this;
     for(BrobInt i = ONE; (i.compareTo(bint) < 0); i = i.add(ONE)){
       answer = answer.add(this);

      //System.out.println("i is " + i + "\n answer is " + answer);
     }

     return answer;

   }

  /** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
   *  Method to divide the value of this BrobIntk by the BrobInt passed as argument
   *  @param  bint         BrobInt to divide this by
   *  @return BrobInt that is the dividend of this BrobInt divided by the one passed in
   *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
   public BrobInt divide( BrobInt bint ) {
     BrobInt answer = this;
     int theActualAnswer = 0;

     while(answer.compareTo(bint) >= 0){
       if(answer.compareTo(bint) == 0){
         theActualAnswer = theActualAnswer + 1;
         break;
       }
       answer = answer.subtract(bint);
       theActualAnswer = theActualAnswer + 1;
       //System.out.println( "actual ansuwewr: " +  theActualAnswer);


     }


     return new BrobInt (Integer.toString(theActualAnswer));
   }

  /** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
   *  Method to get the remainder of division of this BrobInt by the one passed as argument
   *  @param  bint         BrobInt to divide this one by
   *  @return BrobInt that is the remainder of division of this BrobInt by the one passed in
   *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
   public BrobInt remainder( BrobInt bint ) {
      BrobInt answer = this.subtract(this.divide(bint).multiply(bint));

      return answer;
   }

  /** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
   *  Method to compare a BrobInt passed as argument to this BrobInt
   *  @param  bint  BrobInt to compare to this
   *  @return int   one of neg/0/pos if "this" BrobInt is less/equal/more than the "bint" BrobInt
   *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
   public int compareTo( BrobInt bint ) {

     // remove any leading zeros because we will compare lengths
      String me  = this.toString();
      String arg = bint.toString();

     // check if they are equal first, and return a zero if so
      if( this.equals( bint ) ) {
        return 0;
      }

     // handle the signs here
     //  if "this" is neg and "bint" is pos, "this" is smaller so return -1
      if( 1 == sign && 0 == bint.sign ) {
         return -1;

     // if "this" is pos and "bint" is neg, "this" is larger so return +1
      } else if( 0 == sign && 1 == bint.sign ) {
         return 1;
      }

     // otherwise, signs are the same, so we must check the lengths
     //  the longer one is going to be the MORE OF THAT SIGN
     //  e.g., "-1111" for "this" is more neg than "-222" for "arg" so return -1
      if( (1 == sign) && (1 == bint.sign) ) {
         if( me.length() < arg.length() ) {
            return 1;
         } else if( me.length() > arg.length() ) {
            return -1;
         }
      } else if( (0 == sign) && (0 == bint.sign) ) {
         if( me.length() < arg.length() ) {
            return -1;
         } else if( me.length() > arg.length() ) {
            return 1;
         }
      }

     // compare digit-by-digit
     // can only go to the length of the shortest if they are different lengths
      // int end = (me.length() < arg.length()) ? me.length() : arg.length();
      for( int i = 0; i < me.length(); i++ ) {
        if(this.sign == 0 && bint.sign == 0){
         if( me.charAt(i) < arg.charAt(i) ) {
            return -1;
         } else if( me.charAt(i) > arg.charAt(i) ) {
            return 1;
         }
       }

       else if(this.sign == 1 && bint.sign == 1){
        if( me.charAt(i) < arg.charAt(i) ) {
           return 1;
        } else if( me.charAt(i) > arg.charAt(i) ) {
           return -1;
        }
      }

      }
      return 0;      // if it gets here, just assume equality to fool the compiler
   }

  /** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
   *  Method to check if a BrobInt passed as argument is equal to this BrobInt
   *  @param  bint     BrobInt to compare to this
   *  @return boolean  that is true if they are equal and false otherwise
   *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
   public boolean equals( BrobInt bint ) {
      return ( (sign == bint.sign) && (this.toString().equals( bint.toString() )) );
   }

  /** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
   *  Method to return a BrobInt given a long value passed as argument
   *  @param  value    long type number to make into a BrobInt
   *  @return BrobInt  which is the BrobInt representation of the long
   *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
   public static BrobInt valueOf( long value ) throws NumberFormatException {
      BrobInt bi = null;
      try { bi = new BrobInt( Long.valueOf( value ).toString() ); }
      catch( NumberFormatException nfe ) { throw new NumberFormatException( "\n  Sorry, the value must be numeric of type long." ); }
      return bi;
   }

  /** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
   *  Method to return a String representation of this BrobInt
   *  @return String  which is the String representation of this BrobInt
   *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
   public String toString() {
     //BrobInt b1 = this.removeLeadingZeros(); not working :(

      internalValue = "";

       for( int i = (numRep.length - 1); i >= 0; i--){
         internalValue += Integer.toString(numRep[i]);
       }
       if(internalValue.equals("0")){
         internalValue = "0";
       }
       else{
       while(internalValue.charAt(0) == '0'){

         internalValue = internalValue.substring(1);
       }

       }

       if( sign == 1) {
         internalValue = '-' + internalValue;
       }

      return internalValue;
   }

  /** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
   *  Method to remove leading zeros from a BrobInt passed as argument
   *  @param  bint     BrobInt to remove zeros from
   *  @return BrobInt that is the argument BrobInt with leading zeros removed
   *  Note that the sign is preserved if it exists
   *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
   public BrobInt removeLeadingZeros( BrobInt bint ) {
      Character sign = null;
      String returnString = bint.toString();
      int index = 0;

      if( allZeroDetect( bint ) ) {
         return bint;
      }
      if( ('-' == returnString.charAt( index )) || ('+' == returnString.charAt( index )) ) {
         sign = returnString.charAt( index );
         index++;
      }
      if( returnString.charAt( index ) != '0' ) {
         return bint;
      }

      while( returnString.charAt( index ) == '0' ) {
         index++;
      }
      returnString = bint.toString().substring( index, bint.toString().length() );
      if( sign != null ) {
         returnString = sign.toString() + returnString;
      }
      return new BrobInt( returnString );

   }

  /** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
   *  Method to return a boolean if a BrobInt is all zeros
   *  @param  bint     BrobInt to compare to this
   *  @return boolean  that is true if the BrobInt passed is all zeros, false otherwise
   *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
   public boolean allZeroDetect( BrobInt bint ) {
      for( int i = 0; i < bint.toString().length(); i++ ) {
         if( bint.toString().charAt(i) != '0' ) {
            return false;
         }
      }
      return true;
   }

  /** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
   *  Method to display an Array representation of this BrobInt as its bytes
   *  @param   d  byte array from which to display the contents
   *  NOTE: may be changed to int[] or some other type based on requirements in code above
   *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
   public void toArray( int[] d ) {
      System.out.println( "Array contents: " + Arrays.toString( d ) );
   }

  /** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
   *  Method to display a prompt for the user to press 'ENTER' and wait for her to do so
   *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
   public void pressEnter() {
      String inputLine = null;
      try {
         System.out.print( "      [Press 'ENTER' to continue]: >> " );
         inputLine = input.readLine();
      }
      catch( IOException ioe ) {
         System.out.println( "Caught IOException" );
      }

   }

  /** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
   *  the main method redirects the user to the test class
   *  @param  args  String array which contains command line arguments
   *  NOTE:  we don't really care about these, since we test the BrobInt class with the BrobIntTester
   *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
   public static void main( String[] args ) {
      System.out.println( "\n  Hello, world, from the BrobInt program!!\n" );
      System.out.println( "\n   You should run your tests from the BrobIntTester, but here are a few...\n" );

      BrobInt b1 = null;;
      System.out.println("test that should try and catch some stuff becasue it is wrong");
      try { System.out.println( "   Making a new BrobInt: " ); b1 = new BrobInt( "5" ); }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.toString() ); }
      try { System.out.println( "   expecting: 5\n     and got: " + b1.toString() ); }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.toString() ); }

      BrobInt b2 = null;;
      try { System.out.println( "   Making a new BrobInt: " ); b2 = new BrobInt( "-6" ); }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.toString() ); }
      try { System.out.println( "   expecting: -6\n     and got: " + b2.toString() ); }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.toString() ); }

      BrobInt b3 = b1.subtract(b2);
      System.out.println("subtraction answer: " + b3.toString());


      System.out.println("test but this time work");
      try { System.out.println( "   Making a new BrobInt: " ); b1 = new BrobInt( "-21" ); }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.toString() ); }
      try { System.out.println( "   expecting: -21\n     and got: " + b1.toString() ); }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.toString() ); }

      try { System.out.println( "   Making a new BrobInt: " ); b2 = new BrobInt( "2" ); }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.toString() ); }
      try { System.out.println( "   expecting: 2\n     and got: " + b2.toString() ); }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.toString() ); }

      b3 = b1.add(b2);
      System.out.println("addition answer: " + b3.toString());

      System.out.println("test again");
      try { System.out.println( "   Making a new BrobInt: " ); b1 = new BrobInt( "912803567789235" ); }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.toString() ); }
      try { System.out.println( "   expecting: 912803567789235\n     and got: " + b1.toString() ); }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.toString() ); }

      try { System.out.println( "   Making a new BrobInt: " ); b2 = new BrobInt( "12470680913467" ); }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.toString() ); }
      try { System.out.println( "   expecting: 12470680913467\n     and got: " + b2.toString() ); }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.toString() ); }

      b3 = b1.add(b2);
      System.out.println("addition answer: " + b3.toString());

      System.out.println("testery");
      try { System.out.println( "   Making a new BrobInt: " ); b1 = new BrobInt( "-2" ); }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.toString() ); }
      try { System.out.println( "   expecting: -2\n     and got: " + b1.toString() ); }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.toString() ); }

      try { System.out.println( "   Making a new BrobInt: " ); b2 = new BrobInt( "-4" ); }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.toString() ); }
      try { System.out.println( "   expecting: -4\n     and got: " + b2.toString() ); }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.toString() ); }

      b3 = b1.add(b2);
      System.out.println("addition answer: " + b3.toString());

      System.out.println("TESTostrone");
      try { System.out.println( "   Making a new BrobInt: " ); b1 = new BrobInt( "-1235" ); }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.toString() ); }
      try { System.out.println( "   expecting: -1235\n     and got: " + b1.toString() ); }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.toString() ); }

      try { System.out.println( "   Making a new BrobInt: " ); b2 = new BrobInt( "-15" ); }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.toString() ); }
      try { System.out.println( "   expecting: -15\n     and got: " + b2.toString() ); }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.toString() ); }

      b3 = b1.add(b2);
      System.out.println("addition answer: " + b3.toString());

      System.out.println("plz test");
      try { System.out.println( "   Making a new BrobInt: " ); b1 = new BrobInt( "5" ); }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.toString() ); }
      try { System.out.println( "   expecting: 5\n     and got: " + b1.toString() ); }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.toString() ); }

      try { System.out.println( "   Making a new BrobInt: " ); b2 = new BrobInt( "3" ); }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.toString() ); }
      try { System.out.println( "   expecting: 3\n     and got: " + b2.toString() ); }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.toString() ); }

      b3 = b1.multiply(b2);
      System.out.println("multiplication answer: " + b3.toString());

      System.out.println("don't get testy with me");
      try { System.out.println( "   Making a new BrobInt: " ); b1 = new BrobInt( "233" ); }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.toString() ); }
      try { System.out.println( "   expecting: 233\n     and got: " + b1.toString() ); }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.toString() ); }

      try { System.out.println( "   Making a new BrobInt: " ); b2 = new BrobInt( "765" ); }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.toString() ); }
      try { System.out.println( "   expecting: 765\n     and got: " + b2.toString() ); }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.toString() ); }

      b3 = b1.multiply(b2);
      System.out.println("multiplication answer: " + b3.toString());

      System.out.println("tester");
      try { System.out.println( "   Making a new BrobInt: " ); b1 = new BrobInt( "765" ); }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.toString() ); }
      try { System.out.println( "   expecting: 765\n     and got: " + b1.toString() ); }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.toString() ); }

      try { System.out.println( "   Making a new BrobInt: " ); b2 = new BrobInt( "233" ); }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.toString() ); }
      try { System.out.println( "   expecting: 233\n     and got: " + b2.toString() ); }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.toString() ); }

      b3 = b1.subtract(b2);
      System.out.println("subtraction answer: " + b3.toString());

      System.out.println("TEST");
      try { System.out.println( "   Making a new BrobInt: " ); b1 = new BrobInt( "-5" ); }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.toString() ); }
      try { System.out.println( "   expecting: -5\n     and got: " + b1.toString() ); }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.toString() ); }

      try { System.out.println( "   Making a new BrobInt: " ); b2 = new BrobInt( "3" ); }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.toString() ); }
      try { System.out.println( "   expecting: 3\n     and got: " + b2.toString() ); }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.toString() ); }

      b3 = b1.subtract(b2);
      System.out.println("subtraction answer: " + b3.toString());

      System.out.println("test");
      try { System.out.println( "   Making a new BrobInt: " ); b1 = new BrobInt( "5" ); }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.toString() ); }
      try { System.out.println( "   expecting: 5\n     and got: " + b1.toString() ); }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.toString() ); }

      try { System.out.println( "   Making a new BrobInt: " ); b2 = new BrobInt( "-3" ); }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.toString() ); }
      try { System.out.println( "   expecting: -3\n     and got: " + b2.toString() ); }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.toString() ); }

      b3 = b1.subtract(b2);
      System.out.println("subtraction answer: " + b3.toString());

      System.out.println("test");
      try { System.out.println( "   Making a new BrobInt: " ); b1 = new BrobInt( "-5" ); }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.toString() ); }
      try { System.out.println( "   expecting: -5\n     and got: " + b1.toString() ); }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.toString() ); }

      try { System.out.println( "   Making a new BrobInt: " ); b2 = new BrobInt( "-3" ); }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.toString() ); }
      try { System.out.println( "   expecting: -3\n     and got: " + b2.toString() ); }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.toString() ); }

      b3 = b1.subtract(b2);
      System.out.println("subtraction answer: " + b3.toString());

      System.out.println("test");
      try { System.out.println( "   Making a new BrobInt: " ); b1 = new BrobInt( "10" ); }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.toString() ); }
      try { System.out.println( "   expecting: 10\n     and got: " + b1.toString() ); }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.toString() ); }

      try { System.out.println( "   Making a new BrobInt: " ); b2 = new BrobInt( "5" ); }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.toString() ); }
      try { System.out.println( "   expecting: 5\n     and got: " + b2.toString() ); }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.toString() ); }

      b3 = b1.divide(b2);
      System.out.println("division answer: " + b3.toString());



      System.exit( 0 );

   }
}
