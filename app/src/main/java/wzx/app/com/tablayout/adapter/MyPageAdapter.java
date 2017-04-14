package wzx.app.com.tablayout.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

import wzx.app.com.tablayout.fragment.TabLayoutFragment;

/**
 * Created by 王钟鑫 on 2017/4/14.
 */
//FragmentPagerAdapter所创建的fragment在切换的时候会不会销毁fragment。适合比较少的fragment
public class MyPageAdapter extends FragmentPagerAdapter {

    private List<String> mList;
    private List<String> mTitle;
    public MyPageAdapter(FragmentManager fragmentManager,List<String> list,List<String> list_title) {
        super(fragmentManager);
        this.mTitle = list_title;
        this.mList = list;
    }
    //返回一个fragment
    @Override
    public Fragment getItem(int position) {
        String text = mList.get(position);
        return TabLayoutFragment.newInstance(text);
    }
    @Override
    public int getCount() {
        return mList.size();
    }

    //设置page的头
    @Override
    public CharSequence getPageTitle(int position) {

        return mTitle.get(position);
    }
}
