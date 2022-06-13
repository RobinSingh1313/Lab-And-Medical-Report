package com.example.doctorsapplicationfinal;

import android.content.Context;

import com.android.volley.Cache;
import com.android.volley.Network;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.BasicNetwork;
import com.android.volley.toolbox.DiskBasedCache;
import com.android.volley.toolbox.HurlStack;
import com.android.volley.toolbox.Volley;

public class Signleton {
    private static Signleton instance;
    private RequestQueue requestQueue;
    private Context ctx;

    public Signleton(Context ctx) {
        this.ctx = ctx;
        requestQueue=getRequestQueue();
    }
    public  RequestQueue getRequestQueue()
    {
        if (requestQueue==null)
        {
            Cache cache=new DiskBasedCache(ctx.getCacheDir(),1024*1024);
            Network network=new BasicNetwork(new HurlStack());
            requestQueue=new RequestQueue(cache,network);
            requestQueue= Volley.newRequestQueue(ctx.getApplicationContext());

        }
        return requestQueue;
    }
    public static synchronized Signleton getmInstance(Context context)
    {
        if (instance==null)
        {
            instance=new Signleton(context);

        }
        return instance;
    }
    public <T> void  addToRequestQueue(Request<T> request)
    {
        requestQueue.add(request);
    }
}
