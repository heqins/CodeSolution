package 多线程.单例模式;

public class Eager {

    private static Eager instance = new Eager();

    private Eager() {}

    public static Eager getInstance() {
        return instance;
    }
}
