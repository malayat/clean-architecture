package ec.solmedia.cleanarchitecture.view.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;


public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());

        setupToolbar();
        bindViews();
        initView();
    }

    public void setupToolbar() {
        /*mToolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.toolbar);
        if (mToolbar != null) {
            setSupportActionBar(mToolbar);
        }*/
    }

    private void bindViews() {
        ButterKnife.bind(this);
    }

    public void initView() {}


    protected abstract int getLayoutId();
}
