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
