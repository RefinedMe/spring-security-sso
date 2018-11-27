package com.refined.sso.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.refined.sso.entity.BaseMrole;
import com.refined.sso.mapper.BaseMroleMapper;
import com.refined.sso.service.BaseMroleService;
import lombok.AllArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 用户角色Service
 *
 * @author zhang
 * @create 2018-11-06 10:55
 **/
@Service
@AllArgsConstructor
public class BaseMroleServiceImpl extends ServiceImpl<BaseMroleMapper, BaseMrole> implements BaseMroleService {

    private final BaseMroleMapper baseMroleMapper;

    @Override
    public List<BaseMrole> findRolesByUserId(String maAid) {
        return baseMroleMapper.findRolesByUserId(maAid);
    }
}
