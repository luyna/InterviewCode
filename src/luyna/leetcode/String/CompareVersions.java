package luyna.leetcode.String;

public class CompareVersions {
	/**
	 * �Ƚϰ汾��
	 * 1.1<2.3<2.15<13.3
	 * @param version1
	 * @param version2
	 * @return
	 */
	public int compareVersion(String version1, String version2) {
		if(version1.equals(version2)) return 0;
		if(version1.length()==0) return -1;
		if(version2.length()==0) return 1;
        String [] ver1=version1.split("\\."); //����.���͡�|������ת���ַ�������ü�"\\";
        String [] ver2=version2.split("\\.");
        //�������ĳ��Ȳ�ͬ���򽫶̵�һ���򳤵ļ��㲹�� ��1.0�� 1
        //�öδ������ʡ���Ż����ڱȽ�ʱѡ���Ե���0�Ƚ�
        int maxlen=ver1.length;
        if(ver1.length>ver2.length){
        	String[] tmp=new String[maxlen];
        	for(int j=0;j<tmp.length;j++){
        		if(j<ver2.length) tmp[j]=ver2[j];
        		else tmp[j]="0";
        	}
        	ver2=tmp;
        }else if(ver1.length<ver2.length){
        	maxlen=ver2.length;
        	String[] tmp=new String[maxlen];
        	for(int j=0;j<tmp.length;j++){
        		if(j<ver1.length) tmp[j]=ver1[j];
        		else tmp[j]="0";
        	}
        	ver1=tmp;
        }
        
        
        int i=0;
        //����ָ���
        for(i=0;i<maxlen;i++){
        	if(Integer.parseInt(ver1[i])>Integer.parseInt(ver2[i])) 
        		return 1;
        	if(Integer.parseInt(ver1[i])<Integer.parseInt(ver2[i]))
        		return -1;       	
        }
        
		return 0;
    }
}
