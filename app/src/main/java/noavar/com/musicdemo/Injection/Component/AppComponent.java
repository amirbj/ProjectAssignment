package noavar.com.musicdemo.Injection.Component;

/**
 * Created by amir on 12/15/18.
 */


import android.app.Application;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;
import dagger.android.support.AndroidSupportInjectionModule;
import noavar.com.musicdemo.Injection.Module.ActivityBuilder;
import noavar.com.musicdemo.Injection.Module.AppModule;
import noavar.com.musicdemo.Injection.MusicDemo;

@Singleton
@Component(modules = {
        AndroidInjectionModule.class,
        AndroidSupportInjectionModule.class,
        AppModule.class,
        ActivityBuilder.class})
public interface AppComponent {
    @Component.Builder
   public  interface Builder {
        @BindsInstance
        public Builder application(Application application);

       // public Builder sharedPreferencesModule(SharedPreferencesModule sharedPreferencesModule);

        public  AppComponent build();
    }

     void inject(MusicDemo application);
}

