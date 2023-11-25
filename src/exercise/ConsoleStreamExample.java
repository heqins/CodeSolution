package exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleStreamExample {
    public static void main(String[] args) {
        // 使用字节流（System.in）
//        try {
//            System.out.println("使用字节流读取：");
//            InputStreamReader isr = new InputStreamReader(System.in);
//            int byteData;
//            while ((byteData = isr.read()) != -1) {
//                System.out.print((char) byteData); // 将字节转换为字符
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        System.out.println(); // 为了清晰起见，添加一个换行符
        StringBuilder sb = new StringBuilder();

        // 使用字符流（BufferedReader）
        try {
            System.out.println("使用字符流读取：");
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
