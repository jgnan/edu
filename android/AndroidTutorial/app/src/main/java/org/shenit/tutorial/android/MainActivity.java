package org.shenit.tutorial.android;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import org.shenit.tutorial.android.anim.AnimationExamplesActivity;
import org.shenit.tutorial.android.asynccall.AsyncCallExamplesActivity;
import org.shenit.tutorial.android.broadcast.BroadcastReceiverExamplesActivity;
import org.shenit.tutorial.android.customization.CustomizationExamplesActivity;
import org.shenit.tutorial.android.dataproc.DataProcessExamplesActivity;
import org.shenit.tutorial.android.dataprovider.DataProviderExamplesActivity;
import org.shenit.tutorial.android.drawable.DrawableMainActivity;
import org.shenit.tutorial.android.fixscreen.FixScreenExamplesActivity;
import org.shenit.tutorial.android.fragment.FragmentExamplesActivity;
import org.shenit.tutorial.android.list.ListExamplesActivity;
import org.shenit.tutorial.android.menu.MenuExamplesActivity;
import org.shenit.tutorial.android.notification.NotificationExamplesActivity;
import org.shenit.tutorial.android.pager.PagerExamplesActivity;
import org.shenit.tutorial.android.recyclerview.RecyclerViewExamplesActivity;
import org.shenit.tutorial.android.search.SearchExamplesActivity;
import org.shenit.tutorial.android.serialization.SerializationExamplesActivity;
import org.shenit.tutorial.android.services.ServiceExamplesActivity;
import org.shenit.tutorial.android.webview.WebViewExamplesActivity;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TutorialUtils.bind(this, R.id.interact_example_link, InteractExampleActivity.class);
        TutorialUtils.bind(this, R.id.fragment_examples_link, FragmentExamplesActivity.class);
        TutorialUtils.bind(this, R.id.list_examples_link, ListExamplesActivity.class);
        TutorialUtils.bind(this, R.id.drawable_examples_link, DrawableMainActivity.class);
        TutorialUtils.bind(this, R.id.async_call_examples_link, AsyncCallExamplesActivity.class);
        TutorialUtils.bind(this, R.id.act_life_cycle_example_link, ActivityLifeCycleExampleActivity.class);
        TutorialUtils.bind(this, R.id.serialization_examples_link, SerializationExamplesActivity.class);
        TutorialUtils.bind(this, R.id.data_process_examples_link, DataProcessExamplesActivity.class);
        TutorialUtils.bind(this, R.id.menu_examples_link, MenuExamplesActivity.class);
        TutorialUtils.bind(this, R.id.data_provider_examples_link, DataProviderExamplesActivity.class);
        TutorialUtils.bind(this, R.id.pager_examples_link, PagerExamplesActivity.class);
        TutorialUtils.bind(this, R.id.return_result_example_link, ReturnResultActivity.class);
        TutorialUtils.bind(this, R.id.recycler_view_examples_link, RecyclerViewExamplesActivity.class);
        TutorialUtils.bind(this, R.id.search_examples_link, SearchExamplesActivity.class);
        TutorialUtils.bind(this, R.id.service_examples_link, ServiceExamplesActivity.class);
        TutorialUtils.bind(this, R.id.broadcast_receiver_examples_link, BroadcastReceiverExamplesActivity.class);
        TutorialUtils.bind(this, R.id.notification_examples_link, NotificationExamplesActivity.class);
        TutorialUtils.bind(this,R.id.customization_examples_link, CustomizationExamplesActivity.class);
        TutorialUtils.bind(this,R.id.fix_multi_screen_examples_link, FixScreenExamplesActivity.class);
        TutorialUtils.bind(this,R.id.webview_examples_link, WebViewExamplesActivity.class);
        TutorialUtils.bind(this,R.id.animation_example_link, AnimationExamplesActivity.class);
    }
}
