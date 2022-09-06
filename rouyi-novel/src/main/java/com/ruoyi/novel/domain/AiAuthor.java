package com.ruoyi.novel.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 作者对象 ai_author
 * 
 * @author ruoyi
 * @date 2022-08-22
 */
public class AiAuthor extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 作者表主键 */
    private String autId;

    /** 关联用户表 */
    @Excel(name = "关联用户表")
    private String userId;

    /** 作者登录密码 */
    @Excel(name = "作者登录密码")
    private String password;

    /** 加密盐 */
    @Excel(name = "加密盐")
    private String salt;

    /** 笔名 */
    @Excel(name = "笔名")
    private String autName;

    /** 手机号 */
    @Excel(name = "手机号")
    private String phone;

    /** QQ */
    @Excel(name = "QQ")
    private String qq;

    /** 邮箱 */
    @Excel(name = "邮箱")
    private String email;

    /** 作者头像 */
    @Excel(name = "作者头像")
    private String autPic;

    /** 修改时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "修改时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date updataTime;

    /** 删除标识 */
    @Excel(name = "删除标识")
    private String deleteFlage;

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

    /** 作者等级 */
    @Excel(name = "作者等级")
    private String level;

    /** 是否签约 */
    @Excel(name = "是否签约")
    private String signed;

    public void setAutId(String autId) 
    {
        this.autId = autId;
    }

    public String getAutId() 
    {
        return autId;
    }
    public void setUserId(String userId) 
    {
        this.userId = userId;
    }

    public String getUserId() 
    {
        return userId;
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
    public void setAutName(String autName) 
    {
        this.autName = autName;
    }

    public String getAutName() 
    {
        return autName;
    }
    public void setPhone(String phone) 
    {
        this.phone = phone;
    }

    public String getPhone() 
    {
        return phone;
    }
    public void setQq(String qq) 
    {
        this.qq = qq;
    }

    public String getQq() 
    {
        return qq;
    }
    public void setEmail(String email) 
    {
        this.email = email;
    }

    public String getEmail() 
    {
        return email;
    }
    public void setAutPic(String autPic) 
    {
        this.autPic = autPic;
    }

    public String getAutPic() 
    {
        return autPic;
    }
    public void setUpdataTime(Date updataTime) 
    {
        this.updataTime = updataTime;
    }

    public Date getUpdataTime() 
    {
        return updataTime;
    }
    public void setDeleteFlage(String deleteFlage) 
    {
        this.deleteFlage = deleteFlage;
    }

    public String getDeleteFlage() 
    {
        return deleteFlage;
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
    public void setLevel(String level) 
    {
        this.level = level;
    }

    public String getLevel() 
    {
        return level;
    }
    public void setSigned(String signed) 
    {
        this.signed = signed;
    }

    public String getSigned() 
    {
        return signed;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("autId", getAutId())
            .append("userId", getUserId())
            .append("password", getPassword())
            .append("salt", getSalt())
            .append("autName", getAutName())
            .append("phone", getPhone())
            .append("qq", getQq())
            .append("email", getEmail())
            .append("autPic", getAutPic())
            .append("createTime", getCreateTime())
            .append("updataTime", getUpdataTime())
            .append("deleteFlage", getDeleteFlage())
            .append("field1", getField1())
            .append("field2", getField2())
            .append("field3", getField3())
            .append("field4", getField4())
            .append("field5", getField5())
            .append("level", getLevel())
            .append("signed", getSigned())
            .append("remark", getRemark())
            .toString();
    }
}
