package omgtu.ru;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class ChildFragmentA extends BaseFragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_child_a, container, false);
        view.findViewById(R.id.btn_to_b).setOnClickListener(v -> {
            // Переход к следующему дочернему фрагменту через родителя
            if (getParentFragment() instanceof ParentFragment) {
                ((ParentFragment) getParentFragment()).showChildB();
            }
        });
        return view;
    }

    // Обязательный пустой метод для EventBus, если в BaseFragment есть регистрация
    @org.greenrobot.eventbus.Subscribe
    public void onEvent(Object event) {}
}
