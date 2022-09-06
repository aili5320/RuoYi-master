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
import com.ruoyi.novel.domain.AiAuthor;
import com.ruoyi.novel.service.IAiAuthorService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 作者Controller
 * 
 * @author ruoyi
 * @date 2022-08-22
 */
@Controller
@RequestMapping("/author/authors")
public class AiAuthorController extends BaseController
{
    private String prefix = "author/authors";

    @Autowired
    private IAiAuthorService aiAuthorService;

    @RequiresPermissions("author:authors:view")
    @GetMapping()
    public String authors()
    {
        return prefix + "/authors";
    }

    /**
     * 查询作者列表
     */
    @RequiresPermissions("author:authors:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(AiAuthor aiAuthor)
    {
        startPage();
        List<AiAuthor> list = aiAuthorService.selectAiAuthorList(aiAuthor);
        return getDataTable(list);
    }

    /**
     * 导出作者列表
     */
    @RequiresPermissions("author:authors:export")
    @Log(title = "作者", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(AiAuthor aiAuthor)
    {
        List<AiAuthor> list = aiAuthorService.selectAiAuthorList(aiAuthor);
        ExcelUtil<AiAuthor> util = new ExcelUtil<AiAuthor>(AiAuthor.class);
        return util.exportExcel(list, "作者数据");
    }

    /**
     * 新增作者
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存作者
     */
    @RequiresPermissions("author:authors:add")
    @Log(title = "作者", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(AiAuthor aiAuthor)
    {
        return toAjax(aiAuthorService.insertAiAuthor(aiAuthor));
    }

    /**
     * 修改作者
     */
    @RequiresPermissions("author:authors:edit")
    @GetMapping("/edit/{autId}")
    public String edit(@PathVariable("autId") String autId, ModelMap mmap)
    {
        AiAuthor aiAuthor = aiAuthorService.selectAiAuthorByAutId(autId);
        mmap.put("aiAuthor", aiAuthor);
        return prefix + "/edit";
    }

    /**
     * 修改保存作者
     */
    @RequiresPermissions("author:authors:edit")
    @Log(title = "作者", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(AiAuthor aiAuthor)
    {
        return toAjax(aiAuthorService.updateAiAuthor(aiAuthor));
    }

    /**
     * 删除作者
     */
    @RequiresPermissions("author:authors:remove")
    @Log(title = "作者", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(aiAuthorService.deleteAiAuthorByAutIds(ids));
    }
}
