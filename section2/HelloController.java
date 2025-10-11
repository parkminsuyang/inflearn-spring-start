 @Controller
 public class HelloController {
    @GetMapping("hello") // http://localhost:8080/hello
    public String hello(Model model) {
        model.addAttribute("data", "hello!!");
         return "hello";
    }
 }
