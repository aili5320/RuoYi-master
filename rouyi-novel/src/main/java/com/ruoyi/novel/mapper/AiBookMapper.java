package com.ruoyi.novel.mapper;

import java.util.List;
import com.ruoyi.novel.domain.AiBook;

/**
 * 书名Mapper接口
 * 
 * @author ruoyi
 * @date 2022-08-23
 */
public interface AiBookMapper 
{
    /**
     * 查询书名
     * 
     * @param bookId 书名主键
     * @return 书名
     */
    public AiBook selectAiBookByBookId(String bookId);

    /**
     * 查询书名列表
     * 
     * @param aiBook 书名
     * @return 书名集合
     */
    public List<AiBook> selectAiBookList(AiBook aiBook);

    /**
     * 新增书名
     * 
     * @param aiBook 书名
     * @return 结果
     */
    public int insertAiBook(AiBook aiBook);

    /**
     * 修改书名
     * 
     * @param aiBook 书名
     * @return 结果
     */
    public int updateAiBook(AiBook aiBook);

    /**
     * 删除书名
     * 
     * @param bookId 书名主键
     * @return 结果
     */
    public int deleteAiBookByBookId(String bookId);

    /**
     * 批量删除书名
     * 
     * @param bookIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteAiBookByBookIds(String[] bookIds);

    List<AiBook> selectAiBookByAutId(String autId);

    List<AiBook> selectAiBookByBookName(String searchBook);
}
