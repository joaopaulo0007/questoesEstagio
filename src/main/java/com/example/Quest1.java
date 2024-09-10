package com.example;
public class Quest1 {
 public static void main(String[] args) {
    int soma=0, k=0 , indice =13;
      for(int i =0; i<indice; ++i){ // foi usada uma nova variavel i pois se usassemos o k, só interariamos ele até k=12, no momento que k== 13 sairia da condição e não iria somar o 13
        k++;
        soma+=k;
      }
      System.out.println(soma);
 }
}  
