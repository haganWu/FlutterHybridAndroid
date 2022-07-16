package com.hagan.flutterhybridandroid;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import io.flutter.embedding.android.FlutterActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText paramInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        paramInput = findViewById(R.id.paramInput);
        findViewById(R.id.bt_jump).setOnClickListener(this);
        findViewById(R.id.bt_jump1).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.bt_jump1) {
            //直接启动一个FlutterActivity 的方式（无法自定义插件）
            startActivity(FlutterActivity.withNewEngine().initialRoute("来自route1").build(MainActivity.this));
        }
        if (v.getId() == R.id.bt_jump) {
            //使用复写FlutterActivity 的方式（可以自定义插件）
            String inputParams = paramInput.getText().toString().trim();
            FlutterAppActivity.start(MainActivity.this, inputParams);
        }
    }
}