package leetcode;



public class atoi {
	public int atoi(String str) {
        int result=0;
		int flag=1;
		//int count=0;//为统计小数点位数
		if(str.length()==0) return 0;
/*		char head=str.charAt(0);
		if(head=='-') flag= -1;
		else if(head>'0' && head<'9') 
			result=head-'0';*/
		int i=0;
		while(str.charAt(i)==' ' || str.charAt(i)=='\t' || str.charAt(i)=='\n'){
			i++;
		}
		int tmp=i;
	    for( ;i<str.length();i++){
	    	char c=str.charAt(i);
	    	if(i==tmp && c=='-') {
	    	    flag= -1;
	    	    continue;
	    	}
	    	if(i==tmp && c=='+') {
	    	    flag=1;
	    	    continue;
	    	}
	    	if(c>='0' && c<='9'){
	    		result = result*10+c-'0';

	    	/*}else if(c=='.'){              //如果考虑浮点数的话采用这种方法
	    		count=str.length()-i-1;*/
	    	}else break;
	    }
	   
	    if(result >Integer.MAX_VALUE) return Integer.MAX_VALUE;
	    if(result <Integer.MIN_VALUE) return Integer.MIN_VALUE;
	    result=result*flag;
		
	    //if(count!=0) result=result/(Math.pow(10,count));  //考虑浮点数时计算
	    return result;
	 
    }
	
	public static void main(String []args){
		String s="2147483648";
		atoi a=new atoi();
		System.out.println("test:"+a.atoi(s));
	}
}
