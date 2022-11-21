package platform;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CodeService {


    private final CodeRepository codeRepository;

    @Transactional
    public CodeContext getCodeAt(String UUID) {
        CodeContext currentCode = codeRepository.findById(UUID)
                .orElseThrow(CodeNotFoundException::new);
        if(currentCode.isRestrictionsOnTime() && currentCode.isRestrictionsOnViews()){
            if (currentCode.getTime() - currentCode.getSecondsOfExist() <= 0 || currentCode.getViews() == 0) {
                codeRepository.deleteById(UUID);
                throw new CodeNotFoundException();
            }
            this.updateTIme(currentCode);
            currentCode.setViews(currentCode.getViews() - 1);
            currentCode.setStart(Instant.now());
            return currentCode;
        }else if (currentCode.isRestrictionsOnTime()) {
            if (currentCode.getTime() - currentCode.getSecondsOfExist() <= 0) {
                codeRepository.deleteById(UUID);
                throw new CodeNotFoundException();
            }
            this.updateTIme(currentCode);
            currentCode.setStart(Instant.now());
            return currentCode;
        }
        else if (currentCode.isRestrictionsOnViews()) {
            if (currentCode.getViews() <= 0) {
                codeRepository.deleteById(UUID);
                throw new CodeNotFoundException();
            }
            currentCode.setViews(currentCode.getViews() - 1);
            return currentCode;
        }
        else {
            return currentCode;
        }
    }

    @Transactional
    public void updateTIme(CodeContext currentCode) {
        currentCode.setTime(currentCode.getTime() - currentCode.getSecondsOfExist());
    }

    public List<CodeContext> getLastTen() {
        return codeRepository.findTop10ByRestrictionsOnTimeAndRestrictionsOnViewsOrderByDateDesc(false, false);
    }

    public void saveCode(CodeContext code) {
        code.setDate(LocalDateTime.now());
        code.setRestrictionsOnTime(code.getTime() > 0);
        code.setRestrictionsOnViews(code.getViews() > 0);
        codeRepository.save(code);
    }
}
