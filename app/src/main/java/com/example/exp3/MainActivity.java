package com.example.exp3;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);  // 绑定主布局

        // 定义数据源
        List<Map<String, Object>> chatList = new ArrayList<>();
        Map<String, Object> chatItem;

        chatItem = new HashMap<>();
        chatItem.put("icon", R.drawable.cat);
        chatItem.put("message", "cat");
        chatList.add(chatItem);

        chatItem = new HashMap<>();
        chatItem.put("icon", R.drawable.dog);
        chatItem.put("message", "dog");
        chatList.add(chatItem);

        chatItem = new HashMap<>();
        chatItem.put("icon", R.drawable.lion);
        chatItem.put("message", "lion");
        chatList.add(chatItem);

        chatItem = new HashMap<>();
        chatItem.put("icon", R.drawable.elephant);
        chatItem.put("message", "elephant");
        chatList.add(chatItem);

        chatItem = new HashMap<>();
        chatItem.put("icon", R.drawable.monkey);
        chatItem.put("message", "monkey");
        chatList.add(chatItem);

        // 创建 SimpleAdapter
        String[] from = {"icon", "message"}; // 数据源的键
        int[] to = {R.id.chat_icon, R.id.chat_message}; // 视图 ID

        SimpleAdapter adapter = new SimpleAdapter(
                this,                          // 上下文
                chatList,                      // 数据源
                R.layout.list_item,            // 列表项布局
                from,                          // 键
                to                             // 视图 ID
        );

        // 绑定适配器到 ListView
        ListView listView = findViewById(R.id.chat_list);
        listView.setAdapter(adapter);

        Button selectedMessageButton = findViewById(R.id.selected_animal_button);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Map<String, Object> selectedMessage = chatList.get(position);
                String messageText = (String) selectedMessage.get("message");
                selectedMessageButton.setText(messageText);
            }
        });
    }
}
