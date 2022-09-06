package com.ruoyi.novel.controller;

import java.util.List;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.novel.domain.AiUser;
import com.ruoyi.novel.service.IAiUserService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 网站用户Controller
 * 
 * @author ruoyi
 * @date 2022-08-02
 */
@Controller
@RequestMapping("/user/users")
public class AiUserController extends BaseController
{
    private String prefix = "user/users";

    @Autowired
    private IAiUserService aiUserService;

    @RequiresPermissions("user:users:view")
    @GetMapping()
    public String users()
    {
        return prefix + "/users";
    }

    /**
     * 查询网站用户列表
     */
    @RequiresPermissions("user:users:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(AiUser aiUser)
    {
        startPage();
        List<AiUser> list = aiUserService.selectAiUserList(aiUser);
        return getDataTable(list);
    }

    /**
     * 导出网站用户列表
     */
    @RequiresPermissions("user:users:export")
    @Log(title = "网站用户", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(AiUser aiUser)
    {
        List<AiUser> list = aiUserService.selectAiUserList(aiUser);
        ExcelUtil<AiUser> util = new ExcelUtil<AiUser>(AiUser.class);
        return util.exportExcel(list, "网站用户数据");
    }

    /**
     * 新增网站用户
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存网站用户
     */
    @RequiresPermissions("user:users:add")
    @Log(title = "网站用户", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(AiUser aiUser)
    {
        return toAjax(aiUserService.insertAiUser(aiUser));
    }

    /**
     * 修改网站用户
     */
    @RequiresPermissions("user:users:edit")
    @GetMapping("/edit/{userId}")
    public String edit(@PathVariable("userId") String userId, ModelMap mmap)
    {
        AiUser aiUser = aiUserService.selectAiUserByUserId(userId);
        mmap.put("aiUser", aiUser);
        return prefix + "/edit";
    }

    /**
     * 修改保存网站用户
     */
    @RequiresPermissions("user:users:edit")
    @Log(title = "网站用户", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(AiUser aiUser)
    {
        return toAjax(aiUserService.updateAiUser(aiUser));
    }

    /**
     * 删除网站用户
     */
    @RequiresPermissions("user:users:remove")
    @Log(title = "网站用户", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(aiUserService.deleteAiUserByUserIds(ids));
    }
}
