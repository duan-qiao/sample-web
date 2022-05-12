package cn.edu.seu.sky.manage;

import cn.edu.seu.sky.model.req.UserReq;
import cn.edu.seu.sky.model.vo.UserVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author xiaotian on 2022/5/11
 */
@Component
public class UserManage {

    public static final Map<Long, UserVo> USER_MAP = new HashMap<>();

    public List<UserVo> queryAll() {
        return new ArrayList<>(USER_MAP.values());
    }

    public void save(UserVo userVo) {
        USER_MAP.put(userVo.getId(), userVo);
    }

    public UserVo queryById(Long id) {
        return USER_MAP.get(id);
    }

    public List<UserVo> query(UserReq req) {
        Stream<UserVo> stream = USER_MAP.values().stream();
        // 条件过滤
        if (StringUtils.isNotBlank(req.getNickName())) {
            stream = stream.filter(x -> x.getNickName().contains(req.getNickName()));
        }
        if (req.getAge() != null) {
            stream = stream.filter(x -> x.getAge().equals(req.getAge()));
        }
        if (StringUtils.isNotBlank(req.getTelephone())) {
            stream = stream.filter(x -> x.getTelephone().equals(req.getTelephone()));
        }
        if (StringUtils.isNotBlank(req.getEmail())) {
            stream = stream.filter(x -> x.getEmail().equals(req.getEmail()));
        }
        if (req.getStartTime() != null) {
            stream = stream.filter(x -> x.getCreateTime().isAfter(req.getStartTime()));
        }
        if (req.getEndTime() != null) {
            stream = stream.filter(x -> x.getCreateTime().isBefore(req.getEndTime()));
        }
        return stream.collect(Collectors.toList());
    }

    public void delete(Long id) {
        USER_MAP.remove(id);
    }

    public void update(UserVo userVo) {
        USER_MAP.put(userVo.getId(), userVo);
    }

    static {
        UserVo vo1 = UserVo.builder()
                .id(1L)
                .account("zhang.san")
                .nickName("张三")
                .age(21)
                .email("zhang.san@163.com")
                .status(1)
                .telephone("13300001111")
                .createTime(LocalDateTime.now())
                .updateTime(LocalDateTime.now())
                .build();
        USER_MAP.put(vo1.getId(), vo1);

        UserVo vo2 = UserVo.builder()
                .id(2L)
                .account("li.si")
                .nickName("李四")
                .age(22)
                .email("li.si@163.comm")
                .status(1)
                .telephone("13300002222")
                .createTime(LocalDateTime.now())
                .updateTime(LocalDateTime.now())
                .build();
        USER_MAP.put(vo2.getId(), vo2);

        UserVo vo3 = UserVo.builder()
                .id(3L)
                .account("wang.wu")
                .nickName("王五")
                .age(23)
                .email("wang.wu@163.com")
                .status(1)
                .telephone("13300003333")
                .createTime(LocalDateTime.now())
                .updateTime(LocalDateTime.now())
                .build();
        USER_MAP.put(vo3.getId(), vo3);

        UserVo vo4 = UserVo.builder()
                .id(4L)
                .account("zhao.liu")
                .nickName("赵六")
                .age(24)
                .email("zhao.liu@163.com")
                .status(1)
                .telephone("13300004444")
                .createTime(LocalDateTime.now())
                .updateTime(LocalDateTime.now())
                .build();
        USER_MAP.put(vo4.getId(), vo4);

        UserVo vo5 = UserVo.builder()
                .id(5L)
                .account("sun.qi")
                .nickName("孙七")
                .age(23)
                .email("sun.qi@163.com")
                .status(1)
                .telephone("13300005555")
                .createTime(LocalDateTime.now())
                .updateTime(LocalDateTime.now())
                .build();
        USER_MAP.put(vo5.getId(), vo5);

        UserVo vo6 = UserVo.builder()
                .id(6L)
                .account("zhou.ba")
                .nickName("周八")
                .age(21)
                .email("zhou.ba@163.com")
                .status(1)
                .telephone("13300006666")
                .createTime(LocalDateTime.now())
                .updateTime(LocalDateTime.now())
                .build();
        USER_MAP.put(vo6.getId(), vo6);

        UserVo vo7 = UserVo.builder()
                .id(7L)
                .account("wu.jiu")
                .nickName("吴九")
                .age(23)
                .email("wu.jiu@163.com")
                .status(1)
                .telephone("13300007777")
                .createTime(LocalDateTime.now())
                .updateTime(LocalDateTime.now())
                .build();
        USER_MAP.put(vo7.getId(), vo7);

        UserVo vo8 = UserVo.builder()
                .id(8L)
                .account("zheng.shi")
                .nickName("郑十")
                .age(24)
                .email("zheng.shi@163.com")
                .status(1)
                .telephone("13300008888")
                .createTime(LocalDateTime.now())
                .updateTime(LocalDateTime.now())
                .build();
        USER_MAP.put(vo8.getId(), vo8);
    }
}
