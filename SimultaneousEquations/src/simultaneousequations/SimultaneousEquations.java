/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simultaneousequations;
import java.util.Scanner;

/**
 * Simultaneous Equation solver 
 * @author Jason
 */
public class SimultaneousEquations 
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        Scanner keyboard = new Scanner(System.in);
        double[][] coefficients = new double[3][3];
        double[][] result = new double[1][3];
        
        for (int x = 0; x < 3; x++)
        {
            System.out.println("Please enter the " + (x+1) + " x coordinate");
            coefficients[x][0] = keyboard.nextInt();
        }
        
         for (int y = 0; y < 3; y++)
        {
            System.out.println("Please enter the " + (y+1) + " y coordinate");
            coefficients[y][1] = keyboard.nextInt();
        }
         
          for (int z = 0; z < 3; z++)
        {
            System.out.println("Please enter the " + (z+1) + " z coordinate");
            coefficients[z][2] = keyboard.nextInt();
        }
          
          for (int i = 0; i < 3; i++)
        {
            System.out.println("Please enter the " + (i+1) + " result");
            result[0][i] = keyboard.nextInt();
        }
          
        double multiplier = coefficients[1][0] / coefficients[0][0];
        
        for (int i = 0; i < 3; i++)
        {
            coefficients[1][i] -= multiplier * coefficients[0][i];
        }
        
        result[0][1] -= multiplier * result[0][0];
        multiplier = coefficients[2][0] / coefficients[0][0];
        
        for (int i = 0; i < 3; i++)
        {
            coefficients[2][i] -= multiplier * coefficients[0][i];
        }
        
        result[0][2] -= multiplier * result[0][0];
        multiplier = coefficients[2][1] / coefficients[1][1];
        
        for (int i = 1; i < 3; i++)
        {
            coefficients[2][i] -= multiplier * coefficients[1][i];
        }
        
        result[0][2] -= multiplier * result[0][1];
        double z = result[0][2] / coefficients[2][2];
        double y = 0, x = 0;
        
        if ((coefficients[1][2] * z) < 0 )
        {
            y = (result[0][1] + (coefficients[1][2] * z)) / coefficients[1][1];  
        }
        else
        {
            y = (result[0][1] + (coefficients[1][2] * z)) / coefficients[1][1];
        }
        
        if (((coefficients[0][1] * y ) + (coefficients[0][2] * z)) < 0 )
        {
            x = (result[0][0] + ((coefficients[0][2] * z) + (coefficients[0][1] * y))) / coefficients[0][0];
        }
        else 
        {
             x = (result[0][0] - ((coefficients[0][2] * z) + (coefficients[0][1] * y))) / coefficients[0][0];
        }
        
        System.out.println("The x value is " + x);
        System.out.println("The y value is " + y);
        System.out.println("The z value is " + z);
    }
}
