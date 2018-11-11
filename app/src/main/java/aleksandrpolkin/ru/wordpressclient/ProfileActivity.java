package aleksandrpolkin.ru.wordpressclient;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;

public class ProfileActivity extends AppCompatActivity {

    TextInputEditText name, second, about, login;

    public static Intent createNewIntent(Context context) {
        return new Intent(context, ProfileActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.screen_profile);

        getSupportActionBar().setTitle(getResources().getString(R.string.text_tittle_profile));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        name = findViewById(R.id.text_profile_name);
        second = findViewById(R.id.text_profile_second);
        about = findViewById(R.id.text_profile_about);
        login = findViewById(R.id.text_profile_login);

        name.setText(getResources().getString(R.string.text_profile_name));
        second.setText(getResources().getString(R.string.text_profile_second));
        login.setText(getResources().getString(R.string.text_profile_login));
        about.setText(getResources().getString(R.string.text_profile_about));
    }
}