package com.mohammedfahadkaleem.phone.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.mohammedfahadkaleem.phone.R;

/**
 * Created by fahadkaleem on 3/21/18.
 */

public class SearchContactsActivity extends AppCompatActivity{
  ImageView backArrow;
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_search_contacts);
    backArrow = findViewById(R.id.iv_back_arrow);
    backArrow.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View view) {
        Intent intent = new Intent(SearchContactsActivity.this, MainActivity.class);
        startActivity(intent);
      }
    });

  }

}
