package DataStructure;

import java.util.Stack;

public class yingyong_02_10 {
    private class Node {
        int m;
        int n;
        int tag = 0;
        int value;
        public Node(){}

        public Node(int m , int n) {
            this.m = m;
            this.n = n;
        }
    }

    public void ackermann(int m, int n) {
        System.out.println(ack(m, n));
        System.out.println(ack2(m, n));
    }

    public int ack(int m, int n) {
        if (m == 0) {
            return n + 1;
        }else if (n == 0) {
            return ack(m - 1, 1);
        }else {
            return ack(m - 1, ack(m, n - 1));
        }
    }

    public int ack2(int m, int n) {
        Node n1 = new Node(m, n);
        Node[] s = new Node[999];
        int top = -1;
        s[++top] = n1;
        while (top > -1) {
            // tag == 0 -> ack(m,n)未求出
            if (s[top].tag == 0) {
                if (s[top].m == 0) {
                    s[top].value = s[top].n + 1;
                    s[top].tag = 1;
                } else if (s[top].n == 0) {
                    top++;
                    s[top] = new Node(s[top - 1].m - 1, 1);
                } else {
                    top++;
                    s[top] = new Node(s[top - 1].m, s[top - 1].n - 1);
                }
            }else if (s[top].tag == 1) {
                if (top > 0 && s[top - 1].n == 0) {
                    s[top - 1].value = s[top].value;
                    s[top - 1].tag = 1;
                    top--;
                }else if (top > 0) {
                    s[top - 1].m = s[top - 1].m - 1;
                    s[top - 1].n = s[top].value;
                    s[top - 1].tag = 0;
                    top--;
                }
            }
            if (top == 0 && s[top].tag == 1) {
                break;
            }
        }
        return s[top].value;
    }

    public static void main(String[] args) {
        yingyong_02_10 y0210 = new yingyong_02_10();
        y0210.ackermann(3, 2);
    }
}
