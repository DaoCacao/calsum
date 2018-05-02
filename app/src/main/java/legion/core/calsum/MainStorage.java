package legion.core.calsum;

import android.content.Context;
import android.content.SharedPreferences;

public class MainStorage implements Facade.Storage {

    private static final String PREFS_NAME = "calsum_prefs";
    private static final String EXPRESSION_KEY = "expression";

    private Context context;

    MainStorage(Context context) {
        this.context = context;
    }

    private SharedPreferences getPreferences() {
        return context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
    }
    private String getString(String key, String def) {
        return getPreferences().getString(key, def);
    }
    private void setString(String key, String value) {
        getPreferences().edit().putString(key, value).apply();
    }

    @Override
    public String getExpression() {
        return getString(EXPRESSION_KEY, "");
    }

    @Override
    public void saveExpression(String expression) {
        setString(EXPRESSION_KEY, expression);
    }
}
