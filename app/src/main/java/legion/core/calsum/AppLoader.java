package legion.core.calsum;

import android.app.Application;

public class AppLoader extends Application {

    private Facade.Storage storage;

    @Override
    public void onCreate() {
        super.onCreate();
        storage = new MainStorage(getApplicationContext());
    }

    public Facade.Storage getStorage() {
        return storage;
    }
}
