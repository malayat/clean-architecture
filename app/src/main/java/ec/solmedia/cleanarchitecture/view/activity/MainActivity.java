package ec.solmedia.cleanarchitecture.view.activity;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import ec.solmedia.cleanarchitecture.CleanArchitectureApp;
import ec.solmedia.cleanarchitecture.R;
import ec.solmedia.cleanarchitecture.view.adapter.PersonAdapter;
import ec.solmedia.cleanarchitecture.view.base.BaseActivity;
import ec.solmedia.cleanarchitecture.view.presenter.MainPresenter;
import ec.solmedia.cleanarchitecture.view.viewmodel.PersonViewModel;

public class MainActivity extends BaseActivity implements MainPresenter.MainView {

    @BindView(R.id.rv_person_items)
    RecyclerView rvPersonItems;
    @BindView(R.id.progressBar)
    ProgressBar progressBar;

    @Inject
    MainPresenter presenter;

    private PersonAdapter adapter;

    @Override
    public void initView() {
        super.initView();

        setupInjection();
        setupPresenter();
        setupAdapter();
        setupRecyclerView();

        presenter.initialize();

        //setupToolbar();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.onDestroy();
    }

    private void setupInjection() {
        CleanArchitectureApp app = (CleanArchitectureApp) getApplication();
        app.getMainComponent().inject(this);
    }

    private void setupPresenter() {
        presenter.setView(this);
    }

    private void setupAdapter() {
        adapter = new PersonAdapter(presenter);
    }

    private void setupRecyclerView() {
        rvPersonItems.setLayoutManager(new LinearLayoutManager(this));
        rvPersonItems.setHasFixedSize(true);
        rvPersonItems.setAdapter(adapter);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void showLoading() {
        progressBar.setVisibility(View.VISIBLE);
        rvPersonItems.setVisibility(View.GONE);
    }

    @Override
    public void hideLoading() {
        progressBar.setVisibility(View.GONE);
        rvPersonItems.setVisibility(View.VISIBLE);
    }

    @Override
    public void showPersons(List<PersonViewModel> personList) {
        adapter.addAll(personList);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onItemClickPerson(PersonViewModel personViewModel) {
        Toast.makeText(this, "Click en el item: " +personViewModel.toString(), Toast.LENGTH_LONG).show();
    }
}
