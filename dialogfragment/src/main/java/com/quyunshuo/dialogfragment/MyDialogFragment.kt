package com.quyunshuo.dialogfragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment

/**
 * @Author: MiYan
 * @Time: 2019/8/2 14:33
 * @Description: 描述：
 */
class MyDialogFragment : DialogFragment() {
    //onCreateView
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view = inflater.inflate(R.layout.set_name, container)
        return view
    }
}