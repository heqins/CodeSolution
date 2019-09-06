package DataStructure;

public class yingyong_01_01 {
    public int removeMin(SequenceList seqList) {
        int min = (int)seqList.table[0];
        int index = 0;
        for (int i = 1; i < seqList.len; i++) {
            if ((int)seqList.table[i] < min) {
                min = (int)seqList.table[i];
                index = i;
                break;
            }
        }
        seqList.table[index] = seqList.table[seqList.len - 1];
        seqList.len -= 1;
        return min;
    }

    public void removeDuplicate(SequenceList seqList) {
        for (int i = 0; i < seqList.len; i++) {
            for (int j = i + 1; j < seqList.len; j++) {
                if ((int)seqList.table[i] == (int)seqList.table[j]) {
                    seqList.len -= 1;
                    for (int k = j; k < seqList.len - 1; k++) {
                        seqList.table[k] = seqList.table[k+1];
                    }
                }
            }
        }
    }

    public void removeAllElem(SequenceList seqList, int elem) {

    }

    public static void main(String[] args) {
        yingyong_01_01 y0101 = new yingyong_01_01();
        SequenceList seqList = new SequenceList(999);
        seqList.add(1);
        seqList.add(1);
        seqList.add(3);
        seqList.add(4);
        seqList.add(6);
//        System.out.println(y0101.removeMin(seqList));
//        System.out.println(seqList.table[1]);

        y0101.removeAllElem(seqList, 1);
        System.out.println(seqList.len);
        System.out.println(seqList.table[0]);

        y0101.removeDuplicate(seqList);
//        System.out.println(seqList.len);
    }
}
