import java.text.DecimalFormat;
import java.lang.Math;


public class SkateRamp {

   private double[] coeffs  = new double[]{0, 1};
   private int coeffsCheck = 0;
   private double base   = 0;
   private double height  = 0;
   private double area    = 0;
   private double lower   = 0;
   private double upper   = 0;
   private double Epi = 0;






   public SkateRamp() {
     Epi = 0.01;
   }

   public void validateArgsAndSetupSim( String arguments[] ) throws IllegalArgumentException {
     String[] possibleArgs = {"poly", "sin"};

     // no arguments specified, so dispay usage message
      if (arguments[0].equals("runMyTests")) {
        runMyTests();

      }
      // else if(arguments[0].equals("runmytests")) {
      //   testerooooooh();
      //   return true;
      // }

      else if(arguments[0].equals("poly") && 4 > arguments.length ) {
        throw new IllegalArgumentException("arguments have to be greater than 5, you need a function type, function specifications, a lowerbound, upperbound and finally an optionally an epsilon");

      }

      else if(!arguments[0].equals("poly") && 3 > arguments.length ) {
        throw new IllegalArgumentException("arguments have to be greater than 3, you need a function type, function specifications, a lowerbound, upperbound and finally an optionally an epsilon");

      }



      else if(upper < lower){
        throw new IllegalArgumentException("dog you cant have an upperbound be less than a lowerbound, what are you doing with yourself");

      }

      else if(Epi < 0){
        throw new IllegalArgumentException("Epsilon must be above 0");

      }



      else  {
            String possiblyTheEpsilon = arguments[arguments.length - 1];

            if ('%' == possiblyTheEpsilon.charAt(possiblyTheEpsilon.length()-1)) {
              try{


                Epi = Double.parseDouble(possiblyTheEpsilon.substring(0,possiblyTheEpsilon.length()-1)) / 100;
                upper = Double.parseDouble(arguments[arguments.length - 2]);
                lower = Double.parseDouble(arguments[arguments.length - 3]);
                coeffsCheck = arguments.length - 4;
                // System.out.println(lower + "lower");
                // System.out.println(upper + "upper");
                // System.out.println(Epi + "EPI");



                if(coeffsCheck > 0) {
                coeffs = new double [coeffsCheck];
                for(int i = 0; i < coeffsCheck; i++) {
                  coeffs[i] = Double.parseDouble(arguments[i+1]);



                }
              }



              }
              catch(IllegalArgumentException iae) {
                  System.out.println("type in valid numbers");
              }



              }

              else {
                try{
                upper = Double.parseDouble(arguments[arguments.length - 1]);
                lower = Double.parseDouble(arguments[arguments.length - 2]);
                coeffsCheck = arguments.length - 3;




                coeffs = new double [coeffsCheck];

                if(coeffsCheck > 0) {
                  for(int i = 0; i < coeffsCheck; i++) {
                  coeffs[i] = Double.parseDouble(arguments[i+1]);



                }
              }


              }
              catch(IllegalArgumentException iae) {
                  System.out.println("type in valid numbers");
              }


              }


            }



   }





   public double integratePoly(double[] coeffs, int N, double lower, double upper) {
     YCalculator heightCalc = new YCalculator();
     double base = ((upper - lower) / N);
     double y = lower + base;
     double x = lower;
     double midpoint = 0;
     double integrator = 0;



     for(int i = 0; i < N; i++) {
       // System.out.println("iteration " + i);
       // System.out.println("x " + x);
       // System.out.println("y " + y);
        midpoint = (x + y) / 2;
        height = heightCalc.calculateY(coeffs, midpoint);
        area = base * height;
        integrator =  integrator + area;
        x = x + base;
        y = y + base;


        // System.out.println("base " + base);
        // System.out.println("midpoin " + midpoint);
        // System.out.println("height " + height);
        // System.out.println("area " + area);
        // System.out.println("integrator " + integrator);
     }
     return integrator;

   }




