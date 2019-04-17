package com.hz.forum.controller;

import com.hz.forum.entity.Notice;
import com.hz.forum.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.Map;
import java.util.UUID;


/**
 * @Classname test
 * @Description TODO
 * @Date 2019/3/10 0010 22:56
 * @Created by 11022
 * @Email hz15858@163.com
 */
@Controller
@RequestMapping("notice")
public class NoticeController {

    @Autowired
    private NoticeService ns;

    @RequestMapping("/findAll")
    @ResponseBody
    public Map<String,Object> queryMaster(@RequestParam("rows") int totalSize, @RequestParam("page") int pageIndex, String noticeName){
        System.out.println(noticeName);
        return ns.findAll(totalSize,pageIndex,noticeName);
    }

    @RequestMapping("/add")
    @ResponseBody
    public String add(String noticeName,String noticeStatus,String noticeIntroduce){
        Notice notice;
        String uuid = UUID.randomUUID().toString().replace("-","");
        if (noticeStatus == null){
            notice = new Notice(uuid, noticeName, "正常", noticeIntroduce, new Date());
        }else {
            notice = new Notice(uuid, noticeName, "置顶", noticeIntroduce, new Date());
        }
        int add = ns.add(notice);
        if (add !=0){
            return "success";
        }
        return "fail";
    }


    @RequestMapping("/remove")
    @ResponseBody
    public String remove(String noticeId){
        Notice notice = ns.find(noticeId);
        if (notice!= null){
            int remove = ns.remove(notice);
            if (remove!= 0){
                return "success";
            }
        }
        return "fail";
    }

    @RequestMapping("/modify")
    @ResponseBody
    public String modify(String noticeId,String noticeName,String noticeStatus){
        Notice notice = ns.find(noticeId);
        if (notice != null){
            /*if (noticeStatus == null){
                notice.setNoticeStatus("正常");
            }else {
                notice.setNoticeStatus("置顶");
            }*/
            notice.setNoticeStatus(noticeStatus);
            notice.setNoticeName(noticeName);
            int modify = ns.modify(notice);
            if (modify!=0){
                return "success";
            }
        }
        return "fail";
    }

}
