package atj.ws;

import java.io.FileOutputStream;
import java.io.IOException;

import javax.activation.DataHandler;
import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public class Attach {
	final String dir = "/home/users/mchmura/Dokumenty/";

	@WebMethod
	public boolean uploadFile(String fileName, DataHandler dataHandler) {
		try (FileOutputStream file = new FileOutputStream(dir + fileName)) {
			dataHandler.writeTo(file);
			file.flush();
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
}
