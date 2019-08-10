package com.llh.backstack1;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * 项目名:    BackStack1
 * 包名:      com.llh.backstack1
 * 文件名:    FragmentBB
 * 创建者:    LLH
 * 创建时间:  2019/8/2 16:27
 * 描述:      TODO
 */
public class FragmentAA extends Fragment implements View.OnClickListener {
    //声明控件
    private Button button_go;
    public String text="";
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_aa,container,false);
        button_go = (Button)view.findViewById(R.id.btn_select);
        button_go.setOnClickListener(this);
        final TextView textView_display;
        textView_display = view.findViewById(R.id.tv_display);
        if (text!="")
        {
            textView_display.setText(text);
        }
        return view;
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_select:
                //替换碎片
                Fragment fragment = new FragmentBB();
                FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.main_fragment,fragment,"next");
                fragmentTransaction.addToBackStack("pre");
                fragmentTransaction.commit();
                getActivity().getSupportFragmentManager().executePendingTransactions();//返回栈一直为0解决方法
                //获取返回栈中元素的个数
                Log.d("getBackStackEntryCount", "onCreate: "+getActivity().getSupportFragmentManager().getBackStackEntryCount());
                break;
        }
    }
}
