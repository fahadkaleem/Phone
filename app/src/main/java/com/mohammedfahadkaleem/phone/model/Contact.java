package com.mohammedfahadkaleem.phone.model;

import android.graphics.drawable.Drawable;

/**
 * Created by fahadkaleem on 3/21/18.
 */

public class Contact {
  public int image;
  public Drawable imageDrw;
  public String name;
  public String email;
  public boolean section = false;

  public Contact() {
  }

  public Contact(String name, boolean section) {
    this.name = name;
    this.section = section;
  }

}
