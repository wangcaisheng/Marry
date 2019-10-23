package com.csyj.kotlinmap

import com.billy.cc.core.component.CC
import com.billy.cc.core.component.CCResult
import com.billy.cc.core.component.CCUtil
import com.billy.cc.core.component.IComponent

class ComponentA : IComponent{
    override fun onCall(cc: CC?): Boolean {
        val actionName:String=cc!!.actionName
        when (actionName){
            "showActivity" ->{
                //跳转到页面：ActivityA
                CCUtil.navigateTo(cc, MapsActivity::class.java)
                //返回处理结果给调用方
                CC.sendCCResult(cc.getCallId(), CCResult.success())
                return true
            }
            else->{
                CC.sendCCResult(cc.getCallId(), CCResult.errorUnsupportedActionName())
                return false
            }


//        String actionName = cc.getActionName()
//        switch (actionName) {
//            case "showActivity": //响应actionName为"showActivity"的组件调用
//            //跳转到页面：ActivityA
//            CCUtil.navigateTo(cc, ActivityA.class)
//            //返回处理结果给调用方
//            CC.sendCCResult(cc.getCallId(), CCResult.success())
//            //同步方式实现（在return之前听过CC.sendCCResult()返回组件调用结果），return false
//            return false
//            default:
//            //其它actionName当前组件暂时不能响应，可以通过如下方式返回状态码为-12的CCResult给调用方
//            CC.sendCCResult(cc.getCallId(), CCResult.errorUnsupportedActionName());
//            return false;
        }
//    }
    }

    override fun getName(): String {
        return "ComponentA"
    }

}