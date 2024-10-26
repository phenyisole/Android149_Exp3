package com.example.exp3;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity3 extends AppCompatActivity {

    private TextView testTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        testTextView = findViewById(R.id.test_text_view);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.font_small) {
            testTextView.setTextSize(10);
            return true;
        } else if (id == R.id.font_medium) {
            testTextView.setTextSize(16);
            return true;
        } else if (id == R.id.font_large) {
            testTextView.setTextSize(20);
            return true;
        } else if (id == R.id.color_red) {
            testTextView.setTextColor(Color.RED);
            return true;
        } else if (id == R.id.color_black) {
            testTextView.setTextColor(Color.BLACK);
            return true;
        } else if (id == R.id.toast_message) {
            Toast.makeText(this, "普通菜单项被点击", Toast.LENGTH_SHORT).show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}