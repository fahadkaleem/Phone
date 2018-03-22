package com.mohammedfahadkaleem.phone.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.MenuInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.PopupMenu;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.mohammedfahadkaleem.phone.R;
import com.mohammedfahadkaleem.phone.adapter.ViewPagerAdapter;
import com.mohammedfahadkaleem.phone.fragment.ContactsListFragment;
import com.mohammedfahadkaleem.phone.fragment.FavouritesFragment;
import com.mohammedfahadkaleem.phone.fragment.RecentsFragment;
import com.mohammedfahadkaleem.phone.fragment.VoicemailFragment;

public class MainActivity extends AppCompatActivity {
  @BindView(R.id.search_bar)
  CardView searchCard;

  @BindView(R.id.menu)
  ImageButton menu;

  @BindView(R.id.iv_search)
  ImageButton searchImageButton;

  @BindView(R.id.tv_search)
  TextView searchTextView;

  @BindView(R.id.view_pager)
  ViewPager mViewPager;

  @BindView(R.id.tab_layout)
  TabLayout mTabLayout;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    ButterKnife.bind(this);
    setupTabLayout();

    menu.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View view) {
        showPopup(view);
      }
    });

    searchTextView.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View view) {
        viewSearchContacts();
      }
    });

    searchImageButton.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View view) {
        viewSearchContacts();
      }
    });

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
    ViewPagerAdapter mViewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
    mViewPagerAdapter.addFragment(FavouritesFragment.newInstance());
    mViewPagerAdapter.addFragment(RecentsFragment.newInstance());
    mViewPagerAdapter.addFragment(ContactsListFragment.newInstance());
    mViewPagerAdapter.addFragment(VoicemailFragment.newInstance());
    mViewPager.setAdapter(mViewPagerAdapter);
  }

  private void viewSearchContacts() {
    Intent intent = new Intent(MainActivity.this, SearchContactsActivity.class);
    ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(this, searchCard, "search");
    startActivity(intent, options.toBundle());
  }

  private void showPopup(View view) {
    PopupMenu popupMenu = new PopupMenu(this, view);
    MenuInflater inflater = popupMenu.getMenuInflater();
    inflater.inflate(R.menu.menu, popupMenu.getMenu());
    popupMenu.show();
  }
}
