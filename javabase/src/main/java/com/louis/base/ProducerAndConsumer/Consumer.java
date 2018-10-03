package com.louis.base.ProducerAndConsumer;

import java.util.Random;
import java.util.concurrent.BlockingQueue;

public class Consumer  implements Runnable{
    BlockingQueue<Data> blockingQueue;

    //随机对象
    private static Random random = new Random();

    public Consumer(BlockingQueue<Data> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        while(true) {
            try {
                Data data = this.blockingQueue.take();
                //进行数据处理，休眠 0-1000毫秒模拟耗时
                Thread.sleep(random.nextInt(1000));
                System.out.print("当前消费线程"+Thread.currentThread().getName() +",消费成功，消费id为"+data.getId());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
