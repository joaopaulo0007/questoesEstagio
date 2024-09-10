package com.example;
import org.json.JSONArray;
import org.json.JSONObject;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Quest3 {
   public static void main(String[] args) {
      // getResourch para pegar o arquivo em resourchs
      try (InputStream is = Quest3.class.getClassLoader().getResourceAsStream("db/dados.json")) {
         //analisa se achou algo
         if (is == null) {
            throw new IOException("Arquivo não encontrado: db/dados.json");
         }
        //scanner para ler o arquivo e joga-lo em uma string 
         Scanner scanner = new Scanner(is, StandardCharsets.UTF_8.name());
         String content = scanner.useDelimiter("\\A").next();
         //string é convertida em um jsonArray
         JSONArray jsonArray = new JSONArray(content);
         
         double minimo = -1, maximo = 0, soma = 0, numDias = 0;
         
         //interação sobre o array, cada objeto desse array e desestruturado em um objeto e pegamos o campo valor
         for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            double valor = jsonObject.getDouble("valor");
            //aqui verificamos se o valor é diferente de 0 e somamos o valor ao total e incrementamos o numero de dias e checamos se ele não é um valor máximo ou mínimo
            if (valor != 0) {
               soma += valor;
               numDias++;
               
               if (minimo == -1 || valor < minimo) {
                  minimo =  valor;
               }
               if (valor > maximo) {
                  maximo =  valor;
               }
            }
         }
         //média dos valores
         double media = soma / numDias;

        //aqui criamos uma formatação de 4 casas decimais para a média, visto que em valores a formatação está em 4 casas decimais, decidi manter o formato para facilitar a comparação
         DecimalFormat df = new DecimalFormat("#.####");
         //aqui é criado uma lista para armazenar os dias que o valor é maior que a média
         List<Integer> dias = new ArrayList<>();
         int diasMaiorMedia = 0;
         //laço para verificar se o valor é maior que a média e adicionar ao arraylist
         for (int index = 0; index < jsonArray.length(); index++) {
            JSONObject jsonObject = jsonArray.getJSONObject(index);
            double valor = jsonObject.getDouble("valor");
            Integer dia = jsonObject.getInt("dia");
            if (valor > media) {
               dias.add(dia);
               diasMaiorMedia++;
            }
         }

        //impressão dos resultados
         System.out.println("Mínimo: " + minimo);
         System.out.println("Máximo: " + maximo);
         System.out.println("Média: " + df.format(media)); 
         System.out.println("Número de dias acima da média: " + diasMaiorMedia);
         System.out.println("Lista de dias acima da média: " + dias);

      } catch (IOException e) {
         e.printStackTrace();
      }
   }
}
