package str;

public class Excel表列名称 {

    /**
     * 给你一个整数 columnNumber ，返回它在 Excel 表中相对应的列名称。
     */
    public String convertToTitle(int columnNumber) {
        // 这是一个进制转换的问题
        // 注意点是进制是从1开始的，而不是从0开始，所以每次转换的时候要-1
        StringBuilder sb = new StringBuilder();
        while (columnNumber != 0) {
            columnNumber--;

            sb.append((char) ('A' + (columnNumber % 26)));

            columnNumber /= 26;
        }

        return sb.reverse().toString();
    }
}
