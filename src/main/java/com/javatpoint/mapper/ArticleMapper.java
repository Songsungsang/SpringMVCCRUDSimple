package com.javatpoint.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import com.javatpoint.beans.article;

@Mapper
public interface ArticleMapper {
	@Insert("INSERT INTO article (id, head, context, date, views, likes, comments) " + 
			"VALUES (#{id}, #{head}, #{context}, #{date}, #{views}, #{likes}, #{comments})")
	int save(article p);
	
	@Select("SELECT * FROM article")
	List<article> getArticles();
	
	@Select("SELECT * FROM article WHERE id=#{id}")
	article getArticleById(int id);
	
	@Update("UPDATE article " +
			"SET id=#{id}, head=#{head}, context=#{context}, date=#{date}, views=#{views}, likes=#{likes}, comments=#{comments} " +
			"WHERE id = #{id}")
	int update(article p);
	
	@Delete("DELETE FROM article WHERE id=#{id}")
	int delete(int id);
}
