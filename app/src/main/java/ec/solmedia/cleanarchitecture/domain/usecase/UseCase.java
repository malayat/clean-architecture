package ec.solmedia.cleanarchitecture.domain.usecase;


import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.Subscriptions;

public abstract class UseCase {

    private Subscription subscription = Subscriptions.empty();

    public void execute(Subscriber useCaseSubscriber) {
        this.subscription = this.buildObservableUseCase()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(useCaseSubscriber);
    }

    public void unSubscribe() {
        if(!subscription.isUnsubscribed()) {
            subscription.unsubscribe();
        }
    }

    protected abstract Observable buildObservableUseCase();
}
