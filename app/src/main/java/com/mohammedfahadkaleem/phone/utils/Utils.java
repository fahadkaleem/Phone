package com.mohammedfahadkaleem.phone.utils;

import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.DrawableRes;
import android.util.TypedValue;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

/**
 * Created by fahadkaleem on 3/21/18.
 */

public class Utils {

  public static int dpToPx(Context c, int dp) {
    Resources r = c.getResources();
    return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics()));
  }

  public static void displayImageOriginal(Context ctx, ImageView img, @DrawableRes int drawable) {
    try {
      Glide.with(ctx).load(drawable)
          .crossFade()
          .diskCacheStrategy(DiskCacheStrategy.NONE)
          .into(img);
    } catch (Exception e) {
    }
  }

  public static String getEmailFromName(String name) {
    if (name != null && !name.equals("")) {
      String email = name.replaceAll(" ", ".").toLowerCase().concat("@mail.com");
      return email;
    }
    return name;
  }

}
