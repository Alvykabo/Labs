package com.metanit;
import java.util.Scanner;
import java.util.Date;
/**
 * Enter the n-dimension [n,n] matrix from the console.
 * Set element's values of the matrix in the range of values from -n to n with the help of a randomiser.
 * Transpose the matrix.
 *  @author Lubov A. Kabo
 */


public class Main {
    public static void main(String[] args) {


        /**creating an [n,n] matrix*/
        Scanner input = new Scanner(System.in);
        System.out.println("Enter array length: ");
        int n = input.nextInt();
        int[][] a = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = (int)(Math.random()*n)+1;
            }
        }

        /**printing the matrix*/
        System.out.println("Matrix");
        System.out.println("----------------");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.printf("%4d", a[i][j]);
            }
            System.out.println();
        }

        /**transposing the matrix*/
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int temp = a[i][j];
                a[i][j] = a[j][i];
                a[j][i] = temp;
            }
        }

        /**printing the transposed matrix*/
        System.out.println();
        System.out.println("Transposed matrix");
        System.out.println("---------------");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.printf("%4d", a[i][j]);
            }
            System.out.println();
        }

    }
}