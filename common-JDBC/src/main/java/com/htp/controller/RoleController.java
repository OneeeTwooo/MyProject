package com.htp.controller;


import com.htp.controller.requests.RoleCreateRequest;
import com.htp.domain.Role;
import com.htp.repository.RoleDao;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/rest/roles")
public class RoleController {
    @Autowired
    private RoleDao roleDao;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<Role>> getRoles() {
        return new ResponseEntity<>(roleDao.findAll(), HttpStatus.OK);
    }

    @PostMapping
    @Transactional
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Role> createRole(@RequestBody RoleCreateRequest request) {
        Role role = new Role();
        //roleId is empty - will be generated by DB
        role.setNameRole(request.getNameRole());
        role.setRoleType(request.getRoleType());

        Role savedRole = roleDao.save(role);

        return new ResponseEntity<>(savedRole, HttpStatus.OK);
    }

    @ApiOperation(value = "Get role from server by id")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Successful getting role"),
            @ApiResponse(code = 400, message = "Invalid Role ID supplied"),
            @ApiResponse(code = 401, message = "Lol kek"),
            @ApiResponse(code = 404, message = "Role was not found"),
            @ApiResponse(code = 500, message = "Server error, something wrong")
    })
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Role> getRoleById(@ApiParam("Role Id") @PathVariable Long id) {
        Role role = roleDao.findById(id);
        return new ResponseEntity<>(role, HttpStatus.OK);
    }

    @ApiOperation(value = "Update role by roleID")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Successful role update"),
            @ApiResponse(code = 400, message = "Invalid Role ID supplied"),
            @ApiResponse(code = 404, message = "Role was not found"),
            @ApiResponse(code = 500, message = "Server error, something wrong")
    })
    @ApiImplicitParams({
            @ApiImplicitParam(name = "X-Auth-Token", value = "token", required = true, dataType = "string", paramType = "header")
    })
    //TODO: FOR WHAT THIS?
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Role> updateRole(@PathVariable("id") Long roleId,
                                           @RequestBody RoleCreateRequest request) {
        Role role = roleDao.findById(roleId);
        role.setNameRole(request.getNameRole());
        role.setRoleType(request.getRoleType());

        roleDao.update(role);

        return new ResponseEntity<>(role, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Long> deleteRole(@PathVariable("id") Long roleId) {
        roleDao.delete(roleId);
        return new ResponseEntity<>(roleId, HttpStatus.OK);
    }

}
