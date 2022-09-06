package com.ruoyi.novel.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 章节对象 ai_chapter
 * 
 * @author ruoyi
 * @date 2022-08-26
 */
public class AiChapter extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 章节Id */
    private String chapterId;

    /** 小说id */
    @Excel(name = "小说id")
    private String bookId;

    /** 书名 */
    @Excel(name = "书名")
    private String bookName;

    /** 章节名称 */
    @Excel(name = "章节名称")
    private String chapterName;

    /** 章节内容 */
    @Excel(name = "章节内容")
    private String content;

    /** 作者寄语 */
    @Excel(name = "作者寄语")
    private String sendWord;

    /** 删除标识 */
    @Excel(name = "删除标识")
    private String isDelete;

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

    /** 章节字数 */
    @Excel(name = "章节字数")
    private Long chapterNum;

    public void setChapterId(String chapterId) 
    {
        this.chapterId = chapterId;
    }

    public String getChapterId() 
    {
        return chapterId;
    }
    public void setBookId(String bookId) 
    {
        this.bookId = bookId;
    }

    public String getBookId() 
    {
        return bookId;
    }
    public void setBookName(String bookName) 
    {
        this.bookName = bookName;
    }

    public String getBookName() 
    {
        return bookName;
    }
    public void setChapterName(String chapterName) 
    {
        this.chapterName = chapterName;
    }

    public String getChapterName() 
    {
        return chapterName;
    }
    public void setContent(String content) 
    {
        this.content = content;
    }

    public String getContent() 
    {
        return content;
    }
    public void setSendWord(String sendWord) 
    {
        this.sendWord = sendWord;
    }

    public String getSendWord() 
    {
        return sendWord;
    }
    public void setIsDelete(String isDelete) 
    {
        this.isDelete = isDelete;
    }

    public String getIsDelete() 
    {
        return isDelete;
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
    public void setChapterNum(Long chapterNum) 
    {
        this.chapterNum = chapterNum;
    }

    public Long getChapterNum() 
    {
        return chapterNum;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("chapterId", getChapterId())
            .append("bookId", getBookId())
            .append("bookName", getBookName())
            .append("chapterName", getChapterName())
            .append("content", getContent())
            .append("sendWord", getSendWord())
            .append("createTime", getCreateTime())
            .append("isDelete", getIsDelete())
            .append("remark", getRemark())
            .append("field1", getField1())
            .append("field2", getField2())
            .append("field3", getField3())
            .append("field4", getField4())
            .append("field5", getField5())
            .append("updateTime", getUpdateTime())
            .append("chapterNum", getChapterNum())
            .toString();
    }
}
