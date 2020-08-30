package com.maboxuan.service;


import com.maboxuan.entities.CommonResult;
import com.maboxuan.entities.MbxUser;

/**
 * Created by maboxuan
 */

public interface UserService {

    CommonResult login(MbxUser mbxUser);
}
