package com.chentian.validate_example.fragment;

import java.util.List;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import butterknife.Bind;
import butterknife.ButterKnife;

import com.chentian.validate_example.R;
import com.chentian.validate_example.utils.ViewUtils;

/**
 * 用户基本信息输入页面
 *
 * @author chentian
 */
public class InputFormFragment extends Fragment {

  @Bind(R.id.input_name) TextView txtInputName;
  @Bind(R.id.input_pinyin) TextView txtInputPinYin;
  @Bind(R.id.input_email) TextView txtInputEmail;
  @Bind(R.id.radio_gender) RadioGroup radioGender;
  @Bind(R.id.radio_education) RadioGroup radioEducation;
  @Bind({
      R.id.checkbox_investment_target_0, R.id.checkbox_investment_target_1,
      R.id.checkbox_investment_target_2, R.id.checkbox_investment_target_3
  }) List<CheckBox> checkBoxInVestmentList;
  @Bind(R.id.btn_submit) Button btnSubmit;

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_input_form, container, false);

    ButterKnife.bind(this, view);
    bindViews();

    return view;
  }

  private void bindViews() {
    txtInputName.setOnFocusChangeListener((v, hasFocus) -> {
      if (!hasFocus) {
        checkInputName();
      }
    });
    txtInputPinYin.setOnFocusChangeListener((v, hasFocus) -> {
      if (!hasFocus) {
        checkInputPinYin();
      }
    });
    txtInputEmail.setOnFocusChangeListener((v, hasFocus) -> {
      if (!hasFocus) {
        checkInputEmail();
      }
    });
    btnSubmit.setOnClickListener(v -> {
      if (checkInputName() && checkInputPinYin() && checkInputEmail() &&
          checkGender() && checkEducation() && checkInvestmentTarget()) {
        Toast.makeText(getContext(), R.string.validate_success, Toast.LENGTH_SHORT).show();
      }
    });
  }

  private boolean checkInputName() {
    String name = txtInputName.getText().toString();
    if (TextUtils.isEmpty(name) || name.length() <= 2) {
      Toast.makeText(getContext(), R.string.input_name_error_tip, Toast.LENGTH_SHORT).show();
      return false;
    }
    return true;
  }

  private boolean checkInputPinYin() {
    if (TextUtils.isEmpty(txtInputPinYin.getText().toString())) {
      Toast.makeText(getContext(), R.string.input_pinyin_error_tip, Toast.LENGTH_SHORT).show();
      return false;
    }
    return true;
  }

  private boolean checkInputEmail() {
    if (TextUtils.isEmpty(txtInputEmail.getText().toString())) {
      Toast.makeText(getContext(), R.string.input_email_error_tip, Toast.LENGTH_SHORT).show();
      return false;
    }
    return true;
  }

  private boolean checkGender() {
    if (ViewUtils.getRadioSelectedIndex(radioGender) < 0) {
      Toast.makeText(getContext(), R.string.input_gender_error_tip, Toast.LENGTH_SHORT).show();
      return false;
    }
    return true;
  }

  private boolean checkEducation() {
    if (ViewUtils.getRadioSelectedIndex(radioEducation) < 0) {
      Toast.makeText(getContext(), R.string.input_education_error_tip, Toast.LENGTH_SHORT).show();
      return false;
    }
    return true;
  }

  private boolean checkInvestmentTarget() {
    for (CheckBox checkBox : checkBoxInVestmentList) {
      if (checkBox.isChecked()) {
        return true;
      }
    }

    Toast.makeText(getContext(), R.string.input_investment_target_error_tip, Toast.LENGTH_SHORT).show();
    return false;
  }
}
