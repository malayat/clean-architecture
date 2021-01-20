package ec.solmedia.cleanarchitecture.data.datasource;

import java.util.List;

import ec.solmedia.cleanarchitecture.data.entity.PersonEntity;
import ec.solmedia.cleanarchitecture.data.local.LocalApi;
import rx.Observable;

public class PersonsLocalApiDataSource implements DataSource {

    private final LocalApi localApi;

    public PersonsLocalApiDataSource(LocalApi localApi) {
        this.localApi = localApi;
    }

    @Override
    public Observable<List<PersonEntity>> personEntityList() {
        return this.localApi.personEntityList();
    }
}
