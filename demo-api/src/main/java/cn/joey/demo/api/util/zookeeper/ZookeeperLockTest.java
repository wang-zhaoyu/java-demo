package cn.joey.demo.api.util.zookeeper;

/**
 * @author wangzhaoyu
 * @date 2018/12/12 下午3:00
 */
public class ZookeeperLockTest {
    static int n = 500;

    public static void secskill() {
        n = n -1;
        System.out.println(n);
    }

    public static void main(String[] args) {

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                DistributedLock lock = null;
                try {
                    lock = new DistributedLock("127.0.0.1:2181", "test1");
                    lock.lock();
                    secskill();
                } finally {
                    if (lock != null) {
                        lock.unlock();
                    }
                }
            }
        };

        for (int i = 0; i < 100; i++) {
            Thread t = new Thread(runnable);
            t.start();
        }
    }
}
