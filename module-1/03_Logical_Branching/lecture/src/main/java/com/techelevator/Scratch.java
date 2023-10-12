package com.techelevator;

public class Scratch {

    public static void main(String[] args) {

        boolean trueVal = true;
        boolean falseVal = false;

        //AND Requires everything to be true in order to result in a true value
        boolean andVal = trueVal && falseVal;
        System.out.println(andVal);

        boolean andVal2 = trueVal && trueVal;
        System.out.println(andVal2);

        //OR requires just one to be true in order to result in a true value
        boolean orVal = trueVal || falseVal;
        System.out.println(orVal);

        boolean orVal2 = falseVal || falseVal;
        System.out.println(orVal2);

        //someone can drive if they are 15 and have a permit and a licensed driver is with them
        //otherwise if you're 18 you just need a permit
        //or if you already have a license you are good regardless of age
        int driverAge = 15;
        boolean licensedDriverWThem = false;
        boolean hasPermit = true;
        boolean hasLicense = false;
        /*
        boolean age15WPermitAndDriver = (driverAge >= 15) && (hasPermit && licensedDriverWThem);
        boolean age18WPermit = (driverAge >= 18) && hasPermit;

        boolean canDrive = age15WPermitAndDriver || age18WPermit || hasLicense;

        System.out.println("Can Drive? " + canDrive);
        */
        isAbleToDrive(15,true,false,false);

    }

    public static boolean isAbleToDrive(int driverAge, boolean licensedDriverWThem, boolean hasPermit, boolean hasLicense) {
        boolean age15WPermitAndDriver = (driverAge >= 15) && (hasPermit && licensedDriverWThem);
        boolean age18WPermit = (driverAge >= 18) && hasPermit;

        boolean canDrive = age15WPermitAndDriver || age18WPermit || hasLicense;


        //for if statement:
        //step 1: write the if keyword
        //step 2: define the condition wrapped in a single set of parentheses
        //step 3: put a code block {curly braces} after the parentheses
        //step 4: then you can add an else or else if depending on your logic
        //NOTE: only one code block will be selected to run
        if(canDrive){
            return true;
        }
        else if(hasLicense){
            return true;
        }
        else {
            return false;
        }

        //System.out.println("Can Drive? " + canDrive);
        //return canDrive;
    }

    public char grade(int score){

        if(score >= 90) {
            return 'A';
        } else if (score >- 80){
            return 'B';
        }

    }

}
