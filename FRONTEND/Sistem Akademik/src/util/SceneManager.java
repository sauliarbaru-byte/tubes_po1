package util;

import javafx.animation.*;
import javafx.scene.Node;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;

public class SceneManager {

    private static StackPane root;

    // Jenis animasi
    public enum Anim {
        FADE,
        SLIDE_LEFT,
        SLIDE_RIGHT,
        POP
    }

    // Dipanggil SEKALI di MainFX
    public static void init(StackPane container) {
        root = container;
    }

    // Ganti halaman + animasi
    public static void show(Node view, Anim anim) {
        if (root == null) {
            throw new IllegalStateException(
                    "SceneManager belum di-init. Panggil SceneManager.init(root) di MainFX."
            );
        }

        if (root.getChildren().isEmpty()) {
            root.getChildren().add(view);
            return;
        }

        Node current = root.getChildren().get(0);
        root.getChildren().add(view);

        Animation in = buildIn(view, anim);
        Animation out = buildOut(current, anim);

        out.setOnFinished(e -> root.getChildren().remove(current));

        out.play();
        in.play();
    }

    // ================= ANIMASI MASUK =================
    private static Animation buildIn(Node node, Anim anim) {
        switch (anim) {
            case SLIDE_LEFT:
                node.setTranslateX(400);
                return slide(node, 0);
            case SLIDE_RIGHT:
                node.setTranslateX(-400);
                return slide(node, 0);
            case POP:
                node.setScaleX(0.9);
                node.setScaleY(0.9);
                return pop(node);
            default: // FADE
                node.setOpacity(0);
                return fade(node, 1);
        }
    }

    // ================= ANIMASI KELUAR =================
    private static Animation buildOut(Node node, Anim anim) {
        switch (anim) {
            case SLIDE_LEFT:
                return slide(node, -400);
            case SLIDE_RIGHT:
                return slide(node, 400);
            default:
                return fade(node, 0);
        }
    }

    // ================= HELPER =================
    private static Animation fade(Node node, double to) {
        FadeTransition ft = new FadeTransition(Duration.millis(250), node);
        ft.setToValue(to);
        ft.setInterpolator(Interpolator.EASE_BOTH);
        return ft;
    }

    private static Animation slide(Node node, double toX) {
        TranslateTransition tt = new TranslateTransition(Duration.millis(300), node);
        tt.setToX(toX);
        tt.setInterpolator(Interpolator.EASE_BOTH);
        return tt;
    }

    private static Animation pop(Node node) {
        ScaleTransition st = new ScaleTransition(Duration.millis(220), node);
        st.setToX(1);
        st.setToY(1);
        st.setInterpolator(Interpolator.EASE_OUT);
        return st;
    }
}
