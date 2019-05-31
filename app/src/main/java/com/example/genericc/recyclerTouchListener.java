package com.example.genericc;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

public class recyclerTouchListener implements RecyclerView.OnItemTouchListener {

    private ClickListener clickListener;
    private GestureDetector gestureDetector;

    public recyclerTouchListener(Context context, final RecyclerView recyclerView, final ClickListener clickListener) {
        this.clickListener = clickListener;

        gestureDetector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() {
            @Override
            public boolean onSingleTapUp(MotionEvent e) {
//              single click action
//                View child = recyclerView.findChildViewUnder(e.getX(), e.getY());
//                if (child !=null && clickListener != null){
//                    clickListener.onClick(child, recyclerView.getChildAdapterPosition(child));
//                }
                return true;
            }

            @Override
            public void onLongPress(MotionEvent e) {
                View child = recyclerView.findChildViewUnder(e.getX(), e.getY());
                if(child !=null && clickListener !=null){
                    clickListener.onLongPress(child, recyclerView.getChildAdapterPosition(child));
                }

            }
        });
    }

    @Override
    public boolean onInterceptTouchEvent(@NonNull RecyclerView recyclerView, @NonNull MotionEvent motionEvent) {

        View child = recyclerView.findChildViewUnder(motionEvent.getX(),motionEvent.getY()) ;
        if (child != null && clickListener != null && gestureDetector.onTouchEvent(motionEvent)){
            clickListener.onLongPress(child, recyclerView.getChildAdapterPosition(child));
        }
    return  false;
    }
    @Override
    public void onTouchEvent(@NonNull RecyclerView recyclerView, @NonNull MotionEvent motionEvent) {
        View child = recyclerView.findChildViewUnder(motionEvent.getX(), motionEvent.getY());
        if (child != null && clickListener != null) {
            recyclerView.getChildAdapterPosition(child);
        }
    }

    @Override
    public void onRequestDisallowInterceptTouchEvent(boolean b) {

    }

    public interface ClickListener {
        void onClick(View view, int position);

        void onLongPress(View view, int position);

    }
}
