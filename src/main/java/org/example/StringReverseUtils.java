package org.example;

public class StringReverseUtils {

    /**
     * 將s字串反轉後返回
     *
     * @param s 字串
     * @return 反轉後字串
     */
    public String reverse(String s) {
        char[] chars = s.toCharArray();
        for (int i = 0, j = chars.length - 1; i < j; i++, j--) {
            char temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
        }
        return new String(chars);
    }

    /**
     * 將 s 字串的前 k + 1 個字元反轉後面不反轉並返回
     *
     * @param s 字串
     * @param k 目標序列
     * @return 反轉後字串
     */
    public String reverse(String s, int k) {
        char[] chars = s.toCharArray();
        if (k + 1 > chars.length) {
            return reverse(s);
        }
        for (int i = 0, j = k; i < j; i++, j--) {
            char temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        // Test
        StringReverseUtils utils = new StringReverseUtils();
        System.out.println(utils.reverse("abcde"));
        System.out.println(utils.reverse("abcde", 3));
    }

}
