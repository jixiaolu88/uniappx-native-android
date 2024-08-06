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
open class GenPagesCommonLoginLibPhoneLoginPhoneLogin : VueComponent {
    constructor(instance: ComponentInternalInstance) : super(instance) {}
    @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
    override fun `$render`(): Any? {
        val _ctx = this;
        val _cache = this.`$`.renderCache;
        val _component_x_input = resolveEasyComponent("x-input", GenUniModulesTmxUiComponentsXInputXInputClass);
        val _component_x_button = resolveEasyComponent("x-button", GenUniModulesTmxUiComponentsXButtonXButtonClass);
        val _component_x_modal = resolveEasyComponent("x-modal", GenUniModulesTmxUiComponentsXModalXModalClass);
        return createVNode(_component_x_modal, utsMapOf("show" to _ctx.show2, "onUpdate:show" to fun(`$event`: Boolean){
            _ctx.show2 = `$event`;
        }
        , "style" to normalizeStyle(utsMapOf("width" to "48%", "margin-right" to "2%", "max-width" to "756px")), "height" to "auto", "overlayClick" to false, "title" to "手机号登录"), utsMapOf("footer" to withSlotCtx(fun(): UTSArray<Any> {
            return utsArrayOf(
                createVNode(_component_x_button, utsMapOf("skin" to "thin", "width" to "0px", "style" to normalizeStyle(utsMapOf("margin-right" to "16px", "flex" to "1")), "block" to true, "onClick" to fun(){
                    _ctx.show2 = false;
                }
                ), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                    return utsArrayOf(
                        "关闭"
                    );
                }
                ), "_" to 1), 8, utsArrayOf(
                    "style",
                    "onClick"
                )),
                createVNode(_component_x_button, utsMapOf("width" to "0px", "block" to true, "disabled" to _ctx.disabled, "style" to normalizeStyle(utsMapOf("flex" to "1"))), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                    return utsArrayOf(
                        "登 录"
                    );
                }
                ), "_" to 1), 8, utsArrayOf(
                    "disabled",
                    "style"
                ))
            );
        }
        ), "default" to withSlotCtx(fun(): UTSArray<Any> {
            return utsArrayOf(
                createVNode(_component_x_input, utsMapOf("modelValue" to _ctx.mobile, "onUpdate:modelValue" to fun(`$event`: String){
                    _ctx.mobile = `$event`;
                }
                , "dark-bg-color" to "", "placeholder" to "请输入你的手机号", "left-icon" to "phone-line", "class" to "mb-12"), null, 8, utsArrayOf(
                    "modelValue",
                    "onUpdate:modelValue"
                )),
                createVNode(_component_x_input, utsMapOf("darkBgColor" to "", "modelValue" to _ctx.code, "onUpdate:modelValue" to fun(`$event`: String){
                    _ctx.code = `$event`;
                }
                , "left-icon" to "message-2-line", "placeholder" to "输入验证码"), utsMapOf("inputRight" to withSlotCtx(fun(): UTSArray<Any> {
                    return utsArrayOf(
                        createVNode(_component_x_button, utsMapOf("round" to "8", "class" to "mr-2", "height" to "40", "width" to "90"), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                            return utsArrayOf(
                                "获取验证码"
                            );
                        }
                        ), "_" to 1))
                    );
                }
                ), "_" to 1), 8, utsArrayOf(
                    "modelValue",
                    "onUpdate:modelValue"
                ))
            );
        }
        ), "_" to 1), 8, utsArrayOf(
            "show",
            "onUpdate:show",
            "style"
        ));
    }
    open var mobile: String by `$data`;
    open var code: String by `$data`;
    open var disabled: Boolean by `$data`;
    open var show2: Boolean by `$data`;
    @Suppress("USELESS_CAST")
    override fun data(): Map<String, Any?> {
        var show2: Boolean = false;
        return utsMapOf("mobile" to ref(""), "code" to ref(""), "disabled" to true, "show2" to show2);
    }
    override fun `$initMethods`() {
        this.open = fun() {
            this.show2 = true;
        }
        ;
    }
    open lateinit var open: () -> Unit;
    companion object {
        var name = "phoneLogin";
        val styles: Map<String, Map<String, Map<String, Any>>>
            get() {
                return normalizeCssStyles(utsArrayOf());
            }
        var inheritAttrs = true;
        var inject: Map<String, Map<String, Any?>> = utsMapOf();
        var emits: Map<String, Any?> = utsMapOf();
        var props = normalizePropsOptions(utsMapOf());
        var propsNeedCastKeys: UTSArray<String> = utsArrayOf();
        var components: Map<String, CreateVueComponent> = utsMapOf();
    }
}
