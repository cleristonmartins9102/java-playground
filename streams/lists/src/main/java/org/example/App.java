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


        System.out.println("Tamanho: " + nomes.size());
    }
}
