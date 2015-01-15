package leetcode;

import java.util.*;
/**
 * 顺时针 二维矩阵问题 
 * 1、Leetcode NO.54  顺时针打印二维（m,n）矩阵
 * 2、Leetcode NO.59  根据指定的n顺时针生成一个二维矩阵
 * 
 * @author luyna
 * 2015年1月15日
 */

public class SpiralMatrix {
	/**
	 * Leetcode NO.54  顺时针打印二维（m,n）矩阵
	 * 剑指offer P127 面试题20
	 * @param matrix
	 * @return
	 */
	public List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> result=new ArrayList<Integer>();
		if(matrix==null || matrix.length<=0 ) 
	    	return result;
	    int rows=matrix.length;
	    int columns=matrix[0].length;    
	    int rowstart=0,rowend=rows-1;
	    int colstart=0,colend=columns-1;
	    int i,j;
	    while(rowstart<=rowend && colstart<=colend){
	    	for(i=colstart;i<=colend;i++){ //从左向右遍历
		    	result.add(matrix[rowstart][i]);
		    }
	    	rowstart++;
		    for(j=rowstart;j<=rowend;j++){ //从上向下遍历
		    	result.add(matrix[j][colend]);
		    }
		    colend--;
		    if(rowstart<=rowend){  //从右向左遍历，因为上面rowstart变化了，所以要判断是否有必要
		    	for(i=colend;i>=colstart;i--){
			    	result.add(matrix[rowend][i]);
			    }
		    }
	    	rowend--;
		    
		    if(colstart<=colend){  //从下向上遍历
		    	for(j=rowend;j>=rowstart;j--){
			    	result.add(matrix[j][colstart]);
			    } 
		    }
		    colstart++;
		    
	    } 
	    return result;
	}	
	/**
	 * Leetcode NO.59  根据指定的n顺时针生成一个二维矩阵
	 * 比如当n=3时，生成的矩阵为：
	 * [
	 *  [ 1, 2, 3 ],
	 *  [ 8, 9, 4 ],
	 *  [ 7, 6, 5 ]
	 * ]
	 * @param n
	 * @return
	 */
	public int[][] generateMatrix(int n) {
        int [][] result=new int[n][n];
        int rowstart=0,rowend=n-1;
        int colstart=0,colend=n-1;
        int i,num=1;
        while(rowstart<=rowend && colstart<=colend){
        	for(i=colstart;i<=colend;i++){
        		result[rowstart][i]=num++;
        	}
        	rowstart++;
        	for(i=rowstart;i<=rowend;i++){
        		result[i][colend]=num++;
        	}
        	colend--;
        	if(rowstart<=rowend){
        		for(i=colend;i>=colstart;i--){
        			result[rowend][i]=num++;
        		}
        	}
        	rowend--;
        	if(colstart<=colend){
        		for(i=rowend;i>=rowstart;i--){
        			result[i][colstart]=num++;
        		}
        	}
        	colstart++;
        }
        return result;
    }
}
