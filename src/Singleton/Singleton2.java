package Singleton;

/**
 * @auther: WJoe
 * @Description:
 * @Date : 17:57 2018/8/19
 */
public class Singleton2 {

    private static  Singleton2 instance = null;

    static {
        instance = new Singleton2();
    }

    private Singleton2() {
    }

    public static Singleton2 getInstance() {
        return instance;
    }
}
