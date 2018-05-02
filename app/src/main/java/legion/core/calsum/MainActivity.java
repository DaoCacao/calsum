package legion.core.calsum;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements Facade.View {

    private EditText edExpression;
    private TextView tvTotal;

    private Facade.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        presenter = new MainPresenter(this, ((AppLoader) getApplication()).getStorage());

        edExpression = findViewById(R.id.ed_expression);
        tvTotal = findViewById(R.id.tv_total);

        //FIXME --> dirty tricks ^^
        edExpression.setOnClickListener(view -> {
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.OnViewResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        presenter.OnViewPause();
    }

    @Override
    public void showExpression(String expression) {
        edExpression.setText(expression);
    }

    @Override
    public void showTotal(String total) {
        tvTotal.setText(total);
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
            case R.id.btn_divide:
            case R.id.btn_multiply:
            case R.id.btn_minus:
            case R.id.btn_plus:
                presenter.onOperatorClick(edExpression.getSelectionStart(), tvButton.getText().toString());
                break;
            case R.id.btn_coma:
                presenter.onComaClick(edExpression.getSelectionStart());
                break;
            case R.id.btn_clear:
                presenter.onClearClick();
                break;
            case R.id.btn_erase:
                presenter.onEraseClick(edExpression.getSelectionStart());
                break;

        }
    }
}
