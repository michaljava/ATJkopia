package atj;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("hello")
public class Hello {
	
			//konflikt w nazwenictwie
//	@GET    
//	public String sayHello(){
//		return "Hello";
//	}
	@GET
	@Path("{user}")
	public String sayHelloToUser(@PathParam("user") String name){
		return "Hello2   " + name;
	}
	@GET
	public String sayHelloToQueryUser(
			@DefaultValue("Mieszek") @QueryParam("user") String name){
		return "Hello  " + name;
	}
	
}
