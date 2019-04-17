package test;

import com.hz.forum.service.ModuleService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by 11022 on 2018/7/4 0004.
 */
public class managerTest {
    private ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
    private ModuleService ms= (ModuleService) ac.getBean("moduleServiceImpl");
    /*private ManagerService mgr = (ManagerService) ac.getBean("managerServiceImpl");
    private MenuService ms = (MenuService) ac.getBean("menuServiceImpl");
    private SideshowService sideshowService=(SideshowService) ac.getBean("sideshowServiceImpl");
    private MasterService masterService=(MasterService)ac.getBean("masterServiceImpl");
    private ArticleService articleService=(ArticleService)ac.getBean("articleServiceImpl");*/
    /*@Test
    public void select(){
        List<Module> all = ms.findAll(0);
        System.out.println(all);
    }*/
    /*@Test
    public void select(){
        List<SysPermission> zs = mgr.findPermissionByUsername("zs");
        System.out.println(zs);
    }
    @Test
    public void se(){
        Manager manager = mgr.find("zs", "1234567");
        System.out.println(manager);
    }

    @Test
    public void select111(){
        List<SysRole> zs = mgr.findRolesByUserName("zs");
        System.out.println(zs);
    }

    @Test
    public void select1(){
        List<Menu> menus =ms.findAll(1);
        System.out.println(menus);
    }

    @Test
    public void select3(){//totalSize:展示个数
        Map<String,Object> sideshows =sideshowService.findAll(3,2);
        System.out.println(sideshows);
    }

    @Test
    public void update(){
        Sideshow sideshow = new Sideshow();
        sideshow =sideshowService.find("1");
        System.out.println(sideshow);
        sideshow.setPicName("1111");
        sideshow.setDescription("1111");
        sideshow.setPicStatus("1111");
        sideshow.setPicDate(DateConvertUtils.toUtilDate("1999-11-11"));
        int result =sideshowService.modify(sideshow);
        if(result > 0){
            System.out.println(sideshow);
        }else
        {
            System.out.println("错误");
        }
    }
    @Test
    public void insert(){
        Sideshow sideshow = new Sideshow();
        String uuid = UUID.randomUUID().toString().replace("-","");
        sideshow.setId(uuid);
        sideshow.setPicName("1111");
        sideshow.setDescription("1111");
        sideshow.setPicStatus("1111");
        sideshow.setPicDate(DateConvertUtils.toUtilDate("1999-11-11"));
        int result =sideshowService.add(sideshow);
        if(result > 0){
            System.out.println(sideshow);
        }else {
            System.out.println("错误");
        }
    }
    @Test
    public void delete(){
        sideshowService.remove("12");

    }

    @Test
    public void select11(){
        //Map<String,Object> map=articleService.findAll(5,1);
        Article article =articleService.find("1");
        System.out.println(article);
    }

    @Test
    public void  in(){
        ImportParams params = new ImportParams();
        params.setTitleRows(0);
        params.setHeadRows(1);
        List<Master> list = ExcelImportUtil.importExcel(new File("d:/master.xls"),Master.class,params);
        System.out.println(JSON.toJSONString(list));
    }
    @Test
    public void  in1(){
        List<Master> list =masterService.findName();
        System.out.println(list);
    }*/
}