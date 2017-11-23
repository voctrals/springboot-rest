package cn.voctrals.boot.service;


import cn.voctrals.boot.core.pagination.Pager;
import cn.voctrals.boot.core.util.BeanMapper;
import cn.voctrals.boot.dao.BookDao;
import cn.voctrals.boot.dao.entity.Book;
import cn.voctrals.boot.service.dto.BookDto;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookDao bookDao;

    public List<BookDto> selectAllList(BookDto bookDto) {
        Book model = BeanMapper.map(bookDto, Book.class);
        List<Book> lst = bookDao.selectAllList(model);
        return BeanMapper.mapList(lst, BookDto.class);
    }

    public List<BookDto> selectAllList(BookDto bookDto, Pager pager) {
        Book entity = BeanMapper.map(bookDto, Book.class);
        List<Book> lst = null;
        if (pager == null) {
            lst = bookDao.selectAllList(entity);
        } else {
            lst = bookDao.selectAllList(entity, new PageBounds(pager.page, pager.limit));
            pager.paginator = ((PageList<Book>)lst).getPaginator();
        }
        return BeanMapper.mapList(lst, BookDto.class);
    }

    @Transactional
    public int insert(BookDto bookDto, BindingResult bindingResult) {
        Book model = BeanMapper.map(bookDto, Book.class);

        Book result = bookDao.selectByPrimaryKey(model);
            if (result != null) {
            //throw new AppException("", "common.message.error.dataexist", bindingResult);
            }

        return bookDao.insert(model);
    }

    @Transactional
    public void update(BookDto bookDto, BindingResult bindingResult) {
        Book model = BeanMapper.map(bookDto, Book.class);

        bookDao.updateByPrimaryKey(model);
    }

    @Transactional
    public void delete(BookDto bookDto) {
        Book model = BeanMapper.map(bookDto, Book.class);
        bookDao.deleteByPrimaryKey(model);
    }

    public BookDto selectByPrimaryKey(BookDto bookDto) {
        Book model = BeanMapper.map(bookDto, Book.class);
        Book result = bookDao.selectByPrimaryKey(model);

        return BeanMapper.map(result, BookDto.class);
    }

}
