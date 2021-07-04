package com.atguigu.principle.inversion.improve;

public class DependecyInversion {
    public static void main(String[] args) {
        //客户端无需改变
        Person person = new Person();
        person.receive(new Email());
        person.receive(new WeiXin());
    }
}

//定义接口
interface IReceiver {
    public String getInfo();
}

class Email implements IReceiver {
    @Override
    public String getInfo() {
        return "电子邮件信息: hello,world";
    }
}

//增加微信
class WeiXin implements IReceiver {
    @Override
    public String getInfo() {
        return "微信信息: hello,ok";
    }
}

class Person {
    public void receive(IReceiver receiver ) {
        System.out.println(receiver.getInfo());
    }
}
