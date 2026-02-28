package omgtu.ru;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class MainFragment extends Fragment {

    private OnMainFragmentInteractionListener mListener;

    public interface OnMainFragmentInteractionListener {
        void onOpenCatalog();
        void onOpenProfile();
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof OnMainFragmentInteractionListener) {
            mListener = (OnMainFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnMainFragmentInteractionListener");
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);

        Button btnCatalog = view.findViewById(R.id.button_first);
        btnCatalog.setText("Open Catalog");
        btnCatalog.setOnClickListener(v -> {
            if (mListener != null) {
                mListener.onOpenCatalog();
            }
        });

        Button btnProfile = view.findViewById(R.id.button_second);
        btnProfile.setText("My Profile");
        btnProfile.setOnClickListener(v -> {
            if (mListener != null) {
                mListener.onOpenProfile();
            }
        });

        return view;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }
}
