//Autor: Eduardo Barbosa de Oliveira Data: 10/27/2019
//Descrição do problema: Faça uma classe ArrayListThreadSafe usando ReadWriteLock.
//Teste usando threads que realizam leitura e escrita para essa
//estrutura.

public class Main {
    public static void main(String[] args) {
        ArrayListThreadSafe arrayListThreadSafe = new ArrayListThreadSafe();
        new Thread( () -> {
            arrayListThreadSafe.add(10);
        }).start();
        new Thread( () -> {
            arrayListThreadSafe.add(20);
        }).start();
        new Thread( () -> {
            arrayListThreadSafe.add(30);
        }).start();
        new Thread( () -> {
            System.out.println(arrayListThreadSafe.get(0));
        }).start();
        new Thread( () -> {
            System.out.println(arrayListThreadSafe.get(1));
        }).start();
        new Thread( () -> {
            System.out.println(arrayListThreadSafe.get(2));
        }).start();
    }
}
