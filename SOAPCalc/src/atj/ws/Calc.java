package atj.ws;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public class Calc{
	@WebMethod
	public float add(float x,float y){
		return x+y;
	}
	@WebMethod
	public float mul(float x,float y){
		return x*y;
	}
	@WebMethod
	public float div(float x,float y){
		if(y==0) return Float.MAX_VALUE;
		return x/y;
	}
	@WebMethod
	public float sub(float x,float y){
		return x-y;
	}

}
