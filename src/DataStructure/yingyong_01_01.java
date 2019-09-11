package DataStructure;

public class yingyong_01_01 {
    public static int removeMin(SequenceList seqList) {
        int min = (int)seqList.table[0];
        int index = 0;
        for (int i = 1; i < seqList.len; i++) {
            if ((int)seqList.table[i] <= min) {
                min = (int)seqList.table[i];
                index = i;
            }
        }
        seqList.table[index] = seqList.table[seqList.len - 1];
        seqList.len -= 1;
        return min;
    }

    public static void removeDuplicate(SequenceList seqList) {
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

    public static void removeAll(SequenceList seqList, int elem) {
        int k = 0;
        for (int i = 0; i < seqList.len; i++) {
            if ((int)seqList.table[i] != elem) {
                seqList.table[k] = seqList.table[i];
                k++;
            }
        }
        seqList.len = k;
    }

    public static void main(String[] args) {
        SequenceList seqList = new SequenceList(999);
        seqList.add(5);
        seqList.add(2);
        seqList.add(3);
        seqList.add(4);
        seqList.add(-1);

        System.out.println(removeMin(seqList));
        System.out.println(seqList);
        System.out.println("--------");

        SequenceList seqList2 = new SequenceList(999);
        seqList2.add(1);
        seqList2.add(1);
        seqList2.add(3);
        seqList2.add(5);
        seqList2.add(5);

        removeAll(seqList2, 1);
        System.out.println(seqList2);
        System.out.println("--------");

        SequenceList seqList3 = new SequenceList(999);
        seqList3.add(1);
        seqList3.add(1);
        seqList3.add(3);
        seqList3.add(5);
        seqList3.add(5);

        removeDuplicate(seqList3);
        System.out.println(seqList3);
    }
}
