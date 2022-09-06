package com.ruoyi.novel.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.novel.mapper.AiBookMapper;
import com.ruoyi.novel.domain.AiBook;
import com.ruoyi.novel.service.IAiBookService;
import com.ruoyi.common.core.text.Convert;

/**
 * 书名Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-08-23
 */
@Service
public class AiBookServiceImpl implements IAiBookService
{
    @Autowired
    private AiBookMapper aiBookMapper;

    /**
     * 查询书名
     * 
     * @param bookId 书名主键
     * @return 书名
     */
    @Override
    public AiBook selectAiBookByBookId(String bookId)
    {
        return aiBookMapper.selectAiBookByBookId(bookId);
    }

    /**
     * 查询书名列表
     * 
     * @param aiBook 书名
     * @return 书名
     */
    @Override
    public List<AiBook> selectAiBookList(AiBook aiBook)
    {
        return aiBookMapper.selectAiBookList(aiBook);
    }

    /**
     * 新增书名
     * 
     * @param aiBook 书名
     * @return 结果
     */
    @Override
    public int insertAiBook(AiBook aiBook)
    {
        aiBook.setCreateTime(DateUtils.getNowDate());
        return aiBookMapper.insertAiBook(aiBook);
    }

    /**
     * 修改书名
     * 
     * @param aiBook 书名
     * @return 结果
     */
    @Override
    public int updateAiBook(AiBook aiBook)
    {
        return aiBookMapper.updateAiBook(aiBook);
    }

    /**
     * 批量删除书名
     * 
     * @param bookIds 需要删除的书名主键
     * @return 结果
     */
    @Override
    public int deleteAiBookByBookIds(String bookIds)
    {
        return aiBookMapper.deleteAiBookByBookIds(Convert.toStrArray(bookIds));
    }

    /**
     * 删除书名信息
     * 
     * @param bookId 书名主键
     * @return 结果
     */
    @Override
    public int deleteAiBookByBookId(String bookId)
    {
        return aiBookMapper.deleteAiBookByBookId(bookId);
    }



    @Override
    public List<AiBook> selectAiBookByAutId(String autId)
    {

        return aiBookMapper.selectAiBookByAutId(autId);
    }

    @Override
    public List<AiBook> selectAiBookByBookName(String searchBook)
    {
        return aiBookMapper.selectAiBookByBookName(searchBook);
    }
}
