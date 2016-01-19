package com.chentian.validate_example.widget;

import android.content.Context;
import android.util.AttributeSet;

import com.github.mikephil.charting.charts.LineChart;

/**
 * @author chentian
 */
public class LineChartWithSpot extends LineChart {

  private SpotView spotView;

  public LineChartWithSpot(Context context) {
    super(context);
  }

  public LineChartWithSpot(Context context, AttributeSet attrs) {
    super(context, attrs);
  }

  public LineChartWithSpot(Context context, AttributeSet attrs, int defStyle) {
    super(context, attrs, defStyle);
  }

  public void setSpotView(SpotView spotView) {
    this.spotView = spotView;
    addView(spotView);
  }

  @Override
  protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
    super.onMeasure(widthMeasureSpec, heightMeasureSpec);

    spotView.measure(widthMeasureSpec, heightMeasureSpec);
  }

  @Override
  protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
    super.onLayout(changed, left, top, right, bottom);

    spotView.layout(500, 500, 500 + spotView.getMeasuredWidth(), 500 + spotView.getMeasuredHeight());
  }
}
