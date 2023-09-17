
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
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int min = 5;
        int max = 20;
        int[][] payroll;
        System.out.println("Enter the number of employees: (" + min + " to " + max + ")");
        int employees = input.nextInt();
        if((employees < min) || (employees > max)) {
            System.out.println("Please enter a number between " + min + " and " + max);
            return;
        }
        else{
            System.out.println("Generating hours for " + employees + " employees...");
            for(int i = 0; i < employees; i++) {
                int hours = (int)(Math.random() * 12);
                System.out.println(hours);
            }
        }
        for (int i = 0;i <= employees; i++) {
            
        }
    
    }

}