package ec.solmedia.cleanarchitecture;

import android.app.Application;

import ec.solmedia.cleanarchitecture.di.components.DaggerMainComponent;
import ec.solmedia.cleanarchitecture.di.components.MainComponent;
import ec.solmedia.cleanarchitecture.di.modules.MainModule;


public class CleanArchitectureApp extends Application {
    public static final String SHARED_PREFERENCES_NAME = "UserPrefs";
    private MainComponent mainComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        setupInjection();
    }

    private void setupInjection() {
        mainComponent = DaggerMainComponent.builder().mainModule(new MainModule()).build();
    }

    public MainComponent getMainComponent() {
        return mainComponent;
    }
}
