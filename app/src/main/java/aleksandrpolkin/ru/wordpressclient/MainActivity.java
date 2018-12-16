package aleksandrpolkin.ru.wordpressclient;

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

import aleksandrpolkin.ru.wordpressclient.myinterface.OnMyClick;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, OnMyClick {

    private BlogsFragment blogsFragment;
    private FragmentTransaction fragmentTransaction;
    private Toolbar toolbar;
    private DrawerLayout drawer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.screen_blogs_list);
        toolbar = findViewById(R.id.toolbar_main);
        setSupportActionBar(toolbar);

        drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        blogsFragment = BlogsFragment.createInstance();
        fragmentTransaction = getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, blogsFragment, BlogsFragment.FRAGMENT_BLOGS);
        fragmentTransaction.commit();
        getSupportActionBar().setTitle(getResources().getString(R.string.text_tittle_blogs));

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

        } else if (id == R.id.nav_favorite) {
            startActivity(AuthorizationActivity.createNewIntent(this));
        }/* else if (id == R.id.nav_send) {

        }*/

        return true;
    }

    private void openFragment(String title, Fragment fragment, String tag, String back){
        toolbar.setTitle(title);
        fragmentTransaction = getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, fragment, tag);
        if (back != null) fragmentTransaction.addToBackStack(back);
        fragmentTransaction.commit();
        drawer.closeDrawer(GravityCompat.START);
    }


    @Override
    public void setOnMyClick(String tag) {
        switch (tag) {
            case NameBlogsFragment.FRAGMENT_NAME_BLOG:
                NameBlogsFragment nameBlogsFragment = NameBlogsFragment.createInstance();
                openFragment(getResources().getString(R.string.text_tittle_blogs_name), nameBlogsFragment, NameBlogsFragment.FRAGMENT_NAME_BLOG, BlogsFragment.FRAGMENT_BLOGS);

            case BlogsFragment.FRAGMENT_BLOGS:
                openFragment(getResources().getString(R.string.text_tittle_blogs), blogsFragment, BlogsFragment.FRAGMENT_BLOGS, null);

            case PostFragment.FRAGMENT_POST:
                PostFragment postFragment = PostFragment.createInstance();
                openFragment(getResources().getString(R.string.text_tittle_post_tag), postFragment, PostFragment.FRAGMENT_POST, NameBlogsFragment.FRAGMENT_NAME_BLOG);
        }
    }
}
