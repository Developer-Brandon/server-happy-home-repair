package com.dkstudio.happyhomerepair.service;

import com.dkstudio.happyhomerepair.model.entity.BlogPost;
import com.dkstudio.happyhomerepair.repository.BlogPostRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;


@RunWith(SpringRunner.class)
public class BlogPostServiceTests {

    private BlogPostService blogPostService;

    @Mock
    private BlogPostRepository blogPostRepository;

    @Before
    public void 초기화() {
        MockitoAnnotations.initMocks(this);
        blogPostService = new BlogPostService(blogPostRepository);
    }

    @Test
    public void 블로그_포스트_개별_생성() {
        BlogPost mockBlogPost = BlogPost.builder()
                .id(0L)
                .title("현관의 삼연동 중문수리, 삼중문 수리 작업")
                .thumbnailImageUrl("https://blogthumb.pstatic.net/MjAyMDA4MDdfMTY3/MDAxNTk2Nzg4NjIyMTM4.PJ9jgg05AmJh9PWIBAXPBm7smunuHkAq2Quj8AskKbYg.NjfpRIcmNRFivzuWENlpyFAa6wh5q33OSBKuhuoRT38g.JPEG.lain4444/20200806_154153.jpg?type=s2")
                .targetUrl("https://blog.naver.com/PostView.nhn?blogId=lain4444&logNo=222054100175&redirect=Dlog")
                .build();

        given(blogPostRepository.save(any())).willReturn(mockBlogPost);

        BlogPost savedBlogPost = blogPostService.createBlogPost(mockBlogPost);

        assertThat(savedBlogPost.getTitle(), is(mockBlogPost.getTitle()));
        assertThat(savedBlogPost.getThumbnailImageUrl(), is(mockBlogPost.getThumbnailImageUrl()));
        assertThat(savedBlogPost.getTargetUrl(), is(mockBlogPost.getTargetUrl()));
    }

    @Test
    public void 블로그_포스트_일괄_생성() {
        BlogPost mockBlogPost = BlogPost.builder()
                .id(0L)
                .title("현관의 삼연동 중문수리, 삼중문 수리 작업")
                .thumbnailImageUrl("https://blogthumb.pstatic.net/MjAyMDA4MDdfMTY3/MDAxNTk2Nzg4NjIyMTM4.PJ9jgg05AmJh9PWIBAXPBm7smunuHkAq2Quj8AskKbYg.NjfpRIcmNRFivzuWENlpyFAa6wh5q33OSBKuhuoRT38g.JPEG.lain4444/20200806_154153.jpg?type=s2")
                .targetUrl("https://blog.naver.com/PostView.nhn?blogId=lain4444&logNo=222054100175&redirect=Dlog")
                .build();

        BlogPost mockBlogPost2 = BlogPost.builder()
                .id(1L)
                .title("현관의 삼연동 중문수리, 삼중문 수리 작업")
                .thumbnailImageUrl("https://blogthumb.pstatic.net/MjAyMDA4MDdfMTY3/MDAxNTk2Nzg4NjIyMTM4.PJ9jgg05AmJh9PWIBAXPBm7smunuHkAq2Quj8AskKbYg.NjfpRIcmNRFivzuWENlpyFAa6wh5q33OSBKuhuoRT38g.JPEG.lain4444/20200806_154153.jpg?type=s2")
                .targetUrl("https://blog.naver.com/PostView.nhn?blogId=lain4444&logNo=222054100175&redirect=Dlog")
                .build();

        List<BlogPost> blogPostList = new ArrayList<>();
        blogPostList.add(mockBlogPost);
        blogPostList.add(mockBlogPost2);

        blogPostService.createBlogPostList(blogPostList);

        verify(blogPostRepository, times(2)).save(any());
    }
//
//    @Test
//    public void 블로그_포스트_일괄_조회() {}
//
//    @Test
//    public void 블로그_포스트_개별_수정() {}
//
//    @Test
//    public void 블로그_포스트_개별_삭제() {}
}