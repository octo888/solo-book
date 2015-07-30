package com.book.service;

import com.book.entity.*;
import com.book.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.*;


@Transactional
@Service
public class InitDBService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private BlogRepository blogRepository;

    @Autowired
    private TopListRepository topListRepository;

    @Autowired
    private NewsBlogService newsBlogService;

    @PostConstruct
    public void init() {
        if (roleRepository.findByName("ROLE_ADMIN") == null) {
            Role roleUser = new Role();
            roleUser.setName("ROLE_USER");
            roleRepository.save(roleUser);

            Role roleAdmin = new Role();
            roleAdmin.setName("ROLE_ADMIN");
            roleRepository.save(roleAdmin);

            User userAdmin = new User();
            userAdmin.setEnabled(true);
            userAdmin.setName("admin");
            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
            userAdmin.setPassword(encoder.encode("admin"));
            List<Role> roles = new ArrayList<>();
            roles.add(roleAdmin);
            roles.add(roleUser);
            userAdmin.setRoles(roles);
            userRepository.save(userAdmin);

            User testUser = new User();
            testUser.setEnabled(true);
            testUser.setName("test");
            BCryptPasswordEncoder encoder1 = new BCryptPasswordEncoder();
            testUser.setPassword(encoder1.encode("test"));
            List<Role> rolesTest = new ArrayList<>();
            rolesTest.add(roleUser);
            testUser.setRoles(rolesTest);
            userRepository.save(testUser);

            Category classic = new Category("Классика", "classic");
            categoryRepository.save(classic);

            Category modern = new Category("Современная проза", "modern");
            categoryRepository.save(modern);

            Category ukr = new Category("Украинская проза", "ukr");
            categoryRepository.save(ukr);

            Category love = new Category("Сентиментальный роман", "love");
            categoryRepository.save(love);

            Category fantastic = new Category("Фантастика", "fantastic");
            categoryRepository.save(fantastic);

            Category detective = new Category("Детектив", "detective");
            categoryRepository.save(detective);

            Category thriller = new Category("Триллер/Мистика", "thriller");
            categoryRepository.save(thriller);

            Category business = new Category("Бизнес", "business");
            categoryRepository.save(business);

            Category psycho = new Category("Психология", "psycho");
            categoryRepository.save(psycho);

            Category history = new Category("История/Политика", "history");
            categoryRepository.save(history);

            Category philosophy = new Category("Философия", "philosophy");
            categoryRepository.save(philosophy);

            Category memoirs = new Category("Мемуары", "memoirs");
            categoryRepository.save(memoirs);

            TopList topmonth = new TopList("ТОП Месяца", "topmonth");
            topListRepository.save(topmonth);

            NewsBlog bookNews = new NewsBlog();
            bookNews.setName("BooksFreeCom");
            bookNews
                    .setUrl("http://www.booksfree.com/rss/NewReleasesBooks.xml");
            newsBlogService.save(bookNews);
        }

    }
}
