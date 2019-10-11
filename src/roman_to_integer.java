public class roman_to_integer {
    public int romanToInt(String s) {
        if (s == null || s.length() == 0) return 0;
        char[] cc = s.toCharArray();
        char prev = ' ';
        int number = 0;
        for (int i = 0; i < cc.length; i++) {
            char c = cc[i];
            number = getNumber(number, prev, c);
            prev = c;
        }
        return number;
    }

    public int getNumber(int number, char prev, char current) {
        if (prev == 'I' && current == 'V') return number - 1 + 4;
        if (prev == 'I' && current == 'X') return number - 1 + 9;
        if (prev == 'X' && current == 'L') return number - 10 + 40;
        if (prev == 'X' && current == 'C') return number - 10 + 90;
        if (prev == 'C' && current == 'D') return number - 100 + 400;
        if (prev == 'C' && current == 'M') return number - 100 + 900;
        if (current == 'I') return number + 1;
        if (current == 'V') return number + 5;
        if (current == 'X') return number + 10;
        if (current == 'L') return number + 50;
        if (current == 'C') return number + 100;
        if (current == 'D') return number + 500;
        if (current == 'M') return number + 1000;
        return number;
    }
}
