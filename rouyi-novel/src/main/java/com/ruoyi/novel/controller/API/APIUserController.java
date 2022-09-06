package com.ruoyi.novel.controller.API;

import com.alibaba.fastjson.JSONObject;
import com.ruoyi.common.exception.file.FileException;
import com.ruoyi.common.utils.ShiroUtils;
import com.ruoyi.framework.shiro.service.SysPasswordService;
import com.ruoyi.novel.common.IdUtils;
import com.ruoyi.novel.domain.AiAuthor;
import com.ruoyi.novel.domain.AiUser;
import com.ruoyi.novel.service.IAiAuthorService;
import com.ruoyi.novel.service.IAiUserService;
import com.ruoyi.novel.service.UploadService;
import com.ruoyi.novel.utils.DateUtil;
import com.ruoyi.novel.utils.IpAddress;
import com.ruoyi.novel.utils.MyResultMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

@RestController
@CrossOrigin
@RequestMapping("/apiUser")
public class APIUserController extends Thread {
    @Autowired
    private IAiUserService iAiUserService;
    @Autowired
    MyResultMap resultMap;
    @Autowired
    SysPasswordService encryptPassword;
    @Autowired
    IpAddress ipAddress;
    @Autowired
    DateUtil dateUtil;
    @Autowired
    private UploadService uploadService;

    @Autowired
    private IAiAuthorService iAiAuthorService;

   @RequestMapping("/loginAut")
   public Map loginAut(@RequestBody JSONObject jsonObject){

    try {
        String userId = jsonObject.getString("userId");
        AiUser aiUser = iAiUserService.selectAiUserByUserId(userId);
        AiAuthor result = iAiAuthorService.selectAiAuthorByAutId(aiUser.getAutId());
        String newPass = encryptPassword.encryptPassword(userId, jsonObject.getString("password"), result.getSalt());
        AiAuthor data  =iAiAuthorService.selectAiAuthorByPass(newPass);
        if (data!=null){
            return resultMap.resultMap("登录作者专区成功！", data, 0);
        } else {
            return resultMap.resultMap("登录作者专区失败！", null, 1);
        }
    }catch (Exception e) {
            return resultMap.resultMap("系统错误！", null, 1);
       }

   }


    /**
     * 作者注册
     * @param jsonObject
     * @return
     */
    @RequestMapping("/registerAut")
    public  Map registerAut(@RequestBody JSONObject jsonObject){
        AiAuthor aiAuthor = new AiAuthor();


        String AutName = jsonObject.getString("regName");
        aiAuthor.setAutName(AutName);
        List<AiAuthor> list =iAiAuthorService.selectAiAuthorList(aiAuthor);
        if (!list.isEmpty()){
            return resultMap.resultMap("该笔名已被占用", null, 1);
        }
        aiAuthor.setAutId(IdUtils.simpleUUID());
        aiAuthor.setUserId(jsonObject.getString("userId"));
        aiAuthor.setAutPic(jsonObject.getString("userPic"));
        aiAuthor.setQq(jsonObject.getString("qq"));
        aiAuthor.setPhone(jsonObject.getString("phone"));
        aiAuthor.setSalt(ShiroUtils.randomSalt());
        aiAuthor.setPassword(encryptPassword.encryptPassword(aiAuthor.getUserId(), jsonObject.getString("pass"), aiAuthor.getSalt()));

        try {
            int count =  iAiAuthorService.insertAiAuthor(aiAuthor);
             AiUser aiUser = new AiUser();
             aiUser.setUserId(jsonObject.getString("userId"));
             aiUser.setAutId(aiAuthor.getAutId());
           int count1 = iAiUserService.updateAiUser(aiUser);
            if (count ==1 && count1==1) {
                return resultMap.resultMap("注册作者成功！", null, 0);

            } else return resultMap.resultMap("注册失败", null, 1);
        } catch ( Exception e) {
            System.out.println(e);
            return resultMap.resultMap("系统错误！", null, 1);
        }
    }





    /**
     * 登录
     *
     * @param jsonparmes
     * @return
     */
    @RequestMapping("/login")
    public Map query(@RequestBody JSONObject jsonparmes) {
        String username = jsonparmes.getString("username");
        AiUser aiUser = iAiUserService.selectAiUserByUsername(username);
        if (aiUser == null) return resultMap.resultMap("账户不存在！", null, 1);


        String newPass = encryptPassword.encryptPassword(jsonparmes.getString("username"), jsonparmes.getString("password"), aiUser.getSalt());

        AiUser neWaiUser = iAiUserService.selectAiUserByPass(newPass);
        if (neWaiUser != null) {
            return resultMap.resultMap("登录成功！", neWaiUser, 0);
        } else {
            return resultMap.resultMap("密码错误！", null, 1);
        }
    }


    /**
     * 验证用户名是否被占用
     *
     * @param jsonObject
     * @return
     */
    @RequestMapping("/proveUsername")
    public Map proveUsername(@RequestBody JSONObject jsonObject) {
        String username = jsonObject.getString("username");
        Map data = new HashMap();
        if (username.equals("")) {
            data.put("flag", '1');
            return resultMap.resultMap("用户名不能为空哦", data, 0);
        }
        int proveCount = iAiUserService.proveUsername(username);
        if (proveCount == 0) {
            data.put("flag", '0');
            return resultMap.resultMap("可以使用该用户名呢！", data, 0);
        } else {
            data.put("flag", '1');
            return resultMap.resultMap("亲！用户名已被占用，要不要考虑换一个呢！", data, 0);
        }
    }


