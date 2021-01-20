package ec.solmedia.cleanarchitecture.view.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import ec.solmedia.cleanarchitecture.R;
import ec.solmedia.cleanarchitecture.view.presenter.MainPresenter;
import ec.solmedia.cleanarchitecture.view.viewmodel.PersonViewModel;


public class PersonAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private final MainPresenter presenter;
    private final List<PersonViewModel> personViewModelList;

    public PersonAdapter(MainPresenter presenter) {
        this.presenter = presenter;
        this.personViewModelList = new ArrayList<>();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.person_row, parent, false);
        return new PersonViewHolder(view, presenter);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        PersonViewHolder personViewHolder = (PersonViewHolder) holder;
        PersonViewModel personViewModel = personViewModelList.get(position);
        personViewHolder.render(personViewModel);
    }

    @Override
    public int getItemCount() {
        return personViewModelList.size();
    }

    public void addAll(Collection<PersonViewModel> collection) {
        personViewModelList.addAll(collection);
    }
}
