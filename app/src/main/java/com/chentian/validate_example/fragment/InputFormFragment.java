package com.chentian.validate_example.fragment;

import java.util.Arrays;
import java.util.List;

import android.os.Bundle;
import android.support.v4.app.Fragment;
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
import com.chentian.validate_example.validate.ValidateItemView;
import com.chentian.validate_example.validate.ValidateItemViewCollection;
import com.chentian.validate_example.validate.ValidateMode;

/**
 * 用户基本信息输入页面
 *
 * @author chentian
 */
public class InputFormFragment extends Fragment {

  @Bind(R.id.input_name) TextView txtInputName;
  @Bind(R.id.input_pinyin) TextView txtInputPinyin;
  @Bind(R.id.input_email) TextView txtInputEmail;
  @Bind(R.id.radio_gender) RadioGroup radioGender;
  @Bind(R.id.radio_education) RadioGroup radioEducation;
  @Bind({
      R.id.checkbox_investment_target_0, R.id.checkbox_investment_target_1,
      R.id.checkbox_investment_target_2, R.id.checkbox_investment_target_3
  }) List<CheckBox> checkBoxInVestmentList;
  @Bind(R.id.btn_submit) Button btnSubmit;

  private ValidateItemViewCollection validateItemViewCollection;

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_input_form, container, false);

    ButterKnife.bind(this, view);
    bindViews();

    return view;
  }

  private void bindViews() {
    validateItemViewCollection = new ValidateItemViewCollection(Arrays.asList(
        new ValidateItemView.TextViewItem(txtInputName, new ValidateMode.Name(), R.string.input_name_error_tip),
        new ValidateItemView.TextViewItem(txtInputPinyin, new ValidateMode.Pinyin(), R.string.input_pinyin_error_tip),
        new ValidateItemView.TextViewItem(txtInputEmail, new ValidateMode.Email(), R.string.input_email_error_tip),

        new ValidateItemView.RadioGroupItem(radioGender, R.string.input_gender_error_tip),
        new ValidateItemView.RadioGroupItem(radioEducation, R.string.input_education_error_tip),
        new ValidateItemView.CheckBoxItem(checkBoxInVestmentList, R.string.input_investment_target_error_tip)
    ));
    btnSubmit.setOnClickListener(v -> {
      if (validateItemViewCollection.validate()) {
        Toast.makeText(getContext(), R.string.validate_success, Toast.LENGTH_SHORT).show();
      }
    });
  }
}
