package com.example.jun_board.controller;

import com.example.jun_board.entity.Post;
import com.example.jun_board.repository.PostRepository;
import com.sun.tools.jconsole.JConsoleContext;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("board")
@RequiredArgsConstructor
public class PostController {

    private final PostRepository postRepository;    // autowired 필드형 주입 대신에 생성자로 주입

    @GetMapping("list")
    public List<Post> list() {
        List<Post> list = postRepository.findAll();
        System.out.println("Post 리스트를 조회하였습니다.");
        return list;
    }

    @PostMapping("register")
    public void register(Post post){

        System.out.println(post.getId()+" "+post.getTitle()+" "+post.getContent()+" "+post.getWritter()+" "+post.getWdate());

        System.out.println(post.getId()+" 번 아이디 정보를 등록하였습니다.");

        postRepository.save(post);

    }

    @PatchMapping("update/{id}")
    public void update(@PathVariable Long id, Post post){

        Post tmpPost = postRepository.findById(id)
                .orElseThrow();
        tmpPost.setTitle(post.getTitle());
        tmpPost.setContent(post.getContent());
        tmpPost.setWdate(LocalDateTime.now());

        System.out.println(id+" 번 아이디 정보를 수정하였습니다.");

        postRepository.save(tmpPost);

    }

    @DeleteMapping("delete/{id}")
    public void delete(@PathVariable Long id){

        System.out.println(id+" 번 아이디를 삭제하였습니다.");
        postRepository.deleteById(id);

    }


}
