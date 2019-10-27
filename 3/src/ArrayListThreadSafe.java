import java.util.ArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ArrayListThreadSafe {
    private ArrayList items = new ArrayList<Object>(100);
    private ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
    private Lock readLock = reentrantReadWriteLock.readLock();
    private Lock writeLock = reentrantReadWriteLock.writeLock();

    public Object get(int index){
        readLock.lock();
        try{
            return items.get(index);
        }finally {
            readLock.unlock();
        }
    }

    public void add(Object object){
        writeLock.lock();
        try{
            items.add(object);
        }finally {
            writeLock.unlock();
        }
    }

}
