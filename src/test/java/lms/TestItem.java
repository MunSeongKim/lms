package lms;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cafe24.lms.domain.AlbumCategory;
import com.cafe24.lms.domain.Book;
import com.cafe24.lms.domain.BookCategory;
import com.cafe24.lms.domain.Item;
import com.cafe24.lms.domain.MovieCategory;
import com.cafe24.lms.service.CategoryService;
import com.cafe24.lms.service.ItemService;

@ContextConfiguration( "classpath:applicationContext.xml" )
@RunWith( SpringJUnit4ClassRunner.class )
@FixMethodOrder( MethodSorters.NAME_ASCENDING )
public class TestItem {

    @Autowired
    private ItemService itemService;
    @Autowired
    private CategoryService categoryService;
    
    @Before
    public void setUp() throws Exception {
	BookCategory bookCategory = new BookCategory();
	bookCategory.setName( "소설" );
	categoryService.saveCategory( bookCategory );
	MovieCategory movieCategory = new MovieCategory();
	movieCategory.setName("영화");
	categoryService.saveCategory( movieCategory );
	AlbumCategory albumCategory = new AlbumCategory();
	albumCategory.setName("가요");
	categoryService.saveCategory( albumCategory );
    }

    @Test
    public void test01_saveItem() {
	Book book = new Book();
	book.setTitle( "나미아 잡화점의 기적" );
	book.setIsRent( true );
	assertTrue(itemService.saveItem( book, 1L ));
    }
    
    @Ignore @Test
    public void test02_getItemList() {
	//List<Item> items = itemService.getItemList();
	//assertNotNull(items);
	//System.out.println( items );
    }
    
    @Test
    public void test03_rentItem() {
	assertTrue(itemService.rentItem( 1L ));
    }
}
