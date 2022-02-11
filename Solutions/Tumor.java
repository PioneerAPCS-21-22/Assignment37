import java.util.List;
import java.util.ArrayList;

/**
 * Represents the pattern of a tumor. 
 *
 * @author Mr. King
 * @version Feb 2018
 */
public class Tumor
{
    // private class variable List that holds the rows as Strings
    private List<String> rows;

    /** 
     * constructor
     * @param List<String> 
     * initialize class variable as an ArrayList
     */
    public Tumor(List<String> tumor)
    {
        this.rows = new ArrayList<String>(tumor);
    }

    /**
     * method: getTumorLen
     * @param none
     * @return the length of List class variable (number of rows)
     */
    public int getTumorLen()
    {
        return rows.size();
    }

    /**
     * method: getTumor
     * @param none
     * @return a copy of the tumor (List<String>)
     */
    public List<String> getTumor()
    {
        return new ArrayList<String>(rows);
    }

    /**
     * method: rotate
     * Note: does NOT do a full rewrite of the rotate90 code and uses the existing rotate90 method.
     * @param int (pre: degrees that is a multiple of 90)
     * @return A Tumor object that has been rotated d degrees counterclockwise.
     */
    public Tumor rotate(int d)
    {
        Tumor t = new Tumor(this.getTumor());

        for(int i = 0; i < d; i += 90)
        {
            t = rotate90(t);
        }

        return t;
    }

    /**
     * method: rotate90
     * @param: Tumor that is to be rotated.
     * @return: a copy of Tumor t that is rotated 90 degrees counterclockwise.
     */
    public Tumor rotate90(Tumor t)
    {
        List<String> rotated = new ArrayList<String>();
        for(int r = 0; r < t.getTumor().size(); r++)
        {
            rotated.add("");
        }

        int numRows = t.getTumor().size();

        for(int r = 0; r < numRows; r++)
        {	
            for(int c = 0; c < t.getTumor().get(r).length(); c++)
            {
                rotated.set(r, rotated.get(r) + 
                    t.getTumor().get(c).substring(numRows - 1 - r, numRows - 1 - r + 1));
            }
        }

        return new Tumor(rotated);
    }
}
