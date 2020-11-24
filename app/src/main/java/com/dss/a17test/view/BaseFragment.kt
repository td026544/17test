package com.dss.a17test.view

import androidx.fragment.app.Fragment

abstract  class BaseFragment:Fragment() {

    protected abstract fun initView()
    protected abstract fun observe()


}