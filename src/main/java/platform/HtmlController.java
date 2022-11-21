package platform;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@Controller
@RequiredArgsConstructor
public class HtmlController {

    private final CodeService codeService;

    @GetMapping(value = "/code/new")
    public String getNewCode() {
        return "postByWeb";
    }


    @GetMapping(path = "/code/{UUID}")
    public String getCodeInHtml(@PathVariable String UUID, Model model) {
        model.addAttribute("displayCode",codeService.getCodeAt(UUID));
        return "displayHtml";

    }

    @GetMapping(value = "/code/latest")
    public String getLatestHtml(Model model) {
        model.addAttribute("codesToDisplay", codeService.getLastTen());
        return "lastTenHtml";
    }
}
