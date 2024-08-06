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
open class GenPagesTabBarTeacherListLibHeaderHeader : VueComponent {
    constructor(instance: ComponentInternalInstance) : super(instance) {}
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenPagesTabBarTeacherListLibHeaderHeader) -> Any? = fun(
        @Suppress("UNUSED_ANONYMOUS_PARAMETER")
        __props): Any? {
            val __ins = getCurrentInstance()!!;
            val _ctx = __ins.proxy as GenPagesTabBarTeacherListLibHeaderHeader;
            val _cache = __ins.renderCache;
            val show = ref(false);
            val menuList = utsArrayOf<XACTION_MENU_ITEM_INFO>(XACTION_MENU_ITEM_INFO(text = "英语(English)", id = "yingyu"), XACTION_MENU_ITEM_INFO(text = "韩语(한국어)", id = "hanyu"), XACTION_MENU_ITEM_INFO(text = "日语(日本語)", id = "riyu"));
            onBackPress(fun(_): Boolean? {
                if (show.value == true) {
                    show.value = false;
                    return true;
                }
                return null;
            }
            );
            return fun(): Any? {
                val _component_x_icon = resolveEasyComponent("x-icon", GenUniModulesTmxUiComponentsXIconXIconClass);
                val _component_x_text = resolveEasyComponent("x-text", GenUniModulesTmxUiComponentsXTextXTextClass);
                val _component_x_action_menu = resolveEasyComponent("x-action-menu", GenUniModulesTmxUiComponentsXActionMenuXActionMenuClass);
                val _component_x_input = resolveEasyComponent("x-input", GenUniModulesTmxUiComponentsXInputXInputClass);
                val _component_x_form_item = resolveEasyComponent("x-form-item", GenUniModulesTmxUiComponentsXFormItemXFormItemClass);
                val _component_x_button = resolveEasyComponent("x-button", GenUniModulesTmxUiComponentsXButtonXButtonClass);
                val _component_x_form = resolveEasyComponent("x-form", GenUniModulesTmxUiComponentsXFormXFormClass);
                val _component_x_drawer = resolveEasyComponent("x-drawer", GenUniModulesTmxUiComponentsXDrawerXDrawerClass);
                return createElementVNode("view", utsMapOf("class" to "flex-1"), utsArrayOf(
                    createElementVNode("view", utsMapOf("class" to "flex-row flex-around"), utsArrayOf(
                        createVNode(_component_x_action_menu, utsMapOf("list" to menuList, "title" to "请选择学习的语言"), utsMapOf("trigger" to withSlotCtx(fun(): UTSArray<Any> {
                            return utsArrayOf(
                                createElementVNode("view", utsMapOf("class" to "flex-row flex-start"), utsArrayOf(
                                    createVNode(_component_x_icon, utsMapOf("name" to "global-line", "color" to "#9e9e9e")),
                                    createVNode(_component_x_text, utsMapOf("class" to "pl-2 pr-10"), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                                        return utsArrayOf(
                                            "英语(English)"
                                        );
                                    }
                                    ), "_" to 1)),
                                    createVNode(_component_x_icon, utsMapOf("name" to "arrow-down-s-line", "fontSize" to "20", "color" to "#9e9e9e"))
                                ))
                            );
                        }
                        ), "_" to 1)),
                        createElementVNode("view", utsMapOf("class" to "flex-row flex-center", "onClick" to fun(){
                            show.value = true;
                        }
                        ), utsArrayOf(
                            createVNode(_component_x_icon, utsMapOf("name" to "menu-search-line", "color" to "#9e9e9e")),
                            createVNode(_component_x_text, utsMapOf("class" to "pl-2 pr-10"), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                                return utsArrayOf(
                                    "筛选条件"
                                );
                            }
                            ), "_" to 1)),
                            createVNode(_component_x_icon, utsMapOf("fontSize" to "20", "name" to "arrow-right-s-line", "color" to "#9e9e9e"))
                        ), 8, utsArrayOf(
                            "onClick"
                        ))
                    )),
                    createVNode(_component_x_drawer, utsMapOf("swiper-len-close" to 100, "title" to "筛选条件", "round" to "0", "show" to unref(show), "onUpdate:show" to fun(`$event`: Boolean){
                        trySetRefValue(show, `$event`);
                    }
                    , "size" to "100%", "position" to "right", "show-cancel" to true, "show-footer" to true), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                        return utsArrayOf(
                            createVNode(_component_x_form, utsMapOf("show-label" to false), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                                return utsArrayOf(
                                    createVNode(_component_x_form_item, utsMapOf("show-bottom-border" to false), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                                        return utsArrayOf(
                                            createVNode(_component_x_input, utsMapOf("placeholder" to "请输入帐号", "dark-bg-color" to ""))
                                        );
                                    }
                                    ), "_" to 1)),
                                    createVNode(_component_x_form_item, utsMapOf("show-bottom-border" to false), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                                        return utsArrayOf(
                                            createVNode(_component_x_input, utsMapOf("placeholder" to "请输入密码", "dark-bg-color" to ""))
                                        );
                                    }
                                    ), "_" to 1)),
                                    createVNode(_component_x_button, utsMapOf("form-type" to "form", "icon" to "lock-unlock-fill", "block" to true), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                                        return utsArrayOf(
                                            "登入"
                                        );
                                    }
                                    ), "_" to 1))
                                );
                            }
                            ), "_" to 1)),
                            createElementVNode("text", utsMapOf("class" to "text-size-m text-grey mt-10 line-8"), "塞拉利昂共和国总统 比奥：中国在不长的时间内取得了巨大的发展成就，发展不仅需要领导人提出规划，还需要人民的共同努力。习近平主席非常专注，习主席知道应为中国人民带来什么，他不受外界噪音的干扰，明确了发展愿景，赢得了中国人民的拥护，取得了卓越成效。")
                        );
                    }
                    ), "_" to 1), 8, utsArrayOf(
                        "show"
                    ))
                ));
            }
            ;
        }
        ;
        val styles: Map<String, Map<String, Map<String, Any>>>
            get() {
                return normalizeCssStyles(utsArrayOf());
            }
        var inheritAttrs = true;
        var inject: Map<String, Map<String, Any?>> = utsMapOf();
        var emits: Map<String, Any?> = utsMapOf();
        var props = normalizePropsOptions(utsMapOf());
        var propsNeedCastKeys: UTSArray<String> = utsArrayOf();
        var components: Map<String, CreateVueComponent> = utsMapOf();
    }
}
