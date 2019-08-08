package co.gide.tx.util;


public abstract class PartyEntityUtils {
	
	public static Object newInstance(String className) throws Exception
	 {
	      try
	      {
	    	  @SuppressWarnings("rawtypes")
	    	  Class classCa = Class.forName(className);
	    	  Object instance = classCa.newInstance();
	    	  return instance;
	      }
	      catch (Exception e)
	      {
	         throw new IllegalArgumentException(e);
	      }
	 }
	

	
	
	
}
