
    #include<stdio.h>
#include <unistd.h>
#include<string.h>
#include<stdlib.h>
#include <sys/types.h>

            #define MAX_LINE 80
    int input(char* str);
    int args(char* str, char* args[], int n);
    void print(int front,int rear);
    void History(char* str, int* front, int* rear);

    char history[10][MAX_LINE];

    int getCmd(char* str){
        char c;
        int i = 0;
        while((c = getchar())!='\n' && i < MAX_LINE){
            str[i] = c;
            i++;
        }
        //超出输入最大长度
        if(i == MAX_LINE && c != '\n'){
            printf("over maximum length!");
            return 0;
        }
        else{
            str[i] = '\0';
            return i;
        }
    }

    int getArgs(char* str,char* args[]){
	const char s[2] = " ";
        int i = 0;
        char* temp;
        //用空格分解字符串
        temp = strtok(str,s);
        while(temp != NULL){
            args[i] = (char*)malloc(strlen(temp));
            strcpy(args[i],temp);
            i++;
            temp = strtok(NULL,s);
        }
        args[i] = '\0';
        return i;
    }
    void print(int front,int rear){
        int i;
        for( i = front;i < rear;i++){
            printf("%d\t%s\n",rear - i,history[i%10]);
        }
    }

    void History(char* str, int* front, int* rear){
        //添加历史命令到队尾
        strcpy(history[*rear % 10],str);
	*rear = *rear+1;
        if(*rear - *front > 10){
		*front++;
        }
    }

    int main(void){
        char* args[MAX_LINE/2+1];//命令行参数
        int should_run = 1;
        int args_num = 0;
        //用户输入的命令
        char cmd[MAX_LINE];
        int n;

        int front = 0;
        int rear = 0;

        int i = 0;
        int flag = 0;
        int pid_status;

        while(should_run){
            //设置提示符
            printf("2018800658@OS2021$>");
            fflush(stdout);

            n = getCmd(cmd);

            if(n == 0){
                continue;
            }
            //输入exit则退出
            if(strcmp(cmd,"exit")== 0){
                should_run = 0;
                continue;
            }
            //列出历史功能
            if(strcmp(cmd,"history") == 0){
                print(front,rear);
            }
            //执行最近的历史命令
            if(strcmp(cmd,"!!") == 0){
                if(rear != 0){
                    strcpy(cmd,history[(rear -1) % 10]);
                    n = strlen(cmd);
                }
                else{
                    printf("No commands in history.\n");
                }
            }
            //使用第N个历史命令
            else if(cmd[0] == '!'){
                if(cmd[1] <= '0' || cmd[1] > '9' || (cmd[1]-'0') > rear-front){
                    printf("No such command in history.\n");
                }
                else if(cmd[1] == '1'){
                    //第10个历史命令
                    if(cmd[2] == '0')
                        strcpy(cmd,history[front %10]);
                        //第1个历史命令
                    else if(cmd[2] == '\0')
                        strcpy(cmd,history[(rear-1) %10]);
                    else
                        printf("No such command in history.\n");
                }
                //第2-8个历史命令
                else
                    strcpy(cmd,history[rear - cmd[1] + '0']);
            }

            History(cmd,&front,&rear);

            args_num = getArgs(cmd,args);
            //存在&
            if(strcmp(args[args_num-1],"&") == 0){
                flag = 1;
                args_num--;
                args[args_num] = NULL;
            }
            //创建子进程
            pid_t pid = fork();
            if(pid == 0){
                pid_status = execvp(args[0], args);
            }
            else{
                if(flag == 1){
                    //父进程和子进程并发执行
                    printf("%d 进程启动成功 %s \n");
                          // printf("%d 进程启动成功 %s \n",pid,cmd);

                }
                else{
                    //父进程等待子进程退出
                    wait(&pid_status);
                }
            }
            //将标志位归0
            flag  = 0;
        }
        return 0;
    }
