package com.mohammedfahadkaleem.phone.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.mohammedfahadkaleem.phone.R;

/**
 * Created by fahadkaleem on 3/20/18.
 */

public class FavouritesFragment extends Fragment{
 @BindView(R.id.favourites_recycler_view)
 RecyclerView mRecyclerView;

 public FavouritesFragment(){}

 public static FavouritesFragment newInstance(){
   FavouritesFragment favouritesFragment = new FavouritesFragment();
   return favouritesFragment;
 }

  @Nullable
  @Override
  public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
   View view = inflater.inflate(R.layout.fragment_favourites,container,false);
   ButterKnife.bind(getActivity());
   mRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(),2));
   mRecyclerView.setHasFixedSize(true);
    return view;
  }
}
