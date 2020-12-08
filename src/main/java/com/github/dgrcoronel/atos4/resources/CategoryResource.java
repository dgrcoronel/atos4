package com.github.dgrcoronel.atos4.resources;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.github.dgrcoronel.atos4.domain.Category;
import com.github.dgrcoronel.atos4.dto.CategoryDto;

import org.eclipse.microprofile.openapi.annotations.tags.Tag;

@Path("/categories")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CategoryResource {

    @GET
    @Tag(name = "category")
    public List<Category> listAll() {
        return Category.listAll();
        // return categoryService.listAll();
    }

    @GET
    @Path("/{id}")
    @Tag(name = "category")
    public Category findById(@PathParam("id") Long id) {
        // return categoryService.findById(id);
        Optional<Category> categoryOptional = Category.findByIdOptional(id);

        if(categoryOptional.isEmpty()) {
            throw new NotFoundException("Category not found");
        }

        return Category.findById(id);

    }

    @POST
    @Transactional
    @Tag(name = "category")
    public Response insert(CategoryDto categoryDto) {
        // return categoryService.insert(category);

        Category category = new Category(categoryDto.getName());
        category.persist();

        return Response.status(Status.CREATED).build();
        
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    @Tag(name = "category")
    public void delete(@PathParam("id") Long id) {
        // categoryService.delete(id);
        Optional<Category> categoryOptional = Category.findByIdOptional(id);
        
        categoryOptional.ifPresentOrElse(Category::delete, () -> {
            throw new NotFoundException();
        });

    }

    // @POST
    // @Path("/{id}")
    // @Transactional
    // @Tag(name = "category")
    // public void update(@PathParam("id") Long id, CategoryDto categoryDto) {
        
    //     Optional<Category> categoryOptional = Category.findByIdOptional(id);
        
    //     if (categoryOptional.isEmpty()) {
    //         throw new NotFoundException("Category not found");
    //     }
    
    //     Category category = categoryOptional.get();
    //     category.persist();

    // }

}
