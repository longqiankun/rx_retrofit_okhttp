package com.shiqichuban.lib.core.utils;

import com.shiqichuban.lib.core.R;

import java.util.HashMap;
import java.util.Map;

public  class StatusCode{
    public static final int CODE302=302;
    public static final int CODE400=400;
    public static final int CODE401=401;
    public static final int CODE404=404;
    public static final int CODE500=500;
    public static final int CODE1000=1000;
    public static final int CODE1001=1001;
    public static final int CODE1002=1002;
        public static Map<Integer, Integer> status = new HashMap<>();
        static {
            status.put(CODE302, R.string.status_302);
            status.put(CODE400, R.string.status_400);
            status.put(CODE401, R.string.status_401);
            status.put(CODE404, R.string.status_404);
            status.put(CODE500, R.string.status_500);
            status.put(CODE1000, R.string.status_1000);
            status.put(CODE1001, R.string.status_1001);
            status.put(CODE1002, R.string.status_1002);
        }
        public static int getStatus(int key){
            int res=R.string.status_1001;
            if(status.containsKey(key)){
                res=   status.get(key);
            }
            return res;
        }
    }