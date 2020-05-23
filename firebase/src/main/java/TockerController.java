import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TockerController {
    @PostMapping("/api/1/token")
    public String saveTocken() {
        return null;
    }
}
