package legion.core.calsum;

class MainMvp {

    interface View {
        void showExpression(String expression);
        void moveSelector(int selectorPos);
    }

    interface Presenter {
        void OnViewResume(String expression);
        void OnNumberClick(int selectorPos, String number);

        void onClearClick();
        void onEraseClick(int selectorPos);
    }
}
