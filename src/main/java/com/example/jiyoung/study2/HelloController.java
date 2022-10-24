package com.example.jiyoung.study2;

import org.springframework.web.bind.annotation.*;

@RestController
//@RequestMapping(method= RequestMethod.GET, value="study") //GetMapping과 똑같음, 클래스 위에 넣기

public class HelloController {

    @GetMapping("/hello")
    public String Hello() {
        return "hi";
    }

    @GetMapping("name/{name}")
    public String getName(@PathVariable(value = "name") final String name,
                          @PathVariable(value = "type") final String type) {
        return "파트는 " + name + ", 타입은 " + type;
    }

    @GetMapping("/sopt")
    public String getPart(@RequestParam(value = "part", defaultValue = "") final String part) {
        return part;
    }

    @PostMapping("member")
    public String postMember(@RequestBody final Member member) {
        return member.getName();
    }

    @PutMapping("member")
    public String putMember(@RequestBody final Member member) {
        return member.getName();
    }


}
