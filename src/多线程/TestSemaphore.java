package 多线程;

import test.Father;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class TestSemaphore {


    public class HiFather {
        public void say() {
            System.out.println("father");
        }
    }

    public class HiSon extends HiFather {
        @Override
        public void say() {
            System.out.println("son");
        }
    }

    public static void main(String[] args) {
        Class<? extends HiFather> list = HiFather.class;

    }
}
