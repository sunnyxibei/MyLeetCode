package cn.com.timeriver.pattern.proxy;

import java.lang.reflect.Proxy;

public class ProxyTest {

    /**
     * 静态代理全部是
     */
    public static void test() {
        Action action = new RealAction();
        ActionProxy actionProxy = new ActionProxy(action);
        actionProxy.doSomething();
        actionProxy.coding();
    }

    public static void testDynamic() {
        Action action = new RealAction();
        Action proxyInstance = (Action) Proxy.newProxyInstance(
                action.getClass().getClassLoader(),
                new Class[]{Action.class},
                new DynamicActionProxy(action));
        proxyInstance.doSomething();
        proxyInstance.coding();
    }

}
