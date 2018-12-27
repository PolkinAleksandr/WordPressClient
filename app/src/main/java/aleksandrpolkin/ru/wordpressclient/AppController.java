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
    static final String LOGIN_ADDRESS = "https://public-api.wordpress.com/oauth2/authorize?response_type=token&client_id=64203&redirect_uri=https://aleksandrpolkin.ru.wordpressclient";
    static final String AUTH_ADDRESS = "https://wordpress.com/start/ru?ref=homepage";


    public static SharedPreferences getPreference(Context context){
        return context.getSharedPreferences(PREFERENCES_FILE_NAME, Context.MODE_PRIVATE);
    }
}
