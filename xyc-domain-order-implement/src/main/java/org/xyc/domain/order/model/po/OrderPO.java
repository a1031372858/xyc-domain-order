package org.xyc.domain.order.model.po;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

/**
 * @author xuyachang
 * @date 2023/12/29
 */
@Data
public class OrderPO extends Model<OrderPO> {
    private Long id;
    private String orderCode;
    private Integer orderStatus;
    private String buyerName;
    private String buyerMobile;
    private Long shopId;
}
