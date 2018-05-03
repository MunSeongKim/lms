package lms;

import java.util.List;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.cafe24.lms.domain.AlbumCategory;
import com.cafe24.lms.domain.BookCategory;
import com.cafe24.lms.domain.Category;
import com.cafe24.lms.domain.MovieCategory;
import com.cafe24.lms.service.CategoryService;

import junit.framework.TestCase;

@ContextConfiguration( "classpath:applicationContext.xml" )
@RunWith( SpringJUnit4ClassRunner.class )
@FixMethodOrder( MethodSorters.NAME_ASCENDING )
public class TestCategory extends TestCase {

    @Autowired
    private CategoryService categoryService;

    @Test
    public void test01_newCategory() {
	BookCategory bookCategory = new BookCategory();
	bookCategory.setName( "소설" );
	assertTrue(categoryService.saveCategory( bookCategory ));
	MovieCategory movieCategory = new MovieCategory();
	movieCategory.setName("영화");
	assertTrue(categoryService.saveCategory( movieCategory ));
	AlbumCategory albumCategory = new AlbumCategory();
	albumCategory.setName("가요");
	assertTrue(categoryService.saveCategory( albumCategory ));
    }

    @Test
    @Transactional
    public void test02_getCategoryList() {
	List<Category> categories = categoryService.getCategoryList();
	assertNotNull(categories);
	System.out.println( categories );
    }

}
