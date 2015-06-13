/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tw.edu.npu.mis;

import java.util.Observable;


/**
 * The model class of the calculator application.
 *//**
  * 
  * @author STP
  * 
  */
public class Calculator extends Observable{
    String mNb ="";//目前運算結果
    String mRemeber;//判斷目前加減乘除
    String z ="0";
    double x,y;//給予兩個值,計算用
    /**
     * The available operators of the calculator.
     */
    public enum Operator {
        CLEAR,       // C
        CLEAR_ENTRY, // CE
        BACKSPACE,   // ⌫
        EQUAL,       // =
        PLUS,        // +
        MINUS,       // -
        TIMES,       // ×
        OVER,        // ⁄
        PLUS_MINUS,  // ±
        RECIPROCAL,  // 1/x
        PERCENT,     // %
        SQRT,        // √
        MEM_CLEAR,   // MC
        MEM_SET,     // MS
        MEM_PLUS,    // M+
        MEM_MINUS,   // M-
        MEM_RECALL   // MR
    }
    /**
     * 這裏做數字的輸入，數字顯示
     * @param digit 
     */
    public void appendDigit(int digit) {
      mNb += String.valueOf(digit);
      getDisplay();   
    }
    
    public void appendDot() {
        // TODO code application logic here
    }
    /**
     * * 所有運算方法加減乘除的地方
     * @param operator 
     */
    public void performOperation(Operator operator) {
        switch(operator){
        case PLUS:
                x = Integer.parseInt(mNb);
                mNb = "";
                mRemeber = "+";      
                break;
        case MINUS:
                x = Integer.parseInt(mNb);
                mNb = "";
                mRemeber = "-";
                break;
        case TIMES:
                x = Integer.parseInt(mNb);
                mNb = "";
                mRemeber = "*";
                break;
        case OVER:
                x = Integer.parseInt(mNb);
                mNb = "";
                mRemeber = "/";
                break;
        case CLEAR:

              getDisplay();
              mNb = "";
              mRemeber = "";
              break;
            
                case EQUAL:
                    if("+".equals(mRemeber))
                    {
                        y = Integer.parseInt(mNb);
                        mNb = String.valueOf(x+y);
                        getDisplay();
                        mNb= "";
                    }
                     if("-".equals(mRemeber))
                    {
                        y = Integer.parseInt(mNb);
                        mNb = String.valueOf(x-y);
                        getDisplay();
                        mNb= "";
                    }
                     if("*".equals(mRemeber))
                    {
                        y = Integer.parseInt(mNb);
                        mNb = String.valueOf(x*y);
                        getDisplay();
                        mNb= "";
                    }
                     if("/".equals(mRemeber))
                    {
                        y = Integer.parseInt(mNb);
                        mNb = String.valueOf(x/y);
                        getDisplay();
                        mNb= "";
                    }
                     
                break;
                   
        }
        // TODO code application logic here
    }
    /**
     * 更新回傳值
     * @return 
     */
    public String getDisplay() {
        // TODO code application logic here
        setChanged();
        notifyObservers(mNb);
        return mNb;
    }
   /**
    * 依傳過來的運算符號來判斷執行哪一種運算符號的程式
    * @param d 
    */
    public void process(String d)
    {
        if("+".equals(d)) performOperation(Operator.PLUS);
        if("-".equals(d)) performOperation (Operator.MINUS);
        if("*".equals(d)) performOperation (Operator.TIMES);
        if("/".equals(d)) performOperation (Operator.OVER);
        if("=".equals(d)) performOperation(Operator.EQUAL);
        if("C".equals(d)) performOperation(Operator.CLEAR);
    }
}
