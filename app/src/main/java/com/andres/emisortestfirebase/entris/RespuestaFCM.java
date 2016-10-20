package com.andres.emisortestfirebase.entris;

import java.util.List;

/**
 * Created by andresdavid on 14/10/16.
 */
public class RespuestaFCM {

    public String multicast_id;
    public int success;
    public int failure;
    public int canonical_ids;
    public List<GCMObject2> results;

    public class GCMObject2 {
        public int message_id;
        public int registration_id;
        public String error;
    }
}

