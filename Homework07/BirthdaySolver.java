
import java.util.Arrays;
import java.text.DecimalFormat;
import java.io.IOException;





public class BirthdaySolver {

  private int n = 0;
  private int N = 0;




  /**
   *  Constructor takes a string and assigns it to the internal storage, checks for a sign character
   *   @param value String value to make into a birthdaySolver
   *   @throws IllegalArgumentException if not integer
   *
   */
   public BirthdaySolver( String value[] ) {

     try {

     if(value.length <= 0 | value.length > 2){
       System.out.println( "one or two arguments only plz");
       throw new IllegalArgumentException();

          }

        }

          catch( IllegalArgumentException iae ) {

            System.out.println( "plz fix the error in your argument, remember integers only!");

                 System.exit( 8 );
                }

    try {
     if(value.length == 1) {
       N = 100000;

       n = Integer.parseInt(value[0]);


       if(n<= 0){

         System.out.println( "your n or the number of people needs to be greater than 0 for this program to work");
         throw new IllegalArgumentException();
       }
     }

   }

   catch( IllegalArgumentException iae ) {

     System.out.println( "plz fix the error in your argument, remember integers only!");

          System.exit( 8 );
         }


     try {
    if(value.length == 2) {
      n = Integer.parseInt(value[0]);
      N = Integer.parseInt(value[1]);
      if(n<= 0 | N<= 0){
        System.out.println( "your n or the number of people and your N or number of experiments needs to be greater than 0 for this program to work");
        throw new IllegalArgumentException();
      }

        if(N > 1000000) {
              System.out.println("hold up this may take a sec to run");

        }
     }

   }
   catch( IllegalArgumentException iae ) {

     System.out.println( "plz fix the error in your argument, remember integers only!");

          System.exit( 8 );
         }





    }

      /**
       *  theoretical Probability it calculates the probaility using an equation given
       *   @return string returns the string value of the theoretical Probability
       *
       *
       */

     public String theoreticalProbability(){
       int down = 365 - n;
       double P = 0.0;
       double Q = 1.0;
       for(int z = 365; z > down; z--){
         Q = Q * (double)z/365.0;

      }
       P = 1.0 - Q;
       P = P * 100;

       String s = String.valueOf(P) + "%";

       return s;


     }

     /**
      *  non-theoretical Probability it calculates the probaility using approximation
      *   @return string returns the string value of the non-theoretical Probability
      *
      *
      */


     public String nontheoreticalProbability(){
      int counter = 0;
      // int[] Array = {};
      int Birthdays = 0;
      int[] zach = new int[365];


      for (int a = 0; a < N; a++) {
        Birthdays = 0;

        for (int c = 0; c < 365; c++){
         zach[c] = 0;

          }
      for (int h = 0; h < n; h++ ){

         Birthdays = (int) (Math.random() * 364);



         if (zach[Birthdays] == 1){

            counter++;
            break;


             }


         else if(zach[Birthdays] == 0){
          zach[Birthdays] = 1;



        }
      }


      }


        double bubbitybop = (double)counter / (double)N;

        bubbitybop = bubbitybop * 100;

        String bubbitybop1 = String.valueOf(bubbitybop) + "%";

        return bubbitybop1;
      }




      /**
       *  main method so my code runs
       *   @param value String value to make into a birthdaySolver
       *
       *
       */


     public static void main( String value[] ) {


       BirthdaySolver Zach = new BirthdaySolver(value);

      System.out.println("theoretical Probability is: " + Zach.theoreticalProbability());
      System.out.println("Approximate Probability is: " + Zach.nontheoreticalProbability());



    }



}
