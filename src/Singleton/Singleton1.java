package Singleton;

/**
 * @auther: WJoe
 * @Description:  //饿汉模式，即类装载的时候就实例化，静态工厂方法
 * @Date : 17:56 2018/8/19
 */
public class Singleton1 {
    private static final Singleton1 instance = new Singleton1();

    private Singleton1() {
    }

    public static Singleton1 getInstance() {
        return instance;
    }
}
