package cn.voctrals.boot.core.pagination;

import cn.voctrals.boot.util.Constants;
import com.github.miemiedev.mybatis.paginator.domain.Paginator;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;

public class Pager implements Serializable {
    
	private static final long serialVersionUID = 1L;
    
    public int page = 1;
    
    public int limit = Constants.PAGE_LIMIT;
    
    public Paginator paginator;
    
    public Pager() {
        
    }

    public Pager(int page, int limit) {
        this.page = page;
        this.limit = limit;
    }

    @Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
    
}
