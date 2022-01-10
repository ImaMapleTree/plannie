module me.imamapletree.plannie {
    requires javafx.controls;
    requires javafx.base;
    requires javafx.fxml;

    requires com.dlsc.formsfx;
    requires validatorfx;
    requires org.kordamp.bootstrapfx.core;
    requires org.controlsfx.controls;
    requires java.desktop;

    opens me.imamapletree.plannie to javafx.fxml;
    exports me.imamapletree.plannie;
}