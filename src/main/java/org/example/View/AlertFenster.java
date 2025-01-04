package org.example.View;

import javafx.scene.control.Alert;

public class AlertFenster {
	/**
	 * Zeigt ein Alert-Fenster mit der angegebenen Nachricht.
	 *
	 * @param title   Der Titel des Alert-Fensters.
	 * @param message Die Nachricht des Alert-Fensters.
	 */
	public static void showAlert(String title, String message) {
	    Alert alert = new Alert(Alert.AlertType.ERROR);
	    alert.setTitle(title);
	    alert.setHeaderText(null);
	    alert.setContentText(message);
	    alert.showAndWait();
	}
}
