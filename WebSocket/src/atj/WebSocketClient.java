package atj;

import java.io.IOException;
import java.net.URI;

import javax.websocket.ClientEndpoint;
import javax.websocket.CloseReason;
import javax.websocket.ContainerProvider;
import javax.websocket.DeploymentException;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.WebSocketContainer;

@ClientEndpoint
public class WebSocketClient {
	private Session session;

	public WebSocketClient() {
		connectToWebSocket();
	}

	@OnOpen
	public void onOpen(Session session) {
		this.session = session;
	}

	@OnClose
	public void onClose(CloseReason closeReason) {
	}

	@OnError
	public void onError(Throwable throwable) {
	}

	@OnMessage
	public void onMessage(String message, Session session) {
	}

	private void connectToWebSocket() {
		WebSocketContainer webSocketContainer = ContainerProvider.getWebSocketContainer();
		try {
			URI uri = URI.create("ws://localhost:8080/WebSocket/chatendpoint");
			webSocketContainer.connectToServer(this, uri);
		} catch (DeploymentException | IOException e) {
			e.printStackTrace();
		}
	}

	public void sendMessage(String message) {
		try {
			session.getBasicRemote().sendText(message);
		} catch (IOException ex) {
			ex.printStackTrace();
		}

	}
}