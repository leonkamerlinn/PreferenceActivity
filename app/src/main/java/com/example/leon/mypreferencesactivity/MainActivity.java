package com.example.leon.mypreferencesactivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);


        String index = sharedPreferences.getString(getString(R.string.key_upload_quality), "null");
        String[] uploads = getResources().getStringArray(R.array.pref_upload_quality_entries);
        System.out.println(uploads[Integer.valueOf(index)]);

        Boolean aBoolean = sharedPreferences.getBoolean(getString(R.string.notifications_new_message), false);
        System.out.println(aBoolean);

        String videos = sharedPreferences.getString(getString(R.string.key_gallery_name), "null");
        System.out.println(videos);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            // launch settings activity
            startActivity(new Intent(MainActivity.this, SettingsActivity.class));
            return true;
        }

        if (id == R.id.action_settings_headers) {
            // launch settings activity
            startActivity(new Intent(MainActivity.this, SettingsHeadersActivity.class));
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
