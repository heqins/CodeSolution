package DataStructure;

public class yingyong_03_10 {
    public int countAtom(GenListNode head) {
        int count = 0;
        GenListNode p = head.tlink;
        while (p != null) {
            if (p.tag == GenListNode.LIST) {
                count += countAtom(p.tlink);
            }else {
                count++;
            }
            p = p.tlink;
        }
        return count;
    }
}
