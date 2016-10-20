package com.andres.emisortestfirebase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.andres.emisortestfirebase.entris.Notificacion;
import com.andres.emisortestfirebase.entris.RespuestaFCM;
import com.andres.emisortestfirebase.entris.SendNotificationObj;
import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.messaging.FirebaseMessaging;

import org.json.JSONException;
import org.json.JSONObject;


import java.io.IOException;
import java.util.Map;

import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.Call;
import okhttp3.Callback;


public class MainActivity extends AppCompatActivity {

    private final String LOG_TAG = MainActivity.class.getName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        if (getIntent().getExtras() != null) {
            for (String key : getIntent().getExtras().keySet()) {
                Object value = getIntent().getExtras().get(key);
                Log.d(LOG_TAG, "Key: " + key + " Value: " + value);
            }
        }


    }
    @OnClick(R.id.crate_topic_button)
    public  void crateTopic()
    {
        FirebaseMessaging.getInstance().subscribeToTopic("Monitor");
        // [END subscribe_topics]
        // Log and toast
        String msg = getString(R.string.msg_subscribed,"Monitor");
        Log.d(LOG_TAG, msg);
        Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
    }
    @OnClick(R.id.token_id_buttom)
    public  void getTokenID()
    {
        String token = FirebaseInstanceId.getInstance().getToken();

        // Log and toast
        String msg = getString(R.string.msg_token_fmt, token);
        Log.d(LOG_TAG, msg);
        Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
    }
    @OnClick(R.id.create_theme_button)
    public  void createTheme()
    {

    }

    private RequestQueue mRequestQueue;
    @OnClick(R.id.sendNotification)
    public  void sendNotificacion()
    {
        volleyRequest();
    }

    public void volleyRequest(){

        mRequestQueue = Volley.newRequestQueue(this);
        SendNotificationObj sendNotification = new SendNotificationObj();
        Notificacion notificacion = new Notificacion();
        notificacion.setText("FCM  desde el app con Volley");
        sendNotification.setTo(Endpoints.TOKEN);

        String url = Endpoints.BASEURL+Endpoints.FCM_SEND;

        JSONObject jsonto = new JSONObject();
        JSONObject json2 = new JSONObject();
        try {
            json2.put("text","Mimensaje");
            jsonto.put("to", Endpoints.TOKEN);
            jsonto.put("notification",json2);

        } catch (JSONException e) {
            e.printStackTrace();
        }


        JsonObjectRequest postRequest = new JsonObjectRequest(Request.Method.POST, url,jsonto,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        // response
                        Log.d("successful",response.toString());


                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // TODO Auto-generated method stub
                        Log.d("ERROR response ", error.getMessage());
                    }
                }
        ) {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> params = Endpoints.getHeaders();
                return params;
            }
        };
        mRequestQueue.add(postRequest);
    }



}
