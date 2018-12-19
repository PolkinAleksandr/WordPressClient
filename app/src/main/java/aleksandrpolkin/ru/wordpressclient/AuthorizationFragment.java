package aleksandrpolkin.ru.wordpressclient;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import aleksandrpolkin.ru.wordpressclient.myinterface.OnMyClick;

public class AuthorizationFragment extends Fragment {

    static final String FRAGMENT_AUTH = "fragment_auth";

    public static AuthorizationFragment createInstance() {
        return new AuthorizationFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.screen_autorization, container, false);
        Button logIn = v.findViewById(R.id.button_sign_in);
        Button logOut = v.findViewById(R.id.button_sign_out);

        final OnMyClick onMyClick = (OnMyClick) getContext();

        logIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onMyClick.setOnMyClick(LoginFragment.FRAGMENT_LOGIN);
            }
        });

        return v;
    }
}
