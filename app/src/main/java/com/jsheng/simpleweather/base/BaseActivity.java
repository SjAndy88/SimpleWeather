package com.jsheng.simpleweather.base;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;

import com.jsheng.simpleweather.R;
import com.jsheng.simpleweather.Utils.FixLeakUtils;

import butterknife.ButterKnife;
import timber.log.Timber;

/**
 * Created by shengjun on 2017/1/26.
 */

public abstract class BaseActivity extends AppCompatActivity {

    protected final String TAG = toString();

    protected Activity mActivity;

    protected Toolbar mToolbar;
    protected TextView mToolbarTitle;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivity = this;
        setContentView(getActivityLayout());
        ButterKnife.bind(this);

        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mToolbarTitle = (TextView) findViewById(R.id.toolbar_title);

        if (mToolbar != null) {
            setSupportActionBar(mToolbar);
        }

        if (mToolbarTitle != null) {
            mToolbarTitle.setText(getTitle());
            if (getSupportActionBar() != null) {
                getSupportActionBar().setDisplayShowTitleEnabled(false);
            }
        }
    }

    protected abstract int getActivityLayout();

    @Override
    protected void onStart() {
        super.onStart();
        if (isShowNavigation()) {
            showNavigation();
        }
    }

    protected boolean isShowNavigation() {
        return false;
    }

    private void showNavigation() {
        if (mToolbar != null) {
            mToolbar.setNavigationIcon(R.drawable.ic_back);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home :
                onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        FixLeakUtils.fixInputMethodManagerLeak(this);
    }

    final protected Timber.Tree getTimber() {
        return Timber.tag(TAG);
    }

    public String toString() {
        return getClass().getSimpleName() + "@" + Integer.toHexString(hashCode());
    }
}
