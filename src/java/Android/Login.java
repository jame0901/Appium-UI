package Android;

import PublicMethod.*;
import org.junit.Test;

public class Login extends AppiumTool{

    String string;
    TimeLog tl = new TimeLog();

    //登录后判断用户触发的弹窗逻辑
    public void login_judge()throws Exception{
        //判断是否出现城市不一致弹窗
        string = locationElement("str4",ElementKey_SHOUYE.Android_DENGLUYE_CHENGSHIBUYIZHIZHIDAOLEANNIU.getElement(),1000,"4",1);
        if(!string.equals("4")){
            clcikElements(ElementKey_SHOUYE.Android_DENGLUYE_CHENGSHIBUYIZHIZHIDAOLEANNIU.getElement(),100,1);
        }else {
            tl.insertLog("未找到城市不一致弹窗中的“知道了”按钮");
        }
        //判断是否出现精品课弹窗或者未绑定手机号弹窗
        string = locationElement("str5",ElementKey_SHOUYE.Android_TANCHUANG_BUQUEDING.getElement(),1000,"5",1);
        if (!string.equals("5")){
            clcikElements(ElementKey_SHOUYE.Android_TANCHUANG_BUQUEDING.getElement(),100,1);
        }else {
            tl.insertLog("未找到精品课弹窗或者未绑定手机号弹窗");
        }
        //判断是否出现精品课弹窗或者未绑定手机号弹窗
        string = locationElement("str6",ElementKey_SHOUYE.Android_TANCHUANG_BUQUEDING.getElement(),1000,"6",1);
        if (!string.equals("6")){
            clcikElements(ElementKey_SHOUYE.Android_TANCHUANG_BUQUEDING.getElement(),100,1);
        }else {
            tl.insertLog("未找到精品课弹窗或者未绑定手机号弹窗");
        }
    }

    //启动页到登录
    public void  login_One()throws Exception{

        clcikElements(ElementKey_SHOUYE.Android_QIDONGYE_XUEERSIZHANGHAOMIMADENGLU.getElement(),1000,1);
        tl.insertLog("进入快捷登录页");
        clcikElements(ElementKey_SHOUYE.Android_DENGLUYE_MIMADENGLUANNIU.getElement(),1000,1);
        tl.insertLog("进入账号密码登录页");
        sendKey(ElementKey_SHOUYE.Android_DENGLUYE_ZHANGHAOSHURUKUANG.getElement(),"194010046621",1000,1);
        tl.insertLog("输入账号");
        sendKey(ElementKey_SHOUYE.Android_DENGLUYE_MIMASHURUKUANG.getElement(),"123456",1000,1);
        tl.insertLog("输入密码");
        clcikElements(ElementKey_SHOUYE.Android_DENGLUYE_DENGLUANNIU.getElement(),1000,1);
        tl.insertLog("登录账号");
    }

    //首页到登录
    public void login_Two()throws Exception{

        clcikElements(ElementKey_SHOUYE.Android_SHOUYE_WODEANNIU.getElement(),1000,1);
        tl.insertLog("跳转至我的页面");
        clcikElements(ElementKey_WODEYE.Android_WODE_DENGLULAN.getElement(),1000,1);
        tl.insertLog("我的页面跳转登录页");
        clcikElements(ElementKey_SHOUYE.Android_DENGLUYE_MIMADENGLUANNIU.getElement(),1000,1);
        tl.insertLog("进入账号密码登录页");
        sendKey(ElementKey_SHOUYE.Android_DENGLUYE_ZHANGHAOSHURUKUANG.getElement(),"194010046621",1000,1);
        tl.insertLog("输入账号");
        sendKey(ElementKey_SHOUYE.Android_DENGLUYE_MIMASHURUKUANG.getElement(),"123456",1000,1);
        tl.insertLog("输入密码");
        clcikElements(ElementKey_SHOUYE.Android_DENGLUYE_DENGLUANNIU.getElement(),1000,1);
        tl.insertLog("登录账号");

    }

    //隐私协议页到登录
    public void login_Three()throws Exception{

        clcikElements(ElementKey_SHOUYE.Android_SHOUYE_WODEANNIU.getElement(),3000,1);
        tl.insertLog("跳转至我的页面");
        clcikElements(ElementKey_WODEYE.Android_WODE_DENGLULAN.getElement(),1000,1);
        tl.insertLog("我的页面跳转登录页");
        clcikElements(ElementKey_SHOUYE.Android_DENGLUYE_MIMADENGLUANNIU.getElement(),1000,1);
        tl.insertLog("进入账号密码登录页");
        sendKey(ElementKey_SHOUYE.Android_DENGLUYE_ZHANGHAOSHURUKUANG.getElement(),"194010046621",1000,1);
        tl.insertLog("输入账号");
        sendKey(ElementKey_SHOUYE.Android_DENGLUYE_MIMASHURUKUANG.getElement(),"123456",1000,1);
        tl.insertLog("输入密码");
        clcikElements(ElementKey_SHOUYE.Android_DENGLUYE_DENGLUANNIU.getElement(),1000,1);
        tl.insertLog("登录账号");

    }

    @Test
    //判断启动APP进入的场景执行不同用例
    public void login() throws Exception {

        setUp();
        Thread.sleep(3000);
        string = locationElement("tanchuang1",ElementKey_SHOUYE.Android_QIDONGYE_SHOUQUANTANCHUAN.getElement(),3000,"t1",1);
        if (!string.equals("t1")){
            clcikElements(ElementKey_SHOUYE.Android_QIDONGYE_SHOUQUANTANCHUAN.getElement(),3000,1);
        }
        string = locationElement("tanchuang2",ElementKey_SHOUYE.Android_QIDONGYE_SHOUQUANTANCHUAN.getElement(),3000,"t2",1);
        if (!string.equals("t2")){
            clcikElements(ElementKey_SHOUYE.Android_QIDONGYE_SHOUQUANTANCHUAN.getElement(),3000,1);
        }
        string = locationElement("str1",ElementKey_SHOUYE.Android_QIDONGYE_XUEERSIZHANGHAOMIMADENGLU.getElement(),1000,"1",1);
        if(!string.equals("1")){
            login_One();
        }else {
            tl.insertLog("没有找到登录页（账号登录）按钮");
        }
        string = locationElement("str2",ElementKey_SHOUYE.Android_SHOUYE_WODEANNIU.getElement(),1000,"2",1);
        if (!string.equals("2")){
            login_Two();
        }else {
            tl.insertLog("没有找到首页（我的）按钮");
        }
        string = locationElement("str3",ElementKey_SHOUYE.Android_YINSIXIEYIYE_TONGYIANNIU.getElement(),1000,"3",1);
        if (!string.equals("3")){
            clcikElements(ElementKey_SHOUYE.Android_YINSIXIEYIYE_TONGYIANNIU.getElement(),1000,1);
            tl.insertLog("点击同意按钮");
            string = locationElement("str1",ElementKey_SHOUYE.Android_QIDONGYE_XUEERSIZHANGHAOMIMADENGLU.getElement(),1000,"1",1);
            if(!string.equals("1")){
                login_One();
            }else {
                login_Three();
            }
        }else {
            tl.insertLog("没有找到隐私协议页（同意）按钮");
        }
        login_judge();
    }

}