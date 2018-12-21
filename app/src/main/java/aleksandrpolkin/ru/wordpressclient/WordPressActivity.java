package aleksandrpolkin.ru.wordpressclient;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import aleksandrpolkin.ru.wordpressclient.myinterface.CallbackFragment;

public class WordPressActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, CallbackFragment {

    private BlogsFragment blogsFragment;
    private Toolbar toolbar;
    private DrawerLayout drawer;
    private SharedPreferences pref;

    public static Intent createNewIntent(Context context){
        return new Intent(context, WordPressActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.screen_blogs_list);
        toolbar = findViewById(R.id.toolbar_main);
        setSupportActionBar(toolbar);

        pref = AppController.getPreference(this);
        drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        View view = navigationView.getHeaderView(0);
        TextView textHeader = view.findViewById(R.id.text_view_title);
        final ProfileFragment profileFragment = ProfileFragment.createInstance();
        textHeader.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFragment(getResources().getString(R.string.text_tittle_profile), profileFragment, ProfileFragment.FRAGMENT_PROFILE, null);
            }
        });
        ImageView avatarHeader = view.findViewById(R.id.image_view_avatar);
        avatarHeader.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFragment(getResources().getString(R.string.text_tittle_profile), profileFragment, ProfileFragment.FRAGMENT_PROFILE, null);
            }
        });
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.blogs_list, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_blogs) {
            openFragment(getResources().getString(R.string.text_tittle_blogs), blogsFragment, BlogsFragment.FRAGMENT_BLOGS, null);
        } else if (id == R.id.nav_tags) {
            TagsFragment tagsFragment = TagsFragment.createInstance();
            openFragment(getResources().getString(R.string.text_tittle_markers), tagsFragment, TagsFragment.FRAGMENT_TAG, null);
        } else if (id == R.id.nav_category) {
            CategoryFragment categoryFragment = CategoryFragment.createInstance();
            openFragment(getResources().getString(R.string.text_tittle_category), categoryFragment, CategoryFragment.FRAGMENT_CATEGORY, null);
        } else if (id == R.id.nav_markers) {
            //markers code
        } else if (id == R.id.nav_favorite) {
            //favorite code
        } else if (id == R.id.nav_exit) {
            pref.edit().remove(AppController.EXTRA_TOKEN).apply();
            finish();
        }
        return true;
    }

    @Override
    protected void onStart() {
        super.onStart();
        checkToken();
        openFragment(getResources().getString(R.string.text_tittle_blogs), blogsFragment, BlogsFragment.FRAGMENT_BLOGS, null);
    }

    private void checkToken(){
        String token = pref.getString(AppController.EXTRA_TOKEN, AppController.EXTRA_ERROR);
        if (token.equals(AppController.EXTRA_ERROR)){
            finish();
        }
    }

    private void openFragment(String title, Fragment fragment, String tag, String back){
        checkToken();
        toolbar.setTitle(title);
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, fragment, tag);
        if (back != null) fragmentTransaction.addToBackStack(back);
        fragmentTransaction.commit();
        drawer.closeDrawer(GravityCompat.START);
    }


    @Override
    public void setCallbackFragment(String tag) {
        switch (tag) {
            case NameBlogsFragment.FRAGMENT_NAME_BLOG:
                NameBlogsFragment nameBlogsFragment = NameBlogsFragment.createInstance();
                openFragment(getResources().getString(R.string.text_tittle_blogs_name), nameBlogsFragment, NameBlogsFragment.FRAGMENT_NAME_BLOG, BlogsFragment.FRAGMENT_BLOGS);
                break;
            case BlogsFragment.FRAGMENT_BLOGS:
                openFragment(getResources().getString(R.string.text_tittle_blogs), blogsFragment, BlogsFragment.FRAGMENT_BLOGS, null);
                break;
            case PostFragment.FRAGMENT_POST:
                PostFragment postFragment = PostFragment.createInstance();
                openFragment(getResources().getString(R.string.text_tittle_post_tag), postFragment, PostFragment.FRAGMENT_POST, NameBlogsFragment.FRAGMENT_NAME_BLOG);
                break;
                default:
        }
    }
}
