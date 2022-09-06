package com.ruoyi.novel.controller.API;

import com.alibaba.fastjson.JSONObject;
import com.ruoyi.novel.common.IdUtils;
import com.ruoyi.novel.domain.AiBook;
import com.ruoyi.novel.domain.AiChapter;
import com.ruoyi.novel.domain.AiForum;
import com.ruoyi.novel.service.IAiBookService;
import com.ruoyi.novel.service.IAiChapterService;
import com.ruoyi.novel.service.IAiForumService;
import com.ruoyi.novel.utils.MyResultMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/novel")
public class APIBookController {

    @Autowired
    MyResultMap resultMap;

    @Autowired
    private IAiBookService aiBookService;

    @Autowired
    private IAiChapterService aiChapterService;



    @Autowired
    private IAiForumService aiForumService;
    /**
     * 新增书籍
     * @param jsonObject
     * @return
     */
    @RequestMapping("/addBook")
    public Map addBook(@RequestBody JSONObject jsonObject) {
        AiBook aiBook = new AiBook();
        aiBook.setBookId(IdUtils.simpleUUID());
        aiBook.setAutId(jsonObject.getString("autId"));
        aiBook.setBookName(jsonObject.getString("bookName"));
        aiBook.setAutName(jsonObject.getString("autName"));
        aiBook.setAcronym(jsonObject.getString("acronym"));
        aiBook.setGenre(jsonObject.getString("genre"));
        aiBook.setTheme(jsonObject.getString("theme"));
        aiBook.setKeyWord(jsonObject.getString("keyWord"));
        aiBook.setBookPic(jsonObject.getString("bookPic"));
        aiBook.setIntro(jsonObject.getString("intro"));
        aiBook.setWishes(jsonObject.getString("wishes"));
        aiBook.setCollect(jsonObject.getString("collect"));
        try {
            int count = aiBookService.insertAiBook(aiBook);
            if (count == 1) {
                return resultMap.resultMap("新增作品成功！", null, 0);
            } else {
                return resultMap.resultMap("新增作品失败！", null, 1);
            }
        } catch (Exception e) {
            System.out.println(e);
            return resultMap.resultMap("系统异常！", null, 1);
        }
    }


    /**
     * 查询作者书籍列表
      * @param jsonObject
     * @return
     */
    @RequestMapping ("/queryBooks")
    public Map queryBooks(@RequestBody JSONObject jsonObject) {
        String autId = jsonObject.getString("autId");
        List<AiBook> data  =aiBookService.selectAiBookByAutId(autId);
        return resultMap.resultMap("创作者中心加载成功!", data, 0);
    }

    /**
     * 查询书籍详情信息
     *
     */
    @RequestMapping("/queryBookInfo")
    public Map queryBookInfo(@RequestBody JSONObject jsonObject) {
        String bookId = jsonObject.getString("bookId");
        AiBook data=aiBookService.selectAiBookByBookId(bookId);
        return resultMap.resultMap("创作者中心加载成功!", data, 0);
    }


    /**
     * 修改小说信息
     * @param jsonObject
     * @return
     */
    @RequestMapping("/editBook")
    public Map editBook(@RequestBody JSONObject jsonObject) {
        AiBook aiBook = new AiBook();
        aiBook.setBookId(jsonObject.getString("bookId"));
        aiBook.setAutId(jsonObject.getString("autId"));
        aiBook.setBookName(jsonObject.getString("bookName"));
        aiBook.setAutName(jsonObject.getString("autName"));
        aiBook.setAcronym(jsonObject.getString("acronym"));
        aiBook.setGenre(jsonObject.getString("genre"));
        aiBook.setTheme(jsonObject.getString("theme"));
        aiBook.setKeyWord(jsonObject.getString("keyWord"));
        String bookPic = jsonObject.getString("bookPic");
        if(!bookPic.equals("")){
            aiBook.setBookPic(bookPic);
        }
        aiBook.setIntro(jsonObject.getString("intro"));
        aiBook.setWishes(jsonObject.getString("wishes"));
        aiBook.setCollect(jsonObject.getString("collect"));
        try {
            int count = aiBookService.updateAiBook(aiBook);
            if (count == 1) {
                return resultMap.resultMap("修改信息成功！", null, 0);
            } else {
                return resultMap.resultMap("修改信息失败！", null, 1);
            }
        } catch (Exception e) {
            System.out.println(e);
            return resultMap.resultMap("系统异常！", null, 1);
        }
    }


    /**
     * 新增章节
     * @param jsonObject
     * @return
     */

