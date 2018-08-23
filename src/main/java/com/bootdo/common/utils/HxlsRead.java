package com.bootdo.common.utils;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class HxlsRead extends HxlsAbstract{

	
	//���ݴ���������ݵĽӿ�
	private  HxlsOptRowsInterface hxlsOptRowsInterface;
	//������������
	private int optRows_sum = 0;
	//�������ݳɹ�����
	private int optRows_success = 0;
	//��������ʧ������
	private int optRows_failure = 0;
	//excel���ÿ�б���
	private List<String> rowtitle ;
	//ʧ������
	private List<List<String>> failrows;
	//ʧ��ԭ��
	private List<String> failmsgs ;
	
	//Ҫ�����������ڵ�sheet����,sheet������0��ʼ
	private int sheetIndex;
	/**
	 * �����ļ�������
	 * @param filename �����ļ�������·�� 
	 * @param sheetIndex Ҫ��ȡ��������sheet���
	 * @param hxlsOptRowsInterface �����ȡÿһ�����ݵĽӿ�
	 * @throws IOException
	 * @throws FileNotFoundException
	 * @throws SQLException
	 */
	public HxlsRead(String filename,int sheetIndex,HxlsOptRowsInterface hxlsOptRowsInterface) throws IOException,
			FileNotFoundException, SQLException {
		super(filename);
		this.sheetIndex = sheetIndex;
		this.hxlsOptRowsInterface = hxlsOptRowsInterface;
		this.rowtitle = new ArrayList<String>();
		this.failrows = new ArrayList<List<String>>();
		this.failmsgs = new ArrayList<String>();
	}

	/**
	 * �Զ�ȡ��һ�����ݽ��н���
	 */
	@Override
	public void optRows(int sheetIndex,int curRow, List<String> rowlist) throws Exception {
		/*for (int i = 0 ;i< rowlist.size();i++){
			System.out.print("'"+rowlist.get(i)+"',");
		}
		System.out.println();*/
		//��rowlist�ĳ��Ȳ���ͱ���һ��
		int k=rowtitle.size()-rowlist.size();
		for(int i=0;i<k;i++){
			rowlist.add(null);
		}
		if(sheetIndex == this.sheetIndex){
			optRows_sum++;
			
			if(curRow == 0){//��¼����
				rowtitle.addAll(rowlist);
			}else{
				//�ӿڷ��صĽ���ǵ������ݵĽ�����гɹ�����ʧ��
				String result = hxlsOptRowsInterface.optRows(sheetIndex, curRow, rowlist);
				if(result!=null && !result.equals(hxlsOptRowsInterface.SUCCESS)){
					optRows_failure++;//ʧ��ͳ������1
					//ʧ�������б�
					failrows.add(new ArrayList<String>(rowlist));
					failmsgs.add(result);
				}else{
					optRows_success++;
				}
			}

		}
		
		
	}
	
	public long getOptRows_sum() {
		return optRows_sum;
	}

	public void setOptRows_sum(int optRows_sum) {
		this.optRows_sum = optRows_sum;
	}

	public long getOptRows_success() {
		return optRows_success;
	}

	public void setOptRows_success(int optRows_success) {
		this.optRows_success = optRows_success;
	}

	public long getOptRows_failure() {
		return optRows_failure;
	}

	public void setOptRows_failure(int optRows_failure) {
		this.optRows_failure = optRows_failure;
	}

	
	public List<String> getRowtitle() {
		return rowtitle;
	}

	public List<List<String>> getFailrows() {
		return failrows;
	}

	public List<String> getFailmsgs() {
		return failmsgs;
	}

	public void setFailmsgs(List<String> failmsgs) {
		this.failmsgs = failmsgs;
	}

	public static void main(String[] args){
		HxlsRead xls2csv;
		try {
			//��һ���������ǵ�����ļ�
			//�ڶ����������ǵ����ļ����ĸ�sheet
			//��������������ӿڵ�ʵ�������
			xls2csv = new HxlsRead("d:/test11.xls",0,new HxlsOptRowsInterfaceImpl());
			xls2csv.process();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
