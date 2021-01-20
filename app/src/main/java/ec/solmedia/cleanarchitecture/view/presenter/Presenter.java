package ec.solmedia.cleanarchitecture.view.presenter;


public class Presenter<T extends Presenter.View> {

    private T view;

    public void setView(T view) {
        this.view = view;
    }

    public T getView() {
        return view;
    }

    public void initialize() {}

    public void onDestroy(){}

    public interface View {

        void showLoading();

        void hideLoading();

    }
}
