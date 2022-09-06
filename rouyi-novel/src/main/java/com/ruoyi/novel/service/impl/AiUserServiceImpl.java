package com.ruoyi.novel.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.novel.mapper.AiUserMapper;
import com.ruoyi.novel.domain.AiUser;
import com.ruoyi.novel.service.IAiUserService;
import com.ruoyi.common.core.text.Convert;

/**
 * 网站用户Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-08-02
 */
@Service
public class AiUserServiceImpl implements IAiUserService 
{
    @Autowired
    private AiUserMapper aiUserMapper;

    /**
     * 查询网站用户
     * 
     * @param userId 网站用户主键
     * @return 网站用户
     */
    @Override
    public AiUser selectAiUserByUserId(String userId)
    {
        return aiUserMapper.selectAiUserByUserId(userId);
    }

    /**
     * 查询网站用户列表
     * 
     * @param aiUser 网站用户
     * @return 网站用户
     */
    @Override
    public List<AiUser> selectAiUserList(AiUser aiUser)
    {
        return aiUserMapper.selectAiUserList(aiUser);
    }

    /**
     * 新增网站用户
     * 
     * @param aiUser 网站用户
     * @return 结果
     */
    @Override
    public int insertAiUser(AiUser aiUser)
    {
        aiUser.setCreateTime(DateUtils.getNowDate());
        return aiUserMapper.insertAiUser(aiUser);
    }

    /**
     * 修改网站用户
     * 
     * @param aiUser 网站用户
     * @return 结果
     */
    @Override
    public int updateAiUser(AiUser aiUser)
    {
        return aiUserMapper.updateAiUser(aiUser);
    }

    /**
     * 批量删除网站用户
     * 
     * @param userIds 需要删除的网站用户主键
     * @return 结果
     */
    @Override
    public int deleteAiUserByUserIds(String userIds)
    {
        return aiUserMapper.deleteAiUserByUserIds(Convert.toStrArray(userIds));
    }

    /**
     * 删除网站用户信息
     * 
     * @param userId 网站用户主键
     * @return 结果
     */
    @Override
    public int deleteAiUserByUserId(String userId)
    {
        return aiUserMapper.deleteAiUserByUserId(userId);
    }
    /**
     * 根据用户名查询用户信息
     */
    @Override
    public AiUser selectAiUserByUsername(String username)
    {
        return aiUserMapper.selectAiUserByUsername(username);
    }

    @Override
    public AiUser selectAiUserByPass(String newPass)
    {
        return aiUserMapper.selectAiUserByPass(newPass);
    }

    @Override
    public int proveUsername(String username) {
        return aiUserMapper.proveUsername(username);
    }

}
