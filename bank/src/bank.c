#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
#include<stdlib.h>
  
int i, j;
int n;                       //系统资源总数
int m;                       //总的进程数
int a;                       //当前申请的进程号
int l, e;                     //计数器
int b = 0, c = 0, f = 0, g;           //计数器
int z = 0;
int Available[10];           //可使用资源
int Max[10][10];             //最大需求矩阵
int Allocation[10][10] = { 0 };      //已分配分配矩阵
int Need[10][10] = { 0 };            //还需矩阵
int Work[10];                   //工作向量
int Finish[10];                  //是否有足够的资源分配的状态标志
int Request[10][10];         //Request [i][j]=K,则表示进程i需要K个j类型的资源
int Pause[10];              //暂存
int arr[] = { 0 };        //各类资源总数  





int  securitycheck()     //安全性检测
{
    printf("\n\n");
    printf("*-*-*-*-*-*-*-*-安全性检测*-*-*-*-*-*-\n\n");
    if (n == 3)   //3种资源的布局。程序无关，单纯美化
    {
        printf("          工作向量       尚需求量       已分配      工作向量+已分配\n进程 ");
        for (c = 0; c < 4; c++)
        {
            for (j = 0; j < n; j++)
            {
                printf("  %d类", j);
            }
        }
    }

    if (n == 2)  //2种资源的布局.程序无关，单纯美化
    {
        printf("       工作向量   尚需求量  已分配  工作向量+已分配\n进程 ");
        for (c = 0; c < 4; c++)
        {
            for (j = 0; j < n; j++)
            {
                printf("  %d类", j);
            }
        }
    }

	/*安全性检测思路。1.设置两个向量
工作向量Work，它表示系统可提供给进程继续运行所需的各类资源数目，它含有m个元素，在执行安全算法开始时，Work：=Available，也就是初始化输入的值。
Finish，它表示系统是否有足够的资源分配给进程，使之运行完成。初始化所有Finish[i]:=false;当有足够资源分配给进程时，再令Finish[i]:=ture.
2.从进程集合中找到一个满足下述条件的进程：
Finish[i]=false;
Need[i,j]<=Work[j];若找到，执行步骤3），否则，执行步骤4）。
3.当进程Pi获得资源后，可顺利执行，直至完成，并释放出分配给它的资源，故应执行：
Work[j]:=Work[j]+Allocation[i,j];
Finish[i]:=true;
继续循环第二个步骤;
4.如果所有进程的Finish[i]=true则表示系统处于安全状态；否则，系统处于不安全状态。  */
    for (i = 0; i < m; i++)                 //遍历所有进程，状态置为false        
    {
        Pause[i] = Available[i];    //Pause[i]只是一个暂时寄存的中间变量，
		                              //为防止在下面安全性检查时修改Available[i]而暂存的一维数组
        Finish[i] = false;
    }
    for (g = 0; g < m; g++)      //顺序循环所有满足条件的进程
    {

        for (i = 0; i < m; i++)    
        {
            b = 0;                 //计数器初始化
            Finish[i] == false;   //将所有进程初始状态置为false
            for (j = 0; j < n; j++)         
            {
				if(Max[i][j] < Allocation[i][j]){
					printf("\n\n不安全序列！请重新初始化\n");
					return 0;}

                if (Need[i][j] <= Pause[j])    //第i个进程需要的j资源是否满足。满足继续，直到查找到所有资源都满足的进程
                {
                    b = b + 1;
                }
                if (Finish[i] == false && b == n)   //如果状态为false，同时试分配资源数等于总资源数。将状态置为true并输出进程号
                {
                   
					 Finish[i] = true;
                     printf("\nP[%d] ", i);//依次输出进程安全序列

                    for (l = 0; l < n; l++)
                    {
                        printf("  %2d ", Pause[l]);        // 输出工作资源
                    }
                    for (j = 0; j < n; j++)
                    {
                        printf("  %2d ", Need[i][j]);   // 输出尚需资源
                    }
                    for (j = 0; j < n; j++)
                    {
                       
                        printf("  %2d ", Allocation[i][j]);        // 输出已分配资源 
                    }
                    for (j = 0; j < n; j++)
                    {
                        printf("  %2d ", Pause[j] + Allocation[i][j]);  // 输出已分配资源+工作资源
                    }
                    for (l = 0; l < n; l++)
                    {
                        Pause[l] = Pause[l] + Allocation[i][l];        //将已分配资源+工作资源设定为下一步的工作资源。继续循环
                    }
					
                }
            }
        }
    }
  
    printf("\n\n");
    for (i = 0; i < m; i++)
    {
        if (Finish[i] == true) f = f + 1;   //统计Finish[i]＝＝true的个数
	
    }
    if (f == m)     //如果Finish[i]＝＝true的个数等于总进程数，则分配成功。存在安全序列
    {
		printf("安全序列为上表进程序列。\n");
		printf("\n\n系统剩余资源量：   ");
        for (i = 0; i < n; i++)
        {
        printf("   %d ", Available[i]);
        }
        f = 0;       //将计数器f重新初始化，为下一次提出新的进程申请做准备
        return 1;
    }
    else                  //试分配如果不是安全序列，则将本次的试探分配作废，恢复原来的资源分配状态。
    {
        printf("不安全序列！\n");              
        for (i = 0; i < n; i++) 
        {
            Available[i] = Available[i] + Request[a][i];
            Allocation[a][i] = Allocation[a][i] - Request[a][i];
            Need[a][i] = Need[a][i] + Request[a][i];
        }
        return 0;
    }
  
}
 
