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

        int s_index = 0;
        while (s_index < seqList.len) {
            if ((int)seqList.table[s_index] >= s) {
                break;
            }else {
                s_index += 1;
            }
        }

        int t_index = s_index;
        while (t_index < seqList.len) {
            if ((int)seqList.table[t_index] > t) {
                break;
            }else {
                t_index += 1;
            }
        }

        while (t_index < seqList.len) {
            seqList.table[s_index++] = seqList.table[t_index++];
        }

        seqList.len = s_index;
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

        remove(seqList, 2, 10);
//        insert(seqList, 5);
//        merge(seqList1, seqList2);
//        removeAll(seqList, 3);
//        System.out.println(seqList1.table[0]);
        System.out.println(seqList.table[1]);
        System.out.println(seqList.len);
    }
}
