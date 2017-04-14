package wzx.app.com.tablayout;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

import wzx.app.com.tablayout.adapter.MyPageAdapter;

public class TabLayoutActivity extends AppCompatActivity {

    private ViewPager mPager;
    private TabLayout mTab;
    private List<String> mList;
    private List<String> mTitle;
    private Toolbar mToolbar;
    private DrawerLayout mDrawerLayout;
    private NavigationView mView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_layout);

        mToolbar = (Toolbar) findViewById(R.id.tools);
        mPager = (ViewPager) findViewById(R.id.page);
        mTab = (TabLayout) findViewById(R.id.tab_layout);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.draw_layout);
        mView = (NavigationView) findViewById(R.id.nav_view);
        //设置toolbar
        setSupportActionBar(mToolbar);
        //获取toolbar
        ActionBar actionBar = getSupportActionBar();
        //设置图标可见
        actionBar.setDisplayHomeAsUpEnabled(true);
        //关连DrawerLayout 和 Toolbar
        ActionBarDrawerToggle drawerToggle = new ActionBarDrawerToggle(this,mDrawerLayout,mToolbar,0,0);
        //设置DrawerLayout打开关闭显示图标的监听
        mDrawerLayout.addDrawerListener(drawerToggle);
        //异步改变图标
        drawerToggle.syncState();
        initData();
        //使用自定义适配器来设置viewPage
        mPager.setAdapter(new MyPageAdapter(getSupportFragmentManager(),mList,mTitle));
        //将viewPager和toolbar关联在一起
        mTab.setupWithViewPager(mPager);

        //设置菜单默认选中
        mView.setCheckedItem(R.id.nav_call);
        //设置点击对应的菜单后关闭侧滑菜单
        mView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                mDrawerLayout.closeDrawers();
                return true;
            }
        });
    }

    private void initData() {

        mList = new ArrayList<>();
        mList.add("界面1");
        mList.add("界面2");
        mList.add("界面3");
        mTitle = new ArrayList<>();
        mTitle.add("page1");
        mTitle.add("page2");
        mTitle.add("page3");

    }
}
