package controller;

import model.DashboardSummary;
import model.User;
import service.DashboardService;

public class DashboardController {

    private DashboardService dashboardService;

    public DashboardController(DashboardService dashboardService) {
        this.dashboardService = dashboardService;
    }

    public DashboardSummary loadDashboard(User user) {
        return dashboardService.buildDashboard(user);
    }
}
