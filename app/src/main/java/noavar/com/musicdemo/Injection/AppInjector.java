package noavar.com.musicdemo.Injection;

import android.app.Application;
import android.support.v4.app.FragmentManager;

import dagger.android.AndroidInjection;

/**
 * Created by amir on 12/16/18.
 */

class AppInjector{
Application application;
          public AppInjector(MusicDemo application){
              {


        DaggerAppComponent.builder().application(application)
        .build().inject(application);

        application
        .registerActivityLifecycleCallbacks( Application.ActivityLifecycleCallbacks {
                  override fun onActivityPaused(p0:Activity ?){

                  }

              }

private void handleActivity(activity) {
              if (HasSupportFragmentInjector) {
                  AndroidInjection.inject(activity)

              }
          }
          }