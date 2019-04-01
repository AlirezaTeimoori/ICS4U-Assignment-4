//---------------------------------------
//-- Created by:     Alireza Teimoori  --
//-- Created on:     Apr 03 2019       --
//-- Created for:    Assignment 4      --
//-- Course Code:    ICS4U             --
//-- Teacher Name:   Chris Atkinson    --
//---------------------------------------
//-- This program recieves data about  --
//-- a triangle and calculates the area--
//-- and the perimeter of the triabgle --
//-- and displays the information.     --
//---------------------------------------

// This is the main app

import java.util.Scanner;

public class mainApp {

    private static Float side1;
    private static Float side2;
    private static Float side3;
    private static Float angle1;
    private static Float angle2;
    private static Float angle3;
    
    static Scanner scanner = new Scanner(System.in);
    static Triangle triangle = new Triangle();

    public static Float getAngle1() {
        return angle1;
    }

    public static Float getAngle2() {
        return angle2;
    }

    public static Float getAngle3() {
        return angle3;
    }

    public static void main(String[] args) {
        System.out.println("Welcome to the Triangle App!");
        System.out.println("Please choose an option based on what information you have about the triangle:");
        System.out.println("\t1) SSS - if you have 3 sides");
        System.out.println("\t2) SAS - if you have 2 sides and the angle in between");
        System.out.println("\t3) ASA - if you have 2 angles and the side in between");
        System.out.println("\t4) SSA - if you have 2 sides and the angle NOT in between");
        System.out.println("\t5) AAS - if you have 2 angles and the side NOT in between");

        String operationKey = scanner.nextLine(); // Receive the key from user
        operationKey = operationKey instanceof String ? operationKey.toUpperCase() : operationKey; // Make uppercase if it is String

        // Intro variable for the 3 sides and angles


        switch (operationKey) {
            case "1":
            case "SSS":

                // Initial String announcing the beginning of the case:
                System.out.println("--- You have chosen # SSS # you will enter 3 SIDES ---\n");
                
                try {

                    // Ask for and store data:
                    System.out.println("Please enter Side 1 (a): ");
                    side1 = scanner.nextFloat();
                    System.out.println("Please enter Side 2 (b): ");
                    side2 = scanner.nextFloat();
                    System.out.println("Please enter side 3 (c): ");
                    side3 = scanner.nextFloat();

                } catch (Exception e) {

                    // Print error message:
                    System.out.println("You entered a wrong Type! (Must only be float)");
                    break;
                }
                
                // Final String before printing the triangle:
                System.out.println("\n--- Thank you for entering the 3 sides ---");

                // triangle.SSS(side1, side2, side3); // Run SSS() function inputing the 3 sides
                // System.out.println(triangle.toString()); // Print out triangle properties

                break;
        
            case "2":
            case "SAS":

                // Initial String announcing the beginning of the case:
                System.out.println("--- You have chosen # SAS # you will enter 2 SIDES and the ANGLE IN BETWEEN ---\n");
                
                try {

                    // Ask for and store data:
                    System.out.println("Please enter Side 1 (a): ");
                    side1  = scanner.nextFloat();
                    System.out.println("Please enter Angle 3 (C) which is between the two sides: ");
                    angle3 = scanner.nextFloat();
                    System.out.println("Please enter side 2 (b): ");
                    side2  = scanner.nextFloat();

                } catch (Exception e) {
                    
                    // Print error message:
                    System.out.println("You entered a wrong Type! (Must only be float)");
                    break;
                }

                
                // Final String before printing the triangle:
                System.out.println("\n--- Thank you for entering the 3 sides ---");

                side3 = LawOfCosines.getSideC(angle3, side1, side2);
                //side3 = 0;

                break;
            
            case "3":
            case "ASA":
                
                // Initial String announcing the beginning of the case:
                System.out.println("--- You have chosen # ASA # you will enter 2 ANGLES and the SIDE IN BETWEEN ---\n");

                try {

                    // Ask for and store data:
                    System.out.println("Please enter Angle 1 (A): ");
                    angle1 = scanner.nextFloat();
                    System.out.println("Please enter Side 3 (c) which is between the two angles: ");
                    side3  = scanner.nextFloat();
                    System.out.println("Please enter Angle 2 (B): ");
                    angle2 = scanner.nextFloat();
                    
                } catch (Exception e) {

                    // Print error message:
                    System.out.println("You entered a wrong Type! (Must only be float)");
                    break;
                }

                angle3 = 180 - angle1 - angle2;
                side2  = (float) (side3 * Math.sin(Math.toRadians(angle2)) / Math.sin(Math.toRadians(angle3)));
                // side1  = LawOfCosines.getSideA(angle1, side2, side3);
                side1  = (float) ( side2 * Math.sin(Math.toRadians(angle1)) / Math.sin(Math.toRadians(angle2)) );

                break;

            case "4":
            case "SSA":
            
                // Initial String announcing the beginning of the case:
                System.out.println("--- You have chosen # SSA # you will enter 2 SIDES and an ANGLE NOT IN BETWEEN ---\n");

                try {
                    
                    // Ask for and store data:
                    System.out.println("Please enter Side 1 (a): ");
                    side1  = scanner.nextFloat();
                    System.out.println("Please enter Side 2 (b): ");
                    side2  = scanner.nextFloat();
                    System.out.println("Please enter angle 1 (A) which is NOT between the two sides: ");
                    angle1 = scanner.nextFloat();

                } catch (Exception e) {

                    // Print error message:
                    System.out.println("You entered a wrong Type! (Must only be float)");
                    break;
                }

                angle2 = (float) Math.toDegrees(Math.asin( side2 * Math.sin(Math.toRadians(angle1)) / side1));
                angle3 = 180 - angle1 - angle2;
                //side3  = LawOfCosines.getSideC(angle3, side1, side2);
                side3  = (float) ( side2 * Math.sin(Math.toRadians(angle3)) / Math.sin(Math.toRadians(angle2)) );

                break;

            case "5":
            case "AAS":
                
                // Initial String announcing the beginning of the case:
                System.out.println("--- You have chosen # AAS # you will enter 2 ANGLES and a SIDE NOT IN BETWEEN ---\n");
                
                try {

                    // Ask for and store data:
                    System.out.println("Please enter Angle 1 (A): ");
                    angle1 = scanner.nextFloat();
                    System.out.println("Please enter Angle 2 (B): ");
                    angle2 = scanner.nextFloat();
                    System.out.println("Please enter Side 1 (a) which is NOT between the two angles: ");
                    side1  = scanner.nextFloat();

                } catch (Exception e) {

                    // Print error message:
                    System.out.println("You entered a wrong Type! (Must only be float)");
                    break;
                }

                angle3 = 180 - angle1 - angle2;
                side2  = (float) ( side1 * Math.sin(Math.toRadians(angle2)) / Math.sin(Math.toRadians(angle1)) );
                //side3  = LawOfCosines.getSideC(angle3, side1, side2);
                side3 = (float) ( side2 * Math.sin(Math.toRadians(angle3)) / Math.sin(Math.toRadians(angle2)) );


                break;
        
        }
        
        try {

            triangle.SSS(side1, side2, side3); // Run SSS() function inputing the 3 sides
            System.out.println(triangle.toString()); // Print out triangle properties

        } catch (Exception e) {

            System.out.println("Please enter a valid input next time!");
        }
            

    }
}