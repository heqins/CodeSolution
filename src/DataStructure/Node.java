package DataStructure;

public class Node {
    int coef; // 系数
    int exp; // 指数
    Node next;
    public Node(){}

    public Node(int coef, int exp) {
        this.coef = coef;
        this.exp = exp;
    }
}
