/**
 * Application tries to find a spot in the scan that matches the pattern of a tumor.
 * @author Mr. King
 * @version Feb 2018
 */
public class Main
{
    public static void main(String[] args)
    {
    	for(int i = 1; i <= 4; i++)
    	{
	    	String file = "scan" + i + ".txt";
	    	Initialize init = new Initialize(file);
	        Scan s = new Scan(init.getScan());
	        Tumor t = new Tumor(init.getTumor());
	        System.out.print(s.getTumorLoc(t) + "\n\n");
    	}
    }
}
