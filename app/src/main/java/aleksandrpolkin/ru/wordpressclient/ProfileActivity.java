package aleksandrpolkin.ru.wordpressclient;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;

public class ProfileActivity extends AppCompatActivity {

    public static Intent createNewIntent(Context context) {
        return new Intent(context, ProfileActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.screen_profile);

        getSupportActionBar().setTitle(getResources().getString(R.string.text_tittle_profile));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        TextInputEditText name = findViewById(R.id.text_profile_name);
        TextInputEditText second = findViewById(R.id.text_profile_second);
        TextInputEditText about = findViewById(R.id.text_profile_about);
        TextInputEditText login = findViewById(R.id.text_profile_login);

        name.setText(getResources().getString(R.string.text_profile_name));
        second.setText(getResources().getString(R.string.text_profile_second));
        login.setText(getResources().getString(R.string.text_profile_login));
        about.setText(getResources().getString(R.string.text_profile_about));
    }
}
