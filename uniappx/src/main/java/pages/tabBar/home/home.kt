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
import io.dcloud.uniapp.extapi.env as uni_env;
import io.dcloud.uniapp.extapi.getFileSystemManager as uni_getFileSystemManager;
open class GenPagesTabBarHomeHome : BasePage {
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
        onLoad(fun(_: OnLoadOptions) {}, instance);
    }
    @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
    override fun `$render`(): Any? {
        val _ctx = this;
        val _cache = this.`$`.renderCache;
        val _component_x_text = resolveEasyComponent("x-text", GenUniModulesTmxUiComponentsXTextXTextClass);
        return createElementVNode(Fragment, null, utsArrayOf(
            createElementVNode("text", null, "操作日志"),
            createElementVNode("button", utsMapOf("size" to "mini", "onClick" to fun(){
                _ctx.log = "";
            }
            ), "清空日志", 8, utsArrayOf(
                "onClick"
            )),
            createElementVNode("text", utsMapOf("style" to normalizeStyle(utsMapOf("margin" to "2px", "padding" to "2px", "color" to "aliceblue", "border" to "1px solid #000000"))), toDisplayString(_ctx.log), 5),
            createElementVNode("scroll-view", utsMapOf("style" to normalizeStyle(utsMapOf("flex" to "1"))), utsArrayOf(
                createElementVNode("button", utsMapOf("class" to "btnstyle", "type" to "primary", "onClick" to fun(){
                    _ctx.geAbsPath(_ctx.sandboxPath);
                }
                , "id" to "btn-path"), "应用外置沙盒目录uni.env.SANDBOX_PATH", 8, utsArrayOf(
                    "onClick"
                )),
                createElementVNode("button", utsMapOf("class" to "btnstyle", "type" to "primary", "onClick" to fun(){
                    _ctx.geAbsPath(_ctx.cachePath);
                }
                , "id" to "btn-path"), "缓存文件目录uni.env.CACHE_PATH", 8, utsArrayOf(
                    "onClick"
                )),
                createElementVNode("button", utsMapOf("class" to "btnstyle", "type" to "primary", "onClick" to fun(){
                    _ctx.geAbsPath(_ctx.userPath);
                }
                , "id" to "btn-path"), "用户文件目录uni.env.USER_DATA_PATH", 8, utsArrayOf(
                    "onClick"
                )),
                createElementVNode("button", utsMapOf("class" to "btnstyle", "type" to "primary", "onClick" to fun(){
                    _ctx.geAbsPath(_ctx.internalSandboxPath);
                }
                , "id" to "btn-path"), "应用内置沙盒目录uni.env.ANDROID_INTERNAL_SANDBOX_PATH", 8, utsArrayOf(
                    "onClick"
                )),
                createVNode(_component_x_text, utsMapOf("onClick" to _ctx.test), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                    return utsArrayOf(
                        toDisplayString(_ctx.cachePath)
                    );
                }
                ), "_" to 1), 8, utsArrayOf(
                    "onClick"
                ))
            ), 4)
        ), 64);
    }
    open var log: String by `$data`;
    open var userPath: Any? by `$data`;
    open var sandboxPath: Any? by `$data`;
    open var cachePath: Any? by `$data`;
    open var internalSandboxPath: Any? by `$data`;
    open var saa: String by `$data`;
    @Suppress("USELESS_CAST")
    override fun data(): Map<String, Any?> {
        return utsMapOf("log" to "", "userPath" to uni_env.USER_DATA_PATH, "sandboxPath" to uni_env.SANDBOX_PATH, "cachePath" to uni_env.CACHE_PATH, "internalSandboxPath" to uni_env.ANDROID_INTERNAL_SANDBOX_PATH, "saa" to "");
    }
    override fun `$initMethods`() {
        this.test = fun() {
            val fs = uni_getFileSystemManager();
            this.saa = fs.readFileSync("/static/icon/2.svg", "utf-8");
        }
        ;
        this.geAbsPath = fun(path: Any?) {
            this.log += UTSAndroid.convert2AbsFullPath(path as String) + "\n";
        }
        ;
    }
    open lateinit var test: () -> Unit;
    open lateinit var geAbsPath: (path: Any?) -> Unit;
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
                return utsMapOf("btnstyle" to padStyleMapOf(utsMapOf("marginTop" to 4, "marginRight" to 4, "marginBottom" to 4, "marginLeft" to 4)));
            }
        var inheritAttrs = true;
        var inject: Map<String, Map<String, Any?>> = utsMapOf();
        var emits: Map<String, Any?> = utsMapOf();
        var props = normalizePropsOptions(utsMapOf());
        var propsNeedCastKeys: UTSArray<String> = utsArrayOf();
        var components: Map<String, CreateVueComponent> = utsMapOf();
    }
}
