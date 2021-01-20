package ec.solmedia.cleanarchitecture.view.presenter;

import android.support.annotation.NonNull;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import ec.solmedia.cleanarchitecture.domain.model.PersonDomain;
import ec.solmedia.cleanarchitecture.domain.usecase.DefaultSubscriber;
import ec.solmedia.cleanarchitecture.domain.usecase.GetPersons;
import ec.solmedia.cleanarchitecture.view.viewmodel.PersonViewModel;
import ec.solmedia.cleanarchitecture.view.viewmodel.mapper.PersonViewModelToPersonMapper;

@Singleton
public class MainPresenter extends Presenter<MainPresenter.MainView> {

    private final GetPersons getPersons;
    private final PersonViewModelToPersonMapper mapper;

    @Inject
    public MainPresenter(@NonNull GetPersons getPersons, @NonNull PersonViewModelToPersonMapper mapper) {
        this.getPersons = getPersons;
        this.mapper = mapper;
    }

    @Override
    public void initialize() {
        super.initialize();
        getView().showLoading();
        getPersons.execute(new PersonListSuscriber());
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        this.getPersons.unSubscribe();
        setView(null);
    }

    public void onPersonClicked(PersonViewModel personViewModel) {
        getView().onItemClickPerson(personViewModel);
    }

    private final class PersonListSuscriber extends DefaultSubscriber<List<PersonDomain>> {

        @Override
        public void onNext(List<PersonDomain> personDomains) {
            getView().showPersons(mapper.reverseMap(personDomains));
        }

        @Override
        public void onError(Throwable t) {
            getView().hideLoading();
            t.printStackTrace();
        }

        @Override
        public void onCompleted() {
            getView().hideLoading();
        }
    }

    public interface MainView extends Presenter.View {
        void showPersons(List<PersonViewModel> personList);

        //void openPersonScreen(PersonViewModel personViewModel);
        void onItemClickPerson(PersonViewModel personViewModel);
    }
}
