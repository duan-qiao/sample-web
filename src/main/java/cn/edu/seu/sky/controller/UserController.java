package cn.edu.seu.sky.controller;

import cn.edu.seu.sky.manage.UserManage;
import cn.edu.seu.sky.model.req.UserReq;
import cn.edu.seu.sky.model.vo.UserVo;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

/**
 * @author xiaotian on 2022/5/11
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserManage userManage;

    @PostMapping
    public void save(@RequestBody UserVo userVo) {
        userManage.save(userVo);
    }

    @PutMapping
    public void update(@RequestBody UserVo userVo) {
        userManage.update(userVo);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        userManage.delete(id);
    }

    @PostMapping("query")
    public List<UserVo> query(@RequestBody @Valid UserReq req) {
        return userManage.query(req);
    }

    @GetMapping("/users")
    public List<UserVo> queryAll() {
        return userManage.queryAll();
    }

    @GetMapping("/{id}")
    public UserVo queryById(@PathVariable Long id) {
        return userManage.queryById(id);
    }
}
