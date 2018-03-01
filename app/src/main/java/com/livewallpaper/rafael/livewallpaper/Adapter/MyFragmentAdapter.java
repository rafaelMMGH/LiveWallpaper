package com.livewallpaper.rafael.livewallpaper.Adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.livewallpaper.rafael.livewallpaper.Fragment.CategoryFragment;
import com.livewallpaper.rafael.livewallpaper.Fragment.DailyPopularFragment;
import com.livewallpaper.rafael.livewallpaper.Fragment.RecentsFragment;

/**
 * Created by rafael on 20/02/18.
 */

public class MyFragmentAdapter extends FragmentPagerAdapter {

    private Context context;

    public MyFragmentAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
    }


    @Override
    public Fragment getItem(int position) {
        if (position == 0)
        return CategoryFragment.getInstance();
        else if(position == 1)
            return DailyPopularFragment.getInstance();
        else if (position == 2)
            return RecentsFragment.getInstance();
        else
            return null;
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position)
        {
            case 0:
                return "Categorias";
            case 1:
                return "Diaros";
            case 2:
                return "Recientes";
        }
        return "";
    }
}
