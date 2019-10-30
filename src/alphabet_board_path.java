public class alphabet_board_path {
    public String alphabetBoardPath(String target) {
        if (target == null || target.length() == 0) return "";
        int prev = 0;
        StringBuilder sb = new StringBuilder();
        for(char c: target.toCharArray()) {
            int code = c - 'a';
            if (code != prev) {
                if (c == 'z') {
                    moveto('u' - 'a', prev, sb);
                    moveto('z' - 'a', 'u' - 'a', sb);
                }else {
                    moveto(code, prev, sb);
                }
            }
            prev = code;
            sb.append("!");
        }
        return sb.toString();
    }

    public void moveto(int code, int prev, StringBuilder sb) {
        int row = (code / 5) - (prev / 5);
        for (int i = 0; i < Math.abs(row); i++) {
            sb.append(row > 0 ? "D" : "U");
        }

        int column = (code % 5) - (prev % 5);
        for (int i = 0; i < Math.abs(column); i++) {
            sb.append(column > 0 ? "R" : "L");
        }
    }

    public static void main(String[] args) {
        alphabet_board_path abp = new alphabet_board_path();
        String test = "codez";
        System.out.println(abp.alphabetBoardPath(test));
    }
}
