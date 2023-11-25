package exercise.单例模式;

public class DoubleCheck {

    // 防止指令重排序
    private volatile static DoubleCheck instance;

    private DoubleCheck() {}

    public static DoubleCheck getInstance() {
        if (instance == null) { // 第一次检查，没有实例时才进入同步块
            // 必须使用类级别的锁
            synchronized (DoubleCheck.class) {
                if (instance == null) { // 第二次检查，确保没有其他线程在此期间创建实例
                    instance = new DoubleCheck();
                }
            }
        }

        return instance;
    }
}
