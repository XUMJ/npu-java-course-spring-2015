/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tw.edu.npu.mis;

import java.awt.event.ActionEvent;

/**
 *
 * @author STP
 */
public class Controller {
    
        private  Calculator  mCal;
        private View mView;
        
        /**
         * 加入 Model
         * @param m 傳入 Model
         */
        public void Model(Calculator m){
		this.mCal = m;
	}
    
        /**
         * 加入View
         * @param v 傳入 View
         */
        public void View(View v){
		this.mView = v;
	}

   
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}