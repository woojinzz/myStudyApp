package com.kwj.mystudyapp;

public class Ex20FriendsItem {
    String name;
    String hp;
    String sex;
    String addr;
    int age;
    Ex20FriendsItem(String name, String hp, String sex, String addr, int age)
    {
        this.name = name;
        this.hp = hp;
        this.sex = sex;
        this.addr = addr;
        this.age = age;
    }
    void setName (String name) {  this.name = name;  }
    String getName(){   return name;  }
    void setHp (String name) {  this.hp = hp;  }
    String getHp(){   return hp;  }
    void setSex (String name) {  this.sex = sex;  }
    String getSex(){   return sex;  }
    void setAddr (String name) {  this.addr = addr;  }
    String getAddr(){   return addr;  }
    void setAge (String name) {  this.age = age;  }
    int getAge(){   return age;  }
}
