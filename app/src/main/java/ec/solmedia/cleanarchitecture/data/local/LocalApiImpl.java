package ec.solmedia.cleanarchitecture.data.local;

import java.util.ArrayList;
import java.util.List;

import ec.solmedia.cleanarchitecture.data.entity.PersonEntity;
import rx.Observable;
import rx.Subscriber;

public class LocalApiImpl implements LocalApi {
    @Override
    public Observable<List<PersonEntity>> personEntityList() {
        return Observable.create(new Observable.OnSubscribe<List<PersonEntity>>() {
            @Override
            public void call(Subscriber<? super List<PersonEntity>> subscriber) {
                List<PersonEntity> personEntityList = getDummyData();

                if(personEntityList != null) {
                    subscriber.onNext(personEntityList);
                    subscriber.onCompleted();
                } else {
                    subscriber.onError(new Throwable("Error al obtener la informacion"));
                }
            }
        });
    }

    public List<PersonEntity> getDummyData() {
        List<PersonEntity> dummyData = new ArrayList<>();

        PersonEntity p1 = new PersonEntity();
        p1.setDni("1715835524");
        p1.setName("Alejandro");
        p1.setLastName("Ayala");
        p1.setAge(33);
        p1.setPicture("picture");
        dummyData.add(p1);

        PersonEntity p2 = new PersonEntity();
        p2.setDni("1710005214");
        p2.setName("Ana María");
        p2.setLastName("Martínez");
        p2.setAge(34);
        p2.setPicture("picture");
        dummyData.add(p2);

        return dummyData;
    }
}
