package mytest.xigmapro.com.shimmereffect;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

import com.facebook.shimmer.ShimmerFrameLayout;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    private ShimmerFrameLayout mShimmerViewContainer;
    private ListView playlistDataLV;
    private Adapter adapter;
    private Handler handler;
    private List<ShopDetails> shopDetails1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mShimmerViewContainer = findViewById(R.id.shimmer_view_container);
        playlistDataLV = (ListView)findViewById(R.id.playlistDataLV);
        handler = new Handler();

        // I am using Retrofit Client for fetching data from an API.
        // API Call Using Retrofit Client
        String userId = "XXXX";
       // Retrofit retrofit = RetrofitClient.getClient();
        //getPlaylists(userId, retrofit);

        ShopDetails shopDetails = new ShopDetails();

        for (int i=0; i<6; i++){
            shopDetails1 = new ArrayList<>();
            shopDetails.setId(1);
            shopDetails.setName("promo");
            shopDetails.setImage(R.drawable.food_img);

            shopDetails1.add(shopDetails);
        }

        Log.i("aaa", shopDetails1.get(0).getName());



        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                adapter = new Adapter(MainActivity.this, R.layout.item_row, shopDetails1);
                playlistDataLV.setAdapter(adapter);
                mShimmerViewContainer.stopShimmerAnimation();
                mShimmerViewContainer.setVisibility(View.GONE);
            }
        }, 5000);

    }

    private void getPlaylists(String userId, Retrofit retrofit) {
/*
        ApiServices apiServices = retrofit.create(ApiServices.class);
        Call<List<Playlist>> accountPlaylists = apiServices.getAccountPlaylists(userId);

        accountPlaylists.enqueue(new Callback<List<Playlist>>() {
            @Override
            public void onResponse(Call<List<Playlist>> call, Response<List<Playlist>> response) {
                if (response.isSuccessful()) {
                    if (response.code() == 200) {

                        //TODO: Set data in ListView

                    }
                    // Stopping Shimmer Effect's animation after data is loaded to ListView
                    mShimmerViewContainer.stopShimmerAnimation();
                    mShimmerViewContainer.setVisibility(View.GONE);
                }
            }

            @Override
            public void onFailure(Call<List<Playlist>> call, Throwable t) {
                Log.e("TAG", "=======onFailure: " + t.toString());
                t.printStackTrace();
            }
        });*/
    }

    @Override
    public void onResume() {
        super.onResume();
        mShimmerViewContainer.startShimmerAnimation();
    }

    @Override
    protected void onPause() {
        mShimmerViewContainer.stopShimmerAnimation();
        super.onPause();
    }
}
