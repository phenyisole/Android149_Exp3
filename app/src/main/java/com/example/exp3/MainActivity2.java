package com.example.exp3;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity2 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        // 获取主界面中的一个按钮（假设用于触发对话框）
        Button showDialogButton = findViewById(R.id.selected111) ;

        showDialogButton.setOnClickListener(v -> showLoginDialog());
    }

    // 创建并显示自定义对话框的方法
    private void showLoginDialog() {
        // 使用 AlertDialog.Builder 创建对话框
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        // 加载自定义布局
        LayoutInflater inflater = getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.dialog_login, null);

        // 将自定义布局添加到 AlertDialog
        builder.setView(dialogView);

        // 初始化对话框中的视图组件
        EditText usernameEditText = dialogView.findViewById(R.id.editText_username);
        EditText passwordEditText = dialogView.findViewById(R.id.editText_password);
        Button confirmButton = dialogView.findViewById(R.id.button_confirm);
        Button cancelButton = dialogView.findViewById(R.id.button_cancel);

        // 创建并显示对话框
        AlertDialog dialog = builder.create();
        dialog.show();

        // 设置按钮点击事件
        confirmButton.setOnClickListener(v -> {
            String username = usernameEditText.getText().toString();
            String password = passwordEditText.getText().toString();
            Toast.makeText(this, "用户名: " + username + "\n密码: " + password, Toast.LENGTH_SHORT).show();
        });

        cancelButton.setOnClickListener(v -> dialog.dismiss());
    }
}