    @RequestMapping("/addChapter")
    public Map addChapter(@RequestBody JSONObject jsonObject) {
       AiChapter aiChapter = new AiChapter();
       aiChapter.setChapterId(IdUtils.simpleUUID());
       String bookId = jsonObject.getString("bookId");
       aiChapter.setBookId(bookId);
       aiChapter.setBookName(jsonObject.getString("bookName"));
       aiChapter.setChapterName(jsonObject.getString("chapterName"));
       aiChapter.setSendWord(jsonObject.getString("sendWord"));
       String content =jsonObject.getString("content");
       aiChapter.setContent(content);


       String num = content.replace("<p>","").replace("</p>","");
        long  chaNum = (long) num.trim().length();
        aiChapter.setChapterNum (chaNum);
        List<AiChapter> list = aiChapterService.selectAiChapterNumByBookId(bookId);
        Long numAll = chaNum;

        if (!list.isEmpty()){
           for (AiChapter lists:list){
               Long  lisNum = lists.getChapterNum();
               numAll=numAll+lisNum;
           }
        }
        //将最新章节名称存入，书名表
        AiBook aiBook = new AiBook();
        aiBook.setBookId(bookId);
        aiBook.setWordNum(numAll+"");
        aiBook.setNewChapter(aiChapter.getChapterName());
        aiBookService.updateAiBook(aiBook);
       int count = aiChapterService.insertAiChapter(aiChapter);
       if (count==1){
       return resultMap.resultMap("上传章节成功", null, 0);
       }
       return resultMap.resultMap("上传章节失败", null, 0);
    }


    /**
     * 获取章节列表
     * @param jsonObject
     * @return
     */
    @RequestMapping("/getChapterList")
    public Map getChapterList(@RequestBody JSONObject jsonObject) {
        String bookId=  jsonObject.getString("bookId");
        List<AiChapter>  data  = aiChapterService.selectAiChapterByBookId(bookId);
        return resultMap.resultMap("获取章节列表成功！", data, 0);
    }

    /**
     * 获取章节详情信息
     * @param jsonObject
     * @return
     */
    @RequestMapping("/queryChapter")
    public Map queryChapter(@RequestBody JSONObject jsonObject) {
        String chapterId=  jsonObject.getString("chapterId");
        AiChapter chapter = aiChapterService.selectAiChapterByChapterId(chapterId);
        return resultMap.resultMap("获取章节内容成功！", chapter, 0);
    }

    /**
     * 修改章节详情信息
     * @param jsonObject
     * @return
     */
    @RequestMapping("/updateChapter")
    public Map updateChapter(@RequestBody JSONObject jsonObject) {
        AiChapter aiChapter = new AiChapter();
        aiChapter.setChapterId(jsonObject.getString("chapterId"));
        String bookId = jsonObject.getString("bookId");
        aiChapter.setBookId(bookId);
        aiChapter.setBookName(jsonObject.getString("bookName"));
        aiChapter.setChapterName(jsonObject.getString("chapterName"));
        aiChapter.setSendWord(jsonObject.getString("sendWord"));
        String content =jsonObject.getString("content");
        aiChapter.setContent(content);
        String num = content.replace("<p>","").replace("</p>","");
        long  chaNum = (long) num.trim().length();
        aiChapter.setChapterNum (chaNum);
        int count = aiChapterService.updateAiChapter(aiChapter);
        if (count==1){
            return resultMap.resultMap("更新章节内容成功", null, 0);
        }
        return resultMap.resultMap("更新章节内容失败", null, 0);
    }

    /**
     * 删除章节
     * @param jsonObject
     * @return
     */
    @RequestMapping("/deteleChapter")
    public Map deteleChapter(@RequestBody JSONObject jsonObject) {

        String chapterId= jsonObject.getString("chapterId");

        int count = aiChapterService.deleteAiChapterByChapterId(chapterId);
        if (count==1){
            return resultMap.resultMap("删除章节成功", null, 0);
        }
        return resultMap.resultMap("删除章节成功失败", null, 0);
    }


    /**
     * 查询小说名类似
     * @param jsonObject
     * @return
     */
    @RequestMapping("/queryBookList")
    public Map queryBookList(@RequestBody JSONObject jsonObject) {
       String searchBook = jsonObject.getString("searchBook");
       List <AiBook> list =  aiBookService.selectAiBookByBookName(searchBook);
       int count = list.toArray().length;
        Map data = new HashMap<>();
        data.put("bookList",list);
        data.put("count",count);
        return resultMap.resultMap("获取章节列表成功！", data, 0);
    }




