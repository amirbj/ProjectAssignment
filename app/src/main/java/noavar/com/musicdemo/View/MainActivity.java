package noavar.com.musicdemo.View;

import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.ViewModelProviders;
import android.content.ClipData;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;

import java.util.concurrent.TimeUnit;

import dagger.android.AndroidInjection;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import noavar.com.musicdemo.Injection.ViewModelFactory;
import noavar.com.musicdemo.R;
import noavar.com.musicdemo.ViewModel.ListViewModel;

public class MainActivity extends AppCompatActivity {

    private ListViewModel mViewModel;
    private SearchView mSearchView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        configureDagger();
     mViewModel= ViewModelProviders.of(this)
             .get(ListViewModel.class);

     mSearchView = (SearchView) findViewById(R.id.search_view);



    }
    private void configureDagger(){
        AndroidInjection.inject(this);
    }



}
