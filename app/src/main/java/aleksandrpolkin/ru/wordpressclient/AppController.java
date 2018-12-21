package aleksandrpolkin.ru.wordpressclient;

import android.content.Context;
import android.content.SharedPreferences;

public class AppController {

    static final String REDIRECT_URI = "https://aleksandrpolkin.ru.wordpressclient";
    private static final String PREFERENCES_FILE_NAME = "prefs";
    static final String FIND_TOKEN = "access_token=";
    static final String EXTRA_TOKEN = "token";
    static final String EXTRA_ERROR = "error";
    static final String SEPARATION = "&";

    private String token;

    public static SharedPreferences getPreference(Context context){
        return context.getSharedPreferences(PREFERENCES_FILE_NAME, Context.MODE_PRIVATE);
    }

    public void setToken(String uri){
        int indexStart = uri.indexOf(FIND_TOKEN) + FIND_TOKEN.length();
        int indexFinish = uri.indexOf("&");
        token = uri.substring(indexStart, indexFinish);
    }




}
