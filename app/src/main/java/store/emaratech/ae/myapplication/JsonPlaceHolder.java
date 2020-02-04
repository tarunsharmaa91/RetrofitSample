package store.emaratech.ae.myapplication;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created By Tarun
 */
public interface JsonPlaceHolder {

    @GET("posts")
    Call<List<Posts>> getPost();
}
