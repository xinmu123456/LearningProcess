package com.xinmu.servlet;

import com.alibaba.fastjson.JSONArray;
import com.mysql.jdbc.StringUtils;
import com.xinmu.pojo.Role;
import com.xinmu.pojo.User;
import com.xinmu.service.role.RoleService;
import com.xinmu.service.role.RoleServiceImpl;
import com.xinmu.service.user.UserService;
import com.xinmu.service.user.UserServiceImpl;
import com.xinmu.util.Constants;
import com.xinmu.util.PageSupport;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;

/**
 * author: xinmu
 * date: 2022/3/25
 * time: 19:37
 */

//实现servlet的复用
public class UserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String method = req.getParameter("method");
        if (method!=null&&method.equals("savepwd")){
            this.updatePwd(req, resp);
        }else if (method!=null&&method.equals("pwdmodify")){
            this.pwdModify(req, resp);
        }else if (method!=null&&method.equals("query")){
            this.query(req, resp);
        }
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    //修改密码
    public void updatePwd(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //从session中拿到id
        Object o = req.getSession().getAttribute(Constants.USER_SESSION);
        String newpassword = req.getParameter("newpassword");
        boolean flag=false;

        if (o!=null && !StringUtils.isNullOrEmpty(newpassword)&&newpassword.length()!=0){
            UserService userService=new UserServiceImpl();
            flag = userService.updatePwd(((User) o).getId(), newpassword);
            if (flag){
                req.setAttribute("message","修改密码成功,请退出,请使用新密码登录");
                //密码修改成功后移除当前的session
                req.getSession().removeAttribute(Constants.USER_SESSION);
                //resp.sendRedirect("login.jsp");
            }else{
                req.setAttribute("message","密码修改失败");
            }
        }else{
            req.setAttribute("message","新密码修改有问题");
        }

        req.getRequestDispatcher("pwdmodify.jsp").forward(req,resp);
    }

    //验证旧密码,在session中有用户的密码
    public void pwdModify(HttpServletRequest req, HttpServletResponse resp){
        Object o = req.getSession().getAttribute(Constants.USER_SESSION);
        String oldpassword = req.getParameter("oldpassword");

        //万能的map
        HashMap<String, String> resultMap = new HashMap<String, String>();
        if (o==null){//session失效了,session过期了
            System.out.println("session已过期");
            resultMap.put("result","sessionerror");
        }else if (StringUtils.isNullOrEmpty(oldpassword)){//输入密码为空
            resultMap.put("result","error");
        }else {
            String userPassword = ((User) o).getUserPassword();
            if (oldpassword.equals(userPassword)){
                resultMap.put("result","true");
            }else{
                resultMap.put("result","false");
            }
        }

        try {
            resp.setContentType("application/json");
            PrintWriter writer = resp.getWriter();
            //jsonarray 阿里巴巴的接送工具类,转化格式的
            writer.write(JSONArray.toJSONString(resultMap));
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    /*
    //重难点
   public void query(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        //查询用户列表

        //从前端获得数据
        String queryUserName=req.getParameter("queryname");
        String temp=req.getParameter("queryUserRole");
        String pageIndex=req.getParameter("pageIndex");
        int queryUserRole=0;

        //获取用户列表
        UserServiceImpl userService = new UserServiceImpl();
        List<User> userList=null;


        //在第一次走这个请求,一定是第一页,并且页面大小是固定的
        int pageSize=5; //可以将它写在配置文件中,方便后期修改
        int currentPageNo=1;

        if(queryUserName==null){
            queryUserName ="";
        }
        if(temp!=null&&!temp.equals("")){
            queryUserRole=Integer.getInteger(temp);//给查询赋值! 0,1,2,3
        }

        if (pageIndex!=null){
               currentPageNo=Integer.parseInt(pageIndex);
        }

        //获取用户的总数(分页:上一页,下一页)
        int totalCount = userService.getUserCount(queryUserName, queryUserRole);

        //总页数支持
        PageSupport pageSupport=new PageSupport();
        pageSupport.setCurrentPageNo(currentPageNo);
        pageSupport.setPageSize(pageSize);
        pageSupport.setTotalPageCount(totalCount);

        int totalPageCount=((int)(totalCount/pageSize))+1;



        //控制首页和尾页
        //如果页面要小于1了就显示第一页的大小
        if (totalPageCount<1){
            currentPageNo = 1;
        }else if(currentPageNo>totalPageCount) {//当前页面大于了最后一页
            currentPageNo=totalPageCount;
        }

        //获取用户列表的展示
        userList = userService.getUserList(queryUserName, queryUserRole, currentPageNo, pageSize);
        req.setAttribute("userList",userList);

        RoleServiceImpl roleService = new RoleServiceImpl();
        List<Role> roleList = roleService.getRoleList();
        req.setAttribute("roleList",roleList);
        req.setAttribute("totalCount",totalCount);
        req.setAttribute("currentPageNo",currentPageNo);
        req.setAttribute("totalPageCount",totalPageCount);
        req.setAttribute("queryUserName",queryUserName);
        req.setAttribute("queryUserRole",queryUserRole);

        req.setAttribute("userList",userList);
        req.setAttribute("roleList",roleList);
        req.setAttribute("queryUserName", queryUserName);
        req.setAttribute("queryUserRole", queryUserRole);
        req.setAttribute("totalPageCount", totalPageCount);
        req.setAttribute("totalCount", totalCount);
        req.setAttribute("currentPageNo", currentPageNo);

        System.out.println("currentpage-->"+currentPageNo);
        System.out.println("total--->"+totalCount);


        //返回前端
        try {
            req.getRequestDispatcher("userlist.jsp").forward(req,resp);
        } catch (ServletException e) {
            e.printStackTrace();
        }

    }*/


    //用户管理模块页面查询
    //怎么处理

    private  void query(HttpServletRequest req,HttpServletResponse resp) throws ServletException,IOException{
        //接收前端传来的参数
        String queryUserName = req.getParameter("queryname");
        String temp = req.getParameter("queryUserRole");//从前端传回来的用户角色码不知是否为空或者是有效角色码，所以暂存起来
        String pageIndex = req.getParameter("pageIndex");
        int queryUserRole=0;

        //通过UserServiceImpl得到用户列表,用户数
        UserServiceImpl userService = new UserServiceImpl();
        //通过RoleServiceImpl得到角色表
        RoleService roleService = new RoleServiceImpl();
        List<User> userList=null;//用来存储用户列表
        List<Role> roleList=null;//用来存储角色表
        //设置每页显示的页面容量
        int pageSize=Constants.pageSize;
        //设置当前的默认页码
        int currentPageNo=1;
        //输出控制台，显示参数的当前值
        System.out.println("queryUserName servlet--------"+queryUserName);
        System.out.println("queryUserRole servlet--------"+queryUserRole);
        System.out.println("query pageIndex--------- > " + pageIndex);

        //前端传来的参数若不符合查询sql语句，即如果用户不进行设置，值为空会影响sql查询，需要给它们进行一些约束
        if(queryUserName==null){//这里为空，说明用户没有输入要查询的用户名，则sql语句传值为""，%%，会查询所有记录
            queryUserName="";
        }
        if(temp!=null && !temp.equals("")){
            //不为空，说明前端有传来的用户所设置的userCode，更新真正的角色码
            queryUserRole=Integer.parseInt(temp);//强制转换，前端传递的参数都是默认字符串，要转成int类型
        }

        if(pageIndex!=null){//说明当前用户有进行设置跳转页面
            currentPageNo=Integer.valueOf(pageIndex);
        }

        //有了用户名和用户角色后可以开始查询了，所以需要显示当前查询到的总记录条数
        int totalCount = userService.getUserCount(queryUserName, queryUserRole);
        //根据总记录条数以及当前每页的页面容量可以算出，一共有几页，以及最后一页的显示条数
        PageSupport pageSupport = new PageSupport();
        pageSupport.setCurrentPageNo(currentPageNo);
        pageSupport.setPageSize(pageSize);
        pageSupport.setTotalCount(totalCount);
        //可显示的总页数
        int totalPageCount=pageSupport.getTotalPageCount();

        //约束首位页，即防止用户输入的页面索引小于1或者大于总页数
        if(currentPageNo<1){
            currentPageNo=1;
        }else if(currentPageNo>totalPageCount){
            currentPageNo=totalPageCount;
        }
        //有了，待查询条件，当前页码，以及每页的页面容量后，就可以给出每页的具体显示情况了
        userList = userService.getUserList(queryUserName, queryUserRole, currentPageNo, pageSize);
        roleList = roleService.getRoleList();
        //得到了用户表与角色表以及各种经过处理后的参数，都存进req中
        req.setAttribute("userList",userList);
        req.setAttribute("roleList",roleList);
        req.setAttribute("queryUserName", queryUserName);
        req.setAttribute("queryUserRole", queryUserRole);
        req.setAttribute("totalPageCount", totalPageCount);
        req.setAttribute("totalCount", totalCount);
        req.setAttribute("currentPageNo", currentPageNo);
        //将所得到的的所有req参数送回给前端
        req.getRequestDispatcher("userlist.jsp").forward(req,resp);

    }

}
