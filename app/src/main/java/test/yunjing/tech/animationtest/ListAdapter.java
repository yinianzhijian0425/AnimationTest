package test.yunjing.tech.animationtest;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import test.yunjing.tech.animationtest.R;

public class ListAdapter extends BaseAdapter {
    private List<Drawable> mDrawableList = new ArrayList<>();
    private int mLength = 0;
    private LayoutInflater mInflater;
    private Context mContext;
    private ListView mListView;
    private Animation animation;

    public ListAdapter(Context context, ListView listView, List<Drawable> drawables, int length) {
        mDrawableList.addAll(drawables);
        mLength = length;
        mInflater = LayoutInflater.from(context);
        mContext = context;
        mListView = listView;
        animation = AnimationUtils.loadAnimation(mContext, R.anim.bottom_in_anim);
    }

    @Override
    public int getCount() {
        return mLength;
    }

    @Override
    public Object getItem(int position) {
        return mDrawableList.get(position % mDrawableList.size());
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;

        if (convertView == null) {

            holder = new ViewHolder();
            convertView = mInflater.inflate(R.layout.item_layout, null);
            holder.mImageView = (ImageView) convertView.findViewById(R.id.img);
            holder.mTextView = (TextView) convertView.findViewById(R.id.text);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        convertView.startAnimation(animation);
        convertView.setTag(holder);

        holder.mImageView.setImageDrawable(mDrawableList.get(position % mDrawableList.size()));
        holder.mTextView.setText(position+"");

        return convertView;
    }

    public class ViewHolder {
        public ImageView mImageView;
        public TextView mTextView;
    }
}