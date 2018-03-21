package com.mohammedfahadkaleem.phone;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.mohammedfahadkaleem.phone.adapter.ViewPagerAdapter;
import com.mohammedfahadkaleem.phone.fragment.ContactsListFragment;
import com.mohammedfahadkaleem.phone.fragment.FavouritesFragment;
import com.mohammedfahadkaleem.phone.fragment.RecentsFragment;
import com.mohammedfahadkaleem.phone.fragment.VoicemailFragment;

public class MainActivity extends AppCompatActivity {
  @BindView(R.id.view_pager)
  ViewPager mViewPager;

  @BindView(R.id.tab_layout)
  TabLayout mTabLayout;

  private ViewPagerAdapter mViewPagerAdapter;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    ButterKnife.bind(this);
    setupTabLayout();
  }

  private void setupTabLayout(){
    setupViewPager(mViewPager);
    mTabLayout.setupWithViewPager(mViewPager);
    mTabLayout.getTabAt(0).setIcon(R.drawable.ic_star);
    mTabLayout.getTabAt(1).setIcon(R.drawable.ic_recents);
    mTabLayout.getTabAt(2).setIcon(R.drawable.ic_contacts_list);
    mTabLayout.getTabAt(3).setIcon(R.drawable.ic_voicemail);
  }

  private void setupViewPager(ViewPager viewPager){
    mViewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
    mViewPagerAdapter.addFragment(FavouritesFragment.newInstance());
    mViewPagerAdapter.addFragment(RecentsFragment.newInstance());
    mViewPagerAdapter.addFragment(ContactsListFragment.newInstance());
    mViewPagerAdapter.addFragment(VoicemailFragment.newInstance());
    mViewPager.setAdapter(mViewPagerAdapter);
  }
}
