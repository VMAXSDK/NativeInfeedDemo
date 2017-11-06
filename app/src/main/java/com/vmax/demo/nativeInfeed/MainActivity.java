package com.vmax.demo.nativeInfeed;


import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;
import com.vmax.android.ads.api.VmaxAdView;




/**Its Recommended To Use VMAX plugin For Android Studio To Add Your Dependencies
 and Manage Changes in AndroidManifest as Well as Proguard,
 However You Can Manually Do This By Referring To Our Documentation Or following this Demo Project  */


public class MainActivity extends AppCompatActivity {

    public  VmaxAdView vmaxAdView;
    RecyclerView recyclerView;

    RelativeLayout adContainer;
    LayoutInflater layoutInflater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        layoutInflater=(LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        vmaxAdView=(VmaxAdView) layoutInflater.inflate(R.layout.vmax_custom_native_layout,null);

        InitializeRecycler();

    }

    public void InitializeRecycler()
    {
        recyclerView=(RecyclerView)findViewById(R.id.recy_view);
        InitData initData=new InitData(getApplicationContext());
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        RecycleAdapter recycleAdapter=new RecycleAdapter(initData.fillList(),vmaxAdView);
        recyclerView.setAdapter(recycleAdapter);
    }





    /** Handle vmaxAdView object for Activity Lifecycle changes */

    @Override
    protected void onDestroy() {
        if (vmaxAdView != null) {
       /** To Destroy vmaxAdView when Activity Is No Longer Available  */
            vmaxAdView.onDestroy();
        }
        super.onDestroy();
    }




}
