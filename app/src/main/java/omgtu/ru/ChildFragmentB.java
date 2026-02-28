package omgtu.ru;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class ChildFragmentB extends BaseFragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_child_b, container, false);
        view.findViewById(R.id.btn_finish).setOnClickListener(v -> {
            // Уведомляем систему через EventBus о завершении настройки
            eventBus.post(new Events.ShowDetailsEvent("Setup Completed Successfully!"));
        });
        return view;
    }

    @org.greenrobot.eventbus.Subscribe
    public void onEvent(Object event) {}
}
