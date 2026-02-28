package omgtu.ru;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class ParentFragment extends BaseFragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_container, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (savedInstanceState == null) {
            getChildFragmentManager().beginTransaction()
                    .replace(R.id.child_fragment_container, new ChildFragmentA())
                    .commit();
        }
    }

    public void showChildB() {
        getChildFragmentManager().beginTransaction()
                .replace(R.id.child_fragment_container, new ChildFragmentB())
                .addToBackStack(null) // Позволяет вернуться к Child A
                .commit();
    }

    @org.greenrobot.eventbus.Subscribe
    public void onEvent(Object event) {}
}
