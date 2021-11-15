package apiUser;

import javax.management.timer.Timer;
import java.util.HashMap;
import java.util.Map;


public class FxScheduler {

    private static FxScheduler instance;

    private final Map<String, Timer> timers = new HashMap<>();

    private FxScheduler() {
    }

    public static FxScheduler getInstance() {
        if (instance == null) instance = new FxScheduler();
        return instance;
    }

    public void startTimer(String name) {
        if (!timers.containsKey(name))
            timers.put(name, new Timer());
        timers.get(name).start();
    }

    public void restartTimer(String name) {
        timers.get(name).stop();
        timers.get(name).start();
    }

    public void stopTimer(String name) {
        timers.get(name).stop();
    }

    public Map<String, Timer> getTimers() {
        return timers;
    }

}

