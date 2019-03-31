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


public class mainApp {

    public static void name() {
        
    }

    public static void main(String[] args) {
        System.out.println("Welcome to the Triangle App!");
        System.out.println("Please choose an option based on what information you have about the triangle:");
        System.out.println("\t1) SSS - if you have 3 sides");
        System.out.println("\t2) SAS - if you have 2 sides and the angle in between");
        System.out.println("\t3) ASA - if you have 2 angles and the side in between");
        System.out.println("\t4) SSA - if you have 2 sides and the angle NOT in between");
        System.out.println("\t5) AAS - if you have 2 angles and the side NOT in between");


        Triangle triangle = new Triangle();
        
    }
}