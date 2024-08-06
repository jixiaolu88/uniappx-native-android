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
import io.dcloud.uniapp.extapi.getElementById as uni_getElementById;
import io.dcloud.uniapp.extapi.getWindowInfo as uni_getWindowInfo;
open class GenUniModulesTmxUiComponentsXActionMenuXActionMenu : VueComponent {
    constructor(instance: ComponentInternalInstance) : super(instance) {
        onMounted(fun() {
            var t = this;
            var sys = uni_getWindowInfo();
            this._width = sys.windowWidth;
            this._height = sys.windowHeight + 44;
            if (this._show) {
                this.tid = setTimeout(fun(){
                    t.showAlert();
                }
                , 50);
            }
        }
        , instance);
        onBeforeUnmount(fun() {
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
        return createElementVNode("view", null, utsArrayOf(
            createElementVNode("view", mergeProps(utsMapOf("onClick" to _ctx.openDrawer), _ctx.`$attrs`), utsArrayOf(
                renderSlot(_ctx.`$slots`, "trigger", utsMapOf("show" to _ctx.show))
            ), 16, utsArrayOf(
                "onClick"
            )),
            if (isTrue(_ctx.showOverflay)) {
                createElementVNode("view", utsMapOf("key" to 0, "onClick" to _ctx.onClickOverflowy, "onTouchmove" to _ctx.overTouch, "onTransitionend" to _ctx.onEnd, "id" to _ctx.id, "class" to "xActionMenuWrap xActionMenuWrap_bottom", "style" to normalizeStyle(utsArrayOf(
                    utsMapOf("width" to "100%", "top" to (_ctx.windtop + "px"), "height" to _ctx.__height, "transition-timing-function" to _ctx._animationFun),
                    _ctx._customStyle
                ))), utsArrayOf(
                    createElementVNode("view", utsMapOf("onClick" to withModifiers(fun(){}, utsArrayOf(
                        "stop"
                    )), "class" to normalizeClass(utsArrayOf(
                        utsArrayOf(
                            if (_ctx._space) {
                                "onOpenSpace";
                            } else {
                                "";
                            }
                        ),
                        "xActionMenuWrapContent xActionMenuWrapContent_bottom"
                    )), "id" to _ctx.wrapId, "style" to normalizeStyle(utsMapOf("borderRadius" to _ctx._round, "transition-timing-function" to _ctx._animationFun, "backgroundColor" to _ctx._bgColor))), utsArrayOf(
                        if (isTrue(_ctx._showClose)) {
                            createVNode(_component_x_icon, utsMapOf("key" to 0, "class" to "xActionMenuXclose", "onClick" to _ctx.closeAlert, "color" to "#dcdcdc", "font-size" to "21", "name" to "close-circle-fill"), null, 8, utsArrayOf(
                                "onClick"
                            ));
                        } else {
                            createCommentVNode("v-if", true);
                        },
                        createElementVNode("view", null, utsArrayOf(
                            if (isTrue(_ctx._showTitle)) {
                                createElementVNode("view", utsMapOf("key" to 0, "class" to "xActionMenuTitleBox", "style" to normalizeStyle(utsMapOf("backgroundColor" to _ctx._cellBgColor))), utsArrayOf(
                                    renderSlot(_ctx.`$slots`, "title", utsMapOf("show" to _ctx.show), fun(): UTSArray<Any> {
                                        return utsArrayOf(
                                            createElementVNode("text", utsMapOf("class" to "xActionMenutitleBox"), toDisplayString(_ctx._title), 1)
                                        );
                                    })
                                ), 4);
                            } else {
                                createCommentVNode("v-if", true);
                            }
                        )),
                        createElementVNode("view", utsMapOf("class" to "xActionMenuWrapContentBox", "style" to normalizeStyle(utsMapOf("maxHeight" to if (_ctx._maxHeight != "") {
                            _ctx._maxHeight;
                        } else {
                            "100%";
                        }))), utsArrayOf(
                            createElementVNode("scroll-view", utsMapOf("style" to normalizeStyle(utsMapOf("flex" to 1, "backgroundColor" to _ctx._bgColor)), "scroll-y" to true, "rebound" to false), utsArrayOf(
                                renderSlot(_ctx.`$slots`, "default", utsMapOf("show" to _ctx.show), fun(): UTSArray<Any> {
                                    return utsArrayOf(
                                        createElementVNode(Fragment, null, RenderHelpers.renderList(_ctx._list, fun(item, index, _, _): VNode {
                                            return createElementVNode("view", utsMapOf("key" to index, "onClick" to fun(){
                                                _ctx.itemClick(index, item.disabled);
                                            }, "style" to normalizeStyle(utsMapOf("backgroundColor" to _ctx._cellBgColor, "opacity" to if (item.disabled) {
                                                "0.5";
                                            } else {
                                                "1";
                                            })), "class" to "xActionMenuItem", "hover-class" to if (item.disabled) {
                                                "";
                                            } else {
                                                "xActionMenuHover";
                                            }, "hover-stay-time" to "100", "hover-start-time" to "10"), utsArrayOf(
                                                if (item.icon != "") {
                                                    createVNode(_component_x_icon, utsMapOf("key" to 0, "color" to item.iconColor, "name" to item.icon, "style" to normalizeStyle(utsMapOf("margin-right" to "10rpx"))), null, 8, utsArrayOf(
                                                        "color",
                                                        "name",
                                                        "style"
                                                    ));
                                                } else {
                                                    createCommentVNode("v-if", true);
                                                },
                                                createElementVNode("text", utsMapOf("class" to "xActionText", "style" to normalizeStyle(utsMapOf("fontSize" to item.fontSize, "color" to item.fontColor))), toDisplayString(item.text), 5)
                                            ), 12, utsArrayOf(
                                                "onClick",
                                                "hover-class"
                                            ));
                                        }), 128)
                                    );
                                })
                            ), 4)
                        ), 4),
                        if (isTrue(_ctx._showCancel)) {
                            createElementVNode("view", utsMapOf("key" to 1, "onClick" to _ctx.onCancel, "hover-class" to "xActionMenuHover", "style" to normalizeStyle(utsMapOf("backgroundColor" to _ctx._cellBgColor)), "hover-stay-time" to "100", "hover-start-time" to "10", "class" to "xActionMenuFooter"), utsArrayOf(
                                createVNode(_component_x_text, utsMapOf("font-size" to "16", "class" to "xActionMenuFooterText"), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                                    return utsArrayOf(
                                        "取消"
                                    );
                                }), "_" to 1))
                            ), 12, utsArrayOf(
                                "onClick"
                            ));
                        } else {
                            createCommentVNode("v-if", true);
                        }
                    ), 14, utsArrayOf(
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
    open var showTitle: Boolean by `$props`;
    open var showClose: Boolean by `$props`;
    open var overlayClick: Boolean by `$props`;
    open var cellClickClose: Boolean by `$props`;
    open var show: Boolean by `$props`;
    open var showCancel: Boolean by `$props`;
    open var duration: Number by `$props`;
    open var round: String by `$props`;
    open var maxHeight: String by `$props`;
    open var list: UTSArray<XACTION_MENU_ITEM_INFO> by `$props`;
    open var space: Boolean by `$props`;
    open var watiDuration: Number by `$props`;
    open var _width: Number by `$data`;
    open var _height: Number by `$data`;
    open var showOverflay: Boolean by `$data`;
    open var element: Element? by `$data`;
    open var elementWrap: Element? by `$data`;
    open var actioning: Boolean by `$data`;
    open var status: String by `$data`;
    open var id: Any? by `$data`;
    open var wrapId: Any? by `$data`;
    open var first: Boolean by `$data`;
    open var tid: Number by `$data`;
    open var windtop: Number by `$data`;
    open var _customStyle: String by `$data`;
    open var _show: Boolean by `$data`;
    open var _showClose: Boolean by `$data`;
    open var _duration: Number by `$data`;
    open var _cellClickClose: Boolean by `$data`;
    open var _title: String by `$data`;
    open var _showTitle: Boolean by `$data`;
    open var _round: String by `$data`;
    open var _space: Boolean by `$data`;
    open var _maxHeight: String by `$data`;
    open var _showCancel: Boolean by `$data`;
    open var _list: UTSArray<XACTION_MENU_ITEM_INFO_PRIVATE> by `$data`;
    open var _animationFun: String by `$data`;
    open var __height: String by `$data`;
    open var _bgColor: String by `$data`;
    open var _cellBgColor: String by `$data`;
    @Suppress("USELESS_CAST")
    override fun data(): Map<String, Any?> {
        return utsMapOf("_width" to 0, "_height" to 0, "showOverflay" to false, "element" to null as Element?, "elementWrap" to null as Element?, "actioning" to false, "status" to "", "id" to ("xActionMenu" + getUid()), "wrapId" to ("xActionMenuWrap" + getUid()), "first" to true, "tid" to 0, "windtop" to 0, "_customStyle" to computed<String>(fun(): String {
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
        ), "_cellClickClose" to computed<Boolean>(fun(): Boolean {
            return this.cellClickClose;
        }
        ), "_title" to computed<String>(fun(): String {
            return this.title;
        }
        ), "_showTitle" to computed<Boolean>(fun(): Boolean {
            return this.showTitle;
        }
        ), "_round" to computed<String>(fun(): String {
            var round = this.round;
            if (round == "") {
                round = xConfig.drawerRadius;
            }
            var radius = checkIsCssUnit(round, xConfig.unit);
            if (!this._space) {
                return "" + radius + " " + radius + " 0px 0px";
            }
            return "" + radius;
        }
        ), "_space" to computed<Boolean>(fun(): Boolean {
            return this.space;
        }
        ), "_maxHeight" to computed<String>(fun(): String {
            if (this.maxHeight == "") {
                return "80%";
            }
            return checkIsCssUnit(this.maxHeight, xConfig.unit);
        }
        ), "_showCancel" to computed<Boolean>(fun(): Boolean {
            return this.showCancel;
        }
        ), "_list" to computed<UTSArray<XACTION_MENU_ITEM_INFO_PRIVATE>>(fun(): UTSArray<XACTION_MENU_ITEM_INFO_PRIVATE> {
            return this.list.map(fun(el: XACTION_MENU_ITEM_INFO): XACTION_MENU_ITEM_INFO_PRIVATE {
                var psd = if (el.disabled == null) {
                    false;
                } else {
                    el.disabled!!;
                }
                ;
                var defaultSize = this.getFontSize("16");
                var temiconcolor = if (el.iconColor != null) {
                    getDefaultColor(el.iconColor as String);
                } else {
                    "#333333";
                }
                ;
                var temfontcolor = if (el.iconColor != null) {
                    getDefaultColor(el.iconColor as String);
                } else {
                    "#333333";
                }
                ;
                var iconColor = if (xConfig.dark == "dark") {
                    setTextColorLightByDark(temiconcolor);
                } else {
                    temiconcolor;
                }
                ;
                var fontColor = if (xConfig.dark == "dark") {
                    setTextColorLightByDark(temfontcolor);
                } else {
                    temfontcolor;
                }
                ;
                return XACTION_MENU_ITEM_INFO_PRIVATE(iconSize = if (el.iconSize != null) {
                    this.getFontSize(el.iconSize!!);
                } else {
                    defaultSize;
                }
                , icon = if (el.icon != null) {
                    el.icon!!;
                } else {
                    "";
                }
                , fontSize = if (el.fontSize != null) {
                    this.getFontSize(el.fontSize!!);
                } else {
                    defaultSize;
                }
                , iconColor = iconColor, fontColor = fontColor, disabled = psd, id = el.id, text = el.text);
            }
            );
        }
        ), "_animationFun" to computed<String>(fun(): String {
            return xConfig.animationFun;
        }
        ), "__height" to computed<String>(fun(): String {
            var h = "100%";
            return h;
        }
        ), "_bgColor" to computed<String>(fun(): String {
            return if (xConfig.dark == "dark") {
                xConfig.sheetDarkColor;
            } else {
                "#f5f5f5";
            }
            ;
        }
        ), "_cellBgColor" to computed<String>(fun(): String {
            return if (xConfig.dark == "dark") {
                xConfig.inputDarkColor;
            } else {
                "#ffffff";
            }
            ;
        }
        ));
    }
    override fun `$initMethods`() {
        this.getFontSize = fun(size: String): String {
            var fontSize = checkIsCssUnit(size, xConfig.unit);
            if (xConfig.fontScale == 1) {
                return fontSize;
            }
            var sizeNumber = parseInt(fontSize);
            if (isNaN(sizeNumber)) {
                sizeNumber = 14;
            }
            return (sizeNumber * xConfig.fontScale).toString() + getUnit(fontSize);
        }
        ;
        this.itemClick = fun(index: Number, disabled: Boolean) {
            if (this.actioning || disabled || this.status == "close") {
                return;
            }
            this.`$emit`("item-click", index);
            if (!this._cellClickClose) {
                return;
            }
            this.closeAlert();
        }
        ;
        this.overflayMoveTouch = fun(evt: TouchEvent) {
            evt.preventDefault();
        }
        ;
        this.onClickOverflowy = fun(evt: Event) {
            evt.stopPropagation();
            this.`$emit`("click");
            if (!this.overlayClick) {
                return;
            }
            this.onCancel();
        }
        ;
        this.closeAlert = fun() {
            if (this.actioning || this.status == "close") {
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
            var watiDuration: Number = 60;
            try {
                if (this.status == "open") {
                    this.showOverflay = true;
                    clearTimeout(this.tid);
                    this.tid = setTimeout(fun() {
                        t.element = uni_getElementById(t.id as String) as Element?;
                        t.elementWrap = uni_getElementById(t.wrapId as String) as Element?;
                        if (t.element == null || t.elementWrap == null) {
                            return;
                        }
                        t.element!!.style.setProperty("transition-duration", t._duration.toString() + "ms");
                        t.elementWrap!!.style.setProperty("transition-duration", t._duration.toString() + "ms");
                        t.element!!.style.setProperty("opacity", 1);
                        t.elementWrap!!.style.setProperty("transform", "translate(0%," + (if (t._space) {
                            -24;
                        } else {
                            0;
                        }) + "rpx)");
                    }, watiDuration);
                } else if (t.status == "close") {
                    t.element!!.style.setProperty("transition-duration", t._duration.toString() + "ms");
                    t.elementWrap!!.style.setProperty("transition-duration", t._duration.toString() + "ms");
                    t.element!!.style.setProperty("opacity", 0);
                    t.elementWrap!!.style.setProperty("transform", "translate(0%,100%)");
                }
            }
             catch (e: Throwable) {}
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
        this.overTouch = fun(evt: UniTouchEvent) {
            evt.stopPropagation();
        }
        ;
        this.onCancel = fun() {
            this.closeAlert();
            this.`$emit`("cancel");
        }
        ;
    }
    open lateinit var getFontSize: (size: String) -> String;
    open lateinit var itemClick: (index: Number, disabled: Boolean) -> Unit;
    open lateinit var overflayMoveTouch: (evt: TouchEvent) -> Unit;
    open lateinit var onClickOverflowy: (evt: Event) -> Unit;
    open lateinit var closeAlert: () -> Unit;
    open lateinit var showAlert: () -> Unit;
    open lateinit var setStyleAni: () -> Unit;
    open lateinit var openDrawer: () -> Unit;
    open lateinit var onEnd: () -> Unit;
    open lateinit var overTouch: (evt: UniTouchEvent) -> Unit;
    open lateinit var onCancel: () -> Unit;
    companion object {
        val styles: Map<String, Map<String, Map<String, Any>>>
            get() {
                return normalizeCssStyles(utsArrayOf(
                    styles0
                ));
            }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return utsMapOf("xActionText" to padStyleMapOf(utsMapOf("lines" to 1)), "xActionMenuWrapContentBox" to padStyleMapOf(utsMapOf("display" to "flex", "flexDirection" to "column", "flex" to 1)), "xActionMenuItem" to padStyleMapOf(utsMapOf("display" to "flex", "flexDirection" to "row", "justifyContent" to "center", "alignItems" to "center", "height" to 50, "marginBottom" to 1)), "xActionMenuFooter" to padStyleMapOf(utsMapOf("width" to "100%", "marginTop" to 8, "height" to 50, "display" to "flex", "flexDirection" to "row", "justifyContent" to "center", "alignItems" to "center")), "xActionMenuFooterText" to padStyleMapOf(utsMapOf("fontSize" to 16, "color" to "#333333", "textAlign" to "center")), "xActionMenuXclose" to padStyleMapOf(utsMapOf("position" to "absolute", "right" to 12, "top" to 6, "zIndex" to 100)), "xActionMenuTitleBox" to padStyleMapOf(utsMapOf("height" to 44, "display" to "flex", "flexDirection" to "row", "alignItems" to "center", "justifyContent" to "center", "marginBottom" to 4)), "xActionMenutitleBox" to padStyleMapOf(utsMapOf("maxWidth" to 175, "overflow" to "hidden", "lines" to 1, "textOverflow" to "ellipsis", "fontSize" to 14, "color" to "#888888")), "xActionMenuWrap_bottom" to padStyleMapOf(utsMapOf("display" to "flex", "flexDirection" to "row", "justifyContent" to "center", "alignItems" to "flex-end")), "xActionMenuWrapContent" to padStyleMapOf(utsMapOf("transitionDuration" to "350ms", "transitionProperty" to "transform", "display" to "flex", "flexDirection" to "column", "maxWidth" to 500, "flex" to 1)), "onOpenSpace" to padStyleMapOf(utsMapOf("marginTop" to 0, "marginRight" to 16, "marginBottom" to 0, "marginLeft" to 16)), "xActionMenuWrapContent_bottom" to padStyleMapOf(utsMapOf("transform" to "translate(0%, 100%)")), "xActionMenuWrap" to padStyleMapOf(utsMapOf("backgroundColor" to "rgba(0,0,0,0.35)", "opacity" to 0, "position" to "fixed", "zIndex" to 1100, "left" to 0, "top" to 0, "transitionDuration" to "350ms", "transitionProperty" to "opacity")), "@TRANSITION" to utsMapOf("xActionMenuWrapContent" to utsMapOf("duration" to "350ms", "property" to "transform"), "xActionMenuWrap" to utsMapOf("duration" to "350ms", "property" to "opacity")));
            }
        var inheritAttrs = true;
        var inject: Map<String, Map<String, Any?>> = utsMapOf();
        var emits: Map<String, Any?> = utsMapOf("cancel" to null, "click" to null, "close" to null, "open" to null, "beforeOpen" to null, "beforeClose" to null, "update:show" to null, "item-click" to null);
        var props = normalizePropsOptions(utsMapOf("customStyle" to utsMapOf("type" to "String", "default" to ""), "title" to utsMapOf("type" to "String", "default" to "标题"), "showTitle" to utsMapOf("type" to "Boolean", "default" to true), "showClose" to utsMapOf("type" to "Boolean", "default" to false), "overlayClick" to utsMapOf("type" to "Boolean", "default" to true), "cellClickClose" to utsMapOf("type" to "Boolean", "default" to true), "show" to utsMapOf("type" to "Boolean", "default" to false), "showCancel" to utsMapOf("type" to "Boolean", "default" to true), "duration" to utsMapOf("type" to "Number", "default" to 350), "round" to utsMapOf("type" to "String", "default" to ""), "maxHeight" to utsMapOf("type" to "String", "default" to ""), "list" to utsMapOf("type" to "Array", "default" to fun(): UTSArray<XACTION_MENU_ITEM_INFO> {
            return utsArrayOf<XACTION_MENU_ITEM_INFO>();
        }
        ), "space" to utsMapOf("type" to "Boolean", "default" to true), "watiDuration" to utsMapOf("type" to "Number", "default" to 120)));
        var propsNeedCastKeys = utsArrayOf(
            "customStyle",
            "title",
            "showTitle",
            "showClose",
            "overlayClick",
            "cellClickClose",
            "show",
            "showCancel",
            "duration",
            "round",
            "maxHeight",
            "list",
            "space",
            "watiDuration"
        );
        var components: Map<String, CreateVueComponent> = utsMapOf();
    }
}
