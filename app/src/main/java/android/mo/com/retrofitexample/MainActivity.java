package android.mo.com.retrofitexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private Button quoteGenerateButton;
    private TextView quoteText;
    private TextView quoteAuthor;

    private final String url = "http://quotes.stormconsultancy.co.uk";
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // setup views
        quoteGenerateButton = findViewById(R.id._generate_Quote);
        quoteText = findViewById(R.id._quote);
        quoteAuthor = findViewById(R.id._author);

        Retrofit retrofit = new Retrofit.Builder().baseUrl(url).addConverterFactory(GsonConverterFactory.create()).build();

        final QuoteApi api = retrofit.create(QuoteApi.class);

        quoteGenerateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // retrofit builder
                fetchData(api.getRandomQuote());
            }
        });




    }

    private void fetchData(Call<QuoteData> call) {
        call.enqueue(new Callback<QuoteData>() {
            @Override
            public void onResponse(Call<QuoteData> call, Response<QuoteData> response) {
                setFields(response.body());
                Log.d(TAG, "onResponse: Success");
            }

            @Override
            public void onFailure(Call<QuoteData> call, Throwable t) {
                Toast.makeText(getApplicationContext(),"Unable to Find Quote",Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void setFields(QuoteData data){
        quoteAuthor.setText(data.getAuthor());
        quoteText.setText(data.getQuote());
    }
}
