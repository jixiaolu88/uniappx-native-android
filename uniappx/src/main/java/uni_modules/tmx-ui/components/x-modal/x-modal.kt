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
import io.dcloud.uniapp.extapi.getWindowInfo as uni_getWindowInfo;
open class GenUniModulesTmxUiComponentsXModalXModal : VueComponent {
    constructor(instance: ComponentInternalInstance) : super(instance) {
        onMounted(fun() {
            var sys = uni_getWindowInfo();
            this._width = sys.windowWidth;
            this._height = sys.windowHeight + 44;
            if (this._show) {
                this.showAlert();
            }
        }
        , instance);
        onBeforeUnmount(fun() {
            if (this.xani != null) {
                this.xani!!.stop();
                this.xani = null;
            }
            clearTimeout(this.tid);
        }
        , instance);
        this.`$watch`(fun(): Any? {
            return this.show;
        }
        , fun(_newval: Boolean) {
            if (_newval) {
                this.showAlert();
            } else {
                this.closeAlert();
            }
        }
        );
    }
    @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
    override fun `$render`(): Any? {
        val _ctx = this;
        val _cache = this.`$`.renderCache;
        val _component_x_icon = resolveEasyComponent("x-icon", GenUniModulesTmxUiComponentsXIconXIconClass);
        val _component_x_text = resolveEasyComponent("x-text", GenUniModulesTmxUiComponentsXTextXTextClass);
        val _component_x_button = resolveEasyComponent("x-button", GenUniModulesTmxUiComponentsXButtonXButtonClass);
        return createElementVNode("view", null, utsArrayOf(
            createElementVNode("view", utsMapOf("onClick" to _ctx.openDrawer), utsArrayOf(
                renderSlot(_ctx.`$slots`, "trigger", utsMapOf("show" to _ctx.show))
            ), 8, utsArrayOf(
                "onClick"
            )),
            if (isTrue(_ctx.showOverflay)) {
                createElementVNode("view", utsMapOf("key" to 0, "onClick" to _ctx.onClickOverflowy, "onTouchmove" to _ctx.maskerMove, "ref" to "xDrawerWrap", "onTransitionend" to _ctx.onEnd, "id" to _ctx.id, "class" to "xDrawerWrap xDrawerWrap_center", "style" to normalizeStyle(utsArrayOf(
                    utsMapOf("top" to (_ctx.windtop + "px"), "zIndex" to _ctx.zIndex, "width" to "100%", "height" to _ctx.__height, "transition-timing-function" to _ctx._animationFun),
                    _ctx._customStyle
                ))), utsArrayOf(
                    createElementVNode("view", utsMapOf("onClick" to withModifiers(fun(){}, utsArrayOf(
                        "stop"
                    )), "ref" to "xDrawerWrapContent", "class" to "xDrawerWrapContent xDrawerWrapContent_center", "id" to _ctx.wrapId, "style" to normalizeStyle(utsMapOf("width" to _ctx._c_width, "height" to _ctx._c_height, "maxWidth" to "750px", "borderRadius" to _ctx._round, "maxHeight" to if (_ctx._maxHeight != "") {
                        _ctx._maxHeight;
                    } else {
                        "100%";
                    }, "backgroundColor" to _ctx._bgColor, "transition-timing-function" to _ctx._animationFun))), utsArrayOf(
                        createElementVNode("view", utsMapOf("ref" to "xModalWrapBox", "class" to "xModalWrapBox", "style" to normalizeStyle(utsMapOf("borderRadius" to _ctx._round))), utsArrayOf(
                            if (isTrue(_ctx._showClose)) {
                                createVNode(_component_x_icon, utsMapOf("key" to 0, "class" to "xDrawerXclose", "onClick" to _ctx.closeAlert, "color" to "#dcdcdc", "font-size" to "21", "name" to "close-circle-fill"), null, 8, utsArrayOf(
                                    "onClick"
                                ));
                            } else {
                                createCommentVNode("v-if", true);
                            },
                            createElementVNode("view", null, utsArrayOf(
                                if (isTrue(_ctx._showTitle)) {
                                    createElementVNode("view", utsMapOf("key" to 0, "class" to "xDrawerTitleBox"), utsArrayOf(
                                        renderSlot(_ctx.`$slots`, "title", utsMapOf("show" to _ctx.show), fun(): UTSArray<Any> {
                                            return utsArrayOf(
                                                createVNode(_component_x_text, utsMapOf("font-size" to "17", "class" to "xDrawertitleBoxTitle"), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                    return utsArrayOf(
                                                        toDisplayString(_ctx._title)
                                                    );
                                                }), "_" to 1))
                                            );
                                        })
                                    ));
                                } else {
                                    createCommentVNode("v-if", true);
                                }
                            )),
                            if (isTrue(!_ctx.disabledScroll)) {
                                createElementVNode("scroll-view", utsMapOf("key" to 1, "style" to normalizeStyle(utsMapOf("flex" to "1")), "scroll-y" to true, "rebound" to false), utsArrayOf(
                                    createElementVNode("view", utsMapOf("style" to normalizeStyle(utsMapOf("padding" to _ctx._contentPadding))), utsArrayOf(
                                        renderSlot(_ctx.`$slots`, "default", utsMapOf("show" to _ctx.show))
                                    ), 4)
                                ), 4);
                            } else {
                                createCommentVNode("v-if", true);
                            },
                            if (isTrue(_ctx.disabledScroll)) {
                                createElementVNode("view", utsMapOf("key" to 2, "style" to normalizeStyle(utsMapOf("flex" to "1", "padding" to _ctx._contentPadding))), utsArrayOf(
                                    renderSlot(_ctx.`$slots`, "default", utsMapOf("show" to _ctx.show))
                                ), 4);
                            } else {
                                createCommentVNode("v-if", true);
                            },
                            if (isTrue(_ctx.showFooter)) {
                                createElementVNode("view", utsMapOf("key" to 3, "class" to "xDrawerFooter", "style" to normalizeStyle(utsMapOf("backgroundColor" to _ctx._bgColor))), utsArrayOf(
                                    renderSlot(_ctx.`$slots`, "footer", UTSJSONObject(), fun(): UTSArray<Any> {
                                        return utsArrayOf(
                                            if (isTrue(_ctx._showCancel)) {
                                                createVNode(_component_x_button, utsMapOf("key" to 0, "onClick" to _ctx.cancelEvt, "skin" to "thin", "width" to "0px", "block" to true, "style" to normalizeStyle(utsMapOf("margin-right" to "16px", "flex" to "1"))), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                    return utsArrayOf(
                                                        toDisplayString(_ctx._cancelText)
                                                    );
                                                }), "_" to 1), 8, utsArrayOf(
                                                    "onClick",
                                                    "style"
                                                ));
                                            } else {
                                                createCommentVNode("v-if", true);
                                            },
                                            createVNode(_component_x_button, utsMapOf("onClick" to _ctx.confirmEvt, "width" to "0px", "block" to true, "style" to normalizeStyle(utsMapOf("flex" to "1"))), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                return utsArrayOf(
                                                    toDisplayString(_ctx._confirmText)
                                                );
                                            }), "_" to 1), 8, utsArrayOf(
                                                "onClick",
                                                "style"
                                            ))
                                        );
                                    })
                                ), 4);
                            } else {
                                createCommentVNode("v-if", true);
                            }
                        ), 4)
                    ), 12, utsArrayOf(
                        "onClick",
                        "id"
                    ))
                ), 44, utsArrayOf(
                    "onClick",
                    "onTouchmove",
                    "onTransitionend",
                    "id"
                ));
            } else {
                createCommentVNode("v-if", true);
            }
        ));
    }
    open var customStyle: String by `$props`;
    open var title: String by `$props`;
    open var showFooter: Boolean by `$props`;
    open var showTitle: Boolean by `$props`;
    open var showClose: Boolean by `$props`;
    open var showCancel: Boolean by `$props`;
    open var overlayClick: Boolean by `$props`;
    open var show: Boolean by `$props`;
    open var duration: Number by `$props`;
    open var watiDuration: Number by `$props`;
    open var cancelText: String by `$props`;
    open var confirmText: String by `$props`;
    open var round: String by `$props`;
    open var width: String by `$props`;
    open var height: String by `$props`;
    open var maxHeight: String by `$props`;
    open var disabledScroll: Boolean by `$props`;
    open var bgColor: String by `$props`;
    open var darkBgColor: String by `$props`;
    open var zIndex: String by `$props`;
    open var contentPadding: String by `$props`;
    open var _width: Number by `$data`;
    open var _height: Number by `$data`;
    open var showOverflay: Boolean by `$data`;
    open var element: UniElement? by `$data`;
    open var elementWrap: UniElement? by `$data`;
    open var actioning: Boolean by `$data`;
    open var status: String by `$data`;
    open var id: Any? by `$data`;
    open var wrapId: Any? by `$data`;
    open var first: Boolean by `$data`;
    open var tid: Number by `$data`;
    open var windtop: Number by `$data`;
    open var xani: xAnimate? by `$data`;
    open var _customStyle: String by `$data`;
    open var _show: Boolean by `$data`;
    open var _showClose: Boolean by `$data`;
    open var _duration: Number by `$data`;
    open var _title: String by `$data`;
    open var _showTitle: Boolean by `$data`;
    open var _round: String by `$data`;
    open var _c_width: String by `$data`;
    open var _c_height: String by `$data`;
    open var _showFooter: Boolean by `$data`;
    open var _maxHeight: String by `$data`;
    open var _contentPadding: String by `$data`;
    open var _showCancel: Boolean by `$data`;
    open var _cancelText: String by `$data`;
    open var _confirmText: String by `$data`;
    open var _animationFun: String by `$data`;
    open var __height: String by `$data`;
    open var _bgColor: String by `$data`;
    @Suppress("USELESS_CAST")
    override fun data(): Map<String, Any?> {
        return utsMapOf("_width" to 0, "_height" to 0, "showOverflay" to false, "element" to null as UniElement?, "elementWrap" to null as UniElement?, "actioning" to false, "status" to "", "id" to ("xModal" + getUid()), "wrapId" to ("xModal" + getUid()), "first" to true, "tid" to 0, "windtop" to 0, "xani" to null as xAnimate?, "_customStyle" to computed<String>(fun(): String {
            return this.customStyle;
        }
        ), "_show" to computed<Boolean>(fun(): Boolean {
            return this.show;
        }
        ), "_showClose" to computed<Boolean>(fun(): Boolean {
            return this.showClose;
        }
        ), "_duration" to computed<Number>(fun(): Number {
            return this.duration;
        }
        ), "_title" to computed<String>(fun(): String {
            return this.title;
        }
        ), "_showTitle" to computed<Boolean>(fun(): Boolean {
            return this.showTitle;
        }
        ), "_round" to computed<String>(fun(): String {
            if (this.round == "") {
                return checkIsCssUnit(xConfig.modalRadius, xConfig.unit);
            }
            return checkIsCssUnit(this.round, xConfig.unit);
        }
        ), "_c_width" to computed<String>(fun(): String {
            return checkIsCssUnit(this.width, xConfig.unit);
        }
        ), "_c_height" to computed<String>(fun(): String {
            return checkIsCssUnit(this.height, xConfig.unit);
        }
        ), "_showFooter" to computed<Boolean>(fun(): Boolean {
            return this.showFooter;
        }
        ), "_maxHeight" to computed<String>(fun(): String {
            return checkIsCssUnit(this.maxHeight, xConfig.unit);
        }
        ), "_contentPadding" to computed<String>(fun(): String {
            return checkIsCssUnit(this.contentPadding, xConfig.unit);
        }
        ), "_showCancel" to computed<Boolean>(fun(): Boolean {
            return this.showCancel;
        }
        ), "_cancelText" to computed<String>(fun(): String {
            return this.cancelText;
        }
        ), "_confirmText" to computed<String>(fun(): String {
            return this.confirmText;
        }
        ), "_animationFun" to computed<String>(fun(): String {
            return xConfig.animationFun;
        }
        ), "__height" to computed<String>(fun(): String {
            var h = "100%";
            return h;
        }
        ), "_bgColor" to computed<String>(fun(): String {
            if (xConfig.dark == "dark") {
                if (this.darkBgColor != "") {
                    return getDefaultColor(this.darkBgColor);
                }
                return getDefaultColor(xConfig.sheetDarkColor);
            }
            return getDefaultColor(this.bgColor);
        }
        ));
    }
    override fun `$initMethods`() {
        this.overflayMoveTouch = fun(evt: TouchEvent) {
            evt.preventDefault();
        }
        ;
        this.cancelEvt = fun() {
            this.`$emit`("cancel");
            this.closeAlert();
        }
        ;
        this.confirmEvt = fun() {
            this.`$emit`("confirm");
            this.closeAlert();
        }
        ;
        this.onClickOverflowy = fun(evt: Event) {
            evt.stopPropagation();
            this.`$emit`("click");
            if (!this.overlayClick) {
                var el = this.`$refs`["xModalWrapBox"] as UniElement?;
                if (this.xani != null) {
                    this.xani!!.stop();
                    this.xani = null;
                }
                if (el != null) {
                    var t = this;
                    t.xani = xAnimate(el!!, XANIMATE_OPIONS(duration = 100, isDescPlay = true));
                    t.xani!!.attr("scale", "1", "0.95", false).attr("scale", "0.95", "1.05", false).attr("scale", "1.05", "1", false).play();
                }
                return;
            }
            this.closeAlert();
        }
        ;
        this.closeAlert = fun() {
            if (this.actioning) {
                return;
            }
            if (this.status == "close") {
                return;
            }
            this.actioning = true;
            this.status = "close";
            this.`$emit`("beforeClose");
            this.setStyleAni();
        }
        ;
        this.showAlert = fun() {
            if (this.actioning) {
                return;
            }
            if (this.status == "open") {
                return;
            }
            this.showOverflay = true;
            this.actioning = true;
            this.status = "open";
            this.`$emit`("beforeOpen");
            this.setStyleAni();
        }
        ;
        this.setStyleAni = fun() {
            var t = this;
            if (this.status == "open") {
                var watiDuration: Number = 60;
                this.showOverflay = true;
                clearTimeout(this.tid);
                this.tid = setTimeout(fun() {
                    t.element = t.`$refs`["xDrawerWrap"] as UniElement;
                    t.elementWrap = t.`$refs`["xDrawerWrapContent"] as UniElement;
                    if (t.element == null || t.elementWrap == null) {
                        return;
                    }
                    t.element!!.style.setProperty("transition-duration", t._duration.toString() + "ms");
                    t.elementWrap!!.style.setProperty("transition-duration", t._duration.toString() + "ms");
                    t.element!!.style.setProperty("opacity", "1");
                    t.elementWrap!!.style.setProperty("transform", "scale(1)");
                    t.elementWrap!!.style.setProperty("opacity", "1");
                }, watiDuration);
            } else if (t.status == "close") {
                t.element!!.style.setProperty("transition-duration", t._duration.toString() + "ms");
                t.elementWrap!!.style.setProperty("transition-duration", t._duration.toString() + "ms");
                t.element!!.style.setProperty("opacity", 0);
                t.elementWrap!!.style.setProperty("transform", "scale(0.64)");
                t.elementWrap!!.style.setProperty("opacity", 0);
            }
        }
        ;
        this.openDrawer = fun() {
            this.showAlert();
        }
        ;
        this.onEnd = fun() {
            this.actioning = false;
            if (this.status == "close") {
                this.showOverflay = false;
                this.`$emit`("close");
                this.`$emit`("update:show", false);
            } else {
                this.`$emit`("open");
            }
        }
        ;
        this.maskerMove = fun(evt: UniTouchEvent) {};
    }
    open lateinit var overflayMoveTouch: (evt: TouchEvent) -> Unit;
    open lateinit var cancelEvt: () -> Unit;
    open lateinit var confirmEvt: () -> Unit;
    open lateinit var onClickOverflowy: (evt: Event) -> Unit;
    open lateinit var closeAlert: () -> Unit;
    open lateinit var showAlert: () -> Unit;
    open lateinit var setStyleAni: () -> Unit;
    open lateinit var openDrawer: () -> Unit;
    open lateinit var onEnd: () -> Unit;
    open lateinit var maskerMove: (evt: UniTouchEvent) -> Unit;
    companion object {
        val styles: Map<String, Map<String, Map<String, Any>>>
            get() {
                return normalizeCssStyles(utsArrayOf(
                    styles0
                ));
            }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return utsMapOf("xModalWrapBox" to padStyleMapOf(utsMapOf("display" to "flex", "flexDirection" to "column", "height" to "100%", "width" to "100%")), "xDrawerFooter" to padStyleMapOf(utsMapOf("width" to "100%", "paddingTop" to 16, "paddingRight" to 16, "paddingBottom" to 16, "paddingLeft" to 16, "flexDirection" to "row", "justifyContent" to "space-between", "alignItems" to "center")), "xDrawerXclose" to padStyleMapOf(utsMapOf("position" to "absolute", "right" to 12, "top" to 6, "zIndex" to 100)), "xDrawertitleBoxTitle" to padStyleMapOf(utsMapOf("fontSize" to 16)), "xDrawerTitleBox" to padStyleMapOf(utsMapOf("height" to 44, "display" to "flex", "flexDirection" to "row", "alignItems" to "center", "justifyContent" to "center")), "xDrawertitleBox" to padStyleMapOf(utsMapOf("maxWidth" to 350, "overflow" to "hidden", "lines" to 1, "textOverflow" to "ellipsis", "fontSize" to 14)), "xDrawerWrap_center" to padStyleMapOf(utsMapOf("display" to "flex", "flexDirection" to "column", "justifyContent" to "center", "alignItems" to "center")), "xDrawerWrapContent" to padStyleMapOf(utsMapOf("transitionDuration" to "350ms", "transitionProperty" to "transform,opacity", "display" to "flex", "flexDirection" to "column")), "xDrawerWrapContent_center" to padStyleMapOf(utsMapOf("transform" to "scale(0.64)", "opacity" to 0)), "xDrawerWrap" to padStyleMapOf(utsMapOf("backgroundColor" to "rgba(0,0,0,0.4)", "opacity" to 0, "position" to "fixed", "left" to 0, "top" to 0, "transitionDuration" to "350ms", "transitionProperty" to "opacity")), "@TRANSITION" to utsMapOf("xDrawerWrapContent" to utsMapOf("duration" to "350ms", "property" to "transform,opacity"), "xDrawerWrap" to utsMapOf("duration" to "350ms", "property" to "opacity")));
            }
        var inheritAttrs = true;
        var inject: Map<String, Map<String, Any?>> = utsMapOf();
        var emits: Map<String, Any?> = utsMapOf("click" to null, "close" to null, "open" to null, "beforeOpen" to null, "beforeClose" to null, "update:show" to null, "cancel" to null, "confirm" to null);
        var props = normalizePropsOptions(utsMapOf("customStyle" to utsMapOf("type" to "String", "default" to ""), "title" to utsMapOf("type" to "String", "default" to "标题"), "showFooter" to utsMapOf("type" to "Boolean", "default" to true), "showTitle" to utsMapOf("type" to "Boolean", "default" to true), "showClose" to utsMapOf("type" to "Boolean", "default" to false), "showCancel" to utsMapOf("type" to "Boolean", "default" to true), "overlayClick" to utsMapOf("type" to "Boolean", "default" to true), "show" to utsMapOf("type" to "Boolean", "default" to false), "duration" to utsMapOf("type" to "Number", "default" to 300), "watiDuration" to utsMapOf("type" to "Number", "default" to 120), "cancelText" to utsMapOf("type" to "String", "default" to "取消"), "confirmText" to utsMapOf("type" to "String", "default" to "确认"), "round" to utsMapOf("type" to "String", "default" to ""), "width" to utsMapOf("type" to "String", "default" to "84%"), "height" to utsMapOf("type" to "String", "default" to "240px"), "maxHeight" to utsMapOf("type" to "String", "default" to "80%"), "disabledScroll" to utsMapOf("type" to "Boolean", "default" to false), "bgColor" to utsMapOf("type" to "String", "default" to "white"), "darkBgColor" to utsMapOf("type" to "String", "default" to ""), "zIndex" to utsMapOf("type" to "String", "default" to "1000"), "contentPadding" to utsMapOf("type" to "String", "default" to "16")));
        var propsNeedCastKeys = utsArrayOf(
            "customStyle",
            "title",
            "showFooter",
            "showTitle",
            "showClose",
            "showCancel",
            "overlayClick",
            "show",
            "duration",
            "watiDuration",
            "cancelText",
            "confirmText",
            "round",
            "width",
            "height",
            "maxHeight",
            "disabledScroll",
            "bgColor",
            "darkBgColor",
            "zIndex",
            "contentPadding"
        );
        var components: Map<String, CreateVueComponent> = utsMapOf();
    }
}
