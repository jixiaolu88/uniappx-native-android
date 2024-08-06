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
open class GenUniModulesTmxUiComponentsXIconXIcon : VueComponent {
    constructor(instance: ComponentInternalInstance) : super(instance) {
        onBeforeUnmount(fun() {
            this.isdestory = true;
            clearTimeout(this.tid);
        }
        , instance);
        onMounted(fun() {
            this.loadFontByX();
            this.isdestory = false;
            var t = this;
            if (this._spin) {
                clearTimeout(this.tid);
                this.tid = setTimeout(fun() {
                    t.playSpin();
                }, 150);
            } else {
                this.`$nextTick`(fun(){
                    this.setRadeg();
                }
                );
            }
        }
        , instance);
        this.`$watch`(fun(): Any? {
            return this.spin;
        }
        , fun() {
            if (this._spin) {
                clearTimeout(this.tid);
                var t = this;
                this.tid = setTimeout(fun() {
                    t.playSpin();
                }
                , 80);
            }
        }
        );
        this.`$watch`(fun(): Any? {
            return this.rotation;
        }
        , fun() {
            if (this._spin) {
                return;
            }
            this.setRadeg();
        }
        );
    }
    @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
    override fun `$render`(): Any? {
        val _ctx = this;
        val _cache = this.`$`.renderCache;
        return if (isTrue(!_ctx._isFileImg)) {
            createElementVNode("text", utsMapOf("key" to 0, "onClick" to _ctx.clickListen, "id" to _ctx.id, "ref" to "xIcons", "class" to normalizeClass(utsArrayOf(
                "face",
                utsArrayOf(
                    if (_ctx._spin) {
                        "spin";
                    } else {
                        "";
                    }
                )
            )), "onTransitionend" to _ctx.playSpinEnd, "style" to normalizeStyle(utsMapOf("font-family" to "remixicon", "font-size" to _ctx._fontSize, "color" to _ctx._color, "width" to _ctx._fontSize, "lineHeight" to _ctx._fontSize))), toDisplayString(_ctx.iconName), 47, utsArrayOf(
                "onClick",
                "id",
                "onTransitionend"
            ));
        } else {
            createElementVNode("image", utsMapOf("key" to 1, "id" to _ctx.id, "ref" to "xIcons", "style" to normalizeStyle(utsMapOf("width" to _ctx._fontSize, "height" to _ctx._fontSize)), "src" to _ctx.iconName), null, 12, utsArrayOf(
                "id",
                "src"
            ));
        }
        ;
    }
    open var name: String by `$props`;
    open var fontSize: String by `$props`;
    open var color: String by `$props`;
    open var darkColor: String by `$props`;
    open var spin: Boolean by `$props`;
    open var rotation: Number by `$props`;
    open var duration: Number by `$props`;
    open var xIcon: Element? by `$data`;
    open var refreshId: Number by `$data`;
    open var id: Any? by `$data`;
    open var element: Element? by `$data`;
    open var rotationDeg: Number by `$data`;
    open var isLoad: Boolean by `$data`;
    open var isdestory: Boolean by `$data`;
    open var status: String by `$data`;
    open var tid: Number by `$data`;
    open var _iconName: String by `$data`;
    open var iconName: String by `$data`;
    open var _isFileImg: Boolean by `$data`;
    open var _fontSize: String by `$data`;
    open var _color: String by `$data`;
    open var _spin: Boolean by `$data`;
    open var _rotation: Number by `$data`;
    @Suppress("USELESS_CAST")
    override fun data(): Map<String, Any?> {
        return utsMapOf("xIcon" to null as Element?, "refreshId" to 1, "id" to ("xIconspin" + getUid()), "element" to null as Element?, "rotationDeg" to 0, "isLoad" to false, "isdestory" to false, "status" to "play", "tid" to 0, "_iconName" to computed<String>(fun(): String {
            return this.name;
        }
        ), "iconName" to computed<String>(fun(): String {
            if (this._isFileImg) {
                return this.name;
            }
            var texts = "";
            try {
                var code = "";
                code = fonts[this.name] as String;
                var codePoint = Integer.parseInt(code, 16);
                var charArray = Character.toChars(codePoint);
                texts = String(charArray);
            }
             catch (e: Throwable) {
                console.error("xicon解析失败。", e, " at uni_modules/tmx-ui/components/x-icon/x-icon.uvue:113");
            }
            return texts;
        }
        ), "_isFileImg" to computed<Boolean>(fun(): Boolean {
            if (this.name.lastIndexOf(".") > -1 || this.name.indexOf("ftp:") > -1 || this.name.indexOf("https:") > -1 || this.name.indexOf("http:") > -1 || this.name.indexOf("data:image") > -1) {
                return true;
            }
            return false;
        }
        ), "_fontSize" to computed<String>(fun(): String {
            var fontSize = checkIsCssUnit(this.fontSize, xConfig.unit);
            if (xConfig.fontScale == 1) {
                return fontSize;
            }
            var sizeNumber = parseInt(fontSize);
            if (isNaN(sizeNumber)) {
                sizeNumber = 16;
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
        ), "_spin" to computed<Boolean>(fun(): Boolean {
            return this.spin;
        }
        ), "_rotation" to computed<Number>(fun(): Number {
            return this.rotation;
        }
        ));
    }
    override fun `$initMethods`() {
        this.setRadeg = fun() {
            try {
                this.element = this.`$refs`["xIcons"] as UniElement;
                this.element!!.style.setProperty("transition-duration", this.duration.toString() + "ms");
                this.element!!.style.setProperty("transform", "rotate(" + this._rotation + "deg)");
            }
             catch (e: Throwable) {}
        }
        ;
        this.playSpin = fun() {
            if (!this._spin || this.isdestory) {
                return;
            }
            this.element = this.`$refs`["xIcons"] as UniElement;
            try {
                if (this.rotationDeg >= 360) {
                    this.rotationDeg = 0;
                    this.element!!.style.setProperty("transition-duration", "4ms");
                    this.element!!.style.setProperty("transform", "rotate(" + this.rotationDeg + "deg)");
                    this.status = "play";
                    return;
                }
                if (this.status == "play") {
                    this.rotationDeg = 360;
                    this.element!!.style.setProperty("transition-duration", this.duration.toString() + "ms");
                    this.element!!.style.setProperty("transform", "rotate(" + this.rotationDeg + "deg)");
                    this.status = "none";
                }
            }
             catch (e: Throwable) {}
        }
        ;
        this.playSpinEnd = fun() {
            this.playSpin();
        }
        ;
        this.clickListen = fun() {
            this.`$emit`("click");
        }
        ;
        this.loadFontByX = fun() {
            this.isLoad = true;
        }
        ;
    }
    open lateinit var setRadeg: () -> Unit;
    open lateinit var playSpin: () -> Unit;
    open lateinit var playSpinEnd: () -> Unit;
    open lateinit var clickListen: () -> Unit;
    open lateinit var loadFontByX: () -> Unit;
    companion object {
        val styles: Map<String, Map<String, Map<String, Any>>>
            get() {
                return normalizeCssStyles(utsArrayOf(
                    styles0
                ));
            }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return utsMapOf("face" to padStyleMapOf(utsMapOf("transitionProperty" to "transform", "transitionDuration" to "0ms", "transitionTimingFunction" to "linear", "transform" to "rotate(0deg)")), "@TRANSITION" to utsMapOf("face" to utsMapOf("property" to "transform", "duration" to "0ms", "timingFunction" to "linear")));
            }
        var inheritAttrs = true;
        var inject: Map<String, Map<String, Any?>> = utsMapOf();
        var emits: Map<String, Any?> = utsMapOf("click" to null);
        var props = normalizePropsOptions(utsMapOf("name" to utsMapOf("type" to "String", "default" to "home-3-fill"), "fontSize" to utsMapOf("type" to "String", "default" to "16"), "color" to utsMapOf("type" to "String", "default" to "black"), "darkColor" to utsMapOf("type" to "String", "default" to ""), "spin" to utsMapOf("type" to "Boolean", "default" to false), "rotation" to utsMapOf("type" to "Number", "default" to 0), "duration" to utsMapOf("type" to "Number", "default" to 1000)));
        var propsNeedCastKeys = utsArrayOf(
            "name",
            "fontSize",
            "color",
            "darkColor",
            "spin",
            "rotation",
            "duration"
        );
        var components: Map<String, CreateVueComponent> = utsMapOf();
    }
}
