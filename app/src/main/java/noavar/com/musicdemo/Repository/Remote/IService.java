package noavar.com.musicdemo.Repository.Remote;


import java.io.File;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by amir on 12/15/18.
 */

public interface IService {

    @GET("/search")
    Observable downloadFile(@Path("term") String term);
}
