package org.kirin.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * @TableName payment
 */
@TableName(value ="payment")
@Data
public class Payment implements Serializable {
    @TableId(type = IdType.AUTO)
    private Long id;

    private String serial;

    private static final long serialVersionUID = 1L;
}