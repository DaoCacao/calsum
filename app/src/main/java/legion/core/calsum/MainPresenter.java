package legion.core.calsum;

class MainPresenter implements Facade.Presenter {

    private Facade.View view;
    private Facade.Storage storage;
    private MathParser parser = new MathParser();

    private String expression;

    MainPresenter(Facade.View view, Facade.Storage storage) {
        this.view = view;
        this.storage = storage;
    }

    @Override
    public void OnViewResume() {
        this.expression = storage.getExpression();
        view.showExpression(expression);
        view.moveSelector(expression.length());
    }

    @Override
    public void OnViewPause() {
        storage.saveExpression(expression);
    }

    @Override
    public void OnNumberClick(int selectorPos, String number) {
        addToExpression(selectorPos, number);
        view.showTotal(parser.calculate(expression));
    }

    @Override
    public void onOperatorClick(int selectorPos, String operator) {
        if (selectorPos != 0) {
                addToExpression(selectorPos, operator);
        }
        view.showTotal(parser.calculate(expression));
    }


    @Override
    public void onComaClick(int selectionPos) {
        addToExpression(selectionPos, ".");
        view.showTotal(parser.calculate(expression));
    }

    @Override
    public void onClearClick() {
        expression = "";
        view.showExpression(expression);
        view.showTotal("");
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
        view.showTotal(parser.calculate(expression));
    }

    private void addToExpression(int selectorPos, String character) {
        String firstPart = expression.substring(0, selectorPos);
        String secondPart = expression.substring(selectorPos, expression.length());

        expression = firstPart.concat(character).concat(secondPart);
        view.showExpression(expression);
        view.moveSelector(selectorPos + character.length());
    }
    private void replaceInExpression(int selectorPos, String character) {
        String firstPart = expression.substring(0, selectorPos - 1);
        String secondPart = expression.substring(selectorPos, expression.length());

        expression = firstPart.concat(character).concat(secondPart);
        view.showExpression(expression);
        view.moveSelector(selectorPos - 1 + character.length());
    }
}
