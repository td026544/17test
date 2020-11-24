
import com.dss.a17test.model.UserSearchResult
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.*

interface MyApi {





    @GET("/search/users")
    fun getTestApi(@Query("q") name: String,@Query("page") page: Int):Call<UserSearchResult>





}