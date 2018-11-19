package com.example.gearo.streetawarev1.Activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.example.gearo.streetawarev1.R;
import com.example.gearo.streetawarev1.util.CtfFavouritesFragment;
import com.example.gearo.streetawarev1.util.CtfPostFragment;
import com.example.gearo.streetawarev1.util.CtfSearchFragment;
import com.example.gearo.streetawarev1.util.SectionsPagerAdapter;


public class CTF_SearchActivity extends AppCompatActivity {

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

        setupViewPager();
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

}
