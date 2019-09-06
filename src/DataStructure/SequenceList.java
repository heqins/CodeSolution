package DataStructure;

public class SequenceList {
    int len;//数组中的存储长度
    Object[] table;//顺序表的数组
    public SequenceList(int length){//带参数的构造方法，
        this.table=new Object[Math.abs(length)];//取length的绝对值
        this.len=0;
    }

    public SequenceList(){//无参的构造方法
        this(10);
    }

    public void add(int num) {
        this.table[len] = num;
        this.len += 1;
    }

}
