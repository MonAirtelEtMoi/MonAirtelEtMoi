package lab.synah.cd.monairteletmoi;

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

public class PrimoActivity extends AppCompatActivity {


    DrawerLayout drawerLayout;
    Toolbar toolbar;
    ActionBar actionBar;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_primo);

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
                            case R.id.item_navigation_drawer_inbox:
                                menuItem.setChecked(true);
                                setActiveFragment(0);
                                drawerLayout.closeDrawer(GravityCompat.START);
                                return true;
                            case R.id.item_navigation_drawer_starred:
                                menuItem.setChecked(true);
                                setActiveFragment(1);
                                drawerLayout.closeDrawer(GravityCompat.START);
                                return true;
                            case R.id.item_navigation_drawer_sent_mail:
                                menuItem.setChecked(true);
                                Toast.makeText(PrimoActivity.this, "Launching " + menuItem.getTitle().toString(), Toast.LENGTH_SHORT).show();
                                drawerLayout.closeDrawer(GravityCompat.START);
                                return true;
                            case R.id.item_navigation_drawer_drafts:
                                menuItem.setChecked(true);
                                Toast.makeText(PrimoActivity.this, "Launching " + menuItem.getTitle().toString(), Toast.LENGTH_SHORT).show();
                                drawerLayout.closeDrawer(GravityCompat.START);
                                return true;
                            case R.id.item_navigation_drawer_settings:
                                menuItem.setChecked(true);
                                Toast.makeText(PrimoActivity.this, "Launching " + menuItem.getTitle().toString(), Toast.LENGTH_SHORT).show();
                                drawerLayout.closeDrawer(GravityCompat.START);
                               // Intent intent = new Intent(PrimoActivity.this, SettingsActivity.class);
                              //  startActivity(intent);
                                return true;
                            case R.id.item_navigation_drawer_help_and_feedback:
                                menuItem.setChecked(true);
                                Toast.makeText(PrimoActivity.this, menuItem.getTitle().toString(), Toast.LENGTH_SHORT).show();
                                drawerLayout.closeDrawer(GravityCompat.START);
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
                //StudentFragment studentFragment=new StudentFragment();
              //  fragmentTransaction.replace(R.id.fragment, studentFragment);
                fragmentTransaction.commit();
                break;
            case 1:
//                fragmentManager=getSupportFragmentManager();
//                fragmentTransaction=fragmentManager.beginTransaction();
//                StudentFragment studentFragment=new StudentFragment();
//                fragmentTransaction.replace(R.id.fragment, studentFragment);
//                fragmentTransaction.commit();
                break;
        }
    }



}
