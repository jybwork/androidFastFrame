package com.library.base;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * @创建人: Ailen
 * @创建时间: 2019/10/21 0021
 * @描述：Fragment适配器
 */
public class BasePagerAdapter  extends FragmentPagerAdapter {
    private ArrayList<Fragment> fragments;

    public BasePagerAdapter(FragmentManager fm, ArrayList<Fragment> fragments) {
        super(fm);
        this.fragments = fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

}
