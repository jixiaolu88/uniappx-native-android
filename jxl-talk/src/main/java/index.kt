@file:Suppress("UNCHECKED_CAST", "USELESS_CAST", "INAPPLICABLE_JVM_NAME")
package uts.sdk.modules.jxlTalk;
import android.app.Application;
import com.eduhdsdk.interfaces.JoinmeetingCallBack;
import com.eduhdsdk.interfaces.MeetingNotify;
import com.eduhdsdk.room.RoomClient;
import com.eduhdsdk.tools.FunctionSetManage;
import com.eduhdsdk.tools.ScreenScale;
import io.dcloud.uniapp.*;
import io.dcloud.uniapp.extapi.*;
import io.dcloud.uniapp.framework.*;
import io.dcloud.uniapp.runtime.*;
import io.dcloud.uniapp.vue.*;
import io.dcloud.uniapp.vue.shared.*;
import io.dcloud.uts.*;
import io.dcloud.uts.Map;
import io.dcloud.uts.Set;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.async;
import io.dcloud.uts.UTSAndroid;
open class RoomOptions (
    @JsonNotNull
    open var serial: String,
    @JsonNotNull
    open var userrole: Number,
    @JsonNotNull
    open var nickname: String,
    @JsonNotNull
    open var userid: String,
    @JsonNotNull
    open var password: String,
    @JsonNotNull
    open var norecord: Number,
) : UTSObject()
open class RoomCallBack (
    open var joinRoomComplete: (() -> Unit)? = null,
    open var leftRoomComplete: (() -> Unit)? = null,
    open var onClassRoomDisappear: (() -> Unit)? = null,
    open var onClassDismiss: (() -> Unit)? = null,
    open var onCameraDidOpenError: (() -> Unit)? = null,
    open var onClassBegin: (() -> Unit)? = null,
    open var onKitout: (() -> Unit)? = null,
    open var onEnterRoomFailed: ((result: Number, desc: String) -> Unit)? = null,
    open var closeCheckDevice: (() -> Unit)? = null,
    open var onJoinRoom: ((code: Number) -> Unit)? = null,
) : UTSObject()
typealias JoinRoom = (options: RoomOptions, callBack: RoomCallBack) -> Unit;
var baseCallBack = RoomCallBack();
open class SMeetingNotify : MeetingNotify {
    override fun joinRoomComplete(): Unit {
        baseCallBack.joinRoomComplete?.invoke();
    }
    override fun onCameraDidOpenError(): Unit {
        console.debug("123123", " at uni_modules/jxl-talk/utssdk/app-android/index.uts:32");
    }
    override fun onClassBegin(): Unit {
        console.debug("123123", " at uni_modules/jxl-talk/utssdk/app-android/index.uts:35");
    }
    override fun onClassDismiss(): Unit {
        console.debug("123123", " at uni_modules/jxl-talk/utssdk/app-android/index.uts:38");
    }
    override fun onEnterRoomFailed(param0: Int, param1: String): Unit {
        console.debug(param0, param1, " at uni_modules/jxl-talk/utssdk/app-android/index.uts:41");
    }
    override fun onKickOut(param0: Int, param1: String): Unit {
        console.debug(param0, param1, " at uni_modules/jxl-talk/utssdk/app-android/index.uts:44");
    }
    override fun onLeftRoomComplete(): Unit {
        console.debug("123123", " at uni_modules/jxl-talk/utssdk/app-android/index.uts:47");
    }
    override fun onOpenEyeProtection(param0: Boolean): Unit {
        console.debug(param0, " at uni_modules/jxl-talk/utssdk/app-android/index.uts:50");
    }
    override fun onRoomDestroy(): Unit {
        console.debug("123123", " at uni_modules/jxl-talk/utssdk/app-android/index.uts:53");
    }
    override fun onWarning(param0: Int): Unit {
        console.debug(param0, " at uni_modules/jxl-talk/utssdk/app-android/index.uts:56");
    }
}
open class SJoinmeetingCallBack : JoinmeetingCallBack {
    override fun callBack(param0: Int): Unit {
        console.debug(param0, " at uni_modules/jxl-talk/utssdk/app-android/index.uts:62");
    }
}
val MNotify = SMeetingNotify();
val asaas = SJoinmeetingCallBack();
val runBlock1 = run {
    RoomClient.getInstance().setNotify(MNotify);
    RoomClient.getInstance().setCallBack(asaas);
    ScreenScale.init(UTSAndroid.getAppContext() as Application);
}
val activity = UTSAndroid.getUniActivity();
val appName = UTSAndroid.getAppContext() as Application;
val runBlock2 = run {
    FunctionSetManage.getInstance().setAppName(appName.getResources().getIdentifier("app_name", "string", appName.getPackageName()));
    FunctionSetManage.getInstance().setIsShowSettingPrivacyAgreement(appName, false);
}
val joinRoom: JoinRoom = fun(options: RoomOptions, callBack: RoomCallBack): Unit {
    baseCallBack = callBack;
    val paramDic: Map<String, Any> = Map();
    paramDic.set("serial", options.serial);
    paramDic.set("userrole", options.userrole);
    paramDic.set("nickname", options.nickname);
    paramDic.set("password", options.password);
    paramDic.set("norecord", options.norecord);
    paramDic.set("userid", options.userid);
    paramDic.set("host", "global.talk-cloud.net");
    paramDic.set("port", 443);
    paramDic.set("clientType", 2);
    RoomClient.getInstance().joinRoom(activity, paramDic);
}
;
