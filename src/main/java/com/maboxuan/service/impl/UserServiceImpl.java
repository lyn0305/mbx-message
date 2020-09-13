package com.maboxuan.service.impl;


import com.maboxuan.entities.*;
import com.maboxuan.mapper.MbxUserMapper;
import com.maboxuan.mapper.MessageMapper;
import com.maboxuan.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by xiaour.github.com on 2017/11/8.
 */
@Service
public class UserServiceImpl implements UserService {


    @Resource
    private MbxUserMapper mbxUserMapper;

    @Resource
    private MessageMapper messageMapper;
    @Override
    public CommonResult login(MbxUser mbxUser) {

        CommonResult commonResult = new CommonResult();

        String userName = mbxUser.getUserName();
        if (!userName.isEmpty()) {
            MbxUserExample mbxUserExample = new MbxUserExample();
            MbxUserExample.Criteria criteria = mbxUserExample.createCriteria().andUserNameEqualTo(userName);
            List<MbxUser> mbxUsers = mbxUserMapper.selectByExample(mbxUserExample);
            if (!CollectionUtils.isEmpty(mbxUsers)) {
                if (mbxUser.getPassword().equals(mbxUsers.get(0).getPassword())) {

                    commonResult.setMessage("登陆成功");
                    return commonResult;
                }
                commonResult.setMessage("用户密码错误");
                return commonResult;
            }
        }
        commonResult.setMessage("用户不存在！");
        return commonResult;

    }

    @Override
    public CommonResult register(MbxUser mbxUser) {
        CommonResult commonResult = new CommonResult();
        MbxUserExample mbxUserExample = new MbxUserExample();
        MbxUserExample.Criteria criteria = mbxUserExample.createCriteria().andUserNameEqualTo(mbxUser.getUserName());
        List<MbxUser> mbxUsers = mbxUserMapper.selectByExample(mbxUserExample);
        if(!CollectionUtils.isEmpty(mbxUsers)){
            commonResult.setMessage("用户已存在");
        }
        int insert = mbxUserMapper.insert(mbxUser);
        commonResult.setMessage("注册成功");
        return commonResult;
    }

    @Override
    public CommonResult addMessage(Message message) {
        CommonResult commonResult = new CommonResult();
        int insert = messageMapper.insert(message);
        if(insert >0){
            commonResult.setCode(200);
            return commonResult;
        }
        commonResult.setCode(500);
        return commonResult;
    }

    @Override
    public CommonResult getAllMessage() {
        CommonResult commonResult = new CommonResult();

        MessageExample messageExample = new MessageExample();
        List<Message> allMessage = messageMapper.selectByExample(messageExample);
        commonResult.setData(allMessage);
        return commonResult;
    }

}
