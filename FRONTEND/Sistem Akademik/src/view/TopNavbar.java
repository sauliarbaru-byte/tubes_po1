package view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import util.SceneManager;

public class TopNavbar extends HBox {

    public TopNavbar(String activeMenu) {

        setPrefHeight(64);
        setMinHeight(64);
        setMaxHeight(64);
        setAlignment(Pos.CENTER_LEFT);
        setPadding(new Insets(0, 32, 0, 32));
        setStyle("-fx-background-color:#2F8F83;");

        Label brand = new Label("EightPlanner");
        brand.setStyle("""
            -fx-text-fill: white;
            -fx-font-size: 18px;
            -fx-font-weight: bold;
        """);

        Region spacer = new Region();
        HBox.setHgrow(spacer, Priority.ALWAYS);

        Label dashboard = navItem("Dashboard", "dashboard", activeMenu);
        Label tasks = navItem("Tasks", "tasks", activeMenu);
        Label profile = navItem("Profile", "profile", activeMenu);

        HBox menu = new HBox(28, dashboard, tasks, profile);
        menu.setAlignment(Pos.CENTER_RIGHT);

        getChildren().addAll(brand, spacer, menu);
    }

    private Label navItem(String text, String key, String active) {

        Label label = new Label(text);
        label.setCursor(Cursor.HAND);

        boolean isActive = key.equals(active);

        label.setStyle(isActive ? """
            -fx-text-fill: white;
            -fx-font-weight: bold;
            -fx-border-color: white;
            -fx-border-width: 0 0 3 0;
            -fx-padding: 6 0;
        """ : """
            -fx-text-fill: #E0F2F1;
            -fx-padding: 6 0;
        """);

        label.setOnMouseEntered(e -> {
            if (!isActive) label.setStyle("-fx-text-fill:white;-fx-padding:6 0;");
        });

        label.setOnMouseExited(e -> {
            if (!isActive) label.setStyle("-fx-text-fill:#E0F2F1;-fx-padding:6 0;");
        });

        label.setOnMouseClicked(e -> {
            switch (key) {
                case "dashboard" ->
                        SceneManager.show(new DashboardView().getView(), SceneManager.Anim.SLIDE_RIGHT);
                case "tasks" ->
                        SceneManager.show(new TasksView().getView(), SceneManager.Anim.SLIDE_LEFT);
                case "profile" ->
                        SceneManager.show(new ProfileView().getView(), SceneManager.Anim.SLIDE_LEFT);
            }
        });

        return label;
    }
}
