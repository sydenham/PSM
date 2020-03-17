package com.company;
import java.util.Scanner;

public class Main {

    public static double factorial(double n) {
        if (n <= 1)
            return 1;
        else
            return n * factorial(n - 1);
    }

    public static void main(String[] args) {
	    System.out.println("Podaj kąt");
        Scanner scan = new Scanner(System.in);
        while (!scan.hasNextDouble()){
            System.out.println("Podaj watość liczbową");
            scan.next();
        }
        double degrees = scan.nextDouble();
        System.out.println("Podaj r dla radianów lub s dla stopni");
        while (!scan.hasNext("[rs]")){
            System.out.println("Podaj r dla radianów lub s dla stopni");
            scan.next();
        }
        String scale = scan.next();
        double radians = degrees;
        if(scale.equals("s")){
            radians = Math.toRadians(degrees);
        }
        double x = radians % (2*Math.PI);
        if (x < 0) {
           x = -x;
        }
        int sign = 1;
        if (x > Math.PI/2 && x <= Math.PI ){
            x = Math.PI - x;
        } else if (x > Math.PI && x <= 1.5*Math.PI){
            x = -(x - Math.PI);
        }else if (x > 1.5*Math.PI && x <= 2*Math.PI){
            x = -(2*Math.PI-x);
        }
        double javaSine = Math.sin(x);
        System.out.println("Wynik funkcji wbudowanej to: " + javaSine);
        final int ITERATIONS = 9;
        double res = 0;
        for (int i = 0; i <= ITERATIONS; i++) {
            res += Math.pow(-1, i) * (Math.pow(x, 2 * i + 1) / factorial(2 * i + 1));
            System.out.println("Iteracja " + (i+1));
            System.out.println("Wynik to: " + res);
            System.out.println("Różnica do funkcji wbudowanej to: " + (javaSine - res));
        }
}
}
