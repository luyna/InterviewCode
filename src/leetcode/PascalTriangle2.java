package leetcode;


import java.util.ArrayList;
import java.util.List;


/**
 * @author Luyna
 *
 * 2014Äê12ÔÂ17ÈÕ
 * 
 *  Given an index k, return the kth row of the Pascal's triangle.
	For example, given k = 3,
	Return [1,3,3,1].
	Note:
	Could you optimize your algorithm to use only O(k) extra space?
 */
public class PascalTriangle2 {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> result=new ArrayList<Integer>();
        for(int i=0;i<=rowIndex;i++){
        	List<Integer> row=new ArrayList<Integer>();
        	for(int j=0;j<i+1;j++){
        		if(j==0 || j==i){
        			row.add(1);
        		}else{
        			row.add(result.get(j-1)+result.get(j));
        		}
        	}
        	result=row;
        }
        return result;
    }
}
