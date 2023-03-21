package com.collection.list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
public class Main {
    public static void main(String[] args) {

        /*List<Double> notas = new ArrayList<>();
        notas.add(1d);
        notas.add(2d);
        notas.add(3d);
        notas.add(4d);

        System.out.println(notas.indexOf(3d));

        notas.add(4,5d);

        System.out.println(notas);
        notas.set(2,7d);
        System.out.println(notas);
        System.out.println("Nota 4.o está na lista: " + notas.contains(4.0));
        //for(Double nota : notas) System.out.println(nota);
        System.out.println("Exiba a terceira nota adicionada " + notas.get(2));
        System.out.println(notas.toString());
        System.out.println("Exiba a menor nota: " + Collections.min(notas));
        System.out.println("Exiba a maior nota: " + Collections.max(notas));

        Iterator<Double> iterator = notas.iterator();
        Double soma = 0d;
        while (iterator.hasNext()){
            Double next = iterator.next();
            soma += next;
        }

        System.out.println("Exiba a soma dos valores: " + soma);

        System.out.println("Exiba a média das notas: " + (soma/ notas.size()));

        System.out.println("Remova a nota 1.0" );
        notas.remove(1d);
        System.out.println(notas);

        System.out.println("Remova a nota da posição 0" );
        notas.remove(0);
        System.out.println(notas);

        System.out.println("Remova as notas menores que 7.0");
        Iterator<Double> iterator1 = notas.iterator();
        while (iterator1.hasNext()){
            Double next = iterator1.next();
            if(next < 7) iterator1.remove();
        }

        System.out.println(notas);
        System.out.println("Apague toda a lista");
        notas.clear();
        System.out.println(notas);
        System.out.println("Confira se a lista es´ta vazia: " + notas.isEmpty());*/

        /*Dadas as seguintes informações sobre meus gatos, crie uma lista
        e ordene esta lista exibindo:
        (nome - idade - cor);
        com.collection.list.Gato 1 = nome: Jon, idade: 18, cor: preto
        com.collection.list.Gato 2 = nome: Simba, idade: 6, cor: tigrado
        com.collection.list.Gato 3 = nome: Jon, idade: 12, cor: amarelo
*/

        List<Gato> meusGatos = new ArrayList<>(){{
            add(new Gato("Felino", 14, "preto"));
            add(new Gato("Fulano", 15, "branco"));
            add(new Gato("Vagabundo", 17, "tigrado"));
        }};

        System.out.println("Ordem de inserção");
        System.out.println(meusGatos);

        System.out.println("Ordem aleatória");
        Collections.shuffle(meusGatos);
        System.out.println(meusGatos);

        System.out.println("Ordem natural nome");
        Collections.sort(meusGatos);
        System.out.println(meusGatos);

        System.out.println("Ordem idade");
        Collections.sort(meusGatos, new ComparatorIdade());
        //meusGatos.sort(new com.collection.list.ComparatorIdade());
        System.out.println(meusGatos);

        System.out.println("Ordem Cor");
        //Collections.sort(meusGatos, new com.collection.list.ComparatorCor());
        meusGatos.sort(new ComparatorCor());
        System.out.println(meusGatos);

        System.out.println("Ordem nome/cor/idade");
        Collections.sort(meusGatos, new ComparatorNomeCorIdade());
        //meusGatos.sort(new com.collection.list.ComparatorNomeCorIdade());
        System.out.println();
    }


}

class Gato implements Comparable<Gato>{
    private String nome;
    private Integer idade;
    private String cor;

    public Gato(String nome, Integer idade, String cor) {
        this.nome = nome;
        this.idade = idade;
        this.cor = cor;
    }

    public String getNome() {
        return nome;
    }

    public Integer getIdade() {
        return idade;
    }

    public String getCor() {
        return cor;
    }

    @Override
    public String toString() {
        return "{" +
                "nome='" + nome + '\'' +
                ", idade=" + idade +
                ", cor='" + cor + '\'' +
                '}';
    }

    @Override
    public int compareTo(Gato gato) {
        return this.getNome().compareToIgnoreCase(gato.getNome());
    }
}

class ComparatorIdade implements Comparator<Gato> {
    @Override
    public int compare(Gato g1, Gato g2) {
        return Integer.compare(g1.getIdade(), g2.getIdade());
    }
}

class ComparatorCor implements Comparator<Gato> {

    @Override
    public int compare(Gato g1, Gato g2) {
        return g1.getCor().compareToIgnoreCase(g2.getCor());
    }
}

class ComparatorNomeCorIdade implements Comparator<Gato> {

    @Override
    public int compare(Gato g1, Gato g2) {
        int nome = g1.getNome().compareToIgnoreCase(g2.getNome());
        if (nome != 0) return nome;

        int cor = g1.getCor().compareToIgnoreCase(g2.getCor());
        if(cor !=0) return cor;

        return Integer.compare(g1.getIdade(), g2.getIdade());

    }
}