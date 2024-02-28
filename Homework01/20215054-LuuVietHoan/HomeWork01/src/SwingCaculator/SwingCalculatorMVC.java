package SwingCaculator;
//Lưu Việt Hoàn - 20215054
public class SwingCalculatorMVC {
	
	public static void main(String[] args) {
        SwingCalculatorModel model = new SwingCalculatorModel();
        SwingCalculatorView view = new SwingCalculatorView();
        new SwingCalculatorController(model, view);
        view.setVisible(true);
    }
}
