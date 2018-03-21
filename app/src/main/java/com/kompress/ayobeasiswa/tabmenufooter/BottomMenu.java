package com.kompress.ayobeasiswa.tabmenufooter;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;

public class BottomMenu extends AppCompatActivity {

    private TextView mTextMessage;
    private static final String TAG = "SearchActivity";

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            /*Fragment fragment = null;
            Class fragmentClass = null;
            */
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    //mTextMessage.setText(R.string.title_beranda);
                    return true;
                case R.id.navigation_search:
                    //mTextMessage.setText(R.string.title_cari);
                    Log.v(TAG,"Changing class...");

                    //fragmentClass = ActivitySearch.class;

                    ActivitySearch details = new ActivitySearch();
                    FragmentTransaction ft = getFragmentManager().beginTransaction();
                    ft.replace(R.id.fragContainer,details);
                    ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                    ft.commit();

                    return true;
                case R.id.navigation_histori:
                    //mTextMessage.setText(R.string.title_histori);
                    return true;
                case R.id.navigation_account:
                    //mTextMessage.setText(R.string.title_akun);
                    return true;
            }

            /*try {
                fragment = (Fragment) fragmentClass.newInstance();
            } catch (Exception e){
                e.printStackTrace();
            }

            FragmentManager fm = getFragmentManager();
            fm.beginTransaction().replace(R.id.fragContainer,fragment).commit();*/

            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_menu);

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

}
