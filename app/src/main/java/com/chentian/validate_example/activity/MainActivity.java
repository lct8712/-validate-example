package com.chentian.validate_example.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;

import com.chentian.validate_example.R;
import com.chentian.validate_example.fragment.InputFormFragment;

public class MainActivity extends FragmentActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    Fragment fragment = new InputFormFragment();
    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment)
        .commitAllowingStateLoss();
  }
}
