
package tw.edu.npu.mis;


/**
 *
 * @author ASUS
 * implements obserer
 * 新增觀察者跟被觀察者
 */
public  class AlternativeView implements Observer {
    private final Model mModel;
    private boolean mIsValid;
   
    private final String mName;
    private final Window mWindow;
    private String s="";
    /**
     * AlternatioveView建構值
     * @param name
     * @param window
     * @param model 
     */
    public AlternativeView(String  name, Window window, Model model) {
        mName = name;
        mWindow = window;
        mModel = model;
        
    }
    /**
     *  功能檢查变量是否已经實例化
     * @return 
     */
    public boolean isValid() {
        return mIsValid;
    }
    /**
     * 用IF 迴圈SHOW秀出AlternativeView:
     * 多家EDUALS這段程式 讓她可以執行一次後 停止
     */
    public void show() {
        if(!s.equals(mModel.getData())){
        s = mModel.getData();
        System.out.print("AlternativeView: ");
        System.out.println(new StringBuilder(mModel.getData()).reverse());
        mIsValid = true;
    }
    }
   

    @Override
    /**
     * 結束後 更新 
     * 在一次執行SHOW
     */
    public void update() {
        show();
        //mIsValid = false;
    }
    }

