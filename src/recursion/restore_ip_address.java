/**
Given a string containing only digits, restore it by returning all possible valid IP address combinations.

Example:

Input: "25525511135"
Output: ["255.255.11.135", "255.255.111.35"]
**/

/**
这道题要求是复原IP地址，IP地址对我们并不陌生，就算我们不是学CS的，只要我们是广大网友之一，就应该对其并不陌生。

IP地址由32位二进制数组成，为便于使用，常以XXX.XXX.XXX.XXX形式表现，每组XXX代表小于或等于255的10进制数。

所以说IP地址总共有四段，每一段可能有一位，两位或者三位，范围是[0, 255]，题目明确指出输入字符串只含有数字，所以当某段是三位时，

我们要判断其是否越界（>255)，还有一点很重要的是，当只有一位时，0可以成某一段，如果有两位或三位时，像 00， 01， 001， 011， 000等都是不合法的，

所以我们还是需要有一个判定函数来判断某个字符串是否合法。这道题其实也可以看做是字符串的分段问题，在输入字符串中加入三个点，

将字符串分为四段，每一段必须合法，求所有可能的情况。根据目前刷了这么多题，得出了两个经验，一是只要遇到字符串的子序列或配准问题首先考虑动态规划DP，

二是只要遇到需要求出所有可能情况首先考虑用递归。这道题并非是求字符串的子序列或配准问题，更符合第二种情况，所以我们要用递归来解。

我们用k来表示当前还需要分的段数，如果k = 0，则表示三个点已经加入完成，四段已经形成，若这时字符串刚好为空，则将当前分好的结果保存。

若k != 0, 则对于每一段，我们分别用一位，两位，三位来尝试，分别判断其合不合法，如果合法，则调用递归继续分剩下的字符串，

最终和求出所有合法组合，代码如下：
**/

class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        helper(s, 4, "", res);
        return res;
    }
    
    private void helper(String s, int k, String out, List<String> res) {
        if (k == 0) {
            if (s.isEmpty()) {
                res.add(out);
            }
        }else {
            for (int i = 1; i < 4; i++) {
                if (s.length() >= i && isValid(s.substring(0, i))) {
                    if (k == 1) {
                        helper(s.substring(i), k - 1, out + s.substring(0, i), res);
                    }else {
                        helper(s.substring(i), k - 1, out + s.substring(0, i) + ".", res);
                    }
                }
            }
        }
    }
    
    private boolean isValid(String s) {
        if (s.startsWith("0") && !s.equals("0")) return false;
        
        return s.length() <= 3 && 0 <= Integer.valueOf(s) && Integer.valueOf(s) <= 255;
    }
}
