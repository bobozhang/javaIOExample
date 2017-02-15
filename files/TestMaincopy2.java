/**
 * 
 */
package com.javaIO.test;

import java.io.*;

/**
 * @author zhangbo
 * 2017��2��15��  ����12:57:26
 * 
 */
public class TestMain {
	
	
/*
 * 
 * File�๲�ṩ��������ͬ�Ĺ��캯�����Բ�ͬ�Ĳ�����ʽ���ؽ����ļ���Ŀ¼����Ϣ�����캯����
1��File (String   pathname)   
     ��:File  f1=new File("FileTest1.txt"); //�����ļ�����f1��f1��ָ���ļ����ڵ�ǰĿ¼�´�����FileTest1.txt
2��File (String  parent  ,  String child)
     ��:File f2=new  File(��D:\\dir1","FileTest2.txt") ;//  ע�⣺D:\\dir1Ŀ¼���ȱ�����ڣ������쳣
3��File (File    parent  , String child)
     ��:File  f4=new File("\\dir3");
          File  f5=new File(f4,"FileTest5.txt");  //����� \\dir3Ŀ¼������ʹ��f4.mkdir()�ȴ���
        һ����Ӧ��ĳ�����ļ���Ŀ¼��File����һ�������� �Ϳ���ͨ���������ķ���������ļ���Ŀ¼�����ԡ�    
       1��public boolean exists( ) �ж��ļ���Ŀ¼�Ƿ����
       2��public boolean isFile( ) �ж����ļ�����Ŀ¼ 
       3��public boolean isDirectory( ) �ж����ļ�����Ŀ¼
       4��public String getName( ) �����ļ�����Ŀ¼��
       5��public String getPath( ) �����ļ���Ŀ¼��·����
       6��public long length( ) ��ȡ�ļ��ĳ��� 
       7��public String[ ] list ( ) ��Ŀ¼�������ļ����������ַ��������з��ء� 
       File���л�������һЩ���ļ���Ŀ¼���й��������ķ��������õķ����У�
       1�� public boolean renameTo( File newFile );    �������ļ�
       2�� public void delete( );   ɾ���ļ�
       3��  public boolean mkdir( ); ����Ŀ¼
 */
	private static void fileTest() {  //��ָ����·���´����ļ���ͳ���ļ��ļ����µ������ļ�����
		File dir = new File("D:\\github\\javaIOExample\\files");
		File f1 = new File(dir, "fileOne.txt");
		File f2 = new File(dir, "fileTwo.java");
		try {
			if (!dir.exists())
				dir.mkdir();
			if (!f1.exists())
				f1.createNewFile();
			if (!f2.exists())
				f2.createNewFile();
			System.out.println("f1's AbsolutePath=  " + f1.getAbsolutePath());
			System.out.println("f1 Canread=" + f1.canRead());
			System.out.println("f1's len= " + f1.length());
			String[] FL;
			int count = 0;
			FL = dir.list();
			for (int i = 0; i < FL.length; i++) {
				count++;
				System.out.println(FL[i] + "is in  /rootpath");
			}
			System.out.println("there are" + count + " file in /rootpath ");
		} catch (Exception e) {
			e.printStackTrace();
		}
		/*
		 * ˵����File��ķ���:
			(1) exists()���Դ�����ָ�����ļ���Ŀ¼�Ƿ����
			(2) mkdir()�����ļ�����ָ����Ŀ¼������Ŀ¼��
			(3) createNewFile()�����ļ�����ָ�����ļ�
			(4) list()����Ŀ¼�������ļ����ַ���
		 * 
		 */
	}
	
	
	/*
	 * ���ļ���Ϊ��������Դ����������
	 * ���������ķ�ʽ��ȡ�ļ�
	 */
	private static void fileInputStreamTest() {
		try {
			File f = new File("src/com/javaIO/test/TestMain.java");  //���·��
			FileInputStream rf = new FileInputStream(f);
			int n = 512;
			byte buffer[] = new byte[n];
			while ((rf.read(buffer, 0, n) != -1) && (n > 0)) {
				System.out.println(new String(buffer));
			}
			System.out.println();
			rf.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//��׼�����
	//������д�� write.txt �ļ���
	private static void fileOutputStreamTest(){
	      try {  
	            System.out.println("please Input from      Keyboard");  
	            int count, n = 512;  
	          //  byte buffer[] = new byte[n];  
	           // count = System.in.read(buffer);  
	            FileInputStream rf = new FileInputStream(new File("src/com/javaIO/test/TestMain.java"));
	            byte buffer[] = new byte[n];
	            FileOutputStream wf = new FileOutputStream("D:\\github\\javaIOExample\\files\\write.txt");  
	            while ((rf.read(buffer, 0, n) != -1) && (n > 0)) {
					// System.out.println(new String(buffer));
					 wf.write(buffer, 0, n);  
				}
	           
	            wf.close(); // ����д��������ʱ������close�����ر�����  
	            System.out.println("Save to the write.txt");  
	        } catch (IOException IOe) {  
	            System.out.println("File Write Error!");  
	        }  
	      
	}
	
	private static void fileinoutputTest(){
		  try {  
	            File inFile = new File("src/com/javaIO/test/TestMain.java");  
	            File outFile = new File("D:\\github\\javaIOExample\\files\\TestMaincopy2.java");  
	            FileInputStream finS = new FileInputStream(inFile);  
	            FileOutputStream foutS = new FileOutputStream(outFile);  
	            int c;  
	            while ((c = finS.read()) != -1) {  
	                foutS.write(c);  
	            }  
	            finS.close();  
	            foutS.close();  
	        } catch (IOException e) {  
	            System.err.println("FileStreamsTest: " + e);  
	        } 
	}
	
	/**
	 * @author  zhangbo
	 * 2017��2��15��  ����12:57:28
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// fileInputStreamTest() ;
	//	fileOutputStreamTest();
		fileinoutputTest();
		System.out.println("Hello World !!!");
	}

}
