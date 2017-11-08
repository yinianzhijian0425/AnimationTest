package test.yunjing.tech.animationtest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by xining on 2017/9/25 0025.
 */

public class ViewAnimationActivity extends AppCompatActivity {
    private Button scale;
    private TextView tv;
    private Button alpha;
    private Button rotate;
    private Button set;
    /***
     * 缩放动画
     */
    private Animation scaleAnimation;
    /***
     * 透明度动画
     */
    private Animation alphaAnimation;
    /***
     *旋转动画
     */
    private Animation rotateAnimation;
    /***
     * set动画
     */
    private Animation setAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_animation);
        alpha = (Button) findViewById(R.id.alpha);
        scale = (Button) findViewById(R.id.scale);
        rotate = (Button) findViewById(R.id.rotate);
        set = (Button) findViewById(R.id.set);
        tv = (TextView) findViewById(R.id.tv);
        alphaAnimation = AnimationUtils.loadAnimation(this, R.anim.anim_alpha);
        scaleAnimation = AnimationUtils.loadAnimation(this, R.anim.anim_scale);
        rotateAnimation = AnimationUtils.loadAnimation(this, R.anim.anim_rotate);
        setAnimation = AnimationUtils.loadAnimation(this, R.anim.anim_set);

        scale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv.startAnimation(scaleAnimation);
            }
        });
        alpha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv.startAnimation(alphaAnimation);
            }
        });
        rotate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv.startAnimation(rotateAnimation);
            }
        });
        set.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv.startAnimation(setAnimation);
            }
        });
    }
}