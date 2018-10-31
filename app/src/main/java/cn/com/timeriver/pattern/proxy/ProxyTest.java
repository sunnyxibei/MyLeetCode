package cn.com.timeriver.pattern.proxy;

public class ProxyTest {

    /**
     * 静态代理全部是
     */
    public static void test() {
        Action action = new RealAction();
        ActionProxy actionProxy = new ActionProxy(action);
        actionProxy.doSomething();
    }

}
