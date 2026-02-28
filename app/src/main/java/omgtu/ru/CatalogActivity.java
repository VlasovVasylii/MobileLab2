package omgtu.ru;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

public class CatalogActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catalog);
        
        // В реальном приложении здесь бы загружался фрагмент с каталогом
        // Но для демо добавим кнопку "Заказать", которая имитирует завершение
        findViewById(R.id.catalog_main).setOnClickListener(v -> {
            Intent intent = new Intent(this, OrderSuccessActivity.class);
            // Флаги: очистить стек, чтобы нельзя было вернуться назад к каталогу/оформлению
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
        });
    }
}
