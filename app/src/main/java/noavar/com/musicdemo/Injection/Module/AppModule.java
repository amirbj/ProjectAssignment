package noavar.com.musicdemo.Injection.Module;

import android.arch.lifecycle.ViewModelProvider;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import noavar.com.musicdemo.Injection.Component.ViewModelSubComponent;
import noavar.com.musicdemo.Injection.ViewModelFactory;
import noavar.com.musicdemo.Repository.Remote.IService;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.google.gson.internal.$Gson$Types.arrayOf;

/**
 * Created by amir on 12/15/18.
 */
@Module(subcomponents = ViewModelSubComponent.class)
public class AppModule {



    @Singleton
    @Provides
    public Retrofit provideRetrofit(){
        return new Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    @Singleton
    @Provides
    public IService provideRegistrationApi(Retrofit retrofit) {
        return retrofit.create(IService.class);
    }


    @Singleton
    @Provides
    public ViewModelProvider.Factory provideViewModelFactory(ViewModelSubComponent.Builder viewModelSubComponent) {
        return viewModelSubComponent.build();
    }


  /*  @Singleton
    @Provides
    public RegistrationManager provideRegistrationManager( RegistrationRepository registrationRepository) {
        return RegistrationManagerImpl(registrationRepository);
    }*/
}
