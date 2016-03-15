package com.payitezy.resources.assemblers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityLinks;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.RelProvider;
import org.springframework.hateoas.core.EmbeddedWrapper;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import static com.payitezy.resources.hal.ResourceIdFactory.getId;

import com.payitezy.controller.UsersController;
import com.payitezy.model.UsersModel;
import com.payitezy.resources.hal.UsersResource;

@Service
public class UserResourceAssembler extends EmbeddableResourceAssemblerSupport<UsersModel, UsersResource, UsersController>{

  /* @Autowired
   private BookResourceAssembler bookResourceAssembler;*/
   
   
   @Autowired
   public UserResourceAssembler(final EntityLinks entityLinks, final RelProvider relProvider) {
      super(entityLinks, relProvider, UsersController.class, UsersResource.class);
   }

   @Override
   public Link linkToSingleResource(UsersModel usersModel) {
       return entityLinks.linkToSingleResource(UsersResource.class, getId(usersModel));
   }
   
   
   @Override
   public UsersResource toResource(UsersModel entity) {
      final UsersResource resource = createResourceWithId(entity.getId(), entity);
      // Add (multiple) links to authored books 
    
       
      return resource;
   }
   
   public UsersResource toDetailedResource(UsersModel entity) {
	   final UsersResource resource = createResourceWithId(getId(entity), entity);

	      // Add links to available actions
	      //addActionLinks(resource, entity);
	      
	      // Create the collection of embeddables of different types
	     // final List<EmbeddedWrapper> embeddables = new ArrayList<EmbeddedWrapper>();
	      // Add authors
	     // embeddables.addAll( bookResourceAssembler.toEmbeddable(entity.getBooks()) );
	     /* // Add publisher
	      embeddables.add( publisherResourceAssembler.toEmbeddable(entity.getPublisher()) );*/
	      
	     // resource.setEmbeddeds( new Resources<>(embeddables) ); // Note it must be wrapped in a Resources
	      
	      return resource;
	   }

   @Override
   protected UsersResource instantiateResource(UsersModel entity){
      return new UsersResource( entity.getId(),entity.getUserName(),  entity.getUserType(),  entity.getEmailId(),
				 entity.getPhoneNo(),  entity.getDob(),  entity.getGender(),  entity.getPassword(),
				 entity.getStatus(),  entity.getUserCode(),  entity.getAuthenticateStatus(),
				 entity.getUserCount(),  entity.getCreatedDate(),  entity.getEmailStatus(),
				 entity.getConfirmPassword(),  entity.getNewPassword(),
				 entity.getUserEmailIdStatus(),  entity.getSource());
   }
   
      
}
