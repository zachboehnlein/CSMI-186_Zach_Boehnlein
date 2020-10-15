/**
 *  File name     :  SoccerSim.java
 *  Purpose       :  Provides a class defining a soccer ball simulation
 *  @author       : Zah Boehnlein
 *  Date written  :  2020-10-144
 *  Description   :  This class models a soccer field on which a number of soccer balls are placed and
 *                   can move, and on which a pole has been set up.  The field has a "starting point",
 *                   which is used as the origin, and has an x-width and a y-width, as well as an
 *                   orientation offset in degrees, such that 0.0° corresponds to north being straight
 *                   up and down, putting due south at 180°.
 *
 *  Notes         :  From the assignment web page at:<br />
 *  <a href='http://bjohnson.lmu.build/cmsi186web/homework05.html'>http://bjohnson.lmu.build/cmsi186web/homework05.html</a><br />
 *                   Simultaneously, on a perfectly flat playground, at time 00:00:00.0 (hrs:mins:secs),
 *                   an arbitrary number of soccer balls are kicked, all at different speeds and
 *                   directions. We wish to find out, via a discrete simulation of the system, whether
 *                   a collision will ever take place, and, if so, where and when. Each ball has a
 *                   radius of 4.45 inches and weighs one pound. The center of the playground is presumed
 *                   to be the point (x,y) = (0.0,0.0). The following additional conditions apply:<br />
 *                   1) Friction acts to slow each ball down until it comes to rest.  Your program should
 *                      simulate friction as a force that continuously decreases each ball's speed at the
 *                      rate of one per cent per second until it is traveling less than one inch per
 *                      second, at which point it comes to rest.<br />
 *                   2) Data about each ball will be given to your program via four consecutive args,
 *                      namely the x- and y-coordinates of the ball's starting position [measured in
 *                      inches], followed by its speeds in the x- and y-directions [in feet per second].<br />
 *                   3) If present, a final arg specifies the time slice [in seconds].  If missing, your
 *                      program should use a default time slice of one second.<br />
 *                   4) As always, your program should check validity of the args.<br />
 *                   5) Your program should output:<br />
 *                      a) An initial report that gives the locations of all objects, including the
 *                         initial velocity of each ball<br />
 *                      b) After every time slice, a report showing the location and velocity of every ball<br />
 *                      c) A final report indicating the simulated time of the first collision, the objects
 *                         involved and their locations; or, the message NO COLLISION IS POSSIBLE, giving
 *                         the simulated time at which the program made that discovery.v
 *
 *  Warnings      :  None
 *  Exceptions    :  IllegalArgumentException when the input arguments are "hinky"
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  Revision Histor
 *  ---------------
 *            Rev      Date     Modified by:  Reason for change/modification
 *           -----  ----------  ------------  -----------------------------------------------------------
 *  @version 1.0.0  2017-03-09  B.J. Johnson  Initial writing and release
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
import java.text.DecimalFormat;

public class SoccerSim {

   private static final double DEFAULT_FIELD_WIDTH   = 1000.0;
   private static final double DEFAULT_FIELD_HEIGHT  = 1000.0;
   private static final double DEFAULT_POLE_X_POS    = 321.0;
   private static final double DEFAULT_POLE_Y_POS    = 543.0;
   private static final double DEFAULT_TIME_SLICE    = 1.0;

   private boolean  initialReport      = true;
   private boolean  stillMoving        = true;
   private boolean  timeSliceDefault   = true;
   private double   timeSlice          = DEFAULT_TIME_SLICE;
   private double   totalTimeSecs      = 0.0;
   private double[] fieldSizes         = null;
   private double[] poleLocation       = null;
   private int      ballCount          = 0;
   private double counter = 0;
   private double hours = 0;
   private double minutes = 0;
   private double seconds = 0;
   private Ball[]   soccerBalls        = null;


   private static final String USAGE_MESSAGE         = "\n  Usage:" +
         "\n    java SoccerSim <ball-parameters> ... <ball-parameters> [timeslice]" +
         "\n      where EACH <ball-parameters> field is a 4-tuple of the values:" +
         "\n            starting-x, starting-y, start-speed-x, start-speed-y" +
         "\n" +
         "\n    try running with three soccer balls: <10 10 1 1>, <18 18 -1 -1>, and <311 311 1 1>" +
         "\n    this should produce a collision between the first two balls in about four iterations." +
         "\n\n  Please try again.";

  /**
   *  constructor
   */
   public SoccerSim() {
     fieldSizes   = new double[2];
     poleLocation = new double[2];
     fieldSizes[0]   = DEFAULT_FIELD_WIDTH;
     fieldSizes[1]   = DEFAULT_FIELD_HEIGHT;
     poleLocation[0] = DEFAULT_POLE_X_POS;
     poleLocation[1] = DEFAULT_POLE_Y_POS;

   }

  /**
   *  Method to validate the input arguments
   *  @param arguments String array of the arguments supplied to the program
   */
   public void validateArgsAndSetupSim(String arguments[]) throws NumberFormatException, IllegalArgumentException {
      int ballcount = 0;

     // no arguments specified, so dispay usage message
      if( 0 == arguments.length ) {
         System.out.println( USAGE_MESSAGE);
         System.exit(0);

     // validation: if count % 4 is 1, assume last is timeslice in seconds
      } else {
         if( 1 == (arguments.length % 4)) {
           try {
              timeSlice = Double.parseDouble(arguments[arguments.length- 1]);
           }
           catch( IllegalArgumentException nfe ) {
              System.out.println("must be an double value or code will not run");
              System.out.println(USAGE_MESSAGE);
              System.exit(0);
           }

            if( 2 == (arguments.length % 4)) {
              throw new IllegalArgumentException("arguments must equal 4 for each ball and optional timeslice");

            }

             if( 3 == (arguments.length % 4)){
               throw new IllegalArgumentException("arguments must equal 4 for each ball and optional timeslice");
             }

             if(timeSlice <= 0) {
               throw new IllegalArgumentException("invalid timeslice, cannot have 0 or negative time");
             }
            else {
              timeSliceDefault = false;
            }
         }

        // now handle and validate the ball arguments
        //  also check if the timeSlice is the default value or not
         ballCount = 0;
         if( timeSliceDefault ) {
           ballCount = arguments.length / 4;

         } else {
           ballCount = (int) Math.floor(arguments.length / 4);
            }

        // next is a loop to create all the soccerBalls and put them into the array
        //  you will need to replace "true" with the proper condition
        soccerBalls = new Ball[ballCount];
        int i = 0;
        int x = 0;
         while(i < ballCount) {
           soccerBalls[i] = new Ball( Double.parseDouble(arguments[x + 0]), Double.parseDouble(arguments[x + 1]), Double.parseDouble(arguments[x + 2]), Double.parseDouble(arguments[x + 3]));


            x += 4;
            i++;
         }

      }
   }

  /**
   *  method to report the status of the simulation for every clock tick
   *  @param  c  Clock object which keeps track of time
   *  NOTE: this method calls the clock.tick() method to get one second to elapse
   */
   public void report() {
      String output = "";
      if( initialReport ) {
         initialReport = false;
         output += "\n -----REPORT INFORMATION FOR SOCCOR SIM-----";
         output += "\n pole location x is " + " " + poleLocation[0] + ", \n pole location y is "  + " " + poleLocation[1];
         output += "\n The timeslice is " + " "  + timeSlice;
         output += "\n field width is " + " " + fieldSizes[0] + ", \n field height is "  + " " + fieldSizes[1];
         for( int i = 0; i < ballCount; i++ ) {
            output += "\n ball " + (i + 1) + " " + soccerBalls[i].toString();
        //  put in some code here to output the report at time zero

      }
    }
      else {
        for(int i = 0; i < soccerBalls.length; i++) {
           output += "\n ball " + (i + 1) + " " + soccerBalls[i].toString();
        }

        // put in some code here to output the report at all other times
      }
      System.out.println(output);
   }

  /**
   *  method to move the balls in the soccerBall array
   *
   */
   public void simUpdate() {
     for(int i = 0; i < soccerBalls.length; i++) {
        soccerBalls[i].move(timeSlice);
        soccerBalls[i].setBallOutOfBounds(fieldSizes[0], fieldSizes[1]);

   }
 }

  /**
   *  method to check for a collision
   *
   */
   public int[] collisionCheck() {
      int[] ballsCollided = new int[2];
      ballsCollided[0]  = -12345678;
      ballsCollided[1]  = -12345678; //this was an important change because it felt fun to me

      for( int i = 0; i < soccerBalls.length - 1; i++ ) {
         for( int x = i + 1; x < soccerBalls.length; x++ ) {
          double distanceX =  soccerBalls[i].getCurrentPosition()[0] - soccerBalls[x].getCurrentPosition()[0];
          double distanceY =  soccerBalls[i].getCurrentPosition()[1] - soccerBalls[x].getCurrentPosition()[1];

          double distanceTotal = Math.hypot(distanceX, distanceY);

            if((distanceTotal * 12.0) <= 8.9) {
               ballsCollided[0] = i;
               ballsCollided[1] = x;
               return ballsCollided;
            }
         }
      }


      for( int i = 0; i < soccerBalls.length - 1; i++ ) {
          double distanceX =  soccerBalls[i].getCurrentPosition()[0] - DEFAULT_POLE_X_POS;
          double distanceY =  soccerBalls[i].getCurrentPosition()[1] - DEFAULT_POLE_Y_POS;

          double distanceTotal = Math.hypot(distanceX, distanceY);

            if((distanceTotal * 12.0) <= 8.9) {
               ballsCollided[0] = i;
               ballsCollided[1] = -7502;
               return ballsCollided;
             }
           }
      return ballsCollided;
   }

  /**
   *  method to check if at LEAST one ball is still moving
   *
   */
   public boolean atLeastOneBallStillMoving() {
     boolean movers = false;
     for(int i = 0; i < soccerBalls.length; i++ ) {
        if(soccerBalls[i].isStillMoving()) {
           movers = true;
        }
     }
      return movers;
   }

   // clock method taking counter and adding timeSlice

   public double clockity(){
      counter += timeSlice;
      seconds = counter % 60;
      minutes = (int)(counter / 60) % 60;
      hours = (int)(counter / 3600);

      return counter;
   }

   public String simToString(){
      DecimalFormat hours1 = new DecimalFormat("00");
      DecimalFormat minutes1 = new DecimalFormat("00");
      DecimalFormat seconds1 = new DecimalFormat("00.000");
      return "hours is" + " " + hours1.format(hours) + "minutes is" + " " + minutes1.format(minutes) + "seconds is" + " " + seconds1.format(seconds);



   }

  /**
   *  main method of the simulation
   *  @param  args  String array of the command line arguments

   */
   public static void main( String args[] ) {
      System.out.println( "\n  Hello bjohnson05, WELCOME TO MY SoccerSim program!" );
      SoccerSim ss = new SoccerSim();
      try {
         ss.validateArgsAndSetupSim( args );
      }
      catch( NumberFormatException nfe ) {
         System.out.println( USAGE_MESSAGE );
         System.exit( 1 );
      }
      catch( IllegalArgumentException iae ) {
         System.out.println( USAGE_MESSAGE );
         System.exit( 2 );
      }

      ss.report();
      int iterations = 1;             // this is optional
      int[] collision = new int[2];
      while( true ) {
           ss.clockity();  // call the "tick" method to increment the time
           ss.simUpdate();  // call the "simUpdate" method or "move" method or what have you to move all the soccer balls
           ss.report(); // call the "report" method or otherwise output the report
           collision = ss.collisionCheck(); // check for a collision

           if(collision[0] != -12345678 && collision[1] != -7502) {
             System.out.println( "ball collision between one ball " + (collision[0] + 1) + " and one ball " + (collision[1] + 1));
             System.out.println("time of incident == " + ss.simToString());
             System.out.println("ball == " + ss.soccerBalls[collision[0]].toString());

             break;
           }


            if( collision[1] == -7502) {
               System.out.println("ball collision between one ball " + (collision[0] + 1) + " and one pole" );
               System.out.println("time of incident == " + ss.simToString());
               System.out.println("ball == " + ss.soccerBalls[collision[0]].toString());

               break;
            }
            // check if any ball is still moving
            if(ss.atLeastOneBallStillMoving() == false){
              System.out.println("no collision possible ");
              System.out.println("time of end == " + ss.simToString());

              break;
            }



         iterations++;
      }
      // System.out.println( "Simulation required " + iterations + " iterations to complete." );
   }
}
