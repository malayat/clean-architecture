package ec.solmedia.cleanarchitecture.domain.usecase;

import javax.inject.Inject;

import ec.solmedia.cleanarchitecture.data.repository.PersonRepository;
import rx.Observable;

public class GetPersons extends UseCase {

    private final PersonRepository repository;

    @Inject
    public GetPersons(PersonRepository repository) {
        this.repository = repository;
    }

    @Override
    protected Observable buildObservableUseCase() {
        return this.repository.personDomainList();
    }
}
