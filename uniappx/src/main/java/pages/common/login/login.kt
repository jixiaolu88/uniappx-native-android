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
import io.dcloud.uniapp.extapi.navigateTo as uni_navigateTo;
open class GenPagesCommonLoginLogin : BasePage {
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
        onHide(fun() {
            this.showTongYi = false;
        }
        , instance);
    }
    @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
    override fun `$render`(): Any? {
        val _ctx = this;
        val _cache = this.`$`.renderCache;
        val _component_x_text = resolveEasyComponent("x-text", GenUniModulesTmxUiComponentsXTextXTextClass);
        val _component_x_button = resolveEasyComponent("x-button", GenUniModulesTmxUiComponentsXButtonXButtonClass);
        val _component_x_radio = resolveEasyComponent("x-radio", GenUniModulesTmxUiComponentsXRadioXRadioClass);
        val _component_phoneLogin = resolveComponent("phoneLogin");
        val _component_pwdLogin = resolveComponent("pwdLogin");
        val _component_x_modal = resolveEasyComponent("x-modal", GenUniModulesTmxUiComponentsXModalXModalClass);
        return createElementVNode("scroll-view", utsMapOf("style" to normalizeStyle(utsMapOf("flex" to "1"))), utsArrayOf(
            createElementVNode("image", utsMapOf("class" to "login-image", "src" to "/static/image/bg.jpeg", "mode" to "aspectFill")),
            createElementVNode("view", utsMapOf("class" to "flex", "style" to normalizeStyle(utsMapOf("width" to "100%", "height" to "100%", "background-color" to "rgba(0, 0, 0, .5)"))), null, 4),
            createElementVNode("view", utsMapOf("class" to "absolute t-10 pa-40"), utsArrayOf(
                createElementVNode("image", utsMapOf("class" to "logo mb-20", "src" to "/static/logo.png")),
                createElementVNode("text", utsMapOf("class" to "text-white text-weight-b", "style" to normalizeStyle(utsMapOf("font-size" to "48px", "line-height" to "48px"))), "TalkArena", 4),
                createVNode(_component_x_text, utsMapOf("class" to "pt-10", "fontSize" to "18", "color" to "#fff"), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                    return utsArrayOf(
                        "与世界沟通·从杭站开始"
                    );
                }
                ), "_" to 1))
            )),
            createElementVNode("view", utsMapOf("class" to "fulled absolute flex-center", "style" to normalizeStyle(utsMapOf("bottom" to "150px"))), utsArrayOf(
                createElementVNode("view", utsMapOf("class" to "pa-40", "style" to normalizeStyle(utsMapOf("width" to "100%", "max-width" to "756px"))), utsArrayOf(
                    createVNode(_component_x_button, utsMapOf("block" to true, "icon" to "phone-line", "round" to "88", "onClick" to _ctx.openPhoneLogin), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                        return utsArrayOf(
                            "手机号登录"
                        );
                    }
                    ), "_" to 1), 8, utsArrayOf(
                        "onClick"
                    )),
                    createVNode(_component_x_button, utsMapOf("class" to "mt-20", "block" to true, "skin" to "thin", "onClick" to _ctx.openPwdLogin, "icon" to "lock-password-line", "round" to "88"), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                        return utsArrayOf(
                            "密码登录"
                        );
                    }
                    ), "_" to 1), 8, utsArrayOf(
                        "onClick"
                    ))
                ), 4)
            ), 4),
            createElementVNode("view", utsMapOf("class" to "fulled absolute b-40"), utsArrayOf(
                createElementVNode("view", utsMapOf("class" to "flex flex-center"), utsArrayOf(
                    createVNode(_component_x_radio, utsMapOf("size" to "16", "modelValue" to _ctx.isTongYi, "onUpdate:modelValue" to fun(`$event`: String){
                        _ctx.isTongYi = `$event`;
                    }
                    ), utsMapOf("label" to withSlotCtx(fun(): UTSArray<Any> {
                        return utsArrayOf(
                            createElementVNode("view", utsMapOf("class" to "flex-row", "onClick" to withModifiers(fun(){}, utsArrayOf(
                                "stop"
                            ))), utsArrayOf(
                                createElementVNode("text", utsMapOf("class" to "text-size-s text-grey"), "登录注册代表同意"),
                                createElementVNode("text", utsMapOf("class" to "text-size-s text-white", "onClick" to _ctx.openXieYi), "服务协议", 8, utsArrayOf(
                                    "onClick"
                                )),
                                createElementVNode("text", utsMapOf("class" to "text-size-s text-grey"), "和"),
                                createElementVNode("text", utsMapOf("class" to "text-size-s text-white", "onClick" to _ctx.openYinSi), "隐私政策", 8, utsArrayOf(
                                    "onClick"
                                ))
                            ))
                        );
                    }
                    ), "_" to 1), 8, utsArrayOf(
                        "modelValue",
                        "onUpdate:modelValue"
                    ))
                ))
            )),
            createVNode(_component_phoneLogin, utsMapOf("ref" to "phoneLogin"), null, 512),
            createVNode(_component_pwdLogin, utsMapOf("ref" to "pwdLogin"), null, 512),
            createVNode(_component_x_modal, utsMapOf("show" to _ctx.showTongYi, "onUpdate:show" to fun(`$event`: Boolean){
                _ctx.showTongYi = `$event`;
            }
            , "cancelText" to "不同意", "onConfirm" to _ctx.confirm, "overlayClick" to false, "title" to "你是否已阅读并同意", "confirmText" to "同意并继续", "height" to "auto"), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                return utsArrayOf(
                    createElementVNode("view", utsMapOf("class" to "flex-row flex-center"), utsArrayOf(
                        createElementVNode("text", utsMapOf("class" to "text-blue", "onClick" to _ctx.openXieYi), "服务协议", 8, utsArrayOf(
                            "onClick"
                        )),
                        createVNode(_component_x_text, null, utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                            return utsArrayOf(
                                " 和 "
                            );
                        }
                        ), "_" to 1)),
                        createElementVNode("text", utsMapOf("class" to "text-blue", "onClick" to _ctx.openYinSi), "隐私政策", 8, utsArrayOf(
                            "onClick"
                        )),
                        createVNode(_component_x_text, null, utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                            return utsArrayOf(
                                "?"
                            );
                        }
                        ), "_" to 1))
                    ))
                );
            }
            ), "_" to 1), 8, utsArrayOf(
                "show",
                "onUpdate:show",
                "onConfirm"
            ))
        ), 4);
    }
    open var showTongYi: Boolean by `$data`;
    open var isTongYi: String by `$data`;
    open var openState: String by `$data`;
    @Suppress("USELESS_CAST")
    override fun data(): Map<String, Any?> {
        var isTongYi = "0";
        var showTongYi = false;
        var openState = "";
        return utsMapOf("showTongYi" to showTongYi as Boolean, "isTongYi" to isTongYi as String, "openState" to openState as String);
    }
    override fun `$initMethods`() {
        this.confirm = fun() {
            this.isTongYi = "1";
            if (this.openState === "PhoneLogin") {
                this.openPhoneLogin();
            }
            if (this.openState === "PwdLogin") {
                this.openPwdLogin();
            }
        }
        ;
        this.openPhoneLogin = fun() {
            this.openState = "PhoneLogin";
            if (this.isTongYi === "0") {
                this.showTongYi = true;
                return;
            }
            (this.`$refs`["phoneLogin"] as ComponentPublicInstance)?.`$callMethod`("open");
        }
        ;
        this.openPwdLogin = fun() {
            this.openState = "PwdLogin";
            if (this.isTongYi === "0") {
                this.showTongYi = true;
                return;
            }
            (this.`$refs`["pwdLogin"] as ComponentPublicInstance)?.`$callMethod`("open");
        }
        ;
        this.openYinSi = fun(){
            uni_navigateTo(NavigateToOptions(url = "/pages/common/protocol/protocol?code=yinsi"));
        }
        ;
        this.openXieYi = fun(){
            uni_navigateTo(NavigateToOptions(url = "/pages/common/protocol/protocol?code=fuwu"));
        }
        ;
        this.open = fun(){
            console.log("hahaha", " at pages/common/login/login.uvue:60");
        }
        ;
    }
    open lateinit var confirm: () -> Unit;
    open lateinit var openPhoneLogin: () -> Unit;
    open lateinit var openPwdLogin: () -> Unit;
    open lateinit var openYinSi: () -> Unit;
    open lateinit var openXieYi: () -> Unit;
    open lateinit var open: () -> Unit;
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
                return utsMapOf("logo" to padStyleMapOf(utsMapOf("height" to 40, "width" to 40, "borderRadius" to 10)), "login-image" to padStyleMapOf(utsMapOf("width" to "100%", "height" to "100%", "position" to "absolute")));
            }
        var inheritAttrs = true;
        var inject: Map<String, Map<String, Any?>> = utsMapOf();
        var emits: Map<String, Any?> = utsMapOf();
        var props = normalizePropsOptions(utsMapOf());
        var propsNeedCastKeys: UTSArray<String> = utsArrayOf();
        var components: Map<String, CreateVueComponent> = utsMapOf("phoneLogin" to GenPagesCommonLoginLibPhoneLoginPhoneLoginClass, "pwdLogin" to GenPagesCommonLoginLibPwdLoginPwdLoginClass);
    }
}
