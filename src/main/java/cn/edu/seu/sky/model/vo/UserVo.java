package cn.edu.seu.sky.model.vo;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author xiaotian on 2022/5/11
 */
@Data
@Builder
public class UserVo implements Serializable {

    private static final long serialVersionUID = 3207341392594456144L;

    private Long id;

    private String account;

    private String nickName;

    private Integer age;

    private String telephone;

    private String email;

    private Integer status;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;
}
