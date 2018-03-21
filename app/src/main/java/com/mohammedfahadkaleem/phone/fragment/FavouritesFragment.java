package com.mohammedfahadkaleem.phone.fragment;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.mohammedfahadkaleem.phone.R;
import com.mohammedfahadkaleem.phone.adapter.FavouritesGridAdapter;
import com.mohammedfahadkaleem.phone.data.DummyDataGenerator;
import com.mohammedfahadkaleem.phone.model.Contact;
import com.mohammedfahadkaleem.phone.utils.Utils;
import com.mohammedfahadkaleem.phone.widgets.SpacingItemDecoration;
import java.util.List;

/**
 * Created by fahadkaleem on 3/20/18.
 */

public class FavouritesFragment extends Fragment {
 private View parent_view;
 private RecyclerView recyclerView;
 private FavouritesGridAdapter mAdapter;

 public FavouritesFragment() {
  // Required empty public constructor
 }

 public static FavouritesFragment newInstance() {
  FavouritesFragment fragment = new FavouritesFragment();
  return fragment;
 }


 @Override
 public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
  View view =  inflater.inflate(R.layout.fragment_favourites, container, false);
  parent_view = getActivity().findViewById(android.R.id.content);
  recyclerView = view.findViewById(R.id.favourites_recyclerView);
  recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));
  recyclerView.addItemDecoration(new SpacingItemDecoration(2, Utils.dpToPx(getContext(), 1), true));
  recyclerView.setHasFixedSize(true);

  List<Contact> items = DummyDataGenerator.getPeopleData(getContext());

  //set data and list adapter
  mAdapter = new FavouritesGridAdapter(getActivity(), items);
  recyclerView.setAdapter(mAdapter);

  // on item list clicked
  mAdapter.setOnItemClickListener(new FavouritesGridAdapter.OnItemClickListener() {
   @Override
   public void onItemClick(View view, Contact obj, int position) {
    Snackbar.make(parent_view, obj.name + " clicked", Snackbar.LENGTH_SHORT).show();
   }
  });

  return view;
 }

}
