package com.llh.backstack1;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

/**
 * 项目名:    BackStack1
 * 包名:      com.llh.backstack1
 * 文件名:    FragmentBB
 * 创建者:    LLH
 * 创建时间:  2019/8/2 16:27
 * 描述:      TODO
 */
public class FragmentBB extends Fragment implements View.OnClickListener {
    //声明控件
//    private CheckBox checkBox_sex1;
//    private CheckBox checkBox_sex2;
    private Button button_comfirm;
    private EditText editText_sex;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_bb,container,false);
        //给控件赋值
//        checkBox_sex1 = (CheckBox)view.findViewById(R.id.cb_boy);
//        checkBox_sex2 = (CheckBox)view.findViewById(R.id.cb_girl);
        editText_sex = (EditText)view.findViewById(R.id.et_sex);
        button_comfirm = (Button)view.findViewById(R.id.btn_comfirm);
        button_comfirm.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_comfirm:
                //先获取输入框的值
                String sex = editText_sex.getText().toString().trim();
                FragmentAA preFragment=(FragmentAA) getActivity().getSupportFragmentManager().findFragmentByTag("pre");

                preFragment.text=sex;
                //获取栈顶元素
                //getActivity().getSupportFragmentManager().getBackStackEntryAt(0)
                //Fragment fragment = new FragmentAA();
                FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.main_fragment,preFragment);
                fragmentTransaction.commit();
                break;
        }
    }
}
