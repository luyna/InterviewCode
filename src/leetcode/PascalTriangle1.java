package leetcode;


import java.util.ArrayList;
import java.util.List;


/**
 * @author Luyna
 *
 * 2014Äê12ÔÂ17ÈÕ
 *  Given numRows, generate the first numRows of Pascal's triangle.
	For example, given numRows = 5,
	Return
[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]

 */
public class PascalTriangle1 {
    public List<List<Integer>> generate(int numRows) {

        List<List<Integer>> list=new ArrayList<List<Integer>>();
        if(numRows==0) return list;
        for(int i=0;i<numRows;i++){
            List<Integer> tmp=new ArrayList<Integer>();
        	for(int j=0;j<1+i;j++){
        		if(j==0 || j==i){
        			tmp.add(1);
        		}else{
        			tmp.add(list.get(i-1).get(j-1)+list.get(i-1).get(j));
        		}
        	}
        	list.add(tmp);
        }
        return list;
    }
    public static void main(String [] args){
    	PascalTriangle1 p=new PascalTriangle1();
    	System.out.println(p.generate(2));
    }
}
