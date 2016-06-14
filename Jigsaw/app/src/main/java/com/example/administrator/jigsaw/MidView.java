package com.example.administrator.jigsaw;

//生成一个“3*4”的“View”并返回给“MainActivity”
//接收“MainActivity”传过来的乱序数组进行初始化

import android.view.View;
import android.widget.ImageButton;

public class MidView implements View.OnClickListener{

    protected static  int imgSumation;
    protected static  int lastImage;
    protected boolean judgeNum;

    protected ImageButton[] allButton;
    protected int[] childCutNum;
    protected int[] allImage;

    protected int unFillNumX;
    protected int unFillNumY;
    protected int unFillNum;

    public MidView(ImageButton[] imageButton, int[] cutNum, int[] imageId, int imgNumber){

        imgSumation=imgNumber;
        lastImage=imgNumber-1;
        judgeNum=true;

        for(int i=0;i<imgSumation;i++){                                         //最后一位设为移动块
            if(cutNum[i]==0){
                imageButton[i].setBackgroundResource(R.drawable.jg_back);
                unFillNum=i;
            } else
                imageButton[i].setBackgroundResource(imageId[cutNum[i]-1]);

            imageButton[i].setOnClickListener(this);
        }

        allButton=imageButton;
        childCutNum=cutNum;
        allImage=imageId;

        unFillNumX=0;
        unFillNumY=0;
    }

    public void onClick(View buttonView){
        //设置按钮响应事件
    }

    protected void changeButton(int xNum,int yNum){
        //找出符合条件的变换按钮
    }

    protected void switchNum(int dataOne,int dataTwo){                          //两个变量间值的交换
        childCutNum[dataOne]=childCutNum[dataOne]+childCutNum[dataTwo];
        childCutNum[dataTwo]=childCutNum[dataOne]-childCutNum[dataTwo];
        childCutNum[dataOne]=childCutNum[dataOne]-childCutNum[dataTwo];
    }

    protected void switchImage(int baseNum,int targetNum){
        allButton[baseNum].setBackgroundResource(R.drawable.jg_back);
        allButton[targetNum].setBackgroundResource(allImage[childCutNum[targetNum]-1]);
        //值已发生改变
        unFillNum=baseNum;
    }

    protected void checkImage(){                                                //检查是否已完成拼图
        judgeNum=false;

        for(int i=0;i<imgSumation-1;i++)
            if(childCutNum[i]!=(i+1)){
                judgeNum=true;
                break;
            }

        if(!judgeNum)
            allButton[lastImage].setBackgroundResource(allImage[lastImage]);
    }
}