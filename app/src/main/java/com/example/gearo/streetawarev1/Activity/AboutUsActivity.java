package com.example.gearo.streetawarev1.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Toast;

import com.example.gearo.streetawarev1.R;

import java.util.Calendar;

import mehdi.sakout.aboutpage.AboutPage;
import mehdi.sakout.aboutpage.Element;

public class AboutUsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Element versionElement = new Element();
        versionElement.setTitle("Version 1.0");

        View aboutPage = new AboutPage(this)
                .isRTL(false)
                .setImage(R.mipmap.ic_launcher_round)
                .setDescription("Providing you with all your fashion needs")
                .addItem(versionElement)
                .addGroup("Connect with me")
                .addEmail("115495208@umail.ucc.ie")
                .addPlayStore("Find us on the PlayStore")
                .addInstagram("StreetAware Instagram")
                .addTwitter("StreetAware Twitter")
                .addItem(createCopyright())
                .create();

        setContentView(aboutPage);
    }

    private Element createCopyright(){
        Element copyright = new Element();
        final String copyrightString = String.format("Copyright %d by StreetAware", Calendar.getInstance().get(Calendar.YEAR));
        copyright.setTitle(copyrightString);
        copyright.setIconDrawable(R.mipmap.ic_launcher_round);
        copyright.setGravity(Gravity.CENTER);
        copyright.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Toast.makeText(AboutUsActivity.this,copyrightString,Toast.LENGTH_SHORT).show();
            }
        });
        return copyright;
    }
}
