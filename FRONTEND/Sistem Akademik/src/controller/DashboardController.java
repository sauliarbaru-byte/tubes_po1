package controller;

import view.DashboardView;

import javax.swing.*;

public class DashboardController {

    private DashboardView view;

    public DashboardController(DashboardView view) {
        this.view = view;

        view.getBtnPriority().addActionListener(e ->
                JOptionPane.showMessageDialog(view, "Filter Priority")
        );

        view.getBtnDeadline().addActionListener(e ->
                JOptionPane.showMessageDialog(view, "Filter Deadline")
        );
    }
}
