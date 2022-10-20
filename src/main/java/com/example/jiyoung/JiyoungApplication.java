package com.example.jiyoung;

import com.example.jiyoung.assignment1.MemberInterface;
import com.example.jiyoung.assignment1.MemberServiceImpl;
import com.example.jiyoung.study1.PrintObject;
import com.example.jiyoung.study1.Server;
import com.example.jiyoung.study1.User;
import com.example.jiyoung.study1.UserServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JiyoungApplication {

	public static void main(String[] args) {
		SpringApplication.run(JiyoungApplication.class, args);

		User user=new User(1, "양지영","서버");
		user.introduce();

		user.setName("양지용");
		user.setPart("섭어");

		user.introduce();

		UserServiceImpl userService=new UserServiceImpl();

		String club=userService.CLUB;
		System.out.println(club);

		userService.introduce("양지영",25, "infj");
		userService.getInfo(31, "서버");

		userService.getSopt();

		Server server=new Server("양지영","스프링스터디");
		String serverName=server.getName();
		String serverStudy=server.getStudy();
		System.out.println("이름은 "+serverName+", 스터디는 "+serverStudy);

		PrintObject<Integer> object1=new PrintObject<>(31);
		PrintObject<String> object2=new PrintObject<>("server");

		object1.printData();
		object2.printData();

		MemberServiceImpl memberService=new MemberServiceImpl();
		memberService.getMemberInfo(25, "동대문구");
		memberService.getIntro();
		memberService.join();

	}

}
