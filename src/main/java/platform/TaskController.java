package platform;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequiredArgsConstructor
public class TaskController {

   private final
    CodeService codeService;


    @PostMapping("/api/code/new")//work
    public String newCode(@RequestBody CodeContext code) {
        code.setIdUUID();
        codeService.saveCode(code);
        return "{ \"id\" : \"" +code.getId()  + "\"}";
    }


    @GetMapping("/api/code/{UUID}")//work
    public CodeContext getCodeInJson(@PathVariable String UUID) {
        return codeService.getCodeAt(UUID);
    }


    @GetMapping("/api/code/latest")//work
    public List<CodeContext> getLatestJson() {
        return codeService.getLastTen();
    }


}