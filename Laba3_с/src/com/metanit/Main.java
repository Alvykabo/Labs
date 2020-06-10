package com.metanit;
import java.util.Scanner;
import java.util.Arrays;
import java.util.Collections.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter array length: ");
        int size = input.nextInt();
        int a[] = new int[size];
        int b[] = new int[size];
        int c[] = new int[size];
        int d[] = new int[size];
        System.out.println("Insert array elements:");

        for (int i = 0; i < size; i++) {
            System.out.println("a" + i +":");
            a[i] = input.nextInt();
            System.out.println("b" + i +":");
            b[i] = input.nextInt();
            System.out.println("c" + i +":");
            c[i] = input.nextInt();
            System.out.println("d" + i +":");
            d[i] = input.nextInt();
        }

        int summa = 0;
        int summb = 0;
        int summc = 0;
        int summd = 0;
        for (int i = 0; i < size; i++ ){
            summa+= a[i];
            summb+= b[i];
            summc+= c[i];
            summd+= d[i];
        }

        float summA = (float) summa/summb;
        float summB = (float) summc/summd;

        int multa = 1;
        int multb = 1;
        int multc = 1;
        int multd = 1;
        for (int i = 0; i < size; i++ ){
            multa= multa * a[i];
            multb= multb * b[i];
            multc*= c[i];
            multd*= d[i];
        }

        float multA = (float) multa/multb;
        float multB = (float) multc/multd;


        System.out.print("Array elements:" + "\n");
        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(b));
        System.out.println(Arrays.toString(c));
        System.out.println(Arrays.toString(d));
        System.out.println("summ A = " + summA);
        System.out.println("summ B = " + summB);
        System.out.println("mult A = " + multA);
        System.out.println("mult B = " + multB);
    }
}