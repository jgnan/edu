package org.shenit.tutorial.android.dataprovider;

import android.database.Cursor;
import android.provider.ContactsContract.Contacts;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import org.shenit.tutorial.android.R;

/**
 * This example will show you how to get your contact data from data provider.
 */
public class ContactDataProviderExampleActivity extends AppCompatActivity {
    private static final String[] PROJECTIONS = {Contacts._ID,Contacts.DISPLAY_NAME};
    ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        list = (ListView) findViewById(R.id.list_view);
        Cursor cursor = getContentResolver().query(Contacts.CONTENT_URI,PROJECTIONS,null,null,null);
        list.setAdapter(new SimpleContactsCursorAdapter(this,cursor));
    }
}
