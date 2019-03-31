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

// This is the Triangle class

import java.math.*;

public class Triangle {

    // Intro fields:
    private Float               a; // Side 1
    private Float               b; // Side 2
    private Float               c; // Side 3
    private Float               A; // Angle 1
    private Float               B; // Angle 2
    private Float               C; // Angle 3
    private Float       perimeter; // The sum of the 3 sides
    private Float   semiperimeter; // The perimeter devided by 2
    private Float            area; // The area of the Triangle
    private Float        inradius; // The radius of the inner circle
    private Float    circumradius; // The radius of the circumcircle

    private String type = "Triangle"; // To print the type in the end

    public void SSS(Float side1, Float side2, Float side3) {
        
        this.a = side1;
        this.b = side2;
        this.c = side3;

        this.A = (float) Math.toDegrees(LawOfCosines.getAngleA(this.a, this.b, this.c));
        this.B = (float) Math.toDegrees(LawOfCosines.getAngleB(this.a, this.b, this.c));
        this.C = (float) Math.toDegrees(LawOfCosines.getAngleC(this.a, this.b, this.c));
        
        this.perimeter = getPerimeter(this.a, this.b, this.c);
        this.semiperimeter = this.perimeter / 2;
        this.area = getArea(this.semiperimeter, this.a, this.b, this.c);
        // this.inradius = 0;
        // this.circumradius = 0;
    }


    public static Float getPerimeter(Float a, Float b, Float c) {
        return (float) a + b + c;
    }

    public static Float getArea(Float s, Float a, Float b, Float c) {
        return (float) Math.sqrt( s * ( s - a ) * ( s - b ) * ( s - c ));
    }

    public String toString() {
        
        String output = "";

        output += "--- This object is of type: \t\t" + this.type + "\n"; // Display the type
        output += "--- Side 1 (a) length in cm: \t\t" + String.valueOf(this.a) + "\n"; // Display Side 1 (a)
        output += "--- Side 2 (b) length in cm: \t\t" + String.valueOf(this.b) + "\n"; // Display Side 2 (b)
        output += "--- Side 3 (c) length in cm: \t\t" + String.valueOf(this.c) + "\n"; // Display Side 3 (c)
        output += "--- Angle 1 (A) value in deg: \t\t" + String.valueOf(this.A) + "\n"; // Display Angle 1 (A)
        output += "--- Angle 2 (B) value in deg: \t\t" + String.valueOf(this.B) + "\n"; // Display Angle 2 (B)
        output += "--- Angle 3 (C) value in deg: \t\t" + String.valueOf(this.C) + "\n"; // Display Angle 3 (C)
        output += "--- Perimeter value in cm: \t\t" + String.valueOf(this.perimeter) + "\n"; // Display Perimeter
        output += "--- Semiperimeter value in cm: \t\t" + String.valueOf(this.semiperimeter) + "\n"; // Display Semiperimeter
        output += "--- Area value in cm^2: \t\t" + String.valueOf(this.area) + "\n"; // Display Area
        output += "--- Inradius length in cm: \t\t" + String.valueOf(this.inradius) + "\n"; // Display Inradius
        output += "--- Circumradius length in cm: \t\t" + String.valueOf(this.circumradius) + "\n"; // Display Circumradius




        return output;
    }
}