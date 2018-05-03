package com.cafe24.lms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cafe24.lms.domain.Album;
import com.cafe24.lms.domain.AlbumCategory;
import com.cafe24.lms.domain.Book;
import com.cafe24.lms.domain.BookCategory;
import com.cafe24.lms.domain.Movie;
import com.cafe24.lms.domain.MovieCategory;
import com.cafe24.lms.domain.User;
import com.cafe24.lms.service.CategoryService;
import com.cafe24.lms.service.ItemService;
import com.cafe24.lms.service.UserService;
import com.cafe24.security.Auth;
import com.cafe24.type.Gender;

@Controller
public class InitController {
    @Autowired
    private UserService userService;
    @Autowired
    private ItemService itemService;
    @Autowired
    private CategoryService categoryService;
    
    @RequestMapping("/init")
    public String init() {
	// ADMIN user data
	User user = new User();
	user.setName( "관리자" );
	user.setEmail( "admin@lms.com" );
	user.setPassword( "admin" );
	user.setPhone( "010-1234-5678" );
	user.setGender( Gender.FEMALE );
	user.setRole(Auth.Role.ADMIN);
	userService.joinUser( user );
	User user2 = new User();
	user2.setName( "홍길동" );
	user2.setEmail( "hong@a.com" );
	user2.setPassword( "123" );
	user2.setPhone( "010-1111-1111" );
	user2.setGender( Gender.MALE );
	user2.setRole(Auth.Role.USER);
	userService.joinUser( user2 );
	User user3 = new User();
	user3.setName( "둘리" );
	user3.setEmail( "dooly@a.com" );
	user3.setPassword( "123" );
	user3.setPhone( "010-2222-2222" );
	user3.setGender( Gender.MALE );
	user3.setRole(Auth.Role.USER);
	userService.joinUser( user3 );
	
	// Book category data
	BookCategory bookCategory = new BookCategory();
	bookCategory.setName( "도서" );
	bookCategory.setSubName( "소설" );
	categoryService.saveCategory( bookCategory );
	BookCategory bookCategory2 = new BookCategory();
	bookCategory2.setName( "도서" );
	bookCategory2.setSubName( "시" );
	categoryService.saveCategory( bookCategory2 );
	BookCategory bookCategory3 = new BookCategory();
	bookCategory3.setName( "도서" );
	bookCategory3.setSubName( "에세이" );
	categoryService.saveCategory( bookCategory3 );
	
	// DVD category data
	MovieCategory movieCategory = new MovieCategory();
	movieCategory.setName( "DVD" );
	movieCategory.setSubName("영화");
	categoryService.saveCategory( movieCategory );
	MovieCategory movieCategory2 = new MovieCategory();
	movieCategory2.setName( "DVD" );
	movieCategory2.setSubName("드라마");
	categoryService.saveCategory( movieCategory2 );
	
	// Album category data
	AlbumCategory albumCategory = new AlbumCategory();
	albumCategory.setName( "음반" );
	albumCategory.setSubName( "가요" );
	categoryService.saveCategory( albumCategory );
	AlbumCategory albumCategory2 = new AlbumCategory();
	albumCategory2.setName( "음반" );
	albumCategory2.setSubName( "팝" );
	categoryService.saveCategory( albumCategory2 );
	
	// Book item data
	Book book = new Book();
	book.setTitle( "마당이 있는 집" );
	book.setIsRent( true );
	itemService.saveItem( book, 1L );
	Book book2 = new Book();
	book2.setTitle( "모든 순간이 너였다" );
	book2.setIsRent( true );
	itemService.saveItem( book2, 2L );
	Book book3 = new Book();
	book3.setTitle( "나는 나로 살기로 했다" );
	book3.setIsRent( true );
	itemService.saveItem( book3, 3L );
	
	// Movie item data
	Movie movie = new Movie();
	movie.setTitle( "어벤져스: 인피니티 워" );
	movie.setIsRent( true );
	itemService.saveItem( movie, 4L);
	Movie movie2 = new Movie();
	movie2.setTitle( "나의 아저씨" );
	movie2.setIsRent( true );
	itemService.saveItem( movie2, 5L);
	
	// Album item data
	Album album = new Album();
	album.setTitle( "Tears" );
	album.setIsRent( true );
	album.setSinger("소찬휘");
	itemService.saveItem( album, 6L);
	Album album2 = new Album();
	album2.setTitle( "벽지무늬" );
	album2.setIsRent( true );
	album2.setSinger("아이유");
	itemService.saveItem( album2, 6L);
	
	return "redirect:/";
    }
}