   public double integrateSin(double[] coeffs, int N, double lower, double upper) {
     YCalculator heightCalc = new YCalculator();
     double base = ((upper - lower) / N);
     double y = lower + base;
     double x = lower;
     double midpoint = 0;
     double integrator = 0;



     for(int i = 0; i < N; i++) {
       // System.out.println("iteration " + i);
       // System.out.println("x " + x);
       // System.out.println("y " + y);
        midpoint = (x + y) / 2;
        height = Math.sin(heightCalc.calculateY(coeffs, midpoint));
        area = base * height;
        integrator =  integrator + area;
        x = x + base;
        y = y + base;


        // System.out.println("base " + base);
        // System.out.println("midpoin " + midpoint);
        // System.out.println("height " + height);
        // System.out.println("area " + area);
        // System.out.println("integrator " + integrator);
     }
     return integrator;

   }

   public double integrateCos(double[] coeffs, int N, double lower, double upper) {
     YCalculator heightCalc = new YCalculator();
     double base = ((upper - lower) / N);
     double y = lower + base;
     double x = lower;
     double midpoint = 0;
     double integrator = 0;



     for(int i = 0; i < N; i++) {
       // System.out.println("iteration " + i);
       // System.out.println("x " + x);
       // System.out.println("y " + y);
        midpoint = (x + y) / 2;
        height = Math.cos(heightCalc.calculateY(coeffs, midpoint));
        area = base * height;
        integrator =  integrator + area;
        x = x + base;
        y = y + base;


        // System.out.println("base " + base);
        // System.out.println("midpoin " + midpoint);
        // System.out.println("height " + height);
        // System.out.println("area " + area);
        // System.out.println("integrator " + integrator);
     }
     return integrator;

   }


   public double integrateTan(double[] coeffs, int N, double lower, double upper) {
     YCalculator heightCalc = new YCalculator();
     double base = ((upper - lower) / N);
     double y = lower + base;
     double x = lower;
     double midpoint = 0;
     double integrator = 0;



     for(int i = 0; i < N; i++) {
       // System.out.println("iteration " + i);
       // System.out.println("x " + x);
       // System.out.println("y " + y);
        midpoint = (x + y) / 2;
        height = Math.tan(heightCalc.calculateY(coeffs, midpoint));
        area = base * height;
        integrator =  integrator + area;
        x = x + base;
        y = y + base;


        // System.out.println("base " + base);
        // System.out.println("midpoin " + midpoint);
        // System.out.println("height " + height);
        // System.out.println("area " + area);
        // System.out.println("integrator " + integrator);
     }
     return integrator;

   }

   public double integrateLog(double[] coeffs, int N, double lower, double upper) {
     YCalculator heightCalc = new YCalculator();
     double base = ((upper - lower) / N);
     double y = lower + base;
     double x = lower;
     double midpoint = 0;
     double integrator = 0;



     for(int i = 0; i < N; i++) {
       // System.out.println("iteration " + i);
       // System.out.println("x " + x);
       // System.out.println("y " + y);
        midpoint = (x + y) / 2;
        height = Math.log(heightCalc.calculateY(coeffs, midpoint));
        area = base * height;
        integrator =  integrator + area;
        x = x + base;
        y = y + base;


        // System.out.println("base " + base);
        // System.out.println("midpoin " + midpoint);
        // System.out.println("height " + height);
        // System.out.println("area " + area);
        // System.out.println("integrator " + integrator);
     }
     return integrator;

   }

