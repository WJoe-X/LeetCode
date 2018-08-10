public class Singleton {

    //饿汉模式，即类装载的时候就实例化，静态工厂方法
   static class Singleton1{
       private  static final Singleton1 instance = new Singleton1();

       private Singleton1(){}

       public  static  Singleton1 getInstance(){
           return  instance;
       }

    }

    //饿汉模式，
    public static  class Singleton2{
            private Singleton instance = null;
            static {
                instance = new Singleton();
            }
            private Singleton (){}
            public static Singleton getInstance() {
                return this.instance;
            }

        }
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

       //枚举方法
        public  enum  EasySingleton{
           INSTANCE;
       }
}