    @RequestMapping("/chapterPage")
    public Map chapterPage (@RequestBody JSONObject jsonObject) {
        String pageNumber = jsonObject.getString("pageNumber");
        String bookId = jsonObject.getString("bookId");
        String spPage=pageNumber;
        //设置每页条数
        int pageSize=1;
        //页数
        int pageNo=0;
        if(pageNumber == null){
            pageNo=1;
        }else {
            pageNo = Integer.valueOf(spPage);
            if (pageNo < 1) {
                pageNo = 1;
            }
        }
        //设置最大页数
        int totalCount=0;
        int count = aiChapterService.getCount(bookId);
        if(count>0){
            totalCount=count;
        }
        int maxPage=totalCount%pageSize==0?totalCount/pageSize:totalCount/pageSize+1;
        if(pageNo>maxPage){
            pageNo=maxPage;
        }
        int tempPageNo=(pageNo-1)*pageSize;
        //计算总数量
        //分页查询
        Map map = new HashMap();
        map.put("bookId",bookId);
        map.put("PageNo",tempPageNo);
        map.put("pageSize",pageSize);

        AiChapter aiChapter=aiChapterService.queryChapterByBookId(map);

        Map data = new HashMap();
        data.put("chapterInfo",aiChapter);
        data.put("pageNo",pageNo);
        data.put("totalCount",totalCount);

        return resultMap.resultMap("获取章节列表成功！", data, 0);
    }


    /**
     * 新增章节评论
     * @param jsonObject
     * @return
     */

    @RequestMapping("/addForum")
    public Map addForum(@RequestBody JSONObject jsonObject) {
        System.out.println(jsonObject);
        AiForum aiForum = new AiForum();
        aiForum.setForumId(IdUtils.simpleUUID());
        aiForum.setBookId(jsonObject.getString("bookId"));
        aiForum.setUserId(jsonObject.getString("userId"));
        String chapterId = jsonObject.getString("chapterId");
        aiForum.setChapterId(chapterId);
        aiForum.setChapterName(jsonObject.getString("chapterName"));
        aiForum.setForumTitle(jsonObject.getString("forumTitle"));
        aiForum.setComment(jsonObject.getString("comment"));
        aiForum.setRealName(jsonObject.getString("realName"));
        aiForum.setUserPic(jsonObject.getString("userPic"));

        int flag =  aiForumService.insertAiForum(aiForum);

        if (flag==1){

            List<AiForum> data =  aiForumService.selectAiForumByChapterId(chapterId);
        return resultMap.resultMap("发表评论成功！", data, 0);
        } else {
        return resultMap.resultMap("发表评论失败！", null, 0);

        }
    }

    /**
     * 根据章节Id查询
     * @param jsonObject
     * @return
     */
    @RequestMapping("/queryForumByChapterId")
    public Map queryForumByChapterId(@RequestBody JSONObject jsonObject) {
        String chapterId = jsonObject.getString("chapterId");
        List<AiForum> data =  aiForumService.selectAiForumByChapterId(chapterId);
        return resultMap.resultMap("查询评论列表成功！", data, 0);
    }

    /**
     * 根据小说ID查询用户评论
     * @param jsonObject
     * @return
     */
    @RequestMapping("/queryForumByBookId")
    public Map queryForumByBookId(@RequestBody JSONObject jsonObject) {
        String BookId = jsonObject.getString("bookId");
        List<AiForum> data =  aiForumService.queryForumByBookId(BookId);
        return resultMap.resultMap("查询评论列表成功！", data, 0);
    }


    /**
     * 根据用户ID查询用户评论
     * @param jsonObject
     * @return
     */
    @RequestMapping("/queryForumByUserId")
    public Map queryForumByUserId(@RequestBody JSONObject jsonObject) {
        String userId = jsonObject.getString("userId");
        List<AiForum> data =  aiForumService.queryForumByUserId(userId);
        return resultMap.resultMap("查询评论列表成功！", data, 0);
    }


    /**
     * 根据评论ID删除该评论
     * @param jsonObject
     * @return
     */
    @RequestMapping("/delForumById")
    public Map delForumById(@RequestBody JSONObject jsonObject) {
        //删除该条评论
        String forumId = jsonObject.getString("forumId");
        aiForumService.deleteAiForumByForumId(forumId);
        //将新的评论集合返回
        String userId = jsonObject.getString("userId");
        List<AiForum> data =  aiForumService.queryForumByUserId(userId);
        return resultMap.resultMap("查询评论列表成功！", data, 0);
    }


}
