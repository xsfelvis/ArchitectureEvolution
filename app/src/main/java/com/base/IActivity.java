package com.base;

import android.content.Intent;

/**
 * Author: xushangfei
 * Time: created at 2017/5/21.
 * Description:
 */

public interface IActivity {

    /**
     * 处理Intent
     * @param intent
     */
    void handleIntent(Intent intent);

    /**
     * 准备MVP模型中的P
     * 要求在handleIntent()之后，onCreate()之前调用
     */
    void preparePresenter();



}
