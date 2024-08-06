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
import io.dcloud.uniapp.extapi.reLaunch as uni_reLaunch;
import uts.sdk.modules.xLoadingS.showLoading;
import uts.sdk.modules.xLoadingS.hideXloading;
import uts.sdk.modules.xLoadingS.XLOADINGS_TYPE;
import io.dcloud.uniapp.extapi.showToast as uni_showToast;
import uts.sdk.modules.xToastS.showToast;
import uts.sdk.modules.xToastS.XTOAST_TYPE;
open class GenPagesCommonLoginLibPwdLoginPwdLogin : VueComponent {
    constructor(instance: ComponentInternalInstance) : super(instance) {}
    @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
    override fun `$render`(): Any? {
        val _ctx = this;
        val _cache = this.`$`.renderCache;
        val _component_x_input = resolveEasyComponent("x-input", GenUniModulesTmxUiComponentsXInputXInputClass);
        val _component_x_form_item = resolveEasyComponent("x-form-item", GenUniModulesTmxUiComponentsXFormItemXFormItemClass);
        val _component_x_button = resolveEasyComponent("x-button", GenUniModulesTmxUiComponentsXButtonXButtonClass);
        val _component_x_form = resolveEasyComponent("x-form", GenUniModulesTmxUiComponentsXFormXFormClass);
        val _component_x_modal = resolveEasyComponent("x-modal", GenUniModulesTmxUiComponentsXModalXModalClass);
        return createVNode(_component_x_modal, utsMapOf("show" to _ctx.show, "onUpdate:show" to fun(`$event`: Boolean){
            _ctx.show = `$event`;
        }
        , "showFooter" to false, "style" to normalizeStyle(utsMapOf("width" to "48%", "margin-right" to "2%", "max-width" to "756px")), "height" to "auto", "overlayClick" to false, "title" to "密码登录"), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
            return utsArrayOf(
                createVNode(_component_x_form, utsMapOf("modelValue" to _ctx.fromData, "onUpdate:modelValue" to fun(`$event`: fromDataType){
                    _ctx.fromData = `$event`;
                }
                , "onSubmit" to _ctx.submit, "label-direction" to "vertical"), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                    return utsArrayOf(
                        createVNode(_component_x_form_item, utsMapOf("cell-padding" to utsArrayOf(
                            "0",
                            "0"
                        ), "showBottomBorder" to false, "field" to "mobile", "rule" to _ctx.vaildMobile, "label" to "手机号", "required" to true), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                            return utsArrayOf(
                                createVNode(_component_x_input, utsMapOf("modelValue" to _ctx.fromData.mobile, "onUpdate:modelValue" to fun(`$event`: String){
                                    _ctx.fromData.mobile = `$event`;
                                }
                                , "darkBgColor" to "", "left-icon" to "phone-line", "placeholder" to "请输入你的手机号"), null, 8, utsArrayOf(
                                    "modelValue",
                                    "onUpdate:modelValue"
                                ))
                            );
                        }
                        ), "_" to 1), 8, utsArrayOf(
                            "rule"
                        )),
                        createVNode(_component_x_form_item, utsMapOf("cell-padding" to utsArrayOf(
                            "0",
                            "0"
                        ), "showBottomBorder" to false, "field" to "password", "label" to "登录密码", "required" to true), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                            return utsArrayOf(
                                createVNode(_component_x_input, utsMapOf("darkBgColor" to "", "modelValue" to _ctx.fromData.password, "onUpdate:modelValue" to fun(`$event`: String){
                                    _ctx.fromData.password = `$event`;
                                }
                                , "password" to true, "left-icon" to "lock-password-fill", "placeholder" to "请输入密码"), null, 8, utsArrayOf(
                                    "modelValue",
                                    "onUpdate:modelValue"
                                ))
                            );
                        }
                        ), "_" to 1)),
                        createElementVNode("view", utsMapOf("class" to "flex-row mt-40"), utsArrayOf(
                            createVNode(_component_x_button, utsMapOf("skin" to "thin", "width" to "0px", "style" to normalizeStyle(utsMapOf("margin-right" to "16px", "flex" to "1")), "block" to true, "onClick" to fun(){
                                _ctx.show = false;
                            }
                            ), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                                return utsArrayOf(
                                    "关 闭"
                                );
                            }
                            ), "_" to 1), 8, utsArrayOf(
                                "style",
                                "onClick"
                            )),
                            createVNode(_component_x_button, utsMapOf("form-type" to "form", "width" to "0px", "icon" to "lock-unlock-fill", "style" to normalizeStyle(utsMapOf("flex" to "1")), "block" to true), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                                return utsArrayOf(
                                    "登 录"
                                );
                            }
                            ), "_" to 1), 8, utsArrayOf(
                                "style"
                            ))
                        ))
                    );
                }
                ), "_" to 1), 8, utsArrayOf(
                    "modelValue",
                    "onUpdate:modelValue",
                    "onSubmit"
                ))
            );
        }
        ), "_" to 1), 8, utsArrayOf(
            "show",
            "onUpdate:show",
            "style"
        ));
    }
    open var fromData: fromDataType by `$data`;
    open var vaildMobile: UTSArray<FORM_RULE> by `$data`;
    open var disabled: Boolean by `$data`;
    open var show: Boolean by `$data`;
    @Suppress("USELESS_CAST")
    override fun data(): Map<String, Any?> {
        var fromData = fromDataType(mobile = "13106188555", password = "123123");
        var vaildMobile = utsArrayOf<FORM_RULE>(FORM_RULE(type = "string", errorMessage = "请输入正确手机号", valid = fun(kVal: Any): Boolean {
            var pval = kVal as String;
            var reg = UTSRegExp("^1[3-9]\\d{9}\$", "");
            return reg.test(pval);
        }
        ));
        return utsMapOf("fromData" to fromData as fromDataType, "vaildMobile" to vaildMobile, "disabled" to true, "show" to false);
    }
    override fun `$initMethods`() {
        this.submit = fun(evt: FORM_SUBMIT_RESULT) {
            if (!evt.valid) {
                uni_showToast(ShowToastOptions(title = evt.errorMessage, icon = "none"));
                return;
            }
            showLoading(XLOADINGS_TYPE(title = "登录中"));
            userApi.LoginPwdNew(this.fromData.mobile, this.fromData.password).then(fun(){
                showToast(XTOAST_TYPE(title = "登录成功", iconCode = "success"));
                hideXloading();
                uni_reLaunch(ReLaunchOptions(url = "/pages/tabBar/teacherList/teacherList", success = fun(_){}));
            }
            ).`catch`(fun(){
                console.log("失败了？", " at pages/common/login/lib/pwdLogin/pwdLogin.uvue:54");
                hideXloading();
            }
            );
        }
        ;
        this.test = fun() {
            this.show = false;
        }
        ;
        this.open = fun() {
            console.log("open", " at pages/common/login/lib/pwdLogin/pwdLogin.uvue:62");
            this.show = true;
        }
        ;
    }
    open lateinit var submit: (evt: FORM_SUBMIT_RESULT) -> Unit;
    open lateinit var test: () -> Unit;
    open lateinit var open: () -> Unit;
    companion object {
        var name = "pwdLogin";
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
