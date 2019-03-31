package atj.rest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
@Path("hello")
public class Hello {

	@GET
	@Produces(javax.ws.rs.core.MediaType.TEXT_PLAIN)
	public String hello(){
		return "Hello bloody student";
	}
	
}
