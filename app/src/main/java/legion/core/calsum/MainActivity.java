package legion.core.calsum;

import android.content.Context;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputFilter;
import android.text.InputType;
import android.text.Spanned;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements MainMvp.View {

    private EditText edExpression;

    private MainMvp.Presenter presenter = new MainPresenter(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edExpression = findViewById(R.id.ed_expression);

        //FIXME --> dirty tricks ^^
        edExpression.setOnClickListener(view -> {
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.OnViewResume("");
    }

    @Override
    public void showExpression(String expression) {
        edExpression.setText(expression);
    }

    @Override
    public void moveSelector(int selectorPos) {
        edExpression.setSelection(selectorPos);
    }

    public void OnBtnClick(View view) {
        TextView tvButton = (TextView) view;
        switch (view.getId()) {
            case R.id.btn_0:
            case R.id.btn_00:
            case R.id.btn_1:
            case R.id.btn_2:
            case R.id.btn_3:
            case R.id.btn_4:
            case R.id.btn_5:
            case R.id.btn_6:
            case R.id.btn_7:
            case R.id.btn_8:
            case R.id.btn_9:
                presenter.OnNumberClick(edExpression.getSelectionStart(), tvButton.getText().toString());
                break;
            case R.id.btn_clear: presenter.onClearClick(); break;
            case R.id.btn_erase: presenter.onEraseClick(edExpression.getSelectionStart()); break;

            //TODO --> set to operations
            //TODO --> set to erasing
            //TODO --> set to coma
        }
    }
}
