package legion.core.calsum;

class MainPresenter implements MainMvp.Presenter {
    private MainMvp.View view;

    private String expression;

    MainPresenter(MainMvp.View view) {
        this.view = view;
    }

    @Override
    public void OnViewResume(String expression) {
        this.expression = expression;
        view.showExpression(expression);
    }

    @Override
    public void OnNumberClick(int selectorPos, String number) {
        addToExpression(selectorPos, number);
    }

    @Override
    public void onClearClick() {
        expression = "";
        view.showExpression(expression);
    }

    @Override
    public void onEraseClick(int selectorPos) {
        if (selectorPos != 0) {
            String firstPart = expression.substring(0, selectorPos - 1);
            String secondPart = expression.substring(selectorPos, expression.length());

            expression = firstPart.concat(secondPart);
            view.showExpression(expression);
            view.moveSelector(selectorPos - 1);
        }
    }

    private void addToExpression(int selectorPos, String character) {
        String firstPart = expression.substring(0, selectorPos);
        String secondPart = expression.substring(selectorPos, expression.length());

        expression = firstPart.concat(character).concat(secondPart);
        view.showExpression(expression);
        view.moveSelector(selectorPos + character.length());
    }
}
