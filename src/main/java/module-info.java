module com.example.rusiuotojokursinis {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;

    opens com.example.rusiuotojokursinis to javafx.fxml;
    exports com.example.rusiuotojokursinis;
}