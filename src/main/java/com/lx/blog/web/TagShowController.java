package com.lx.blog.web;

import com.lx.blog.pojo.Tag;
import com.lx.blog.service.BlogService;
import com.lx.blog.service.TagService;
import com.lx.blog.vo.BlogQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class TagShowController {

    @Autowired
    private TagService tagService;

    private BlogService blogService;

    @GetMapping("/tags/{id}")
    public String tags(@PageableDefault(size=8,sort = {"updateTime"},direction = Sort.Direction.DESC) Pageable pageable,
                       Model model, @PathVariable Long id){
        List<Tag> tags=tagService.listTagTop(10);
        if(id==-1){
            id=tags.get(0).getId();
        }
        model.addAttribute("tags",tags);
        model.addAttribute("page",blogService.listBlog(id,pageable));
        model.addAttribute("activeid",id);
        return "tags";
    }
}
