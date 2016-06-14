package com.example.administrator.jigsaw;

//点击左下角图片按钮后生成一个提供图片选择的“View”并返回

import android.widget.ImageButton;
import android.widget.Button;
import android.view.View;

public class SelectView implements View.OnClickListener{

    private static final String CLOSE_STR="X";
    private static final String CHOSE_STR="C";
    private static final int BUTTON_NUM=12;
    private static final int F_S_CREAT=42;
    private static final int S_T_CREAT=72;

    private int decidePicture;
    private int doubleNum;
    private int imageData;
    private int imageNum;
    private int choseId;

    private ImageButton[] selectButton;
    private ImageButton[] jigSawButton;
    private int[] imageId;

    private Button decideButton;
    private int jigSawLength;
//    private Button defaultButton;
//    private Button cardButton;

    public SelectView(ImageButton[] selectButtons,ImageButton[] jigSawButtons, Button decidePicture,
                      Button defaultButton,Button cardButton){

        jigSawLength=jigSawButtons.length;
        imageData=(jigSawLength/10)*10;
        imageId=MainActivity.imagesId;
        doubleNum=imageId.length*2;

        for(int i=0;i<doubleNum;i++){
            if(i%2==0) {
                selectButtons[i].setBackgroundResource(imageId[i/2]);
                selectButtons[i].setVisibility(View.VISIBLE);
            }else{
                selectButtons[i].setBackgroundResource(R.drawable.unchose_back_button);
                selectButtons[i].setVisibility(View.INVISIBLE);
            }
            selectButtons[i].setOnClickListener(this);
        }

        for(int i=doubleNum;i<BUTTON_NUM;i++){
            selectButtons[i].setVisibility(View.INVISIBLE);
        }

        decidePicture.setOnClickListener(this);
        defaultButton.setOnClickListener(this);
        cardButton.setOnClickListener(this);

        decidePicture.setAlpha((float)0.7);
        decidePicture.setText(CLOSE_STR);

 //       this.defaultButton=defaultButton;
 //       this.cardButton=cardButton;
        selectButton=selectButtons;
        jigSawButton=jigSawButtons;
        decideButton=decidePicture;
    }

    @Override
    public void onClick(View buttonView){
        switch(buttonView.getId()){
            case R.id.default_button:
                break;
            case R.id.card_button:
                break;
            case R.id.decide_picture:
                decideButtonChose();
                break;
            default:
                selectButtonFun(buttonView);
                break;
        }
    }

    private void decideButtonChose(){
        switch((String)decideButton.getText()){
            case CLOSE_STR:
                MainActivity.closeView();
                break;
            case CHOSE_STR:
                chosePicture();
                break;
        }
    }

    private void chosePicture(){
        MainActivity.setImageButtonBackground(decidePicture);
        imageId=ImageId.reButtonBackground(imageData);
        MainActivity.imageId=imageId;

        switch (jigSawLength){
            case BUTTON_NUM:
                new ViewThreeFour(jigSawButton,CutNum.returnNum(jigSawLength),imageId);
                break;
            case F_S_CREAT:
                new ViewFiveSeven(jigSawButton,CutNum.returnNum(jigSawLength),imageId);
                break;
            case S_T_CREAT:
                new ViewSevenTen(jigSawButton,CutNum.returnNum(jigSawLength),imageId);
                break;
        }

        MainActivity.closeView();
    }

    private void selectButtonFun(View buttonView){
        for(int i=0;i<doubleNum;i++)
            if(buttonView.getId()==selectButton[i].getId()) {
                if(i%2==0) {
                    decidePicture=imageId[i/2];
                    imageNum=i/2;
                    imageData=imageData+imageNum;
                    choseId = i + 1;
                    setBack();
                }else{
                    imageData=imageData-imageNum;
                    deleteBack();
                }
                break;
            }
    }

    private void setBack(){
        for(int i=0;i<doubleNum;i++)
            if(i%2!=0) {
                selectButton[i].setVisibility(View.VISIBLE);
                if(i==choseId)
                    selectButton[i].setBackgroundResource(R.drawable.chose_back_button);
            }

        decideButton.setText(CHOSE_STR);
        decideButton.setAlpha(1);
    }

    private void deleteBack(){
        for(int i=0;i<doubleNum;i++)
            if(i%2!=0){
                selectButton[i].setBackgroundResource(R.drawable.unchose_back_button);
                selectButton[i].setVisibility(View.INVISIBLE);
            }

        decideButton.setText(CLOSE_STR);
        decideButton.setAlpha((float)0.7);
    }

}