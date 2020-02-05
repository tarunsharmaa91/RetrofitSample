package store.emaratech.ae.myapplication;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;

/**
 * Created By Tarun
 */
public interface JsonPlaceHolder {

    @GET("posts")
    Call<List<Posts>> getPost();

    @GET("posts/{id}/comments")
    Call<List<Comments>> getComments(@Path("id") int postId);

    //Query will add "?postId=1" to url
    @GET("comments")
    Call<List<Comments>> getCommentsQuery(@Query("id") int postId);

    //Using below technique url will be like
    // comments?id=1&_sort=id&_order=desc
    @GET("comments")
    Call<List<Comments>> getCommentsQueryWithMultipleParameters(
            //@Query("id") Integer postId,
            @Query("_sort") String sortBy,
            @Query("_order") String orderBy,
            @Query("id") Integer... posts
    );

    //Use of query map
    @GET("comments")
    Call<List<Comments>> getCommentsQueryWithMultipleParametersWithQueryMap(
            @QueryMap Map<String, String> parameters
    );

    // Here we can pass simple Url like or we can use base url alongside and that will replace base url
    // post/3/comments
    @GET("comments")
    Call<List<Comments>> getCommentsUsingURL(@Url String url);
}
