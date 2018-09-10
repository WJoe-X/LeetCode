package Singleton;

/**
 * @auther: WJoe
 * @Description:  双重检查
 * @Date : 18:32 2018/8/19
 */
public class Singleton {
    private static volatile Singleton singleton;

    private Singleton() {
    }

    public static Singleton getSingleton() {
        if (singleton == null) {
            synchronized (Singleton.class) {
                if (singleton == null)
                    singleton = new Singleton();
            }

        }
        return singleton;

    }

}
