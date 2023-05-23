package am.itspace.healthcaremanagement.controller;

import am.itspace.healthcaremanagement.entity.User;
import am.itspace.healthcaremanagement.entity.type.UserType;
import am.itspace.healthcaremanagement.security.CurrentUser;
import am.itspace.healthcaremanagement.service.MainService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor
public class MainController {

    private final MainService MAIN_SERVICE;


    @GetMapping("/")
    public String main() {
        return "index";
    }

    @GetMapping(value = "/getImage", produces = MediaType.IMAGE_JPEG_VALUE)
    public @ResponseBody byte[] getImage(@RequestParam("profilePic") String profilePic) {
        return MAIN_SERVICE.getImage(profilePic);
    }

    @GetMapping("/customLogin")
    public String customLogin() {
        return "customLoginPage";
    }

    @GetMapping("/customSuccessLogin")
    public String customSuccessLogin(@AuthenticationPrincipal CurrentUser currentUser) {
        if (currentUser != null) {
            User user = currentUser.getUser();
            if (user.getUserType() == UserType.ADMIN) {
                return "redirect:/";
            } else if (user.getUserType() == UserType.USER) {
                return "redirect:/";

            }
        }
        return "redirect:/";
    }
}
