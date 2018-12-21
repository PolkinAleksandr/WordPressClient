package aleksandrpolkin.ru.wordpressclient;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import aleksandrpolkin.ru.wordpressclient.myinterface.CallbackAuthorization;


public class LoginFragment extends Fragment {


    static final String FRAGMENT_LOGIN = "fragment_login";


    public static LoginFragment createInstance() {
        return new LoginFragment();
    }

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.screen_fragment_login, container, false);
        WebView web = view.findViewById(R.id.web_view_login);
        web.setWebViewClient(new WebViewClient(){
                                 @Override
                                 public boolean shouldOverrideUrlLoading(WebView view, String uri) {
                                     if (uri.startsWith(AppController.REDIRECT_URI)){
                                         CallbackAuthorization callbackAuthorization = (CallbackAuthorization) getContext();
                                         if (callbackAuthorization != null) {
                                             callbackAuthorization.setCallbackAuthorization(uri);
                                         }
                                     } else {
                                         view.loadUrl(uri);
                                     }
                                     return true;
                                 }
                             });
        web.getSettings().setDomStorageEnabled(true);
        web.getSettings().setJavaScriptEnabled(true);
        web.loadUrl(AppController.LOGIN_ADDRESS);
        return view;
    }
}
