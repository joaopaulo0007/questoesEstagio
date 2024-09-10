package com.example;
import java.util.Scanner;

public class Quest2 {

    public static void verificafib(int n) {
        //analisa se 0 ou 1 faz parte da sequencia de fibonacci
        if (n == 0 || n == 1) {
            System.out.println("Número passado " + n + " faz parte da sequência de Fibonacci");
            return;
        }

        int a = 0, b = 1;  
        // ao invés de usar uma estrategia recursiva, calculando o fib de n-1 e n-2 cuja complexidade é exponencial, decidi usar uma abordagem interativa pois só precisamos saber o valor de n-1 e n-2, sendo assim a complexidade é linear caso quissesemos toda a lista, bastava jogar os valores em uma arrayList
        while (b < n) {
            int temp = a + b;
            a = b;
            b = temp;
        }

        if (b == n) {
            System.out.println("Número passado " + n + " faz parte da sequência de Fibonacci");
        } else {
            System.out.println("Número passado " + n + " não faz parte da sequência de Fibonacci");
        }
    }

    public static void main(String[] args) {
        Scanner sr = new Scanner(System.in);
        System.out.print("Enter the number:");
        int n = sr.nextInt();
        verificafib(n);
        sr.close();
    }
}
