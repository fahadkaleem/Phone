package com.mohammedfahadkaleem.phone.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.mohammedfahadkaleem.phone.R;
import com.mohammedfahadkaleem.phone.model.Contact;
import com.mohammedfahadkaleem.phone.utils.Utils;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by fahadkaleem on 3/21/18.
 */

public class FavouritesGridAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
  private List<Contact> mContactList = new ArrayList<>();

  private OnLoadMoreListener mOnLoadMoreListener;

  private Context context;
  private OnItemClickListener mOnItemClickListener;

  public interface OnItemClickListener {
    void onItemClick(View view, Contact obj, int position);
  }

  public void setOnItemClickListener(final OnItemClickListener mItemClickListener) {
    this.mOnItemClickListener = mItemClickListener;
  }

  public FavouritesGridAdapter(Context context, List<Contact> items) {
    this.mContactList = items;
    this.context = context;
  }

  public class FavouritesGridViewHolder extends RecyclerView.ViewHolder {
    public ImageView image;
    public TextView name;
    public View lyt_parent;

    public FavouritesGridViewHolder(View view) {
      super(view);
      image = view.findViewById(R.id.image);
      name = view.findViewById(R.id.name);
      lyt_parent = view.findViewById(R.id.lyt_parent);
    }
  }

  @Override
  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    RecyclerView.ViewHolder vh;
    View v = LayoutInflater
        .from(parent.getContext()).inflate(R.layout.item_favourite_grid, parent, false);
    vh = new FavouritesGridViewHolder(v);
    return vh;
  }

  // Replace the contents of a view (invoked by the layout manager)
  @Override
  public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
    Contact obj = mContactList.get(position);
    if (holder instanceof FavouritesGridViewHolder) {
      FavouritesGridViewHolder view = (FavouritesGridViewHolder) holder;
      view.name.setText(obj.name);
      Utils.displayImageOriginal(context, view.image, obj.image);
      view.lyt_parent.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
          if (mOnItemClickListener != null) {
            mOnItemClickListener.onItemClick(view, mContactList.get(position), position);
          }
        }
      });
    }
  }

  @Override
  public int getItemCount() {
    return mContactList.size();
  }

  public void setmOnLoadMoreListener(OnLoadMoreListener mOnLoadMoreListener) {
    this.mOnLoadMoreListener = mOnLoadMoreListener;
  }

  public interface OnLoadMoreListener {
    void onLoadMore(int current_page);
  }

}