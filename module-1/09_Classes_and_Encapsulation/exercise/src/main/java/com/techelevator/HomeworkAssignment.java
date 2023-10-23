package com.techelevator;

public class HomeworkAssignment {

    private int earnedMarks;

    public int getEarnedMarks(){
        return earnedMarks;
    }

    public void setEarnedMarks(int earnedMarks){
        this.earnedMarks = earnedMarks;
    }

    private int possibleMarks;

    public int getPossibleMarks(){
        return possibleMarks;
    }

    private String submitterName;

    public String getSubmitterName(){
        return submitterName;
    }

    //constructor
    public HomeworkAssignment(int possibleMarks, String submitterName){
        this.possibleMarks = possibleMarks;
        this.submitterName = submitterName;
    }

    public String getLetterGrade(){

        double score = (earnedMarks/(double)possibleMarks)*100;
        if (score >= 90){
            return "A";
        } else if (score >= 80){
            return "B";
        } else if (score >= 70){
            return "C";
        }
        else if (score >=60){
            return "D";
        } else {
            return "F";
        }

    }

}
