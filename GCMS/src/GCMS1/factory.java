package GCMS1;


import GCMS1.DatabaseLogger;
import GCMS1.FileLogger;
import GCMS1.FileLoggerFactory;
import GCMS1.Logger;
import GCMS1.LoggerFactory;
import java.util.Scanner;

//日志记录器接口：抽象产品
interface	Logger	{
	public	void	writeLog();		
	
}

//数据库日志记录器：具体产品	
class	DatabaseLogger	implements	Logger	{
	public	void	writeLog()	{										
		System.out.println("数据库日志记录成功。");						
		}		
}		

//文件日志记录器：具体产品
class	FileLogger	implements	Logger	{						
	public	void	writeLog()	{										
		System.out.println("文件日志记录成功。");						
		}		
	
}	

//日志记录器工厂接口：抽象工厂
interface	LoggerFactory	{		
	public	Logger	createLogger();		
				
}

//数据库日志记录器工厂类：具体工厂
class	DatabaseLoggerFactory	implements	LoggerFactory	{
	public	Logger	createLogger()	{
		//创建数据库日志记录器对象
		Logger	logger	=	new	DatabaseLogger();	
		//初始化数据库日志记录器
		return	logger;	
	}
}
	
//文件日志记录器工厂类：具体工厂	
class	FileLoggerFactory	implements	LoggerFactory	{
	public	Logger	createLogger()	{
		//创建文件日志记录器对象	
		Logger	logger	=	new	FileLogger();
		//初始化创建文件
		return	logger;	
	}
}



//客户端代码
class	factory	{		
	public	static	void	main(String	args[])	{
		LoggerFactory	factory;										
		Logger	logger;	
		while(true){
			System.out.print("系统支持以下日志记录方式:\n1.文件记录   \n2.数据库记录\n");
			System.out.print("请输入你的选择：");
			Scanner sc = new Scanner(System.in);
			int choice = sc.nextInt();	
			if (choice == 1) {
				factory	=	new	FileLoggerFactory();	//可引入配置文件实现										
			    logger	=	factory.createLogger();										
			    logger.writeLog();
			    System.out.println("");
			    continue;
		}
		else if (choice == 2){
				factory	=	new	DatabaseLoggerFactory();	//可引入配置文件实现										
				logger	=	factory.createLogger();										
				logger.writeLog();	
				System.out.println("");
				continue;
							
			}	
		}
	}
}


