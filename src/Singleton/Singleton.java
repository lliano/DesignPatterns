package Singleton;

/**
 * @author linyabin
 * Singleton
 */

public class Singleton {


    //1 懒汉式(线程不安全)
    // uniqueInstance 被延迟实例化，这样做的好处是，如果没有用到该类，那么就不会实例化 uniqueInstance，从而节约资源
      /*  private static Singleton uniqueInstance;
        private Singleton(){
        }
        public static Singleton getUniqueInstance(){
            if (uniqueInstance == null){
                uniqueInstance = new Singleton();
            }
            return uniqueInstance;
        }*/


    //2 饿汉式(线程安全)
    // 接实例化 uniqueInstance 的方式就不会产生线程不安全问题。 但是直接实例化的方式也丢失了延迟实例化带来的节约资源的好处。
    /*private static Singleton uniqueInstance = new Singleton();
    public static Singleton getUniqueInstance(){
        return uniqueInstance;
            }*/


    //3 懒汉式（线程安全）
    //当一个线程进入方法时，其他视图进入该方法的线程都必须等待，会造成阻塞，不推荐
   /* private static Singleton uniqueInstance;
    private Singleton(){
    }
    public static synchronized Singleton getUniqueInstance(){
        if (uniqueInstance == null){
            uniqueInstance = new Singleton();
        }
        return uniqueInstance;
    }*/

    //4 双重校验锁（线程安全）
    //volatile 可以避免指令重排 在进行new Singleton操作时会进行123 操作，但是指令重排会出现132
    //1 uniqueInstance 分配内存空间
    //2 初始化 uniqueInstance
    //3 将 uniqueInstance 指向分配的内存地址
    //例如线程 T1 执行了13 ，这时线程2执行了getUniqueInstance 发现unique不为空，但是此时uniqueInstance还没有初始化，产生问题
    /*private volatile static Singleton uniqueInstance;

    private Singleton() {
    }

    public static Singleton getUniqueInstance() {
        if (uniqueInstance == null) {
            synchronized (Singleton.class) {
                if (uniqueInstance == null) {
                    uniqueInstance = new Singleton();
                }
            }
        }
        return uniqueInstance;
    }*/


    //5 静态内部类实现
    /*private Singleton(){

    }
    private static class SingletonHolder{
        private static final Singleton INSTANCE = new Singleton();
    }
    private static Singleton getUniqueInstance(){
        return SingletonHolder.INSTANCE;
    }*/





}
