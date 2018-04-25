package legion.core.calsum;

class MainPresenter implements MainMvp.Presenter {
    private MainMvp.View view;

    private String expression;

    MainPresenter(MainMvp.View view) {
        this.view = view;
    }

    @Override
    public void OnNumberClick(String number) {
        expression = expression.concat(number);
        System.out.println(expression);
        view.showExpression(expression);
    }
}
