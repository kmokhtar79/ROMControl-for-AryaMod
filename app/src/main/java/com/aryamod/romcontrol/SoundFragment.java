package com.aryamod.romcontrol;

import android.os.Bundle;
import android.preference.PreferenceFragment;


public class SoundFragment extends PreferenceFragment {
    HandlePreferenceFragments hpf;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        hpf = new HandlePreferenceFragments(getActivity(), this, "sound_prefs");
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


}
