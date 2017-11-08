package test.yunjing.tech.animationtest;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xining on 2017/10/12 0012.
 */

public class LayoutAnimationActivity extends AppCompatActivity {
    private ListView mListView;
    private ArrayAdapter mAdapter;
    private Button mAddListBtn;
    private LayoutAnimationController layoutAnimationController;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout_animation);
        mListView = (ListView) findViewById(R.id.listview);
        mAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, getData());
        mListView.setAdapter(mAdapter);

        mAddListBtn = (Button) findViewById(R.id.addlist);
        doLayoutAnimation();
        mListView.setLayoutAnimation(layoutAnimationController);
        mAddListBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAdapter.addAll(getData());
            }
        });
    }

    private void doLayoutAnimation() {
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.slide_in_left);
         layoutAnimationController = new LayoutAnimationController(animation);
        layoutAnimationController.setDelay(1);
        layoutAnimationController.setOrder(LayoutAnimationController.ORDER_NORMAL);
    }

    private List<String> getData() {
        List<String> data = new ArrayList<String>();
        data.add("测试数据1");
        data.add("测试数据2");
        data.add("测试数据3");
        data.add("测试数据4");

        return data;
    }
}
