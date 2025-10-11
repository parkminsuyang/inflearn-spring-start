package hello.hello_spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("hello")
    public String hello(Model model){
        model.addAttribute("data", "hello!");;
        return "hello";
    }
    @GetMapping("hello-mvc") // http://localhost:8080/hello-mvc
    public String helloMvc(@RequestParam ("name") String name, Model model){
        model.addAttribute("name", name); // http://localhost:8080/hello-mvc?name=spring
        return "hello-template";
    }

    @GetMapping("hello-string")
    @ResponseBody // viewResolver 사용하지 않고 http body에 직접 반환
    public String helloString(@RequestParam ("name") String name){
        return "hello "+name; //"hello spring"
    }

    @GetMapping("hello-api")
    @ResponseBody // JSON으로 반환
    public Hello helloApi(@RequestParam("name") String name){
        Hello hello = new Hello();
        hello.setName(name);
        return hello; // hello 객체 반환 -> HttpMessageConverter 작동, JSON형식으로 반환
    }

    static class Hello{
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
