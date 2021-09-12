package view;

import control.ViewController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuePanel extends ViewPanel{
    private JButton newOrderButton;
    private JButton logOutButton;
    private JPanel finalPanel;
    private JButton lastOrderButton;

    public MenuePanel(ViewController viewController, MainWindow mainWindow) {
        super(viewController,mainWindow);
        logOutButton.addActionListener( e -> viewController.setPanel("startPanel"));
        lastOrderButton.addActionListener(e -> viewController.setPanel("lastOrdersPanel"));
        newOrderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viewController.setPanel("orderPanel");
                viewController.getMainController().getCurrentUser().makeNewOrder();
            }
        });
    }

    public JPanel getMainPanel() {
        return finalPanel;
    }
}
