package lms;

import static org.junit.Assert.*;

import javax.crypto.EncryptedPrivateKeyInfo;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cafe24.lms.domain.Album;
import com.cafe24.lms.domain.AlbumCategory;
import com.cafe24.lms.domain.Book;
import com.cafe24.lms.domain.BookCategory;
import com.cafe24.lms.domain.MovieCategory;
import com.cafe24.lms.domain.User;
import com.cafe24.lms.service.CategoryService;
import com.cafe24.lms.service.ItemService;
import com.cafe24.lms.service.ReserveService;
import com.cafe24.lms.service.UserService;
import com.cafe24.type.Gender;
import com.cafe24.util.EncryptPassword;

@ContextConfiguration( "classpath:applicationContext.xml" )
@RunWith( SpringJUnit4ClassRunner.class )
@FixMethodOrder( MethodSorters.NAME_ASCENDING )
public class TestReserve {
    @Autowired
    private UserService userService;
    @Autowired
    private ItemService itemService;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private ReserveService reserveService;

    @Test
    public void test01_init() {
	User user = new User();
	user.setName( "홍길동" );
	user.setEmail( "hong@a.com" );
	user.setPassword( "123" );
	user.setPhone( "010-1234-5678" );
	user.setGender( Gender.MALE );
	userService.joinUser( user );
	User user2 = new User();
	user2.setName( "홍ghdhd" );
	user2.setEmail( "hong@a.com" );
	user2.setPassword( "123" );
	user2.setPhone( "010-1234-5678" );
	user2.setGender( Gender.MALE );
	userService.joinUser( user2 );
	BookCategory bookCategory = new BookCategory();
	bookCategory.setName( "도서" );
	bookCategory.setSubName( "소설" );
	categoryService.saveCategory( bookCategory );
	MovieCategory movieCategory = new MovieCategory();
	movieCategory.setName( "DVD" );
	movieCategory.setSubName("영화");
	categoryService.saveCategory( movieCategory );
	AlbumCategory albumCategory = new AlbumCategory();
	albumCategory.setName( "음반" );
	albumCategory.setSubName( "락" );
	categoryService.saveCategory( albumCategory );
	Book book = new Book();
	book.setTitle( "나미아 잡화점의 기적" );
	book.setIsRent( true );
	itemService.saveItem( book, 1L );
	Album album = new Album();
	album.setTitle( "Tears" );
	album.setIsRent( true );
	album.setSinger( "소찬휘" );
	itemService.saveItem( album, 3L);
    }
    
    @Test
    public void test02_reserve() {
	assertTrue(reserveService.reserve(1L, 1L));
	assertTrue(reserveService.reserve(1L, 2L));
	assertTrue(reserveService.reserve(2L, 1L));
	System.out.println( EncryptPassword.encrypt( "123" ) );
    }
    
    
}
