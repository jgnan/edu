package org.shenit.tutorial.android.dataprovider;

import android.content.Context;
import android.database.Cursor;
import android.provider.ContactsContract.Contacts;
import android.support.v4.widget.SimpleCursorAdapter;

import org.shenit.tutorial.android.R;

/**
 * Created by 江老师 on 6/3/16.
 */
public class SimpleContactsCursorAdapter extends SimpleCursorAdapter{
    private static final String[] COLUMNS = {Contacts.DISPLAY_NAME,Contacts.PHOTO_URI};
    private static final int[] IDS={R.id.display_name,R.id.thumbnail};

    public SimpleContactsCursorAdapter(Context context, Cursor c) {
        super(context, R.layout.item_simple_contact, c, COLUMNS, IDS, 0);
    }


}
