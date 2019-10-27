//Autor: Eduardo Barbosa de Oliveira Data: 10/27/2019
//Descrição do problema: Crie uma classe SharedFifoQueue e use Conditions para
//controlar se a fila está vazia ou cheia. Teste usando threads
//produtoras e consumidoras.

public class Main {
    public static void main(String[] args) {
        SharedFifoQueue queue = new SharedFifoQueue();
        new Thread( () -> {
            try {
                System.out.println(queue.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread( () -> {
            try {
                queue.put(20);
                System.out.println("20 inputed");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread( () -> {
            try {
                System.out.println(queue.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread( () -> {
            try {
                queue.put(10);
                System.out.println("10 inputed");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
