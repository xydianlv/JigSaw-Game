package com.example.administrator.jigsaw;


public class ButtonId {

    private static final int[] t_f_ButtonId={R.id.one_one_button,R.id.one_two_button,R.id.one_three_button,
            R.id.two_one_button,R.id.two_two_button,R.id.two_three_button,R.id.three_one_button,
            R.id.three_two_button,R.id.three_three_button,R.id.four_one_button,R.id.four_two_button,
            R.id.four_three_button};

    private static final int[] f_s_ButtonId={R.id.f_s_01,R.id.f_s_02,R.id.f_s_03,R.id.f_s_04,R.id.f_s_05,
            R.id.f_s_06,R.id.f_s_07,R.id.f_s_08,R.id.f_s_09,R.id.f_s_10,R.id.f_s_11,R.id.f_s_12,
            R.id.f_s_13,R.id.f_s_14,R.id.f_s_15,R.id.f_s_16,R.id.f_s_17,R.id.f_s_18,R.id.f_s_19,
            R.id.f_s_20,R.id.f_s_21,R.id.f_s_22,R.id.f_s_23,R.id.f_s_24,R.id.f_s_25,R.id.f_s_26,
            R.id.f_s_27,R.id.f_s_28,R.id.f_s_29,R.id.f_s_30,R.id.f_s_31,R.id.f_s_32,R.id.f_s_33,
            R.id.f_s_34,R.id.f_s_35,R.id.f_s_36,R.id.f_s_37,R.id.f_s_38,R.id.f_s_39,R.id.f_s_40,
            R.id.f_s_41,R.id.f_s_42};

    private static final int[] s_t_ButtonId={R.id.s_t_01,R.id.s_t_02,R.id.s_t_03,R.id.s_t_04,R.id.s_t_05,
            R.id.s_t_06,R.id.s_t_07,R.id.s_t_08,R.id.s_t_09,R.id.s_t_10,R.id.s_t_11,R.id.s_t_12,
            R.id.s_t_13,R.id.s_t_14,R.id.s_t_15,R.id.s_t_16,R.id.s_t_17,R.id.s_t_18,R.id.s_t_19,
            R.id.s_t_20,R.id.s_t_21,R.id.s_t_22,R.id.s_t_23,R.id.s_t_24,R.id.s_t_25,R.id.s_t_26,
            R.id.s_t_27,R.id.s_t_28,R.id.s_t_29,R.id.s_t_30,R.id.s_t_31,R.id.s_t_32,R.id.s_t_33,
            R.id.s_t_34,R.id.s_t_35,R.id.s_t_36,R.id.s_t_37,R.id.s_t_38,R.id.s_t_39,R.id.s_t_40,
            R.id.s_t_41,R.id.s_t_42,R.id.s_t_43,R.id.s_t_44,R.id.s_t_45,R.id.s_t_46,R.id.s_t_47,
            R.id.s_t_48,R.id.s_t_49,R.id.s_t_50,R.id.s_t_51,R.id.s_t_52,R.id.s_t_53,R.id.s_t_54,
            R.id.s_t_55,R.id.s_t_56,R.id.s_t_57,R.id.s_t_58,R.id.s_t_59,R.id.s_t_60,R.id.s_t_61,
            R.id.s_t_62,R.id.s_t_63,R.id.s_t_64,R.id.s_t_65,R.id.s_t_66,R.id.s_t_67,R.id.s_t_68,
            R.id.s_t_69,R.id.s_t_70,R.id.s_t_71,R.id.s_t_72};

    private static final int[] selectButton={R.id.one_select,R.id.one_select_back,R.id.two_select,
            R.id.two_select_back,R.id.three_select,R.id.three_select_back,R.id.four_select,
            R.id.four_select_back,R.id.five_select,R.id.five_select_back,R.id.six_select,
            R.id.six_select_back};

    private static final int[] buttonId={};

    public static int[] reButtonId(int data){
        switch(data) {
            case 12:
                return t_f_ButtonId;
            case 42:
                return f_s_ButtonId;
            case 72:
                return s_t_ButtonId;
            case 6:
                return selectButton;
            default:
                return buttonId;
        }
    }
}