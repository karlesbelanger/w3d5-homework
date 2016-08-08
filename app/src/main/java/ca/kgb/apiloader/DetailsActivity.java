package ca.kgb.apiloader;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {

    private TextView mTextview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        RelatedTopic character = getIntent().getExtras().getParcelable("keyvalue");
        mTextview = (TextView) findViewById(R.id.infobox_text);
        mTextview.setText(character.text);
    }
}