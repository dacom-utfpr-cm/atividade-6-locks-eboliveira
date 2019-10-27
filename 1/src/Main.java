//Autor: Eduardo Barbosa de Oliveira Data: 10/27/2019
//Descrição do problema: Faça um programa usando Lock para simular a atualização de
//um contador que é acessado por múltiplas threads. O
//contador pode diminuir e aumentar.

public class Main {
    public static void main(String[] args) {
        Counter counter = new Counter();
        new Thread( () -> {
            counter.increment(100);
        }).start();
        new Thread( () -> {
            counter.decrement(100);
        }).start();
        new Thread( () -> {
            counter.increment(100);
        }).start();
        new Thread( () -> {
            counter.increment(100);
        }).start();
    }
}
