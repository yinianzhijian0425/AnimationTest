package test.yunjing.tech.animationtest;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.GridLayoutAnimationController;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xining on 2017/10/12 0012.
 */

public class GrideAnimationActivity extends AppCompatActivity {
    private GridAdapter mGrideAdapter;
    private List<String> mDatas = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gride_animation);

        /**
         * 填充gridview
         */
        GridView grid = (GridView) findViewById(R.id.grid);
        mDatas.addAll(getData());
        mGrideAdapter = new GridAdapter();
        Animation animation = AnimationUtils.loadAnimation(GrideAnimationActivity.this,R.anim.slide_in_left);
        GridLayoutAnimationController controller = new GridLayoutAnimationController(animation);
        controller.setColumnDelay(0.75f);
        controller.setRowDelay(0.5f);
        controller.setDirection(GridLayoutAnimationController.DIRECTION_BOTTOM_TO_TOP|GridLayoutAnimationController.DIRECTION_LEFT_TO_RIGHT);
        controller.setDirectionPriority(GridLayoutAnimationController.PRIORITY_NONE);
        grid.setLayoutAnimation(controller);
        grid.startLayoutAnimation();
        grid.setAdapter(mGrideAdapter);

        /**
         * 按钮点击响应
         */
        Button addData = (Button) findViewById(R.id.add_data);
        addData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addData();
            }
        });
    }

    private List<String> getData() {

        List<String> data = new ArrayList<String>();
        for (int i = 1; i < 35; i++) {
            data.add("DATA " + i);
        }
        return data;
    }


    public void addData() {
        mDatas.addAll(mDatas);
        mGrideAdapter.notifyDataSetChanged();
    }


    public class GridAdapter extends BaseAdapter {
        public View getView(int position, View convertView, ViewGroup parent) {
            TextView i = new TextView(GrideAnimationActivity.this);
            i.setText(mDatas.get(position));
            i.setLayoutParams(new GridView.LayoutParams(GridView.LayoutParams.WRAP_CONTENT, GridView.LayoutParams.WRAP_CONTENT));
            return i;
        }

        public final int getCount() {
            return mDatas.size();
        }

        public final Object getItem(int position) {
            return null;
        }

        public final long getItemId(int position) {
            return position;
        }
    }
}
