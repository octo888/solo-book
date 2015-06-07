package com.book.service;

import com.book.entity.*;
import com.book.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;


@Transactional
@Service
public class InitDBService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private ImageRepository imageRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CategoryRepository categoryRepository;

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
            userAdmin.setName("admin");
            List<Role> roles = new ArrayList<>();
            roles.add(roleAdmin);
            roles.add(roleUser);
            userAdmin.setRoles(roles);
            userRepository.save(userAdmin);

            Category classic = new Category();
            classic.setName("Классика");
            classic.setTitle("classic");
            categoryRepository.save(classic);

            Category modern = new Category();
            modern.setName("Модерн");
            modern.setTitle("modern");
            categoryRepository.save(modern);

            Category fantastic = new Category();
            fantastic.setName("Фантастика");
            fantastic.setTitle("fantastic");
            categoryRepository.save(fantastic);

            Category detective = new Category();
            detective.setName("Детектив");
            detective.setTitle("detective");
            categoryRepository.save(detective);

            Book book1 = new Book();
            book1.setName("Игра Престолов");
            book1.setAuthorName("Джордж Мартин");
            book1.setCategory(fantastic);
            book1.setDescription("Первая часть саги 'Песнь Льда и Пламени'");
            bookRepository.save(book1);

            Book book2 = new Book();
            book2.setName("Танец с Драконами");
            book2.setAuthorName("Джордж Мартин");
            book2.setCategory(fantastic);
            book2.setDescription("Пятая часть саги 'Песнь Льда и Пламени'");
            bookRepository.save(book2);

            Book book3 = new Book();
            book3.setName("Властелин колец");
            book3.setAuthorName("Р.Р. Толкиен");
            book3.setCategory(fantastic);
            book3.setDescription("Сага о похождениях Фродо");
            bookRepository.save(book3);

            Book book4 = new Book();
            book4.setName("9 Принцев Амбера");
            book4.setAuthorName("Роджер Желязны");
            book4.setCategory(fantastic);
            book4.setDescription("Первая часть саги Хроники Амбера");
            bookRepository.save(book4);

            Book book5 = new Book();
            book5.setName("Ружья Авалона");
            book5.setAuthorName("Роджер Желязны");
            book5.setCategory(fantastic);
            book5.setDescription("Вторая часть саги Хроники Амбера");
            bookRepository.save(book5);

            Book book6 = new Book();
            book6.setName("Владыка Хаоса");
            book6.setAuthorName("Роджер Желязны");
            book6.setCategory(fantastic);
            book6.setDescription("Пятая часть саги Хроники Амбера");
            bookRepository.save(book6);

            Book book7 = new Book();
            book7.setName("Стальная Крыса");
            book7.setAuthorName("Гарри Гаррисон");
            book7.setCategory(fantastic);
            book7.setDescription("Первая написанная книга о Джиме де Гризе");
            bookRepository.save(book7);

            Book book8 = new Book();
            book8.setName("Рождение Стальная Крыса");
            book8.setAuthorName("Гарри Гаррисон");
            book8.setCategory(fantastic);
            book8.setDescription("Первая по хронологии книга о Джиме де Гризе");
            bookRepository.save(book8);

            Book book9 = new Book();
            book9.setName("Последний довод Королей");
            book9.setAuthorName("Джон Аберкромби");
            book9.setCategory(fantastic);
            book9.setDescription("Цикл Кровь и Железо");
            bookRepository.save(book9);

            Book book10 = new Book();
            book10.setName("Сборник рассказов Шекли");
            book10.setAuthorName("Роберт Шекли");
            book10.setCategory(fantastic);
            book10.setDescription("Прекрасный сборник фантастических рассказов");
            bookRepository.save(book10);
        }

    }
}
