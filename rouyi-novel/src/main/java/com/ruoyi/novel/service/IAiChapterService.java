package com.ruoyi.novel.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ruoyi.novel.domain.AiChapter;

/**
 * 章节Service接口
 * 
 * @author ruoyi
 * @date 2022-08-25
 */
public interface IAiChapterService 
{
    /**
     * 查询章节
     * 
     * @param chapterId 章节主键
     * @return 章节
     */
    public AiChapter selectAiChapterByChapterId(String chapterId);

    /**
     * 查询章节列表
     * 
     * @param aiChapter 章节
     * @return 章节集合
     */
    public List<AiChapter> selectAiChapterList(AiChapter aiChapter);

    /**
     * 新增章节
     * 
     * @param aiChapter 章节
     * @return 结果
     */
    public int insertAiChapter(AiChapter aiChapter);

    /**
     * 修改章节
     * 
     * @param aiChapter 章节
     * @return 结果
     */
    public int updateAiChapter(AiChapter aiChapter);

    /**
     * 批量删除章节
     * 
     * @param chapterIds 需要删除的章节主键集合
     * @return 结果
     */
    public int deleteAiChapterByChapterIds(String chapterIds);

    /**
     * 删除章节信息
     * 
     * @param chapterId 章节主键
     * @return 结果
     */
    public int deleteAiChapterByChapterId(String chapterId);


    /**
     * 获取章节列表
     * @param bookId
     * @return
     */

    List<AiChapter>  selectAiChapterByBookId(String bookId);

    /**
     * 根据书ID返回所有章节字数
     * @param bookId
     * @return
     */
    List<AiChapter>  selectAiChapterNumByBookId(String bookId);

    AiChapter queryChapterByBookId(Map map);

    int getCount(String chapterId);
}
