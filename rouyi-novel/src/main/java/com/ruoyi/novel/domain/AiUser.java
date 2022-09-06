package com.ruoyi.novel.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 网站用户对象 ai_user
 * 
 * @author ruoyi
 * @date 2022-08-22
 */
public class AiUser extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private String userId;

    /** 作者id */
    @Excel(name = "作者id")
    private String autId;

    /** 登录名 */
    @Excel(name = "登录名")
    private String userName;

    /** 登录密码 */
    @Excel(name = "登录密码")
    private String password;

    /** 加密盐 */
    @Excel(name = "加密盐")
    private String salt;

    /** 用户姓名 */
    @Excel(name = "用户姓名")
    private String realName;

    /** 手机号码 */
    @Excel(name = "手机号码")
    private String phone;

    /** 邮箱 */
    @Excel(name = "邮箱")
    private String email;

    /** 身份证号码 */
    @Excel(name = "身份证号码")
    private String idCard;

    /** 用户头像 */
    @Excel(name = "用户头像")
    private String userPic;

    /**  */
    @Excel(name = "")
    private String field1;

    /**  */
    @Excel(name = "")
    private String field2;

    /**  */
    @Excel(name = "")
    private String field3;

    /**  */
    @Excel(name = "")
    private String field4;

    /**  */
    @Excel(name = "")
    private String field5;

    /** 修改人 */
    @Excel(name = "修改人")
    private String updateUser;

    /** 删除标识 */
    @Excel(name = "删除标识")
    private String deleteFlage;

    /** token */
    @Excel(name = "token")
    private String token;

    /** 生日 */
    @Excel(name = "生日")
    private String birthday;

    /** 性别：1男，0女 */
    @Excel(name = "性别：1男，0女")
    private String sex;

    /** 兴趣 */
    @Excel(name = "兴趣")
    private String focus;

    /** 用户IP */
    @Excel(name = "用户IP")
    private String userIp;

    /** 推送：true推送false不推送 */
    @Excel(name = "推送：true推送false不推送")
    private String delivery;

    public void setUserId(String userId) 
    {
        this.userId = userId;
    }

    public String getUserId() 
    {
        return userId;
    }
    public void setAutId(String autId) 
    {
        this.autId = autId;
    }

    public String getAutId() 
    {
        return autId;
    }
    public void setUserName(String userName) 
    {
        this.userName = userName;
    }

    public String getUserName() 
    {
        return userName;
    }
    public void setPassword(String password) 
    {
        this.password = password;
    }

    public String getPassword() 
    {
        return password;
    }
    public void setSalt(String salt) 
    {
        this.salt = salt;
    }

    public String getSalt() 
    {
        return salt;
    }
    public void setRealName(String realName) 
    {
        this.realName = realName;
    }

    public String getRealName() 
    {
        return realName;
    }
    public void setPhone(String phone) 
    {
        this.phone = phone;
    }

    public String getPhone() 
    {
        return phone;
    }
    public void setEmail(String email) 
    {
        this.email = email;
    }

    public String getEmail() 
    {
        return email;
    }
    public void setIdCard(String idCard) 
    {
        this.idCard = idCard;
    }

    public String getIdCard() 
    {
        return idCard;
    }
    public void setUserPic(String userPic) 
    {
        this.userPic = userPic;
    }

    public String getUserPic() 
    {
        return userPic;
    }
    public void setField1(String field1) 
    {
        this.field1 = field1;
    }

    public String getField1() 
    {
        return field1;
    }
    public void setField2(String field2) 
    {
        this.field2 = field2;
    }

    public String getField2() 
    {
        return field2;
    }
    public void setField3(String field3) 
    {
        this.field3 = field3;
    }

    public String getField3() 
    {
        return field3;
    }
    public void setField4(String field4) 
    {
        this.field4 = field4;
    }

    public String getField4() 
    {
        return field4;
    }
    public void setField5(String field5) 
    {
        this.field5 = field5;
    }

    public String getField5() 
    {
        return field5;
    }
    public void setUpdateUser(String updateUser) 
    {
        this.updateUser = updateUser;
    }

    public String getUpdateUser() 
    {
        return updateUser;
    }
    public void setDeleteFlage(String deleteFlage) 
    {
        this.deleteFlage = deleteFlage;
    }

    public String getDeleteFlage() 
    {
        return deleteFlage;
    }
    public void setToken(String token) 
    {
        this.token = token;
    }

    public String getToken() 
    {
        return token;
    }
    public void setBirthday(String birthday) 
    {
        this.birthday = birthday;
    }

    public String getBirthday() 
    {
        return birthday;
    }
    public void setSex(String sex) 
    {
        this.sex = sex;
    }

    public String getSex() 
    {
        return sex;
    }
    public void setFocus(String focus) 
    {
        this.focus = focus;
    }

    public String getFocus() 
    {
        return focus;
    }
    public void setUserIp(String userIp) 
    {
        this.userIp = userIp;
    }

    public String getUserIp() 
    {
        return userIp;
    }
    public void setDelivery(String delivery) 
    {
        this.delivery = delivery;
    }

    public String getDelivery() 
    {
        return delivery;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("userId", getUserId())
            .append("autId", getAutId())
            .append("userName", getUserName())
            .append("password", getPassword())
            .append("salt", getSalt())
            .append("realName", getRealName())
            .append("phone", getPhone())
            .append("email", getEmail())
            .append("idCard", getIdCard())
            .append("userPic", getUserPic())
            .append("field1", getField1())
            .append("field2", getField2())
            .append("field3", getField3())
            .append("field4", getField4())
            .append("field5", getField5())
            .append("remark", getRemark())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("updateUser", getUpdateUser())
            .append("deleteFlage", getDeleteFlage())
            .append("token", getToken())
            .append("birthday", getBirthday())
            .append("sex", getSex())
            .append("focus", getFocus())
            .append("userIp", getUserIp())
            .append("delivery", getDelivery())
            .toString();
    }
}
