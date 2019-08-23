package Str;

public class lower_str {
    public String toLowerCase(String str) {
        String newstr = "";
        int n;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c >= 65 && c <= 90) {
                n = c + 32;
                c = (char) n;
            }
            newstr += c;
        }
        return newstr;
    }

    public static void main(String[] args) {
        lower_str low = new lower_str();
        System.out.println(low.toLowerCase("DDDdddCC90012C"));
    }
}
