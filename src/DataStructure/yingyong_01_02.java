package DataStructure;

public class yingyong_01_02 {
    public static void insert(SequenceList seqList, int e) {
        int count = 0;
        while ((int)seqList.table[count] <= e) {
            count += 1;
        }

        for (int i = seqList.len - 1; i >= count - 1; i--) {
            seqList.table[i + 1] = seqList.table[i];
        }

        seqList.table[count] = e;
        seqList.len += 1;
    }

    public static void merge(SequenceList seqList1, SequenceList seqList2) {
        int len1 = seqList1.len;
        int len2 = seqList2.len;
        int count = 0;
        int i = 0;
        int j = 0;
        if (len1 < len2) {
            while (count < len1) {
                if ((int)seqList1.table[i] <= (int)seqList2.table[j]) {
                    i++;
                }else {
                    seqList1.table[len1 + len2 - i - 1] = seqList1.table[i];
                    seqList1.table[i++] = seqList2.table[j++];
                }
                count += 1;
            }
            seqList1.len = len1 + len2;
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

    public static void remove(SequenceList seqList, int s, int t) {
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
        SequenceList seqList = new SequenceList(999);
        SequenceList seqList1 = new SequenceList(999);
        SequenceList seqList2 = new SequenceList(999);
        seqList1.add(10);
        seqList1.add(15);
        seqList2.add(-40);
        seqList2.add(-20);
        seqList2.add(100);

        seqList.add(1);
        seqList.add(2);
        seqList.add(3);
        seqList.add(10);
        seqList.add(12);

//        remove(seqList, 2, 5);
//        insert(seqList, 5);
        merge(seqList1, seqList2);
        removeAll(seqList, 3);
        System.out.println(seqList.table[2]);
    }
}
