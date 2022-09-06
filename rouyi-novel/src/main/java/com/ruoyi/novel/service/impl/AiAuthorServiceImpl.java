package com.ruoyi.novel.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.novel.mapper.AiAuthorMapper;
import com.ruoyi.novel.domain.AiAuthor;
import com.ruoyi.novel.service.IAiAuthorService;
import com.ruoyi.common.core.text.Convert;

/**
 * 作者Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-08-22
 */
@Service
public class AiAuthorServiceImpl implements IAiAuthorService 
{
    @Autowired
    private AiAuthorMapper aiAuthorMapper;

    /**
     * 查询作者
     * 
     * @param autId 作者主键
     * @return 作者
     */
    @Override
    public AiAuthor selectAiAuthorByAutId(String autId)
    {
        return aiAuthorMapper.selectAiAuthorByAutId(autId);
    }

    /**
     * 查询作者列表
     * 
     * @param aiAuthor 作者
     * @return 作者
     */
    @Override
    public List<AiAuthor> selectAiAuthorList(AiAuthor aiAuthor)
    {
        return aiAuthorMapper.selectAiAuthorList(aiAuthor);
    }

    /**
     * 新增作者
     * 
     * @param aiAuthor 作者
     * @return 结果
     */
    @Override
    public int insertAiAuthor(AiAuthor aiAuthor)
    {
        aiAuthor.setCreateTime(DateUtils.getNowDate());
        return aiAuthorMapper.insertAiAuthor(aiAuthor);
    }

    /**
     * 修改作者
     * 
     * @param aiAuthor 作者
     * @return 结果
     */
    @Override
    public int updateAiAuthor(AiAuthor aiAuthor)
    {
        return aiAuthorMapper.updateAiAuthor(aiAuthor);
    }

    /**
     * 批量删除作者
     * 
     * @param autIds 需要删除的作者主键
     * @return 结果
     */
    @Override
    public int deleteAiAuthorByAutIds(String autIds)
    {
        return aiAuthorMapper.deleteAiAuthorByAutIds(Convert.toStrArray(autIds));
    }

    /**
     * 删除作者信息
     * 
     * @param autId 作者主键
     * @return 结果
     */
    @Override
    public int deleteAiAuthorByAutId(String autId)
    {
        return aiAuthorMapper.deleteAiAuthorByAutId(autId);
    }

    @Override
    public AiAuthor selectAiAuthorByPass(String newPass) {
        return aiAuthorMapper.selectAiAuthorByPass(newPass);
    }

}
