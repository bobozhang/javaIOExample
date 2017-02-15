/**
 * 
 */
package com.javaIO.test;

import java.io.*;

/**
 * @author zhangbo
 * 2017年2月15日  下午12:57:26
 * 
 */
public class TestMain {
	
	
/*
 * 
 * File类共提供了三个不同的构造函数，以不同的参数形式灵活地接收文件和目录名信息。构造函数：
1）File (String   pathname)   
     例:File  f1=new File("FileTest1.txt"); //创建文件对象f1，f1所指的文件是在当前目录下创建的FileTest1.txt
2）File (String  parent  ,  String child)
     例:File f2=new  File(“D:\\dir1","FileTest2.txt") ;//  注意：D:\\dir1目录事先必须存在，否则异常
3）File (File    parent  , String child)
     例:File  f4=new File("\\dir3");
          File  f5=new File(f4,"FileTest5.txt");  //在如果 \\dir3目录不存在使用f4.mkdir()先创建
        一个对应于某磁盘文件或目录的File对象一经创建， 就可以通过调用它的方法来获得文件或目录的属性。    
       1）public boolean exists( ) 判断文件或目录是否存在
       2）public boolean isFile( ) 判断是文件还是目录 
       3）public boolean isDirectory( ) 判断是文件还是目录
       4）public String getName( ) 返回文件名或目录名
       5）public String getPath( ) 返回文件或目录的路径。
       6）public long length( ) 获取文件的长度 
       7）public String[ ] list ( ) 将目录中所有文件名保存在字符串数组中返回。 
       File类中还定义了一些对文件或目录进行管理、操作的方法，常用的方法有：
       1） public boolean renameTo( File newFile );    重命名文件
       2） public void delete( );   删除文件
       3）  public boolean mkdir( ); 创建目录
 */
	private static void fileTest() {  //在指定的路径下创建文件，统计文件文件夹下的所有文件名称
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
		 * 说明：File类的方法:
			(1) exists()测试磁盘中指定的文件或目录是否存在
			(2) mkdir()创建文件对象指定的目录（单层目录）
			(3) createNewFile()创建文件对象指定的文件
			(4) list()返回目录中所有文件名字符串
		 * 
		 */
	}
	
	
	/*
	 * 以文件作为数据输入源的数据流。
	 * 以数据流的方式读取文件
	 */
	private static void fileInputStreamTest() {
		try {
			File f = new File("src/com/javaIO/test/TestMain.java");  //相对路径
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
	
	//标准输出流
	//把数据写到 write.txt 文件中
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
	           
	            wf.close(); // 当流写操作结束时，调用close方法关闭流。  
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
	 * 2017年2月15日  下午12:57:28
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// fileInputStreamTest() ;
	//	fileOutputStreamTest();
		fileinoutputTest();
		System.out.println("Hello World !!!");
	}

}
