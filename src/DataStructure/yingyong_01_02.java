package DataStructure;

public class yingyong_01_02 {
//    public int insert(SequenceList seqList) {
//
//    }
//
//    public void merge(SequenceList seqList) {
//
//    }
//
//    public void removeAllElem(SequenceList seqList, int elem) {
//
//    }

    public void removeElems(SequenceList seqList, int s, int t) {
        if (s >= t || seqList.len == 0) {
            System.out.println("Error!");
            return;
        }

        int count = 0;
        while (count < seqList.len) {
            if ((int)seqList.table[count] >= s) {
                break;
            }else {
                count += 1;
            }
        }

        System.out.println(count);
        for (int i = count; i < (t - s); i++) {
            seqList.table[i] = seqList.table[seqList.len - t + i - 1];
            seqList.len -= 1;
        }
    }

    public static void main(String[] args) {
        yingyong_01_02 y0102 = new yingyong_01_02();
        SequenceList seqList = new SequenceList(999);
        seqList.add(1);
        seqList.add(2);
        seqList.add(3);
        seqList.add(4);
        seqList.add(6);

        y0102.removeElems(seqList, 2, 5);
        System.out.println(seqList.len);
    }
}
