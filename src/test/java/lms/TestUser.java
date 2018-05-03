package lms;

import static org.junit.Assert.*;

import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cafe24.lms.domain.User;
import com.cafe24.lms.service.UserService;
import com.cafe24.type.Gender;

@ContextConfiguration( "classpath:applicationContext.xml" )
@RunWith( SpringJUnit4ClassRunner.class )
@FixMethodOrder( MethodSorters.NAME_ASCENDING )
public class TestUser {
    @Autowired
    private UserService userService;

    @Test
    public void test01_join() {
	User user = new User();
	user.setName( "홍길동" );
	user.setEmail( "hong@a.com" );
	user.setPassword( "123" );
	user.setPhone( "010-1234-5678" );
	user.setGender( Gender.MALE );
	userService.joinUser( user );
	assertNotNull( userService.getUser( "hong@a.com", "123" ) );
    }

    @Test
    public void test02_getUser() {
	User user = userService.getUser( "hong@a.com", "123" );
	System.out.println( user );
	assertNotNull( user );
    }

    @Test
    public void test03_getUserByNo() {
	User user = userService.getUser( 1L );
	assertNotNull( user );
	System.out.println( user );
    }
    
    @Test
    public void test04_modify() {
	User user = userService.getUser( 1L );
	user.setName( "홍금보" );
	System.out.println( user );
	assertNotNull(userService.modifyUser( user ));
    }
}