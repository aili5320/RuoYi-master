package com.ruoyi.novel.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 书名对象 ai_book
 * 
 * @author ruoyi
 * @date 2022-08-26
 */
public class AiBook extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 书籍ID */
    private String bookId;

    /** 书名 */
    @Excel(name = "书名")
    private String bookName;

    /** 作者ID */
    @Excel(name = "作者ID")
    private String autId;

    /** 笔名 */
    @Excel(name = "笔名")
    private String autName;

    /** 作品首字母 */
    @Excel(name = "作品首字母")
    private String acronym;

    /** 作品类型 */
    @Excel(name = "作品类型")
    private String genre;

    /** 作品主题 */
    @Excel(name = "作品主题")
    private String theme;

    /** 关键字 */
    @Excel(name = "关键字")
    private String keyWord;

    /** 作品图片地址 */
    @Excel(name = "作品图片地址")
    private String bookPic;

    /** 简介 */
    @Excel(name = "简介")
    private String intro;

    /** 作者寄语 */
    @Excel(name = "作者寄语")
    private String wishes;

    /** 是否签订合同 */
    @Excel(name = "是否签订合同")
    private String signContract;

    /** 作品状态：0连载中，1完结， */
    @Excel(name = "作品状态：0连载中，1完结，")
    private String serial;

    /** 检验状态：0未审核，1审核完成 */
    @Excel(name = "检验状态：0未审核，1审核完成")
    private String checkout;

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

    /** 修改时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "修改时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date updataTime;

    /** 修改人 */
    @Excel(name = "修改人")
    private String updateUser;

    /** 收藏数 */
    @Excel(name = "收藏数")
    private String favorite;

    /** 点击数 */
    @Excel(name = "点击数")
    private String hit;

    /** 征文活动 */
    @Excel(name = "征文活动")
    private String collect;

    /** 作品总字数 */
    @Excel(name = "作品总字数")
    private String wordNum;

    /** 最新章节名称 */
    @Excel(name = "最新章节名称")
    private String newChapter;

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
    public void setAutId(String autId) 
    {
        this.autId = autId;
    }

    public String getAutId() 
    {
        return autId;
    }
    public void setAutName(String autName) 
    {
        this.autName = autName;
    }

    public String getAutName() 
    {
        return autName;
    }
    public void setAcronym(String acronym) 
    {
        this.acronym = acronym;
    }

    public String getAcronym() 
    {
        return acronym;
    }
    public void setGenre(String genre) 
    {
        this.genre = genre;
    }

    public String getGenre() 
    {
        return genre;
    }
    public void setTheme(String theme) 
    {
        this.theme = theme;
    }

    public String getTheme() 
    {
        return theme;
    }
    public void setKeyWord(String keyWord) 
    {
        this.keyWord = keyWord;
    }

    public String getKeyWord() 
    {
        return keyWord;
    }
    public void setBookPic(String bookPic) 
    {
        this.bookPic = bookPic;
    }

    public String getBookPic() 
    {
        return bookPic;
    }
    public void setIntro(String intro) 
    {
        this.intro = intro;
    }

    public String getIntro() 
    {
        return intro;
    }
    public void setWishes(String wishes) 
    {
        this.wishes = wishes;
    }

    public String getWishes() 
    {
        return wishes;
    }
    public void setSignContract(String signContract) 
    {
        this.signContract = signContract;
    }

    public String getSignContract() 
    {
        return signContract;
    }
    public void setSerial(String serial) 
    {
        this.serial = serial;
    }

    public String getSerial() 
    {
        return serial;
    }
    public void setCheckout(String checkout) 
    {
        this.checkout = checkout;
    }

    public String getCheckout() 
    {
        return checkout;
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
    public void setUpdataTime(Date updataTime) 
    {
        this.updataTime = updataTime;
    }

    public Date getUpdataTime() 
    {
        return updataTime;
    }
    public void setUpdateUser(String updateUser) 
    {
        this.updateUser = updateUser;
    }

    public String getUpdateUser() 
    {
        return updateUser;
    }
    public void setFavorite(String favorite) 
    {
        this.favorite = favorite;
    }

    public String getFavorite() 
    {
        return favorite;
    }
    public void setHit(String hit) 
    {
        this.hit = hit;
    }

    public String getHit() 
    {
        return hit;
    }
    public void setCollect(String collect) 
    {
        this.collect = collect;
    }

    public String getCollect() 
    {
        return collect;
    }
    public void setWordNum(String wordNum) 
    {
        this.wordNum = wordNum;
    }

    public String getWordNum() 
    {
        return wordNum;
    }
    public void setNewChapter(String newChapter) 
    {
        this.newChapter = newChapter;
    }

    public String getNewChapter() 
    {
        return newChapter;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("bookId", getBookId())
            .append("bookName", getBookName())
            .append("autId", getAutId())
            .append("autName", getAutName())
            .append("acronym", getAcronym())
            .append("genre", getGenre())
            .append("theme", getTheme())
            .append("keyWord", getKeyWord())
            .append("bookPic", getBookPic())
            .append("intro", getIntro())
            .append("wishes", getWishes())
            .append("signContract", getSignContract())
            .append("serial", getSerial())
            .append("checkout", getCheckout())
            .append("field1", getField1())
            .append("field2", getField2())
            .append("field3", getField3())
            .append("field4", getField4())
            .append("field5", getField5())
            .append("createTime", getCreateTime())
            .append("updataTime", getUpdataTime())
            .append("updateUser", getUpdateUser())
            .append("remark", getRemark())
            .append("favorite", getFavorite())
            .append("hit", getHit())
            .append("collect", getCollect())
            .append("wordNum", getWordNum())
            .append("newChapter", getNewChapter())
            .toString();
    }
}
