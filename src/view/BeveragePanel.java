package view;

import control.App;
import model.Beverage;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BeveragePanel extends ViewPanel{

    private JButton backButton;
    private JButton addToCardButton;
    private JComboBox selectBox;
    private JPanel beveragePanel;
    private String selectetTyp;

    public BeveragePanel(App maincontroller, MainWindow mainWindow, OrderPanel orderPanel){
        super(maincontroller,mainWindow);
        backButton.addActionListener(e -> mainWindow.setNewPanel(orderPanel.getMainPanel()));
        addToCardButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectetTyp=(String)selectBox.getSelectedItem();
                mainController.getCurrentUser().addBeverageToOrder(new Beverage(selectetTyp));
            }
        });
    }

    public JPanel getMainPanel() {
        return beveragePanel;
    }
}
