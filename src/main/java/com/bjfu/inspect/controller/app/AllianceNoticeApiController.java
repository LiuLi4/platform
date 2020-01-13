package com.bjfu.inspect.controller.app;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.bjfu.inspect.bean.AllianceNotice;
import com.bjfu.inspect.bean.DataNotice;
import com.bjfu.inspect.service.AllianceNoticeService;
import com.bjfu.inspect.service.DataNoticeService;
import com.bjfu.inspect.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


@RestController
@CrossOrigin
@RequestMapping("/api/notice/alliance")
public class AllianceNoticeApiController {
    @Autowired
    private AllianceNoticeService allianceNoticeService;
    @Autowired
    private FileService fileService;

    @RequestMapping("/release")
    public int release(@RequestParam("title") String title,
                              @RequestParam("infor") String infor,
                              @RequestParam("type") String type,
                              @RequestParam("price") double price,
                              @RequestParam("position") String position,
                              @RequestParam("power") int power,
                              @RequestParam(value="remark", defaultValue = "") String remark,
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
        AllianceNotice notice = new AllianceNotice(title, images.toString(), infor, type, price, position, power, timestamp, remark, author);
        return allianceNoticeService.save(notice);
    }

    @RequestMapping("/update")
    public int update(@RequestParam("title") String title,
                          @RequestParam("infor") String infor,
                          @RequestParam("type") String type,
                          @RequestParam("price") double price,
                          @RequestParam("position") String position,
                          @RequestParam("power") int power,
                          @RequestParam(value="remark", defaultValue = "") String remark,
                          @RequestParam("author") int author,
                          @RequestParam("imageName") String imageNameArr,
                          @RequestParam("noticeId") int noticeId){
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
        AllianceNotice notice = new AllianceNotice(noticeId, title, images.toString(), infor, type, price, position, power, timestamp, remark, author);
        return allianceNoticeService.update(notice);
    }

    @RequestMapping("/delete")
    public int delete(@RequestParam("noticeId")int noticeId){
        //删除文件夹中的图片
        AllianceNotice notice = allianceNoticeService.findById(noticeId);
        JSONArray imgArr = JSONArray.parseArray(notice.getaImage());
        Object[] array =  imgArr.toArray();
        for (Object ob : array){
            fileService.delete(ob.toString(), 1);
        }
        return allianceNoticeService.delete(noticeId);
    }

    @RequestMapping("/show")
    public JSONArray show(){
        List<AllianceNotice> list = allianceNoticeService.findAll();
        return listToJson(list);
    }

    @RequestMapping("/find")
    public JSONArray find(@RequestParam("authorId")int authorId){
        List<AllianceNotice> list = allianceNoticeService.findByAuthor(authorId);
        return listToJson(list);
    }

    @RequestMapping("/findById")
    public JSONObject findById(@RequestParam("noticeId")int noticeId){
        JSONObject jsonObject = new JSONObject();
        AllianceNotice notice = allianceNoticeService.findById(noticeId);
        jsonObject.put("noticeId", notice.getaId());
        jsonObject.put("title", notice.getaTitle());
        JSONArray imgArr = JSONArray.parseArray(notice.getaImage());
        jsonObject.put("imagePath", imgArr);
        jsonObject.put("information", notice.getaInfor());
        jsonObject.put("type", notice.getaType());
        jsonObject.put("price", notice.getaPrice());
        jsonObject.put("position", notice.getaPosition());
        jsonObject.put("power", notice.getaPower());
        SimpleDateFormat sdr = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        jsonObject.put("time", sdr.format(notice.getaTime()));
        jsonObject.put("remark", notice.getaRemark());
        return jsonObject;
    }

    /**
     * 把对象转化成json对象
     * @param list
     * @return
     */
    private JSONArray listToJson(List<AllianceNotice> list){
        JSONArray jsonArray = new JSONArray();
        for (AllianceNotice notice : list){
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("noticeId", notice.getaId());
            jsonObject.put("title", notice.getaTitle());
            SimpleDateFormat sdr = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            jsonObject.put("time", sdr.format(notice.getaTime()));
            jsonObject.put("information", notice.toString());
            JSONArray imgArr = JSONArray.parseArray(notice.getaImage());
            jsonObject.put("image", imgArr.getString(0));
            jsonArray.add(jsonObject);
        }
        return jsonArray;
    }
}
