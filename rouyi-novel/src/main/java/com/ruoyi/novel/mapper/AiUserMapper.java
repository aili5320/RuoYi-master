package com.ruoyi.novel.mapper;

import java.util.List;
import com.ruoyi.novel.domain.AiUser;

/**
 * 网站用户Mapper接口
 * 
 * @author ruoyi
 * @date 2022-08-02
 */
public interface AiUserMapper 
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
     * 删除网站用户
     * 
     * @param userId 网站用户主键
     * @return 结果
     */
    public int deleteAiUserByUserId(String userId);

    /**
     * 批量删除网站用户
     * 
     * @param userIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteAiUserByUserIds(String[] userIds);


    /**
     * 根据用户名查询用户信息
     */
    AiUser selectAiUserByUsername(String username);

    /**
     * 根据加密盐查找用户信息
     * @param password
     * @return
     */
    AiUser selectAiUserByPass(String password);

    int proveUsername(String username);
}
