package com.mohammedfahadkaleem.phone.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.mohammedfahadkaleem.phone.R;

/**
 * Created by fahadkaleem on 3/20/18.
 */

public class VoicemailFragment extends Fragment{
 public VoicemailFragment(){}

 public static VoicemailFragment newInstance(){
   VoicemailFragment voicemailFragment = new VoicemailFragment();
   return voicemailFragment;
 }

  @Nullable
  @Override
  public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
   View view = inflater.inflate(R.layout.fragment_voicemail,container,false);
    return view;
  }
}
