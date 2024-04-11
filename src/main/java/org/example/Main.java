package org.example;

import java.time.LocalDate;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {


        Map<String,Object> paramMap = new TreeMap<>();
        paramMap.put("userId","123456");
        Map<String,Object> extra = new TreeMap<>();
        extra.put("ifsc","IFSC1234");
        extra.put("aaa","123");
        extra.put("bbb","321");
        paramMap.put("extra",extra);
        paramMap.put("sign","987654321");


        String result = mapToQueryString2(paramMap);

        System.out.println(result);
    }

    private boolean setData(Member member) {
//        member = new Member("Lily", 13, "abc@gmail.com", LocalDate.of(2010, 10, 26));
        member.setMemberName("Sandy");
        return false;
    }

    public static String mapToQueryString2(Map<String, Object> map) {
        return map.entrySet().stream()
                .map(entry -> entry.getKey() + "=" + encodeValue(entry.getValue()))
                .collect(Collectors.joining("&"));
    }

    private static String encodeValue(Object value) {
        StringBuilder queryString = new StringBuilder();
        if(value instanceof String){
            queryString.append(value);
        }else {
            Map<String,String> valueMap = (TreeMap) value;
            queryString.append("{");
            queryString.append(valueMap.entrySet().stream()
                    .map(entry -> "\"" + entry.getKey() + "\":\"" + entry.getValue() + "\"")
                    .collect(Collectors.joining(",")));
            queryString.append("}");
        }
        return queryString.toString();
    }


        public static String mapToQueryString(Map<String, Object> map)   {
        StringBuilder queryString = new StringBuilder();
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            if (queryString.length() > 0) {
                queryString.append("&");
            }
            queryString.append(entry.getKey());
            queryString.append("=");
            if(entry.getValue() instanceof String){
                queryString.append(entry.getValue());
            }else {
                Map<String,String> valueMap = (Map) entry.getValue();
                queryString.append("{");
                boolean single = true;
                for (Map.Entry<String, String> entry1 : valueMap.entrySet()) {
                    if(!single)  queryString.append(",");
                    queryString.append("\""+entry1.getKey()+"\"");
                    queryString.append(":");
                    queryString.append("\""+entry1.getValue()+"\"");
                    single = false;
                }
                queryString.append("}");
            }

        }
        return queryString.toString();
    }

}