   public double integrateExp(double[] coeffs, int N, double lower, double upper) {
     YCalculator heightCalc = new YCalculator();
     double base = ((upper - lower) / N);
     double y = lower + base;
     double x = lower;
     double midpoint = 0;
     double integrator = 0;



     for(int i = 0; i < N; i++) {
       // System.out.println("iteration " + i);
       // System.out.println("x " + x);
       // System.out.println("y " + y);
        midpoint = (x + y) / 2;
        height = Math.exp(heightCalc.calculateY(coeffs, midpoint));
        area = base * height;
        integrator =  integrator + area;
        x = x + base;
        y = y + base;


        // System.out.println("base " + base);
        // System.out.println("midpoin " + midpoint);
        // System.out.println("height " + height);
        // System.out.println("area " + area);
        // System.out.println("integrator " + integrator);
     }
     return integrator;

   }

   public double integrateSqrt(double[] coeffs, int N, double lower, double upper) {
     YCalculator heightCalc = new YCalculator();
     double base = ((upper - lower) / N);
     double y = lower + base;
     double x = lower;
     double midpoint = 0;
     double integrator = 0;



     for(int i = 0; i < N; i++) {
       // System.out.println("iteration " + i);
       // System.out.println("x " + x);
       // System.out.println("y " + y);
        midpoint = (x + y) / 2;
        height = Math.sqrt(heightCalc.calculateY(coeffs, midpoint));
        area = base * height;
        integrator =  integrator + area;
        x = x + base;
        y = y + base;


        // System.out.println("base " + base);
        // System.out.println("midpoin " + midpoint);
        // System.out.println("height " + height);
        // System.out.println("area " + area);
        // System.out.println("integrator " + integrator);
     }
     return integrator;

   }

   public double integrateLog10(double[] coeffs, int N, double lower, double upper) {
     YCalculator heightCalc = new YCalculator();
     double base = ((upper - lower) / N);
     double y = lower + base;
     double x = lower;
     double midpoint = 0;
     double integrator = 0;



     for(int i = 0; i < N; i++) {
       // System.out.println("iteration " + i);
       // System.out.println("x " + x);
       // System.out.println("y " + y);
        midpoint = (x + y) / 2;
        height = Math.log10(heightCalc.calculateY(coeffs, midpoint));
        area = base * height;
        integrator =  integrator + area;
        x = x + base;
        y = y + base;


        // System.out.println("base " + base);
        // System.out.println("midpoin " + midpoint);
        // System.out.println("height " + height);
        // System.out.println("area " + area);
        // System.out.println("integrator " + integrator);
     }
     return integrator;

   }


   public void runMyTests() {
     System.out.println("RUNNING THESE TESTS FOR YOUR VIEWING PLEASURE SO SIT BACK, RELAX AND ENJOY THESE TESTS FOR YOUR EYES TO FEAST ON!");
     System.out.println( "\n 1) testing validateArgsAndSetupSim()");
     try {

      String arguments[] = new String[]{"poly", "1", "-2.3", "-1", "3"};
      validateArgsAndSetupSim(arguments);
      System.out.println("function is: "  + arguments[0]);
      String TestPrint = "";
      for(int i = 0; i < coeffsCheck; i++) {
        TestPrint += coeffs[i] + ", ";
      }
      System.out.println("coeffs are: " + TestPrint);
      System.out.println("upperbound is: " + upper);
      System.out.println("lower bound is: " + lower);
      System.out.println("Epsilon is: " + Epi);

     }
     catch(IllegalArgumentException iae) {
         System.out.println("error invalid");
     }


     System.out.println( "\n 2) testing poly integration: running: poly 1, -2.3, -1, 3");
     try {
       String arguments1[] = new String[]{"poly", "1", "-2.3", "-1", "3"};
       validateArgsAndSetupSim(arguments1);

       System.out.println("function is: "  + arguments1[0]);

       String TestPrint = "";
       for(int i = 0; i < coeffsCheck; i++) {
         TestPrint += coeffs[i] + ", ";
       }

       System.out.println("coeffs are: " + TestPrint);
       System.out.println("upperbound is: " + upper);
       System.out.println("lower bound is: " + lower);
       System.out.println("Epsilon is: " + Epi);
       double testPoly = integratePoly(coeffs, 1000, lower, upper);
       System.out.println("~ expect: -5.2 , got: " + testPoly);

     }
     catch(IllegalArgumentException iae) {

         System.out.println("error invalid");
       }

       System.out.println( "\n 3) testing sin integration: running: sin -.27 3.55");
       try {
         String arguments2[] = new String[]{"sin", "-.27", "3.55"};
         validateArgsAndSetupSim(arguments2);

         System.out.println("function is: "  + arguments2[0]);

         String TestPrint = "";
         for(int i = 0; i < coeffsCheck; i++) {
           TestPrint += coeffs[i] + ", ";
         }

         System.out.println("coeffs are: " + TestPrint);
         System.out.println("upperbound is: " + upper);
         System.out.println("lower bound is: " + lower);
         System.out.println("Epsilon is: " + Epi);
         double testSin = integrateSin(coeffs, 1000, lower, upper);
         System.out.println("~ expect: 1.88 , got: " + testSin);

       }
       catch(IllegalArgumentException iae) {

           System.out.println("error invalid");
         }

}






