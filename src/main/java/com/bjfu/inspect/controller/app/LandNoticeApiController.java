package com.bjfu.inspect.controller.app;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.bjfu.inspect.bean.AllianceNotice;
import com.bjfu.inspect.bean.HumanNotice;
import com.bjfu.inspect.bean.LandNotice;
import com.bjfu.inspect.service.AllianceNoticeService;
import com.bjfu.inspect.service.LandNoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;


@RestController
@CrossOrigin
@RequestMapping("/api/notice/land")
public class LandNoticeApiController {
    @Autowired
    private LandNoticeService landNoticeService;

    @RequestMapping("/release")
    public int release(@RequestParam("type") String type,
                              @RequestParam("price") double price,
                              @RequestParam("region") String region,
                              @RequestParam("position") String position,
                              @RequestParam("area") int area,
                              @RequestParam("year") int year,
                              @RequestParam("name") String name,
                              @RequestParam("telephone") String telephone,
                              @RequestParam("address") String address,
                              @RequestParam(value="remark", defaultValue = "") String remark,
                              @RequestParam("author") int author,
                              @RequestParam("imageName") String imageNameArr,
                              @RequestParam("title") String title){
        String[] imageName = imageNameArr.split("#");
        //1、补充图片路径
        JSONArray images = new JSONArray();
        for (String s : imageName) {
            if (!StringUtils.isEmpty(s)){
                images.add(s);
            }
        }
        //2、设置创建时间
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        LandNotice notice = new LandNotice(title, images.toString(), type, price, region, position, area, year, name, telephone, address, remark, author, timestamp);
        return landNoticeService.save(notice);
    }

    @RequestMapping("/update")
    public int update(@RequestParam("type") String type,
                      @RequestParam("price") double price,
                      @RequestParam("region") String region,
                      @RequestParam("position") String position,
                      @RequestParam("area") int area,
                      @RequestParam("year") int year,
                      @RequestParam("name") String name,
                      @RequestParam("telephone") String telephone,
                      @RequestParam("address") String address,
                      @RequestParam(value="remark", defaultValue = "") String remark,
                      @RequestParam("author") int author,
                      @RequestParam("imageName") String imageNameArr,
                      @RequestParam("noticeId") int noticeId,
                      @RequestParam("title") String title){
        String[] imageName = imageNameArr.split("#");
        //1、补充图片路径
        JSONArray images = new JSONArray();
        for (String s : imageName) {
            if (!StringUtils.isEmpty(s)){
                images.add(s);
            }
        }
        //2、设置创建时间
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        LandNotice notice = new LandNotice(noticeId, images.toString(), title, type, price, region, position, area, year, name, telephone, address, remark, author, timestamp);
        return landNoticeService.update(notice);
    }

    @RequestMapping("/delete")
    public int delete(@RequestParam("noticeId")int noticeId){
        return landNoticeService.delete(noticeId);
    }

    @RequestMapping("/show")
    public JSONArray show(){
        List<LandNotice> list = landNoticeService.findAll();
        return listToJson(list);
    }

    @RequestMapping("/find")
    public JSONArray find(@RequestParam("authorId")int authorId){
        List<LandNotice> list = landNoticeService.findByAuthor(authorId);
        return listToJson(list);
    }

    @RequestMapping("/findById")
    public JSONObject findById(@RequestParam("noticeId")String ltId){
        JSONObject jsonObject = new JSONObject();
        LandNotice notice = landNoticeService.findById(ltId);
        jsonObject.put("noticeId", notice.getLtId());
        jsonObject.put("title", notice.getLtTitle());
        JSONArray imgArr = JSONArray.parseArray(notice.getLtImage());
        jsonObject.put("imagePath", imgArr);
        jsonObject.put("type", notice.getLtType());
        jsonObject.put("price", notice.getLtPrice());
        jsonObject.put("area", notice.getLtArea());
        jsonObject.put("position", notice.getLtPosition());
        jsonObject.put("region", notice.getLtRegion());
        SimpleDateFormat sdr = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        jsonObject.put("time", sdr.format(notice.getLtTime()));
        jsonObject.put("year", notice.getLtYear());
        jsonObject.put("name", notice.getLtName());
        jsonObject.put("telephone", notice.getLtTelephone());
        jsonObject.put("address", notice.getLtAddress());
        jsonObject.put("remark", notice.getLtRemark());
        return jsonObject;
    }

    /**
     * 把对象转化成json对象
     * @param list
     * @return
     */
    private JSONArray listToJson(List<LandNotice> list){
        JSONArray jsonArray = new JSONArray();
        for (LandNotice notice : list){
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("noticeId", notice.getLtId());
            jsonObject.put("title", notice.getLtTitle());
            SimpleDateFormat sdr = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            jsonObject.put("time", sdr.format(notice.getLtTime()));
            jsonObject.put("information", notice.toString());
            JSONArray imgArr = JSONArray.parseArray(notice.getLtImage());
            jsonObject.put("image", imgArr.getString(0));
            jsonArray.add(jsonObject);
        }
        return jsonArray;
    }
}
