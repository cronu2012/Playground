package org.example;

import java.util.Map;
import java.util.TreeMap;

public class SignUtils {

    private Map<String, String> signs;

    public SignUtils() {
        this.signs = new TreeMap<>();
    }

    /**
     * 放入 鍵值 進入SignUtils物件
     *
     * @param key   鍵
     * @param value 值
     */
    public void put(String key, String value) {
        this.signs.put(key, value);
    }

    /**
     * 取得調整順序後的字串結果
     *
     * @return 字串結果
     */
    public String getSign() {
        Map<String, String> treeSigns = this.signs;

        StringBuilder result = new StringBuilder();

        boolean firstEntry = true;
        for (Map.Entry<String, String> entry : treeSigns.entrySet()) {
            if (!firstEntry) {
                result.append("&");
            }
            result.append(entry.getKey());
            result.append("=");
            result.append(entry.getValue());
            firstEntry = false;
        }

        return result.toString();
    }

    public static void main(String[] args) {
        // Test
        SignUtils signUtils = new SignUtils();
        signUtils.put("timestamp", "1670549739457");
        signUtils.put("amount", "100");
        signUtils.put("userName", "alden");
        signUtils.put("userPhone", "09844789231");
        signUtils.put("orderNo", "fpx08742139912");
        System.out.println(signUtils.getSign());

    }
}
