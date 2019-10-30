import java.util.ArrayList;
import java.util.List;
import java.util.regex.*;

/**
 * res = []
 *         import re
 *         rePattern = '^[a-z]*'
 *         for i,v in enumerate(pattern):
 *             rePattern += v
 *             rePattern += '[a-z]*'
 *         #rePattern = rePattern[:-2]
 *         rePattern += '$'
 *         for i in queries:
 *             r = re.search(rePattern, i)
 *             if r == None:
 *                 res.append(False)
 *                 continue
 *             r = r.group()
 *             subq = i[len(r):]
 *             res.append(len(subq) == 0 or subq.islower())
 */


public class camelcase_matching {
    public List<Boolean> camelMatch(String[] queries, String pattern) {
        List<Boolean> res = new ArrayList<>();
        return res;
    }

    public static void main(String[] args) {
        String[] test = new String[]{"BooBar","FooBarTest","FootBall","FrameBuffer","ForceFeedBack"};
        camelcase_matching cm = new camelcase_matching();
        List<Boolean> res = cm.camelMatch(test, "FB");
//      System.out.println(Arrays.toString(res.toArray()));
        String pattern = "^[a-z]*F[a-z]*B[a-z]*$";
        String str = "FooBar";
        System.out.println(Pattern.matches(pattern, str));
    }
}
