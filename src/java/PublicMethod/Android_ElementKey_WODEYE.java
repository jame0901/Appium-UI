package PublicMethod;

public enum Android_ElementKey_WODEYE {

    //我的页面
    Android_WODE_DENGLULAN("//android.widget.TextView[@resource-id='com.xes.jazhanghui.activity:id/tv_user_center_top_name']");

    private String element = null;

    private Android_ElementKey_WODEYE(String element) {
        this.element = element;
    }

    public void setElement(String element){
        this.element = element;
    }

    public String getElement() {
        return element;
    }
}
