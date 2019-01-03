package com.yatop.lambda.workflow.core.richmodel.workflow.node;

import com.yatop.lambda.base.model.WfFlowNodeLink;
import com.yatop.lambda.core.enums.IsWebLinkEnum;
import com.yatop.lambda.workflow.core.richmodel.IRichModel;

public class NodeLink extends WfFlowNodeLink implements IRichModel, Comparable<NodeLink> {

    private boolean override;       //用于作业执行时辅助解析工作流有效的任务内容
    private boolean deleted;

    public NodeLink(WfFlowNodeLink data) {
        super.copyProperties(data);
        this.override = false;
        this.deleted = false;
        this.clearColoured();
    }

    @Override
    public void clear() {
        super.clear();
    }

    @Override
    public int compareTo(NodeLink o) {
        return this.getLinkId().compareTo(o.getLinkId());
    }

    public boolean isOverride() {
        return override;
    }

    public void setOverride(boolean override) {
        this.override = override;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void markDeleted() {
        this.deleted = true;
    }

    public boolean isWebLink() {
        return this.getIsWebLink() == IsWebLinkEnum.YES.getMark();
    }
}
