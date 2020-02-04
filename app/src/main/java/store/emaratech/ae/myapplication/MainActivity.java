package store.emaratech.ae.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        JsonPlaceHolder jsonPlaceHolder = retrofit.create(JsonPlaceHolder.class);
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
}
