package ec.solmedia.cleanarchitecture.di.components;


import javax.inject.Singleton;

import dagger.Component;
import ec.solmedia.cleanarchitecture.di.modules.MainModule;
import ec.solmedia.cleanarchitecture.view.activity.MainActivity;

@Singleton
@Component(modules = MainModule.class)
public interface MainComponent {
    void inject(MainActivity activity);
}
