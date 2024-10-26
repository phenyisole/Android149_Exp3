package com.example.exp3;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity4 extends AppCompatActivity {

    SimpleAdapter adapter;
    List<Map<String, Object>> chatList;
    private ActionMode actionMode; // ActionMode对象
    private int selectedPosition = -1; // 选中的列表项位置
    private View selectedView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main4);

        // 初始化数据
        chatList = new ArrayList<>();
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

        String[] from = {"icon", "message"}; // 数据源的键
        int[] to = {R.id.chat_icon, R.id.chat_message}; // 视图 ID

        adapter = new SimpleAdapter(
                this,                          // 上下文
                chatList,                      // 数据源
                R.layout.list_item,            // 列表项布局
                from,                          // 键
                to                             // 视图 ID
        );

        // 绑定适配器到 ListView
        ListView listView = findViewById(R.id.chat_list);
        listView.setAdapter(adapter);

        // 为列表项设置点击事件
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (actionMode != null) {
                    return; // 如果正在显示ActionMode，忽略点击
                }
                selectedPosition = position;
                selectedView = view;
                // 开启ActionMode
                actionMode = startActionMode(actionModeCallback);
                view.setSelected(true);
            }
        });

    }

    // 定义ActionMode回调
    private final ActionMode.Callback actionModeCallback = new ActionMode.Callback() {
        @Override
        public boolean onCreateActionMode(ActionMode mode, Menu menu) {
            // 加载上下文菜单
            getMenuInflater().inflate(R.menu.menu_main2, menu);
            return true;
        }

        @Override
        public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
            return false; // 如果你想在每次显示时更新菜单，可以返回true
        }

        @Override
        public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
            if (item.getItemId() == R.id.select) {
                if (selectedPosition != -1) {
                    selectedView.setBackgroundColor(Color.YELLOW);
                    adapter.notifyDataSetChanged(); // 更新适配器
                    mode.finish(); // 结束ActionMode
                }
                mode.finish(); // 结束ActionMode
                return true;
            } else if (item.getItemId() == R.id.delete) {
                if (selectedPosition != -1) {
                    chatList.remove(selectedPosition); // 从数据源中移除item
                    adapter.notifyDataSetChanged(); // 更新适配器
                    mode.finish(); // 结束ActionMode
                }
                return true;
            } else {
                return false; // 处理未知菜单项
            }
        }

        @Override
        public void onDestroyActionMode(ActionMode mode) {
            actionMode = null; // 重置ActionMode
        }
    };
}
