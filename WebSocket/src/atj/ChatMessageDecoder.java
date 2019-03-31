package atj;

import javax.websocket.DecodeException;
import javax.websocket.Decoder;
import javax.websocket.EndpointConfig;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

public class ChatMessageDecoder implements Decoder.Text<ChatMessage> {
	private ChatMessage chatMessage;

	@Override
	public ChatMessage decode(String msgInJson) throws DecodeException {
		if (willDecode(msgInJson)) {
			return chatMessage;
		}
		return null;
	}

	@Override
	public boolean willDecode(String msgInJson) {
		try {
			// deserializacja ciagu bajtów w formacie JSON do obiektu klasy ChatMessage
			// chatMessage = JsonbBuilder.create().fromJson(msgInJson,ChatMessage.class);}
			chatMessage = new Gson().fromJson(msgInJson, ChatMessage.class);
		} catch (JsonSyntaxException e) {
			return false;
		}
		return true;
	}

	@Override
	public void init(EndpointConfig config) {
	}

	@Override
	public void destroy() {
	}

}
