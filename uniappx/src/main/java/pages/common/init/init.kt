@file:Suppress("UNCHECKED_CAST", "USELESS_CAST", "INAPPLICABLE_JVM_NAME")
package uni.UNI6115B65;
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
import io.dcloud.uniapp.extapi.`$emit` as uni__emit;
import io.dcloud.uniapp.extapi.getStorageSync as uni_getStorageSync;
import io.dcloud.uniapp.extapi.reLaunch as uni_reLaunch;
import io.dcloud.uniapp.extapi.removeStorageSync as uni_removeStorageSync;
open class GenPagesCommonInitInit : BasePage {
    constructor(instance: ComponentInternalInstance) : super(instance) {
        onPageScroll(fun(e: OnPageScrollOptions) {
            xProvitae.scrollTop = e.scrollTop;
        }
        , instance);
        onResize(fun(_: OnResizeOptions) {
            uni__emit("onResize", fun() {});
        }
        , instance);
        onLoad(fun(_: OnLoadOptions) {}, instance);
        onHide(fun() {
            uni__emit("onHide", fun() {});
        }
        , instance);
        onPageShow(fun() {
            uni__emit("onShow", fun() {});
        }
        , instance);
        onLoad(fun(_: OnLoadOptions) {
            val token = uni_getStorageSync("token") as String;
            console.log("init onLoad", " at pages/common/init/init.uvue:12");
            if (token != "") {
                refreshGlobalUserInfo().then(fun(){
                    console.log("已经登陆过了可以直接跳转主页", " at pages/common/init/init.uvue:15");
                    uni_reLaunch(ReLaunchOptions(url = "/pages/tabBar/teacherList/teacherList"));
                }).`catch`(fun(){
                    console.log("token过期2了2", " at pages/common/init/init.uvue:20");
                    uni_removeStorageSync("token");
                    uni_reLaunch(ReLaunchOptions(url = "/pages/common/login/login"));
                });
            } else {
                console.log("没有token 直接登录", " at pages/common/init/init.uvue:27");
                uni_reLaunch(ReLaunchOptions(url = "/pages/common/login/login"));
            }
        }
        , instance);
    }
    @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
    override fun `$render`(): Any? {
        val _cache = this.`$`.renderCache;
        val _component_x_text = resolveEasyComponent("x-text", GenUniModulesTmxUiComponentsXTextXTextClass);
        return createElementVNode("view", null, utsArrayOf(
            createVNode(_component_x_text, utsMapOf("label" to "中间页"))
        ));
    }
    companion object {
        val styles: Map<String, Map<String, Map<String, Any>>>
            get() {
                return normalizeCssStyles(utsArrayOf(), utsArrayOf(
                    GenApp.styles
                ));
            }
        var inheritAttrs = true;
        var inject: Map<String, Map<String, Any?>> = utsMapOf();
        var emits: Map<String, Any?> = utsMapOf();
        var props = normalizePropsOptions(utsMapOf());
        var propsNeedCastKeys: UTSArray<String> = utsArrayOf();
        var components: Map<String, CreateVueComponent> = utsMapOf();
    }
}
