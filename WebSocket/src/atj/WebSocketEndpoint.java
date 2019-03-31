package atj;

import java.io.IOException;
import java.util.concurrent.ConcurrentLinkedQueue;
import javax.enterprise.context.ApplicationScoped;
import javax.websocket.CloseReason;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

@ApplicationScoped
@ServerEndpoint("/chatendpoint")
public class WebSocketEndpoint {
	private static final ConcurrentLinkedQueue<Session> sessions = new ConcurrentLinkedQueue<>();

	// opcjonalnie, patrz @OnMessage
	// adnotacja metody, która będzie wołana
	// przy każdym nawiązaniu połączenia przez klienta
	@OnOpen
	public void onOpen(Session session) {
		sessions.add(session);
	}

	// adnotacja metody, która będzie wołana po każdym odbiorze wiadomości
	@OnMessage
	public void onMessage(String message, Session session,@PathParam("user") String userName) {
		// parametrami są: wiadomość
		// i obiekt klasy implementującej interfejs javax.websocket.Session

		try {
			for (Session aSession : session.getOpenSessions()) {

				if (aSession.isOpen()) {
					aSession.getBasicRemote().sendText(userName +"<br/>"+message);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// adnotacja metody, która będzie wołana
	// przy każdym zamknięciu połączenia przez klienta
	@OnClose
	public void onClose(Session session, CloseReason closeReason) {
		// System.out.println (closeReason.getReasonPhrase());
		sessions.remove(session);
	}

	// adnotacja metody, która będzie wołana po wystąpieniu błędu
	@OnError
	public void onError(Throwable error) {
	}
}
