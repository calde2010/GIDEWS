package co.test.clientes;

import java.util.ArrayList;
import java.util.List;

import javax.xml.ws.handler.Handler;
import javax.xml.ws.handler.HandlerResolver;
import javax.xml.ws.handler.PortInfo;
import javax.persistence.Entity;
 
/**
 *
 * @author www.javadb.com
 */

public class HeaderHandlerResolver implements HandlerResolver {
	
	private String userNameHeader, passwordHeader;
	
	public HeaderHandlerResolver(String userNameHeader, String passwordHeader){
		this.userNameHeader=userNameHeader;
		this.passwordHeader=passwordHeader;
	}
    
public List<Handler> getHandlerChain(PortInfo portInfo) {
      List<Handler> handlerChain = new ArrayList<Handler>();
 
      HeaderHandler hh = new HeaderHandler(userNameHeader, passwordHeader);
 
      
      handlerChain.add(hh);
 
      
      return handlerChain;
   }
}