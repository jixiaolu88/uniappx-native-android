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
open class GenUniModulesTmxUiComponentsXCheckboxXCheckbox : VueComponent {
    constructor(instance: ComponentInternalInstance) : super(instance) {
        onBeforeUnmount(fun() {
            this.isDestroy = true;
        }
        , instance);
        onMounted(fun() {
            var t = this;
            this.isDestroy = false;
            this.`$nextTick`(fun(){
                t.nowValue = t.modelValue;
                t.setAni();
                t.pushDataToParent(false);
            }
            );
        }
        , instance);
        this.`$watch`(fun(): Any? {
            return this.modelValue;
        }
        , fun(newValue: String) {
            if (newValue == this.nowValue) {
                return;
            }
            this.nowValue = newValue;
            this.setAni();
        }
        );
    }
    @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
    override fun `$render`(): Any? {
        val _ctx = this;
        val _cache = this.`$`.renderCache;
        val _component_x_icon = resolveEasyComponent("x-icon", GenUniModulesTmxUiComponentsXIconXIconClass);
        val _component_x_text = resolveEasyComponent("x-text", GenUniModulesTmxUiComponentsXTextXTextClass);
        return createElementVNode("view", utsMapOf("class" to normalizeClass(utsArrayOf(
            utsArrayOf(
                if (_ctx._disabled) {
                    "checkboxDisabled";
                } else {
                    "";
                }
            ),
            "checkbox"
        )), "onClick" to _ctx.boxClick), utsArrayOf(
            if (isTrue(!_ctx.hiddenCheckbox)) {
                createElementVNode("view", utsMapOf("key" to 0, "class" to "checkboxBox", "style" to normalizeStyle(utsMapOf("backgroundColor" to if (_ctx._isCheck) {
                    _ctx._color;
                } else {
                    "transparent";
                }, "border" to ("1px solid " + (if (_ctx._isCheck) {
                    _ctx._color;
                } else {
                    _ctx._unCheckColor;
                })), "width" to _ctx._size, "height" to _ctx._size))), utsArrayOf(
                    createElementVNode("view", utsMapOf("id" to _ctx.boxId, "ref" to "checkboxBoxIcon", "class" to "checkboxBoxIcon"), utsArrayOf(
                        createVNode(_component_x_icon, utsMapOf("color" to "white", "name" to if (_ctx._indeterminate) {
                            "subtract-fill";
                        } else {
                            _ctx.icon;
                        }, "font-size" to _ctx.iconSize), null, 8, utsArrayOf(
                            "name",
                            "font-size"
                        ))
                    ), 8, utsArrayOf(
                        "id"
                    ))
                ), 4);
            } else {
                createCommentVNode("v-if", true);
            }
            ,
            createElementVNode("view", utsMapOf("class" to normalizeClass(utsArrayOf(
                "checkboxLabelBox",
                utsArrayOf(
                    if (!_ctx.hiddenCheckbox) {
                        "checkboxLabelBoxLeftSpace";
                    } else {
                        "";
                    }
                )
            ))), utsArrayOf(
                renderSlot(_ctx.`$slots`, "label", GenUniModulesTmxUiComponentsXCheckboxXCheckboxSlotDataLabel(checked = _ctx._isCheck, value = _ctx.nowValue), fun(): UTSArray<Any> {
                    return utsArrayOf(
                        createVNode(_component_x_text, utsMapOf("class" to "checkboxLabel"), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                            return utsArrayOf(
                                toDisplayString(_ctx._label)
                            );
                        }
                        ), "_" to 1))
                    );
                }
                )
            ), 2)
        ), 10, utsArrayOf(
            "onClick"
        ));
    }
    open var color: String by `$props`;
    open var unCheckColor: String by `$props`;
    open var darkUnCheckColor: String by `$props`;
    open var modelValue: String by `$props`;
    open var value: String by `$props`;
    open var unCheckValue: String by `$props`;
    open var disabled: Boolean by `$props`;
    open var icon: String by `$props`;
    open var label: String by `$props`;
    open var hiddenCheckbox: Boolean by `$props`;
    open var indeterminate: Boolean by `$props`;
    open var size: String by `$props`;
    open var iconSize: String by `$props`;
    open var nowValue: String by `$data`;
    open var boxId: Any? by `$data`;
    open var tid: Number by `$data`;
    open var isDestroy: Boolean by `$data`;
    open var _color: String by `$data`;
    open var _unCheckColor: String by `$data`;
    open var _isCheck: Boolean by `$data`;
    open var _disabled: Boolean by `$data`;
    open var _label: String by `$data`;
    open var _indeterminate: Boolean by `$data`;
    open var _size: String by `$data`;
    @Suppress("USELESS_CAST")
    override fun data(): Map<String, Any?> {
        return utsMapOf("nowValue" to "1", "boxId" to ("xCheckbox-" + getUid()), "tid" to 0, "isDestroy" to false, "_color" to computed<String>(fun(): String {
            if (this.color == "") {
                return getDefaultColor(xConfig.color);
            }
            return getDefaultColor(this.color);
        }
        ), "_unCheckColor" to computed<String>(fun(): String {
            if (xConfig.dark == "dark" && this.darkUnCheckColor != "") {
                return getDefaultColor(this.darkUnCheckColor);
            }
            if (this.unCheckColor == "") {
                return getDefaultColor(xConfig.unRadioAndCheckBoxColor);
            }
            return getDefaultColor(this.unCheckColor);
        }
        ), "_isCheck" to computed<Boolean>(fun(): Boolean {
            return this.nowValue == this.value;
        }
        ), "_disabled" to computed<Boolean>(fun(): Boolean {
            return this.disabled;
        }
        ), "_label" to computed<String>(fun(): String {
            return this.label;
        }
        ), "_indeterminate" to computed<Boolean>(fun(): Boolean {
            return this.indeterminate;
        }
        ), "_size" to computed<String>(fun(): String {
            var size = checkIsCssUnit(this.size, xConfig.unit);
            if (xConfig.fontScale == 1) {
                return size;
            }
            var sizeNumber = parseInt(size);
            if (isNaN(sizeNumber)) {
                sizeNumber = 24;
            }
            return (sizeNumber * xConfig.fontScale).toString() + getUnit(size);
        }
        ));
    }
    override fun `$initMethods`() {
        this.boxClick = fun() {
            this.`$emit`("click");
            if (this._disabled) {
                return;
            }
            if (this._isCheck && !this.indeterminate) {
                this.nowValue = this.unCheckValue;
            } else {
                this.nowValue = this.value;
            }
            this.`$emit`("update:modelValue", this.nowValue);
            this.`$emit`("change", this._isCheck, this.nowValue);
            this.pushDataToParent(true);
            this.setAni();
        }
        ;
        this.setAni = fun() {
            if (this.hiddenCheckbox || this.isDestroy) {
                return;
            }
            try {
                var el = this.`$refs`["checkboxBoxIcon"] as Element;
                el.style.setProperty("opacity", if (this._isCheck) {
                    1;
                } else {
                    0;
                }
                );
                el.style.setProperty("transform", "scale(" + (if (this._isCheck) {
                    0.74;
                } else {
                    0;
                }
                ) + ")");
            }
             catch (e: Throwable) {}
        }
        ;
        this.setSelected = fun(kVal: UTSArray<String>) {
            if (!UTSArray.isArray(kVal)) {
                throw UTSError("val must be an array");
            }
            val isChecked = kVal.includes(this.value);
            if (isChecked) {
                this.nowValue = this.value;
            } else {
                this.nowValue = this.unCheckValue;
            }
            this.setAni();
        }
        ;
        this.pushDataToParent = fun(isChange: Boolean) {
            var parent: GenUniModulesTmxUiComponentsXCheckboxGroupXCheckboxGroupComponentPublicInstance? = null;
            try {
                parent = this.`$parent` as GenUniModulesTmxUiComponentsXCheckboxGroupXCheckboxGroupComponentPublicInstance?;
            }
             catch (e: Throwable) {}
            if (parent == null) {
                return;
            }
            var parents = parent as GenUniModulesTmxUiComponentsXCheckboxGroupXCheckboxGroupComponentPublicInstance;
            parents.addItem(this, CHECKBOX_ITEM_INFO(id = this.boxId as String, nowvalue = this.nowValue, value = this.value, unvalue = this.unCheckValue), isChange);
        }
        ;
    }
    open lateinit var boxClick: () -> Unit;
    open lateinit var setAni: () -> Unit;
    open lateinit var setSelected: (kVal: UTSArray<String>) -> Unit;
    open lateinit var pushDataToParent: (isChange: Boolean) -> Unit;
    companion object {
        val styles: Map<String, Map<String, Map<String, Any>>>
            get() {
                return normalizeCssStyles(utsArrayOf(
                    styles0
                ));
            }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return utsMapOf("checkbox" to padStyleMapOf(utsMapOf("display" to "flex", "flexDirection" to "row", "alignItems" to "center", "justifyContent" to "flex-start")), "checkboxLabelBox" to padStyleMapOf(utsMapOf("flex" to 1)), "checkboxDisabled" to padStyleMapOf(utsMapOf("opacity" to 0.7)), "checkboxBoxIcon" to padStyleMapOf(utsMapOf("transitionDuration" to "350ms", "transitionTimingFunction" to "cubic-bezier(0.18,0.89,0.32,1)", "transitionProperty" to "opacity,transform", "opacity" to 0, "transform" to "scale(0)")), "checkboxBox" to padStyleMapOf(utsMapOf("borderRadius" to 4, "display" to "flex", "flexDirection" to "row", "alignItems" to "center", "justifyContent" to "center")), "checkboxLabelBoxLeftSpace" to padStyleMapOf(utsMapOf("paddingLeft" to 10)), "checkboxLabel" to padStyleMapOf(utsMapOf("fontSize" to 14)), "@TRANSITION" to utsMapOf("checkboxBoxIcon" to utsMapOf("duration" to "350ms", "timingFunction" to "cubic-bezier(0.18,0.89,0.32,1)", "property" to "opacity,transform")));
            }
        var inheritAttrs = true;
        var inject: Map<String, Map<String, Any?>> = utsMapOf();
        var emits: Map<String, Any?> = utsMapOf("change" to null, "click" to null, "update:modelValue" to null);
        var props = normalizePropsOptions(utsMapOf("color" to utsMapOf("type" to "String", "default" to ""), "unCheckColor" to utsMapOf("type" to "String", "default" to ""), "darkUnCheckColor" to utsMapOf("type" to "String", "default" to ""), "modelValue" to utsMapOf("type" to "String", "default" to "0"), "value" to utsMapOf("type" to "String", "default" to "1"), "unCheckValue" to utsMapOf("type" to "String", "default" to "0"), "disabled" to utsMapOf("type" to "Boolean", "default" to false), "icon" to utsMapOf("type" to "String", "default" to "check-line"), "label" to utsMapOf("type" to "String", "default" to ""), "hiddenCheckbox" to utsMapOf("type" to "Boolean", "default" to false), "indeterminate" to utsMapOf("type" to "Boolean", "default" to false), "size" to utsMapOf("type" to "String", "default" to "24"), "iconSize" to utsMapOf("type" to "String", "default" to "20")));
        var propsNeedCastKeys = utsArrayOf(
            "color",
            "unCheckColor",
            "darkUnCheckColor",
            "modelValue",
            "value",
            "unCheckValue",
            "disabled",
            "icon",
            "label",
            "hiddenCheckbox",
            "indeterminate",
            "size",
            "iconSize"
        );
        var components: Map<String, CreateVueComponent> = utsMapOf();
    }
}
