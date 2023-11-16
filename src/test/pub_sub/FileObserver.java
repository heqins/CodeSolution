package test.pub_sub;

public class FileObserver implements Observer {
    @Override
    public void listen() {
        System.out.println("FileListener");
    }
}
