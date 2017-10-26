package com.indieDream.wordChain;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;

import com.ogaclejapan.smarttablayout.SmartTabLayout;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItem;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems;

/**
 * Created by kjw19 on 19/10/2017.
 */

public class bottomFragment extends Fragment {

    private FrameLayout fragmentContainer;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;

    /**
     * Create a new instance of the fragment
     */
    public static bottomFragment newInstance(int index) {
        bottomFragment fragment = new bottomFragment();
        Bundle b = new Bundle();
        b.putInt("index", index);
        fragment.setArguments(b);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (getArguments().getInt("index", 0) == 0) {
            View view = inflater.inflate(R.layout.join_page, container, false);
            initHomeList(view);
            return view;
        } else {
            View view = inflater.inflate(R.layout.rank_page, container, false);
            initRankList(view);
            return view;
        }
    }

    /**
     * Init the fragment
     */


    private void initHomeList(View view) {

        Toolbar toolbar = (Toolbar) view.findViewById(R.id.toolbar);
        toolbar.setTitle("Demo");
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);

        ViewGroup tab = (ViewGroup) view.findViewById(R.id.tab);
        tab.addView(LayoutInflater.from(getActivity()).inflate(R.layout.demo_basic, tab, false));

        ViewPager viewPager = (ViewPager) view.findViewById(R.id.viewpager);
        SmartTabLayout viewPagerTab = (SmartTabLayout) view.findViewById(R.id.viewpagertab);

        FragmentPagerItems pages = new FragmentPagerItems(getActivity());
        pages.add(FragmentPagerItem.of("我参与的", DemoFragment.class));
        pages.add(FragmentPagerItem.of("我围观的", DemoFragment.class));

        FragmentPagerItemAdapter adapter = new FragmentPagerItemAdapter(
                getFragmentManager(), pages);

        viewPager.setAdapter(adapter);
       viewPagerTab.setViewPager(viewPager);
    }

    private void initRankList(View view) {

        Toolbar toolbar = (Toolbar) view.findViewById(R.id.toolbar);
        toolbar.setTitle("Demo1");
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);

        ViewGroup tab = (ViewGroup) view.findViewById(R.id.tab);
        tab.addView(LayoutInflater.from(getActivity()).inflate(R.layout.demo_basic, tab, false));

        ViewPager viewPager = (ViewPager) view.findViewById(R.id.viewpager);
        SmartTabLayout viewPagerTab = (SmartTabLayout) view.findViewById(R.id.viewpagertab);

        FragmentPagerItems pages = new FragmentPagerItems(getActivity());
        pages.add(FragmentPagerItem.of("最长接龙", DemoFragment.class));
        pages.add(FragmentPagerItem.of("实力接龙", DemoFragment.class));

        FragmentPagerItemAdapter adapter = new FragmentPagerItemAdapter(
                getFragmentManager(), pages);

        viewPager.setAdapter(adapter);
       viewPagerTab.setViewPager(viewPager);
    }


    /**
     * Refresh
     */
    public void refresh() {
        if (getArguments().getInt("index", 0) > 0 && recyclerView != null) {
            recyclerView.smoothScrollToPosition(0);
        }
    }

    /**
     * Called when a fragment will be displayed
     */
    public void willBeDisplayed() {
        // Do what you want here, for example animate the content
        if (fragmentContainer != null) {
            Animation fadeIn = AnimationUtils.loadAnimation(getActivity(), R.anim.fade_in);
            fragmentContainer.startAnimation(fadeIn);
        }
    }

    /**
     * Called when a fragment will be hidden
     */
    public void willBeHidden() {
        if (fragmentContainer != null) {
            Animation fadeOut = AnimationUtils.loadAnimation(getActivity(), R.anim.fade_out);
            fragmentContainer.startAnimation(fadeOut);
        }
    }
}
