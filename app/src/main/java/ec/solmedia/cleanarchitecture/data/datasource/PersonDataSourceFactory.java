package ec.solmedia.cleanarchitecture.data.datasource;

import javax.inject.Inject;
import javax.inject.Singleton;

import ec.solmedia.cleanarchitecture.data.local.LocalApiImpl;

@Singleton
public class PersonDataSourceFactory {

    @Inject
    public PersonDataSourceFactory() {
    }

    public PersonsLocalApiDataSource createDataSource() {
        LocalApiImpl local = new LocalApiImpl();
        return new PersonsLocalApiDataSource(local);
    }
}
