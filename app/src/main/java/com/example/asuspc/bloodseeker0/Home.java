package com.example.asuspc.bloodseeker0;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.ListFragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class Home extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private Toolbar toolbar;
    Fragment fragment;
    NavigationView navigationView;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private int[] tabIcons = {
            R.drawable.newspaper,
            R.drawable.route,
            R.drawable.notification,
            R.drawable.donate,
            R.drawable.request,
            R.drawable.history,
            R.drawable.rewards,
            R.drawable.followers,
            R.drawable.campaign,
            R.drawable.support
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
        setupTabIcons();

        Toolbar toolbars = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbars);

//
//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbars, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        int tab_position=tabLayout.getSelectedTabPosition();
        tabLayout.setOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(viewPager) {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch(tab.getPosition()) {
                    case 0:
                        fragment = new NotificationFrag();
                        FragmentTransaction ft;
                        ft = getSupportFragmentManager().beginTransaction();
                        ft.replace(R.id.mainFrame, fragment);
                        ft.commit();
                        navigationView.getMenu().getItem(1).setChecked(true);
                        break;
                    case 1:
                        navigationView.getMenu().getItem(0).setChecked(true);
                        break;
                    case 2:
                        fragment = new NotificationFrag();
                        ft = getSupportFragmentManager().beginTransaction();
                        ft.replace(R.id.mainFrame, fragment);
                        ft.commit();

                        navigationView.getMenu().getItem(2).setChecked(true);
                        break;
                    case 3:
                        navigationView.getMenu().getItem(3).setChecked(true);
                        break;
                    case 4:
                        navigationView.getMenu().getItem(4).setChecked(true);
                        break;
                    case 5:
                        navigationView.getMenu().getItem(5).setChecked(true);
                        break;
                    case 6:
                        navigationView.getMenu().getItem(6).setChecked(true);
                        break;
                    case 7:
                        fragment = new followersFragment();
                        ft = getSupportFragmentManager().beginTransaction();
                        ft.replace(R.id.mainFrame, fragment);
                        ft.commit();
                        navigationView.getMenu().getItem(7).setChecked(true);
                        break;
                    case 8:
                        navigationView.getMenu().getItem(8).setChecked(true);
                        break;
                    case 9:
                        navigationView.getMenu().getItem(9).setChecked(true);
                        break;
                }
                super.onTabSelected(tab);
            }
        });

    }
    private void setupTabIcons() {
        tabLayout.getTabAt(0).setIcon(tabIcons[0]);
        tabLayout.getTabAt(1).setIcon(tabIcons[1]);
        tabLayout.getTabAt(2).setIcon(tabIcons[2]);
        tabLayout.getTabAt(3).setIcon(tabIcons[3]);
        tabLayout.getTabAt(4).setIcon(tabIcons[4]);
        tabLayout.getTabAt(5).setIcon(tabIcons[5]);
        tabLayout.getTabAt(6).setIcon(tabIcons[6]);
        tabLayout.getTabAt(7).setIcon(tabIcons[7]);
        tabLayout.getTabAt(8).setIcon(tabIcons[8]);
        tabLayout.getTabAt(9).setIcon(tabIcons[9]);
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFrag(new FeedFragment(), "Feeds");
        adapter.addFrag(new Fragment(), "Maps");
        adapter.addFrag(new NotificationFrag(), "Notification");
        adapter.addFrag(new Fragment(), "Donate");
        adapter.addFrag(new Fragment(), "Request");
        adapter.addFrag(new Fragment(), "History");
        adapter.addFrag(new Fragment(), "Rewards");
        adapter.addFrag(new followersFragment(), "Followers");
        adapter.addFrag(new Fragment(), "Campaign");
        adapter.addFrag(new Fragment(), "Support");
        viewPager.setAdapter(adapter);
    }

    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFrag(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
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

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.home, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }
    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(final MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();


        if (id == R.id.feed) {
            fragment = new FeedFragment();
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.mainFrame, fragment);
            ft.commit();


            TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
            TabLayout.Tab tab = tabLayout.getTabAt(0);
            tab.select();
//            toolbar.setTitle("Notification");
        } else if (id == R.id.map) {
//            TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
//            TabLayout.Tab tab = tabLayout.getTabAt(1);
//            tab.select();
//            toolbar.setTitle("Notification");
        } else if (id == R.id.nav_notif) {
            fragment = new NotificationFrag();
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.mainFrame, fragment);
            ft.commit();

            TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
            TabLayout.Tab tab = tabLayout.getTabAt(2);
            tab.select();
//            toolbar.setTitle("Notification");
        } else if (id == R.id.nav_donate) {
//            TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
//            TabLayout.Tab tab = tabLayout.getTabAt(3);
//            tab.select();
        } else if (id == R.id.nav_request) {
//            TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
//            TabLayout.Tab tab = tabLayout.getTabAt(4);
//            tab.select();
        } else if (id == R.id.nav_history) {
//            TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
//            TabLayout.Tab tab = tabLayout.getTabAt(5);
//            tab.select();
        } else if (id == R.id.nav_rewards) {
//            TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
//            TabLayout.Tab tab = tabLayout.getTabAt(6);
//            tab.select();
        } else if (id == R.id.nav_followers) {
            toolbar.setTitle("Followers");
            tabLayout.getTabAt(7).getCustomView().setSelected(true);
            fragment = new followersFragment();
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.mainFrame, fragment);
            ft.commit();
            TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
            TabLayout.Tab tab = tabLayout.getTabAt(7);
            tab.select();
        } else if (id == R.id.nav_support) {
//            TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
//            TabLayout.Tab tab = tabLayout.getTabAt(9);
//            tab.select();
        } else if (id == R.id.campaign) {
//            TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
//            TabLayout.Tab tab = tabLayout.getTabAt(8);
//            tab.select();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
