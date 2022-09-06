package com.ruoyi.novel.service;

import java.util.List;
import com.ruoyi.novel.domain.AiForum;

/**
 * 评论Service接口
 * 
 * @author ruoyi
 * @date 2022-09-02
 */
public interface IAiForumService 
{
    /**
     * 查询评论
     * 
     * @param forumId 评论主键
     * @return 评论
     */
    public AiForum selectAiForumByForumId(String forumId);

    /**
     * 查询评论列表
     * 
     * @param aiForum 评论
     * @return 评论集合
     */
    public List<AiForum> selectAiForumList(AiForum aiForum);

    /**
     * 新增评论
     * 
     * @param aiForum 评论
     * @return 结果
     */
    public int insertAiForum(AiForum aiForum);

    /**
     * 修改评论
     * 
     * @param aiForum 评论
     * @return 结果
     */
    public int updateAiForum(AiForum aiForum);

    /**
     * 批量删除评论
     * 
     * @param forumIds 需要删除的评论主键集合
     * @return 结果
     */
    public int deleteAiForumByForumIds(String forumIds);

    /**
     * 删除评论信息
     * 
     * @param forumId 评论主键
     * @return 结果
     */
    public int deleteAiForumByForumId(String forumId);

    List<AiForum> selectAiForumByChapterId(String chapterId);

    List<AiForum> queryForumByBookId(String bookId);

    List<AiForum> queryForumByUserId(String userId);
}
