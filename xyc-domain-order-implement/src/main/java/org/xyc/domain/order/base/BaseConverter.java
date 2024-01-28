package org.xyc.domain.order.base;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author xuyachang
 * @date 2024/1/4
 */
public abstract class BaseConverter<TO,PO> {
    public abstract TO convertT(PO po);
    public abstract PO convertP(TO to);

    public TO po2to(PO po){
        return this.convertT(po);
    }

    public PO to2po(TO to){
        return this.convertP(to);
    }

    public List<TO> poList2TOList(List<PO> poList){
        return poList.stream().map(this::convertT).collect(Collectors.toList());
    }

    public List<PO> toList2POList(List<TO> toList){
        return toList.stream().map(this::convertP).collect(Collectors.toList());
    }
}
