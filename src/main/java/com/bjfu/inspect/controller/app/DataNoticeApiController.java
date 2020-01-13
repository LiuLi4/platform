package com.bjfu.inspect.controller.app;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.bjfu.inspect.bean.AllianceNotice;
import com.bjfu.inspect.bean.DataNotice;
import com.bjfu.inspect.service.AllianceNoticeService;
import com.bjfu.inspect.service.DataNoticeService;
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
@RequestMapping("/api/notice/data")
public class DataNoticeApiController {
    @Autowired
    private DataNoticeService dataNoticeService;

    @RequestMapping("/release")
    public int release(@RequestParam("name") String name,
                              @RequestParam("address") String address,
                              @RequestParam("infor") String infor,
                              @RequestParam("type") String type,
                              @RequestParam("price") double price,
                              @RequestParam("position") String position,
                              @RequestParam("power") int power,
                              @RequestParam(value="remark", defaultValue = "", required = false) String remark,
                              @RequestParam("author") int author,
                              @RequestParam("imageName") String imageNameArr){
        String[] imgName = imageNameArr.split("#");
        //1、补充图片路径
        JSONArray images = new JSONArray();
        for (String s : imgName) {
            if(s != null && !s.isEmpty()){
                images.add(s);
            }
        }
        //2、设置创建时间
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        DataNotice notice = new DataNotice(name, address, images.toString(), infor, type, price, position, power, remark, author, timestamp);
        return dataNoticeService.save(notice);
    }

    @RequestMapping("/update")
    public int update(@RequestParam("name") String name,
                      @RequestParam("address") String address,
                      @RequestParam("infor") String infor,
                      @RequestParam("type") String type,
                      @RequestParam("price") double price,
                      @RequestParam("position") String position,
                      @RequestParam("power") int power,
                      @RequestParam(value="remark", defaultValue = "") String remark,
                      @RequestParam("author") int author,
                      @RequestParam("imageName") String imageNameArr,
                      @RequestParam("noticeId") int noticeId){
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
        DataNotice notice = new DataNotice(noticeId, name, address, images.toString(), infor, type, price, position, power, remark, author, timestamp);
        return dataNoticeService.update(notice);
    }

    @RequestMapping("/delete")
    public int delete(@RequestParam("noticeId")int noticeId){
        return dataNoticeService.delete(noticeId);
    }

    @RequestMapping("/show")
    public JSONArray show(){
        List<DataNotice> list = dataNoticeService.findAll();
        return listToJson(list);
    }

    @RequestMapping("/find")
    public JSONArray find(@RequestParam("authorId")int authorId){
        List<DataNotice> list = dataNoticeService.findByAuthor(authorId);
        return listToJson(list);
    }

    @RequestMapping("/findById")
    public JSONObject findById(@RequestParam("noticeId")String adId){
        JSONObject jsonObject = new JSONObject();
        DataNotice notice = dataNoticeService.findById(adId);
        jsonObject.put("noticeId", notice.getAdId());
        jsonObject.put("name", notice.getAdName());
        JSONArray imgArr = JSONArray.parseArray(notice.getAdImage());
        jsonObject.put("imagePath", imgArr);
        jsonObject.put("address", notice.getAdAddress());
        jsonObject.put("information", notice.getAdInfor());
        jsonObject.put("price", notice.getAdPrice());
        jsonObject.put("position", notice.getAdPosition());
        jsonObject.put("power", notice.getAdPower());
        SimpleDateFormat sdr = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        jsonObject.put("time", sdr.format(notice.getAdTime()));
        jsonObject.put("type", notice.getAdType());
        return jsonObject;
    }

    @RequestMapping("/findByType")
    public JSONArray findByType(@RequestParam("adType")String adType){
        List<DataNotice> list = dataNoticeService.findByType(adType);
        return listToJson(list);
    }

    /**
     * 把对象转化成json对象
     * @param list
     * @return
     */
    private JSONArray listToJson(List<DataNotice> list){
        JSONArray jsonArray = new JSONArray();
        for (DataNotice notice : list){
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("noticeId", notice.getAdId());
            jsonObject.put("name", notice.getAdName());
            SimpleDateFormat sdr = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            jsonObject.put("time", sdr.format(notice.getAdTime()));
            jsonObject.put("information", notice.toString());
            JSONArray imgArr = JSONArray.parseArray(notice.getAdImage());
            jsonObject.put("image", imgArr.getString(0));
            jsonArray.add(jsonObject);
        }
        return jsonArray;
    }
}
