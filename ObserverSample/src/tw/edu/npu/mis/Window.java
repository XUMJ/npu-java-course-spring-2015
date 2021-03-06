/*
 * Copyright (c) 2015, Samael Wang <freesamael@gmail.com>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * * Redistributions of source code must retain the above copyright notice, this
 *   list of conditions and the following disclaimer.
 * * Redistributions in binary form must reproduce the above copyright notice,
 *   this list of conditions and the following disclaimer in the documentation
 *   and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 */
package tw.edu.npu.mis;

import java.util.ArrayList;
import java.util.List;

/**
 * Simulate Window objects in GUI toolkits.
 *
 * @author Samael Wang <freesamael@gmail.com>
 */
public class Window {

    private Controller mController;
    private List<View> mInvalidViews;

    /**
     * 啟動事件 使它循環
     * @param c 給控制元件命名.
     * @param views 給予views利用第一個循環 
     */
    public void startEventLoop(Controller c, List<View> views) {
        mController = c;
        mInvalidViews = new ArrayList<>(views);

       /**
        * 模擬一個事件環如何工作 .
        */
            while (true) {
            mController.readInput();
            for (View v : mInvalidViews) {
                v.onDraw();
            }
            mInvalidViews.clear();
        }
    }

    /**
     *新增 view 讓 queue 重劃在稍後螢幕上顯示 
     * @param v View to redraw.
     */
    public void schduleRedraw(View v) {
        mInvalidViews.add(v);
    }
}
