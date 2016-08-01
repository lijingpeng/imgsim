package org.lijingpeng.algorithm.image.web;

import org.lijingpeng.algorithm.image.api.service.ImageSimilarityService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by frank on 16/8/1.
 */
@Controller
@RequestMapping("/home")
public class HomeController {

    @Resource(name = "imageSimilarityService")
    private ImageSimilarityService imageSimilarityService;

    @RequestMapping(method = RequestMethod.GET)
    public String imgsimService(HttpServletRequest request, ModelMap model) {
        String url1 = request.getParameter("url1");
        String url2 = request.getParameter("url2");
        try {
            String hash1 = imageSimilarityService.getImagePHashFromURL(url1);
            String hash2 = imageSimilarityService.getImagePHashFromURL(url2);
            Integer dis1 = imageSimilarityService.getImageSimilarityDistance(url1, url2);

            model.addAttribute("url1", url1);
            model.addAttribute("url2", url2);
            model.addAttribute("url1_hash", hash1);
            model.addAttribute("url2_hash", hash2);

            model.addAttribute("message1", dis1);
        } catch (Exception e) {
            // do nothing
        }

        return "home";
    }
}
