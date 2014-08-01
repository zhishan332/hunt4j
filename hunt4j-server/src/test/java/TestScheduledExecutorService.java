import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created with IntelliJ IDEA.
 * User: wangq
 * Date: 14-5-19
 * Time: 下午10:33
 * To change this template use File | Settings | File Templates.
 */
public class TestScheduledExecutorService {

    public static void main(String[] args) {
        ScheduledExecutorService scheduler= Executors.newScheduledThreadPool(5);
        scheduler.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getId()+"在执行............");
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
                }
            }
        }, 1, 2, TimeUnit.SECONDS);

        ScheduledExecutorService scheduler2= Executors.newScheduledThreadPool(5);
        scheduler2.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getId()+"在执行............");
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
                }
            }
        }, 1, 2, TimeUnit.SECONDS);
    }
}
