package com.javatpoint.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.javatpoint.beans.article;

public class ArticleDao {
	JdbcTemplate template;  
	  
	public void setTemplate(JdbcTemplate template) {  
	    this.template = template;  
	}  

	public int save(article p) {  
	    String sql = "INSERT INTO article (id, head, context, date, views, likes, comments) VALUES (?, ?, ?, ?, ?, ?, ?)";
	    return template.update(sql, p.getId(), p.getHead(), p.getContext(), p.getDate(), p.getViews(), p.getLikes(), p.getComments());
	}
	
//	public int save(article p){  
//	    String sql="insert into article(id,head,context,date,view,like,comment) values('"+p.getHead()+"',"+p.getContext()+",'"+p.getDate()+"','"+p.getView()+"',"+p.getLike()+",'"+p.getComment()+"')";  
//	    return template.update(sql);  
//	}  
	public int update(article p) {  
	    String sql = "UPDATE article SET head=?, context=?, date=?, view=?, like_count=?, comment_count=? WHERE id=?";
	    return template.update(sql, p.getHead(), p.getContext(), p.getDate(), p.getViews(), p.getLikes(), p.getComments(), p.getId());
	}
	public int delete(int id){  
	    String sql="delete from article where id="+id+"";  
	    return template.update(sql);  
	}  
	public article getArticleById(int id){  
	    String sql="select * from article where id=?";  
	    return template.queryForObject(sql, new Object[]{id},new BeanPropertyRowMapper<article>(article.class));  
	}  
	public List<article> getArticles(){  
	    return template.query("select * from article",new RowMapper<article>(){  
	        public article mapRow(ResultSet rs, int row) throws SQLException {  
	            article a=new article();  
	            a.setId(rs.getInt(1));  
	            a.setHead(rs.getString(2));  
	            a.setContext(rs.getString(3));  
	            a.setDate(rs.getString(4));  
	            a.setViews(rs.getInt(5));  
	            a.setLikes(rs.getInt(6));  
	            a.setComments(rs.getInt(7));  
	            return a;  
	        }  
	    });  
	}  
	}  