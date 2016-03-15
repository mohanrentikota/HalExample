package com.payitezy.controller;

import java.util.Collection;
import java.util.List;

import javax.annotation.Resource;
import javax.print.attribute.standard.Media;

import org.elasticsearch.common.metrics.MeanMetric;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.ExposesResourceFor;
import org.springframework.hateoas.config.EnableHypermediaSupport;
import org.springframework.hateoas.config.EnableHypermediaSupport.HypermediaType;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.social.connect.UsersConnectionRepository;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.http.MediaType;

import com.payitezy.businessdelegate.domain.IKeyBuilder;
import com.payitezy.businessdelegate.domain.SimpleIdKeyBuilder;
import com.payitezy.businessdelegate.service.IBusinessDelegate;
import com.payitezy.businessdelegate.service.UsersContext;
import com.payitezy.dao.UsersRepository;
import com.payitezy.domain.Users;
import com.payitezy.model.UsersModel;
import com.payitezy.resources.assemblers.UserResourceAssembler;
import com.payitezy.resources.hal.UsersResource;
import com.payitezy.service.*;

@RestController
@RequestMapping(value="/users")
@ExposesResourceFor(value = UsersResource.class)
@EnableHypermediaSupport(type = { HypermediaType.HAL })
public class UsersController {
	private IBusinessDelegate<UsersModel, UsersContext, IKeyBuilder<String>, String> businessDelegate;
	private ObjectFactory<SimpleIdKeyBuilder> keyBuilderFactory;
    private ObjectFactory<UsersContext> usersContextFactory;
	@Autowired
	private UsersRepository usersRepository;
	@Autowired 
	private UserResourceAssembler userResourceAssembler; 
	@Autowired
	private IUsersService usersService;
		@RequestMapping(method=RequestMethod.GET)
		public ResponseEntity<Iterable<UsersResource>> getAllUsers(){
			List<Users> users = (List<Users>) usersService.getAll();
			UsersContext usersContext = usersContextFactory.getObject();
	        usersContext.setAll("all");
			Iterable<UsersModel> usersModels = businessDelegate.getCollection(usersContext);
			 final Iterable<UsersResource> resources = userResourceAssembler.toResources(usersModels);
			return ResponseEntity.ok(resources);
		}
		@RequestMapping(method = RequestMethod.POST ,value="/create",consumes = {MediaType.ALL_VALUE})
		@ResponseBody
		public ResponseEntity<UsersResource> createUser(@RequestBody UsersModel model){
			UsersModel u = new UsersModel();
			 BeanUtils.copyProperties(model, u);
		UsersModel userModel = 	businessDelegate.create(model);
			
		UsersResource resource = userResourceAssembler.toResource(userModel);
			
			return new ResponseEntity<UsersResource>(resource,HttpStatus.CREATED);
			
		}
		
		 @Resource(name = "usersBusinessDelegate")
		    public void setBusinessDelegate(final IBusinessDelegate businessDelegate) {
		        this.businessDelegate = businessDelegate;
		    }
		 @Resource
		    public void setKeyBuilderFactory(final ObjectFactory<SimpleIdKeyBuilder> factory) {
		        keyBuilderFactory = factory;
		    }
		 @Autowired
		    public void setUsersObjectFactory(final ObjectFactory<UsersContext> usersContextFactory) {
		        this.usersContextFactory = usersContextFactory;
		    }
}
