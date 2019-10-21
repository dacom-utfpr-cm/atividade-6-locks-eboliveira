import java.util.concurrent.locks.ReentrantLock;

public class Counter {
    private int counter = 0;
    private final ReentrantLock lock = new ReentrantLock();

    public void increment(int value){
        lock.lock();
        try{
            counter+=value;
            System.out.println(counter);
        }finally {
            lock.unlock();
        }
    }

    public void decrement(int value){
        lock.lock();
        try{
            counter-=value;
            System.out.println(counter);
        }finally {
            lock.unlock();
        }
    }
}
