package view;

import control.ViewController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SaladPanel extends ViewPanel{
    private JButton addToCartButton;
    private JButton backButton;
    private JComboBox saladSelectionBox;
    private JPanel SaladPanel;


    public SaladPanel(ViewController viewController) {
        super(viewController);

        backButton.addActionListener(e -> viewController.setPanel("orderPanel"));
        addToCartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(viewController.getMainController().getStorage().getSaladkit()>0){
                    viewController.getMainController().getOrderController().addFoodToOrder("Salad", null);
                }else{
                    JOptionPane.showMessageDialog(null,"No Saladkits left, next salad tomorow");
                }
            }
        });
    }

    public JPanel getMainPanel() {
        return SaladPanel;
    }
}
