package aleksandrpolkin.ru.wordpressclient;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import aleksandrpolkin.ru.wordpressclient.myinterface.CallbackFragment;

public class AuthorizationFragment extends Fragment {

    static final String FRAGMENT_AUTH = "fragment_auth";

    public static AuthorizationFragment createInstance() {
        return new AuthorizationFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.screen_autorization, container, false);
        Button logIn = view.findViewById(R.id.button_sign_in);
        Button logOut = view.findViewById(R.id.button_sign_out);

        final CallbackFragment callbackFragment = (CallbackFragment) getContext();

        logIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callbackFragment.setCallbackFragment(LoginFragment.FRAGMENT_LOGIN);
            }
        });

        return view;
    }
}
