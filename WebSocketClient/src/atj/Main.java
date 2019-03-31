package atj;
	
import javax.websocket.CloseReason;
import javax.websocket.CloseReason.CloseCodes;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			FXMLLoader fxmlLoader= new FXMLLoader(Main.class.getResource("WebSocketChat.fxml"));
			AnchorPane	root= fxmlLoader.load();
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.setTitle("JavaFX Web Socket Client");
			primaryStage.setOnHiding(e->primaryStage_Hiding(e, fxmlLoader));
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	private	void primaryStage_Hiding(WindowEvent e, FXMLLoader	fxmlLoader) {
	((WebSocketChatController)fxmlLoader.getController()).closeSession(new CloseReason(CloseCodes.NORMAL_CLOSURE, "Stage	is	hiding"));
	}
	public static void main(String[] args) {
		launch(args);
	}
}
