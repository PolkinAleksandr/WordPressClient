package aleksandrpolkin.ru.wordpressclient;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import aleksandrpolkin.ru.wordpressclient.myinterface.OnMyClick;

public class LoginActivity extends AppCompatActivity implements OnMyClick {

    private FragmentTransaction fragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.screen_login);

        AuthorizationFragment authorizationFragment = AuthorizationFragment.createInstance();
        fragmentTransaction = getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, authorizationFragment, AuthorizationFragment.FRAGMENT_AUTH);
        fragmentTransaction.commit();
    }


    @Override
    public void setOnMyClick(String tag) {
        LoginFragment loginFragment = LoginFragment.createInstance();
        fragmentTransaction = getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, loginFragment, tag);
        fragmentTransaction.commit();
    }
}
