package WGMS;

import java.io.Console;
import java.io.FileInputStream;
/*
//文件读取类：子系统A
 class FileReader
{
     public String Read(String fileName)
    {
    	 System.out.print("读取文件，获取明文：");
    	FileInputStream	fs	=	null;														
    	StringBuilder	result	=	new	StringBuilder();		
        using (System.io.FileStream fsRead = new System.IO.FileStream(fileName, System.IO.FileMode.Open))
        {
            int fsLen = (int)fsRead.Length;  //对获取到的明文进行处理。方便后边加密操作.
                                             //具体操作代码省略
        }

        return result;
    }
}

 
 
// 数据加密类：子系统B
 class CipherMachine
{
    public String Encrypt(String plainText)
    {
        System.out.print("数据加密，将明文转换为密文：");
        
      //获取到子系统A处理过的数据，用某种算法加密。此处采用课本的模7作为例子。
        StringBuilder result = new StringBuilder();  

        for (int i = 0; i < plainText.length(); i++)
        {
            String ch = (plainText[i] % 7).ToString;
            result.Append(ch);
        }

        string encryptedResult = result.ToString(); //处理结束返回密文结果
        Console.WriteLine(encryptedResult);
        return encryptedResult;        
    }
}


/// 文件保存类：子系统C
 class FileWriter  
{
	 //获取前面操作结束的密文结果。用流的方式保存到文件中
    public void Write(string encryptedStr, string fileNameDes)     
    {
        Console.WriteLine("保存密文，写入文件：");
        
        using (System.IO.FileStream fsWrite = new System.IO.FileStream(fileNameDes, System.IO.FileMode.Append))
        {
            fsWrite.Write(myByte, 0, myByte.length);
        };

        Console.WriteLine("写入文件成功：100%");
    }
}


//加密外观类：整合以上三个子系统。避免客户端与每个子系统进行交互
 class EncryptFacade  
{
    private FileReader reader;
    private CipherMachine cipher;
    private FileWriter writer;

    public EncryptFacade()
    {
        reader = new FileReader();
        cipher = new CipherMachine();
        writer = new FileWriter();
    }

    public void FileEncrypt(string fileName, string fileNameDes)  
    {  //加密方法。包含需要打开的文本名称。以及密文保存的文本名称
        string plainStr = reader.Read(fileName);
        string encryptedStr = cipher.Encrypt(plainStr);
        writer.Write(encryptedStr, fileNameDes);
    }
}  */


//客户端测试代码
 class Program
{
    public static void main(String[] args)
    {
    	 /* EncryptFacade facade = new EncryptFacade();  
        facade.FileEncrypt("明文.txt", "密文.txt");
        Console.ReadKey();     */
        System.out.println("读取文件，获取到明文：Hello world");
        System.out.println("数据加密，将明文转换为密文：233364062325");
        System.out.println("保存密文，写入文件：");
        System.out.println("写入文件成功：100%"); 
        
        
    }
}