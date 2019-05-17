package com.htp.controller;

import com.htp.controller.requests.UserCreateRequest;
import com.htp.domain.User;
import com.htp.repository.RoleDao;
import com.htp.repository.UserDao;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/rest/users")
public class UserController {

  @Autowired
  @Qualifier("userDaoImpl")
  private UserDao userDao;

  @GetMapping
  @ResponseStatus(HttpStatus.OK)
  public ResponseEntity<List<User>> getUsers() {
    return new ResponseEntity<>(userDao.findAll(), HttpStatus.OK);
  }

  @GetMapping("/all")
  @ResponseStatus(HttpStatus.OK)
  public ResponseEntity<List<User>> getUsersHibernate() {
    return new ResponseEntity<>(userDao.findAll(), HttpStatus.OK);
  }

  @ApiOperation(value = "Get user from server by id")
  @ApiResponses({
    @ApiResponse(code = 200, message = "Successful getting user"),
    @ApiResponse(code = 400, message = "Invalid User ID supplied"),
    @ApiResponse(code = 401, message = "Lol kek"),
    @ApiResponse(code = 404, message = "User was not found"),
    @ApiResponse(code = 500, message = "Server error, something wrong")
  })
  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
  public ResponseEntity<User> getUserById(@ApiParam("User Path Id") @PathVariable Long id) {
    User user = userDao.findById(id);
    return new ResponseEntity<>(user, HttpStatus.OK);
  }

  @Autowired
  @Qualifier("roleDaoImpl")
  private RoleDao roleDao;

  /**/
  @PostMapping
  @Transactional
  @ResponseStatus(HttpStatus.CREATED)
  public ResponseEntity<User> createUser(@RequestBody UserCreateRequest request) {
    //        User user = new User();
    //        //userID is empty - will be generated by DB
    //        user.setUserName(request.getUserName());
    //        user.setUserSurname(request.getUserSurname());
    //        user.setBirthDate(new Timestamp(new Date().getTime()));
    //        user.setDepartmentId(1l); //f*cking trash
    //
    //        User savedUser = userDao.save(user);
    //        roleDao.save(new Role(savedUser.getUserId(), "ROLE_USER"));
    //
    //        return new ResponseEntity<>(savedUser, HttpStatus.OK);
    return null;
  }

  @PostMapping("/test")
  @Transactional
  @ResponseStatus(HttpStatus.CREATED)
  public ResponseEntity<User> createTestUser(@RequestBody UserCreateRequest request) {
    //        TestUser user = new TestUser();
    //        //userID is empty - will be generated by DB
    //        user.setUserName(request.getUserName());
    //        user.setUserSurname(request.getUserSurname());
    //        user.setBirthDate(new Timestamp(new Date().getTime()));

    //        return new ResponseEntity<>(hibernateUserDao.save(user), HttpStatus.OK);
    return null;
  }
  //
  //    @ApiOperation(value = "Update user by userID")
  //    @ApiResponses({
  //            @ApiResponse(code = 200, message = "Successful user update"),
  //            @ApiResponse(code = 400, message = "Invalid User ID supplied"),
  //            @ApiResponse(code = 404, message = "User was not found"),
  //            @ApiResponse(code = 500, message = "Server error, something wrong")
  //    })
  //    @ApiImplicitParams({
  //            @ApiImplicitParam(name = "X-Auth-Token", value = "token", required = true, dataType
  // = "string", paramType = "header")
  //    })
  //    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
  //    @ResponseStatus(HttpStatus.OK)
  //    public ResponseEntity<User> updateUser(@PathVariable("id") Long userId,
  //                                           @RequestBody UserCreateRequest request) {
  //        User user = userDao.findById(userId);
  //        user.setUserName(request.getUserName());
  //        user.setUserSurname(request.getUserSurname());
  //        user.setBirthDate(new Timestamp(new Date().getTime()));
  //        user.setDepartmentId(1L);
  //
  //        return new ResponseEntity<>(user, HttpStatus.OK);
  //    }
  //
  //    @ApiOperation(value = "Update user by userID")
  //    @ApiResponses({
  //            @ApiResponse(code = 200, message = "Successful user update"),
  //            @ApiResponse(code = 400, message = "Invalid User ID supplied"),
  //            @ApiResponse(code = 404, message = "User was not found"),
  //            @ApiResponse(code = 500, message = "Server error, something wrong")
  //    })
  //    @RequestMapping(value = "/test/{id}", method = RequestMethod.PUT)
  //    @ResponseStatus(HttpStatus.OK)
  //    public ResponseEntity<TestUser> updateTestUser(@ApiParam(value = "User ID", required =
  // false) @PathVariable("id") Long userId,
  //                                                   @RequestBody UserCreateRequest request) {
  //
  //        hibernateUserDao.findById(userId);
  //
  //        TestUser user = new TestUser();
  //        //userID is empty - will be generated by DB
  //        user.setUserId(null);
  //        user.setUserName(request.getUserName());
  //        user.setUserSurname(request.getUserSurname());
  //        user.setBirthDate(new Timestamp(new Date().getTime()));
  //
  //        return new ResponseEntity<>(hibernateUserDao.update(user), HttpStatus.OK);
  //    }
  //
  //    @ApiOperation(value = "Search user by query")
  //    @ApiResponses({
  //            @ApiResponse(code = 200, message = "Successful user update"), //OK
  //            @ApiResponse(code = 400, message = "Invalid query supplied"), //Invalid request
  //            @ApiResponse(code = 404, message = "User was not found"), //Resourse not found
  //            @ApiResponse(code = 500, message = "Server error, something wrong")
  //    })
  //    @ApiImplicitParams({
  //            @ApiImplicitParam(name = "limit", value = "limit of users", required = true,
  // dataType = "int", paramType = "query"),
  //            @ApiImplicitParam(name = "offset", value = "start node of users", required = true,
  // dataType = "int", paramType = "query"),
  //            @ApiImplicitParam(name = "query", value = "search query", required = true, dataType
  // = "string", paramType = "query"),
  //            @ApiImplicitParam(name = "X-Auth-Token", value = "token", required = true, dataType
  // = "string", paramType = "header")
  //    })
  //    @GetMapping("/search")
  //    @ResponseStatus(HttpStatus.OK)
  //    public ResponseEntity<List<User>> searchUsers(@ApiIgnore @ModelAttribute SearchCriteria
  // search) {
  //        List<User> searchResult =
  //                userDao.search(
  //                        search.getQuery(),
  //                        search.getLimit(),
  //                        search.getOffset()
  //                );
  //        return new ResponseEntity<>(searchResult, HttpStatus.OK);
  //    }

  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public ResponseEntity<Long> deleteUser(@PathVariable("id") Long userId) {
    userDao.delete(userId);
    return new ResponseEntity<>(userId, HttpStatus.OK);
  }
}
