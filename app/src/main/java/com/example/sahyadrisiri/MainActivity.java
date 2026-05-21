package com.example.sahyadrisiri;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    private TextView tvAiInsight;
    private FloatingActionButton fabReport;
    private BottomNavigationView bottomNav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvAiInsight = findViewById(R.id.tvAiInsight);
        fabReport = findViewById(R.id.fabReport);
        bottomNav = findViewById(R.id.bottomNav);

        // AI Insight Text
        tvAiInsight.setText(
                "3 streams show improved clarity after rainfall. " +
                        "Monitor Sharavathi Tributary — turbidity rising."
        );

        // Floating Action Button → Report Screen
        fabReport.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, ReportActivity.class);
            startActivity(intent);
        });

        // Bottom Navigation
        bottomNav.setOnItemSelectedListener(item -> {
            int id = item.getItemId();

            if (id == R.id.nav_map) {
                Intent intent = new Intent(MainActivity.this, MapActivity.class);
                startActivity(intent);
                return true;

            } else if (id == R.id.nav_alerts) {
                Intent intent = new Intent(MainActivity.this, AlertActivity.class);
                startActivity(intent);
                return true;

            } else if (id == R.id.nav_wiki) {
                Intent intent = new Intent(MainActivity.this, WikiActivity.class);
                startActivity(intent);
                return true;
            }
            return false;
        });
    }
}
