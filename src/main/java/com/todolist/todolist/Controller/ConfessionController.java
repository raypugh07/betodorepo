package com.todolist.todolist.Controller;


import com.todolist.todolist.Model.Confession;
import com.todolist.todolist.Service.ConfessionService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;

@RestController
@RequestMapping(value="/confessions")
public class ConfessionController {

    @Autowired
    private ConfessionService confessionService;

    @ApiOperation(value = "Return all Confessions", response = Confession.class, responseContainer = "List")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", dataType = "integr", paramType = "query",
                    value = "Results page you want to retrieve (0..N)"),
            @ApiImplicitParam(name = "size", dataType = "integer", paramType = "query",
                    value = "Number of records per page."),
            @ApiImplicitParam(name = "sort", allowMultiple = true, dataType = "string", paramType = "query",
                    value = "Sorting criteria in the format: property(,asc|desc). " +
                            "Default sort order is ascending. " +
                            "Multiple sort criteria are supported.")})

    @GetMapping(value = "/confessions", produces = {"application/json"})
    public ResponseEntity<?> listAllConfessions(Pageable pageable){
        return new ResponseEntity<>(confessionService.findAll(pageable), HttpStatus.OK);
    }

    @PostMapping(value = "/confessions",
            consumes = {"application/json"},
            produces = {"application/json"})
    public ResponseEntity<?> addNewConfesions(@Valid
                                          @RequestBody
                                                  Confession newConfession) throws URISyntaxException
    {
        newConfession = confessionService.save(newConfession);

        // set the location header for the newly created resource
        HttpHeaders responseHeaders = new HttpHeaders();
        URI newStudentURI = ServletUriComponentsBuilder.fromCurrentRequest().path("/{confessionid}").buildAndExpand(newConfession.getConfessionid()).toUri();
        responseHeaders.setLocation(newStudentURI);

        return new ResponseEntity<>(null, responseHeaders, HttpStatus.CREATED);
    }

}