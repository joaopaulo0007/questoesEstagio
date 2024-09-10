package com.example;
import java.util.Scanner;
public class Quest5 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a String: ");
        String word= input.nextLine();
        String reverseWord="";
        //laço para interar sobre cada letra da palavra
        for (int index = word.length()-1; index >=0; index--) {
            //uma string em java é um objeto, por isso não podemos interar diretamente sobre o char naquela posição como em c onde poderiamos fazer word[index], para isso usamos o método charAt que retorna o char naquela posição
            reverseWord+=word.charAt(index);
        }
        System.out.println("Reverse String is: "+reverseWord);
    }
}   
