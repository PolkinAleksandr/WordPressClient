package aleksandrpolkin.ru.wordpressclient;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import aleksandrpolkin.ru.wordpressclient.myinterface.CallbackAuthorization;
import aleksandrpolkin.ru.wordpressclient.myinterface.CallbackFragment;

public class LoginActivity extends AppCompatActivity implements CallbackFragment, CallbackAuthorization {

    private FragmentTransaction fragmentTransaction;
    private SharedPreferences pref;

    public static Intent createNewIntent(Context context){
        return new Intent(context, LoginActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.screen_login);

        AuthorizationFragment authorizationFragment = AuthorizationFragment.createInstance();
        fragmentTransaction = getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, authorizationFragment, AuthorizationFragment.FRAGMENT_AUTH);
        fragmentTransaction.commit();
        pref = AppController.getPreference(this);
    }


    @Override
    public void setCallbackFragment(String tag) {
        switch (tag){
            case LoginFragment.FRAGMENT_LOGIN:
                LoginFragment loginFragment = LoginFragment.createInstance();
                openFragment(loginFragment, LoginFragment.FRAGMENT_LOGIN);
                break;
            case AuthorizationFragment.FRAGMENT_AUTH:
                AuthorizationFragment authorizationFragment = AuthorizationFragment.createInstance();
                openFragment(authorizationFragment, AuthorizationFragment.FRAGMENT_AUTH);
                break;
        }
    }

    @Override
    public void setCallbackAuthorization(String uri) {
        int indexStart = uri.indexOf(AppController.FIND_TOKEN) + AppController.FIND_TOKEN.length();
        int indexFinish = uri.indexOf(AppController.SEPARATION);
        String token = uri.substring(indexStart, indexFinish);
        pref = AppController.getPreference(this);
        pref.edit().putString(AppController.EXTRA_TOKEN, token).apply();
        CallbackFragment callbackFragment = this;
        callbackFragment.setCallbackFragment(AuthorizationFragment.FRAGMENT_AUTH);
        startActivity(WordPressActivity.createNewIntent(this));
    }

    @Override
    protected void onStart() {
        super.onStart();
        String token = pref.getString(AppController.EXTRA_TOKEN, AppController.EXTRA_ERROR);
        if (!token.equals(AppController.EXTRA_ERROR)){
            startActivity(WordPressActivity.createNewIntent(this));
        }
    }

    private void openFragment(Fragment fragment, String tag){
        fragmentTransaction = getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, fragment, tag);
        fragmentTransaction.commit();
    }
}
