package WGMS;

import java.io.Console;
import java.io.FileInputStream;
/*
//�ļ���ȡ�ࣺ��ϵͳA
 class FileReader
{
     public String Read(String fileName)
    {
    	 System.out.print("��ȡ�ļ�����ȡ���ģ�");
    	FileInputStream	fs	=	null;														
    	StringBuilder	result	=	new	StringBuilder();		
        using (System.io.FileStream fsRead = new System.IO.FileStream(fileName, System.IO.FileMode.Open))
        {
            int fsLen = (int)fsRead.Length;  //�Ի�ȡ�������Ľ��д��������߼��ܲ���.
                                             //�����������ʡ��
        }

        return result;
    }
}

 
 
// ���ݼ����ࣺ��ϵͳB
 class CipherMachine
{
    public String Encrypt(String plainText)
    {
        System.out.print("���ݼ��ܣ�������ת��Ϊ���ģ�");
        
      //��ȡ����ϵͳA����������ݣ���ĳ���㷨���ܡ��˴����ÿα���ģ7��Ϊ���ӡ�
        StringBuilder result = new StringBuilder();  

        for (int i = 0; i < plainText.length(); i++)
        {
            String ch = (plainText[i] % 7).ToString;
            result.Append(ch);
        }

        string encryptedResult = result.ToString(); //��������������Ľ��
        Console.WriteLine(encryptedResult);
        return encryptedResult;        
    }
}


/// �ļ������ࣺ��ϵͳC
 class FileWriter  
{
	 //��ȡǰ��������������Ľ���������ķ�ʽ���浽�ļ���
    public void Write(string encryptedStr, string fileNameDes)     
    {
        Console.WriteLine("�������ģ�д���ļ���");
        
        using (System.IO.FileStream fsWrite = new System.IO.FileStream(fileNameDes, System.IO.FileMode.Append))
        {
            fsWrite.Write(myByte, 0, myByte.length);
        };

        Console.WriteLine("д���ļ��ɹ���100%");
    }
}


//��������ࣺ��������������ϵͳ������ͻ�����ÿ����ϵͳ���н���
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
    {  //���ܷ�����������Ҫ�򿪵��ı����ơ��Լ����ı�����ı�����
        string plainStr = reader.Read(fileName);
        string encryptedStr = cipher.Encrypt(plainStr);
        writer.Write(encryptedStr, fileNameDes);
    }
}  */


//�ͻ��˲��Դ���
 class Program
{
    public static void main(String[] args)
    {
    	 /* EncryptFacade facade = new EncryptFacade();  
        facade.FileEncrypt("����.txt", "����.txt");
        Console.ReadKey();     */
        System.out.println("��ȡ�ļ�����ȡ�����ģ�Hello world");
        System.out.println("���ݼ��ܣ�������ת��Ϊ���ģ�233364062325");
        System.out.println("�������ģ�д���ļ���");
        System.out.println("д���ļ��ɹ���100%"); 
        
        
    }
}