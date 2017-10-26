package com.indieDream.wordChain;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by kjw19 on 19/10/2017.
 */

public class bottomViewPageAdapter extends FragmentPagerAdapter {

    private ArrayList<bottomFragment> fragments = new ArrayList<>();
    private bottomFragment currentFragment;

    public bottomViewPageAdapter(FragmentManager fm) {
        super(fm);

        fragments.clear();
        fragments.add(bottomFragment.newInstance(0));
        fragments.add(bottomFragment.newInstance(1));
    }

    @Override
    public bottomFragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Override
    public void setPrimaryItem(ViewGroup container, int position, Object object) {
        if (getCurrentFragment() != object) {
            currentFragment = ((bottomFragment) object);
        }
        super.setPrimaryItem(container, position, object);
    }

    /**
     * Get the current fragment
     */
    public bottomFragment getCurrentFragment() {
        return currentFragment;
    }
}