package com.example.firstlessoncounter;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.location.GnssAntennaInfo;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView textCount;
    private Button button;

    private int count = 0;
    private View.OnClickListener Listener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        textCount = findViewById(R.id.textCount);
        button = findViewById(R.id.button);


        button.setOnClickListener(Listener);
    }
        private View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count++;
                textCount.setText(Integer.toString(count));
            }
        };

    @Override
    protected void onStart() {
        Toast toast = Toast.makeText(this, "Старт Активности", Toast.LENGTH_SHORT);
        toast.show();
        super.onStart();
    }

    @Override
    protected void onStop() {
        Toast toast = Toast.makeText(this, "Стоп активности", Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.LEFT, 0, 0);
        toast.show();
        super.onStop();
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState, @NonNull PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        outState.putInt("key", count);


        Toast toast = Toast.makeText(this, "Запись данных в контейнер Bundle", Toast.LENGTH_SHORT);
        toast.show();
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        count = savedInstanceState.getInt("key");

        Toast toast = Toast.makeText(this, "Считывание данных из контейнера Bundle", Toast.LENGTH_SHORT);
        toast.show();
    }

    @Override
    protected void onDestroy() {
        Toast toast = Toast.makeText(this, "Уничтожение Активности", Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.BOTTOM, 0, 0);
        toast.show();
        super.onDestroy();
    }

    @Override
    protected void onPause() {
        Toast toast = Toast.makeText(this, R.string.pause_activity, Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.TOP, 0, 0);
        toast.show();
        super.onPause();
    }

    @Override
    protected void onResume() {
        Toast toast = Toast.makeText(this, R.string.resume_activity, Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER, 0, 0);

        LinearLayout toastContainer = (LinearLayout) toast.getView();

        ImageView cat = new ImageView(this);
        cat.setImageResource(R.drawable.cat);
        toastContainer.addView(cat, 1);
        toast.show();
        super.onResume();
    }
}