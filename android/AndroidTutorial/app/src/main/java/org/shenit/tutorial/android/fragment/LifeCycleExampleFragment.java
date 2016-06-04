package org.shenit.tutorial.android.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.shenit.tutorial.android.R;

/**
 * Life cycle example for fragment
 */
public class LifeCycleExampleFragment extends Fragment {
    public LifeCycleExampleFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("FLifeCycle", ">>>>> onCreate event...");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d("FLifeCycle", ">>>>> onStart event...");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d("FLifeCycle", ">>>>> onResume event...");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d("FLifeCycle", ">>>>> onPause event...");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d("FLifeCycle", ">>>>> onStop event...");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d("FLifeCycle", ">>>>> onDestroyView event...");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("FLifeCycle", ">>>>> onDestroy event...");
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.d("FLifeCycle", ">>>>> onActivityCreated event...");
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.d("FLifeCycle", ">>>>> onViewCreated event...");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        Log.d("FLifeCycle", ">>>>> onCreateView event...");
        return inflater.inflate(R.layout.fragment_fragment_life_cycle_example, container, false);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.d("FLifeCycle", ">>>>> onAttach event...");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.d("FLifeCycle", ">>>>> onDetach event...");
    }
}
