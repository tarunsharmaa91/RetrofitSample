package store.emaratech.ae.myapplication;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
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

    //We are send Posts as data and getting same in return in below api
    @POST("posts")
    Call<Posts> createPost(@Body Posts post);

    @FormUrlEncoded
    @POST("posts")
    Call<Posts> createPostUsingForm(
      @Field("userId") int userId,
      @Field("title") String title,
      @Field("body") String text
    );

    // or we can do this way as well, below is just demo and return exception

    @FormUrlEncoded
    @POST("posts/{id}/comments")
    Call<Posts> createPostUsingFormMap(
      @FieldMap Map<String, String> fields,
      // we can also pass array this way in it
      @Field("array") List<String> array,
      @Path("id") int ID
    );

    @PUT("posts/{id}")
    Call<Posts> updatePostData(
            @Path("id") int ID, @Body Posts post
    );

}