void initialize()  //初始化
{
    printf("系统的资源种类数：\n");
    scanf("%d", &n);

	printf("各类资源总数：\n");
    for (i = 0; i < n; i++)
    { 
        scanf("%d", &arr[i]);
    }
    printf("进程总数：\n");
    scanf("%d", &m);

	printf("进程对资源的最大需求矩阵：\n");
    for (i = 0; i < m; i++)
    {
        for (j = 0; j < n; j++)
        {
            scanf("%d", &Max[i][j]);
        }
    }

    printf("进程的所有资源已分配矩阵：\n");
    for (i = 0; i < m; i++)
    {
        for (j = 0; j < n; j++)
        {
            scanf("%d", &Allocation[i][j]);
            Need[i][j] = Max[i][j] - Allocation[i][j];
        }
    }
    for (i = 0; i < n; i++)
    {
        for (j = 0; j < m; j++)
        {
            arr[i] -= Allocation[j][i];
        }
    }
	for (i = 0; i < n; i++)
        Available[i] = arr[i];  // Available为系统最大资源量
        securitycheck();
                 //初始化完成直接进行安全性检测算法
}  

void mainrequest()  //进程申请资源
{
    printf("申请资源的进程：");
    scanf("%d", &a);
	printf("进程P[%d]对资源的申请矩阵：",a);
    for (i = 0; i < n; i++)
    {
        
        scanf("%d", &Request[a][i]);
        if (Request[a][i] > Need[a][i])     //如果Request i[j]<=Need[i,j]，便转向下一步。否则出错，原因如下
        {
            printf("\n错误！进程申请的资源数多于它自己申报的最大需求量\n");
            return;
        }
        if (Request[a][i] > Available[i])  // 如果Request i[j]<=Available[i,j]，试分配；否则等待。
        {
            printf("\nP[%d]请求的资源数大于可用资源数，必须等待\n", a);
            return;
        }
  
    }
    for (i = 0; i < n; i++)
    {
        //以下是试分配
        Available[i] = Available[i] - Request[a][i];
        Allocation[a][i] = Allocation[a][i] + Request[a][i];
        Need[a][i] = Need[a][i] - Request[a][i];
    }
    int ret=securitycheck();    //执行安全性检测算法
    if (ret == 1)              //安全检测返回1则安全。如果不安全，则安全性检测算法将试分配值恢复分配之前的值
    {
        int key = 0;
        for (j = 0; j < n; j++)       
        {
            if (Need[a][j] == 0)       //进程a尚需的各种资源如果全为0，释放资源
            {
                key++;
            }
        }
        if (key == n)                 
        {
            for (j = 0; j < n; j++)
            {
                Available[j] += Allocation[a][j];  
                Allocation[a][j] = 0;    //释放分配给的资源
            }
        }
    }
}  
void mainshow()
{                             //输出当前资源状态
    printf("\n\n");
    if (n == 3)
    {
        printf("          已分配       最大需求量       尚需要量 \n进程");
    }
    if (n == 2)
    {
        printf("       已分配   最大需求  尚需要量 \n进程");
    }for (i = 0; i < m; i++)
    {
        printf("\nP[%d]", i);
        for (j = 0; j < n; j++)
        {
            printf("  %2d ", Allocation[i][j]);
        }
        for (j = 0; j < n; j++)
        {
            printf("  %2d ", Max[i][j]);
        }
        for (j = 0; j < n; j++)
        {
            printf("  %2d ", Need[i][j]);
        }
    }
    printf("\n\n系统剩余资源量：   ");
    for (i = 0; i < n; i++)
    {
        printf("   %d ", Available[i]);
    }
    printf("\n");
}
void menu()
{
	printf("\n");
	printf("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*\n");
    printf("*-*-*-*-*-*-*  银行家算法         *-*-*-*-*-*-*\n");
    printf("*-*-*-*-*-*-*  1:初始化           *-*-*-*-*-*-*\n");
    printf("*-*-*-*-*-*-*  2:进程继续资源申请 *-*-*-*-*-*-*\n");
    printf("*-*-*-*-*-*-*  3:当前资源状态     *-*-*-*-*-*-*\n");
    printf("*-*-*-*-*-*-*  4:退出             *-*-*-*-*-*-*\n");
    printf("*-*-*-*-*-*-*  请输入你的选择:    *-*-*-*-*-*-*\n");
	printf("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*\n");
}
int main()
{
    int key = 0;
    printf("\n\n");
    while (1)
    {
        menu();
        scanf("%d", &key);
        printf("\n\n");
        switch (key)
        {
        case 1:
            initialize();
            break;
        case 2:
            mainrequest();
            break;
        case 3:
            mainshow();
            break;
        case 4:
            printf("*-*-*-*-*-*-*  程序结束，再见！    *-*-*-*-*-*-*\n");
            system("pause");
            return 0;
        }
  
    }
    system("pause");
    return 0;
}