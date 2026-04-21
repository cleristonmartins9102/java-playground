package org.example;

import java.util.ArrayList;
import java.util.List;

public class App 
{
    public static void main( String[] args )
    {
        List<String> nomes = new ArrayList<>();

        nomes.add("Ana");
        nomes.add("Marina");
        nomes.add("Martina");

        System.out.println("Primeiro nome: " + nomes.get(0));

        for (int i = 0; i < nomes.size(); i++) {
            System.out.println("Index " + i + ": " + nomes.get(i));
        }

        for (String nome : nomes) {
            System.out.println("Nome: " + nome);
        }

        nomes.forEach(nome -> System.out.println("Lambda: " + nome));

        nomes.remove("Martina");

        System.out.println("Tamanho: " + nomes.size());
    }
}
