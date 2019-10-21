import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class SharedFifoQueue {
    private final ReentrantLock lock = new ReentrantLock();
    private final Condition notFull  = lock.newCondition();
    private final Condition notEmpty = lock.newCondition();

    private final Object[] items = new Object[100];

    private int count = 0;

    public void put(Object obj) throws InterruptedException{
        lock.lock();
        try{
            while(count == items.length){
                notFull.await();
            }
            items[count] = obj;
            count+=1;
            notEmpty.signal();
        } finally {
            lock.unlock();
        }
    }
}
