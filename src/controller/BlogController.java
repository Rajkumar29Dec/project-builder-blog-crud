package controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Blog;
import model.User;
import service.CRUDOperations;
import service.ExcelFileStorage;
import utility.CheckBlogPost;


@WebServlet(urlPatterns= {"/blog"})
public class BlogController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public BlogController() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd=this.getServletContext().getRequestDispatcher("/WEB-INF/views/blogView.jsp");
		rd.forward(request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String blogDetails = request.getParameter("selectedAnswers");
		System.out.println(blogDetails);
		
		String[] userBlog=blogDetails.split(",");
		String title = userBlog[0];
		String description = userBlog[1];
		LocalDate postedOn = LocalDate.now();
		System.out.println(title);
		System.out.println(description);
		
		User user = null;
		Blog blog=new Blog(title,description,postedOn);
		System.out.println(title);
		System.out.println(description);
		
		blog.setBlogTitle(title);
		blog.setBlogDescription(description);
		blog.setDate(postedOn);
		
		CheckBlogPost checkBlog=new CheckBlogPost();
		boolean check=checkBlog.checkBlog(blog);
		
		CRUDOperations crud=new CRUDOperations();
		//List
		List<Blog> listblog = crud.createBlog(blog);
		listblog.sort((Blog s1,Blog  s2)->s1.getTitle().compareTo(s2.getTitle()));
		System.out.println(listblog);
		listblog.sort((Blog s1,Blog  s2)->s1.getDate().compareTo(s2.getDate()));
		System.out.println(listblog);
		//Map
		Map<String,Blog> mapblog = new TreeMap<String,Blog>();
		System.out.println(mapblog);
		//Set
		HashSet<Blog> blog1=new HashSet<TouristPlace>();
		TreeSet<Blog> set = new TreeSet<Blog>((o1, o2) -> o1.getTitle().compareTo(o2.getTitle()));
		for(Blog p:blog1)
		{
			set.add(p);
		}
		System.out.println(set);
		TreeSet<Blog> set1 = new TreeSet<Blog>((o1, o2) -> o1.getDate().compareTo(o2.getDate()));
		for(Blog p:blog1)
		{
			set1.add(p);
		}
		System.out.println(set1);
		if(check) {
			request.setAttribute("listBlog", listblog);
			request.setAttribute("blog", blog);
			request.setAttribute("user",user);
			RequestDispatcher rd=this.getServletContext().getRequestDispatcher("/WEB-INF/views/blogView.jsp");
			rd.forward(request, response);
		}
		else
		{
			request.setAttribute("message","Your blog contains offensive words. Please use appropriate words.");
			RequestDispatcher rd=this.getServletContext().getRequestDispatcher("/WEB-INF/views/blogView.jsp");
			rd.forward(request, response);
		}
		
	}

}