package org.example;

import java.util.*;

public class Account {
    private static final Integer MAX_SIZE = 50;
    //使用LinkedHashMap確保插入順序
    public static final Map<String, Account> cacheMap = new LinkedHashMap<>();

    public static Account getInstance(String key) {
        Account account = cacheMap.get(key);
        if(account == null) {
            //使用synchronized 鎖住 cacheMap 確保只有一個執行緒能進來執行創建與刪除操作
            synchronized (cacheMap){
                account = new Account(key);
                account.init();
                cacheMap.put(key, account);
                //當元素數量大於50時，刪除第一位元素
                if(cacheMap.size() > MAX_SIZE){
                    cacheMap.remove(cacheMap.keySet().iterator().next());
                }
            }

        }

        return account;
    }

    private String key;
    private String cachedData;

    //將建構子私有化來禁止外部呼叫，只能使用getInstance來取得實體
    private Account(String key) {
        this.key = key;
    }

    private void init() {
        // 從資料庫載入資料存入 cachedData，假設載入一個帳號大約需要10秒(不必實作載入的動作)
    }
}
