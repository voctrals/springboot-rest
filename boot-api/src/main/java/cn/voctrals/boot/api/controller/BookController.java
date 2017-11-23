package cn.voctrals.boot.api.controller;

import cn.voctrals.boot.api.model.ResultModel;
import cn.voctrals.boot.core.pagination.Pager;
import cn.voctrals.boot.service.BookService;
import cn.voctrals.boot.service.dto.BookDto;
import org.apache.oltu.oauth2.common.exception.OAuthProblemException;
import org.apache.oltu.oauth2.common.exception.OAuthSystemException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by liulei on 05/11/2016.
 */
@RestController
public class BookController extends RestBaseController {

    @Autowired
    private BookService bookService;

    @RequestMapping(value = "/books", method = RequestMethod.GET)
    public Object findAllBooks(HttpServletRequest request, @RequestParam(required = false) Integer page, @RequestParam(required = false) Integer limit) throws OAuthSystemException, OAuthProblemException {
        ResultModel result;

        BookDto bookDto = new BookDto();
        Pager pager = null;
        if (page != null && limit != null) {
            pager = new Pager(page, limit);
        }

        List<BookDto> lst = bookService.selectAllList(bookDto, pager);
        result = super.makeListResult(lst, pager);

        return result;
    }

    @RequestMapping(value = "/books/{id}", method = RequestMethod.GET)
    public Object findOneBook(@PathVariable("id") Long id) {
        ResultModel result;

        BookDto bookDto = new BookDto();
        bookDto.setId(id);

        BookDto book = bookService.selectByPrimaryKey(bookDto);
        result = super.makeOneResult(book);
        return result;
    }

    @RequestMapping(value = "/books", method = RequestMethod.POST)
    public void createBook(@RequestBody BookDto bookDto) {
        bookService.insert(bookDto, null);
    }

    @RequestMapping(value = "/books/{id}", method = RequestMethod.PUT)
    public void modifyBook(@RequestBody BookDto bookDto) {
        String s ="";
        //bookService.update(bookDto, null);
    }

    @RequestMapping(value = "/books/{id}", method = RequestMethod.DELETE)
    public void deleteBook(@PathVariable("id") Long id) {
        BookDto bookDto = new BookDto();
        bookDto.setId(id);
        bookService.delete(bookDto);
    }
}
