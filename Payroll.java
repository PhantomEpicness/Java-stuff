
/*
* @author Donald Wyand
* @date 9/14/2023
* ICS 211 Payroll assignment
*/
import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.*;
import java.util.Random;
class Payroll {
    // Control variables for the payroll
    static int maxWeekHours = 40;
    static double hourlyWage = 14.50; 
    static double overtimeRate = 1.5; // OT hours are multiplied by this.
    static int col = 5;
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int min = 5;
        int max = 20;
        int[][] payroll;
        /*
         * The 2d array "payroll" is filled with employees hours, the rows repesenting the employees and 
         * the collums representing the working hours per day
         * 
         */
        int employees;
        System.out.println("This program will calculate the payroll for 5 to 20 employees. \n It will generate a payroll table, and calculate ovetime, and show employee total time & overtime hours");
        System.out.println("Enter the number of employees: (" + min + " to " + max + ")");
        
        // input filtering below

        try { 
            employees = input.nextInt();
        }
        catch(InputMismatchException e) {
            System.out.println("Fatal Error: Please enter a number between " + min + " and " + max);
            input.close();
            return;
        }
        if((employees < min) || (employees > max)) {
            System.out.println("Fatal Error: Please enter a number between " + min + " and " + max);
            input.close();
            return;
        }

        else{
            System.out.println("Generating hours for " + employees + " employees...");
            int hours = 0;
            payroll = new int[employees][col];    // setting up to use for loop to fill array
            for(int i = 0; i < employees; i++) {
                for(int n = 0; n < col; n++) {
                    hours = (int)(Math.random()*12); //the now deleted PRNG function I put here made OT too rare so Math.random() is used. Random is random so ¯\_(ツ)_/¯ 
                    payroll[i][n] = hours;
                }
                //System.out.println(hours);
            }
        }
        // Formatting and printing the hours table. Spaces line it out exactly
        System.out.println("\n               Mon Tue Wed Thu Fri ");
        for(int i = 0; i < employees; i++) {
            System.out.print(" Employee ");
            System.out.printf("%2d", i+1); // meticulously putting each differant input into seperate prints because the formatting is allergic to strings
            System.out.print("  ");   
            for (int n = 0; n < col; n++) {
                System.out.printf("%4d",payroll[i][n]);
            }
            System.out.print("\n"); // And a newline to end it off
        }

        calculatePayroll(payroll,employees);
        input.close();
    }
    /** calculatePayroll()
     * this calculates the payroll for each employee based on the hourly pay rate, considering overtime hours and the employee's
     * paycheck for the week
     */
    static void calculatePayroll(int[][] payroll, int employees) throws InputMismatchException {
        int[] empHours = new int[employees]; // Each index number represents an employee's TOTAL hours worked which is used to calculate the payroll
       
        // First calculate both total hours and fill the empHours[] 1D array of total hours per employee
        System.out.println("\n  Total hours worked for employees: ");
        for(int i = 0; i < employees; i++) { // Go through each row
            int totalHours = 0;
            for(int n = 0; n < col; n++) {
                totalHours += payroll[i][n];
            }
            System.out.print(" Employee ");
            System.out.printf("%2d", i+1); // see now I can't resist making the other ones look nice too.
            System.out.print("  ");  
            System.out.println("Hours worked = " + totalHours);
            empHours[i] = totalHours;
        }

        // Use the now filled empHours[] array to calculate OT hours
        System.out.println("\nEmployees that worked overtime:");
        for(int i = 0; i < employees; i++) {
            if(empHours[i] > maxWeekHours) {
                System.out.print(" Employee ");
                System.out.printf("%2d", i+1); // formatting again
                System.out.print("  ");  
                System.out.println("Overtime = " + (empHours[i] - maxWeekHours) + " hours");
            }
        }
        
        // with the empHours[] and OT hours done, now we can get to the real money
         System.out.println("\n    PAYROLL FOR THIS WEEK");
        for(int i = 0; i < employees; i++) {
            double overtimePay = 0;
            int hours = empHours[i];  // int used to store the hours worked for this employee
            double totalPay;
            if(empHours[i] > maxWeekHours) {
                overtimePay = (empHours[i] - maxWeekHours) * hourlyWage * overtimeRate;
                hours = hours - (empHours[i] - maxWeekHours); // minus OT hours from the hours so that it isn't double counted
            }
            totalPay = hours * hourlyWage + overtimePay; // adding everything together now

            System.out.print(" Employee ");
            System.out.printf("%2d", i+1); // formatting again
            System.out.print("  ");  
            System.out.println("Pay = $" + totalPay);
        }
    }
}