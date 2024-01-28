package org.xyc.domain.order.util;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.TemplateType;

/**
 * @author xuyachang
 * @date 2024/1/16
 */
public class MybatisPlusAutoGeneratorUtil {

    public static void execute(){
        DataSourceConfig.Builder config = new DataSourceConfig.Builder(
                "jdbc:postgresql://47.94.163.139:5432/xyc_mall",
                "postgres",
                "postgres");
        FastAutoGenerator.create(config)
                .globalConfig((scanner,builder)  -> {
                    builder.author("xuyachang")
                            .commentDate("yyyy-MM-dd")
                            .outputDir("D:\\workspace\\private\\xyc-domain-order\\xyc-domain-order-implement\\src\\main\\java");
                })
                .packageConfig((scanner,builder) -> {
                    builder.parent("org.xyc.domain.order");
                        })
                .strategyConfig((scanner,builder)  -> {
                    // 设置需要生成的表名
                    builder.addInclude("order_p_o");
                })
                .templateConfig((scanner,builder)->{
                    builder.disable(TemplateType.CONTROLLER);
                })
                .execute();
    }

    public static void main(String[] args) {
        MybatisPlusAutoGeneratorUtil.execute();
    }
}
