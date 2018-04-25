package legion.core.calsum;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements MainMvp.View {

    private EditText edExpression;

    private TextView btn0;
    private TextView btn00;
    private TextView btn1;
    private TextView btn2;
    private TextView btn3;
    private TextView btn4;
    private TextView btn5;
    private TextView btn6;
    private TextView btn7;
    private TextView btn8;
    private TextView btn9;

    private TextView btnPlus;
    private TextView btnMinus;
    private TextView btnMultiply;
    private TextView btnDivide;
    private TextView btnTotal;

    private TextView btnClear;
    private TextView btnErase;

    private TextView btnComa;
    private TextView btnHi;

    private MainMvp.Presenter presenter = new MainPresenter(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        initListeners();
    }

    private void initViews() {
        edExpression = findViewById(R.id.ed_expression);

        btn0 = findViewById(R.id.btn_0);
        btn00 = findViewById(R.id.btn_00);
        btn1 = findViewById(R.id.btn_1);
        btn2 = findViewById(R.id.btn_2);
        btn3 = findViewById(R.id.btn_3);
        btn4 = findViewById(R.id.btn_4);
        btn5 = findViewById(R.id.btn_5);
        btn6 = findViewById(R.id.btn_6);
        btn7 = findViewById(R.id.btn_7);
        btn8 = findViewById(R.id.btn_8);
        btn9 = findViewById(R.id.btn_9);

        btnPlus = findViewById(R.id.btn_plus);
        btnMinus = findViewById(R.id.btn_minus);
        btnMultiply = findViewById(R.id.btn_multiply);
        btnDivide = findViewById(R.id.btn_divide);
        btnTotal = findViewById(R.id.btn_total);

        btnClear = findViewById(R.id.btn_clear);
        btnErase = findViewById(R.id.btn_erase);

        btnComa = findViewById(R.id.btn_coma);
        btnHi = findViewById(R.id.btn_hi);
    }
    private void initListeners() {
        btn0.setOnClickListener(v -> presenter.OnNumberClick("0"));
        btn00.setOnClickListener(v -> presenter.OnNumberClick("00"));
        btn1.setOnClickListener(v -> presenter.OnNumberClick("1"));
        btn2.setOnClickListener(v -> presenter.OnNumberClick("2"));
        btn3.setOnClickListener(v -> presenter.OnNumberClick("3"));
        btn4.setOnClickListener(v -> presenter.OnNumberClick("4"));
        btn5.setOnClickListener(v -> presenter.OnNumberClick("5"));
        btn6.setOnClickListener(v -> presenter.OnNumberClick("6"));
        btn7.setOnClickListener(v -> presenter.OnNumberClick("7"));
        btn8.setOnClickListener(v -> presenter.OnNumberClick("8"));
        btn9.setOnClickListener(v -> presenter.OnNumberClick("9"));

        //TODO --> set to operations
        //TODO --> set to erasing
        //TODO --> set to coma
    }

    @Override
    public void showExpression(String expression) {
        int start = edExpression.getSelectionStart();
        int end = edExpression.getSelectionEnd();
        edExpression.setText(expression);
    }
}
