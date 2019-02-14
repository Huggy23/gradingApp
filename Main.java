//***************************************************************************************************************************************
// gradingApp.java                                        Author: Jason Huggy						Date Created: 2/11/2019
//
// This application allows a teacher to input the grades for a student on four tests and four assignments, and then calculates the 
//     total grade. The class average and standard deviation are utilized to then perform a "curve" on the student's final
//     grade. 
//***************************************************************************************************************************************

import java.util.Scanner;
import static java.lang.Math.*;
import java.util.stream.IntStream;

public class Main {

	public static void main(String[] args) {
		
	
int exam1 = -1, exam2 = -1, exam3 = -1, exam4 = -1, assgn1 = -1, assgn2 = -1, assgn3 = -1, assgn4 = -1;

	    
	  
	    
//**************************************************************************************************************  
// This allows for the user to input the student's grade on the assignment/test. An incorrect input will result
//    in loop and the user will be asked to input the grade again. This is done for all tests and assignments. 
//**************************************************************************************************************

	Scanner scan = new Scanner(System.in); 
	
	   while (exam1 < 0 || exam1 > 50) { 
		   System.out.println("Enter student's score for Exam #1 (0 - 50) ");
		   exam1 = scan.nextInt(); }
	   
	   while (exam2 < 0 || exam2 > 50) {
		   System.out.println("Enter student's score for Exam #2 (0 - 50) ");
		   exam2 = scan.nextInt(); }
	  
	    while (exam3 < 0 || exam3 > 50) { 
	    	System.out.println("Enter student's score for Exam #3 (0 - 50) ");
	    	exam3 = scan.nextInt(); }
	    
       while (exam4 < 0 || exam4 > 50) {
	        System.out.println("Enter student's score for Exam #4 (0 - 50) ");
	        exam4 = scan.nextInt(); }
	  
	   while (assgn1 < 0 || assgn1 >75) {
	    	System.out.println("Enter student's score for Assignment #1 (0 - 75) ");
	    	assgn1 = scan.nextInt(); }
	    
	   while (assgn2 < 0 || assgn2 >75) {
	    	System.out.println("Enter student's score for Assignment #2 (0 - 75) ");
	    	assgn2 = scan.nextInt(); }
	     
	   while (assgn3 < 0 || assgn3 >75) {
	    	System.out.println("Enter student's score for Assignment #3 (0 - 75) ");
	    	assgn3 = scan.nextInt(); }
	     
	   while (assgn4 < 0 || assgn4 >75) {
	    	System.out.println("Enter student's score for Assignment #4 (0 - 75) ");
	    	assgn4 = scan.nextInt(); }

//***********************************************************************************
// Calculates the sum of all of the exams and assignments graded. Not weighted.  
//***********************************************************************************
	   int sum = exam1 + exam2 + exam3 + exam4 + assgn1 + assgn2 + assgn3 + assgn4; 
        

//***********************************************************************************
// Compares the student's total points to the initial grading terms. (No curve) 
//***********************************************************************************
    	if (isBetween(sum, 450, 500)) {
    		System.out.println("Grade before curve is: A");
    	}
            
    	else if (isBetween(sum, 400, 449)) {    
            System.out.println("Grade before curve is: B");
    	} 
        else if (isBetween(sum, 350, 399)) {    
            System.out.println("Grade before curve is: C");
        }       
            
        else if (isBetween(sum, 300, 349)) {    
            System.out.println("Grade before curve is: D");
        }       
            
        else { 
            System.out.println("Grade before curve is: F");
        }
  
//***************************************************************************************************   	
// Change the following point totals of the other 10 students if a new "curve" is to be determined.
//***************************************************************************************************
    	int[] grades = {400, 350, 370, 280, 300, 290, 310, 340, 350, 330};
    
//***************************************************************************************************   	
// Determines the Standard Deviation of the Class' grades. To be used to determine "curve". 
//***************************************************************************************************    
    	double stdMath = (Math.pow(grades[0]-(mean(grades)), 2)) + (Math.pow(grades[1]-(mean(grades)), 2)) + (Math.pow(grades[2]-(mean(grades)), 2)) +
    			(Math.pow(grades[3]-(mean(grades)), 2)) + (Math.pow(grades[4]-(mean(grades)), 2)) + (Math.pow(grades[5]-(mean(grades)), 2)) +
    			(Math.pow(grades[6]-(mean(grades)), 2)) + (Math.pow(grades[7]-(mean(grades)), 2)) + (Math.pow(grades[8]-(mean(grades)), 2)) +
    			(Math.pow(grades[9]-(mean(grades)), 2));
    	
    	
    	double stdDev = sqrt(stdMath / grades.length); 
    	
//***************************************************************************************************   	
// Creates the new grading standards with the "curve" accounted for and prints updated grade. 
//***************************************************************************************************
    	
    	double aCurve = (mean(grades) + 2*(stdDev));
    	double bCurve = (mean(grades) + stdDev);
    	double cCurve = (mean(grades));
    	double dCurve = (mean(grades) - stdDev);
    	double fCurve = (mean(grades) - 2*(stdDev));
    	
    	
    	if (sum >= aCurve){  
    		System.out.println("Grade after curve is: A");
    	} else if (sum >= bCurve && sum < aCurve) {
    		System.out.println("Grade after curve is: B");
    	} else if (sum >= cCurve && sum < bCurve) {
    		System.out.println("Grade after curve is: C");
    	} else if (sum >= dCurve && sum < cCurve) {
    		System.out.println("Grade after curve is: D");
    	} else if (sum <= fCurve) {
    		System.out.println("Grade after curve is: F");
    	}
 
    	
    	
	}
//*******************************************************************************************************
// This method it utilized to find the mean of the class' grade totals and for standard deviation
//*******************************************************************************************************
	private static int mean(int[] grades) {
		int sum = IntStream.of(grades).sum();
		return sum / grades.length;
	}
	
//*******************************************************************************************************
// This method it utilized as a boolean to determine if the sum is between two numbers. 
//*******************************************************************************************************
	private static boolean isBetween(int sum, int i, int j) {
		return i <= sum && sum <= j;
	}
}
