package store.emaratech.ae.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Query;

public class MainActivity extends AppCompatActivity {

    private JsonPlaceHolder jsonPlaceHolder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        jsonPlaceHolder = retrofit.create(JsonPlaceHolder.class);
        //Normal Use of Get method
        //getPosts();

        //Get method with additional parameter
        //getComments();

        //Use of Single Query
        //getCommentsWithQuery();

        //Use of Multiple Query
        //getCommentsWithMultipleQuery();

        //Above thing we can achieve using QueryMap as well
        //getCommentsWithMultipleQueryUsingQueryMap();


        // POST METHOD

        //Normal post method
        //createPost();

        //Post Using Url Encoded
        //createPostUsingUrlEncoded();

        //Post Using Url Encoded
        //createPostUsingUrlEncodedMix();

        //Put Method
        updateDataUsingPut();

    }



    private void getCommentsWithMultipleQueryUsingQueryMap() {
        Map<String, String> hashMap = new HashMap<>();
        hashMap.put("_sort","id");
        hashMap.put("_order","desc");
        hashMap.put("id","1");

        Call<List<Comments>> call = jsonPlaceHolder.getCommentsQueryWithMultipleParametersWithQueryMap(hashMap);
        call.enqueue(new Callback<List<Comments>>() {
            @Override
            public void onResponse(@NotNull Call<List<Comments>> call, @NotNull Response<List<Comments>> response) {

                if(response.isSuccessful())
                {
                    List<Comments> comments = response.body();
                    assert comments != null;
                    for(Comments comment : comments)
                    {
                        Log.e("Response : ", String.valueOf(comment.getId()));
                    }
                    Toast.makeText(MainActivity.this, "Success" , Toast.LENGTH_LONG).show();
                }else
                {
                    Toast.makeText(MainActivity.this, response.code() , Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(@NotNull Call<List<Comments>> call, @NotNull Throwable t) {
                Toast.makeText(MainActivity.this, "Fail" , Toast.LENGTH_LONG).show();
            }
        });
    }

    private void getCommentsWithMultipleQuery() {
        // We can also pass null in place of id or desc

        //or

        //We can pass array as well
        // new Integer[]{1,2,3}
        //Call<List<Comments>> call = jsonPlaceHolder.getCommentsQueryWithMultipleParameters(4, "id", "desc",new Integer[]{1,2,3});

        Call<List<Comments>> call = jsonPlaceHolder.getCommentsQueryWithMultipleParameters( "id", "desc",new Integer[]{1,2,3});
        call.enqueue(new Callback<List<Comments>>() {
            @Override
            public void onResponse(@NotNull Call<List<Comments>> call, @NotNull Response<List<Comments>> response) {

                if(response.isSuccessful())
                {
                    List<Comments> comments = response.body();
                    assert comments != null;
                    for(Comments comment : comments)
                    {
                        Log.e("Response : ", String.valueOf(comment.getId()));
                    }
                    Toast.makeText(MainActivity.this, "Success" , Toast.LENGTH_LONG).show();
                }else
                {
                    Toast.makeText(MainActivity.this, response.code() , Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(@NotNull Call<List<Comments>> call, @NotNull Throwable t) {
                Toast.makeText(MainActivity.this, "Fail" , Toast.LENGTH_LONG).show();
            }
        });
    }

    private void getCommentsWithQuery() {
        Call<List<Comments>> call = jsonPlaceHolder.getCommentsQuery(3);
        call.enqueue(new Callback<List<Comments>>() {
            @Override
            public void onResponse(@NotNull Call<List<Comments>> call, @NotNull Response<List<Comments>> response) {

                if(response.isSuccessful())
                {
                    List<Comments> comments = response.body();
                    assert comments != null;
                    for(Comments comment : comments)
                    {
                        Log.e("Response : ", String.valueOf(comment.getPostId()));
                    }
                    Toast.makeText(MainActivity.this, "Success" , Toast.LENGTH_LONG).show();
                }else
                {
                    Toast.makeText(MainActivity.this, response.code() , Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(@NotNull Call<List<Comments>> call, @NotNull Throwable t) {
                Toast.makeText(MainActivity.this, "Fail" , Toast.LENGTH_LONG).show();
            }
        });
    }

    private void getComments() {
        Call<List<Comments>> call = jsonPlaceHolder.getComments(3);
        call.enqueue(new Callback<List<Comments>>() {
            @Override
            public void onResponse(@NotNull Call<List<Comments>> call, @NotNull Response<List<Comments>> response) {

                if(response.isSuccessful())
                {
                    List<Comments> comments = response.body();
                    assert comments != null;
                    for(Comments comment : comments)
                    {
                        Log.e("Response : ", String.valueOf(comment.getPostId()));
                    }
                    Toast.makeText(MainActivity.this, "Success" , Toast.LENGTH_LONG).show();
                }else
                {
                    Toast.makeText(MainActivity.this, response.code() , Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(@NotNull Call<List<Comments>> call, @NotNull Throwable t) {
                Toast.makeText(MainActivity.this, "Fail" , Toast.LENGTH_LONG).show();
            }
        });
    }

    private void getPosts() {
        Call<List<Posts>> call = jsonPlaceHolder.getPost();
        call.enqueue(new Callback<List<Posts>>() {
            @Override
            public void onResponse(@NotNull Call<List<Posts>> call, @NotNull Response<List<Posts>> response) {

                if(response.isSuccessful())
                {
                    List<Posts> posts = response.body();
                    assert posts != null;
                    for(Posts post : posts)
                    {
                        Log.e("Response : ", post.getTitle());
                    }
                    Toast.makeText(MainActivity.this, "Success" , Toast.LENGTH_LONG).show();
                }else
                {
                    Toast.makeText(MainActivity.this, response.code() , Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(@NotNull Call<List<Posts>> call, @NotNull Throwable t) {
                Toast.makeText(MainActivity.this, "Fail" , Toast.LENGTH_LONG).show();
            }
        });
    }

    private void createPost() {

        Posts post = new Posts(1, null, "titleName", "textToDisplay");
        Call<Posts> call = jsonPlaceHolder.createPost(post);
        call.enqueue(new Callback<Posts>() {
            @Override
            public void onResponse(Call<Posts> call, Response<Posts> response) {

                if(!response.isSuccessful())
                {
                    return;
                }
                Posts res = response.body();
                Toast.makeText(MainActivity.this, String.valueOf(res), Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<Posts> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Fail" , Toast.LENGTH_LONG).show();
            }
        });
    }

    private void createPostUsingUrlEncoded() {

        Call<Posts> call = jsonPlaceHolder.createPostUsingForm(1,  "titleName", "textToDisplay");
        call.enqueue(new Callback<Posts>() {
            @Override
            public void onResponse(Call<Posts> call, Response<Posts> response) {

                if(!response.isSuccessful())
                {
                    return;
                }
                Posts res = response.body();
                Toast.makeText(MainActivity.this, String.valueOf(res), Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<Posts> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Fail" , Toast.LENGTH_LONG).show();
            }
        });
    }

    private void createPostUsingUrlEncodedMix() {

        // This is just for representation that this way we can pass data as well and  its result will be fail

        Map<String, String> map = new HashMap<>();
        map.put("id","1");

        List<String> list = new ArrayList<>();
        list.add("value");

        Call<Posts> call = jsonPlaceHolder.createPostUsingFormMap(map, list, 1);
        call.enqueue(new Callback<Posts>() {
            @Override
            public void onResponse(Call<Posts> call, Response<Posts> response) {

                if(!response.isSuccessful())
                {
                    return;
                }
                Posts res = response.body();
                Toast.makeText(MainActivity.this, String.valueOf(res), Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<Posts> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Fail" , Toast.LENGTH_LONG).show();
            }
        });
    }

    private void updateDataUsingPut() {
        Posts post = new Posts(1, null, "titleName", "textToDisplay");
        Call<Posts> call = jsonPlaceHolder.updatePostData(1,post);
        call.enqueue(new Callback<Posts>() {
            @Override
            public void onResponse(@NotNull Call<Posts> call, @NotNull Response<Posts> response) {
                if(!response.isSuccessful())
                {
                    return;
                }
                Posts res = response.body();
                Toast.makeText(MainActivity.this, String.valueOf(res), Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(@NotNull Call<Posts> call, @NotNull Throwable t) {
                Toast.makeText(MainActivity.this, "Fail" , Toast.LENGTH_LONG).show();
            }
        });

    }
}
