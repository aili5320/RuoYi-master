package com.ruoyi.novel.service;

import java.util.List;
import com.ruoyi.novel.domain.AiUser;

/**
 * 网站用户Service接口
 * 
 * @author ruoyi
 * @date 2022-08-02
 */
public interface IAiUserService 
{
    /**
     * 查询网站用户
     * 
     * @param userId 网站用户主键
     * @return 网站用户
     */
    public AiUser selectAiUserByUserId(String userId);

    /**
     * 查询网站用户列表
     * 
     * @param aiUser 网站用户
     * @return 网站用户集合
     */
    public List<AiUser> selectAiUserList(AiUser aiUser);

    /**
     * 新增网站用户
     * 
     * @param aiUser 网站用户
     * @return 结果
     */
    public int insertAiUser(AiUser aiUser);

    /**
     * 修改网站用户
     * 
     * @param aiUser 网站用户
     * @return 结果
     */
    public int updateAiUser(AiUser aiUser);

    /**
     * 批量删除网站用户
     * 
     * @param userIds 需要删除的网站用户主键集合
     * @return 结果
     */
    public int deleteAiUserByUserIds(String userIds);

    /**
     * 删除网站用户信息
     * 
     * @param userId 网站用户主键
     * @return 结果
     */
    public int deleteAiUserByUserId(String userId);


    AiUser selectAiUserByUsername(String username);

    AiUser selectAiUserByPass(String newPass);

    int proveUsername(String username);
}
