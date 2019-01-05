package com.example.gearo.streetawarev1.Activity;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.gearo.streetawarev1.R;
import com.example.gearo.streetawarev1.util.CtfFavouritesFragment;
import com.example.gearo.streetawarev1.util.CtfPostFragment;
import com.example.gearo.streetawarev1.util.CtfSearchFragment;
import com.example.gearo.streetawarev1.util.SectionsPagerAdapter;


public class CTF_Activity extends AppCompatActivity {

    private static final String TAG = "CTF_Activity";

    //Used for catching result in the onRequestPermission result method
    private static final int REQUEST_CODE = 1404;

    //Widgets
    private TabLayout mTabLayout;
    public ViewPager mViewPager;

    //Variables
    public SectionsPagerAdapter mPagerAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ctf_search);
        mTabLayout = (TabLayout)findViewById(R.id.CTFtabs);
        mViewPager = (ViewPager)findViewById(R.id.viewpager_container);

        verifyPermissions();
    }

    private void setupViewPager(){
        mPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());
        mPagerAdapter.addFragment(new CtfSearchFragment());
        mPagerAdapter.addFragment(new CtfFavouritesFragment());
        mPagerAdapter.addFragment(new CtfPostFragment());

        mViewPager.setAdapter(mPagerAdapter);
        mTabLayout.setupWithViewPager(mViewPager);
        mTabLayout.getTabAt(0).setText(R.string.fragment_search);
        mTabLayout.getTabAt(1).setText(R.string.fragment_favourites);
        mTabLayout.getTabAt(2).setText(R.string.fragment_post);

    }

    private void verifyPermissions(){
        Log.d(TAG, "verifyPermissions: asking user for permission");
        String[] permissions = {Manifest.permission.READ_EXTERNAL_STORAGE,
        Manifest.permission.WRITE_EXTERNAL_STORAGE,
        Manifest.permission.CAMERA};

        if(ContextCompat.checkSelfPermission(this.getApplicationContext(),
                permissions[0]) == PackageManager.PERMISSION_GRANTED
                && ContextCompat.checkSelfPermission(this.getApplicationContext(),
                permissions[1]) == PackageManager.PERMISSION_GRANTED
                && ContextCompat.checkSelfPermission(this.getApplicationContext(),
                permissions[2]) == PackageManager.PERMISSION_GRANTED) {
            setupViewPager();
        }else{
            ActivityCompat.requestPermissions(CTF_Activity.this,
                    permissions,
                    REQUEST_CODE);
        }
    }

    //This is used to catch result code (Logic above should suffice)
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        verifyPermissions();
    }

}
