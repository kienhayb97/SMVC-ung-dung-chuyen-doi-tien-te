package Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

@Controller
public class DictionaryController {
    @GetMapping("/translate")
    public String translate(@RequestParam String englishWord, Model model){
        Map<String,String> dictionary=new HashMap<>();
        dictionary.put("hello", "Xin chào");
        dictionary.put("dog", "con cho");
        dictionary.put("computer", "may tinh");
        String vietnameseWord = dictionary.get(englishWord);
        if (vietnameseWord != null) {
            model.addAttribute("englishWord", englishWord);
            model.addAttribute("vietnameseWord", vietnameseWord);
        } else {
            vietnameseWord = "Not Found";
            model.addAttribute("englishWord", englishWord);
            model.addAttribute("vietnameseWord", vietnameseWord);
        }
        return "dictionary";
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }


}
