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
import uts.sdk.modules.xLoadingS.showLoading;
import uts.sdk.modules.xLoadingS.hideXloading;
import uts.sdk.modules.xLoadingS.XLOADINGS_TYPE;
open class GenPagesTabBarTeacherListTeacherList : BasePage {
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
        onMounted(fun() {
            setTimeout(fun(){
                showLoading(XLOADINGS_TYPE(title = "请稍后..."));
                this.getList();
            }
            , 500);
        }
        , instance);
    }
    @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
    override fun `$render`(): Any? {
        val _ctx = this;
        val _cache = this.`$`.renderCache;
        val _component_header_uvue = resolveComponent("header-uvue");
        val _component_x_sheet = resolveEasyComponent("x-sheet", GenUniModulesTmxUiComponentsXSheetXSheetClass);
        val _component_TeacherCardUvue = resolveComponent("TeacherCardUvue");
        val _component_x_text = resolveEasyComponent("x-text", GenUniModulesTmxUiComponentsXTextXTextClass);
        return createElementVNode("list-view", utsMapOf("class" to "flex-1", "refresher-enabled" to "true", "onRefresherrefresh" to _ctx.onRefresherrefresh, "onScrolltolower" to _ctx.scrolltolower, "enable-back-to-top" to "true", "refresher-triggered" to _ctx.refresherTriggered), utsArrayOf(
            createElementVNode("sticky-header", null, utsArrayOf(
                createVNode(_component_x_sheet, utsMapOf("round" to utsArrayOf(
                    "0"
                ), "margin" to utsArrayOf(
                    "0"
                )), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                    return utsArrayOf(
                        createVNode(_component_header_uvue)
                    );
                }
                ), "_" to 1))
            )),
            createElementVNode(Fragment, null, RenderHelpers.renderList(_ctx.teacherList, fun(item, index, _, _): VNode {
                return createElementVNode("list-item", utsMapOf("key" to index, "type" to "1"), utsArrayOf(
                    createElementVNode("view", utsMapOf("class" to "pt-5"), utsArrayOf(
                        createVNode(_component_TeacherCardUvue, utsMapOf("teacher" to item), null, 8, utsArrayOf(
                            "teacher"
                        ))
                    ))
                ));
            }
            ), 128),
            createElementVNode("list-item", utsMapOf("type" to "2"), utsArrayOf(
                createElementVNode("view", utsMapOf("style" to normalizeStyle(utsMapOf("height" to "50px")), "class" to "pb-20"), utsArrayOf(
                    if (isTrue(_ctx.bottomLoad)) {
                        createElementVNode("view", utsMapOf("key" to 0, "class" to "flex-row flex-center"), utsArrayOf(
                            createVNode(_component_x_text, utsMapOf("fontSize" to "12", "color" to "#ccc", "class" to "pl-2 text-grey"), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                                return utsArrayOf(
                                    " 加载中,请稍后..."
                                );
                            }), "_" to 1))
                        ));
                    } else {
                        createCommentVNode("v-if", true);
                    }
                ), 4)
            ))
        ), 40, utsArrayOf(
            "onRefresherrefresh",
            "onScrolltolower",
            "refresher-triggered"
        ));
    }
    open var bottomLoad: Boolean by `$data`;
    open var teacherList: UTSArray<TeacherType> by `$data`;
    open var page: TeacherListOptions by `$data`;
    open var isNext: Boolean by `$data`;
    open var refresherTriggered: Boolean by `$data`;
    @Suppress("USELESS_CAST")
    override fun data(): Map<String, Any?> {
        return utsMapOf("bottomLoad" to false, "teacherList" to utsArrayOf<TeacherType>(), "page" to TeacherListOptions(current = 1, size = 20), "isNext" to true, "refresherTriggered" to false);
    }
    override fun `$initMethods`() {
        this.onRefresherrefresh = fun() {
            this.refresherTriggered = true;
            this.page.current = 1;
            this.isNext = true;
            this.getList();
        }
        ;
        this.getList = fun() {
            var t = this;
            setTimeout(fun() {
                TeacherApi.getAListOfTeachers(t.page).then(fun(res: TeachersListDataType?){
                    if (t.refresherTriggered == true) {
                        t.teacherList = utsArrayOf();
                    }
                    t.teacherList.push(*res!!.records.toTypedArray());
                    if (res!!.records.length < 20) {
                        t.isNext = false;
                    }
                }
                ).`catch`(fun(){}).`finally`(fun(){
                    setTimeout(fun(){
                        t.refresherTriggered = false;
                        t.bottomLoad = false;
                        hideXloading();
                    }
                    , 500);
                }
                );
            }
            , 500);
        }
        ;
        this.scrolltolower = fun() {
            if (this.isNext == true && this.bottomLoad == false) {
                console.log("到底了", " at pages/tabBar/teacherList/teacherList.uvue:64");
                this.bottomLoad = true;
                this.page.current += 1;
                this.getList();
            }
        }
        ;
    }
    open lateinit var onRefresherrefresh: () -> Unit;
    open lateinit var getList: () -> Unit;
    open lateinit var scrolltolower: () -> Unit;
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
        var components: Map<String, CreateVueComponent> = utsMapOf("TeacherCardUvue" to GenPagesTabBarTeacherListLibTeacherCardClass, "headerUvue" to GenPagesTabBarTeacherListLibHeaderHeaderClass);
    }
}
