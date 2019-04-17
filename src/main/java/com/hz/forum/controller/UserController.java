package com.hz.forum.controller;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import com.hz.forum.entity.User;
import com.hz.forum.service.UserService;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
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
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService us;

    @RequestMapping("/findAll")
    @ResponseBody
    public Map<String,Object> queryMaster(@RequestParam("rows") int totalSize,
                                          @RequestParam("page") int pageIndex,
                                          String userName) {
        return us.findAll(totalSize,pageIndex,userName);

    }

    @RequestMapping("/add")
    @ResponseBody
    public String add(String userName,String userLevel,String userStatus,String userIntroduce){
        String uuid = UUID.randomUUID().toString().replace("-","");
        if (userIntroduce.trim().isEmpty()){
            userIntroduce ="该户用很懒什么都没有留下";
        }
        User user = new User(uuid,userName,userLevel,userStatus,userIntroduce);
        int add = us.add(user);
        if (add != 0){
            return "success";
        }else {
            return "fail";
        }
    }

    @RequestMapping("/modify")
    @ResponseBody
    public String modify(String userId,String userStatus){
        User user = us.find(userId);
        if (user!= null){
            user.setUserStatus(userStatus);
            int modify = us.modify(user);
            System.out.println(modify);
            if (modify != 0){
                return "success";
            }
        }
        return "fail";
    }

    @RequestMapping("remove")
    @ResponseBody
    public String remove(String userId){
        User user = us.find(userId);
        if (user!= null){
            int remove = us.remove(user);
            if (remove!= 0){
                return "success";
            }
        }
        return "fail";
    }

    @RequestMapping(value = "/import",method= RequestMethod.POST)
    @ResponseBody
    public String importExcel(@RequestParam("file") MultipartFile file,
                              HttpSession session) throws Exception {
        ImportParams params = new ImportParams();
        params.setTitleRows(0);
        params.setHeadRows(1);

        params.setNeedVerfiy(true);
        List<User> userList = null;
        userList = ExcelImportUtil.importExcel(file.getInputStream(),
                User.class,params);
        String realPath1 =session.getServletContext().getRealPath("").
                replace("forum","upload");
        for (User user:userList) {
            int a =us.add(user);
            if( a <= 0 ){
                return "false";
            }
        }
        return "success";
    }
    @RequestMapping("/download")
    public void download(HttpServletResponse response) throws IOException {
        List<User> users = us.downloadAll();
        System.out.println(users);
        Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams("",
                        ""),
                User.class,users);
        ServletOutputStream out = response.getOutputStream();

        String fileName =new String("用户信息.xls".getBytes(),"iso-8859-1");
        response.setContentType("application/vnd.ms-excel");

        response.setHeader("content-disposition","attachment;fileName="+fileName);
        workbook.write(out);
        out.close();
    }
}
