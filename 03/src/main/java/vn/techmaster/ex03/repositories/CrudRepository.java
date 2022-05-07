package vn.techmaster.ex03.repositories;


import java.util.List;

public interface CrudRepository<T> {
    // Save
     void save (T t);

     // Find by Id
    T findById(Long id);

    // Get all
    List<T> getList();


}
