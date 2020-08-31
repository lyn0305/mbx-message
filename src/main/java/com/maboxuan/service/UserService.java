package com.maboxuan.service;


import com.maboxuan.entities.CommonResult;
import com.maboxuan.entities.MbxUser;
import com.maboxuan.entities.Message;

import java.util.List;

/**
 * Created by maboxuan
 */

public interface UserService {

    CommonResult login(MbxUser mbxUser);

    CommonResult register(MbxUser mbxUser);

    CommonResult addMessage(Message message);

    CommonResult getAllMessage();
}
