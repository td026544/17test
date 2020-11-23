
import com.dss.a17test.model.UserSearchResult
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.*

interface MyApi {


//
//    @GET("DevTides/DogsApi/master/dogs.json")
//    fun getDogs(): Call<List<TestModel>>




    @GET("/search/users")
    fun getTestApi(@QueryMap options: HashMap<String, String>?):Call<UserSearchResult>





}