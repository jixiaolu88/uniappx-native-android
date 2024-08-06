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
import io.dcloud.uniapp.extapi.navigateTo as uni_navigateTo;
open class GenUniModulesTmxUiComponentsXTagXTag : VueComponent {
    constructor(instance: ComponentInternalInstance) : super(instance) {
        onMounted(fun() {
            this.customStyles();
        }
        , instance);
        this.`$watch`(fun(): Any? {
            return this._color;
        }
        , fun() {
            this.customStyles();
        }
        );
        this.`$watch`(fun(): Any? {
            return this.color;
        }
        , fun() {
            this.customStyles();
        }
        );
        this.`$watch`(fun(): Any? {
            return this.bgColor;
        }
        , fun() {
            this.customStyles();
        }
        );
        this.`$watch`(fun(): Any? {
            return this.borderColor;
        }
        , fun() {
            this.customStyles();
        }
        );
    }
    @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
    override fun `$render`(): Any? {
        val _ctx = this;
        val _cache = this.`$`.renderCache;
        val _component_x_icon = resolveEasyComponent("x-icon", GenUniModulesTmxUiComponentsXIconXIconClass);
        return createElementVNode("view", utsMapOf("disabled" to _ctx._disabled, "onClick" to _ctx.clickListen, "class" to normalizeClass(utsArrayOf(
            _ctx._class_name,
            "button"
        )), "style" to normalizeStyle(_ctx._styleMap)), utsArrayOf(
            if (isTrue(_ctx._icon != "" && !_ctx._loading)) {
                createVNode(_component_x_icon, utsMapOf("key" to 0, "style" to normalizeStyle(utsMapOf("margin-right" to "5px")), "font-size" to _ctx._fontSize, "color" to _ctx._set_font_color, "name" to _ctx._icon), null, 8, utsArrayOf(
                    "style",
                    "font-size",
                    "color",
                    "name"
                ));
            } else {
                createCommentVNode("v-if", true);
            }
            ,
            createElementVNode("text", utsMapOf("style" to normalizeStyle(utsMapOf("color" to _ctx._set_font_color, "font-size" to _ctx._fontSize))), utsArrayOf(
                renderSlot(_ctx.`$slots`, "default")
            ), 4)
        ), 14, utsArrayOf(
            "disabled",
            "onClick"
        ));
    }
    open var _class: String by `$props`;
    open var _style: String by `$props`;
    open var color: String by `$props`;
    open var bgColor: String by `$props`;
    open var darkBgColor: String by `$props`;
    open var linearGradient: UTSArray<String> by `$props`;
    open var fontColor: String by `$props`;
    open var fontSize: String by `$props`;
    open var round: Number by `$props`;
    open var border: Number by `$props`;
    open var borderColor: String by `$props`;
    open var darkBorderColor: String by `$props`;
    open var skin: String by `$props`;
    open var icon: String by `$props`;
    open var size: String by `$props`;
    open var url: String by `$props`;
    open var disabled: Boolean by `$props`;
    open var loading: Boolean by `$props`;
    open var height: String by `$props`;
    open var _set_border_color: String by `$data`;
    open var _set_background_color: String by `$data`;
    open var _set_background_img: String by `$data`;
    open var _set_font_color: String by `$data`;
    open var _set_opacity: String by `$data`;
    open var _color: String by `$data`;
    open var _bgColor: String by `$data`;
    open var _class_name: String by `$data`;
    open var _borderColor: String by `$data`;
    open var _fontSize: String by `$data`;
    open var _disabled: Boolean by `$data`;
    open var _icon: String by `$data`;
    open var _radius: String by `$data`;
    open var _border: String by `$data`;
    open var _loading: Boolean by `$data`;
    open var _padding: String by `$data`;
    open var _height: String by `$data`;
    open var _styleMap: Map<String, String> by `$data`;
    @Suppress("USELESS_CAST")
    override fun data(): Map<String, Any?> {
        return utsMapOf("_set_border_color" to "1px solid #00000", "_set_background_color" to "#00000", "_set_background_img" to "", "_set_font_color" to "#00000", "_set_opacity" to "1", "_color" to computed<String>(fun(): String {
            var color = getDefaultColor(this.color);
            if (color == "") {
                color = xConfig.color;
            }
            return color;
        }
        ), "_bgColor" to computed<String>(fun(): String {
            var color = this.bgColor;
            if (xConfig.dark == "dark" && this.darkBgColor != "") {
                color = this.darkBgColor;
            }
            return color;
        }
        ), "_class_name" to computed<String>(fun(): String {
            return this._class;
        }
        ), "_borderColor" to computed<String>(fun(): String {
            var bordercolor = this.borderColor as String;
            if (xConfig.dark == "dark" && this.darkBorderColor != "") {
                bordercolor = this.darkBorderColor;
            }
            return bordercolor;
        }
        ), "_fontSize" to computed<String>(fun(): String {
            var fontSize = this.fontSize;
            if (fontSize == "") {
                if (this.size == "mini") {
                    return "9px";
                }
                if (this.size == "small") {
                    return "10px";
                }
                if (this.size == "mdeium") {
                    return "12px";
                }
                if (this.size == "normal") {
                    return "12px";
                }
                if (this.size == "large") {
                    return "16px";
                }
            }
            fontSize = checkIsCssUnit(fontSize, xConfig.unit);
            if (xConfig.fontScale == 1) {
                return fontSize;
            }
            var sizeNumber = parseInt(fontSize);
            if (isNaN(sizeNumber)) {
                sizeNumber = 16;
            }
            return (sizeNumber * xConfig.fontScale).toString() + getUnit(this.fontSize);
        }
        ), "_disabled" to computed<Boolean>(fun(): Boolean {
            if (this.disabled) {
                this._set_opacity = "0.7";
            }
            return this.disabled;
        }
        ), "_icon" to computed<String>(fun(): String {
            return this.icon;
        }
        ), "_radius" to computed<String>(fun(): String {
            if (this.round == -1) {
                return checkIsCssUnit(xConfig.tagRadius, xConfig.unit);
            }
            return checkIsCssUnit(this.round.toString(), xConfig.unit);
        }
        ), "_border" to computed<String>(fun(): String {
            return checkIsCssUnit(this.border.toString(), xConfig.unit);
        }
        ), "_loading" to computed<Boolean>(fun(): Boolean {
            if (this.loading) {
                this._set_opacity = "0.7";
            }
            return this.loading;
        }
        ), "_padding" to computed<String>(fun(): String {
            if (this.size == "mini") {
                return "0px 0px";
            }
            if (this.size == "small") {
                return "0px 3px";
            }
            if (this.size == "mdeium") {
                return "0px 5px";
            }
            if (this.size == "normal") {
                return "0px 8px";
            }
            if (this.size == "large") {
                return "0px 12px";
            }
            return "0rpx 8px";
        }
        ), "_height" to computed<String>(fun(): String {
            if (this.height != "") {
                return checkIsCssUnit(this.height, xConfig.unit);
            }
            if (this.size == "mini") {
                return "14px";
            }
            if (this.size == "small") {
                return "18px";
            }
            if (this.size == "mdeium") {
                return "20px";
            }
            if (this.size == "normal") {
                return "24px";
            }
            if (this.size == "large") {
                return "32px";
            }
            return checkIsCssUnit(this.height, xConfig.unit);
        }
        ), "_styleMap" to computed<Map<String, String>>(fun(): Map<String, String> {
            var styleMap = Map<String, String>();
            styleMap.set("padding", this._padding);
            styleMap.set("height", this._height);
            styleMap.set("border", this._set_border_color);
            styleMap.set("borderRadius", this._radius);
            styleMap.set("backgroundColor", this._set_background_color);
            styleMap.set("backgroundImage", this._set_background_img);
            styleMap.set("opacity", this._set_opacity);
            return styleMap;
        }
        ));
    }
    override fun `$initMethods`() {
        this.clickListen = fun(e: Any) {
            if (this._disabled == false) {
                this.`$emit`("click", e);
            }
            if (this._disabled == false && this.url != "") {
                uni_navigateTo(NavigateToOptions(url = this.url));
            }
        }
        ;
        this.customStyles = fun() {
            var color = getDefaultColor(this._color);
            var hoverColor = color;
            this._set_opacity = "1";
            if (this._disabled || this._loading) {
                this._set_opacity = "0.7";
            }
            var colorInit: UTSJSONObject = getDefaultColorObj(color, hoverColor);
            var borderStyle = "solid";
            if (this.skin == "text") {
                colorInit = getTextColorObj(color, hoverColor, xConfig.dark == "dark");
            }
            if (this.skin == "thin") {
                colorInit = getThinColorObj(color, hoverColor, xConfig.dark == "dark");
            }
            if (this.skin == "outline" || this.skin == "dashed") {
                colorInit = getOutlineColorObj(color, hoverColor);
            }
            if (this.skin == "dashed") {
                borderStyle = "dashed";
            }
            var defaultObj: UTSJSONObject = colorInit.getJSON("default")!!;
            var borderWidth = checkIsCssUnit(this.border.toString(), "rpx");
            var dbordercolor = getDefaultColor(this._borderColor);
            var background = getDefaultColor(this._bgColor);
            var fontcolor = getDefaultColor(this.fontColor);
            this._set_border_color = "" + borderWidth + " " + borderStyle + " " + (if (dbordercolor == "") {
                defaultObj.getString("borderColor")!!;
            } else {
                dbordercolor;
            }
            );
            this._set_background_color = if (background == "") {
                defaultObj.getString("background")!!;
            } else {
                background;
            }
            ;
            this._set_font_color = if (fontcolor == "") {
                defaultObj.getString("fontColor")!!;
            } else {
                fontcolor;
            }
            ;
            if (this.linearGradient.length > 0) {
                var dirs = this.linearGradient[0];
                if (this.linearGradient[0] == "top") {
                    dirs = "to top";
                } else if (this.linearGradient[0] == "bottom") {
                    dirs = "to bottom";
                } else if (this.linearGradient[0] == "left") {
                    dirs = "to left";
                } else if (this.linearGradient[0] == "right") {
                    dirs = "to right";
                }
                this._set_background_color = "";
                this._set_background_img = "linear-gradient(" + dirs + "," + this.linearGradient[1] + "," + this.linearGradient[2] + ")";
            }
        }
        ;
    }
    open lateinit var clickListen: (e: Any) -> Unit;
    open lateinit var customStyles: () -> Unit;
    companion object {
        val styles: Map<String, Map<String, Map<String, Any>>>
            get() {
                return normalizeCssStyles(utsArrayOf(
                    styles0
                ));
            }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return utsMapOf("button" to padStyleMapOf(utsMapOf("flexDirection" to "row", "alignItems" to "center", "alignContent" to "center")), "loadingMask" to padStyleMapOf(utsMapOf("position" to "absolute", "width" to "100%", "height" to "100%", "backgroundColor" to "rgba(200,200,200,0.6)", "display" to "flex", "flexDirection" to "row", "justifyContent" to "center", "alignItems" to "center")));
            }
        var inheritAttrs = true;
        var inject: Map<String, Map<String, Any?>> = utsMapOf();
        var emits: Map<String, Any?> = utsMapOf("click" to null);
        var props = normalizePropsOptions(utsMapOf("_class" to utsMapOf("type" to "String", "default" to ""), "_style" to utsMapOf("type" to "String", "default" to ""), "color" to utsMapOf("type" to "String", "default" to ""), "bgColor" to utsMapOf("type" to "String", "default" to ""), "darkBgColor" to utsMapOf("type" to "String", "default" to ""), "linearGradient" to utsMapOf("type" to "Array", "default" to fun(): UTSArray<String> {
            return utsArrayOf();
        }
        ), "fontColor" to utsMapOf("type" to "String", "default" to ""), "fontSize" to utsMapOf("type" to "String", "default" to ""), "round" to utsMapOf("type" to "Number", "default" to -1), "border" to utsMapOf("type" to "Number", "default" to 1), "borderColor" to utsMapOf("type" to "String", "default" to ""), "darkBorderColor" to utsMapOf("type" to "String", "default" to ""), "skin" to utsMapOf("type" to "String", "default" to "default"), "icon" to utsMapOf("type" to "String", "default" to ""), "size" to utsMapOf("type" to "String", "default" to "normal"), "url" to utsMapOf("type" to "String", "default" to ""), "disabled" to utsMapOf("type" to "Boolean", "default" to false), "loading" to utsMapOf("type" to "Boolean", "default" to false), "height" to utsMapOf("type" to "String", "default" to "")));
        var propsNeedCastKeys = utsArrayOf(
            "_class",
            "_style",
            "color",
            "bgColor",
            "darkBgColor",
            "linearGradient",
            "fontColor",
            "fontSize",
            "round",
            "border",
            "borderColor",
            "darkBorderColor",
            "skin",
            "icon",
            "size",
            "url",
            "disabled",
            "loading",
            "height"
        );
        var components: Map<String, CreateVueComponent> = utsMapOf();
    }
}
