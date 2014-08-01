import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created with IntelliJ IDEA.
 * User: wangq
 * Date: 14-5-24
 * Time: 下午8:50
 * To change this template use File | Settings | File Templates.
 */
public class TestScheduledExecutorService2 {
    public static void main(String[] args) throws InterruptedException {
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(5);
        for (int i = 0; i < 3; i++) {
            scheduler.scheduleAtFixedRate(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getId() + "在执行............");
                    try {
                        Thread.sleep(6000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
                    }
                }
            }, 1, 2, TimeUnit.SECONDS);
        }
        scheduler.shutdown();
    }
}