    /**
     * 修改密码
     *
     * @param jsonObject
     * @return
     */

    @RequestMapping("/updatePsw")
    public Map updatePsw(@RequestBody JSONObject jsonObject) {

        String userName = jsonObject.getString("userName");
        String pass = jsonObject.getString("pass");
        AiUser aiUser = iAiUserService.selectAiUserByUsername(userName);

        String oldPsw = jsonObject.getString("oldPsw");

        String basePass = encryptPassword.encryptPassword(userName, oldPsw, aiUser.getSalt());
        if (!aiUser.getPassword().equals(basePass)) {
            Map data = new HashMap();
            data.put("pswTip", '1');
            return resultMap.resultMap("原密码错误，请重新输入", null, 1);
        }
        String newPsw = encryptPassword.encryptPassword(userName, pass, aiUser.getSalt());
        aiUser.setPassword(newPsw);
        int count = iAiUserService.updateAiUser(aiUser);
        if (count == 1) return resultMap.resultMap("密码修改成功！", null, 0);
        return resultMap.resultMap("修改密码失败！", null, 1);
    }

    /**
     * 修改用户头像
     * 删除之前的头像，将新头像的URL存入
     *
     * @param jsonObject
     * @return
     */

    @RequestMapping("/updatePic")
    public Map updataPic(@RequestBody JSONObject jsonObject) {
        String oldImgURL = jsonObject.getString("oldPic");
//        Boolean flag = uploadService.deleteImg(oldImgURL);
//        if (!flag) return resultMap.resultMap("更换头像失败！", null, 1);
        AiUser user = new AiUser();
        user.setUserId(jsonObject.getString("userId"));
        user.setUserPic(jsonObject.getString("newPic"));
        int count = iAiUserService.updateAiUser(user);
        if (count != 1) {
            return resultMap.resultMap("上传头像失败！", null, 1);
        }
        AiUser data = iAiUserService.selectAiUserByUserId(jsonObject.getString("userId"));
        return resultMap.resultMap("修改头像成功！", data, 0);
    }


    /**
     * 删除用户头像文件
     *
     * @param jsonObject
     * @return
     */

    @RequestMapping("/deleteImg")
    public Map deleteImg(@RequestBody JSONObject jsonObject) {
        String imgURL = jsonObject.getString("picUrl");
        try {
            Boolean flag = uploadService.deleteImg(imgURL);
            System.out.println(flag);
            if (flag == true) return resultMap.resultMap("删除用户头像成功", null, 0);
            else return resultMap.resultMap("删除用户头像失败", null, 1);
        } catch (FileException e) {
            System.out.println(e);
            return resultMap.resultMap("系统异常，请联系管理员！", null, 1);
        }

    }

    /**
     * 注册
     *
     * @param jsonObject
     * @param request
     * @return
     */
    @RequestMapping("/register")
    public Map Register(@RequestBody JSONObject jsonObject, HttpServletRequest request) {
        try {
            String userIp = ipAddress.getIpAddress(request);

            AiUser user = new AiUser();
            user.setUserId(IdUtils.simpleUUID());
            user.setUserName(jsonObject.getString("username"));
            user.setRealName(jsonObject.getString("name"));
            user.setSalt(ShiroUtils.randomSalt());
            user.setPassword(encryptPassword.encryptPassword(jsonObject.getString("username"), jsonObject.getString("pass"), user.getSalt()));
            user.setSex(jsonObject.getString("sex"));
            user.setFocus(jsonObject.getString("type"));
            user.setUserIp(userIp);
            String dateTime = jsonObject.getString("birthday");
            user.setBirthday(dateUtil.SimpleDate(dateTime));
            user.setDelivery(jsonObject.getString("delivery"));
            user.setUserPic(jsonObject.getString("picUrl"));
            user.setEmail(jsonObject.getString("email"));
            iAiUserService.insertAiUser(user);
            return resultMap.resultMap("注册成功！", null, 0);
        } catch (Exception e) {
            return resultMap.resultMap("注册失败！", null, 1);
        }
    }


    /**
     * 用户信息修改
     *
     * @param jsonObject
     * @return
     */
    @RequestMapping("/updateUserInfo")
    public Map updateUserInfo(@RequestBody JSONObject jsonObject) {
        AiUser user = new AiUser();
        user.setUserId(jsonObject.getString("userId"));
        user.setRealName(jsonObject.getString("realName"));
        user.setSex(jsonObject.getString("sex"));
        user.setRemark(jsonObject.getString("remark"));
//        user.setUpdataTime(dateUtil.currentTime());
        String dateTime = jsonObject.getString("birthday");
        if (dateTime != null) {
            user.setBirthday(dateUtil.SimpleDate(dateTime));
        }

        String phone = jsonObject.getString("newphone");
        if (phone != null && phone.length() == 11) {
            user.setPhone(phone);
        }
        int count = iAiUserService.updateAiUser(user);
        try {
            AiUser data = iAiUserService.selectAiUserByUserId(user.getUserId());
            if (count == 1) return resultMap.resultMap("修改成功！", data, 0);
            return resultMap.resultMap("修改个人信息失败！", null, 1);
        } catch (Exception e) {
            return resultMap.resultMap("系统异常！", null, 1);
        }
    }


    @RequestMapping("/queryAutIdByAuthor")
    public Map queryAutIdByAuthor (@RequestBody JSONObject jsonObject) {
        String autId = jsonObject.getString("autId");
        AiAuthor aiAuthor = iAiAuthorService.selectAiAuthorByAutId(autId);
        return resultMap.resultMap("修改成功！", aiAuthor, 0);
    }
}




