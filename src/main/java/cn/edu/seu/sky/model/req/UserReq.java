package cn.edu.seu.sky.model.req;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.Future;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author xiaotian on 2022/5/11
 */
@Data
public class UserReq implements Serializable {

    private static final long serialVersionUID = 1755248495447942747L;

    @Pattern(regexp = "^1[3456789]\\d{9}$", message = "手机号格式不正确")
    private String telephone;

    @NotBlank(message = "用户昵称不能为空")
    private String nickName;

    @Max(value = 25, message = "年龄范围必须在20到25之间")
    @Min(value = 20, message = "年龄范围必须在20到25之间")
    private Integer age;

    @Email(message = "邮箱格式不正确")
    private String email;

    @Past(message = "开始时间必须是一个过去时间")
    private LocalDateTime startTime;

    @Future(message = "结束时间必须是一个未来时间")
    private LocalDateTime endTime;
}
