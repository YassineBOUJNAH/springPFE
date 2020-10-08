package com.entreprise.projet.web;

import com.entreprise.projet.domain.*;
import net.bytebuddy.asm.Advice;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.util.Date;

@CrossOrigin("*")
@RestController
public class PostController  {

    private static final Logger logger = LoggerFactory.getLogger(PostController.class);

    @Autowired
    private PostRepository postRepository ;

    @Autowired
    private SupervisorRepo supervisorRepo ;


    @RequestMapping("/posts")
    public Iterable<Post> getAllPosts() {
        return postRepository.findAll();
    }

    @PostMapping(value = "/posts", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Post> addPost(@RequestParam("postedAt") String postedAt , @RequestParam("description") String description , @RequestParam("content") String content , @RequestParam("idsup") Long id_sup ,  @RequestParam(value = "file",required = false) MultipartFile file) throws IOException {

         Supervisor supervisor = supervisorRepo.findById(id_sup).orElseThrow(() -> new ResourceNotFoundException("Supervisor not found for this id :" + id_sup));
          Post p = new Post();
          p.setPostedAt(new Timestamp(new Date().getTime()));

          supervisor.setId(id_sup);
          p.setSupervisor(supervisor);
          p.setContent(content);
          p.setDescription(description);

          if (file != null) {
              String filename = StringUtils.cleanPath(file.getOriginalFilename());
              String filetype = file.getContentType();
              byte[] data = file.getBytes();
              FileStorage f = new FileStorage(filename,filetype,data);
              p.setFile(f);
          }

          postRepository.save(p);

         return ResponseEntity.ok(p);

    }

    @DeleteMapping("/posts/{id}")
    public void deletePostById( @PathVariable Long id){
        postRepository.deleteById(id);
    }

    @PutMapping("posts/{id}")
    public ResponseEntity<Post> updatePost( @RequestBody Post post  , @PathVariable Long id) throws ResourceNotFoundException {

        Post post1 = postRepository.findById(id)
                .orElseThrow( () -> new ResourceNotFoundException("Post not found for this id :" + id));

        post1.setId(id);
        post1.setDescription(post.getDescription());
        post1.setContent(post.getContent());

        final Post updatedpost = postRepository.save(post1);

         return ResponseEntity.ok(updatedpost);

    }

}
