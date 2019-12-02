package PublicMethod;

public enum Android_ElementKey_SHOUYE {

    //启动页
    Android_QIDONGYE_XUEERSIZHANGHAOMIMADENGLU("//android.widget.TextView[@resource-id='com.xes.jazhanghui.activity:id/tv_login_xes']"),
    Android_QIDONGYE_SHOUQUANTANCHUAN("\".//*[@text='始终允许']\""),
    //隐私协议页
    Android_YINSIXIEYIYE_TONGYIANNIU("//android.widget.TextView[@resource-id='com.xes.jazhanghui.activity:id/btn_sure']"),
    //首页
    Android_SHOUYE_WODEANNIU("//android.widget.LinearLayout/android.view.View[3]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]"),
//    Android_SHOUYE_WODEANNIU("//android.widget.LinearLayout/android.view.View[3]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.ImageView[1]"),
    //登录页
    Android_DENGLUYE_MIMADENGLUANNIU("//android.widget.TextView[@resource-id='com.xes.jazhanghui.activity:id/login_change']"),
    Android_DENGLUYE_ZHANGHAOSHURUKUANG("//android.widget.EditText[@resource-id='com.xes.jazhanghui.activity:id/xes_login_username']"),
    Android_DENGLUYE_MIMASHURUKUANG("//android.widget.EditText[@resource-id='com.xes.jazhanghui.activity:id/xes_login_password']"),
    Android_DENGLUYE_DENGLUANNIU("//android.widget.Button[@resource-id='com.xes.jazhanghui.activity:id/xes_login_button']"),
    Android_DENGLUYE_CHENGSHIBUYIZHIZHIDAOLEANNIU("//android.widget.Button[@resource-id='com.xes.jazhanghui.activity:id/btn_dialog_only']"),
    //弹窗
    Android_TANCHUANG_QUEDING("//android.widget.Button[@resource-id='com.xes.jazhanghui.activity:id/btn_dialog_ok']"),
    Android_TANCHUANG_BUQUEDING("//android.widget.Button[@resource-id='com.xes.jazhanghui.activity:id/btn_dialog_cancel']");

    private String element = null;

    private Android_ElementKey_SHOUYE(String element) {
        this.element = element;
    }

    public void setElement(String element){
        this.element = element;
    }

    public String getElement() {
        return element;
    }
}
