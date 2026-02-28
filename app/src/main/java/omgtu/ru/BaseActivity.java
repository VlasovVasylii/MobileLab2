package omgtu.ru;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import org.greenrobot.eventbus.EventBus;

public abstract class BaseActivity extends AppCompatActivity {

    protected EventBus eventBus;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        eventBus = App.getEventBus();
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (!eventBus.isRegistered(this)) {
            eventBus.register(this);
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (eventBus.isRegistered(this)) {
            eventBus.unregister(this);
        }
    }
}
