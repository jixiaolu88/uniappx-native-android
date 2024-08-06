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
open class GenUniModulesTmxUiComponentsXStepperXStepper : VueComponent {
    constructor(instance: ComponentInternalInstance) : super(instance) {
        onMounted(fun() {
            this.setValue(this.modelValue, false);
        }
        , instance);
        this.`$watch`(fun(): Any? {
            return this.modelValue;
        }
        , fun(newval: Number) {
            if (newval == this._value) {
                return;
            }
            this.setValue(newval, false);
        }
        );
    }
    @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
    override fun `$render`(): Any? {
        val _ctx = this;
        val _cache = this.`$`.renderCache;
        val _component_x_icon = resolveEasyComponent("x-icon", GenUniModulesTmxUiComponentsXIconXIconClass);
        return createElementVNode("view", utsMapOf("class" to "xStepper", "style" to normalizeStyle(utsMapOf("width" to _ctx._width))), utsArrayOf(
            createElementVNode("view", utsMapOf("hover-start-time" to 20, "hover-stay-time" to 150, "hover-class" to if (_ctx.addDomDisabeld) {
                "";
            } else {
                "xStepperHoverbtn";
            }
            , "onClick" to _ctx.handleDecrement, "class" to "xStepperBtn", "style" to normalizeStyle(utsMapOf("backgroundColor" to _ctx._btnColor, "height" to _ctx._height, "width" to _ctx._btnWidth, "opacity" to if (_ctx.surDomDisabeld) {
                0.6;
            } else {
                1;
            }
            , "borderRadius" to if (_ctx._splitBtn) {
                "50px";
            } else {
                "0rpx";
            }
            ))), utsArrayOf(
                createVNode(_component_x_icon, utsMapOf("class" to "xStepperBtnBtn", "color" to _ctx._btnFontColor, "font-size" to _ctx._unFontSize, "name" to "subtract-line"), null, 8, utsArrayOf(
                    "color",
                    "font-size"
                ))
            ), 12, utsArrayOf(
                "hover-class",
                "onClick"
            )),
            createElementVNode("input", utsMapOf("onBlur" to _ctx.inputBlur, "onInput" to _ctx.handleInputChange, "value" to _ctx._input_value, "class" to "xStepperInput", "style" to normalizeStyle(utsMapOf("backgroundColor" to if (_ctx._splitBtn) {
                "transparent";
            } else {
                _ctx._btnColor;
            }
            , "height" to _ctx._height, "color" to _ctx._fontColor, "fontSize" to _ctx._fontSize)), "type" to if (_ctx.decimalLen > 0) {
                "digit";
            } else {
                "number";
            }
            ), null, 44, utsArrayOf(
                "onBlur",
                "onInput",
                "value",
                "type"
            )),
            createElementVNode("view", utsMapOf("hover-start-time" to 20, "hover-stay-time" to 150, "hover-class" to if (_ctx.addDomDisabeld) {
                "";
            } else {
                "xStepperHoverbtn";
            }
            , "onClick" to _ctx.handleIncrement, "class" to "xStepperBtn", "style" to normalizeStyle(utsMapOf("backgroundColor" to _ctx._btnColor, "height" to _ctx._height, "width" to _ctx._btnWidth, "borderRadius" to if (_ctx._splitBtn) {
                "50px";
            } else {
                "0rpx";
            }
            ))), utsArrayOf(
                createVNode(_component_x_icon, utsMapOf("class" to "xStepperBtnBtn", "style" to normalizeStyle(utsMapOf("opacity" to if (_ctx.addDomDisabeld) {
                    0.6;
                } else {
                    1;
                }
                )), "color" to _ctx._btnFontColor, "font-size" to _ctx._unFontSize, "name" to "add-line"), null, 8, utsArrayOf(
                    "style",
                    "color",
                    "font-size"
                ))
            ), 12, utsArrayOf(
                "hover-class",
                "onClick"
            ))
        ), 4);
    }
    open var modelValue: Number by `$props`;
    open var max: Number by `$props`;
    open var width: String by `$props`;
    open var min: Number by `$props`;
    open var disabled: Boolean by `$props`;
    open var step: Number by `$props`;
    open var decimalLen: Number by `$props`;
    open var btnColor: String by `$props`;
    open var darkBtnColor: String by `$props`;
    open var bgColor: String by `$props`;
    open var darkBgColor: String by `$props`;
    open var btnWidth: String by `$props`;
    open var height: String by `$props`;
    open var round: String by `$props`;
    open var splitBtn: Boolean by `$props`;
    open var btnFontColor: String by `$props`;
    open var fontColor: String by `$props`;
    open var fontSize: String by `$props`;
    open var _value: Number by `$data`;
    open var _input_value: String by `$data`;
    open var addDomDisabeld: Boolean by `$data`;
    open var surDomDisabeld: Boolean by `$data`;
    open var _round: String by `$data`;
    open var _width: String by `$data`;
    open var _fontSize: String by `$data`;
    open var _unFontSize: String by `$data`;
    open var _btnFontColor: String by `$data`;
    open var _fontColor: String by `$data`;
    open var _height: String by `$data`;
    open var _btnWidth: String by `$data`;
    open var _splitBtn: Boolean by `$data`;
    open var _btnColor: String by `$data`;
    open var _bgColor: String by `$data`;
    open var _max: Number by `$data`;
    open var _min: Number by `$data`;
    open var _step: Number by `$data`;
    open var _disabled: Boolean by `$data`;
    @Suppress("USELESS_CAST")
    override fun data(): Map<String, Any?> {
        return utsMapOf("_value" to 0, "_input_value" to "", "addDomDisabeld" to false, "surDomDisabeld" to false, "_round" to computed<String>(fun(): String {
            if (this.round == "") {
                return checkIsCssUnit(xConfig.progressRadius, xConfig.unit);
            }
            return checkIsCssUnit(this.round, xConfig.unit);
        }
        ), "_width" to computed<String>(fun(): String {
            return checkIsCssUnit(this.width, xConfig.unit);
        }
        ), "_fontSize" to computed<String>(fun(): String {
            var fontSize = checkIsCssUnit(this.fontSize, xConfig.unit);
            if (xConfig.fontScale == 1) {
                return fontSize;
            }
            var sizeNumber = parseInt(fontSize);
            if (isNaN(sizeNumber)) {
                sizeNumber = 14;
            }
            return (sizeNumber * xConfig.fontScale).toString() + getUnit(fontSize);
        }
        ), "_unFontSize" to computed<String>(fun(): String {
            return this.fontSize;
        }
        ), "_btnFontColor" to computed<String>(fun(): String {
            return getDefaultColor(this.btnFontColor);
        }
        ), "_fontColor" to computed<String>(fun(): String {
            if (xConfig.dark == "dark") {
                return "#ffffff";
            }
            return getDefaultColor(this.fontColor);
        }
        ), "_height" to computed<String>(fun(): String {
            return checkIsCssUnit(this.height, xConfig.unit);
        }
        ), "_btnWidth" to computed<String>(fun(): String {
            return checkIsCssUnit(this.btnWidth, xConfig.unit);
        }
        ), "_splitBtn" to computed<Boolean>(fun(): Boolean {
            return this.splitBtn;
        }
        ), "_btnColor" to computed<String>(fun(): String {
            var color = getDefaultColor(this.btnColor);
            if (xConfig.dark == "dark") {
                if (this.darkBtnColor == "") {
                    color = xConfig.inputDarkColor;
                } else {
                    color = getDefaultColor(this.darkBtnColor);
                }
            }
            return color;
        }
        ), "_bgColor" to computed<String>(fun(): String {
            var color = getDefaultColor(this.bgColor);
            if (xConfig.dark == "dark") {
                if (this.darkBgColor == "") {
                    color = xConfig.inputDarkColor;
                } else {
                    color = getDefaultColor(this.darkBgColor);
                }
            }
            return color;
        }
        ), "_max" to computed<Number>(fun(): Number {
            return this.max;
        }
        ), "_min" to computed<Number>(fun(): Number {
            return this.min;
        }
        ), "_step" to computed<Number>(fun(): Number {
            return this.step;
        }
        ), "_disabled" to computed<Boolean>(fun(): Boolean {
            return this.disabled;
        }
        ));
    }
    override fun `$initMethods`() {
        this.isInRange = fun(value: Number): Boolean {
            return value >= this._min && value <= this._max;
        }
        ;
        this.clampValue = fun(value: Number): Number {
            return Math.min(Math.max(value, this._min), this._max);
        }
        ;
        this.getDecimalPlaces = fun(): Number {
            return this.decimalLen;
        }
        ;
        this.handleIncrement = fun() {
            val newValue = Math.min(this._value + this._step, this.max);
            var kVal = this.clampValue(parseFloat(newValue.toFixed(this.decimalLen)));
            this.setValue(kVal, true);
        }
        ;
        this.handleDecrement = fun() {
            val newValue = Math.max(this._value - this._step, this.min);
            var kVal = this.clampValue(parseFloat(newValue.toFixed(this.decimalLen)));
            this.setValue(kVal, true);
        }
        ;
        this.handleInputChange = fun(event: UniInputEvent) {
            this._input_value = event.detail.value;
        }
        ;
        this.inputBlur = fun() {
            val inputValue = parseFloat(this._input_value);
            if (!isNaN(inputValue)) {
                var kVal = this.clampValue(inputValue);
                this.setValue(kVal, true);
            } else {
                this.setValue(parseFloat(this._min.toFixed(this.decimalLen)), true);
            }
        }
        ;
        this.setValue = fun(value: Number, isEmit: Boolean) {
            val clampedValue = this.clampValue(value);
            this._value = clampedValue;
            this._input_value = this._value.toString();
            this.addDomDisabeld = this._value >= this.max;
            this.surDomDisabeld = this._value <= this.min;
            if (isEmit) {
                this.`$emit`("update:modelValue", clampedValue);
                this.`$emit`("change", clampedValue);
            }
        }
        ;
    }
    open lateinit var isInRange: (value: Number) -> Boolean;
    open lateinit var clampValue: (value: Number) -> Number;
    open lateinit var getDecimalPlaces: () -> Number;
    open lateinit var handleIncrement: () -> Unit;
    open lateinit var handleDecrement: () -> Unit;
    open lateinit var handleInputChange: (event: UniInputEvent) -> Unit;
    open lateinit var inputBlur: () -> Unit;
    open lateinit var setValue: (value: Number, isEmit: Boolean) -> Unit;
    companion object {
        val styles: Map<String, Map<String, Map<String, Any>>>
            get() {
                return normalizeCssStyles(utsArrayOf(
                    styles0
                ));
            }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return utsMapOf("xStepperBtnBtn" to padStyleMapOf(utsMapOf("pointerEvents" to "none")), "xStepperHoverbtn" to padStyleMapOf(utsMapOf("opacity" to 0.8)), "xStepper" to padStyleMapOf(utsMapOf("display" to "flex", "flexDirection" to "row")), "xStepperInput" to padStyleMapOf(utsMapOf("flex" to 1, "marginTop" to 0, "marginRight" to 1, "marginBottom" to 0, "marginLeft" to 1, "paddingTop" to 0, "paddingRight" to 5, "paddingBottom" to 0, "paddingLeft" to 5, "textAlign" to "center")), "xStepperBtn" to padStyleMapOf(utsMapOf("display" to "flex", "flexDirection" to "row", "justifyContent" to "center", "alignItems" to "center")));
            }
        var inheritAttrs = true;
        var inject: Map<String, Map<String, Any?>> = utsMapOf();
        var emits: Map<String, Any?> = utsMapOf("change" to null, "update:modelValue" to null);
        var props = normalizePropsOptions(utsMapOf("modelValue" to utsMapOf("type" to "Number", "default" to 0), "max" to utsMapOf("type" to "Number", "default" to 100), "width" to utsMapOf("type" to "String", "default" to "auto"), "min" to utsMapOf("type" to "Number", "default" to 0), "disabled" to utsMapOf("type" to "Boolean", "default" to false), "step" to utsMapOf("type" to "Number", "default" to 1), "decimalLen" to utsMapOf("type" to "Number", "default" to 0), "btnColor" to utsMapOf("type" to "String", "default" to "info"), "darkBtnColor" to utsMapOf("type" to "String", "default" to ""), "bgColor" to utsMapOf("type" to "String", "default" to "info"), "darkBgColor" to utsMapOf("type" to "String", "default" to ""), "btnWidth" to utsMapOf("type" to "String", "default" to "36"), "height" to utsMapOf("type" to "String", "default" to "36"), "round" to utsMapOf("type" to "String", "default" to "4"), "splitBtn" to utsMapOf("type" to "Boolean", "default" to false), "btnFontColor" to utsMapOf("type" to "String", "default" to "#333333"), "fontColor" to utsMapOf("type" to "String", "default" to "#333333"), "fontSize" to utsMapOf("type" to "String", "default" to "14")));
        var propsNeedCastKeys = utsArrayOf(
            "modelValue",
            "max",
            "width",
            "min",
            "disabled",
            "step",
            "decimalLen",
            "btnColor",
            "darkBtnColor",
            "bgColor",
            "darkBgColor",
            "btnWidth",
            "height",
            "round",
            "splitBtn",
            "btnFontColor",
            "fontColor",
            "fontSize"
        );
        var components: Map<String, CreateVueComponent> = utsMapOf();
    }
}
