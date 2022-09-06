package com.ruoyi.novel.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.novel.mapper.AiForumMapper;
import com.ruoyi.novel.domain.AiForum;
import com.ruoyi.novel.service.IAiForumService;
import com.ruoyi.common.core.text.Convert;

/**
 * 评论Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-09-02
 */
@Service
public class AiForumServiceImpl implements IAiForumService 
{
    @Autowired
    private AiForumMapper aiForumMapper;

    /**
     * 查询评论
     * 
     * @param forumId 评论主键
     * @return 评论
     */
    @Override
    public AiForum selectAiForumByForumId(String forumId)
    {
        return aiForumMapper.selectAiForumByForumId(forumId);
    }

    /**
     * 查询评论列表
     * 
     * @param aiForum 评论
     * @return 评论
     */
    @Override
    public List<AiForum> selectAiForumList(AiForum aiForum)
    {
        return aiForumMapper.selectAiForumList(aiForum);
    }

    /**
     * 新增评论
     * 
     * @param aiForum 评论
     * @return 结果
     */
    @Override
    public int insertAiForum(AiForum aiForum)
    {
        aiForum.setCreateTime(DateUtils.getNowDate());
        return aiForumMapper.insertAiForum(aiForum);
    }

    /**
     * 修改评论
     * 
     * @param aiForum 评论
     * @return 结果
     */
    @Override
    public int updateAiForum(AiForum aiForum)
    {
        return aiForumMapper.updateAiForum(aiForum);
    }

    /**
     * 批量删除评论
     * 
     * @param forumIds 需要删除的评论主键
     * @return 结果
     */
    @Override
    public int deleteAiForumByForumIds(String forumIds)
    {
        return aiForumMapper.deleteAiForumByForumIds(Convert.toStrArray(forumIds));
    }

    /**
     * 删除评论信息
     * 
     * @param forumId 评论主键
     * @return 结果
     */
    @Override
    public int deleteAiForumByForumId(String forumId)
    {
        return aiForumMapper.deleteAiForumByForumId(forumId);
    }

    @Override
    public List<AiForum> selectAiForumByChapterId(String chapterId) {
        return aiForumMapper.selectAiForumByChapterId(chapterId);
    }

    @Override
    public List<AiForum> queryForumByBookId(String bookId) {
        return aiForumMapper.queryForumByBookId(bookId);
    }

    @Override
    public List<AiForum> queryForumByUserId(String userId) {
        return aiForumMapper.queryForumByUserId(userId);
    }
}
