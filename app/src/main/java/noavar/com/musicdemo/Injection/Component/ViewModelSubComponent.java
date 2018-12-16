package noavar.com.musicdemo.Injection.Component;

import android.arch.lifecycle.ViewModelProvider;

import dagger.Subcomponent;
import noavar.com.musicdemo.Injection.ViewModelFactory;
import noavar.com.musicdemo.ViewModel.ListViewModel;

/**
 * Created by amir on 12/15/18.
 */

@Subcomponent
public interface ViewModelSubComponent {
    @Subcomponent.Builder
   public  interface Builder {
        public ViewModelSubComponent build();
    }

    public  ListViewModel listViewModel();

}
