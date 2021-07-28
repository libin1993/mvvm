package com.synway.mvvm.base;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/**
 * @Modified by 王骏杰
 * @data 2019/8/18
 * @des 解决RecyclerView嵌套ecyclerView竖向滑动冲突
 */
public class NestRecyclerView extends RecyclerView {

    private int lastVisibleItemPosition;
    private int firstVisibleItemPosition;
    private float mLastY = 0;// 记录上次Y位置
    private boolean isTopToBottom = false;
    private boolean isBottomToTop = false;
    public NestRecyclerView(Context context) {
        this(context, null);
    }

    public NestRecyclerView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public NestRecyclerView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }



    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.d("libin", 4444+":"+event.getAction());
        int action = event.getAction();
        switch (action) {
            case MotionEvent.ACTION_DOWN:
                mLastY = event.getY();
                //不允许父View拦截事件
                if (getParent().getParent() instanceof RecyclerView){
                    Log.d("libin", 1111111+"");
                }
                if (getParent() instanceof RecyclerView){
                    Log.d("libin", 22222+"");
                }

                if (getParent() instanceof FrameLayout){
                    Log.d("libin", 333+"");
                }

                getParent().requestDisallowInterceptTouchEvent(true);
                break;
            case MotionEvent.ACTION_MOVE:
                float nowY = event.getY();
                isIntercept(nowY);
                if (isBottomToTop||isTopToBottom){
                    getParent().requestDisallowInterceptTouchEvent(false);
                    return false;
                }else{
                   getParent().requestDisallowInterceptTouchEvent(true);
                }
                mLastY = nowY;
                break;
            case MotionEvent.ACTION_UP:
            case MotionEvent.ACTION_CANCEL:
                getParent().requestDisallowInterceptTouchEvent(false);
                break;
        }
        return super.onTouchEvent(event);
    }

    private void isIntercept(float nowY){

        isTopToBottom = false;
        isBottomToTop = false;

        RecyclerView.LayoutManager layoutManager = getLayoutManager();
        if (layoutManager instanceof GridLayoutManager) {
            //得到当前界面，最后一个子视图对应的position
            lastVisibleItemPosition = ((GridLayoutManager) layoutManager)
                    .findLastVisibleItemPosition();
            //得到当前界面，第一个子视图的position
            firstVisibleItemPosition = ((GridLayoutManager) layoutManager)
                    .findFirstVisibleItemPosition();
        }else if (layoutManager instanceof LinearLayoutManager){
            //得到当前界面，最后一个子视图对应的position
            lastVisibleItemPosition = ((LinearLayoutManager) layoutManager)
                    .findLastVisibleItemPosition();
            //得到当前界面，第一个子视图的position
            firstVisibleItemPosition = ((LinearLayoutManager) layoutManager)
                    .findFirstVisibleItemPosition();
        }
        //得到当前界面可见数据的大小
        int visibleItemCount = layoutManager.getChildCount();
        //得到RecyclerView对应所有数据的大小
        int totalItemCount = layoutManager.getItemCount();
        Log.d("libin","onScrollStateChanged");
        if (visibleItemCount>0) {

            if (lastVisibleItemPosition == totalItemCount - 1) {
                //最后视图对应的position等于总数-1时，说明上一次滑动结束时，触底了
                Log.d("nestScrolling", "触底了");

                /**
                 * 注意这里有非常关键的两点，也是我修改完善之前哥们博客的有坑的两点，
                 * 第一点是canScrollVertically传的正负值问题，判断向上用正值1，向下则反过来用负值-1，
                 * 第二点是canScrollVertically返回值的问题，true时是代表可以滑动，false时才代表划到顶部或者底部不可以再滑动了，所以这个判断前要加逻辑非!运算符
                 * 补充了这两点基本效果就很完美了。
                 */
                if (!NestRecyclerView.this.canScrollVertically(1) && nowY < mLastY) {
                    // 不能向上滑动
                    Log.d("libin", "不能向上滑动");
                    isBottomToTop = true;
                } else {
                    Log.d("libin", "向下滑动");
                }
            } else if (firstVisibleItemPosition == 0) {
                //第一个视图的position等于0，说明上一次滑动结束时，触顶了
                Log.d("libin", "触顶了");
                if (!NestRecyclerView.this.canScrollVertically(-1) && nowY > mLastY) {
                    // 不能向下滑动
                    Log.d("libin", "不能向下滑动");
                    isTopToBottom = true;
                } else {
                    Log.d("libin", "向上滑动");
                }
            }
        }
    }

}