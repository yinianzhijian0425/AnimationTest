package test.yunjing.tech.animationtest;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by xining on 2017/10/10 0010.
 */

@SuppressLint("AppCompatCustomView")
public class MyTextView extends TextView {
    public MyTextView(Context context) {
        super(context);
    }

    public MyTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MyTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    /***
     * 。TextView中虽然有setText(CharSequence text) 函数，但这个函数的参数类型是CharSequence，而不是Character类型。所以我们要自定义一个类派生自TextView来改变TextView的字符
     * @param character
     */
    public void setCharText(Character character){
        setText(String.valueOf(character));
    }
}
