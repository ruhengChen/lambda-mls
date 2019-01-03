package com.yatop.lambda.workflow.core.richmodel.workflow.module;

import com.google.common.collect.TreeMultimap;
import com.yatop.lambda.base.model.WfModuleCatalog;
import com.yatop.lambda.core.utils.DataUtil;
import com.yatop.lambda.workflow.core.richmodel.IRichModel;
import com.yatop.lambda.workflow.core.utils.CollectionUtil;

import java.util.List;

public class ModuleCatalog extends WfModuleCatalog implements Comparable<ModuleCatalog>, IRichModel {

    private TreeMultimap<Integer, ModuleCatalog> childCatalogs = TreeMultimap.create();     //下级目录按序号排序
    private TreeMultimap<Integer, Module> childModules = TreeMultimap.create();     //工作流组件按序号排序

    public ModuleCatalog(WfModuleCatalog data) {
        super.copyProperties(data);
        this.clearColoured();
    }

    public int childCatalogCount() {
        return childCatalogs.size();
    }

    public List<ModuleCatalog> getChildCatalogs() {
        return CollectionUtil.toList(childCatalogs);
    }

    public void putChildCatalog(ModuleCatalog catalog) {
        if(DataUtil.isNull(catalog))
            return;
        this.childCatalogs.put(catalog.getSequence(), catalog);
    }

    public int childModuleCount() {
        return childModules.size();
    }

    public List<Module> getChildModules() {
        return CollectionUtil.toList(childModules);
    }

    public void putChildModule(Module module) {
        if(DataUtil.isNull(module))
            return;
        this.childModules.put(module.getSequence(), module);
    }

    @Override
    public int compareTo(ModuleCatalog o) {
        return this.getCatalogId().compareTo(o.getCatalogId());
    }

    @Override
    public void clear() {
        childCatalogs.clear();
        childModules.clear();
        super.clear();
    }
}
