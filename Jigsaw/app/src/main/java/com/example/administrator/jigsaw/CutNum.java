package com.example.administrator.jigsaw;

//生成一个随机数数组返回给“MainActivity”用作图片的乱序,由类名调用

import java.util.Random;

public class CutNum {

    private int[] cutNumber;
    private Random random;

    private static int inNum=0;
    private int midNum;
    private int data;

    private CutNum(int total){

        cutNumber=new int[total];
        random = new Random();
        midNum=total/2;

        for (int i = 0; i < total; i++)
            cutNumber[i]=i;

        for (total=total-1; total > 0; total--) {
            data=random.nextInt(total);
            switchData(total,data);
        }

        sumNumber();
        checkList(total);
    }

    private void checkList(int total){                   //检查该随机数列与“0”所在行列和是否为偶数

        for(int i=0;i<cutNumber.length;i++)
            if(cutNumber[i]==0)
                switch(total){
                    case 12:
                        data=i/3+i%3;
                        break;
                    case 42:
                        data=i/6+i%6;
                        break;
                    case 72:
                        data=i/8+i%8;
                        break;
                }

        if((inNum%2!=0)&&(data%2==0))
            switchZero();

        if((inNum%2==0)&&(data%2!=0))
            switchZero();

    }

    private void sumNumber(){                                                   //计算该数列的逆序数

        for(int total=0;total<cutNumber.length;total++)
            for(int i=0;i<total;i++)
                if(cutNumber[total]<cutNumber[i])
                    inNum++;
    }

    private void switchZero(){                          //交换数据位位置，使得逆序数与行列和满足要求

        if(cutNumber[midNum]!=0){
            if(cutNumber[midNum-1]!=0){
                switchData(midNum,midNum-1);
            }else{
                switchData(midNum,midNum+1);
            }
        }else{
            switchData(midNum-1,midNum-2);
        }
    }

    private void switchData(int dataOne,int dataTwo){                           //两个变量间值的交换
        cutNumber[dataOne]=cutNumber[dataOne]+cutNumber[dataTwo];
        cutNumber[dataTwo]=cutNumber[dataOne]-cutNumber[dataTwo];
        cutNumber[dataOne]=cutNumber[dataOne]-cutNumber[dataTwo];
    }

    public static int[] returnNum(int total){
        return new CutNum(total).cutNumber;
    }
}