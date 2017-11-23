package cn.voctrals.boot.dao;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;

import java.io.Serializable;
import java.util.List;

public interface BaseMasterDao<T, PK extends Serializable> {
	
	List<T> selectAllList(T record);
	
	List<T> selectAllList(T record, PageBounds pageBounds);
	
	T selectByPrimaryKey(PK id);
	
	int insert(T record);
	
	int updateByPrimaryKey(T record);

	int updateByPrimaryKeySelective(T record);
	
    int deleteByPrimaryKey(PK id);

	int insertList(List<T> list);
    
}
