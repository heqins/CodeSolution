package test.pub_sub;

public class ScoreObserver implements Observer {
    @Override
    public void listen() {
        System.out.println("ScoreListener");
    }
}
