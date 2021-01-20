package ec.solmedia.cleanarchitecture.data.local;

import java.util.List;

import ec.solmedia.cleanarchitecture.data.entity.PersonEntity;
import rx.Observable;

public interface LocalApi {
    Observable<List<PersonEntity>> personEntityList();
}
