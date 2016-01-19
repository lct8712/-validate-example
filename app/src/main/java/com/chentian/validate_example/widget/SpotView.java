package com.chentian.validate_example.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import butterknife.Bind;
import butterknife.ButterKnife;

import com.chentian.validate_example.R;

/**
 * @author chentian
 */
public class SpotView extends RelativeLayout {

  @Bind(R.id.spot) View spot;

  public SpotView(Context context) {
    super(context);
  }

  public SpotView(Context context, AttributeSet attrs) {
    super(context, attrs);
  }

  public SpotView(Context context, AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);
  }

  public static SpotView newInstance(ViewGroup parent) {
    return (SpotView) LayoutInflater.from(parent.getContext()).inflate(R.layout.widgeet_spot, parent, false);
  }

  @Override
  protected void onFinishInflate() {
    super.onFinishInflate();

    ButterKnife.bind(this, this);
  }

  @Override
  protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
    super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    Log.d("chentian", "spot measured width: " + spot.getMeasuredWidth());
    Log.d("chentian", "widthMeasureSpec width: " + MeasureSpec.getSize(widthMeasureSpec));

    widthMeasureSpec = MeasureSpec.makeMeasureSpec(spot.getMeasuredWidth(), MeasureSpec.getMode(widthMeasureSpec));
    heightMeasureSpec = MeasureSpec.makeMeasureSpec(spot.getMeasuredHeight(), MeasureSpec.getMode(heightMeasureSpec));
    super.onMeasure(widthMeasureSpec, heightMeasureSpec);
  }
}
