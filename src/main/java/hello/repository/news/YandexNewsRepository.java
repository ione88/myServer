package hello.repository.news;

import org.springframework.data.repository.CrudRepository;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface YandexNewsRepository extends CrudRepository<YandexNews, Long> {

}
