package com.ruoyi.novel.common;

import com.ruoyi.common.utils.uuid.UUID;

public class IdUtils {
    public static String simpleUUID()
    {
        return UUID.randomUUID().toString(true);
    }
}
