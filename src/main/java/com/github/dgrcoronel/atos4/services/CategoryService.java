package com.github.dgrcoronel.atos4.services;

import java.util.List;

import com.github.dgrcoronel.atos4.domain.Category;

public class CategoryService {

    public List<Category> listAll() {
        
        // Category cat1 = new Category(1L, "Informática");
        // Category cat2 = new Category(2L, "Escritório");

        // List<Category> lista = new ArrayList<>();
        // lista.add(cat1);
        // lista.add(cat2);

        return Category.listAll();
    }
    
    // public Category findById(Long id) {
        
    //     Optional<Category> categoryOptional = Category.findByIdOptional(id);

    //     if(categoryOptional.isEmpty()) {
    //         throw new NotFoundException("Category not found");
    //     }

    //     return Category.findById(id);
    // }

    // public Response insert(Category category) {
        
    //     category.persist();

    //     return Response.status(Status.CREATED).build();

    // }

    // public void delete(Long id) {
        
    //     Optional<Category> categoryOptional = Category.findByIdOptional(id);
        
    //     categoryOptional.ifPresentOrElse(Category::delete, () -> {
    //         throw new NotFoundException();
    //     });

    // }

    // public Response update(Category category) {
        
    //     Optional<Category> categoryOptional = Category.findByIdOptional(category.getId());
        
    //     if (categoryOptional.isEmpty()) {
    //         throw new NotFoundException("Category not found");
    //     }
    
    //     category.persist();
    //     return Response.status(Status.CREATED).build();
    // }

}
