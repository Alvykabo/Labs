package com.metanit;

import java.util.Arrays;

public class Complex {

    private int a;
    private int b;
    private int c;
    private int d;
    private int summA;
    private int summB;
    private int multA;
    private int multB;


    public Complex(int a, int b, int c, int d, int summA, int summB, int multA, int multB) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.summA = summA;
        this.summB = summB;
        this.multA = multA;
        this.multB = multB;
    }

    public int geta() {
        return a;
    }
    public int getb() {
        return b;
    }
    public int getc() {
        return c;
    }
    public int getd() {
        return d;
    }

    @Override
    public String toString() {
        return
                "summA = " + summA +
                        '\'' + "summB = " + summB +
                        '\'' + "multA = " + multA +
                        '\'' + "multB = " + multB + '\'' + "\n";
    }
}
