package test.yunjing.tech.animationtest;

import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.TimeInterpolator;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by xining on 2017/9/25 0025.
 * 属性动画
 */

public class PropertyAnimatorActivity extends AppCompatActivity {
    private Button btn;
    private TextView tv;
    private TextView tv1;
    private MyTextView tv2;
    private Button btn1;
    private Button btn2;
    private Button btn3;
    private Button btn4;
    private MyPointView pointView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.android_property_animator);
        btn = (Button) findViewById(R.id.btn);
        tv = (TextView) findViewById(R.id.tv);
        tv1 = (TextView) findViewById(R.id.tv1);
        tv2 = (MyTextView) findViewById(R.id.tv2);
        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        btn3 = (Button) findViewById(R.id.btn3);
        btn4 = (Button) findViewById(R.id.btn4);
        pointView = (MyPointView) findViewById(R.id.pointView);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //视图动画
//                TranslateAnimation translateAnimation = new TranslateAnimation(Animation.ABSOLUTE, 0, Animation.ABSOLUTE, 400, Animation.ABSOLUTE, 0, Animation.ABSOLUTE, 400);
//                translateAnimation.setFillAfter(true);
//                translateAnimation.setDuration(1000);
//                tv.startAnimation(translateAnimation);

                //属性动画
//                ValueAnimator vallueAnimator = ValueAnimator.ofInt(0, 400);
//                vallueAnimator.setDuration(1000);
//                vallueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
//                    @Override
//                    public void onAnimationUpdate(ValueAnimator animation) {
//                        int curValue = (int) animation.getAnimatedValue();
//                        Log.e("我来了", "curValue :" + curValue);
//                    }
//                });
//                vallueAnimator.start();


                //属性动画结合布局使用
                doAnimator();

            }


        });
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(PropertyAnimatorActivity.this, "click", Toast.LENGTH_SHORT).show();
            }
        });
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                //数值转化
//                final ValueAnimator animator = ValueAnimator.ofInt(0, 400);
//                animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
//                    @Override
//                    public void onAnimationUpdate(ValueAnimator animation) {
//                        int current_animator = (int) animator.getAnimatedValue();
//                        tv.layout(current_animator, current_animator, current_animator + tv.getWidth(), current_animator + tv.getHeight());
//
//                    }
//                });
//                animator.setDuration(1000);
////                animator.setInterpolator(new BounceInterpolator());
//                animator.setInterpolator(new MyInterpolator());
//                animator.start();


                //色值变化
                final ValueAnimator animator1 = ValueAnimator.ofInt(0xffff0000, 0xff0000ff);
                animator1.setDuration(1000);
                animator1.setEvaluator(new ArgbEvaluator());
                animator1.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator animation) {
                        int c = (int) animator1.getAnimatedValue();
                        tv.setBackgroundColor(c);
                    }
                });
                animator1.start();

            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                pointView.doPointAnim();
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ValueAnimator va = ValueAnimator.ofObject(new CharEvalutor(), new Character('A'), new Character('Z'));
                va.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator animation) {
                        char c = (char) animation.getAnimatedValue();
                        tv1.setText(String.valueOf(c));
                    }
                });
                va.setDuration(1000);
                va.setInterpolator(new DecelerateInterpolator());
                va.start();
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doOfObjectAnim();
            }
        });
    }

    private void doOfObjectAnim() {
        //根据PropertyValuesHolder.ofObject生成一个PropertyValuesHolder实例，注意它的属性就是CharText，
        // 所对应的set函数就是setCharText,由于CharEvaluator的中间值是Character类型，所以CharText属性所对应的完整的函数声明为setCharText(Character character)；
        // 这也就是我们为什么要自定义一个MyTextView原因，就是因为TextView中没有setText(Character character)这样的函数。
        PropertyValuesHolder charHolder = PropertyValuesHolder.ofObject("CharText", new CharEvalutor(), new Character('A'), new Character('Z'));
        ObjectAnimator animator = ObjectAnimator.ofPropertyValuesHolder(tv2, charHolder);
        animator.setDuration(3000);
        animator.setInterpolator(new AccelerateInterpolator());
        animator.start();
    }

    class CharEvalutor implements TypeEvaluator<Character> {

        @Override
        public Character evaluate(float fraction, Character startValue, Character endValue) {
            int startint = startValue;
            int endint = endValue;
            int curint = (int) (startint + fraction * (endint - startint));
            char curchat = (char) curint;
            return curchat;
        }
    }

    class MyInterpolator implements TimeInterpolator {

        @Override
        public float getInterpolation(float input) {
//            return 1 - input;//倒叙
            return input;//正序
        }
    }

    /***
     *给布局设置动画
     */
    private void doAnimator() {
        ValueAnimator animator = ValueAnimator.ofInt(0, 400);
        animator.setDuration(1000);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                int currentValue = (int) animation.getAnimatedValue();
                tv.layout(currentValue, currentValue, currentValue + tv.getWidth(), currentValue + tv.getHeight());
            }
        });
        animator.start();
    }
}
