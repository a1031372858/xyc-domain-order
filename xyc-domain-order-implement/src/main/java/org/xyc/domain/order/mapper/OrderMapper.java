package org.xyc.domain.order.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.xyc.domain.order.model.po.OrderPO;

/**
 * @author xuyachang
 * @date 2023/12/29
 */

@Mapper
public interface OrderMapper extends BaseMapper<OrderPO> {

}
