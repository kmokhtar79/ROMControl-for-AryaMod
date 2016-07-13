package com.aryamod.romcontrol;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceFragment;
import android.provider.Settings;

import java.io.FileNotFoundException;
import java.io.InputStream;


public class NotiPanelFragment extends PreferenceFragment {
    HandlePreferenceFragments hpf;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        hpf = new HandlePreferenceFragments(getActivity(), this, "noti_panel_prefs");
    }

    @Override
    public void onResume() {
        super.onResume();
        hpf.onResumeFragment();
    }

    @Override
    public void onPause() {
        super.onPause();
        hpf.onPauseFragment();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(resultCode != Activity.RESULT_OK) {
            return;
        }
        switch (requestCode) {
            case 46:
                String key = "notification_panel_bg";
                Uri uri = data.getData();
                Settings.System.putString(getActivity().getContentResolver(), key, uri.toString());
                try {
                    InputStream inputStream = getActivity().getContentResolver().openInputStream(uri);
                    Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
                    Drawable icon = new BitmapDrawable(getActivity().getResources(), bitmap);
                    findPreference(key).setIcon(icon);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                break;
            default:
                super.onActivityResult(requestCode, resultCode, data);
        }

    }
}