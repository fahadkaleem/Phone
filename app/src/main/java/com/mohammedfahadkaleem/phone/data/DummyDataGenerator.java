package com.mohammedfahadkaleem.phone.data;

import android.content.Context;
import android.content.res.TypedArray;
import com.mohammedfahadkaleem.phone.R;
import com.mohammedfahadkaleem.phone.model.Contact;
import com.mohammedfahadkaleem.phone.utils.Utils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by fahadkaleem on 3/21/18.
 */

public class DummyDataGenerator {
  private final static String TAG = "DummyDataGenerator";
  public static List<Contact> getPeopleData(Context ctx) {
    List<Contact> contactList = new ArrayList<>();
    TypedArray drw_arr = ctx.getResources().obtainTypedArray(R.array.dummy_favourite_contacts_images);
    String name_arr[] = ctx.getResources().getStringArray(R.array.dummy_favourite_contacts);

    for (int i = 0; i < drw_arr.length(); i++) {
      Contact contact = new Contact();
      contact.image = drw_arr.getResourceId(i, -1);
      contact.name = name_arr[i];
      contact.email = Utils.getEmailFromName(contact.name);
      contact.imageDrw = ctx.getResources().getDrawable(contact.image);
      contactList.add(contact);
    }
    Collections.shuffle(contactList);
    return contactList;
  }
}
