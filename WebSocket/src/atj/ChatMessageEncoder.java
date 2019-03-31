package atj;

import javax.websocket.EncodeException;
import javax.websocket.Encoder;
import javax.websocket.EndpointConfig;

import com.google.gson.Gson;

public class ChatMessageEncoder implements Encoder.Text<ChatMessage> {
	@Override
	public String encode(ChatMessage chatMsg) throws EncodeException {
		// serializacja obiektu klasy ChatMessage do formatu JSON
		// return JsonbBuilder.create().toJson(chatMsg); aplikacja webowa
		return new Gson().toJson(chatMsg); // aplikacja desktopowa
	}

	@Override
	public void init(EndpointConfig config) {
	}

	@Override
	public void destroy() {
	}
}