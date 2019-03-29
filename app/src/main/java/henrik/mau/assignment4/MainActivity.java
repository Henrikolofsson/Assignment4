package henrik.mau.assignment4;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;


public class MainActivity extends AppCompatActivity {
    private Controller controller;
    private FragmentManager fm;

    private Toolbar toolbar;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializeSystem();
        initializeComponents();
    }

    private void initializeSystem(){
        fm = getSupportFragmentManager();
        controller = new Controller(this);
    }

    private void initializeComponents(){
        toolbar = findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);
        final ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.ic_menu_black_24dp);
        drawerLayout = findViewById(R.id.drawerLayout);
        navigationView = findViewById(R.id.navigationView);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch(menuItem.getItemId()){
                    case R.id.nav_compass:
                        menuItem.setChecked(true);
                        drawerLayout.closeDrawers();
                        return true;

                    case R.id.nav_steps:
                        menuItem.setChecked(true);
                        drawerLayout.closeDrawers();
                        return true;

                }
                return false;
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /*
       Used to dynamically change fragments.
     */
    public void setFragment(Fragment fragment, String tag){
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.main_container, fragment, tag);
        ft.commit();
    }

    /*
       Used by dataFragment to add and store fragments in it.
     */
    public void addFragment(Fragment fragment, String tag){
        FragmentTransaction ft = fm.beginTransaction();
        ft.add(fragment, tag);
        ft.commit();
    }

    /*
       Calls the controllers onBackPressed method to control
       what fragments is exchanged to when pressed.
     */
    @Override
    public void onBackPressed() {
        if(controller.onBackPressed()){
            super.onBackPressed();
        }
    }

    public Fragment getFragment(String tag){
        return fm.findFragmentByTag(tag);
    }

}
