package noavar.com.musicdemo.ViewModel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.MutableLiveData;
import android.content.ClipData;
import android.support.annotation.NonNull;
import android.util.Log;
import android.widget.SearchView;


import com.google.common.eventbus.Subscribe;
import com.google.common.util.concurrent.AbstractScheduledService;
import com.jakewharton.rxbinding2.widget.RxSearchView;

import org.reactivestreams.Subscriber;


import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.Subject;
import noavar.com.musicdemo.Repository.Remote.IService;


/**
 * Created by amir on 12/16/18.
 */

public class ListViewModel extends AndroidViewModel {
    private IService mService;
    private CompositeDisposable mSubscription;
   // private MutableLiveData<>

    @Inject
    public ListViewModel(@NonNull Application application, IService service) {
        super(application);
        this.mService = service;
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        mSubscription.clear();
    }


    public void search(String query, SearchView searchView){

        RxSearchView.queryTextChanges(searchView)
                .debounce(400, TimeUnit.MILLISECONDS)
                .subscribeOn(AndroidSchedulers.mainThread())
                .observeOn(Schedulers.io())
                .map(CharSequence::chars)
                .switchMap(q -> mService.downloadFile(q.toString()))
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer() {
                    @Override
                    public void onSubscribe(@io.reactivex.annotations.NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@io.reactivex.annotations.NonNull Object o) {

                    }

                    @Override
                    public void onError(@io.reactivex.annotations.NonNull Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    public void getList(String name){

        mService.downloadFile(name).subscribeOn(AndroidSchedulers.mainThread()).
                observeOn(Schedulers.io()).subscribe(new Observer() {
            @Override
            public void onSubscribe(@io.reactivex.annotations.NonNull Disposable d) {
                mSubscription.add(d);
            }

            @Override
            public void onNext(@io.reactivex.annotations.NonNull Object o) {

            }

            @Override
            public void onError(@io.reactivex.annotations.NonNull Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });

    }

}
