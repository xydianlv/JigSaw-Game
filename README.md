# JigSaw-Game
##简易拼图游戏

###功能描述  
![][jigsaw_one]
#####图一
>APP启动界面，两秒后跳转到初始的“3*4”界面，右下角为“游戏指南”按钮，点开后呈现给用户的指南界面；  

![][jigsaw_two]
#####图二
>点击左下角图片按钮提供更多的图片选择，该图片按钮既是一个选择按钮，又具有拼图过程中的提示功能；  

![][jigsaw_three]

#####图三
>切换到“6*7”并选择另一图片；

![][jigsaw_five]

#####图四
>点击中间的红色圆形按钮可进行“3*4、6*7、8*9”的模式切换，并且每个模式下提供不同的图片选择；  

>“新游戏”按钮接收“CutNum”传来的新一组乱序数组对当前图片进行重新排列；  

###项目结构  
![][jigsaw_four]

1. “MainActivity”为主类，负责各组件的初始化，并承担将负责不同功能的对象组合到一起；  

2. “MidView”为“ViewThreeFour、ViewFiveSeven、ViewSevenTen”的父类，实现“View.OnClickListener接口，其子类对其方法“OnClick”进行重写，
   构造适用于不同模式的相应方式，并将获得的响应值传递给父类的“checkList”函数，判断图片是否已完成正确排列；  

3. “ButtonId”与“ImageId”通过“Static”方法，由传递进来的参数决定向外部提供的“Id”数组；  

4. “CutNum”负责为每种模式生成相应的可解（有限的移动次数后可完成拼图）的乱序数组，并传递给“MidView”子类的构造函数，生成不同的模式
   排列对象；  

5. “GuideView”为“游戏指南”生成类，依照单例模式构建，只需要进行一次初始化；  

6. “SelectView”生成包含提供不同图片选择的区域对象，接收来自“ImageId、ButtonId”传来的“Id”数组初始化该类对象；  


--------------------------------
[jigsaw_one]:https://github.com/xydianlv/AllImages/raw/master/Image/jigsaw/jigsaw_gifo.jif
[jigsaw_two]:https://github.com/xydianlv/AllImages/raw/master/Image/jigsaw/jigsaw_gift.jif
[jigsaw_three]:https://github.com/xydianlv/AllImages/raw/master/Image/jigsaw/jigsaw_gifh.jif
[jigsaw_five]:https://github.com/xydianlv/AllImages/raw/master/Image/jigsaw/jigsaw_giff.jif
[jigsaw_four]:https://github.com/xydianlv/AllImages/raw/master/Image/jigsaw/jigsaw_four.png
