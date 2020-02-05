package store.emaratech.ae.myapplication;

import com.google.gson.annotations.SerializedName;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

/**
 * Created By Tarun
 */
@Data
@AllArgsConstructor
class Posts {

    private int userId;
    //We made below data type Integer so when we send this data in post
    //method, id will be set as null automatically and ignored by GSON
    private Integer id;
    private String title;
    @SerializedName("body")
    private String textToDisplay;

}
