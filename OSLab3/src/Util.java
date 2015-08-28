
public class Util {
	
	/**
	 * Debug mode or not
	 */
	public static final boolean DEBUG = true;
	
	/**
	 * Utility function to display text if debugging
	 * @param string
	 */
	public static void println(String string){
		if(Util.DEBUG){
			System.out.println(string);
		}
	}
	
	/**
	 * Utility function to display text if debugging
	 * @param inte
	 */
	public static void println(Integer inte){
		if(Util.DEBUG){
			System.out.println(inte);
		}
	}
	
	/**
	 * Utility function to display text on same line if debugging
	 * @param string
	 */
	public static void print(String string){
		if(Util.DEBUG){
			System.out.print(string);
		}
	}
}
