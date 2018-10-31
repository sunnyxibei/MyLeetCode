package cn.com.timeriver.pattern.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import timber.log.Timber;

public class DynamicActionProxy implements InvocationHandler {

    //用于接收具体实现类的实例对象
    private Object object;

    /**
     * 使用带参数的构造器来传递具体实现类的对象
     */
    public DynamicActionProxy(Object object) {
        this.object = object;
    }

    /**
     * 从这个实现里能看到动态代理和静态代理的区别
     * 从实现的方式上，被代理接口每增加一个方法，静态代理类响应地要增加方法
     * 但是对于动态代理，所有方法的调用处理，都集中在类invoke的回调中
     * 在Java动态生成代理类后，回调该方法，可以通过参数进行判断，作逻辑处理
     * 其实Retrofit就是这样做的，不是么
     * 由此看来，静态代理和动态代理，原理没有区别
     * 只是，Java提供Proxy类，帮助我们自动化完成了一些本来在静态代理中是手动完成的工作，解放了我们的双手
     *
     * @param proxy
     * @param method
     * @param args
     * @return
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws InvocationTargetException, IllegalAccessException {
        Timber.tag("Dynamic Proxy").d("before: 早上要准时起床哦");
        method.invoke(object, args);
        Timber.tag("Dynamic Proxy").d("after: 晚上要早点睡觉哦");
        return null;
    }
}
