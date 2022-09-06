package com.ruoyi.novel.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 评论对象 ai_forum
 * 
 * @author ruoyi
 * @date 2022-09-02
 */
public class AiForum extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 评论主键 */
    private String forumId;

    /** 用户Id */
    @Excel(name = "用户Id")
    private String userId;

    /** 评论用户名 */
    @Excel(name = "评论用户名")
    private String realName;

    /** 评论用户头像 */
    @Excel(name = "评论用户头像")
    private String userPic;

    /** 评论书Id */
    @Excel(name = "评论书Id")
    private String bookId;

    /** 评论章节Id */
    @Excel(name = "评论章节Id")
    private String chapterId;

    /** 修改时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "修改时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date updataTime;

    /** 删除标识 */
    @Excel(name = "删除标识")
    private String deleteFlage;

    /** 用户等级 */
    @Excel(name = "用户等级")
    private String level;

    /** 评论标题 */
    @Excel(name = "评论标题")
    private String forumTitle;

    /** 评论内容 */
    @Excel(name = "评论内容")
    private String comment;

    /** 点赞数 */
    @Excel(name = "点赞数")
    private String praise;

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

    /** 章节名称 */
    @Excel(name = "章节名称")
    private String chapterName;

    public void setForumId(String forumId) 
    {
        this.forumId = forumId;
    }

    public String getForumId() 
    {
        return forumId;
    }
    public void setUserId(String userId) 
    {
        this.userId = userId;
    }

    public String getUserId() 
    {
        return userId;
    }
    public void setRealName(String realName) 
    {
        this.realName = realName;
    }

    public String getRealName() 
    {
        return realName;
    }
    public void setUserPic(String userPic) 
    {
        this.userPic = userPic;
    }

    public String getUserPic() 
    {
        return userPic;
    }
    public void setBookId(String bookId) 
    {
        this.bookId = bookId;
    }

    public String getBookId() 
    {
        return bookId;
    }
    public void setChapterId(String chapterId) 
    {
        this.chapterId = chapterId;
    }

    public String getChapterId() 
    {
        return chapterId;
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
    public void setLevel(String level) 
    {
        this.level = level;
    }

    public String getLevel() 
    {
        return level;
    }
    public void setForumTitle(String forumTitle) 
    {
        this.forumTitle = forumTitle;
    }

    public String getForumTitle() 
    {
        return forumTitle;
    }
    public void setComment(String comment) 
    {
        this.comment = comment;
    }

    public String getComment() 
    {
        return comment;
    }
    public void setPraise(String praise) 
    {
        this.praise = praise;
    }

    public String getPraise() 
    {
        return praise;
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
    public void setChapterName(String chapterName) 
    {
        this.chapterName = chapterName;
    }

    public String getChapterName() 
    {
        return chapterName;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("forumId", getForumId())
            .append("userId", getUserId())
            .append("realName", getRealName())
            .append("userPic", getUserPic())
            .append("bookId", getBookId())
            .append("chapterId", getChapterId())
            .append("createTime", getCreateTime())
            .append("updataTime", getUpdataTime())
            .append("deleteFlage", getDeleteFlage())
            .append("level", getLevel())
            .append("forumTitle", getForumTitle())
            .append("comment", getComment())
            .append("praise", getPraise())
            .append("field1", getField1())
            .append("field2", getField2())
            .append("field3", getField3())
            .append("field4", getField4())
            .append("field5", getField5())
            .append("chapterName", getChapterName())
            .toString();
    }
}
