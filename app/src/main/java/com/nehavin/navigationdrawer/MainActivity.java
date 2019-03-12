package com.nehavin.navigationdrawer;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;
import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    Toolbar toolbar;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ActionBarDrawerToggle toggle;
    CircleImageView circleImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.navigation_drawer);

        toolbar = (Toolbar) findViewById(R.id.toolbaar);
        setSupportActionBar(toolbar);

        drawerLayout = (DrawerLayout)findViewById(R.id.nd);
        navigationView = (NavigationView)findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar,
                R.string.open_drawer, R.string.close_drawer);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        circleImageView = (CircleImageView) findViewById(R.id.circleViewImg);
    }



    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (toggle!=null) {
            drawerLayout.removeDrawerListener(toggle);
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();

        switch (id){
            case R.id.inbox_id:
                Toast.makeText(this, "inbox", Toast.LENGTH_SHORT).show();
                break;
            case R.id.starred_id:
                Toast.makeText(this, "Starred", Toast.LENGTH_SHORT).show();
                break;
            case R.id.sent_id:
                Toast.makeText(this, "Send", Toast.LENGTH_SHORT).show();
                break;
            case R.id.drafts_id:
                Toast.makeText(this, "Drafts", Toast.LENGTH_SHORT).show();
                break;
            case R.id.allmail_id:
                Toast.makeText(this, "All Mails", Toast.LENGTH_SHORT).show();
                break;
            case R.id.trash_id:
                Toast.makeText(this, "Trash", Toast.LENGTH_SHORT).show();
                break;
            case R.id.spam_id:
                Toast.makeText(this, "Spam", Toast.LENGTH_SHORT).show();
                break;
        }

        drawerLayout.closeDrawer(GravityCompat.START);

        return true;
    }

    @Override
    public void onBackPressed() {

        if(drawerLayout.isDrawerOpen(GravityCompat.START))
        {
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        else {
            super.onBackPressed();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
//        circleImageView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //        android:onClick="clickToast"
//                Toast.makeText(MainActivity.this, "Image Clicked", Toast.LENGTH_SHORT).show();
//            }
//        });
    }

    //    public void clickToast(View view)
//    {
//        Toast.makeText(this, "Image Clicked", Toast.LENGTH_SHORT).show();
//    }
}
