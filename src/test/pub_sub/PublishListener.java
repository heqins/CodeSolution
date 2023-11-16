package test.pub_sub;

import java.util.ArrayList;
import java.util.List;

public class PublishListener implements Subject{

    private final List<Observer> observers = new ArrayList<>();

    public static void main(String[] args) {
        PublishListener pub = new PublishListener();
        pub.registerListener(new FileObserver());
        pub.registerListener(new ScoreObserver());

        System.out.println("working...");
        pub.publishMsg("ss");
    }

    @Override
    public void registerListener(Observer listener) {
        if (listener != null) {
            observers.add(listener);
        }
    }

    @Override
    public void publishMsg(Object msg) {
        for (Observer observer : observers) {
            observer.listen();
        }
    }
}
