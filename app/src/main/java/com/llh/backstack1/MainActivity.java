package com.llh.backstack1;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //创建碎片实例
        Fragment fragment = new FragmentAA();
        //获取碎片管理者
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.main_fragment,fragment,"pre");
        //获取返回栈中元素的个数
        Log.d("getBackStackEntryCount", "onCreate: "+getSupportFragmentManager().getBackStackEntryCount());

        fragmentTransaction.commit();
    }
}
