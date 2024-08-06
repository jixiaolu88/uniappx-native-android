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
open class GenUniModulesTmxUiComponentsXRadioGroupXRadioGroup : VueComponent {
    constructor(instance: ComponentInternalInstance) : super(instance) {
        onBeforeUnmount(fun() {
            this.isDestroy = true;
            clearTimeout(this.tid);
        }
        , instance);
        onMounted(fun() {
            this.checkvaluelist = this.modelValue;
            this.isDestroy = false;
        }
        , instance);
        this.`$watch`(fun(): Any? {
            return this.modelValue;
        }
        , fun(newValue: String) {
            if (newValue != this.checkvaluelist) {
                this.checkvaluelist = newValue;
                this.setOldCheckboxValue();
                this.pushAllChildren();
            }
        }
        );
    }
    @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
    override fun `$render`(): Any? {
        val _ctx = this;
        val _cache = this.`$`.renderCache;
        return createElementVNode("view", utsMapOf("class" to "xRadioGroup", "style" to normalizeStyle(utsMapOf("flex-direction" to _ctx.direction))), utsArrayOf(
            renderSlot(_ctx.`$slots`, "default")
        ), 4);
    }
    open var modelValue: String by `$props`;
    open var direction: String by `$props`;
    open var oldvalueList: UTSArray<XRADIO_LISTITEM_TYPE> by `$data`;
    open var checkvaluelist: String by `$data`;
    open var tid: Number by `$data`;
    open var isDestroy: Boolean by `$data`;
    open var oldvalueList_ids: UTSArray<String> by `$data`;
    @Suppress("USELESS_CAST")
    override fun data(): Map<String, Any?> {
        return utsMapOf("oldvalueList" to utsArrayOf<XRADIO_LISTITEM_TYPE>(), "checkvaluelist" to "", "tid" to 0, "isDestroy" to false, "oldvalueList_ids" to computed<UTSArray<String>>(fun(): UTSArray<String> {
            return this.oldvalueList.map(fun(el: XRADIO_LISTITEM_TYPE): String {
                return el.id;
            }
            );
        }
        ));
    }
    override fun `$initMethods`() {
        this.addItem = fun(t: GenUniModulesTmxUiComponentsXRadioXRadioComponentPublicInstance, item: RADIO_ITEM_INFO, ischange: Boolean) {
            var index = this.oldvalueList.findIndex(fun(el: XRADIO_LISTITEM_TYPE): Boolean {
                return el.id == item.id;
            }
            );
            var nowitem = item;
            var _this = this;
            this.clearAll();
            if (!ischange) {
                if (this.checkvaluelist === item.value && item.nowvalue !== item.value) {
                    nowitem.nowvalue = nowitem.value;
                } else {
                    nowitem.nowvalue = nowitem.unvalue;
                }
            }
            if (index > -1) {
                this.oldvalueList.splice(index, 1, XRADIO_LISTITEM_TYPE(ele = t, id = nowitem.id, data = nowitem));
            } else {
                this.oldvalueList.push(XRADIO_LISTITEM_TYPE(ele = t, id = nowitem.id, data = nowitem));
            }
            if (ischange) {
                var fl = this.oldvalueList.filter(fun(el: XRADIO_LISTITEM_TYPE): Boolean {
                    return el.data.nowvalue === el.data.value;
                }
                );
                this.checkvaluelist = if (fl.length == 1) {
                    fl[0].data.value;
                } else {
                    "";
                }
                ;
                this.`$emit`("update:modelValue", this.checkvaluelist);
                this.`$emit`("change", this.checkvaluelist);
            }
            clearTimeout(this.tid);
            this.tid = setTimeout(fun() {
                _this.pushAllChildren();
            }
            , 100);
        }
        ;
        this.setOldCheckboxValue = fun() {
            this.oldvalueList.forEach(fun(item: XRADIO_LISTITEM_TYPE){
                if (this.checkvaluelist == item.data.value) {
                    item.data.nowvalue = item.data.value;
                } else {
                    item.data.nowvalue = item.data.unvalue;
                }
            }
            );
        }
        ;
        this.clearAll = fun() {
            this.oldvalueList.forEach(fun(item: XRADIO_LISTITEM_TYPE){
                item.data.nowvalue = item.data.unvalue;
            }
            );
        }
        ;
        this.pushAllChildren = fun() {
            if (this.isDestroy) {
                return;
            }
            try {
                this.oldvalueList.forEach(fun(el: XRADIO_LISTITEM_TYPE){
                    el.ele.setSelected(this.checkvaluelist);
                }
                );
            }
             catch (e: Throwable) {}
        }
        ;
    }
    open lateinit var addItem: (t: GenUniModulesTmxUiComponentsXRadioXRadioComponentPublicInstance, item: RADIO_ITEM_INFO, ischange: Boolean) -> Unit;
    open lateinit var setOldCheckboxValue: () -> Unit;
    open lateinit var clearAll: () -> Unit;
    open lateinit var pushAllChildren: () -> Unit;
    companion object {
        val styles: Map<String, Map<String, Map<String, Any>>>
            get() {
                return normalizeCssStyles(utsArrayOf(
                    styles0
                ));
            }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return utsMapOf("xRadioGroup" to padStyleMapOf(utsMapOf("display" to "flex", "flexWrap" to "wrap")));
            }
        var inheritAttrs = true;
        var inject: Map<String, Map<String, Any?>> = utsMapOf();
        var emits: Map<String, Any?> = utsMapOf("change" to null, "update:modelValue" to null);
        var props = normalizePropsOptions(utsMapOf("modelValue" to utsMapOf("type" to "String", "default" to ""), "direction" to utsMapOf("type" to "String", "default" to "row")));
        var propsNeedCastKeys = utsArrayOf(
            "modelValue",
            "direction"
        );
        var components: Map<String, CreateVueComponent> = utsMapOf();
    }
}
