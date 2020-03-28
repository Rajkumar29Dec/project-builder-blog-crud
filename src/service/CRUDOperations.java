package service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import model.Blog;

public class CRUDOperations {
	static List<Blog> list=new ArrayList<Blog>(); // Store the blog in the list
	
	public List<Blog> addBlog(Blog blog) throws IOException {
		list.add(blog);
	}
	
	public List<Blog> viewBlog(Blog blog) throws IOException{
		System.out.print(list);
		return list;
		
	}
	public List<Blog> updateBlog(Blog blog) throws IOException{
		return null;
	
	}
	public List<Blog> deleteBlog(Blog blog) throws IOException{
		return null;
		
	}
}