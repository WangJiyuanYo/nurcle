package icu.iseenu;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 多线程之间的同步代码块
 */
public class ThreadSync {
    public static void main(String[] args) {

    }

    //1.第一种方式，Sync
    private synchronized void type1() {

    }

    //2.信号量
    private void type2() throws InterruptedException {
        Semaphore semaphore = new Semaphore(2);
        semaphore.acquire();
        try {
            System.out.println("调用同步资源");
        } finally {
            semaphore.release();
        }
    }

    //3.lock
    private void type3() {
        ReentrantLock lock = new ReentrantLock();
        if (lock.tryLock()) {
            try {

            } finally {
                lock.unlock();
            }
        }
    }

    //4.CountDownLatch
    private void type4() throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(3);
        // 每个线程完成工作后调用 latch.countDown()
        latch.countDown();
        // 主线程等待所有工作线程完成
        latch.await();
    }
}
