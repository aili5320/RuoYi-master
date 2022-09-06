package com.ruoyi.novel.utils;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
@Component
public class MyResultMap {

    public Map<String, Object> resultMap(String message,Object data,int result){
        Map<String, Object> map = new HashMap();
        map.put("message",message);
        map.put("data",data);
        map.put("result",result);
        return map;
    }
}
