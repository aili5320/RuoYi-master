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
import com.ruoyi.novel.domain.AiChapter;
import com.ruoyi.novel.service.IAiChapterService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 章节Controller
 * 
 * @author ruoyi
 * @date 2022-08-25
 */
@Controller
@RequestMapping("/chapter/chapters")
public class AiChapterController extends BaseController
{
    private String prefix = "chapter/chapters";

    @Autowired
    private IAiChapterService aiChapterService;

    @RequiresPermissions("chapter:chapters:view")
    @GetMapping()
    public String chapters()
    {
        return prefix + "/chapters";
    }

    /**
     * 查询章节列表
     */
    @RequiresPermissions("chapter:chapters:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(AiChapter aiChapter)
    {
        startPage();
        List<AiChapter> list = aiChapterService.selectAiChapterList(aiChapter);
        return getDataTable(list);
    }

    /**
     * 导出章节列表
     */
    @RequiresPermissions("chapter:chapters:export")
    @Log(title = "章节", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(AiChapter aiChapter)
    {
        List<AiChapter> list = aiChapterService.selectAiChapterList(aiChapter);
        ExcelUtil<AiChapter> util = new ExcelUtil<AiChapter>(AiChapter.class);
        return util.exportExcel(list, "章节数据");
    }

    /**
     * 新增章节
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存章节
     */
    @RequiresPermissions("chapter:chapters:add")
    @Log(title = "章节", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(AiChapter aiChapter)
    {
        return toAjax(aiChapterService.insertAiChapter(aiChapter));
    }

    /**
     * 修改章节
     */
    @RequiresPermissions("chapter:chapters:edit")
    @GetMapping("/edit/{chapterId}")
    public String edit(@PathVariable("chapterId") String chapterId, ModelMap mmap)
    {
        AiChapter aiChapter = aiChapterService.selectAiChapterByChapterId(chapterId);
        mmap.put("aiChapter", aiChapter);
        return prefix + "/edit";
    }

    /**
     * 修改保存章节
     */
    @RequiresPermissions("chapter:chapters:edit")
    @Log(title = "章节", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(AiChapter aiChapter)
    {
        return toAjax(aiChapterService.updateAiChapter(aiChapter));
    }

    /**
     * 删除章节
     */
    @RequiresPermissions("chapter:chapters:remove")
    @Log(title = "章节", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(aiChapterService.deleteAiChapterByChapterIds(ids));
    }
}
