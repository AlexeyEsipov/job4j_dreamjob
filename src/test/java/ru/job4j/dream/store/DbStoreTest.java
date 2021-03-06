package ru.job4j.dream.store;
import org.junit.Ignore;
import org.junit.Test;
import ru.job4j.dream.model.Candidate;
import ru.job4j.dream.model.Post;
import ru.job4j.dream.model.User;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.core.IsNull.nullValue;

public class DbStoreTest {

    @Ignore
    @Test
    public void whenCreatePost() {
        Store store = DbStore.instOf();
        Post post = new Post(0, "Java Job");
        store.savePost(post);
        Post postInDb = store.findPostById(post.getId());
        assertThat(postInDb.getName(), is(post.getName()));
    }

    @Ignore
    @Test
    public void whenUpdatePost() {
        Store store = DbStore.instOf();
        Post post = new Post(0, "Java Job");
        store.savePost(post);
        post.setName("Java Job Updated");
        store.savePost(post);
        Post postInDb = store.findPostById(post.getId());
        assertThat(postInDb.getName(), is("Java Job Updated"));
    }

    @Test
    public void whenCreateCandidate() {
        Store store = DbStore.instOf();
        Candidate candidate = new Candidate(0, "Java Junior", 1);
        store.saveCandidate(candidate);
        Candidate candidateInDb = store.findCandidateById(candidate.getId());
        assertThat(candidateInDb.getName(), is(candidate.getName()));
    }

    @Test
    public void whenUpdateCandidate() {
        Store store = DbStore.instOf();
        Candidate candidate = new Candidate(0, "Java Junior", 1);
        store.saveCandidate(candidate);
        candidate.setName("Java Middle");
        store.saveCandidate(candidate);
        Candidate candidateInDb = store.findCandidateById(candidate.getId());
        assertThat(candidateInDb.getName(), is("Java Middle"));
    }

    @Test
    public void whenDeleteCandidate() {
        Store store = DbStore.instOf();
        Candidate candidate = new Candidate(0, "Java Junior", 1);
        store.saveCandidate(candidate);
        Candidate candidateInDb = store.findCandidateById(candidate.getId());
        store.deleteCandidate(candidateInDb.getId());
        assertThat(store.findCandidateById(candidateInDb.getId()), is(nullValue()));
    }

    @Test
    public void whenCreateUser() {
        Store store = DbStore.instOf();
        User user = new User(0, "Bob", "bob@mail.com", "");
        store.saveUser(user);
        User userInDb = store.findUserById(user.getId());
        assertThat(userInDb.getName(), is(user.getName()));
    }

    @Test
    public void whenFindUserByEmail() {
        Store store = DbStore.instOf();
        User user1 = new User(0, "Alex", "alex@mail.com", "");
        store.saveUser(user1);
        User user2 = new User(0, "Jim", "jim@mail.com", "");
        store.saveUser(user2);
        User userInDb = store.findUserByEmail(user2.getEmail());
        assertThat(userInDb.getEmail(), is(user2.getEmail()));
    }

    @Test
    public void whenDeleteUser() {
        Store store = DbStore.instOf();
        User user = new User(0, "Sam", "sam@mail.com", "");
        store.saveUser(user);
        store.deleteUser(user.getId());
        assertThat(store.findUserById(user.getId()), is(nullValue()));
    }
}