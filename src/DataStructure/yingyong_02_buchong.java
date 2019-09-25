package DataStructure;

public class yingyong_02_buchong {
    public static void solution(SeqStack stack) {
        int length = stack.len;
        SeqQueue queue = new SeqQueue(999);
        for (int i = 0; i < length; i++) {
            queue.offer(stack.pop());
        }

        for (int j = 0; j < length; j++) {
            int temp = queue.poll();
            if (temp % 2 == 0) {
                // 偶数进队列
                queue.offer(temp);
            }else {
                // 奇数进栈
                stack.push(temp);
            }
        }

        for (int i = 0; i < length / 2; i++) {
            queue.offer(stack.pop());
        }

        for (int i = 0; i < length / 2; i ++) {
            stack.push(queue.poll());
        }

        for (int i = 0; i < length / 2; i++) {
            queue.offer(stack.pop());
        }

        for (int i = 0; i < length; i++) {
            stack.push(queue.poll());
        }
    }
    public static void main(String[] args) {
        SeqStack stack = new SeqStack(6);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);
        solution(stack);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}
