package com.andres.emisortestfirebase;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Andres on 09/09/2016.
 */
public class Endpoints {

    public static final String BASEURL = "https://fcm.googleapis.com/";
    public static final String FCM_SEND = "fcm/send";
    public static final String TOKEN = "ekcOpGGewKY:APA91bFCZdN7vLBHWYqaW4pkqD6MKFPs_cu-Trgpx8XFw7mvureq_TSkU0tZy99fWoeBTxYSilARERWBU1PX_r1gNaqtc4NSCojWufhSr8yiC-7BqLYz8wjRku18Bl4Uc2pnhkvQ8zv6";
    public static final String API_KEY ="key= AIzaSyC2SACnH3vLg85QxBAiK8ZypQS9lvqWX0s";


    public static Map<String, String> getHeaders()
    {
        Map<String, String> params = new HashMap<String, String>();
        params.put("Authorization", API_KEY);
        params.put("Content-Type", "application/json");
        return params;
    }

}
