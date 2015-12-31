package lab.synah.cd.monairteletmoi.gui;

import android.app.DialogFragment;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import lab.synah.cd.monairteletmoi.fragment.AddListUssdDialogFragment;
import lab.synah.cd.monairteletmoi.fragment.SuscriberListFragment;

import lab.synah.cd.monairteletmoi.BaseActivity;
import lab.synah.cd.monairteletmoi.R;

/**
 * Created by Michelo on 31/12/15.
 */
public class AddFirebaseActivity extends BaseActivity {

    private static final String LOG_TAG=AddFirebaseActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_ussd_activity);

        /**
         * Link layout elements from XML and setup the toolbar
         */
        initializeScreen();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        /* Inflate the menu; this adds items to the action bar if it is present. */
        getMenuInflater().inflate(R.menu.menu_primo, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    /**
     * Link layout elements from XML and setup the toolbar
     */
    public void initializeScreen() {
        ViewPager viewPager = (ViewPager) findViewById(R.id.pager);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        Toolbar toolbar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
        /**
         * Create SectionPagerAdapter, set it as adapter to viewPager with setOffscreenPageLimit(2)
         **/
        SectionPagerAdapter adapter = new SectionPagerAdapter(getSupportFragmentManager());
        viewPager.setOffscreenPageLimit(2);
        viewPager.setAdapter(adapter);
        /**
         * Setup the mTabLayout with view pager
         */
        tabLayout.setupWithViewPager(viewPager);
    }

    /**
     * Create an instance of the AddList dialog fragment and show it
     */
    public void showAddListDialog(View view){
        /* create an instance   */
        DialogFragment dialog = AddListUssdDialogFragment.newInstance();
        dialog.show(AddFirebaseActivity.this.getFragmentManager(),"AddListUssdFragment");
    }

    /*public void showSuscriberListDialog(View view){
        *//* create an instance   *//*
        DialogFragment dialog = SuscriberListFragment.newInstance();
        dialog.show(AddFirebaseActivity.this.getFragmentManager(),"SuscriberListFragment");
    }*/

    /**
     * SectionPagerAdapter class that extends FragmentStatePagerAdapter to save fragments state
     */
    public class SectionPagerAdapter extends FragmentStatePagerAdapter {

        public SectionPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        /**
         * Use positions (0 and 1) to find and instantiate fragments with newInstance()
         *
         * @param position
         */

        @Override
        public Fragment getItem(int position) {

            Fragment fragment = null;

            /**
             * Set fragment to different fragments depending on position in ViewPager
             */
            switch (position) {
                case 0:
                  //  fragment = ShoppingListsFragment.newInstance();
                    break;
                case 1:
                   // fragment = MealsFragment.newInstance();
                    break;
                default:
                  //  fragment = ShoppingListsFragment.newInstance();
                    break;
            }

            return fragment;
        }


        @Override
        public int getCount() {
            return 2;
        }

        /**
         * Set string resources as titles for each fragment by it's position
         *
         * @param position
         */
        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return getString(R.string.pager_title_ussd_lists);
                case 1:
                default:
                    return getString(R.string.pager_list_suscriber);
            }
        }
    }




}
