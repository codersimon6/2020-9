package GCMS1;


import GCMS1.DatabaseLogger;
import GCMS1.FileLogger;
import GCMS1.FileLoggerFactory;
import GCMS1.Logger;
import GCMS1.LoggerFactory;
import java.util.Scanner;

//��־��¼���ӿڣ������Ʒ
interface	Logger	{
	public	void	writeLog();		
	
}

//���ݿ���־��¼���������Ʒ	
class	DatabaseLogger	implements	Logger	{
	public	void	writeLog()	{										
		System.out.println("���ݿ���־��¼�ɹ���");						
		}		
}		

//�ļ���־��¼���������Ʒ
class	FileLogger	implements	Logger	{						
	public	void	writeLog()	{										
		System.out.println("�ļ���־��¼�ɹ���");						
		}		
	
}	

//��־��¼�������ӿڣ����󹤳�
interface	LoggerFactory	{		
	public	Logger	createLogger();		
				
}

//���ݿ���־��¼�������ࣺ���幤��
class	DatabaseLoggerFactory	implements	LoggerFactory	{
	public	Logger	createLogger()	{
		//�������ݿ���־��¼������
		Logger	logger	=	new	DatabaseLogger();	
		//��ʼ�����ݿ���־��¼��
		return	logger;	
	}
}
	
//�ļ���־��¼�������ࣺ���幤��	
class	FileLoggerFactory	implements	LoggerFactory	{
	public	Logger	createLogger()	{
		//�����ļ���־��¼������	
		Logger	logger	=	new	FileLogger();
		//��ʼ�������ļ�
		return	logger;	
	}
}



//�ͻ��˴���
class	factory	{		
	public	static	void	main(String	args[])	{
		LoggerFactory	factory;										
		Logger	logger;	
		while(true){
			System.out.print("ϵͳ֧��������־��¼��ʽ:\n1.�ļ���¼   \n2.���ݿ��¼\n");
			System.out.print("���������ѡ��");
			Scanner sc = new Scanner(System.in);
			int choice = sc.nextInt();	
			if (choice == 1) {
				factory	=	new	FileLoggerFactory();	//�����������ļ�ʵ��										
			    logger	=	factory.createLogger();										
			    logger.writeLog();
			    System.out.println("");
			    continue;
		}
		else if (choice == 2){
				factory	=	new	DatabaseLoggerFactory();	//�����������ļ�ʵ��										
				logger	=	factory.createLogger();										
				logger.writeLog();	
				System.out.println("");
				continue;
							
			}	
		}
	}
}


