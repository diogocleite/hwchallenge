import Objects.FileGist;
import Objects.Gist;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;

public interface GistInterface {

        String USER ="";
        String PRETOKEN = "token ";
        String TOKEN = PRETOKEN + "";

        //List public gists for a user
        @GET("/users/{user}/gists")
        Call<List<Gist>> listUserPublicGists(@Path("user") String user);

        //List user gists
        @GET("/gists")
        Call<List<Gist>> listUserGists(@Header("Authorization") String token);

        //List a specific gist
        @GET("/gists/{id}")
        Call<Gist> listGist(@Header("Authorization") String token, @Path("id") String id);

        //Create a gist
        @POST("/gists")
        Call<Gist> creatGist(@Header("Authorization") String token,@Body FileGist files);

        //Delete a gist
        @DELETE("/gists/{id}")
        Call<ResponseBody> deleteGist(@Header("Authorization") String token, @Path("id") String id);

}
