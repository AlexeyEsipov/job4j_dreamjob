package ru.job4j.dream.controller;

import org.junit.Test;
import ru.job4j.dream.model.Post;
import ru.job4j.dream.store.DbStore;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PostServletTest {
    @Test
    public void whenCreatePost() throws IOException {
        HttpServletRequest req = mock(HttpServletRequest.class);
        HttpServletResponse resp = mock(HttpServletResponse.class);
        when(req.getParameter("id")).thenReturn("0");
        when(req.getParameter("name")).thenReturn("name of new post");
        when(req.getParameter("description")).thenReturn("d");
        new PostServlet().doPost(req, resp);
        Post post = DbStore.instOf().findPostById(1);
        assertThat(post, notNullValue());
    }

    @Test
    public void whenEditPost() throws IOException {
        HttpServletRequest req = mock(HttpServletRequest.class);
        HttpServletResponse res = mock(HttpServletResponse.class);
        DbStore.instOf().savePost(new Post(0, "New post"));
        when(req.getParameter("id")).thenReturn("1");
        when(req.getParameter("name")).thenReturn("Updated post");
        new PostServlet().doPost(req, res);
        Post post = DbStore.instOf().findPostById(1);
        assertThat(post.getName(), is("Updated post"));
    }
}