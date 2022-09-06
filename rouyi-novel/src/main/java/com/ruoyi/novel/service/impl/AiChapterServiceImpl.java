package com.ruoyi.novel.service.impl;

import java.util.List;
import java.util.Map;

import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.novel.mapper.AiChapterMapper;
import com.ruoyi.novel.domain.AiChapter;
import com.ruoyi.novel.service.IAiChapterService;
import com.ruoyi.common.core.text.Convert;

/**
 * 章节Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-08-25
 */
@Service
public class AiChapterServiceImpl implements IAiChapterService 
{
    @Autowired
    private AiChapterMapper aiChapterMapper;

    /**
     * 查询章节
     * 
     * @param chapterId 章节主键
     * @return 章节
     */
    @Override
    public AiChapter selectAiChapterByChapterId(String chapterId)
    {
        return aiChapterMapper.selectAiChapterByChapterId(chapterId);
    }

    /**
     * 查询章节列表
     * 
     * @param aiChapter 章节
     * @return 章节
     */
    @Override
    public List<AiChapter> selectAiChapterList(AiChapter aiChapter)
    {
        return aiChapterMapper.selectAiChapterList(aiChapter);
    }

    /**
     * 新增章节
     * 
     * @param aiChapter 章节
     * @return 结果
     */
    @Override
    public int insertAiChapter(AiChapter aiChapter)
    {
        aiChapter.setCreateTime(DateUtils.getNowDate());
        return aiChapterMapper.insertAiChapter(aiChapter);
    }

    /**
     * 修改章节
     * 
     * @param aiChapter 章节
     * @return 结果
     */
    @Override
    public int updateAiChapter(AiChapter aiChapter)
    {
        aiChapter.setUpdateTime(DateUtils.getNowDate());
        return aiChapterMapper.updateAiChapter(aiChapter);
    }

    /**
     * 批量删除章节
     * 
     * @param chapterIds 需要删除的章节主键
     * @return 结果
     */
    @Override
    public int deleteAiChapterByChapterIds(String chapterIds)
    {
        return aiChapterMapper.deleteAiChapterByChapterIds(Convert.toStrArray(chapterIds));
    }

    /**
     * 删除章节信息
     * 
     * @param chapterId 章节主键
     * @return 结果
     */
    @Override
    public int deleteAiChapterByChapterId(String chapterId)
    {
        return aiChapterMapper.deleteAiChapterByChapterId(chapterId);
    }



    @Override
    public List<AiChapter> selectAiChapterByBookId(String bookId)
    {
        return aiChapterMapper.selectAiChapterByBookId(bookId);
    }

    @Override
    public List<AiChapter> selectAiChapterNumByBookId(String bookId) {
        return aiChapterMapper.selectAiChapterNumByBookId(bookId);
    }

    @Override
    public AiChapter queryChapterByBookId(Map map) {
        return aiChapterMapper.queryChapterByBookId(map);
    }

   // 查询章节总数量
    @Override
    public int getCount(String bookId) {
        return aiChapterMapper.getCount(bookId);
    }


}
