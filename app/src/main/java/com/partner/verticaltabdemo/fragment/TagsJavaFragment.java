package com.partner.verticaltabdemo.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.partner.tabtools.verticalTab.DisplayUtil;
import com.partner.tabtools.verticalTab.TabAdapter;
import com.partner.tabtools.verticalTab.TabView;
import com.partner.tabtools.verticalTab.VerticalTabLayout;
import com.partner.verticaltabdemo.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TagsJavaFragment extends Fragment {

    List<String> tabsTitle = new ArrayList<>();
    List<Fragment> fragments = new ArrayList<>();
    TabAdapter adapter;
    FragmentPagerAdapter fragmentPagerAdapter;
    RelativeLayout rlTitle;
    VerticalTabLayout verticalTabLayout;
    VerticalTabLayout verticalTabLayout2;
    ViewPager vpAllTags;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_tags_list,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
        initData();
    }

    private void initData() {
        tabsTitle = Arrays.asList("推荐分类" , "JAVA" , "Android", "Kotlin", "C++", "Flutter", "Python");

        for (String title : tabsTitle){
            Fragment fragment = new TestFragment();
            Bundle bundle1 = new Bundle();
            bundle1.putString("_type", title);
            fragment.setArguments(bundle1);
            fragments.add(fragment);
        }

        setAdapter();
    }

    private void setAdapter() {
        fragmentPagerAdapter = new FragmentPagerAdapter(getChildFragmentManager()) {
            @NonNull
            @Override
            public Fragment getItem(int position) {
                return fragments.get(position);
            }

            @Override
            public int getCount() {
                return fragments.size();
            }
        };

        vpAllTags.setAdapter(fragmentPagerAdapter);
        verticalTabLayout.setupWithViewPager(vpAllTags);
        verticalTabLayout2.setupWithViewPager(vpAllTags);

        adapter = new TabAdapter() {
            @Override
            public int getCount() {
                return tabsTitle.size();
            }

            @Override
            public TabView.TabBadge getBadge(int position) {
                return null;
            }

            @Override
            public TabView.TabIcon getIcon(int position) {
                return null;
            }

            @Override
            public TabView.TabTitle getTitle(int position) {
                return new TabView.TabTitle.Builder()
                        .setContent(tabsTitle.get(position))
                        .setTextSize(DisplayUtil.getSR(13))
                        .setTextColor(0xFFcbcbcc,0xFF4a4a4a)
                        .build();
            }

            @Override
            public int getBackground(int position) {
                return getResources().getColor(R.color.white);
            }
        };
        verticalTabLayout.setTabAdapter(adapter);
        verticalTabLayout2.setTabAdapter(adapter);
    }

    private void initView(View view) {
        rlTitle = view.findViewById(R.id.rlTitle);
        verticalTabLayout = view.findViewById(R.id.verticalTabLayout);
        verticalTabLayout2 = view.findViewById(R.id.verticalTabLayout2);
        vpAllTags = view.findViewById(R.id.vpAllTags);

        ((ViewGroup.MarginLayoutParams) rlTitle.getLayoutParams()).topMargin = DisplayUtil.getSR(23);
        ((ViewGroup.MarginLayoutParams) rlTitle.getLayoutParams()).bottomMargin = DisplayUtil.getSR(20);
        ((ViewGroup.MarginLayoutParams) rlTitle.getLayoutParams()).leftMargin = DisplayUtil.getSR(20);

        verticalTabLayout.getLayoutParams().width = DisplayUtil.getSR(64);
        verticalTabLayout2.getLayoutParams().width = DisplayUtil.getSR(64);

        vpAllTags.setOffscreenPageLimit(10);
    }
}
