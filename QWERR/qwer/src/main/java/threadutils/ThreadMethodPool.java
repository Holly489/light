package threadutils;

import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.*;
import java.util.function.Consumer;

/**
 * @author 1031
 */
public class ThreadMethodPool {

    private final int maxWorker;//线程池最大worker数量

    public ThreadMethodPool(int maxWoker) {
        this.maxWorker = maxWoker;
    }

    public int getMaxWorker() {
        return maxWorker;
    }

    /**
     * 取集合中的每一个元素作为参数传递给实现Consumer接口的对象的accept方法执行，
     * 可以理解为第一个参数是个方法，第二个参数是列表，但是java不能传方法，所以传个单方法的对象
     *
     * @param consumer 实现Consumer接口的一个对象
     * @param collection 集合对象
     * @param <T> 集合内装的对象类型
     * @throws Exception
     */
    public synchronized <T> void map(Consumer<T> consumer, Collection<T> collection) throws Exception {
        Iterator<T> iterator = collection.iterator();
        int collectionSize = collection.size();
        CountDownLatch countDownLatch = new CountDownLatch(collectionSize);
        ExecutorService executorService = new ThreadPoolExecutor(maxWorker, maxWorker,
                0L, TimeUnit.MILLISECONDS,
                new ArrayBlockingQueue<Runnable>(collectionSize));
        while (iterator.hasNext()) {
            T next = iterator.next();
            executorService.submit(() -> {
                try {
                    consumer.accept(next);
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    countDownLatch.countDown();
                }
            });
        }
        countDownLatch.await();//线程池没执行完之前堵塞主线程
        executorService.shutdown();
    }
}
