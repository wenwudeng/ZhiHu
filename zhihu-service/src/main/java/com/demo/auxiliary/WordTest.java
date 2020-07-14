package com.demo.auxiliary;


import com.demo.auxiliary.SensitiveWord;

import java.util.HashMap;
import java.util.Map;

public class WordTest {
    public static Map<String,Object> filter(String str) {
        long startNumer = System.currentTimeMillis();
        boolean flag = SensitiveWord.checkSenstiveWord(str);
        System.out.println("字符串的长度为:" + str.length());
        str = SensitiveWord.filterInfoAfter(str);
        System.out.println("含有敏感词汇:" + flag);
        long endNumber = System.currentTimeMillis();
        System.out.println("消耗时间为" + (endNumber - startNumer) + "ms");
        System.out.println("转换后的字符串为:\n" + str);
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("flag",flag);
        map.put("str",str);
        return map;
    }

}