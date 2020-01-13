package com.bjfu.inspect.controller.app;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.bjfu.inspect.bean.DataNotice;
import com.bjfu.inspect.bean.ProjectNotice;
import com.bjfu.inspect.service.DataNoticeService;
import com.bjfu.inspect.service.ProjectNoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;


@RestController
@CrossOrigin
@RequestMapping("/api/notice/project")
public class ProjectNoticeApiController {
    @Autowired
    private ProjectNoticeService projectNoticeService;

    @RequestMapping("/release")
    public int release(@RequestParam("title") String title,
                              @RequestParam("address") String address,
                              @RequestParam("type") String type,
                              @RequestParam("hnum") int hnum,
                              @RequestParam("wage") int wage,
                              @RequestParam(value="remark", defaultValue = "") String remark,
                              @RequestParam("author") int author,
                              @RequestParam("imageName") String imageNameArr,
                              @RequestParam("creatTime") String creatTime){
        String[] imageName = imageNameArr.split("#");
        //1、补充图片路径
        JSONArray images = new JSONArray();
        for (String s : imageName) {
            if (!StringUtils.isEmpty(s)){
                images.add(s);
            }
        }
        SimpleDateFormat sdr = new SimpleDateFormat("yyyy-MM-dd");
        Timestamp creatTimes = null;
        try {
            creatTimes = new Timestamp(sdr.parse(creatTime).getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        //2、设置创建时间
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        ProjectNotice notice = new ProjectNotice(title, images.toString(), address, type, hnum, wage, timestamp, creatTimes, remark, author);
        return projectNoticeService.save(notice);
    }

    @RequestMapping("/update")
    public int update(@RequestParam("title") String title,
                      @RequestParam("address") String address,
                      @RequestParam("type") String type,
                      @RequestParam("hnum") int hnum,
                      @RequestParam("wage") int wage,
                      @RequestParam(value="remark", defaultValue = "") String remark,
                      @RequestParam("author") int author,
                      @RequestParam("imageName") String[] imageName,
                      @RequestParam("noticeId") int noticeId,
                      @RequestParam("creatTime") String creatTime){
        //1、补充图片路径
        JSONArray images = new JSONArray();
        for (String s : imageName) {
            images.add(s);
        }
        //2、设置创建时间
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        SimpleDateFormat sdr = new SimpleDateFormat("yyyy-MM-dd");
        Timestamp creatTimes = null;
        try {
            creatTimes = new Timestamp(sdr.parse(creatTime).getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        ProjectNotice notice = new ProjectNotice(noticeId, title, images.toString(), address, type, hnum, wage, timestamp, creatTimes, remark, author);
        return projectNoticeService.update(notice);
    }

    @RequestMapping("/delete")
    public int delete(@RequestParam("noticeId")Integer noticeId){
        return projectNoticeService.delete(noticeId);
    }

    @RequestMapping("/show")
    public JSONArray show(){
        List<ProjectNotice> list = projectNoticeService.findAll();
        return listToJson(list);
    }

    @RequestMapping("/find")
    public JSONArray show(@RequestParam("noticeId")Integer authorId){
        List<ProjectNotice> list = projectNoticeService.findByAuthor(authorId);
        return listToJson(list);
    }

    @RequestMapping("/findById")
    public JSONObject findById(@RequestParam("noticeId")String pId){
        JSONObject jsonObject = new JSONObject();
        ProjectNotice notice = projectNoticeService.findById(pId);
        jsonObject.put("noticeId", notice.getpId());
        jsonObject.put("title", notice.getpTitle());
        JSONArray imgArr = JSONArray.parseArray(notice.getpImage());
        jsonObject.put("imagePath", imgArr);
        jsonObject.put("type", notice.getpType());
        jsonObject.put("address", notice.getpAddress());
        jsonObject.put("hnum", notice.getpHnum());
        jsonObject.put("wage", notice.getpWage());
        SimpleDateFormat sdr = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        jsonObject.put("creatTime", sdr.format(notice.getpCreatTime()));
        jsonObject.put("time", sdr.format(notice.getpTime()));
        jsonObject.put("remark", notice.getpRemark());
        return jsonObject;
    }

    /**
     * 把对象转化成json对象
     * @param list
     * @return
     */
    private JSONArray listToJson(List<ProjectNotice> list){
        JSONArray jsonArray = new JSONArray();
        for (ProjectNotice notice : list){
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("noticeId", notice.getpId());
            jsonObject.put("title", notice.getpTitle());
            SimpleDateFormat sdr = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            jsonObject.put("time", sdr.format(notice.getpTime()));
            jsonObject.put("information", notice.toString());
            JSONArray imgArr = JSONArray.parseArray(notice.getpImage());
            jsonObject.put("image", imgArr.getString(0));
            jsonArray.add(jsonObject);
        }
        return jsonArray;
    }
}
