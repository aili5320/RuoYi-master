package com.ruoyi.novel.service;

import java.util.List;
import com.ruoyi.novel.domain.AiAuthor;

/**
 * 作者Service接口
 * 
 * @author ruoyi
 * @date 2022-08-22
 */
public interface IAiAuthorService 
{
    /**
     * 查询作者
     * 
     * @param autId 作者主键
     * @return 作者
     */
    public AiAuthor selectAiAuthorByAutId(String autId);

    /**
     * 查询作者列表
     * 
     * @param aiAuthor 作者
     * @return 作者集合
     */
    public List<AiAuthor> selectAiAuthorList(AiAuthor aiAuthor);

    /**
     * 新增作者
     * 
     * @param aiAuthor 作者
     * @return 结果
     */
    public int insertAiAuthor(AiAuthor aiAuthor);

    /**
     * 修改作者
     * 
     * @param aiAuthor 作者
     * @return 结果
     */
    public int updateAiAuthor(AiAuthor aiAuthor);

    /**
     * 批量删除作者
     * 
     * @param autIds 需要删除的作者主键集合
     * @return 结果
     */
    public int deleteAiAuthorByAutIds(String autIds);

    /**
     * 删除作者信息
     * 
     * @param autId 作者主键
     * @return 结果
     */
    public int deleteAiAuthorByAutId(String autId);

    AiAuthor selectAiAuthorByPass(String newPass);
}
