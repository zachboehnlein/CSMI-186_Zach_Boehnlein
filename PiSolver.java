/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  File name     :  PiSolver.Java
 *  Purpose       :  PiSolver code to find area of circle
 *  Author        :  Zach Boehnlein
 *  Date          :  2020-09-22

 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
*/

class PiSolver {

  public PiSolver(){
    super();
  }


  public static void main(String args[]){

    int runs=1000;
    double circleArea = 1;
    double squareArea = 1;

    if (args.length == 0){
      System.out.println("must put in integer value for runs, defaulting to 1000 runs");
    }
    else{
      try{
        runs = Integer.parseInt( args[0]);
      }
      catch(NumberFormatException nfe){
        System.out.println("Input is not integer value, input an integer to continue");
        System.exit( -1 );
      }

      }

    for (int i = 0; i < runs; i++) {

      double randx = Math.random();
      if (Math.round(Math.random()) == 1){
        randx = randx * -1;
      }
      double randy = Math.random();
      if (Math.round(Math.random()) == 1){
        randy = randy * -1;
      }


      double distance = Math.hypot(randx, randy);

      if (distance <= 1) {
        circleArea ++;
      }
    }




  double pi = ((double)circleArea / (double)runs) * 4.0;

  System.out.println("pi =" + pi);
  }
}
