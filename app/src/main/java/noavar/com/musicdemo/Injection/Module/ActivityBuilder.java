package noavar.com.musicdemo.Injection.Module;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import noavar.com.musicdemo.View.MainActivity;

import static com.google.gson.internal.$Gson$Types.arrayOf;

/**
 * Created by amir on 12/15/18.
 */

@Module
public abstract class ActivityBuilder {
    @ContributesAndroidInjector(modules =MainActivity.class )
     public abstract  MainActivity contributeMainActivity();
}
