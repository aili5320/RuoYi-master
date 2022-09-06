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
import com.ruoyi.novel.domain.AiForum;
import com.ruoyi.novel.service.IAiForumService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 评论Controller
 * 
 * @author ruoyi
 * @date 2022-09-02
 */
@Controller
@RequestMapping("/forums/forum")
public class AiForumController extends BaseController
{
    private String prefix = "forums/forum";

    @Autowired
    private IAiForumService aiForumService;

    @RequiresPermissions("forums:forum:view")
    @GetMapping()
    public String forum()
    {
        return prefix + "/forum";
    }

    /**
     * 查询评论列表
     */
    @RequiresPermissions("forums:forum:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(AiForum aiForum)
    {
        startPage();
        List<AiForum> list = aiForumService.selectAiForumList(aiForum);
        return getDataTable(list);
    }

    /**
     * 导出评论列表
     */
    @RequiresPermissions("forums:forum:export")
    @Log(title = "评论", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(AiForum aiForum)
    {
        List<AiForum> list = aiForumService.selectAiForumList(aiForum);
        ExcelUtil<AiForum> util = new ExcelUtil<AiForum>(AiForum.class);
        return util.exportExcel(list, "评论数据");
    }

    /**
     * 新增评论
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存评论
     */
    @RequiresPermissions("forums:forum:add")
    @Log(title = "评论", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(AiForum aiForum)
    {
        return toAjax(aiForumService.insertAiForum(aiForum));
    }

    /**
     * 修改评论
     */
    @RequiresPermissions("forums:forum:edit")
    @GetMapping("/edit/{forumId}")
    public String edit(@PathVariable("forumId") String forumId, ModelMap mmap)
    {
        AiForum aiForum = aiForumService.selectAiForumByForumId(forumId);
        mmap.put("aiForum", aiForum);
        return prefix + "/edit";
    }

    /**
     * 修改保存评论
     */
    @RequiresPermissions("forums:forum:edit")
    @Log(title = "评论", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(AiForum aiForum)
    {
        return toAjax(aiForumService.updateAiForum(aiForum));
    }

    /**
     * 删除评论
     */
    @RequiresPermissions("forums:forum:remove")
    @Log(title = "评论", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(aiForumService.deleteAiForumByForumIds(ids));
    }
}
