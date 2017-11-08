package test.yunjing.tech.animationtest;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xining on 2017/10/12 0012.
 */

public class ListViewItemAnimationActivity extends AppCompatActivity {
    private ListAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview_item_animation);
        List<Drawable> drawables = new ArrayList<>();
        drawables.add(getResources().getDrawable(R.mipmap.pic1));
        drawables.add(getResources().getDrawable(R.mipmap.pic2));
        drawables.add(getResources().getDrawable(R.mipmap.pic3));
        drawables.add(getResources().getDrawable(R.mipmap.pic4));
        drawables.add(getResources().getDrawable(R.mipmap.pic5));
        drawables.add(getResources().getDrawable(R.mipmap.pic6));
        drawables.add(getResources().getDrawable(R.mipmap.pic7));
        drawables.add(getResources().getDrawable(R.mipmap.pic8));
        drawables.add(getResources().getDrawable(R.mipmap.pic9));


        ListView listView = (ListView) findViewById(R.id.list);
        adapter = new ListAdapter(this, listView, drawables, 10);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //关键在这里哦
                Drawable drawable = (Drawable) adapter.getItem(position);
            }
        });
    }
}
