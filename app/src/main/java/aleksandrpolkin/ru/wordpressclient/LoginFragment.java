package aleksandrpolkin.ru.wordpressclient;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;


/**
 * A simple {@link Fragment} subclass.
 */
public class LoginFragment extends Fragment {


    static final String FRAGMENT_LOGIN = "fragment_login";

    public static LoginFragment createInstance() {
        return new LoginFragment();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.screen_fragment_login, container, false);
        WebView web = v.findViewById(R.id.web_view_login);
        web.setWebViewClient(new WebViewClient(){
                                 @Override
                                 public boolean shouldOverrideUrlLoading(WebView view, String url) {
                                     view.loadUrl(url);
                                     return true;
                                 }
                             });
        web.getSettings().setJavaScriptEnabled(true);
        web.loadUrl("https://public-api.wordpress.com/oauth2/authorize?client_id=64203&redirect_uri=https://aleksandrpolkin.ru.wordpressclient&response_type=token");
        //web.loadUrl("https://vk.com/");
        return v;
    }



}
