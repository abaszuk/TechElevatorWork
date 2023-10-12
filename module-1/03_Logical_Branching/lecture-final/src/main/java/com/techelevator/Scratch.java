package com.techelevator;

public class Scratch {

    public static void main(String[] args) {

        boolean trueVal = true;
        boolean falseVal = false;

        //AND requires everything to be true in order to result in a true value
        boolean andVal = trueVal && falseVal;
        System.out.println(andVal);

        boolean andVal2 = trueVal && trueVal;
        System.out.println(andVal2);

        //OR requires just one to be true in order to result in a true value
        boolean orVal = trueVal || falseVal;
        System.out.println(orVal);

        boolean orVal2 = falseVal || falseVal;
        System.out.println(orVal2);

        //Someone can drive if they are 15 or older and have a permit and a licensed driver is with them
        //otherwise if you're 18 you just need a permit
        //or if you already have a license you are good regardless of age
        //int driverAge = 16;
        boolean licensedDriverWThem = false;
        boolean hasPermit = true;
        boolean hasLicense = true;

        /*
        boolean age15WPermitAndDriver = (driverAge >= 15) && hasPermit && licensedDriverWThem;
        boolean age18WPermit = (driverAge >= 18) && hasPermit;

        boolean canDrive = age15WPermitAndDriver || age18WPermit || hasLicense;

        System.out.println("Can Drive? " + canDrive);
        */

      isAbleToDrive(15, true, true, false);
      isAbleToDrive(18, false, false, false);
      isAbleToDrive(50, false, false, true);


      //curly braces indicate code blocks
        // think of code blocks sort of like their own cinematic universe
        {
            String spiderMan = "Tobey Maguire";
            System.out.println(spiderMan);
        }
        {
            String spiderMan = "Andrew Garfield";
            System.out.println(spiderMan);
        }
        {
            String spiderMan = "Tom Holland";

            //we can nest code blocks within code blocks
            //note: because spiderMan was declared in the outer code block he will still have scope in the nested
            {
                System.out.println(spiderMan);
            }
        }

        //System.out.println(spiderMan);
        int val = 17;
        boolean result = isAbleToDrive( 15, true, true, false);
        isAbleToDrive(18, false, false, false);
        isAbleToDrive(50, false, false, true);


        char earnedGrade = grade(64);
        System.out.println(earnedGrade);
    }

    public static char grade(int score){

        if(score >= 90) {
            return 'A';
        } else if(score >= 80){
            return 'B';
        } else if(score >= 70){
            return 'C';
        } else if(score >= 60){
            return 'D';
        } else {
            return 'F';
        }
    }

    public static boolean isAbleToDrive(int driverAge, boolean licensedDriverWThem, boolean hasPermit, boolean hasLicense){



        boolean age15WPermitAndDriver = (driverAge >= 15) && hasPermit && licensedDriverWThem;
        boolean age18WPermit = (driverAge >= 18) && hasPermit;

        boolean canDrive = age15WPermitAndDriver || age18WPermit ;

        // For if statements:
        //Step 1: write the if keyword
        //Step 2: Define the condition wrapped in a single set of parentheses
        //Step 3: Put a code block (curly braces) after the parentheses
        //Step 4: Then you can add an else or else if depending on your logic
        //NOTE: Only one code block will be selected to run
        if(canDrive || hasLicense) {
            System.out.println("Can drive!");
            return true;
        }
        else {
            System.out.println("Can't drive!");
            return false;
        }

       // System.out.println("Can Drive? " + canDrive);
       // return canDrive;
    }




}


