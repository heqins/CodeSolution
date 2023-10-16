package 多线程.单例模式;

public class StaticInner {

    private StaticInner() {}

    private static class StaticInnerClass {
        private static final StaticInner instance = new StaticInner();
    }

    public static StaticInner getInstance() {
        return StaticInnerClass.instance;
    }
}
