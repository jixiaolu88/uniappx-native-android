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
import io.dcloud.uniapp.extapi.showToast as uni_showToast;
open class GenPagesTestFormForm : BasePage {
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
    }
    @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
    override fun `$render`(): Any? {
        val _ctx = this;
        val _cache = this.`$`.renderCache;
        val _component_x_input = resolveEasyComponent("x-input", GenUniModulesTmxUiComponentsXInputXInputClass);
        val _component_x_form_item = resolveEasyComponent("x-form-item", GenUniModulesTmxUiComponentsXFormItemXFormItemClass);
        val _component_x_stepper = resolveEasyComponent("x-stepper", GenUniModulesTmxUiComponentsXStepperXStepperClass);
        val _component_x_radio = resolveEasyComponent("x-radio", GenUniModulesTmxUiComponentsXRadioXRadioClass);
        val _component_x_radio_group = resolveEasyComponent("x-radio-group", GenUniModulesTmxUiComponentsXRadioGroupXRadioGroupClass);
        val _component_x_checkbox = resolveEasyComponent("x-checkbox", GenUniModulesTmxUiComponentsXCheckboxXCheckboxClass);
        val _component_x_checkbox_group = resolveEasyComponent("x-checkbox-group", GenUniModulesTmxUiComponentsXCheckboxGroupXCheckboxGroupClass);
        val _component_x_button = resolveEasyComponent("x-button", GenUniModulesTmxUiComponentsXButtonXButtonClass);
        val _component_x_text = resolveEasyComponent("x-text", GenUniModulesTmxUiComponentsXTextXTextClass);
        val _component_x_form = resolveEasyComponent("x-form", GenUniModulesTmxUiComponentsXFormXFormClass);
        val _component_x_sheet = resolveEasyComponent("x-sheet", GenUniModulesTmxUiComponentsXSheetXSheetClass);
        return createElementVNode("scroll-view", utsMapOf("style" to normalizeStyle(utsMapOf("flex" to "1"))), utsArrayOf(
            createVNode(_component_x_sheet, null, utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                return utsArrayOf(
                    createVNode(_component_x_form, utsMapOf("onSubmit" to _ctx.submitData, "model-value" to _ctx.formData), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                        return utsArrayOf(
                            createVNode(_component_x_form_item, utsMapOf("rule" to _ctx.validname, "field" to "username", "label" to "联系姓名", "required" to true), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                                return utsArrayOf(
                                    createVNode(_component_x_input, utsMapOf("color" to "transparent", "modelValue" to _ctx.reqData.username, "onUpdate:modelValue" to fun(`$event`: String){
                                        _ctx.reqData.username = `$event`;
                                    }
                                    , "align" to "right"), null, 8, utsArrayOf(
                                        "modelValue",
                                        "onUpdate:modelValue"
                                    ))
                                );
                            }
                            ), "_" to 1), 8, utsArrayOf(
                                "rule"
                            )),
                            createVNode(_component_x_form_item, utsMapOf("rule" to _ctx.vaildTitles, "field" to "title", "label" to "产品标题", "required" to true), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                                return utsArrayOf(
                                    createVNode(_component_x_input, utsMapOf("color" to "transparent", "modelValue" to _ctx.reqData.title, "onUpdate:modelValue" to fun(`$event`: String){
                                        _ctx.reqData.title = `$event`;
                                    }
                                    , "align" to "right"), null, 8, utsArrayOf(
                                        "modelValue",
                                        "onUpdate:modelValue"
                                    ))
                                );
                            }
                            ), "_" to 1), 8, utsArrayOf(
                                "rule"
                            )),
                            createVNode(_component_x_form_item, utsMapOf("rule" to _ctx.vaildPrices, "field" to "price", "label" to "产品价格", "required" to true), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                                return utsArrayOf(
                                    createVNode(_component_x_input, utsMapOf("color" to "transparent", "type" to "number", "modelValue" to _ctx.reqData.price, "onUpdate:modelValue" to fun(`$event`: String){
                                        _ctx.reqData.price = `$event`;
                                    }
                                    , "right-text" to "万元", "align" to "right"), null, 8, utsArrayOf(
                                        "modelValue",
                                        "onUpdate:modelValue"
                                    ))
                                );
                            }
                            ), "_" to 1), 8, utsArrayOf(
                                "rule"
                            )),
                            createVNode(_component_x_form_item, utsMapOf("show-bottom-boder" to false, "rule" to _ctx.vaildNums, "field" to "num", "label" to "库存数量", "required" to true), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                                return utsArrayOf(
                                    createElementVNode("view", utsMapOf("class" to "flex flex-row flex-row-center-end"), utsArrayOf(
                                        createVNode(_component_x_stepper, utsMapOf("width" to "120", "modelValue" to _ctx.reqData.num, "onUpdate:modelValue" to fun(`$event`: Number){
                                            _ctx.reqData.num = `$event`;
                                        }
                                        ), null, 8, utsArrayOf(
                                            "modelValue",
                                            "onUpdate:modelValue"
                                        ))
                                    ))
                                );
                            }
                            ), "_" to 1), 8, utsArrayOf(
                                "rule"
                            )),
                            createVNode(_component_x_radio_group, null, utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                                return utsArrayOf(
                                    createVNode(_component_x_radio)
                                );
                            }
                            ), "_" to 1)),
                            createVNode(_component_x_checkbox_group, null, utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                                return utsArrayOf(
                                    createVNode(_component_x_checkbox)
                                );
                            }
                            ), "_" to 1)),
                            createVNode(_component_x_button, utsMapOf("form-type" to "form", "class" to "mt-32", "block" to true), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                                return utsArrayOf(
                                    "保存资料"
                                );
                            }
                            ), "_" to 1)),
                            createVNode(_component_x_text, utsMapOf("font-size" to "12", "color" to "error", "class" to "text-align-center pt-24"), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                                return utsArrayOf(
                                    "表单收集与组件不是绑定结构只与form-item绑定，因此不会像官方那样局限，可以作为一个数据验证器来理解。"
                                );
                            }
                            ), "_" to 1))
                        );
                    }
                    ), "_" to 1), 8, utsArrayOf(
                        "onSubmit",
                        "model-value"
                    ))
                );
            }
            ), "_" to 1)),
            createVNode(_component_x_sheet, null, utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                return utsArrayOf(
                    createVNode(_component_x_text, utsMapOf("font-size" to "18", "class" to "text-weight-b"), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                        return utsArrayOf(
                            "风格可以自己随意变化"
                        );
                    }
                    ), "_" to 1))
                );
            }
            ), "_" to 1)),
            createVNode(_component_x_sheet, null, utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                return utsArrayOf(
                    createVNode(_component_x_form, utsMapOf("onSubmit" to _ctx.submit, "model-value" to _ctx._logindata, "label-direction" to "vertical"), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                        return utsArrayOf(
                            createVNode(_component_x_form_item, utsMapOf("showBottomBorder" to false, "rule" to _ctx.validname, "field" to "user", "label" to "用户帐号", "required" to true), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                                return utsArrayOf(
                                    createVNode(_component_x_input, utsMapOf("darkBgColor" to "", "left-icon" to "account-pin-circle-fill", "placeholder" to "请输入你的帐号", "modelValue" to _ctx.logindata.user, "onUpdate:modelValue" to fun(`$event`: String){
                                        _ctx.logindata.user = `$event`;
                                    }
                                    ), null, 8, utsArrayOf(
                                        "modelValue",
                                        "onUpdate:modelValue"
                                    ))
                                );
                            }
                            ), "_" to 1), 8, utsArrayOf(
                                "rule"
                            )),
                            createVNode(_component_x_form_item, utsMapOf("showBottomBorder" to false, "rule" to _ctx.vaildPasss, "field" to "pass", "label" to "登录密码", "required" to true), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                                return utsArrayOf(
                                    createVNode(_component_x_input, utsMapOf("darkBgColor" to "", "password" to true, "left-icon" to "lock-password-fill", "placeholder" to "请输入8位密码", "modelValue" to _ctx.logindata.pass, "onUpdate:modelValue" to fun(`$event`: String){
                                        _ctx.logindata.pass = `$event`;
                                    }
                                    ), null, 8, utsArrayOf(
                                        "modelValue",
                                        "onUpdate:modelValue"
                                    ))
                                );
                            }
                            ), "_" to 1), 8, utsArrayOf(
                                "rule"
                            )),
                            createVNode(_component_x_button, utsMapOf("form-type" to "form", "class" to "mt-32", "icon" to "lock-unlock-fill", "block" to true), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                                return utsArrayOf(
                                    "登入"
                                );
                            }
                            ), "_" to 1))
                        );
                    }
                    ), "_" to 1), 8, utsArrayOf(
                        "onSubmit",
                        "model-value"
                    ))
                );
            }
            ), "_" to 1)),
            createElementVNode("view", utsMapOf("style" to normalizeStyle(utsMapOf("height" to "550px"))), null, 4)
        ), 4);
    }
    open var validname: UTSArray<FORM_RULE> by `$data`;
    open var vaildTitles: UTSArray<FORM_RULE> by `$data`;
    open var vaildPrices: UTSArray<FORM_RULE> by `$data`;
    open var vaildNums: UTSArray<FORM_RULE> by `$data`;
    open var vaildPasss: UTSArray<FORM_RULE> by `$data`;
    open var reqData: USER_TYPE by `$data`;
    open var logindata: LOGIN_TYPE by `$data`;
    open var formData: UTSJSONObject by `$data`;
    open var _logindata: UTSJSONObject by `$data`;
    @Suppress("USELESS_CAST")
    override fun data(): Map<String, Any?> {
        var vaildUsername = utsArrayOf<FORM_RULE>(FORM_RULE(type = "string", errorMessage = "姓名填写不正确，不能空，且要小于4个字符", valid = fun(kVal: Any): Boolean {
            var pval = kVal as String;
            return pval.length > 0 && pval.length <= 4;
        }
        ));
        var vaildTitle = utsArrayOf<FORM_RULE>(FORM_RULE(type = "string", errorMessage = "产品标题不空，且大于5个字符小于12个字符", valid = fun(kVal: Any): Boolean {
            var pval = kVal as String;
            return pval.length > 5 && pval.length <= 12;
        }
        ));
        var vaildPrice = utsArrayOf<FORM_RULE>(FORM_RULE(type = "string", errorMessage = "价格不能小于30元", valid = fun(kVal: Any): Boolean {
            var valStr = kVal as String;
            var pval = parseInt(valStr);
            return pval >= 30 && valStr != "";
        }
        ));
        var vaildNum = utsArrayOf<FORM_RULE>(FORM_RULE(type = "number", errorMessage = "商品库存在2-200之间", valid = fun(kVal: Any): Boolean {
            var pval = kVal as Number;
            return pval >= 2 && pval <= 200;
        }
        ));
        var vaildPass = utsArrayOf<FORM_RULE>(FORM_RULE(type = "number", errorMessage = "请输入8位密码", valid = fun(kVal: Any): Boolean {
            var pval = kVal as String;
            return pval.length == 8;
        }
        ));
        return utsMapOf("validname" to vaildUsername as UTSArray<FORM_RULE>, "vaildTitles" to vaildTitle as UTSArray<FORM_RULE>, "vaildPrices" to vaildPrice as UTSArray<FORM_RULE>, "vaildNums" to vaildNum as UTSArray<FORM_RULE>, "vaildPasss" to vaildPass as UTSArray<FORM_RULE>, "reqData" to USER_TYPE(username = "", password = "", title = "", price = "", num = 0), "logindata" to LOGIN_TYPE(user = "", pass = ""), "formData" to computed<UTSJSONObject>(fun(): UTSJSONObject {
            this.reqData.username;
            this.reqData.title;
            this.reqData.price;
            this.reqData.num;
            return JSON.parseObject(JSON.stringify(this.reqData))!!;
        }
        ), "_logindata" to computed<UTSJSONObject>(fun(): UTSJSONObject {
            this.logindata.user;
            this.logindata.pass;
            return JSON.parseObject(JSON.stringify(this.logindata))!!;
        }
        ));
    }
    override fun `$initMethods`() {
        this.submitData = fun(evt: FORM_SUBMIT_RESULT) {
            if (!evt.valid) {
                uni_showToast(ShowToastOptions(title = evt.errorMessage, icon = "none"));
                return;
            }
        }
        ;
        this.submit = fun(evt: FORM_SUBMIT_RESULT) {
            if (!evt.valid) {
                uni_showToast(ShowToastOptions(title = evt.errorMessage, icon = "none"));
                return;
            }
        }
        ;
    }
    open lateinit var submitData: (evt: FORM_SUBMIT_RESULT) -> Unit;
    open lateinit var submit: (evt: FORM_SUBMIT_RESULT) -> Unit;
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
