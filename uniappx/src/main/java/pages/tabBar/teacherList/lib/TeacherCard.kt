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
open class GenPagesTabBarTeacherListLibTeacherCard : VueComponent {
    constructor(instance: ComponentInternalInstance) : super(instance) {}
    @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
    override fun `$render`(): Any? {
        val _ctx = this;
        val _cache = this.`$`.renderCache;
        val _component_x_text = resolveEasyComponent("x-text", GenUniModulesTmxUiComponentsXTextXTextClass);
        val _component_x_icon = resolveEasyComponent("x-icon", GenUniModulesTmxUiComponentsXIconXIconClass);
        val _component_x_tag = resolveEasyComponent("x-tag", GenUniModulesTmxUiComponentsXTagXTagClass);
        val _component_x_button = resolveEasyComponent("x-button", GenUniModulesTmxUiComponentsXButtonXButtonClass);
        val _component_x_sheet = resolveEasyComponent("x-sheet", GenUniModulesTmxUiComponentsXSheetXSheetClass);
        return createVNode(_component_x_sheet, utsMapOf("style" to normalizeStyle(utsMapOf("flex" to "1")), "darkColor" to "#1b1b1b"), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
            return utsArrayOf(
                createElementVNode("view", utsMapOf("class" to "flex-row"), utsArrayOf(
                    createElementVNode("image", utsMapOf("style" to normalizeStyle(utsMapOf("width" to "100px", "height" to "100px")), "class" to "round-10 grey", "src" to (_ctx.teacher.teacher_pic + "!w_128")), null, 12, utsArrayOf(
                        "src"
                    )),
                    createElementVNode("view", utsMapOf("class" to "pl-10"), utsArrayOf(
                        createElementVNode("view", utsMapOf("class" to "flex-row flex-row-center-start"), utsArrayOf(
                            createVNode(_component_x_text, utsMapOf("lines" to 1, "fontSize" to "20px"), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                                return utsArrayOf(
                                    toDisplayString(_ctx.teacher["teacher_nick_name"])
                                );
                            }
                            ), "_" to 1)),
                            createVNode(_component_x_icon, utsMapOf("class" to "ml-2", "font-size" to "20", "name" to ("https://hangzhanedu.oss-cn-hangzhou.aliyuncs.com/img/nationality/" + _ctx.teacher.teacher_nationality + ".png")), null, 8, utsArrayOf(
                                "name"
                            ))
                        )),
                        createElementVNode("view", utsMapOf("class" to "flex flex-row"), utsArrayOf(
                            createElementVNode(Fragment, null, RenderHelpers.renderList(_ctx.teacher.teacher_tag, fun(item, _, _, _): VNode {
                                return createVNode(_component_x_tag, utsMapOf("skin" to "thin", "class" to "mr-5"), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                                    return utsArrayOf(
                                        toDisplayString(item)
                                    );
                                }
                                ), "_" to 2), 1024);
                            }
                            ), 256)
                        )),
                        createElementVNode("view", utsMapOf("class" to ""))
                    ))
                )),
                createElementVNode("view", utsMapOf("class" to "pt-5"), utsArrayOf(
                    createVNode(_component_x_text, utsMapOf("color" to "#ccc", "font-size" to "13", "lineHeight" to "1.4", "lines" to 3), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                        return utsArrayOf(
                            toDisplayString(_ctx.teacher["introduction_cn"])
                        );
                    }
                    ), "_" to 1))
                )),
                createElementVNode("view", utsMapOf("class" to "flex flex-row flex-row-center-between mt-10"), utsArrayOf(
                    createVNode(_component_x_button, utsMapOf("width" to "48%"), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                        return utsArrayOf(
                            "预约课程"
                        );
                    }
                    ), "_" to 1)),
                    createVNode(_component_x_button, utsMapOf("width" to "48%", "skin" to "thin"), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                        return utsArrayOf(
                            "查看简历"
                        );
                    }
                    ), "_" to 1))
                ))
            );
        }
        ), "_" to 1), 8, utsArrayOf(
            "style"
        ));
    }
    open var teacher: TeacherType by `$props`;
    companion object {
        val styles: Map<String, Map<String, Map<String, Any>>>
            get() {
                return normalizeCssStyles(utsArrayOf());
            }
        var inheritAttrs = true;
        var inject: Map<String, Map<String, Any?>> = utsMapOf();
        var emits: Map<String, Any?> = utsMapOf();
        var props = normalizePropsOptions(utsMapOf("teacher" to utsMapOf("type" to "Object", "required" to true)));
        var propsNeedCastKeys: UTSArray<String> = utsArrayOf();
        var components: Map<String, CreateVueComponent> = utsMapOf();
    }
}
