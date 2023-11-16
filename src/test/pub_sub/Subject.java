package test.pub_sub;

public interface Subject {

    void registerListener(Observer listener);

    void publishMsg(Object msg);

}
