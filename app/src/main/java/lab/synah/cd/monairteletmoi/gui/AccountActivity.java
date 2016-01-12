package lab.synah.cd.monairteletmoi.gui;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import lab.synah.cd.monairteletmoi.R;
import lab.synah.cd.monairteletmoi.fragment.MapFragment;
import lab.synah.cd.monairteletmoi.fragment.PrimoFragment;

public class AccountActivity extends AppCompatActivity {


    DrawerLayout drawerLayout;
    Toolbar toolbar;
    ActionBar actionBar;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);

        toolbar=(Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        actionBar=getSupportActionBar();
        actionBar.setHomeAsUpIndicator(R.drawable.ic_menu_white_24dp);
        actionBar.setDisplayHomeAsUpEnabled(true);

        drawerLayout=(DrawerLayout) findViewById(R.id.navigation_drawer_layout);

        NavigationView navigationView =(NavigationView) findViewById(R.id.navigation_view);
        if(navigationView!=null){
            setNavigationDrawerContent(navigationView);
        }

        setNavigationDrawerContent(navigationView);

        //Open the first fragment
        setActiveFragment(0);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_primo, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }



    private void setNavigationDrawerContent(NavigationView navigationView){
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        // textView = (TextView) findViewById(R.id.textView);
                        switch (menuItem.getItemId()) {
                            case R.id.item_navigation_drawer_moncompte:
                                menuItem.setChecked(true);
                                setActiveFragment(0);
                                drawerLayout.closeDrawer(GravityCompat.START);
                                return true;
                            case R.id.item_navigation_drawer_recharge:
                                menuItem.setChecked(true);
                                setActiveFragment(1);
                                drawerLayout.closeDrawer(GravityCompat.START);
                                return true;
                            case R.id.item_navigation_drawer_services:
                                menuItem.setChecked(true);
                                Toast.makeText(AccountActivity.this, "Launching " + menuItem.getTitle().toString(), Toast.LENGTH_SHORT).show();
                                drawerLayout.closeDrawer(GravityCompat.START);
                                return true;
                            case R.id.item_navigation_drawer_offres:
                                menuItem.setChecked(true);
                                Toast.makeText(AccountActivity.this, "Launching " + menuItem.getTitle().toString(), Toast.LENGTH_SHORT).show();
                                drawerLayout.closeDrawer(GravityCompat.START);
                                return true;
                            case R.id.item_navigation_drawer_money:
                                menuItem.setChecked(true);
                                Toast.makeText(AccountActivity.this, "Launching " + menuItem.getTitle().toString(), Toast.LENGTH_SHORT).show();
                                drawerLayout.closeDrawer(GravityCompat.START);
                                return true;
                            case R.id.item_navigation_drawer_faqs:
                                menuItem.setChecked(true);
                                Toast.makeText(AccountActivity.this, "Launching " + menuItem.getTitle().toString(), Toast.LENGTH_SHORT).show();
                                drawerLayout.closeDrawer(GravityCompat.START);
                                return true;
                            case R.id.item_navigation_drawer_shops:
                                menuItem.setChecked(true);
                                Toast.makeText(AccountActivity.this, "Launching " + menuItem.getTitle().toString(), Toast.LENGTH_SHORT).show();
                                drawerLayout.closeDrawer(GravityCompat.START);
                                return true;
                            case R.id.item_navigation_drawer_settings:
                                menuItem.setChecked(true);
                                Toast.makeText(AccountActivity.this, "Launching " + menuItem.getTitle().toString(), Toast.LENGTH_SHORT).show();
                                drawerLayout.closeDrawer(GravityCompat.START);
                                Intent intent = new Intent(AccountActivity.this, SettingsActivity.class);
                                startActivity(intent);
                                return true;
                            case R.id.item_navigation_drawer_ussd_code:
                                /*menuItem.setChecked(true);
                                Toast.makeText(PrimoActivity.this, menuItem.getTitle().toString(), Toast.LENGTH_SHORT).show();
                                drawerLayout.closeDrawer(GravityCompat.START);*/

                                menuItem.setChecked(true);
                                Toast.makeText(AccountActivity.this, "Launching " + menuItem.getTitle().toString(), Toast.LENGTH_SHORT).show();
                                drawerLayout.closeDrawer(GravityCompat.START);
                                Intent intent2 = new Intent(AccountActivity.this, UssdFirebaseActivity.class);
                                startActivity(intent2);
                                return true;
                        }
                        return true;
                    }
                });
    }


    public void setActiveFragment(int position){
        FragmentManager fragmentManager;
        FragmentTransaction fragmentTransaction;
        switch (position){
            case 0:
                fragmentManager=getSupportFragmentManager();
                fragmentTransaction=fragmentManager.beginTransaction();
                PrimoFragment mainFragment=new PrimoFragment();
                fragmentTransaction.replace(R.id.fragment,mainFragment);
                fragmentTransaction.commit();
                break;
            case 1:
                fragmentManager=getSupportFragmentManager();
                fragmentTransaction=fragmentManager.beginTransaction();
                MapFragment accountFragment=new MapFragment();
                fragmentTransaction.replace(R.id.fragment, accountFragment);
                fragmentTransaction.commit();
                break;
        }
    }



}
