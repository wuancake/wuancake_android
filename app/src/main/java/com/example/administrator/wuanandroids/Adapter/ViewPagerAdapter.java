package com.example.administrator.wuanandroids.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;

import java.util.List;

/**
 * @class name: ViewPagerAdapter
 * @anthor ：卫士
 * @time :Create on 2018/9/11  8:54
 */
public class ViewPagerAdapter extends FragmentStatePagerAdapter {
    List<Fragment>  fragmentList=null;
    private  Context context;
    public ViewPagerAdapter(Context context,FragmentManager fm , List<Fragment> fragmentList) {
        super(fm);
        this.context=context;
        this.fragmentList=fragmentList;
        notifyDataSetChanged();
    }

    @Override
    public Fragment getItem(int i) {
        return fragmentList.get(i);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }

    @Override
    public int getItemPosition(@NonNull Object object) {
        return PagerAdapter.POSITION_NONE;
    }

//    public void addFragment(Fragment fragment){
//        fragmentList.add(fragment);
//    }
//    public void changeFragment(Fragment fragment){
//        if(fragmentList.size()>0) {
//            if (fragmentList.contains(fragmentList.get(0))) {
//                fragmentList.remove(0);
//                fragmentList.add(0, fragment);
//            } else {
//                fragmentList.add(fragment);
//            }
//        }else{
//            addFragment(fragment);
//        }
//    }
}
