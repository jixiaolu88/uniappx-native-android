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
open class GenUniModulesTmxUiComponentsXTextXText : VueComponent {
    constructor(instance: ComponentInternalInstance) : super(instance) {}
    @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
    override fun `$render`(): Any? {
        val _ctx = this;
        val _cache = this.`$`.renderCache;
        return createElementVNode("text", mergeProps(utsMapOf("onClick" to _ctx.allClick, "style" to _ctx._styleMap, "class" to "xTextLines", "selectable" to _ctx.selectable), _ctx.`$attrs`), utsArrayOf(
            renderSlot(_ctx.`$slots`, "default", UTSJSONObject(), fun(): UTSArray<Any> {
                return utsArrayOf(
                    createElementVNode(Fragment, null, RenderHelpers.renderList(_ctx._texts, fun(item, index, _, _): VNode {
                        return createElementVNode("text", mergeProps(utsMapOf("onTouchend" to fun(){
                            _ctx.itemClick(item.text);
                        }
                        , "selectable" to _ctx.selectable, "style" to utsArrayOf(
                            utsMapOf("color" to item.color, "lineHeight" to _ctx.lineHeight, "fontSize" to _ctx._fontSize),
                            if (item.isHeightLight) {
                                _ctx.heightLightStyle;
                            } else {
                                "";
                            }
                        ), "key" to index), _ctx.`$attrs`), toDisplayString(item.text), 17, utsArrayOf(
                            "onTouchend",
                            "selectable"
                        ));
                    }
                    ), 128)
                );
            }
            )
        ), 16, utsArrayOf(
            "onClick",
            "selectable"
        ));
    }
    open var label: String by `$props`;
    open var heightLight: UTSArray<String> by `$props`;
    open var heightLightReg: UTSArray<String> by `$props`;
    open var heightLightStyle: String by `$props`;
    open var lines: Number by `$props`;
    open var selectable: Boolean by `$props`;
    open var color: String by `$props`;
    open var darkColor: String by `$props`;
    open var heightLightColor: String by `$props`;
    open var lineHeight: String by `$props`;
    open var fontSize: String by `$props`;
    open var _fontSize: String by `$data`;
    open var _color: String by `$data`;
    open var _heightLightColor: String by `$data`;
    open var _texts: UTSArray<ITEMINFO> by `$data`;
    open var _styleMap: Map<String, String> by `$data`;
    @Suppress("USELESS_CAST")
    override fun data(): Map<String, Any?> {
        return utsMapOf("_fontSize" to computed<String>(fun(): String {
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
        ), "_color" to computed<String>(fun(): String {
            var color = this.color;
            if (xConfig.dark == "dark") {
                if (this.darkColor != "") {
                    color = this.darkColor!!;
                    return getDefaultColor(color);
                }
                return setTextColorLightByDark(color);
            }
            return getDefaultColor(this.color);
        }
        ), "_heightLightColor" to computed<String>(fun(): String {
            return getDefaultColor(this.heightLightColor);
        }
        ), "_texts" to computed<UTSArray<ITEMINFO>>(fun(): UTSArray<ITEMINFO> {
            var keywords = this.heightLight;
            var albel = this.label;
            if ((keywords.length == 0 && this.heightLightReg.length == 0) || albel.length == 0) {
                return utsArrayOf(
                    ITEMINFO(text = albel, color = this._color, isHeightLight = false)
                );
            }
            var regexxAr = utsArrayOf<String>();
            this.heightLightReg.forEach(fun(reg: String) {
                var regex = UTSRegExp(reg, "gi");
                var rulst = regex.exec(albel);
                if (UTSArray.isArray(rulst)) {
                    regexxAr = regexxAr.concat(rulst as UTSArray<String>) as UTSArray<String>;
                }
            }
            );
            keywords = keywords.concat(regexxAr);
            keywords.forEach(fun(keyword: String) {
                var regex = UTSRegExp(keyword, "gi");
                albel = albel.replace(regex, "~-<span>" + keyword + "</span>~-");
            }
            );
            var ps = albel.split("~-");
            var ar = utsArrayOf<ITEMINFO>();
            ps.forEach(fun(el: String){
                if (el.length > 0) {
                    var start = el.indexOf("<span>");
                    if (start > -1) {
                        var end = el.lastIndexOf("</span>");
                        ar.push(ITEMINFO(text = el.substring(start + 6, end), color = this._heightLightColor, isHeightLight = true));
                    } else {
                        ar.push(ITEMINFO(text = el, color = this._color, isHeightLight = false));
                    }
                }
            }
            );
            return ar;
        }
        ), "_styleMap" to computed<Map<String, String>>(fun(): Map<String, String> {
            var styleMap = Map<String, String>();
            styleMap.set("lines", this.lines.toString());
            styleMap.set("lineHeight", this.lineHeight);
            styleMap.set("fontSize", this._fontSize);
            styleMap.set("color", this._color);
            return styleMap;
        }
        ));
    }
    override fun `$initMethods`() {
        this.allClick = fun() {
            this.`$emit`("click");
        }
        ;
        this.itemClick = fun(str: String) {
            this.`$emit`("item-click", str);
        }
        ;
    }
    open lateinit var allClick: () -> Unit;
    open lateinit var itemClick: (str: String) -> Unit;
    companion object {
        val styles: Map<String, Map<String, Map<String, Any>>>
            get() {
                return normalizeCssStyles(utsArrayOf(
                    styles0
                ));
            }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return utsMapOf("xTextLines" to padStyleMapOf(utsMapOf("textOverflow" to "ellipsis")));
            }
        var inheritAttrs = true;
        var inject: Map<String, Map<String, Any?>> = utsMapOf();
        var emits: Map<String, Any?> = utsMapOf("click" to null, "item-click" to null);
        var props = normalizePropsOptions(utsMapOf("label" to utsMapOf("type" to "String", "default" to ""), "heightLight" to utsMapOf("type" to "Array", "default" to fun(): UTSArray<String> {
            return utsArrayOf<String>();
        }
        ), "heightLightReg" to utsMapOf("type" to "Array", "default" to fun(): UTSArray<String> {
            return utsArrayOf<String>();
        }
        ), "heightLightStyle" to utsMapOf("type" to "String", "default" to ""), "lines" to utsMapOf("type" to "Number", "default" to 0), "selectable" to utsMapOf("type" to "Boolean", "default" to false), "color" to utsMapOf("type" to "String", "default" to "#333333"), "darkColor" to utsMapOf("type" to "String", "default" to ""), "heightLightColor" to utsMapOf("type" to "String", "default" to "primary"), "lineHeight" to utsMapOf("type" to "String", "default" to "1.7"), "fontSize" to utsMapOf("type" to "String", "default" to "15px")));
        var propsNeedCastKeys = utsArrayOf(
            "label",
            "heightLight",
            "heightLightReg",
            "heightLightStyle",
            "lines",
            "selectable",
            "color",
            "darkColor",
            "heightLightColor",
            "lineHeight",
            "fontSize"
        );
        var components: Map<String, CreateVueComponent> = utsMapOf();
    }
}
