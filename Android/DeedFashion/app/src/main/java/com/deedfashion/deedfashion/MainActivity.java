package com.deedfashion.deedfashion;

import android.support.v7.app.AppCompatActivity;
import android.support.v4.view.ViewPager;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.Fragment;
import android.os.Bundle;


public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        ViewPager viewPager = (ViewPager) findViewById(R.id.pager);


        tabLayout.addTab(tabLayout.newTab());
        tabLayout.addTab(tabLayout.newTab());
        tabLayout.addTab(tabLayout.newTab());

        viewPager.setAdapter(new ViewPagerAdapter(getSupportFragmentManager()));

        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0).setText("home");
        tabLayout.getTabAt(1).setText("post");
        tabLayout.getTabAt(2).setText("shop");
        tabLayout.getTabAt(3).setText("collection");
        tabLayout.getTabAt(4).setText("news");

    }

    private class ViewPagerAdapter extends FragmentPagerAdapter {
        public ViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            Fragment fragment = null;

            switch (position) {
                case 0:
                    fragment = new homeFragment();
                    break;
                case 1:
                    fragment = new postFragment();
                    break;
                case 2:
                    fragment = new shopFragment();
                    break;
                case 3:
                    fragment = new collectionFragment();
                    break;
                case 4:
                    fragment = new newsFragment();
                    break;
                default:
                    break;
            }
            return fragment;
        }

        @Override
        public int getCount() {

            //タブ追加したら5に変更
            return 5;
        }


        @Override
        public CharSequence getPageTitle(int position) {
            return null;
        }


    }
}
