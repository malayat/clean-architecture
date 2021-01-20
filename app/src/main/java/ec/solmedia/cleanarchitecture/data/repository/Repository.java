package ec.solmedia.cleanarchitecture.data.repository;

import java.util.List;

import ec.solmedia.cleanarchitecture.domain.model.PersonDomain;
import rx.Observable;

public interface Repository {
    Observable<List<PersonDomain>> personDomainList();
}
