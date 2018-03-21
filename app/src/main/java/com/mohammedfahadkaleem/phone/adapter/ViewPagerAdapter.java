package com.mohammedfahadkaleem.phone.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import com.mohammedfahadkaleem.phone.fragment.ContactsListFragment;
import com.mohammedfahadkaleem.phone.fragment.FavouritesFragment;
import com.mohammedfahadkaleem.phone.fragment.RecentsFragment;
import com.mohammedfahadkaleem.phone.fragment.VoicemailFragment;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by fahadkaleem on 3/20/18.
 */

public class ViewPagerAdapter extends FragmentPagerAdapter {

  private final List<Fragment> mFragmentList = new ArrayList<>();
  private final List<String> mFragmentTitleList = new ArrayList<>();

  public ViewPagerAdapter(FragmentManager manager) {
    super(manager);
  }

  @Override
  public Fragment getItem(int position) {
    switch (position){
      case 0:
        return new FavouritesFragment();
      case 1:
        return new RecentsFragment();
      case 2:
        return new ContactsListFragment();
      case 3:
        return new VoicemailFragment();
      default:
        return null;
    }
  }

  @Override
  public int getCount() {
    return mFragmentList.size();
  }

  public void addFragment(Fragment fragment) {
    mFragmentList.add(fragment);
  }

  @Override
  public CharSequence getPageTitle(int position) {
    return null;
  }}