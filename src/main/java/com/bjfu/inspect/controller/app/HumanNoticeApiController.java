package com.bjfu.inspect.controller.app;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.bjfu.inspect.bean.AllianceNotice;
import com.bjfu.inspect.bean.DataNotice;
import com.bjfu.inspect.bean.HumanNotice;
import com.bjfu.inspect.service.AllianceNoticeService;
import com.bjfu.inspect.service.HumanNoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;


@RestController
@CrossOrigin
@RequestMapping("/api/notice/human")
public class HumanNoticeApiController {
    @Autowired
    private HumanNoticeService humanNoticeService;

    @RequestMapping("/release")
    public int release(@RequestParam("title") String title,
                              @RequestParam("skill") String skill,
                              @RequestParam("wage") int wage,
                              @RequestParam("address") String address,
                              @RequestParam("request") String request,
                              @RequestParam("name") String name,
                              @RequestParam("telephone") String telephone,
                              @RequestParam(value="remark", defaultValue = "") String remark,
                              @RequestParam("author") int author){
        //设置创建时间
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        HumanNotice notice = new HumanNotice(title, skill, wage, address, request, name, telephone, remark, author, timestamp);
        return humanNoticeService.save(notice);
    }

    @RequestMapping("/update")
    public int update(@RequestParam("title") String title,
                      @RequestParam("skill") String skill,
                      @RequestParam("wage") int wage,
                      @RequestParam("address") String address,
                      @RequestParam("request") String request,
                      @RequestParam("name") String name,
                      @RequestParam("telephone") String telephone,
                      @RequestParam(value="remark", defaultValue = "") String remark,
                      @RequestParam("author") int author,
                      @RequestParam("noticeId") int noticeId){
        //设置创建时间
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        HumanNotice notice = new HumanNotice(noticeId, title, skill, wage, address, request, name, telephone, remark, timestamp, author);
        return humanNoticeService.update(notice);
    }

    @RequestMapping("/delete")
    public int delete(@RequestParam("noticeId")int noticeId){
        return humanNoticeService.delete(noticeId);
    }

    @RequestMapping("/show")
    public JSONArray show(){
        List<HumanNotice> list = humanNoticeService.findAll();
        return listToJson(list);
    }

    @RequestMapping("/find")
    public JSONArray find(@RequestParam("authorId")int authorId){
        List<HumanNotice> list = humanNoticeService.findByAuthor(authorId);
        return listToJson(list);
    }

    @RequestMapping("/findById")
    public JSONObject findById(@RequestParam("noticeId")String hrId){
        JSONObject jsonObject = new JSONObject();
        HumanNotice notice = humanNoticeService.findById(hrId);
        jsonObject.put("noticeId", notice.getHrId());
        jsonObject.put("title", notice.getHrTitle());
        jsonObject.put("skill", notice.getHrSkill());
        jsonObject.put("wage", notice.getHrWage());
        jsonObject.put("address", notice.getHrAddress());
        jsonObject.put("request", notice.getHrRequest());
        jsonObject.put("name", notice.getHrName());
        jsonObject.put("telephone", notice.getHrTelephone());
        SimpleDateFormat sdr = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        jsonObject.put("time", sdr.format(notice.getHrTime()));
        jsonObject.put("remark", notice.getHrRemark());
        return jsonObject;
    }

    /**
     * 把对象转化成json对象
     * @param list
     * @return
     */
    private JSONArray listToJson(List<HumanNotice> list){
        JSONArray jsonArray = new JSONArray();
        for (HumanNotice notice : list){
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("noticeId", notice.getHrId());
            jsonObject.put("title", notice.getHrTitle());
            SimpleDateFormat sdr = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            jsonObject.put("time", sdr.format(notice.getHrTime()));
            jsonObject.put("information", notice.toString());
            jsonArray.add(jsonObject);
        }
        return jsonArray;
    }
}
