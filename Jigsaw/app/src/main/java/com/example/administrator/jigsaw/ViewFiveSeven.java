package com.example.administrator.jigsaw;

//生成一个“6*7”的“View”并返回给“MainActivity”
//接收“MainActivity”传过来的乱序数组进行初始化

import android.widget.ImageButton;
import android.view.View;

public class ViewFiveSeven extends MidView{

    private static final int viewNumber=42;

    public ViewFiveSeven(ImageButton[]imageButton, int[] cutNum, int[] imageId){
        super(imageButton,cutNum,imageId,viewNumber);
    }

    @Override
    public void onClick(View buttonView){
        if(judgeNum){
            for(int i=0;i<viewNumber;i++)
                if(buttonView.getId()==allButton[i].getId()){
                    changeButton(i/6,i%6);
                    break;
                }
            checkImage();
        }
    }

    @Override
    protected void changeButton(int xNum,int yNum){
        unFillNumX=unFillNum/6;
        unFillNumY=unFillNum%6;

        if((xNum==unFillNumX)&&((yNum==unFillNumY+1)||(yNum==unFillNumY-1))){
            switchNum(xNum*6+yNum,unFillNum);
            switchImage(xNum*6+yNum,unFillNum);
        }

        if((yNum==unFillNumY)&&((xNum==unFillNumX+1)||(xNum==unFillNumX-1))){
            switchNum(xNum*6+yNum,unFillNum);
            switchImage(xNum*6+yNum,unFillNum);
        }
    }
}