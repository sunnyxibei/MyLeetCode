package cn.com.timeriver.pattern.proxy;

import timber.log.Timber;

public class ActionProxy implements Action {

    private final Action action;

    public ActionProxy(Action action) {
        this.action = action;
    }

    /**
     * 代理模式的作用，对被代理类的实际业务作了扩展，但是不影响原有类的结果，不具有侵入性
     */
    @Override
    public void doSomething() {
        Timber.tag("Proxy").d("before: 早上要准时起床哦");
        action.doSomething();
        Timber.tag("Proxy").d("after: 晚上要早点睡觉哦");
    }
}
