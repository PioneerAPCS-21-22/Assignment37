import java.util.List;
import java.util.ArrayList;

/**
 * A patient scan possibly contains tumors.
 * 
 * @author King 
 * @version 1/13/2018
 */

public class Scan 
{
    // private class variable List that holds the rows as Strings
	private List<String> scan;

    /** 
     * constructor
     * @param List<String> rows
     * initialize class variable as an ArrayList
     */
	public Scan(List<String> scan) 
	{
		this.scan = new ArrayList<String>(scan);
	}

    /**
     * method: getScan
     * @param none
     * @return a copy of the scan (List<String>)
     */
	public List<String> getScan()
	{
		return scan;
	}

    /**
     *  method: getScanLen
     *  @param none
     * @return the length of List class variable (number of rows)
     */
	public int getScanLen()
	{
		return scan.size();
	}

    /**
     * method: getTumorLoc
     * @param Tumor t
     * @return String that says where the tumor is (with rotation) or "No tumors detected." if not found.
     */
	public String getTumorLoc(Tumor t)
	{
		String results = "";
		
		int tumorLen = t.getTumorLen();
		int scanLen = getScanLen();
		
		for(int r = 0; r <= scanLen - tumorLen; r++)
		{	
			for(int c = 0; c <= scanLen - tumorLen; c++)
			{
				List<String> scanPiece = new ArrayList<String>();
				for(int m = r; m < r + tumorLen; m++)  // generate scan piece to match
				{
					scanPiece.add(scan.get(m).substring(c, c + tumorLen));
				}
				
				Scan s = new Scan(scanPiece);
				
				for(int deg = 0; deg <= 270 ; deg += 90)  // rotate
				{	
					if(isMatch(s, t.rotate(deg)))
					{
						results += "Possible tumor at (" + r + ", " + c + ", " + deg + ")\n";
					}
				}
			}
		}

		if(results.length() > 0)
		{
			return results;
		}
		
		return "No tumors detected.\n";
	}

    /**
     * method: isMatch
     * @param Scan s, Tumor t
     * @return true if all corresponding rows from the Scan and Tumor match, false otherwise.
     */
	private boolean isMatch(Scan s, Tumor t)
	{
		int numRows = s.getScan().size();

		for(int r = 0; r < numRows; r++)
		{	
			if(!s.getScan().get(r).equals(t.getTumor().get(r)))
			{
				return false;
			}
		}

		return true;
	}
}
