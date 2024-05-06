import java.util.Timer;
import java.util.TimerTask;

public class FocusTimer {
    private Timer timer;
    private int interval; // 间隔时间，单位：毫秒

    public FocusTimer(int interval) {
        this.interval = interval;
        timer = new Timer();
    }

    public void start() {
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                System.out.println("It's time to take a break and relax!"); // 提醒用户休息
            }
        }, 0, interval);
    }

    public void stop() {
        timer.cancel();
    }

    public static void main(String[] args) {
        // 创建一个间隔为30分钟的专注时钟
        FocusTimer focusTimer = new FocusTimer(30 * 60 * 1000); // 30分钟，单位：毫秒
        focusTimer.start();
    }
}
