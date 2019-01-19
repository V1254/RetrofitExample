package android.mo.com.retrofitexample;

import retrofit2.Call;
import retrofit2.http.GET;

public interface QuoteApi {
    @GET("/random.json/")
    Call<QuoteData> getRandomQuote();
}
