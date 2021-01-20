package ec.solmedia.cleanarchitecture.data.repository;

import android.support.annotation.NonNull;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import ec.solmedia.cleanarchitecture.data.datasource.PersonDataSourceFactory;
import ec.solmedia.cleanarchitecture.data.entity.PersonEntity;
import ec.solmedia.cleanarchitecture.data.datasource.DataSource;
import ec.solmedia.cleanarchitecture.data.repository.mapper.PersonDomainToPersonEntityMapper;
import ec.solmedia.cleanarchitecture.domain.model.PersonDomain;
import rx.Observable;
import rx.functions.Func1;

@Singleton
public class PersonRepository implements Repository {

    private final PersonDomainToPersonEntityMapper mapper;
    private final DataSource dataSource;

    @Inject
    public PersonRepository(@NonNull PersonDomainToPersonEntityMapper mapper, @NonNull PersonDataSourceFactory personDataSourceFactory) {
        this.mapper = mapper;
        this.dataSource = personDataSourceFactory.createDataSource();
    }

    @Override
    public Observable<List<PersonDomain>> personDomainList() {
        return dataSource.personEntityList().map(new Func1<List<PersonEntity>, List<PersonDomain>>() {
            @Override
            public List<PersonDomain> call(List<PersonEntity> personEntities) {
                return mapper.reverseMap(personEntities);
            }
        });
    }
}
