package View;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPager;
import android.text.Layout;
import android.util.AttributeSet;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

/**
 * Created by java on 14.12.2016.
 */

public class SwipeItemView  extends FrameLayout implements GestureDetector.OnGestureListener {

    private GestureDetectorCompat mGestureDetectorCompat;
    private View mTopView;
    private View mBottomView;

    private boolean isLeftDirection;

    public SwipeItemView(Context context) {
        super(context);
        mGestureDetectorCompat = new GestureDetectorCompat(getContext(), this);
    }

    public SwipeItemView(Context context, AttributeSet attrs) {
        super(context, attrs);

        mTopView = new View(getContext());
        mBottomView = new View(getContext());

        LayoutParams params = new LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
        );

        mTopView.setLayoutParams(params);
        mBottomView.setLayoutParams(params);

        ViewCompat.setBackground(mTopView, new ColorDrawable(Color.RED));
        ViewCompat.setBackground(mBottomView, new ColorDrawable(Color.GREEN));

        addView(mBottomView);
        addView(mTopView);

        mGestureDetectorCompat = new GestureDetectorCompat(getContext(), this);
    }

    public SwipeItemView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public SwipeItemView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return super.onInterceptTouchEvent(ev);
    }



    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        mGestureDetectorCompat.onTouchEvent(ev);
        if(ev.getAction() == MotionEvent.ACTION_UP){
            //if(mTopView.getX()<mTopView.getMeasuredWidth()/2;
        }

        return super.onTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return super.onTouchEvent(event);
    }


    @Override
    public boolean onDown(MotionEvent motionEvent) {
        return false;
    }

    @Override
    public void onShowPress(MotionEvent motionEvent) {

    }

    @Override
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
        Log.d(SwipeItemView.class.getSimpleName(), "scroll");
       //if(motionEvent1.getX()<mTopView.getMeasuredWidth()/2){
            mTopView.setX(motionEvent1.getX());
      //  }

        return false;
    }

    @Override
    public void onLongPress(MotionEvent motionEvent) {

    }

    @Override
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
        return false;
    }
}
