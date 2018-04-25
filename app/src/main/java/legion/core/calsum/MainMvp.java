package legion.core.calsum;

class MainMvp {

    interface View {
        void showExpression(String expression);
    }

    interface Presenter {
        void OnNumberClick(String number);
    }
}
