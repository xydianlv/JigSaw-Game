# JigSaw-Game
##简易拼图游戏
1. “MainActivity”为主类，负责各组件的初始化，并承担将负责不同功能的对象组合到一起；  
2. “MidView”为“ViewThreeFour、ViewFiveSeven、ViewSevenTen”的父类，实现“View.OnClickListener接口，其子类对其方法“OnClick”进行重写，
   构造适用于不同模式的相应方式，并将获得的响应值传递给父类的“checkList”函数，判断图片是否已完成正确排列；  
3. “ButtonId”与“ImageId”通过“Static”方法，由传递进来的参数决定向外部提供的“Id”数组；  
4. “CutNum”负责为每种模式生成相应的可解（有限的移动次数后可完成拼图）的乱序数组，并传递给“MidView”子类的构造函数，生成不同的模式
   排列对象；  
5. “GuideView”为“游戏指南”生成类，依照单例模式构建，只需要进行一次初始化；  
6. “SelectView”生成包含提供不同图片选择的区域对象，接收来自“ImageId、ButtonId”传来的“Id”数组初始化该类对象
