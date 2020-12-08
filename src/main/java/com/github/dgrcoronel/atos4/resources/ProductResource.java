package com.github.dgrcoronel.atos4.resources;

import java.util.List;

import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.github.dgrcoronel.atos4.domain.Product;
import com.github.dgrcoronel.atos4.dto.ProductDto;

import org.eclipse.microprofile.openapi.annotations.tags.Tag;

@Path("/products")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProductResource {

    @GET
    @Tag(name = "products")
    public List<Product> listAll() {
        return Product.listAll();
        // return categoryService.listAll();
    }

    // @GET
    // @Path("/{id}")
    // @Tag(name = "products")
    // public Category findById(@PathParam("id") Long id) {
    //     // return categoryService.findById(id);
    //     Optional<Category> categoryOptional = Category.findByIdOptional(id);

    //     if(categoryOptional.isEmpty()) {
    //         throw new NotFoundException("Category not found");
    //     }

    //     return Category.findById(id);

    // }

    @POST
    @Transactional
    @Tag(name = "products")
    public Response insert(ProductDto productDto) {
        // return categoryService.insert(category);

        Product product = new Product(productDto.name, productDto.price);
        product.persist();

        return Response.status(Status.CREATED).build();
        
    }

    // @DELETE
    // @Path("/{id}")
    // @Transactional
    // @Tag(name = "products")
    // public void delete(@PathParam("id") Long id) {
    //     // categoryService.delete(id);
    //     Optional<Category> categoryOptional = Category.findByIdOptional(id);
        
    //     categoryOptional.ifPresentOrElse(Category::delete, () -> {
    //         throw new NotFoundException();
    //     });

    // }

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
