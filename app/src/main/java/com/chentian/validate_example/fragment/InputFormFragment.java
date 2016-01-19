package com.chentian.validate_example.fragment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.Bind;
import butterknife.ButterKnife;

import com.chentian.validate_example.R;
import com.chentian.validate_example.widget.LineChartWithSpot;
import com.chentian.validate_example.widget.SpotView;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;

/**
 * @author chentian
 */
public class InputFormFragment extends Fragment {

  @Bind(R.id.chart) LineChartWithSpot chart;

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_input_form, container, false);
    ButterKnife.bind(this, view);

    bindChart();

    return view;
  }

  private void bindChart() {
    List<Entry> valsComp1 = new ArrayList<>();
    valsComp1.add(new Entry(100.000f, 0));
    valsComp1.add(new Entry(50.000f, 1));
    valsComp1.add(new Entry(70.000f, 2));
    valsComp1.add(new Entry(80.000f, 3));
    valsComp1.add(new Entry(90.000f, 4));
    valsComp1.add(new Entry(10.000f, 5));

    LineDataSet setComp1 = new LineDataSet(valsComp1, "Company");
    setComp1.setAxisDependency(YAxis.AxisDependency.LEFT);

    List<LineDataSet> dataSets = Collections.singletonList(setComp1);

    List<String> xVals = Arrays.asList("1", "2", "3", "4", "5", "6");

    LineData data = new LineData(xVals, dataSets);
    chart.setData(data);
    chart.invalidate(); // refresh

    chart.setSpotView(SpotView.newInstance(chart));
  }
}
