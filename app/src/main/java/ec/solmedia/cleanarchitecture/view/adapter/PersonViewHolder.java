package ec.solmedia.cleanarchitecture.view.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import ec.solmedia.cleanarchitecture.R;
import ec.solmedia.cleanarchitecture.view.presenter.MainPresenter;
import ec.solmedia.cleanarchitecture.view.viewmodel.PersonViewModel;


public class PersonViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.tv_cedula)
    TextView tvCedula;
    @BindView(R.id.tv_nom_ape)
    TextView tvNomApe;
    @BindView(R.id.tv_edad)
    TextView tvEdad;
    @BindView(R.id.iv_foto)
    ImageView imgFoto;

    private final MainPresenter presenter;

    public PersonViewHolder(View itemView, MainPresenter presenter) {
        super(itemView);
        this.presenter = presenter;
        ButterKnife.bind(this, itemView);
    }

    public void render(PersonViewModel personViewModel) {
        tvCedula.setText(personViewModel.getCedula());
        tvNomApe.setText(personViewModel.getNombre().concat(" ").concat(personViewModel.getApellido()));
        tvEdad.setText(String.valueOf(personViewModel.getEdad()));

        onItemClick(personViewModel);
    }

    private void onItemClick(final PersonViewModel personViewModel) {
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.onPersonClicked(personViewModel);
            }
        });
    }
}
