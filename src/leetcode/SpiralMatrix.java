package leetcode;

import java.util.*;
/**
 * ˳ʱ�� ��ά�������� 
 * 1��Leetcode NO.54  ˳ʱ���ӡ��ά��m,n������
 * 2��Leetcode NO.59  ����ָ����n˳ʱ������һ����ά����
 * 
 * @author luyna
 * 2015��1��15��
 */

public class SpiralMatrix {
	/**
	 * Leetcode NO.54  ˳ʱ���ӡ��ά��m,n������
	 * ��ָoffer P127 ������20
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
	    	for(i=colstart;i<=colend;i++){ //�������ұ���
		    	result.add(matrix[rowstart][i]);
		    }
	    	rowstart++;
		    for(j=rowstart;j<=rowend;j++){ //�������±���
		    	result.add(matrix[j][colend]);
		    }
		    colend--;
		    if(rowstart<=rowend){  //���������������Ϊ����rowstart�仯�ˣ�����Ҫ�ж��Ƿ��б�Ҫ
		    	for(i=colend;i>=colstart;i--){
			    	result.add(matrix[rowend][i]);
			    }
		    }
	    	rowend--;
		    
		    if(colstart<=colend){  //�������ϱ���
		    	for(j=rowend;j>=rowstart;j--){
			    	result.add(matrix[j][colstart]);
			    } 
		    }
		    colstart++;
		    
	    } 
	    return result;
	}	
	/**
	 * Leetcode NO.59  ����ָ����n˳ʱ������һ����ά����
	 * ���統n=3ʱ�����ɵľ���Ϊ��
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
