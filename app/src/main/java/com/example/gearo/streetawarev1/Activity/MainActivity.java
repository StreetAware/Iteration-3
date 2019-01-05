package com.example.gearo.streetawarev1.Activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.example.gearo.streetawarev1.Fragment.ArticlesFragment;
import com.example.gearo.streetawarev1.Fragment.CalendarFragment;
import com.example.gearo.streetawarev1.Fragment.HomeFragment;
import com.example.gearo.streetawarev1.Fragment.LogoutFragment;
import com.example.gearo.streetawarev1.Fragment.RateMyFitFragment;
import com.example.gearo.streetawarev1.Fragment.TrendingFragment;
import com.example.gearo.streetawarev1.R;


public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private BottomNavigationView mBottomNav;

//    Initialising the fragments
    private HomeFragment homeFragment;
    private TrendingFragment trendingFragment;
    private CalendarFragment calendarFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

//        Creating an instance of the BottomNavigationView
        mBottomNav = (BottomNavigationView) findViewById(R.id.btmNavView);

//        Constructors for the fragments
        homeFragment = new HomeFragment();
        trendingFragment = new TrendingFragment();
        calendarFragment = new CalendarFragment();

        /*Setting the default fragment*/
        setFragment(homeFragment);

        mBottomNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
//            Depending on which item in the bottom nav bar is selected, the corresponding screen will show
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch(item.getItemId()) {

                    /*If this case is selected then the background color will change to primary and the fragment will be switched to home*/
                    case R.id.nav_trending:
                        mBottomNav.setItemBackgroundResource(R.color.NavDrawerBG);
                        setFragment(trendingFragment);
                        return true;

                    case R.id.nav_home:
                        mBottomNav.setItemBackgroundResource(R.color.NavDrawerBG);
                        setFragment(homeFragment);
                        return true;

                    case R.id.nav_calendar:
                        mBottomNav.setItemBackgroundResource(R.color.NavDrawerBG);
                        setFragment(calendarFragment);
                        return true;

                        default: return false;
                }
            }
        });

    }

    /*Creates the method with which to replace the current fragment with the selected fragment*/
    private void setFragment(Fragment fragment) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();

        ft.replace(R.id.flMain, fragment);
        ft.commit();
    }

    //Setting the title of the action bar to correlate with the selected navigation drawer item
    public void setActionBarTitle(String title){
        getSupportActionBar().setTitle(title);

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_login) {
            Intent a = new Intent(MainActivity.this, LoginActivity.class);
            startActivity(a);
        } else if (id == R.id.action_logout) {
            android.support.v4.app.FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.flMain, new LogoutFragment()); //Replacing the frame layout I set with the articles fragment
            ft.commit();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_articles) {
            android.support.v4.app.FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.flMain, new ArticlesFragment()); //Replacing the frame layout I set with the articles fragment
            ft.commit();
        } else if (id == R.id.nav_cop_the_fit) {
            Intent a = new Intent(MainActivity.this, CTF_Activity.class);
            startActivity(a);
        } else if (id == R.id.nav_rate_my_fit) {
            android.support.v4.app.FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.flMain, new RateMyFitFragment()); //Replacing the frame layout I set with the articles fragment
            ft.commit();
            /*This is to open an activity instead of a fragment*/
        } else if (id == R.id.nav_settings) {
            Intent a = new Intent(MainActivity.this, SettingsActivity.class);
            startActivity(a);
        }   else if (id == R.id.nav_about_us) {
            Intent a = new Intent(MainActivity.this, AboutUsActivity.class);
            startActivity(a);
            /*This is to open the google docs file I saved containing the Privacy Policy*/
        } else if (id == R.id.nav_privacy_policy) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://docs.google.com/document/d/e/2PACX-1vRqSNgs8m3bF0q0ANxG9FR4DbbyMBUHcSVRLSwC1Se4axBvNljeOSo_ejoRlj6TOdAQGsmBdAJBx3_u/pub")));
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
