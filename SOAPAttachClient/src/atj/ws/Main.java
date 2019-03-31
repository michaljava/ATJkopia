package atj.ws;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {

	public static void main(String[] args) {
		Path path = Paths.get("/home/users/mchmura/Pobrane/1x.java");
		byte[] data;
		try {
			data = Files.readAllBytes(path);
			// Foofoo = ( new FooService().getFooPort();
			Attach attach = new AttachService().getAttachPort();
			if (attach.uploadFile("SOAP.pptx", data))
				System.out.println("Plik został	przesłany.");
			else
				System.out.println("Podczas przesyłania pliku wystąpił błąd.");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
