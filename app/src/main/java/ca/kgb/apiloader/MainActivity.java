package ca.kgb.apiloader;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    private static final String APIURL = "https://api.duckduckgo.com/?q=simpsons+characters&format=json";
    private static final String TAG = MainActivity.class.getSimpleName() + "TAG_";

    private Result simpson;
    private ListView mListview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mListview = (ListView) findViewById(R.id.a_main_listview);
        getInfo();
    }

    private void getInfo() {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(APIURL)
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String json = response.body().string();
                Gson gson = new GsonBuilder().create();
                simpson = gson.fromJson(json, Result.class);
                loadList(simpson);
            }
        });
    }

    private void loadList(final Result results) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                List arr = new ArrayList<String>();
                for(RelatedTopic character : results.relatedTopics){
                    String[] name = character.text.split("-");
                    Log.d(TAG, "doGsonPojo: " + name[0].trim());
                    arr.add(name[0].trim());
                }

                final ArrayAdapter adapter = new ArrayAdapter<String>(getApplicationContext(),R.layout.list_item,R.id.text_item, arr);
                mListview.setAdapter(adapter);

                mListview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        Log.d(TAG, "onItemClick: " + adapter.getItem(i));
                        Intent intent = new Intent(getApplication(), DetailsActivity.class);
                        RelatedTopic character = results.relatedTopics.get(i);
                        intent.putExtra("keyvalue", character);
                        startActivity(intent);
                    }
                });
            }
        });
    }
}