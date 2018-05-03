package com.cafe24.lms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cafe24.lms.domain.Item;
import com.cafe24.lms.domain.User;
import com.cafe24.lms.service.ItemService;
import com.cafe24.lms.service.RentService;
import com.cafe24.lms.service.ReserveService;
import com.cafe24.security.Auth;
import com.cafe24.security.Auth.Role;
import com.cafe24.security.AuthUser;

@Controller
public class MainController {
    @Autowired
    private ItemService itemService;
    @Autowired
    private RentService rentService;
    @Autowired
    private ReserveService reserveService;

    private static final int PAGE_SIZE = 3;
    private static final int ELEMENT_SIZE = 3;

    @RequestMapping( { "", "/main" } )
    public String index(
	    @PageableDefault( size = ELEMENT_SIZE, sort = { "no" }, direction = Direction.DESC ) Pageable pageable,
	    Model model ) {
	Page<Item> items = itemService.getItemList( pageable );
	int startPage = items.getNumber() - (items.getNumber() % PAGE_SIZE);
	int endPage = items.getNumber() + (PAGE_SIZE - (items.getNumber() % PAGE_SIZE));
	if( endPage >= items.getTotalPages() ){
	    endPage = items.getTotalPages();   
	}
	model.addAttribute( "items", items );
	model.addAttribute( "startPage", startPage);
	model.addAttribute( "endPage", endPage);
	model.addAttribute( "elementSize", ELEMENT_SIZE);
	model.addAttribute( "pageSize", PAGE_SIZE);
	return "main/index";
    }

    @Auth( role = Role.USER )
    @RequestMapping( "/rent/{path1}" )
    public String rent( @PathVariable( "path1" ) Long itemNo, @AuthUser User authUser, Model model ) {
	if ( !rentService.rent( itemNo, authUser.getNo() ) ) {
	    model.addAttribute( "message", "fail" );
	    return "main/rent";
	}
	model.addAttribute( "message", "success" );
	return "main/rent";
    }

    @Auth( role = Role.USER )
    @RequestMapping( "/reserve/{path1}" )
    public String reserve( @PathVariable( "path1" ) Long itemNo, @AuthUser User authUser, Model model ) {
	if ( !reserveService.reserve( itemNo, authUser.getNo() ) ) {
	    model.addAttribute( "message", "fail" );
	    return "main/rent";
	}
	model.addAttribute( "message", "success" );
	return "main/rent";
    }
    
}
