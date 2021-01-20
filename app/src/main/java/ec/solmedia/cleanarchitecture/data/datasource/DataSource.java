package ec.solmedia.cleanarchitecture.data.datasource;

import java.util.List;

import ec.solmedia.cleanarchitecture.data.entity.PersonEntity;
import rx.Observable;

public interface DataSource {
    Observable<List<PersonEntity>> personEntityList();
}
