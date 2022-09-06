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
import com.ruoyi.novel.domain.AiBook;
import com.ruoyi.novel.service.IAiBookService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 书名Controller
 * 
 * @author ruoyi
 * @date 2022-08-23
 */
@Controller
@RequestMapping("/book/books")
public class AiBookController extends BaseController
{
    private String prefix = "book/books";

    @Autowired
    private IAiBookService aiBookService;

    @RequiresPermissions("book:books:view")
    @GetMapping()
    public String books()
    {
        return prefix + "/books";
    }

    /**
     * 查询书名列表
     */
    @RequiresPermissions("book:books:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(AiBook aiBook)
    {
        startPage();
        List<AiBook> list = aiBookService.selectAiBookList(aiBook);
        return getDataTable(list);
    }

    /**
     * 导出书名列表
     */
    @RequiresPermissions("book:books:export")
    @Log(title = "书名", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(AiBook aiBook)
    {
        List<AiBook> list = aiBookService.selectAiBookList(aiBook);
        ExcelUtil<AiBook> util = new ExcelUtil<AiBook>(AiBook.class);
        return util.exportExcel(list, "书名数据");
    }

    /**
     * 新增书名
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存书名
     */
    @RequiresPermissions("book:books:add")
    @Log(title = "书名", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(AiBook aiBook)
    {
        return toAjax(aiBookService.insertAiBook(aiBook));
    }

    /**
     * 修改书名
     */
    @RequiresPermissions("book:books:edit")
    @GetMapping("/edit/{bookId}")
    public String edit(@PathVariable("bookId") String bookId, ModelMap mmap)
    {
        AiBook aiBook = aiBookService.selectAiBookByBookId(bookId);
        mmap.put("aiBook", aiBook);
        return prefix + "/edit";
    }

    /**
     * 修改保存书名
     */
    @RequiresPermissions("book:books:edit")
    @Log(title = "书名", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(AiBook aiBook)
    {
        return toAjax(aiBookService.updateAiBook(aiBook));
    }

    /**
     * 删除书名
     */
    @RequiresPermissions("book:books:remove")
    @Log(title = "书名", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(aiBookService.deleteAiBookByBookIds(ids));
    }
}
