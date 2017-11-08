package test.yunjing.tech.animationtest;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

/**
 * Created by xining on 2017/10/12 0012.
 * 弃用
 */

public class AnimateLayoutChangesActivity extends AppCompatActivity implements View.OnClickListener {


    private LinearLayout layoutTransitionGroup;

    private int i = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animate_layoutchanges);
        layoutTransitionGroup = (LinearLayout) findViewById(R.id.layoutTransitionGroup);
        findViewById(R.id.add_btn).setOnClickListener(this);
        findViewById(R.id.remove_btn).setOnClickListener(this);
    }

    private void addButtonView() {
        i++;
        Button button = new Button(this);
        button.setText("button" + i);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        button.setLayoutParams(params);
        layoutTransitionGroup.addView(button, 0);
    }

    private void removeButtonView() {
        if (i > 0) {
            layoutTransitionGroup.removeViewAt(0);
        }
        i--;
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.add_btn) {
            addButtonView();
        }
        if (v.getId() == R.id.remove_btn) {
            removeButtonView();
        }

    }
}
