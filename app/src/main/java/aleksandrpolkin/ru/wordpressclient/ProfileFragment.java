package aleksandrpolkin.ru.wordpressclient;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class ProfileFragment extends Fragment {

    static final String FRAGMENT_PROFILE = "screen_fragment_profile";

    public static ProfileFragment createInstance() {
        return new ProfileFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.screen_fragment_profile, container, false);

        TextInputEditText name = view.findViewById(R.id.text_profile_name);
        TextInputEditText second = view.findViewById(R.id.text_profile_second);
        TextInputEditText about = view.findViewById(R.id.text_profile_about);
        TextInputEditText login = view.findViewById(R.id.text_profile_login);

        name.setText(getResources().getString(R.string.text_profile_name));
        second.setText(getResources().getString(R.string.text_profile_second));
        login.setText(getResources().getString(R.string.text_profile_login));
        about.setText(getResources().getString(R.string.text_profile_about));
        return view;
    }
}
