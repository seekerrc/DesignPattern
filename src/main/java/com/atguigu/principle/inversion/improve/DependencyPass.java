package com.atguigu.principle.inversion.improve;

public class DependencyPass {
    
//    public static void main(String[] args) {
//        // TODO Auto-generated method stub
//        ChangHong changHong = new ChangHong();
//        //		OpenAndClose openAndClose = new OpenAndClose();
//        //		openAndClose.open(changHong);
//
//        //通过构造器进行依赖传递
//        //		OpenAndClose openAndClose = new OpenAndClose(changHong);
//        //		openAndClose.open();
//        //通过setter方法进行依赖传递
//        OpenAndClose openAndClose = new OpenAndClose();
//        openAndClose.setTv(changHong);
//        openAndClose.open();
//
//    }
    
}

// 方式1： 通过接口传递实现依赖
interface IOpenAndClose {
    public void open(ITV tv);
}

interface ITV {
    public void play();
}

class OpenAndClose implements IOpenAndClose {
    @Override
    public void open(ITV tv) {
        tv.play();
    }
}

class ChangHong implements ITV {
    @Override
    public void play() {
//        System.out.println("长虹电视机，打开");
        System.out.println();
    }
}
// 方式2: 通过构造方法依赖传递
//interface IOpenAndClose {
//    public void open(); //抽象方法
//}
//
//interface ITV { //ITV接口
//    public void play();
//}
//
//class OpenAndClose implements IOpenAndClose {
//    public ITV tv; //成员
//
//    public OpenAndClose(ITV tv) { //构造器
//        this.tv = tv;
//    }
//    @Override
//    public void open() {
//        this.tv.play();
//    }
//}
//
//class ChangHong implements ITV {
//    @Override
//    public void play() {
//        System.out.println("长虹电视机，打开");
//    }
//}


// 方式3 , 通过setter方法传递
//interface IOpenAndClose {
//    public void open(); // 抽象方法
//    public void setTv(ITV tv);
//}
//
//interface ITV { // ITV接口
//    public void play();
//}
//
//class OpenAndClose implements IOpenAndClose {
//    private ITV tv;
//
//    @Override
//    public void setTv(ITV tv) {
//        this.tv = tv;
//    }
//    @Override
//    public void open() {
//        this.tv.play();
//    }
//}
////
//class ChangHong implements ITV {
//    @Override
//    public void play() {
//        System.out.println("长虹电视机，打开");
//    }
//}