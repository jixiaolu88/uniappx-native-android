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
import io.dcloud.uniapp.extapi.createWebviewContext as uni_createWebviewContext;
import io.dcloud.uniapp.extapi.getElementById as uni_getElementById;
import io.dcloud.uniapp.extapi.setNavigationBarTitle as uni_setNavigationBarTitle;
open class GenPagesCommonProtocolProtocol : BasePage {
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
        onReady(fun() {
            this.webviewContext = uni_createWebviewContext("web-view", this);
            this.webviewElement = uni_getElementById("web-view") as UniWebViewElement;
        }
        , instance);
        onLoad(fun(event: OnLoadOptions) {
            val code = event["code"] ?: "";
            if (code.toString() == "fuwu") {
                uni_setNavigationBarTitle(SetNavigationBarTitleOptions(title = "服务协议"));
                this.src = "https://protocol.hangzhan.vip/fuwu.htm";
            }
            if (code.toString() == "yinsi") {
                uni_setNavigationBarTitle(SetNavigationBarTitleOptions(title = "隐私政策"));
                this.src = "https://protocol.hangzhan.vip/yinsi.html";
            }
        }
        , instance);
    }
    @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
    override fun `$render`(): Any? {
        val _ctx = this;
        val _cache = this.`$`.renderCache;
        return createElementVNode("web-view", utsMapOf("class" to "wh-full", "style" to normalizeStyle(utsMapOf("background-color" to "#fff")), "id" to "web-view", "src" to _ctx.src), null, 12, utsArrayOf(
            "src"
        ));
    }
    open var webviewContext: WebviewContext? by `$data`;
    open var webviewElement: UniWebViewElement? by `$data`;
    open var src: String by `$data`;
    @Suppress("USELESS_CAST")
    override fun data(): Map<String, Any?> {
        return utsMapOf("webviewContext" to null as WebviewContext?, "webviewElement" to null as UniWebViewElement?, "src" to "");
    }
    companion object {
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
                return utsMapOf("wh-full" to padStyleMapOf(utsMapOf("width" to "100%", "height" to "100%")));
            }
        var inheritAttrs = true;
        var inject: Map<String, Map<String, Any?>> = utsMapOf();
        var emits: Map<String, Any?> = utsMapOf();
        var props = normalizePropsOptions(utsMapOf());
        var propsNeedCastKeys: UTSArray<String> = utsArrayOf();
        var components: Map<String, CreateVueComponent> = utsMapOf();
    }
}
