package omgtu.ru;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import org.greenrobot.eventbus.Subscribe;

public class MainActivity extends BaseActivity implements MainFragment.OnMainFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, new MainFragment())
                    .commit();
        }
    }

    @Override
    public void onOpenCatalog() {
        Intent intent = new Intent(this, CatalogActivity.class);
        startActivity(intent);
    }

    @Override
    public void onOpenProfile() {
        // Открываем ParentFragment, который содержит ChildFragmentManager
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, new ParentFragment())
                .addToBackStack(null)
                .commit();
    }

    @Subscribe
    public void onShowDetails(Events.ShowDetailsEvent event) {
        Toast.makeText(this, event.message, Toast.LENGTH_LONG).show();
        // После успешной настройки возвращаемся на главный экран
        getSupportFragmentManager().popBackStack();
    }
}
