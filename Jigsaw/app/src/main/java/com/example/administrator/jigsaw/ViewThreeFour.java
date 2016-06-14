package com.example.administrator.jigsaw;

//生成一个“3*4”的“View”并返回给“MainActivity”
//接收“MainActivity”传过来的乱序数组进行初始化

import android.widget.ImageButton;
import android.view.View;

public class ViewThreeFour extends MidView{

    private static final int viewNumber=12;

    public ViewThreeFour(ImageButton[]imageButton, int[] cutNum, int[] imageId){
        super(imageButton,cutNum,imageId,viewNumber);
    }

    @Override
    public void onClick(View buttonView){
        if(judgeNum){
            for (int i = 0; i < viewNumber; i++)
                if (buttonView.getId() == allButton[i].getId()) {
                    changeButton(i / 3, i % 3);
                    break;
                }
            checkImage();
        }
    }

    @Override
    protected void changeButton(int xNum,int yNum){
        unFillNumX=unFillNum/3;
        unFillNumY=unFillNum%3;

        if((xNum==unFillNumX)&&((yNum==unFillNumY+1)||(yNum==unFillNumY-1))){
            switchNum(xNum*3+yNum,unFillNum);
            switchImage(xNum*3+yNum,unFillNum);
        }

        if((yNum==unFillNumY)&&((xNum==unFillNumX+1)||(xNum==unFillNumX-1))){
            switchNum(xNum*3+yNum,unFillNum);
            switchImage(xNum*3+yNum,unFillNum);
        }
    }
}