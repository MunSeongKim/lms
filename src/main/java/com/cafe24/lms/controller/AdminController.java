package com.cafe24.lms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cafe24.lms.domain.Rent;
import com.cafe24.lms.domain.Reserve;
import com.cafe24.lms.service.RentService;
import com.cafe24.lms.service.ReserveService;
import com.cafe24.security.Auth;

@Controller
@RequestMapping( "/admin" )
public class AdminController {
    @Autowired
    private RentService rentService;
    @Autowired
    private ReserveService reserveService;
    
    private static final int PAGE_SIZE = 2;
    private static final int ELEMENT_SIZE = 3;
    
    @Auth(role=Auth.Role.ADMIN)
    @RequestMapping( { "", "/rent", "/main" } )
    public String main( @PageableDefault( size = ELEMENT_SIZE, sort = { "no" }, direction = Direction.DESC ) Pageable pageable, Model model ) {
	Page<Rent> rents = rentService.getRentList(pageable);
	model.addAttribute("rents", rents);
	int startPage = rents.getNumber() - (rents.getNumber() % PAGE_SIZE);
	int endPage = rents.getNumber() + (PAGE_SIZE - (rents.getNumber() % PAGE_SIZE));
	if( endPage >= rents.getTotalPages() ){
	    endPage = rents.getTotalPages();   
	}
	model.addAttribute( "startPage", startPage);
	model.addAttribute( "endPage", endPage);
	model.addAttribute( "elementSize", ELEMENT_SIZE);
	model.addAttribute( "pageSize", PAGE_SIZE);
	return "admin/rent";
    }

    @Auth(role=Auth.Role.ADMIN)
    @RequestMapping( "/reserve" )
    public String reserve(@PageableDefault( size = ELEMENT_SIZE ) Pageable pageable, Model model) {
	Page<Reserve> reserves = reserveService.getReserveList(pageable);
	model.addAttribute("reserves", reserves);
	int startPage = reserves.getNumber() - (reserves.getNumber() % PAGE_SIZE);
	int endPage = reserves.getNumber() + (PAGE_SIZE - (reserves.getNumber() % PAGE_SIZE));
	if( endPage >= reserves.getTotalPages() ){
	    endPage = reserves.getTotalPages();   
	}
	model.addAttribute( "startPage", startPage);
	model.addAttribute( "endPage", endPage);
	model.addAttribute( "elementSize", ELEMENT_SIZE);
	model.addAttribute( "pageSize", PAGE_SIZE);
	return "admin/reserve";
    }

}
