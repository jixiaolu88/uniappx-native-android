@file:Suppress("UNCHECKED_CAST", "USELESS_CAST", "INAPPLICABLE_JVM_NAME")
package uni.UNI80AFE50;
import io.dcloud.uniapp.*;
import io.dcloud.uniapp.extapi.*;
import io.dcloud.uniapp.framework.*;
import io.dcloud.uniapp.runtime.*;
import io.dcloud.uniapp.vue.*;
import io.dcloud.uniapp.vue.shared.*;
import io.dcloud.uts.*;
import io.dcloud.uts.Map;
import io.dcloud.uts.Set;
import io.dcloud.uts.UTSAndroid;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.async;
import uts.sdk.modules.jxlTalk.joinRoom;
import uts.sdk.modules.jxlTalk.RoomOptions;
import uts.sdk.modules.jxlTalk.RoomCallBack;
open class GenPagesIndexIndex : BasePage {
    constructor(instance: ComponentInternalInstance) : super(instance) {}
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenPagesIndexIndex) -> Any? = fun(
        @Suppress("UNUSED_ANONYMOUS_PARAMETER")
        __props): Any? {
            val __ins = getCurrentInstance()!!;
            val _ctx = __ins.proxy as GenPagesIndexIndex;
            val _cache = __ins.renderCache;
            val Back = RoomCallBack(joinRoomComplete = fun() {
                console.log("草你打也得Nci ", " at pages/index/index.uvue:12");
            }
            , closeCheckDevice = fun() {
                console.debug("33333333", " at pages/index/index.uvue:15");
            }
            , onKitout = fun() {
                console.debug("44444444", " at pages/index/index.uvue:18");
            }
            );
            val open = fun(){
                val Options = RoomOptions(serial = "1474421588", password = "5576", userid = "890524", nickname = "测试晓鹭", userrole = 2, norecord = 0);
                joinRoom(Options, Back);
            }
            ;
            return fun(): Any? {
                return createElementVNode("view", null, utsArrayOf(
                    createElementVNode("image", utsMapOf("class" to "logo", "src" to "/static/logo.png")),
                    createElementVNode("view", utsMapOf("class" to "text-area"), utsArrayOf(
                        createElementVNode("text", utsMapOf("class" to "title")),
                        createElementVNode("text", utsMapOf("class" to "title"), "Hello World"),
                        createElementVNode("button", utsMapOf("onClick" to open), "打开教2室")
                    ))
                ));
            }
            ;
        }
        ;
        val styles: Map<String, Map<String, Map<String, Any>>>
            get() {
                return normalizeCssStyles(utsArrayOf(
                    styles0
                ), utsArrayOf(
                    GenApp.styles
                ));
            }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return utsMapOf("logo" to padStyleMapOf(utsMapOf("height" to 100, "width" to 100, "marginTop" to 100, "marginRight" to "auto", "marginBottom" to 25, "marginLeft" to "auto")), "title" to padStyleMapOf(utsMapOf("fontSize" to 18, "color" to "#8f8f94", "textAlign" to "center")));
            }
        var inheritAttrs = true;
        var inject: Map<String, Map<String, Any?>> = utsMapOf();
        var emits: Map<String, Any?> = utsMapOf();
        var props = normalizePropsOptions(utsMapOf());
        var propsNeedCastKeys: UTSArray<String> = utsArrayOf();
        var components: Map<String, CreateVueComponent> = utsMapOf();
    }
}
