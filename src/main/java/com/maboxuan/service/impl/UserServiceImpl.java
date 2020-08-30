package com.maboxuan.service.impl;


import com.maboxuan.entities.CommonResult;
import com.maboxuan.entities.MbxUser;
import com.maboxuan.entities.MbxUserExample;
import com.maboxuan.mapper.MbxUserMapper;
import com.maboxuan.service.UserService;
import com.mysql.jdbc.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.jws.WebService;
import java.util.List;

/**
 * Created by xiaour.github.com on 2017/11/8.
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class UserServiceImpl implements UserService {


    @Resource
    private MbxUserMapper mbxUserMapper;


    @Override
    public CommonResult login(MbxUser mbxUser) {

        CommonResult commonResult = new CommonResult();

        String userName = mbxUser.getUserName();
        if (StringUtils.isNullOrEmpty(userName)) {
            MbxUserExample mbxUserExample = new MbxUserExample();
            MbxUserExample.Criteria criteria = mbxUserExample.createCriteria().andUserNameEqualTo(userName);
            List<MbxUser> mbxUsers = mbxUserMapper.selectByExample(mbxUserExample);
            if (mbxUsers != null && mbxUsers.get(0) != null) {
                if (mbxUser.getPassword().equals(mbxUsers.get(0).getPassword())) {

                    commonResult.setCode(200);
                    return commonResult;
                }
                commonResult.setCode(201);
                return commonResult;
            }
        }
        commonResult.setCode(202);
        return commonResult;

    }

}
