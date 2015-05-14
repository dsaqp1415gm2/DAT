package api.dat.dsaqp1415gm2.dsa.eetac.upc.edu.dat_android.TabPager;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import api.dat.dsaqp1415gm2.dsa.eetac.upc.edu.dat_android.TabPager.FragmentTab;

public class ViewPagerAdapter extends FragmentStatePagerAdapter {

    final int PAGE_COUNT = 4;
    // Tab Titles
    private String TABTITLES[] = new String[] { "TECNOLOGIA", "DEPORTES", "MOTOR", "VIDEOJUEGOS" };
    Context context;

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {

            // Open FragmentTab1.java
            case 0:
                FragmentTab fragmenttab1 = new FragmentTab();
                fragmenttab1.setID(1);
                return fragmenttab1;

            // Open FragmentTab2.java
            case 1:
                FragmentTab fragmenttab2 = new FragmentTab();
                fragmenttab2.setID(2);
                return fragmenttab2;

            // Open FragmentTab3.java
            case 2:
                FragmentTab fragmenttab3 = new FragmentTab();
                fragmenttab3.setID(3);
                return fragmenttab3;

            // Open FragmentTab4.java
            case 3:
                FragmentTab fragmenttab4 = new FragmentTab();
                fragmenttab4.setID(4);
                return fragmenttab4;
        }
        return null;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return TABTITLES[position];
    }
}