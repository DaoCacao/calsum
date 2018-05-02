package legion.core.calsum;

interface Facade {

    interface View {
        void showExpression(String expression);
        void showTotal(String total);

        void moveSelector(int selectorPos);
    }

    interface Presenter {
        void OnViewResume();
        void OnViewPause();

        void OnNumberClick(int selectorPos, String number);
        void onOperatorClick(int selectorPos, String operator);
        void onComaClick(int selectionPos);
        void onClearClick();
        void onEraseClick(int selectorPos);
    }

    interface Storage {
        String getExpression();
        void saveExpression(String expression);
    }
}
