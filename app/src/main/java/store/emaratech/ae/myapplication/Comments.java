package store.emaratech.ae.myapplication;

import com.google.gson.annotations.SerializedName;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Created By Tarun
 */
@Data
@AllArgsConstructor
public class Comments {

    private int postId;
    private int userId;
    private int id;
    private String title;
    @SerializedName("body")
    private String textToDisplay;
}
