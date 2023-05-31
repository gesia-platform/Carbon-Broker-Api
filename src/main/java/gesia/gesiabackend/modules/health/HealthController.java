package gesia.gesiabackend.modules.health;

import gesia.gesiabackend.modules.common.dto.ResultResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static gesia.gesiabackend.modules.common.Const.SUCCESS;
import static gesia.gesiabackend.modules.common.Const.SUCCESS_MSG;

@RestController
@RequestMapping("/health")
public class HealthController {
    @GetMapping("/check")
    public ResultResponse checkHealth() {
        return ResultResponse.result(SUCCESS, SUCCESS_MSG);
    }
}