   public static void main( String arguments[] ) {
     double prevArea = -1000;
     double currentArea = 10000;
     double percentChange = 1000000;
     int N = 1;

  SkateRamp sk = new SkateRamp();
  sk.validateArgsAndSetupSim(arguments);

  if(!arguments[0].equals("runMyTests")) {



  switch(arguments[0]){
    case "poly":
    String showMeThePoly = "";
    for(int i = 0; i < sk.coeffsCheck; i++) {
      showMeThePoly += sk.coeffs[sk.coeffsCheck - i -1] + "x^" + i  + "  ";
    }
      System.out.println("poly" + "\n coeffs = " + showMeThePoly + "\n lower = " + sk.lower + "\n upper = " + sk.upper + "\n Epi = " + sk.Epi);

    while(percentChange > sk.Epi) {
      prevArea = currentArea;
      currentArea = sk.integratePoly(sk.coeffs, N, sk.lower, sk.upper);
      percentChange = Math.abs(1 - (currentArea / prevArea));
      N = N+ 1;

  }
  break;


  case "sin":
  String showMeTheSin = "";
  for(int i = 0; i < sk.coeffsCheck; i++) {
    showMeTheSin += sk.coeffs[sk.coeffsCheck - i -1] + "x^" + i  + "  ";
  }
    System.out.println("sin" + "\n coeffs = " + showMeTheSin + "\n lower = " + sk.lower + "\n upper = " + sk.upper + "\n Epi = " + sk.Epi);

  while(percentChange > sk.Epi) {
    prevArea = currentArea;
    currentArea = sk.integrateSin(sk.coeffs, N, sk.lower, sk.upper);
    percentChange = Math.abs(1 - (currentArea / prevArea));
    N = N+ 1;

}

break;


case "cos":
String showMeTheCos = "";
for(int i = 0; i < sk.coeffsCheck; i++) {
  showMeTheCos += sk.coeffs[sk.coeffsCheck - i -1] + "x^" + i  + "  ";
}
  System.out.println("sin" + "\n coeffs = " + showMeTheCos + "\n lower = " + sk.lower + "\n upper = " + sk.upper + "\n Epi = " + sk.Epi);

while(percentChange > sk.Epi) {
  prevArea = currentArea;
  currentArea = sk.integrateCos(sk.coeffs, N, sk.lower, sk.upper);
  percentChange = Math.abs(1 - (currentArea / prevArea));
  N = N+ 1;

}

break;

case "tan":
String showMeTheTan = "";
for(int i = 0; i < sk.coeffsCheck; i++) {
  showMeTheTan += sk.coeffs[sk.coeffsCheck - i -1] + "x^" + i  + "  ";
}
  System.out.println("tan" + "\n coeffs = " + showMeTheTan + "\n lower = " + sk.lower + "\n upper = " + sk.upper + "\n Epi = " + sk.Epi);

while(percentChange > sk.Epi) {
  prevArea = currentArea;
  currentArea = sk.integrateTan(sk.coeffs, N, sk.lower, sk.upper);
  percentChange = Math.abs(1 - (currentArea / prevArea));
  N = N+ 1;

}
break;

case "log":
String showMeTheLog = "";
for(int i = 0; i < sk.coeffsCheck; i++) {
  showMeTheLog += sk.coeffs[sk.coeffsCheck - i -1] + "x^" + i  + "  ";
}
  System.out.println("tan" + "\n coeffs = " + showMeTheLog + "\n lower = " + sk.lower + "\n upper = " + sk.upper + "\n Epi = " + sk.Epi);

while(percentChange > sk.Epi) {
  prevArea = currentArea;
  currentArea = sk.integrateLog(sk.coeffs, N, sk.lower, sk.upper);
  percentChange = Math.abs(1 - (currentArea / prevArea));
  N = N+ 1;

}
break;


case "exp":
String showMeTheExp = "";
for(int i = 0; i < sk.coeffsCheck; i++) {
  showMeTheExp += sk.coeffs[sk.coeffsCheck - i -1] + "x^" + i  + "  ";
}
  System.out.println("tan" + "\n coeffs = " + showMeTheExp + "\n lower = " + sk.lower + "\n upper = " + sk.upper + "\n Epi = " + sk.Epi);

while(percentChange > sk.Epi) {
  prevArea = currentArea;
  currentArea = sk.integrateExp(sk.coeffs, N, sk.lower, sk.upper);
  percentChange = Math.abs(1 - (currentArea / prevArea));
  N = N+ 1;

}
break;



case "sqrt":
String showMeTheSqrt = "";
for(int i = 0; i < sk.coeffsCheck; i++) {
  showMeTheSqrt += sk.coeffs[sk.coeffsCheck - i -1] + "x^" + i  + "  ";
}
  System.out.println("sqrt" + "\n coeffs = " + showMeTheSqrt + "\n lower = " + sk.lower + "\n upper = " + sk.upper + "\n Epi = " + sk.Epi);

while(percentChange > sk.Epi) {
  prevArea = currentArea;
  currentArea = sk.integrateSqrt(sk.coeffs, N, sk.lower, sk.upper);
  percentChange = Math.abs(1 - (currentArea / prevArea));
  N = N+ 1;

}
break;

case "log10":
String showMeTheLog10 = "";
for(int i = 0; i < sk.coeffsCheck; i++) {
  showMeTheLog10 += sk.coeffs[sk.coeffsCheck - i -1] + "x^" + i  + "  ";
}
  System.out.println("log10" + "\n coeffs = " + showMeTheLog10 + "\n lower = " + sk.lower + "\n upper = " + sk.upper + "\n Epi = " + sk.Epi);

while(percentChange > sk.Epi) {
  prevArea = currentArea;
  currentArea = sk.integrateLog10(sk.coeffs, N, sk.lower, sk.upper);
  percentChange = Math.abs(1 - (currentArea / prevArea));
  N = N+ 1;

}
break;



}

//   while(percentChange > sk.Epi) {
//     // System.out.println(currentArea);
//     // System.out.println(prevArea);
//     // System.out.println(percentChange);
//     // System.out.println(N);
//     prevArea = currentArea;
//     currentArea = sk.integratePoly(sk.coeffs, N, sk.lower, sk.upper);
//     percentChange = Math.abs(1 - (currentArea / prevArea));
//     N = N+ 1 ;
//
//    }
// //   double[] array = new double []{0, 8, -2};
// //  System.out.println(sk.integration(array, 3, 1, 4));

   System.out.println("Current Area: " + currentArea);
   System.out.println("Current Area * 3: " + (currentArea * 3));
 }



  }


}
