package lib.sixzeroseven;

/**
 * @auther: WJoe
 * @Description:
 * @Date : 10:07 2018/7/7
 */
public class Singleton {
    //饿汉模式，即类装载的时候就实例化，静态工厂方法
    private static final Singleton instance = new Singleton();

    private Singleton() {
    }

    public static Singleton getInstance() {
        return instance;
    }

}

//饿汉模式，
class Singleton2 {
    private static Singleton2 instance = null;

    static {
        instance = new Singleton2();
    }

    private Singleton2() {
    }

    public static Singleton2 getInstance() {
        return instance;
    }

}

//静态内部类,懒汉模式，没有性能缺陷
class Singleton3 {
    private static class SingletonHolder {
        private static final Singleton3 INSTANCE = new Singleton3();
    }

    private Singleton3() {
    }

    public static Singleton3 getInstance() {
        return SingletonHolder.INSTANCE;

    }
}

//枚举方法
enum EasySingleton {
    INSTANCE;
}



