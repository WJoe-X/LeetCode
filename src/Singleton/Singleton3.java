package Singleton;

/**
 * @auther: WJoe
 * @Description:
 * @Date : 17:58 2018/8/19
 */
//静态内部类,懒汉模式，没有性能缺陷
public class Singleton3 {
    private static class SingletonHolder
    {
        private static final Singleton3 INSTANCE = new Singleton3();
    }

    private Singleton3() {
    }

    public static  Singleton3 getInstance() {
        return SingletonHolder.INSTANCE;

    }
}
