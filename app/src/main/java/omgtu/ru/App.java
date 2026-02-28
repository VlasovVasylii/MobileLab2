package omgtu.ru;

import android.app.Application;
import org.greenrobot.eventbus.EventBus;

public class App extends Application {
    private static EventBus eventBus;

    @Override
    public void onCreate() {
        super.onCreate();
        eventBus = EventBus.getDefault();
    }

    public static EventBus getEventBus() {
        return eventBus;
    }
}
