package com.jsheng.simpleweather.base;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.lang.reflect.Field;
import java.util.List;

import butterknife.ButterKnife;
import timber.log.Timber;

/**
 * Created by shengjun on 2017/1/26.
 */

public abstract class BaseFragment extends Fragment {

    protected final String TAG = toString();

    protected Activity mActivity;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mActivity = (Activity) context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(getFragmentLayout(), container, false);
    }

    protected abstract int getFragmentLayout();

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        ButterKnife.bind(this, view);

    }

    @Override
    public void onDetach() {
        super.onDetach();
        clearChildFragmentManager();
    }

    @SuppressWarnings("TryWithIdenticalCatches")
    private void clearChildFragmentManager() {
        List<Fragment> childFragments = getChildFragmentManager().getFragments();
        if (childFragments != null && childFragments.isEmpty())
        try {
            Field childFragmentManager = Fragment.class.getDeclaredField("mChildFragmentManager");
            childFragmentManager.setAccessible(true);
            childFragmentManager.set(this, null);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    final protected Timber.Tree getTimber() {
        return Timber.tag(TAG);
    }

    public String toString() {
        return getClass().getSimpleName() + "@" + Integer.toHexString(hashCode());
    }

    /**
     * 重写下面三个方法是因为：
     *  嵌套Fragment startActivityForResult解决方案
     *  http://blog.csdn.net/CN_FOOLISHMAN/article/details/47148877
     */

    @Override
    public void startActivityForResult(Intent intent, int requestCode) {
        super.startActivityForResult(intent, requestCode);
        Fragment fragment = getParentFragment();
        if (fragment != null) {
            fragment.startActivityForResult(intent, requestCode);
        } else {
            super.startActivityForResult(intent, requestCode);
        }
    }

    @Override
    public void startActivityForResult(Intent intent, int requestCode, @Nullable Bundle options) {
        super.startActivityForResult(intent, requestCode, options);
        Fragment fragment = getParentFragment();
        if (fragment != null) {
            fragment.startActivityForResult(intent, requestCode, options);
        } else {
            super.startActivityForResult(intent, requestCode, options);
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        List<Fragment> childFragments = getChildFragmentManager().getFragments();
        if (childFragments != null) {
            for(Fragment fragment : childFragments){
                fragment.onActivityResult(requestCode, resultCode, data);
            }
        }
    }
}
