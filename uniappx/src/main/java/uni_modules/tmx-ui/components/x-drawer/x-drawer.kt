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
open class GenUniModulesTmxUiComponentsXDrawerXDrawer : VueComponent {
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
        val _component_x_button = resolveEasyComponent("x-button", GenUniModulesTmxUiComponentsXButtonXButtonClass);
        return createElementVNode("view", null, utsArrayOf(
            createElementVNode("view", utsMapOf("onClick" to _ctx.openDrawer), utsArrayOf(
                renderSlot(_ctx.`$slots`, "trigger", GenUniModulesTmxUiComponentsXDrawerXDrawerSlotDataTrigger(show = _ctx.show))
            ), 8, utsArrayOf(
                "onClick"
            )),
            if (isTrue(_ctx.showOverflay)) {
                createElementVNode("view", utsMapOf("key" to 0, "onClick" to _ctx.onClickOverflowy, "onTouchmove" to _ctx.maskerMove, "onTransitionend" to _ctx.onEnd, "id" to _ctx.id, "ref" to "xDrawerWrap", "class" to normalizeClass(utsArrayOf(
                    "xDrawerWrap",
                    utsArrayOf(
                        if ((_ctx._position == "top" || _ctx._position == "bottom") && _ctx._widthCoverCenter) {
                            "xDrawerWrapContentMinwidthWrapDir";
                        } else {
                            "";
                        },
                        "xDrawerWrap_" + _ctx._position
                    )
                )), "style" to normalizeStyle(utsArrayOf(
                    utsMapOf("backgroundColor" to _ctx.overflayBgColor, "width" to "100%", "top" to (_ctx.windtop + "px"), "height" to _ctx.__height, "transition-timing-function" to _ctx._animationFun),
                    _ctx._customStyle
                ))), utsArrayOf(
                    createElementVNode("view", utsMapOf("onClick" to withModifiers(fun(){}, utsArrayOf(
                        "stop"
                    )), "ref" to "xDrawerWrapContent", "class" to normalizeClass(utsArrayOf(
                        "xDrawerWrapContent",
                        utsArrayOf(
                            if ((_ctx._position == "top" || _ctx._position == "bottom") && _ctx._widthCoverCenter) {
                                "xDrawerWrapContentMinwidth";
                            } else {
                                "";
                            },
                            "xDrawerWrapContent_" + _ctx._position
                        )
                    )), "onTouchstart" to _ctx.mStart, "onTouchmove" to _ctx.mMove, "onTouchend" to _ctx.mEnd, "id" to _ctx.wrapId, "style" to normalizeStyle(utsMapOf("width" to if (_ctx._position == "left" || _ctx._position == "right") {
                        _ctx._size;
                    } else {
                        "100%";
                    }, "height" to if (_ctx._position == "left" || _ctx._position == "right") {
                        "100%";
                    } else {
                        _ctx._size;
                    }, "borderRadius" to _ctx._round, "maxHeight" to if (_ctx._maxHeight != "") {
                        _ctx._maxHeight;
                    } else {
                        "100%";
                    }, "transition-timing-function" to _ctx._animationFun, "backgroundColor" to _ctx._bgColor))), utsArrayOf(
                        if (isTrue(_ctx._showClose)) {
                            createVNode(_component_x_icon, utsMapOf("key" to 0, "class" to "xDrawerXclose", "onClick" to _ctx.cancelEvt, "color" to "#dcdcdc", "font-size" to "21", "name" to "close-circle-fill"), null, 8, utsArrayOf(
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
                                            createElementVNode("text", utsMapOf("style" to normalizeStyle(utsMapOf("fontSize" to _ctx._titleFontSize, "color" to if (_ctx._isDark) {
                                                "white";
                                            } else {
                                                "black";
                                            }, "opacity" to "0.64")), "class" to "xDrawertitleBox"), toDisplayString(_ctx._title), 5)
                                        );
                                    })
                                ));
                            } else {
                                createCommentVNode("v-if", true);
                            }
                        )),
                        createElementVNode("view", utsMapOf("ref" to "xDrawerContent", "class" to "xDrawerContent", "style" to normalizeStyle(utsMapOf("flex" to "1", "margin" to ("0px " + _ctx._contentMargin + " " + _ctx._contentMargin + " " + _ctx._contentMargin)))), utsArrayOf(
                            if (isTrue(!_ctx.disabledScroll)) {
                                createElementVNode("scroll-view", utsMapOf("key" to 0, "onScroll" to _ctx.onScroll, "onScrolltoupper" to _ctx.onScrollTop, "onScrolltolower" to _ctx.onScrollBottom, "style" to normalizeStyle(utsMapOf("flex" to "1")), "scroll-y" to true, "rebound" to false), utsArrayOf(
                                    renderSlot(_ctx.`$slots`, "default", utsMapOf("show" to _ctx.show))
                                ), 44, utsArrayOf(
                                    "onScroll",
                                    "onScrolltoupper",
                                    "onScrolltolower"
                                ));
                            } else {
                                createElementVNode("view", utsMapOf("key" to 1, "style" to normalizeStyle(utsMapOf("flex" to "1"))), utsArrayOf(
                                    renderSlot(_ctx.`$slots`, "default", utsMapOf("show" to _ctx.show))
                                ), 4);
                            }
                        ), 4),
                        if (isTrue(_ctx.showFooter)) {
                            createElementVNode("view", utsMapOf("key" to 1, "class" to "xDrawerFooter", "style" to normalizeStyle(utsMapOf("backgroundColor" to _ctx._bgColor))), utsArrayOf(
                                renderSlot(_ctx.`$slots`, "footer", UTSJSONObject(), fun(): UTSArray<Any> {
                                    return utsArrayOf(
                                        createElementVNode("view", utsMapOf("style" to normalizeStyle(utsMapOf("flex-direction" to "row", "align-items" to "center", "justify-content" to "center"))), utsArrayOf(
                                            if (isTrue(_ctx._showCancel)) {
                                                createVNode(_component_x_button, utsMapOf("key" to 0, "onClick" to _ctx.cancelEvt, "skin" to "thin", "width" to "0px", "block" to true, "style" to normalizeStyle(utsMapOf("margin-right" to "16rpx", "flex" to "1"))), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
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
                                        ), 4)
                                    );
                                })
                            ), 4);
                        } else {
                            createCommentVNode("v-if", true);
                        }
                    ), 46, utsArrayOf(
                        "onClick",
                        "onTouchstart",
                        "onTouchmove",
                        "onTouchend",
                        "id"
                    ))
                ), 46, utsArrayOf(
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
    open var overlayClick: Boolean by `$props`;
    open var show: Boolean by `$props`;
    open var showCancel: Boolean by `$props`;
    open var cancelText: String by `$props`;
    open var confirmText: String by `$props`;
    open var duration: Number by `$props`;
    open var watiDuration: Number by `$props`;
    open var position: String by `$props`;
    open var round: String by `$props`;
    open var size: String by `$props`;
    open var maxHeight: String by `$props`;
    open var bgColor: String by `$props`;
    open var darkBgColor: String by `$props`;
    open var overflayBgColor: String by `$props`;
    open var disabledScroll: Boolean by `$props`;
    open var contentMargin: String by `$props`;
    open var widthCoverCenter: Boolean by `$props`;
    open var swiperLenClose: Number by `$props`;
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
    open var start_move_x: Number by `$data`;
    open var start_move_y: Number by `$data`;
    open var move_x: Number by `$data`;
    open var move_y: Number by `$data`;
    open var move_end_x: Number by `$data`;
    open var move_end_y: Number by `$data`;
    open var scrollTop: Number by `$data`;
    open var isTopOrBottomByScroll: Boolean by `$data`;
    open var xDrawerContentHeight: Number by `$data`;
    open var _customStyle: String by `$data`;
    open var _show: Boolean by `$data`;
    open var _widthCoverCenter: Boolean by `$data`;
    open var _showClose: Boolean by `$data`;
    open var _duration: Number by `$data`;
    open var _position: String by `$data`;
    open var _title: String by `$data`;
    open var _showTitle: Boolean by `$data`;
    open var _round: String by `$data`;
    open var _size: String by `$data`;
    open var _contentMargin: String by `$data`;
    open var _showFooter: Boolean by `$data`;
    open var _maxHeight: String by `$data`;
    open var _showCancel: Boolean by `$data`;
    open var _cancelText: String by `$data`;
    open var _confirmText: String by `$data`;
    open var _animationFun: String by `$data`;
    open var _bgColor: String by `$data`;
    open var __height: String by `$data`;
    open var _titleFontSize: String by `$data`;
    open var _isDark: Boolean by `$data`;
    @Suppress("USELESS_CAST")
    override fun data(): Map<String, Any?> {
        return utsMapOf("_width" to 0, "_height" to 0, "showOverflay" to false, "element" to null as Element?, "elementWrap" to null as Element?, "actioning" to false, "status" to "", "id" to ("xDrawer" + getUid()), "wrapId" to ("xDrawerWrap" + getUid()), "first" to true, "tid" to 0, "windtop" to 0, "start_move_x" to 0, "start_move_y" to 0, "move_x" to 0, "move_y" to 0, "move_end_x" to 0, "move_end_y" to 0, "scrollTop" to -1, "isTopOrBottomByScroll" to false, "xDrawerContentHeight" to 0, "_customStyle" to computed<String>(fun(): String {
            return this.customStyle;
        }
        ), "_show" to computed<Boolean>(fun(): Boolean {
            return this.show;
        }
        ), "_widthCoverCenter" to computed<Boolean>(fun(): Boolean {
            return this.widthCoverCenter;
        }
        ), "_showClose" to computed<Boolean>(fun(): Boolean {
            return this.showClose;
        }
        ), "_duration" to computed<Number>(fun(): Number {
            return this.duration;
        }
        ), "_position" to computed<String>(fun(): String {
            return this.position;
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
            var _r = "none";
            if (this.position == "top") {
                _r = "0px 0px " + radius + " " + radius;
            }
            if (this.position == "bottom") {
                _r = "" + radius + " " + radius + " 0px 0px";
            }
            return _r;
        }
        ), "_size" to computed<String>(fun(): String {
            return checkIsCssUnit(this.size, xConfig.unit);
        }
        ), "_contentMargin" to computed<String>(fun(): String {
            return checkIsCssUnit(this.contentMargin, xConfig.unit);
        }
        ), "_showFooter" to computed<Boolean>(fun(): Boolean {
            return this.showFooter;
        }
        ), "_maxHeight" to computed<String>(fun(): String {
            if (this.maxHeight == "") {
                return "";
            }
            if (this.position == "left" || this.position == "right") {
                return "";
            }
            return checkIsCssUnit(this.maxHeight, xConfig.unit);
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
        ), "_bgColor" to computed<String>(fun(): String {
            var bgcolor = this.bgColor;
            if (xConfig.dark == "dark") {
                if (this.darkBgColor != "") {
                }
                bgcolor = if (this.darkBgColor != "") {
                    this.darkBgColor;
                } else {
                    xConfig.sheetDarkColor;
                }
                ;
            }
            return getDefaultColor(bgcolor);
        }
        ), "__height" to computed<String>(fun(): String {
            var h = "100%";
            return h;
        }
        ), "_titleFontSize" to computed<String>(fun(): String {
            return (xConfig.fontScale * 16).toString() + "px";
        }
        ), "_isDark" to computed<Boolean>(fun(): Boolean {
            return xConfig.dark == "dark";
        }
        ));
    }
    override fun `$initMethods`() {
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
            try {
                var t = this;
                var watiDuration: Number = 60;
                if (this.status == "open") {
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
                        t.element!!.style.setProperty("opacity", 1);
                        t.elementWrap!!.style.setProperty("transform", "translate(0%,0%)");
                    }, watiDuration);
                } else if (this.status == "close") {
                    this.element!!.style.setProperty("transition-duration", this._duration.toString() + "ms");
                    this.elementWrap!!.style.setProperty("transition-duration", this._duration.toString() + "ms");
                    this.element!!.style.setProperty("opacity", 0);
                    if (this._position == "bottom") {
                        this.elementWrap!!.style.setProperty("transform", "translate(0%,100%)");
                    } else if (this._position == "top") {
                        this.elementWrap!!.style.setProperty("transform", "translate(0%,-100%)");
                    } else if (this._position == "left") {
                        this.elementWrap!!.style.setProperty("transform", "translate(-100%,0%)");
                    } else if (this._position == "right") {
                        this.elementWrap!!.style.setProperty("transform", "translate(100%,0%)");
                    }
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
        this.maskerMove = fun(evt: UniTouchEvent) {};
        this.mStart = fun(evt: UniTouchEvent) {
            this.start_move_x = evt.changedTouches[0].clientX;
            this.start_move_y = evt.changedTouches[0].clientY;
        }
        ;
        this.mMove = fun(evt: UniTouchEvent) {
            if (evt.changedTouches.length == 0) {
                return;
            }
            this.move_x = evt.changedTouches[0].clientX;
            this.move_y = evt.changedTouches[0].clientY;
        }
        ;
        this.mEnd = fun(evt: UniTouchEvent) {
            if (evt.changedTouches.length == 0) {
                return;
            }
            var x = evt.changedTouches[0].clientX;
            var y = evt.changedTouches[0].clientY;
            this.move_end_x = x;
            this.move_end_y = y;
            this.swiperClose();
        }
        ;
        this.swiperClose = fun() {
            var offsetX = this.move_end_x - this.start_move_x;
            var offsetY = this.move_end_y - this.start_move_y;
            if (this.swiperLenClose == 0 || (this.actioning && this.status == "close")) {
                return;
            }
            if (this.position == "left" && offsetX < this.swiperLenClose * -1 && Math.abs(offsetX) >= Math.abs(offsetY)) {
                this.closeAlert();
            }
            if (this.position == "right" && offsetX > this.swiperLenClose && Math.abs(offsetX) >= Math.abs(offsetY)) {
                this.closeAlert();
            }
            if (this.position == "top" && offsetY < this.swiperLenClose * -1 && Math.abs(offsetY) >= Math.abs(offsetX)) {
                this.closeAlert();
            }
            if (this.position == "bottom" && offsetY > this.swiperLenClose && Math.abs(offsetY) >= Math.abs(offsetX)) {
                this.closeAlert();
            }
        }
        ;
        this.onScroll = fun(evt: UniScrollEvent) {
            if (this.position == "bottom") {
                if (evt.detail.scrollTop > 0) {
                    this.start_move_x = this.move_x;
                    this.start_move_y = this.move_y;
                }
            }
            if (this.position == "top") {
                var ele = this.`$refs`["xDrawerContent"] as UniElement?;
                if (ele == null) {
                    return;
                }
                var height = ele.getBoundingClientRect().height;
                var maxheight = evt.detail.scrollHeight - evt.detail.scrollTop;
                if (evt.detail.scrollTop < maxheight - 1) {
                    this.start_move_x = this.move_x;
                    this.start_move_y = this.move_y;
                }
            }
        }
        ;
        this.onScrollTop = fun(evt: UniScrollToUpperEvent) {
            this.start_move_x = this.move_x;
            this.start_move_y = this.move_y;
        }
        ;
        this.onScrollBottom = fun(evt: UniScrollToLowerEvent) {
            this.start_move_x = this.move_x;
            this.start_move_y = this.move_y;
        }
        ;
    }
    open lateinit var cancelEvt: () -> Unit;
    open lateinit var confirmEvt: () -> Unit;
    open lateinit var overflayMoveTouch: (evt: TouchEvent) -> Unit;
    open lateinit var onClickOverflowy: (evt: Event) -> Unit;
    open lateinit var closeAlert: () -> Unit;
    open lateinit var showAlert: () -> Unit;
    open lateinit var setStyleAni: () -> Unit;
    open lateinit var openDrawer: () -> Unit;
    open lateinit var onEnd: () -> Unit;
    open lateinit var maskerMove: (evt: UniTouchEvent) -> Unit;
    open lateinit var mStart: (evt: UniTouchEvent) -> Unit;
    open lateinit var mMove: (evt: UniTouchEvent) -> Unit;
    open lateinit var mEnd: (evt: UniTouchEvent) -> Unit;
    open lateinit var swiperClose: () -> Unit;
    open lateinit var onScroll: (evt: UniScrollEvent) -> Unit;
    open lateinit var onScrollTop: (evt: UniScrollToUpperEvent) -> Unit;
    open lateinit var onScrollBottom: (evt: UniScrollToLowerEvent) -> Unit;
    companion object {
        val styles: Map<String, Map<String, Map<String, Any>>>
            get() {
                return normalizeCssStyles(utsArrayOf(
                    styles0
                ));
            }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return utsMapOf("xDrawerFooter" to padStyleMapOf(utsMapOf("width" to "100%", "paddingTop" to 0, "paddingRight" to 16, "paddingBottom" to 16, "paddingLeft" to 16)), "xDrawerXclose" to padStyleMapOf(utsMapOf("position" to "absolute", "right" to 16, "top" to 13, "zIndex" to 100)), "xDrawerTitleBox" to padStyleMapOf(utsMapOf("height" to 50, "display" to "flex", "flexDirection" to "row", "alignItems" to "center", "justifyContent" to "center")), "xDrawertitleBox" to padStyleMapOf(utsMapOf("maxWidth" to 175, "overflow" to "hidden", "lines" to 1, "textOverflow" to "ellipsis")), "xDrawerWrap_bottom" to padStyleMapOf(utsMapOf("display" to "flex", "flexDirection" to "column", "justifyContent" to "flex-end")), "xDrawerWrap_top" to padStyleMapOf(utsMapOf("display" to "flex", "flexDirection" to "column", "justifyContent" to "flex-start")), "xDrawerWrap_left" to padStyleMapOf(utsMapOf("display" to "flex", "flexDirection" to "row", "justifyContent" to "flex-start")), "xDrawerWrap_right" to padStyleMapOf(utsMapOf("display" to "flex", "flexDirection" to "row", "justifyContent" to "flex-end")), "xDrawerWrapContent" to padStyleMapOf(utsMapOf("transitionDuration" to "350ms", "transitionProperty" to "transform", "display" to "flex", "flexDirection" to "column")), "xDrawerWrapContentMinwidth" to padStyleMapOf(utsMapOf("maxWidth" to 500)), "xDrawerWrapContentMinwidthWrapDir" to padStyleMapOf(utsMapOf("alignItems" to "center")), "xDrawerWrapContent_bottom" to padStyleMapOf(utsMapOf("transform" to "translate(0%, 100%)")), "xDrawerWrapContent_top" to padStyleMapOf(utsMapOf("transform" to "translate(0%, -100%)")), "xDrawerWrapContent_left" to padStyleMapOf(utsMapOf("transform" to "translate(-100%, 0%)")), "xDrawerWrapContent_right" to padStyleMapOf(utsMapOf("transform" to "translate(100%, 0%)")), "xDrawerWrap" to padStyleMapOf(utsMapOf("opacity" to 0, "position" to "fixed", "zIndex" to 1100, "left" to 0, "top" to 0, "transitionDuration" to "350ms", "transitionProperty" to "opacity")), "@TRANSITION" to utsMapOf("xDrawerWrapContent" to utsMapOf("duration" to "350ms", "property" to "transform"), "xDrawerWrap" to utsMapOf("duration" to "350ms", "property" to "opacity")));
            }
        var inheritAttrs = true;
        var inject: Map<String, Map<String, Any?>> = utsMapOf();
        var emits: Map<String, Any?> = utsMapOf("click" to null, "close" to null, "open" to null, "beforeOpen" to null, "beforeClose" to null, "update:show" to null, "cancel" to null, "confirm" to null);
        var props = normalizePropsOptions(utsMapOf("customStyle" to utsMapOf("type" to "String", "default" to ""), "title" to utsMapOf("type" to "String", "default" to "标题"), "showFooter" to utsMapOf("type" to "Boolean", "default" to false), "showTitle" to utsMapOf("type" to "Boolean", "default" to true), "showClose" to utsMapOf("type" to "Boolean", "default" to false), "overlayClick" to utsMapOf("type" to "Boolean", "default" to true), "show" to utsMapOf("type" to "Boolean", "default" to false), "showCancel" to utsMapOf("type" to "Boolean", "default" to true), "cancelText" to utsMapOf("type" to "String", "default" to "取消"), "confirmText" to utsMapOf("type" to "String", "default" to "确认"), "duration" to utsMapOf("type" to "Number", "default" to 300), "watiDuration" to utsMapOf("type" to "Number", "default" to 120), "position" to utsMapOf("type" to "String", "default" to "bottom"), "round" to utsMapOf("type" to "String", "default" to ""), "size" to utsMapOf("type" to "String", "default" to "50%"), "maxHeight" to utsMapOf("type" to "String", "default" to ""), "bgColor" to utsMapOf("type" to "String", "default" to "white"), "darkBgColor" to utsMapOf("type" to "String", "default" to ""), "overflayBgColor" to utsMapOf("type" to "String", "default" to "rgba(0, 0, 0, 0.4)"), "disabledScroll" to utsMapOf("type" to "Boolean", "default" to false), "contentMargin" to utsMapOf("type" to "String", "default" to "16"), "widthCoverCenter" to utsMapOf("type" to "Boolean", "default" to false), "swiperLenClose" to utsMapOf("type" to "Number", "default" to 0)));
        var propsNeedCastKeys = utsArrayOf(
            "customStyle",
            "title",
            "showFooter",
            "showTitle",
            "showClose",
            "overlayClick",
            "show",
            "showCancel",
            "cancelText",
            "confirmText",
            "duration",
            "watiDuration",
            "position",
            "round",
            "size",
            "maxHeight",
            "bgColor",
            "darkBgColor",
            "overflayBgColor",
            "disabledScroll",
            "contentMargin",
            "widthCoverCenter",
            "swiperLenClose"
        );
        var components: Map<String, CreateVueComponent> = utsMapOf();
    }
}
