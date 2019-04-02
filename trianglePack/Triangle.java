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
    private Float         heightA; // The height, a being the base
    private Float         heightB; // The height, b being the base
    private Float         heightC; // The height, c being the base
    private Float        inradius; // The radius of the inner circle
    private Float    circumradius; // The radius of the circumcircle
    private String          type ; // To print the type in the end

    // SSS() function solves the triangle using 
    public void SSS(Float side1, Float side2, Float side3) {
        
        // Set the sided to the rounded corresponding values:
        this.a = (float) (Math.round( side1 * 100.0 ) / 100.0);
        this.b = (float) (Math.round( side2 * 100.0 ) / 100.0);
        this.c = (float) (Math.round( side3 * 100.0 ) / 100.0);

        
        // Calculate and set the angles to the corresponding values (if they are empty):
        this.A = (mainApp.getAngle1() == null) ? (float) Math.toDegrees(LawOfCosines.getAngleA(this.a, this.b, this.c)) : mainApp.getAngle1();
        this.B = (mainApp.getAngle2() == null) ? (float) Math.toDegrees(LawOfCosines.getAngleB(this.a, this.b, this.c)) : mainApp.getAngle2();
        this.C = (mainApp.getAngle3() == null) ? (float) (180 - this.A - this.B) : mainApp.getAngle3();

        // this.A = (float) Math.toDegrees(LawOfCosines.getAngleA(this.a, this.b, this.c));
        // this.B = (float) Math.toDegrees(LawOfCosines.getAngleB(this.a, this.b, this.c));
        // this.C = (float) (180 - this.A - this.B);
        
        // Round the values to 2 decimal digits:
        this.A = (float) (Math.round( this.A * 10.0 ) / 10.0);
        this.B = (float) (Math.round( this.B * 10.0 ) / 10.0);
        this.C = (float) (Math.round( this.C * 10.0 ) / 10.0);

        // Calculate and set perimeter, semiperimeter, and area:
        this.perimeter = (float) (Math.round( getPerimeter(this.a, this.b, this.c) * 100.0 ) / 100.0);
        this.semiperimeter = (float) (Math.round( (this.perimeter / 2) * 100.0 ) / 100.0);
        this.area = (float) (Math.round( getArea(this.semiperimeter, this.a, this.b, this.c) * 100.0 ) / 100.0);

        // Calculate and set each of the heights:
        this.heightA = (float) (Math.round( (2 * this.area / this.a) * 100.0 ) / 100.0);
        this.heightB = (float) (Math.round( (2 * this.area / this.b) * 100.0 ) / 100.0);
        this.heightC = (float) (Math.round( (2 * this.area / this.c) * 100.0 ) / 100.0);

        // Calculate and set inradius and circumradius:
        this.inradius = (float) (Math.round( getInradius(this.semiperimeter, this.a, this.b, this.c) * 100.0 ) / 100.0);
        this.circumradius = (float) (Math.round( getCircimradius(this.area, this.a, this.b, this.c) * 100.0 ) / 100.0);

        this.type = setType();
    }

    // getPerimeter() function calculates and returns the perimeter using the inputed data:
    public static Float getPerimeter(Float a, Float b, Float c) {
        return (float) a + b + c;
    }

    // getArea() function calculates and returns the area using the inputed data:
    public static Float getArea(Float s, Float a, Float b, Float c) {
        return (float) Math.sqrt( s * ( s - a ) * ( s - b ) * ( s - c ));
    }

    // getInradius() function calculates and returns the Inradius using the inputed data:
    public static Float getInradius(Float s, Float a, Float b, Float c) {
        
        return (float) Math.sqrt( ( s - a ) * ( s - b ) * ( s - c ) / s );
    }

    // getCircumradius() function caluculates and returns the Circumradius using the inputed data:
    public static Float getCircimradius(Float area, Float a, Float b, Float c) {
        return (float) a * b * c / (4 * area);
    }

    public String setType() {

        String type = "";

        if (this.A < 90 && this.B < 90 && this.C < 90) { // If all of the angles are less than 90

            type += "Acute"; // Add "Acute" to the type string

            if (this.A.equals(this.B) && this.A.equals(this.C)) { // If all the sides are equal

                type += ", Equilateral, Equiangular"; // Add ", Equilateral, Equiangular" to the type

            } else if (this.A.equals(this.B) || this.A.equals(this.C) || this.B.equals(this.C)) { // If 2 of the sides are equal

                type += ", Isosceles"; // Add ", Isosceles" to the type

            }

        } else { // If at least one of the angles is greater than or equal to 90

            if (this.A == 90 || this.B == 90 || this.C == 90) { // If one of the angles is equal to 90

                type += "Right"; // Add "Right" to the type

                if (this.A.equals(this.B) || this.A.equals(this.C) || this.B.equals(this.C)) { // If 2 of the sides are equal

                    type += ", Isosceles"; // Add ", Isosceles" to the type

                }
            } else { // If one of the angles is greater than 90

                type += "Obtuse"; // Add "Obtuse" to the type

                if (this.A.equals(this.B) || this.A.equals(this.C) || this.B.equals(this.C)) { // If 2 of the sides are equal

                    type += ", Isosceles"; // Add ", Isosceles" to the type

                }
            }
        }

        return type;
    }

    // toString() function returns the final output in an organized way:
    public String toString() {
        
        String output = "\n";

        output += "--- The type of the triangle: \t\t" + this.type + "\n"; // Display the type
        output += "--- Side 1 (a) length in cm: \t\t" + String.valueOf(this.a) + "\n"; // Display Side 1 (a)
        output += "--- Side 2 (b) length in cm: \t\t" + String.valueOf(this.b) + "\n"; // Display Side 2 (b)
        output += "--- Side 3 (c) length in cm: \t\t" + String.valueOf(this.c) + "\n"; // Display Side 3 (c)
        output += "--- Angle 1 (A) value in deg: \t\t" + String.valueOf(this.A) + "\n"; // Display Angle 1 (A)
        output += "--- Angle 2 (B) value in deg: \t\t" + String.valueOf(this.B) + "\n"; // Display Angle 2 (B)
        output += "--- Angle 3 (C) value in deg: \t\t" + String.valueOf(this.C) + "\n"; // Display Angle 3 (C)
        output += "--- Perimeter value in cm: \t\t" + String.valueOf(this.perimeter) + "\n"; // Display Perimeter
        output += "--- Semiperimeter value in cm: \t\t" + String.valueOf(this.semiperimeter) + "\n"; // Display Semiperimeter
        output += "--- Area value in cm^2: \t\t" + String.valueOf(this.area) + "\n"; // Display Area
        output += "--- Height (a) length in cm: \t\t" + String.valueOf(this.heightA) + "\n"; // Display HeightA
        output += "--- Height (b) length in cm: \t\t" + String.valueOf(this.heightB) + "\n"; // Display HeightB
        output += "--- Height (c) length in cm: \t\t" + String.valueOf(this.heightC) + "\n"; // Display HeightC
        output += "--- Inradius length in cm: \t\t" + String.valueOf(this.inradius) + "\n"; // Display Inradius
        output += "--- Circumradius length in cm: \t\t" + String.valueOf(this.circumradius) + "\n"; // Display Circumradius




        return output;
    }
}