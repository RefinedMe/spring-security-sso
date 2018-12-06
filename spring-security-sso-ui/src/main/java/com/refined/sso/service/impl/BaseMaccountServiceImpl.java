package com.refined.sso.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.refined.sso.entity.BaseMaccount;
import com.refined.sso.mapper.BaseMaccountMapper;
import com.refined.sso.service.BaseMaccountService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * 用户表
 *
 * @author zhang
 * @create 2018-11-06 12:10
 **/
@Service
@AllArgsConstructor
public class BaseMaccountServiceImpl extends ServiceImpl<BaseMaccountMapper, BaseMaccount> implements BaseMaccountService {


    @Override
    public BaseMaccount findUserInfo(String username) {
        //SysUser condition = new SysUser();
        BaseMaccount condition = new BaseMaccount();
        condition.setMaMobile(username);
        //SysUser sysUser = this.getOne(new QueryWrapper<>(condition));
        BaseMaccount baseMaccount = this.getOne(new QueryWrapper<>(condition));
        if (baseMaccount == null) {
            return null;
        }
        return baseMaccount;
    }
}
