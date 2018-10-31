package cn.com.timeriver.pattern.proxy;

import android.widget.Toast;

import cn.com.timeriver.myleetcode.base.App;
import timber.log.Timber;

public class RealAction implements Action {

    @Override
    public void doSomething() {
        Timber.tag("Proxy").d("doSomething: 上班了，写代码中");
        Toast.makeText(App.Companion.getInstance(), "上班了，写代码中", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void coding() {
        Timber.tag("Proxy").d("coding: hard coding");
        Toast.makeText(App.Companion.getInstance(), "hard coding", Toast.LENGTH_SHORT).show();
    }

}
