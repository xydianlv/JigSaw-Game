package com.example.administrator.jigsaw;

import android.support.v7.app.AppCompatActivity;
import android.os.Handler;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ViewFlipper;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private static final String T_F_NUM="12";
    private static final String F_S_NUM="42";
    private static final String S_T_NUM="72";
    private static final int T_F_CREAT=12;
    private static final int F_S_CREAT=42;
    private static final int S_T_CREAT=72;
    private static final int M_B_NUM=6;
    private static int nowNumber=12;

    private ImageButton[] midButtons;                                           //参与拼图的图片按钮
    private ImageButton[] midButton;                                        //负责挑选图片的图片按钮
    public static int[] imagesId;                                        //挑选图片的那几张图片“ID”
    public static int[] imageId;                                               //参与拼图的图片“ID”
    private int[] buttonId;

    private LinearLayout im_b_tb_Layout;
    private LinearLayout guideLayout;
    private LinearLayout closeGuide;
    private LinearLayout t_b_Layout;
    private LinearLayout t_f_View;
    private LinearLayout f_s_View;
    private LinearLayout s_t_View;
    private ViewFlipper allFlipper;

    private static LinearLayout selectPicture;
    private static LinearLayout pictureView;
    private static ImageView viewOne;
    private static ImageView viewTwo;
    private static ImageView viewThree;
    private static ImageView viewFour;
    private static ImageView viewFive;
    private Button rightButtonB;
    private Button rightButton;
    private Button leftButtonB;
    private Button leftButton;
    private Button defaultButton;
    private Button cardButton;
    private Button decideButton;
    private Button guideButton;
    private Button closeGB;

    private static ImageButton imageButton;
    private Button switchButton;
    private Button t_f_Button;
    private Button f_s_Button;
    private Button s_t_Button;
    private Button newGame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageId=ImageId.reImageId(T_F_CREAT);
        creatView(T_F_CREAT);
        welcomeDelay();

        im_b_tb_Layout=(LinearLayout)findViewById(R.id.im_b_tb_layout) ;
        t_b_Layout=(LinearLayout)findViewById(R.id.three_button_layout) ;
        guideLayout=(LinearLayout)findViewById(R.id.guide_layout);
        closeGuide=(LinearLayout)findViewById(R.id.close_guide_layout);

        pictureView=(LinearLayout)findViewById(R.id.picture_view);
        selectPicture=(LinearLayout)findViewById(R.id.select_picture_button);
        leftButton=(Button)findViewById(R.id.close_picture_one);
        rightButton=(Button)findViewById(R.id.close_picture_two);
        leftButtonB=(Button)findViewById(R.id.close_picture_three);
        rightButtonB=(Button)findViewById(R.id.close_picture_four);
        viewOne=(ImageView)findViewById(R.id.image_view_one);
        viewTwo=(ImageView)findViewById(R.id.image_view_two);
        viewThree=(ImageView)findViewById(R.id.image_view_three);
        viewFour=(ImageView)findViewById(R.id.image_view_four);
        viewFive=(ImageView)findViewById(R.id.image_view_five);

        t_f_View=(LinearLayout) findViewById(R.id.three_four_view) ;
        f_s_View=(LinearLayout) findViewById(R.id.five_seven_view) ;
        s_t_View=(LinearLayout) findViewById(R.id.seven_ten_view) ;
        setStartVisible();

        imageButton=(ImageButton)findViewById(R.id.image_button);
        switchButton=(Button)findViewById(R.id.switch_button);
        t_f_Button=(Button)findViewById(R.id.t_f_button);
        f_s_Button=(Button)findViewById(R.id.f_s_button);
        s_t_Button=(Button)findViewById(R.id.s_t_button);
        newGame=(Button)findViewById(R.id.new_game);
        guideButton=(Button)findViewById(R.id.guide_button);
        closeGB=(Button)findViewById(R.id.close_guide) ;

        switchButton.setOnClickListener(this);
        t_f_Button.setOnClickListener(this);
        f_s_Button.setOnClickListener(this);
        s_t_Button.setOnClickListener(this);
        newGame.setOnClickListener(this);
        guideButton.setOnClickListener(this);
        closeGB.setOnClickListener(this);

        leftButton.setOnClickListener(this);
        rightButton.setOnClickListener(this);
        imageButton.setOnClickListener(this);
        leftButtonB.setOnClickListener(this);
        rightButtonB.setOnClickListener(this);
    }

    private void creatView(int data){
        buttonId=ButtonId.reButtonId(data);
        midButtons=new ImageButton[data];
        nowNumber=data;

        for(int i=0;i<data;i++)
            midButtons[i]=(ImageButton)findViewById(buttonId[i]);

        switch (data){
            case T_F_CREAT:
                new ViewThreeFour(midButtons,CutNum.returnNum(data),imageId);
                break;
            case F_S_CREAT:
                new ViewFiveSeven(midButtons,CutNum.returnNum(data),imageId);
                break;
            case S_T_CREAT:
                new ViewSevenTen(midButtons,CutNum.returnNum(data),imageId);
                break;
        }
    }

    private void creatSelectView(int data){
        defaultButton=(Button)findViewById(R.id.default_button);
        decideButton=(Button)findViewById(R.id.decide_picture);
        cardButton=(Button)findViewById(R.id.card_button);

        buttonId=ButtonId.reButtonId(M_B_NUM);
        imagesId=ImageId.reImageId(data);
        midButton=new ImageButton[T_F_CREAT];

        for(int i=0;i<T_F_CREAT;i++)
            midButton[i]=(ImageButton)findViewById(buttonId[i]);

        new SelectView(midButton,midButtons,decideButton,defaultButton,cardButton);
    }

    private void welcomeDelay(){
        allFlipper = (ViewFlipper) findViewById(R.id.viewFlipper);

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
                getWindow().addFlags(WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN);
                allFlipper.setDisplayedChild(1);
            }
        }, 3000);
    }

    private void setStartVisible(){
        t_f_View.setVisibility(View.VISIBLE);
        f_s_View.setVisibility(View.INVISIBLE);
        s_t_View.setVisibility(View.INVISIBLE);
    }

    public void onClick(View buttonView){
        switch (buttonView.getId()){
            case R.id.switch_button:
                switchView();
                break;
            case R.id.t_f_button:
                t_f_Open();
                break;
            case R.id.f_s_button:
                f_s_Open();
                break;
            case R.id.s_t_button:
                s_t_Open();
                break;
            case R.id.new_game:
                creatView(nowNumber);
                break;
            case R.id.image_button:
                openView();
                break;
            case R.id.guide_button:
                controlGuide(View.VISIBLE);
                break;
            case R.id.close_guide:
                controlGuide(View.INVISIBLE);
                break;
            case R.id.close_picture_one:
            case R.id.close_picture_two:
            case R.id.close_picture_three:
            case R.id.close_picture_four:
                closeView();
                break;
        }
    }

    private void controlGuide(int visibleData){
        guideLayout.setVisibility(visibleData);
        closeGuide.setVisibility(visibleData);
        controlView(visibleData);
    }

    private void openView(){
        switch(nowNumber){
            case 12:
                creatSelectView(0);
                break;
            case 42:
                creatSelectView(1);
                break;
            case 72:
                creatSelectView(2);
                break;
        }
        selectView(View.VISIBLE);
    }

    public static void closeView(){
        selectView(View.INVISIBLE);
    }

    private static void selectView(int visibleData){
        pictureView.setVisibility(visibleData);
        selectPicture.setVisibility(visibleData);
        controlView(visibleData);
    }

    private static void controlView(int data){
        viewOne.setVisibility(data);
        viewTwo.setVisibility(data);
        viewThree.setVisibility(data);
        viewFour.setVisibility(data);
        viewFive.setVisibility(data);
    }

    private void switchView(){
        bottomCut(im_b_tb_Layout);
    }

    public static void setImageButtonBackground(int pictureId){                 //设置图片按钮的背景
        imageButton.setBackgroundResource(pictureId);
    }

    private void t_f_Open(){
        bottomCut(t_b_Layout);
        switchButton.setText(T_F_NUM);
        setImageButtonBackground(R.drawable.t_f_first);
        imageId=ImageId.reImageId(T_F_CREAT);
        numViewCut(t_f_View);
        creatView(T_F_CREAT);
    }

    private void f_s_Open(){
        bottomCut(t_b_Layout);
        switchButton.setText(F_S_NUM);
        setImageButtonBackground(R.drawable.f_s_first);
        imageId=ImageId.reImageId(F_S_CREAT);
        numViewCut(f_s_View);
        creatView(F_S_CREAT);
    }

    private void s_t_Open(){
        bottomCut(t_b_Layout);
        switchButton.setText(S_T_NUM);
        setImageButtonBackground(R.drawable.s_t_first);
        imageId=ImageId.reImageId(S_T_CREAT);
        numViewCut(s_t_View);
        creatView(S_T_CREAT);
    }

    private void bottomCut(LinearLayout layoutView){
        if(layoutView.equals(t_b_Layout)){
            im_b_tb_Layout.setVisibility(View.VISIBLE);
            t_b_Layout.setVisibility(View.INVISIBLE);
        }else{
            im_b_tb_Layout.setVisibility(View.INVISIBLE);
            t_b_Layout.setVisibility(View.VISIBLE);
        }
    }

    private void numViewCut(LinearLayout layoutView){
        f_s_View.setVisibility(View.INVISIBLE);
        t_f_View.setVisibility(View.INVISIBLE);
        s_t_View.setVisibility(View.INVISIBLE);
        layoutView.setVisibility(View.VISIBLE);
    }
}
